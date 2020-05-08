package org.greenrobot.greendao.codemodifier;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eclipse.jdt.core.JavaCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "encoding", "", "(Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/lang/String;)V", "classParser", "Lorg/greenrobot/greendao/codemodifier/EntityClassParser;", "getFormattingOptions", "()Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "jdtOptions", "Ljava/util/Hashtable;", "parse", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "javaFile", "Ljava/io/File;", "classesInPackage", "", "transformer", "Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "parsedEntity", "Companion", "greendao-code-modifier_main"}
)
public final class JdtCodeContext {
   private final Hashtable jdtOptions;
   private final EntityClassParser classParser;
   @Nullable
   private final FormattingOptions formattingOptions;
   @NotNull
   private static final String JAVA_LEVEL = "1.7";
   public static final JdtCodeContext.Companion Companion = new JdtCodeContext.Companion((DefaultConstructorMarker)null);

   @Nullable
   public final ParsedEntity parse(@NotNull File javaFile, @NotNull List classesInPackage) {
      Intrinsics.checkParameterIsNotNull(javaFile, "javaFile");
      Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage");
      return this.classParser.parse(javaFile, classesInPackage);
   }

   @NotNull
   public final EntityClassTransformer transformer(@NotNull ParsedEntity parsedEntity) {
      Intrinsics.checkParameterIsNotNull(parsedEntity, "parsedEntity");
      return new EntityClassTransformer(parsedEntity, this.jdtOptions, this.formattingOptions, (Charset)null, 8, (DefaultConstructorMarker)null);
   }

   @Nullable
   public final FormattingOptions getFormattingOptions() {
      return this.formattingOptions;
   }

   public JdtCodeContext(@Nullable FormattingOptions formattingOptions, @NotNull String encoding) {
      Intrinsics.checkParameterIsNotNull(encoding, "encoding");
      super();
      this.formattingOptions = formattingOptions;
      Hashtable var10001 = JavaCore.getOptions();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "JavaCore.getOptions()");
      this.jdtOptions = var10001;
      this.jdtOptions.put("org.greenrobot.eclipse.jdt.core.compiler.source", Companion.getJAVA_LEVEL());
      this.jdtOptions.put("org.greenrobot.eclipse.jdt.core.compiler.compliance", Companion.getJAVA_LEVEL());
      this.jdtOptions.put("org.greenrobot.eclipse.jdt.core.encoding", encoding);
      this.classParser = new EntityClassParser(this.jdtOptions, encoding);
   }

   // $FF: synthetic method
   public JdtCodeContext(FormattingOptions var1, String var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 1) != 0) {
         var1 = (FormattingOptions)null;
      }

      this(var1, var2);
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/JdtCodeContext$Companion;", "", "()V", "JAVA_LEVEL", "", "getJAVA_LEVEL", "()Ljava/lang/String;", "greendao-code-modifier_main"}
   )
   public static final class Companion {
      @NotNull
      public final String getJAVA_LEVEL() {
         return JdtCodeContext.JAVA_LEVEL;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
