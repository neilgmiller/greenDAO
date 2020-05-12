package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eclipse.jdt.internal.formatter.DefaultCodeFormatter;
import org.greenrobot.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions;
import org.greenrobot.eclipse.jface.text.Document;
import org.greenrobot.eclipse.jface.text.IDocument;
import org.greenrobot.eclipse.text.edits.TextEdit;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\r"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Formatter;", "", "formatting", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "(Lorg/greenrobot/greendao/codemodifier/Formatting;)V", "formatter", "Lorg/greenrobot/eclipse/jdt/internal/formatter/DefaultCodeFormatter;", "getFormatting", "()Lorg/greenrobot/greendao/codemodifier/Formatting;", "setFormatting", "format", "", "javaCode", "greendao-code-modifier_main"}
)
public final class Formatter {
   private final DefaultCodeFormatter formatter;
   @NotNull
   private Formatting formatting;

   @NotNull
   public final String format(@NotNull String javaCode) {
      Intrinsics.checkParameterIsNotNull(javaCode, "javaCode");
      TextEdit formatEdits = this.formatter.format(4, javaCode, 0, javaCode.length(), 0, "\n");
      Document doc = new Document(javaCode);
      if (formatEdits != null) {
         formatEdits.apply((IDocument)doc);
         String var10000 = doc.get();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "doc.get()");
         return var10000;
      } else {
         throw (Throwable)(new RuntimeException("Can't format the code. Check syntax correctness of the code."));
      }
   }

   @NotNull
   public final Formatting getFormatting() {
      return this.formatting;
   }

   public final void setFormatting(@NotNull Formatting var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.formatting = var1;
   }

   public Formatter(@NotNull Formatting formatting) {
      Intrinsics.checkParameterIsNotNull(formatting, "formatting");
      super();
      this.formatting = formatting;
      DefaultCodeFormatterOptions options = new DefaultCodeFormatterOptions(DefaultCodeFormatterOptions.getJavaConventionsSettings().getMap());
      options.tab_size = this.formatting.tabulation.getSize();
      options.tab_char = this.formatting.tabulation.getTabChar() == ' ' ? 2 : 1;
      options.page_width = this.formatting.lineWidth;
      this.formatter = new DefaultCodeFormatter(options);
   }
}
