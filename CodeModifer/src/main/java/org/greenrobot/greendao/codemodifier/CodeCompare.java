package org.greenrobot.greendao.codemodifier;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.greenrobot.eclipse.jdt.core.dom.ASTNode;
import org.greenrobot.essentials.hash.Murmur3F;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/CodeCompare;", "", "()V", "murmur", "Lorg/greenrobot/essentials/hash/Murmur3F;", "regexGeneratedAnnotation", "Lkotlin/text/Regex;", "regexJavaCommentMl", "regexJavaCommentSl", "regexTooManySpaces", "regexUselessSpaces", "codeHash", "", "code", "", "isSameCode", "", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "unformatCode", "greendao-code-modifier_main"}
)
public final class CodeCompare {
   private static final Regex regexTooManySpaces;
   private static final Regex regexUselessSpaces;
   private static final Regex regexJavaCommentMl;
   private static final Regex regexJavaCommentSl;
   private static final Regex regexGeneratedAnnotation;
   private static final Murmur3F murmur;
   public static final CodeCompare INSTANCE;

   @NotNull
   public final String unformatCode(@NotNull String code) {
      Intrinsics.checkParameterIsNotNull(code, "code");
      CharSequence var2 = (CharSequence)code;
      Regex var3 = regexJavaCommentSl;
      String var4 = "/*$1*/";
      var2 = (CharSequence)var3.replace(var2, var4);
      var3 = regexJavaCommentMl;
      Function1 var6 = (Function1)null.INSTANCE;
      var2 = (CharSequence)var3.replace(var2, var6);
      var3 = regexTooManySpaces;
      var4 = " ";
      var2 = (CharSequence)var3.replace(var2, var4);
      var3 = regexUselessSpaces;
      var4 = "$1";
      String var5 = var3.replace(var2, var4);
      if (var5 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
      } else {
         return StringsKt.trim((CharSequence)var5).toString();
      }
   }

   public final int codeHash(@NotNull String code) {
      Intrinsics.checkParameterIsNotNull(code, "code");
      murmur.reset();
      CharSequence var3 = (CharSequence)code;
      Regex var4 = regexGeneratedAnnotation;
      String var5 = "";
      String var8 = var4.replace(var3, var5);
      String unformattedCode = this.unformatCode(var8);
      Charset var10 = null;
      boolean var11 = true;
      Object var6 = null;
      Murmur3F var7 = murmur;
      if (var11 & true) {
         var10 = Charsets.UTF_8;
      }

      if (unformattedCode == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         byte[] var10000 = ((String)unformattedCode).getBytes(var10);
         Intrinsics.checkExpressionValueIsNotNull(var10000, "(this as java.lang.String).getBytes(charset)");
         byte[] var12 = var10000;
         var7.update(var12);
         int intHash = (int)murmur.getValue();
         return intHash << 1 >>> 1;
      }
   }

   public final boolean isSameCode(@NotNull ASTNode node, @NotNull String code) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      Intrinsics.checkParameterIsNotNull(code, "code");
      CodeCompare var10000 = INSTANCE;
      String var10001 = node.toString();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "node.toString()");
      String nodeCode = var10000.unformatCode(var10001);
      String unformattedCode = INSTANCE.unformatCode(code);
      return Intrinsics.areEqual(nodeCode, unformattedCode);
   }

   private CodeCompare() {
      INSTANCE = (CodeCompare)this;
      regexTooManySpaces = new Regex("[ \\n\\t\\r]+");
      regexUselessSpaces = new Regex("\\s?(\\W)\\s?");
      regexJavaCommentMl = new Regex("/\\*([^\\*]|\\*(?!/))*?\\*/");
      regexJavaCommentSl = new Regex("//(.*)$");
      regexGeneratedAnnotation = new Regex("@(org.greenrobot.greendao.annotation.)?Generated[(][^)]+[)]");
      murmur = new Murmur3F();
   }

   static {
      new CodeCompare();
   }
}
