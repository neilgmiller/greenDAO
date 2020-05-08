package org.greenrobot.greendao.codemodifier;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.greenrobot.eclipse.jdt.core.dom.AST;
import org.greenrobot.eclipse.jdt.core.dom.ASTNode;
import org.greenrobot.eclipse.jdt.core.dom.BodyDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit;
import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ImportDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.greenrobot.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.greenrobot.eclipse.jface.text.Document;
import org.greenrobot.eclipse.jface.text.IDocument;
import org.greenrobot.eclipse.text.edits.TextEdit;
import org.greenrobot.eclipse.text.edits.TextEditGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010$\u001a\u00020%J\"\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060*J\"\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006J5\u00100\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00062\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000601\"\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060*¢\u0006\u0002\u00102J5\u00103\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00062\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000601\"\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060*¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020%J\u000e\u00105\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0006J\u001c\u00106\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0016H\u0002J$\u00108\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0002J$\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010\u00162\b\u0010A\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u0010B\u001a\u00020%J\b\u0010C\u001a\u0004\u0018\u00010\u0006J\u0010\u0010D\u001a\u00020%*\u0006\u0012\u0002\b\u00030EH\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\u0006*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006F"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "", "parsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "jdtOptions", "Ljava/util/Hashtable;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "charset", "Ljava/nio/charset/Charset;", "(Lorg/greenrobot/greendao/codemodifier/ParsedEntity;Ljava/util/Hashtable;Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/nio/charset/Charset;)V", "addedImports", "", "astRewrite", "Lorg/greenrobot/eclipse/jdt/core/dom/rewrite/ASTRewrite;", "kotlin.jvm.PlatformType", "bodyRewrite", "Lorg/greenrobot/eclipse/jdt/core/dom/rewrite/ListRewrite;", "getCharset", "()Ljava/nio/charset/Charset;", "cu", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "formatter", "Lorg/greenrobot/greendao/codemodifier/Formatter;", "formatting", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "importsRewrite", "getJdtOptions", "()Ljava/util/Hashtable;", "keepNodes", "getParsedEntity", "()Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "sourceLine", "getSourceLine", "(Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;)Ljava/lang/String;", "annotateLegacyKeepFields", "", "defConstructor", "paramTypes", "", "code", "Lkotlin/Function0;", "defField", "name", "type", "Lorg/greenrobot/greendao/codemodifier/VariableType;", "comment", "defMethod", "", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "defMethodIfMissing", "ensureDefaultConstructor", "ensureImport", "insertField", "replaceOld", "insertMethod", "insertAfter", "remove", "node", "replaceHashStub", "source", "replaceNode", "newNode", "oldNode", "orInsertAfter", "writeToFile", "writeToString", "checkKeepPresent", "Lorg/greenrobot/greendao/codemodifier/Generatable;", "greendao-code-modifier_main"}
)
public final class EntityClassTransformer {
   private final ASTNode cu;
   private final Formatting formatting;
   private final Formatter formatter;
   private final ASTRewrite astRewrite;
   private final ListRewrite importsRewrite;
   private final ListRewrite bodyRewrite;
   private final Set keepNodes;
   private final Set addedImports;
   @NotNull
   private final ParsedEntity parsedEntity;
   @NotNull
   private final Hashtable jdtOptions;
   @NotNull
   private final Charset charset;

   public final void ensureImport(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      String packageName = StringsKt.substringBeforeLast(name, '.', "");
      String maybeInnerClassName = StringsKt.substringAfterLast(packageName, ".", "");
      if (Intrinsics.areEqual(packageName, this.parsedEntity.getPackageName()) ^ true && Intrinsics.areEqual(maybeInnerClassName, this.parsedEntity.getName()) ^ true && !JdtUtilsKt.has((Iterable)this.parsedEntity.getImports(), name) && !this.addedImports.contains(name)) {
         ImportDeclaration id = this.cu.getAST().newImportDeclaration();
         AST var10001 = this.cu.getAST();
         Collection $receiver$iv = (Collection)StringsKt.split$default((CharSequence)name, new char[]{'.'}, false, 0, 6, (Object)null);
         AST var9 = var10001;
         if ($receiver$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.util.Collection<T>");
         }

         Collection thisCollection$iv = (Collection)$receiver$iv;
         Object[] var10000 = thisCollection$iv.toArray(new String[thisCollection$iv.size()]);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
         }

         Object[] var10 = (Object[])var10000;
         id.setName(var9.newName((String[])var10));
         this.importsRewrite.insertLast((ASTNode)id, (TextEditGroup)null);
         $receiver$iv = (Collection)this.addedImports;
         $receiver$iv.add(name);
      }

   }

   public final void remove(@NotNull ASTNode node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      this.bodyRewrite.remove(node, (TextEditGroup)null);
   }

   private final void insertMethod(String code, ASTNode replaceOld, ASTNode insertAfter) {
      if (replaceOld != null && CodeCompare.INSTANCE.isSameCode(replaceOld, code)) {
         Collection var6 = (Collection)this.keepNodes;
         var6.add(replaceOld);
      } else {
         String formatted = this.formatter.format(code);
         ASTNode newMethod = this.astRewrite.createStringPlaceholder(formatted, TypeDeclaration.METHOD_DECLARATION);
         Intrinsics.checkExpressionValueIsNotNull(newMethod, "newMethod");
         this.replaceNode(newMethod, replaceOld, insertAfter);
      }

   }

   private final void insertField(String code, ASTNode replaceOld) {
      if (replaceOld != null && CodeCompare.INSTANCE.isSameCode(replaceOld, code)) {
         Collection var5 = (Collection)this.keepNodes;
         var5.add(replaceOld);
      } else {
         String formatted = this.formatter.format(code);
         ASTNode newField = this.astRewrite.createStringPlaceholder(formatted, TypeDeclaration.FIELD_DECLARATION);
         Intrinsics.checkExpressionValueIsNotNull(newField, "newField");
         this.replaceNode(newField, replaceOld, (ASTNode)this.parsedEntity.getLastFieldDeclaration());
      }

   }

   private final void replaceNode(ASTNode newNode, ASTNode oldNode, ASTNode orInsertAfter) {
      if (oldNode != null) {
         this.bodyRewrite.insertAfter(newNode, oldNode, (TextEditGroup)null);
         this.remove(oldNode);
      } else if (orInsertAfter != null) {
         this.bodyRewrite.insertAfter(newNode, orInsertAfter, (TextEditGroup)null);
      } else {
         this.bodyRewrite.insertLast(newNode, (TextEditGroup)null);
      }

   }

   private final String getSourceLine(@NotNull ASTNode $receiver) {
      return this.parsedEntity.getSourceFile().getPath() + ":" + JdtUtilsKt.getLineNumber($receiver);
   }

   private final void checkKeepPresent(@NotNull Generatable $receiver) {
      BodyDeclaration node = $receiver.getNode();
      String place = node instanceof MethodDeclaration ? (((MethodDeclaration)node).isConstructor() ? "constructor" : "method") : (node instanceof FieldDeclaration ? "field" : "declaration");
      GeneratorHint var4 = $receiver.getHint();
      if (Intrinsics.areEqual(var4, GeneratorHint.Keep.INSTANCE)) {
         String var5 = "Keep " + place + " in " + this.getSourceLine((ASTNode)node);
         System.out.println(var5);
      } else if (Intrinsics.areEqual(var4, (Object)null)) {
         throw (Throwable)(new RuntimeException(StringsKt.trimIndent("Can't replace " + place + " in " + this.getSourceLine((ASTNode)node) + " with generated version." + "\n" + "                    If you would like to keep it, it should be explicitly marked with @Keep annotation." + "\n" + "                    Otherwise please mark it with @Generated annotation")));
      }

   }

   public final void defConstructor(@NotNull List paramTypes, @NotNull Function0 code) {
      Intrinsics.checkParameterIsNotNull(paramTypes, "paramTypes");
      Intrinsics.checkParameterIsNotNull(code, "code");
      Iterable var4 = (Iterable)this.parsedEntity.getConstructors();
      Iterator var6 = var4.iterator();

      Object var10000;
      while(true) {
         if (var6.hasNext()) {
            Object var7 = var6.next();
            Method it = (Method)var7;
            if (!it.hasSignature(this.parsedEntity.getName(), paramTypes)) {
               continue;
            }

            var10000 = var7;
            break;
         }

         var10000 = null;
         break;
      }

      Method matchingConstructor = (Method)var10000;
      String var10001;
      ASTNode var10002;
      MethodDeclaration var10003;
      if (matchingConstructor != null) {
         if (matchingConstructor.getGenerated()) {
            var10001 = this.replaceHashStub((String)code.invoke());
            var10002 = (ASTNode)matchingConstructor.getNode();
            var10003 = this.parsedEntity.getLastConstructorDeclaration();
            this.insertMethod(var10001, var10002, var10003 != null ? (ASTNode)var10003 : (ASTNode)this.parsedEntity.getLastFieldDeclaration());
         } else {
            this.checkKeepPresent((Generatable)matchingConstructor);
         }
      } else {
         Iterable var5 = (Iterable)this.parsedEntity.getConstructors();
         Iterator var14 = var5.iterator();

         while(true) {
            if (!var14.hasNext()) {
               var10000 = null;
               break;
            }

            Object var16 = var14.next();
            Method it = (Method)var16;
            if (it.getGenerated()) {
               var10000 = var16;
               break;
            }
         }

         Method generatedConstructor = (Method)var10000;
         if (generatedConstructor != null) {
            MethodDeclaration nodeToReplace;
            if (!generatedConstructor.getParameters().isEmpty() && !paramTypes.isEmpty()) {
               nodeToReplace = generatedConstructor.getNode();
            } else {
               Collection var13 = (Collection)this.keepNodes;
               MethodDeclaration var15 = generatedConstructor.getNode();
               var13.add(var15);
               nodeToReplace = (MethodDeclaration)null;
            }

            var10001 = this.replaceHashStub((String)code.invoke());
            var10002 = (ASTNode)nodeToReplace;
            var10003 = this.parsedEntity.getLastConstructorDeclaration();
            this.insertMethod(var10001, var10002, var10003 != null ? (ASTNode)var10003 : (ASTNode)this.parsedEntity.getLastFieldDeclaration());
         } else {
            var10001 = this.replaceHashStub((String)code.invoke());
            var10003 = this.parsedEntity.getLastConstructorDeclaration();
            this.insertMethod(var10001, (ASTNode)null, var10003 != null ? (ASTNode)var10003 : (ASTNode)this.parsedEntity.getLastFieldDeclaration());
         }
      }

   }

   public final void ensureDefaultConstructor() {
      Iterable var2 = (Iterable)this.parsedEntity.getConstructors();
      Iterator var4 = var2.iterator();

      Object var10000;
      while(true) {
         if (var4.hasNext()) {
            Object var5 = var4.next();
            Method it = (Method)var5;
            if (!it.getParameters().isEmpty()) {
               continue;
            }

            var10000 = var5;
            break;
         }

         var10000 = null;
         break;
      }

      Method defaultConstructor = (Method)var10000;
      if (defaultConstructor != null && !defaultConstructor.getGenerated()) {
         Collection var9 = (Collection)this.keepNodes;
         MethodDeclaration var3 = defaultConstructor.getNode();
         var9.add(var3);
      } else {
         String defaultConstructorCode = "public " + this.parsedEntity.getName() + "() {" + "\n" + "                    }";
         ASTNode var10002 = (ASTNode)(defaultConstructor != null ? defaultConstructor.getNode() : null);
         MethodDeclaration var10003 = this.parsedEntity.getLastConstructorDeclaration();
         this.insertMethod(defaultConstructorCode, var10002, var10003 != null ? (ASTNode)var10003 : (ASTNode)this.parsedEntity.getLastFieldDeclaration());
      }

   }

   public final void defMethod(@NotNull String name, @NotNull String[] paramTypes, @NotNull Function0 code) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(paramTypes, "paramTypes");
      Intrinsics.checkParameterIsNotNull(code, "code");
      Iterable $receiver$iv = (Iterable)this.parsedEntity.getMethods();
      Iterator var7 = $receiver$iv.iterator();

      Object var10000;
      while(true) {
         if (var7.hasNext()) {
            Object var8 = var7.next();
            Method it = (Method)var8;
            if (!it.hasSignature(name, ArraysKt.toList((Object[])paramTypes))) {
               continue;
            }

            var10000 = var8;
            break;
         }

         var10000 = null;
         break;
      }

      Method method = (Method)var10000;
      if (method != null && !method.getGenerated()) {
         this.checkKeepPresent((Generatable)method);
      } else {
         Object[] $receiver$iv = (Object[])paramTypes;
         Object[] $receiver$iv$iv = $receiver$iv;
         Collection destination$iv$iv = (Collection)(new ArrayList());

         for(int var18 = 0; var18 < $receiver$iv$iv.length; ++var18) {
            Object element$iv$iv = $receiver$iv$iv[var18];
            String it = (String)element$iv$iv;
            if (StringsKt.contains$default((CharSequence)it, '.', false, 2, (Object)null)) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         $receiver$iv = (Iterable)((List)destination$iv$iv);
         Iterator var15 = $receiver$iv.iterator();

         while(var15.hasNext()) {
            Object element$iv = var15.next();
            String it = (String)element$iv;
            this.ensureImport(it);
         }

         String var10001 = this.replaceHashStub((String)code.invoke());
         ASTNode var10002 = (ASTNode)(method != null ? method.getNode() : null);
         MethodDeclaration var10003 = this.parsedEntity.getLastMethodDeclaration();
         ASTNode var21 = var10003 != null ? (ASTNode)var10003 : (ASTNode)this.parsedEntity.getLastConstructorDeclaration();
         if (var21 == null) {
            var21 = (ASTNode)this.parsedEntity.getLastFieldDeclaration();
         }

         this.insertMethod(var10001, var10002, var21);
      }

   }

   public final void defMethodIfMissing(@NotNull String name, @NotNull String[] paramTypes, @NotNull Function0 code) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(paramTypes, "paramTypes");
      Intrinsics.checkParameterIsNotNull(code, "code");
      Iterable $receiver$iv = (Iterable)this.parsedEntity.getMethods();
      Iterator var7 = $receiver$iv.iterator();

      Object var10000;
      while(true) {
         if (var7.hasNext()) {
            Object var8 = var7.next();
            Method it = (Method)var8;
            if (!it.hasSignature(name, ArraysKt.toList((Object[])paramTypes))) {
               continue;
            }

            var10000 = var8;
            break;
         }

         var10000 = null;
         break;
      }

      Method method = (Method)var10000;
      if (method == null) {
         Object[] $receiver$iv = (Object[])paramTypes;
         Object[] $receiver$iv$iv = $receiver$iv;
         Collection destination$iv$iv = (Collection)(new ArrayList());

         for(int var18 = 0; var18 < $receiver$iv$iv.length; ++var18) {
            Object element$iv$iv = $receiver$iv$iv[var18];
            String it = (String)element$iv$iv;
            if (StringsKt.contains$default((CharSequence)it, '.', false, 2, (Object)null)) {
               destination$iv$iv.add(element$iv$iv);
            }
         }

         $receiver$iv = (Iterable)((List)destination$iv$iv);
         Iterator var15 = $receiver$iv.iterator();

         while(var15.hasNext()) {
            Object element$iv = var15.next();
            String it = (String)element$iv;
            this.ensureImport(it);
         }

         String var10001 = (String)code.invoke();
         MethodDeclaration var10003 = this.parsedEntity.getLastMethodDeclaration();
         ASTNode var21 = var10003 != null ? (ASTNode)var10003 : (ASTNode)this.parsedEntity.getLastConstructorDeclaration();
         if (var21 == null) {
            var21 = (ASTNode)this.parsedEntity.getLastFieldDeclaration();
         }

         this.insertMethod(var10001, (ASTNode)null, var21);
      }

   }

   public final void defField(@NotNull String name, @NotNull VariableType type, @Nullable String comment) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(type, "type");
      Iterable var5 = (Iterable)this.parsedEntity.getTransientFields();
      Iterator var7 = var5.iterator();

      Object var10000;
      while(true) {
         if (var7.hasNext()) {
            Object var8 = var7.next();
            TransientField it = (TransientField)var8;
            if (!Intrinsics.areEqual(it.getVariable().getName(), name)) {
               continue;
            }

            var10000 = var8;
            break;
         }

         var10000 = null;
         break;
      }

      TransientField field = (TransientField)var10000;
      if (field != null && !field.getGenerated()) {
         this.checkKeepPresent((Generatable)field);
      } else {
         if (!type.isPrimitive() && Intrinsics.areEqual(type.getName(), type.getSimpleName()) ^ true) {
            this.ensureImport(type.getName());
         }

         this.insertField(this.replaceHashStub((comment != null ? "/** " + comment + " */" + "\n" : "") + "@Generated(hash = " + EntityClassTransformerKt.getHASH_STUB() + ")" + "\n" + "private transient " + type.getSimpleName() + " " + name + ";"), (ASTNode)(field != null ? field.getNode() : null));
      }

   }

   public final void annotateLegacyKeepFields() {
      if (!this.parsedEntity.getLegacyTransientFields().isEmpty()) {
         this.ensureImport("org.greenrobot.greendao.annotation.Transient");
         Iterable $receiver$iv = (Iterable)this.parsedEntity.getLegacyTransientFields();
         Iterator var2 = $receiver$iv.iterator();

         while(var2.hasNext()) {
            Object element$iv = var2.next();
            TransientField it = (TransientField)element$iv;
            this.insertField("@Transient" + "\n" + "                       private " + it.getVariable().getType().getSimpleName() + " " + it.getVariable().getName() + ";", (ASTNode)it.getNode());
         }

      }
   }

   private final String replaceHashStub(String source) {
      int hash = CodeCompare.INSTANCE.codeHash(source);
      return StringsKt.replace$default(source, EntityClassTransformerKt.getHASH_STUB(), String.valueOf(hash), false, 4, (Object)null);
   }

   public final void writeToFile() {
      String newSource = this.writeToString();
      String var2;
      if (newSource != null) {
         var2 = "Change " + this.parsedEntity.getSourceFile().getPath();
         System.out.println(var2);
         FilesKt.writeText(this.parsedEntity.getSourceFile(), newSource, this.charset);
      } else {
         var2 = "Skip " + this.parsedEntity.getSourceFile().getPath();
         System.out.println(var2);
      }

   }

   @Nullable
   public final String writeToString() {
      <undefinedtype> removeUnneeded$ = new Function1() {
         public final void invoke(@NotNull Iterable $receiver) {
            Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
            Sequence $receiver$iv = SequencesKt.filter(CollectionsKt.asSequence($receiver), (Function1)(new Function1() {
               public final boolean invoke(@NotNull Generatable it) {
                  Intrinsics.checkParameterIsNotNull(it, "it");
                  return it.getGenerated() && EntityClassTransformer.this.keepNodes.contains(it.getNode()) ^ true;
               }
            }));
            Iterator var3 = $receiver$iv.iterator();

            while(var3.hasNext()) {
               Object element$iv = var3.next();
               Generatable it = (Generatable)element$iv;
               EntityClassTransformer.this.remove((ASTNode)it.getNode());
            }

         }
      };
      ParsedEntity var2 = this.parsedEntity;
      ParsedEntity $receiver = (ParsedEntity)var2;
      removeUnneeded$.invoke((Iterable)$receiver.getConstructors());
      removeUnneeded$.invoke((Iterable)$receiver.getMethods());
      removeUnneeded$.invoke((Iterable)$receiver.getTransientFields());
      Document document = new Document(this.parsedEntity.getSource());
      TextEdit edits = this.astRewrite.rewriteAST((IDocument)document, (Map)this.jdtOptions);
      edits.apply((IDocument)document);
      String newSource = document.get();
      return Intrinsics.areEqual(newSource, this.parsedEntity.getSource()) ^ true ? newSource : null;
   }

   @NotNull
   public final ParsedEntity getParsedEntity() {
      return this.parsedEntity;
   }

   @NotNull
   public final Hashtable getJdtOptions() {
      return this.jdtOptions;
   }

   @NotNull
   public final Charset getCharset() {
      return this.charset;
   }

   public EntityClassTransformer(@NotNull ParsedEntity parsedEntity, @NotNull Hashtable jdtOptions, @Nullable FormattingOptions formattingOptions, @NotNull Charset charset) {
      Formatting var10001;
      label17: {
         Intrinsics.checkParameterIsNotNull(parsedEntity, "parsedEntity");
         Intrinsics.checkParameterIsNotNull(jdtOptions, "jdtOptions");
         Intrinsics.checkParameterIsNotNull(charset, "charset");
         super();
         this.parsedEntity = parsedEntity;
         this.jdtOptions = jdtOptions;
         this.charset = charset;
         this.cu = this.parsedEntity.getNode().getRoot();
         if (formattingOptions != null) {
            var10001 = formattingOptions.toFormatting();
            if (var10001 != null) {
               break label17;
            }
         }

         var10001 = Formatting.Companion.detect(this.parsedEntity.getSource(), formattingOptions);
      }

      this.formatting = var10001;
      this.formatter = new Formatter(this.formatting);
      this.astRewrite = ASTRewrite.create(this.cu.getAST());
      this.importsRewrite = this.astRewrite.getListRewrite(this.cu, CompilationUnit.IMPORTS_PROPERTY);
      this.bodyRewrite = this.astRewrite.getListRewrite((ASTNode)this.parsedEntity.getNode(), TypeDeclaration.BODY_DECLARATIONS_PROPERTY);
      Set var7 = (Set)(new LinkedHashSet());
      this.keepNodes = var7;
      var7 = (Set)(new LinkedHashSet());
      this.addedImports = var7;
      Tabulation tabulation = this.formatting.getTabulation();
      this.jdtOptions.put("org.greenrobot.eclipse.jdt.core.formatter.tabulation.char", tabulation.getTabChar() == ' ' ? "space" : "tab");
      this.jdtOptions.put("org.greenrobot.eclipse.jdt.core.formatter.tabulation.size", String.valueOf(tabulation.getSize()));
   }

   // $FF: synthetic method
   public EntityClassTransformer(ParsedEntity var1, Hashtable var2, FormattingOptions var3, Charset var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = Charsets.UTF_8;
      }

      this(var1, var2, var3, var4);
   }
}
