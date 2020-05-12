package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.internal.formatter.DefaultCodeFormatter
import org.greenrobot.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions
import org.greenrobot.eclipse.jface.text.Document
import org.greenrobot.eclipse.jface.text.IDocument
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\r"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Formatter;", "", "formatting", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "(Lorg/greenrobot/greendao/codemodifier/Formatting;)V", "formatter", "Lorg/greenrobot/eclipse/jdt/internal/formatter/DefaultCodeFormatter;", "getFormatting", "()Lorg/greenrobot/greendao/codemodifier/Formatting;", "setFormatting", "format", "", "javaCode", "greendao-code-modifier_main"])
class Formatter(formatting: Formatting) {
    private val formatter: DefaultCodeFormatter
    private var formatting: Formatting
    fun format(javaCode: String): String {
        Intrinsics.checkParameterIsNotNull(javaCode, "javaCode")
        val formatEdits = formatter.format(4, javaCode, 0, javaCode.length, 0, "\n")
        val doc = Document(javaCode)
        return if (formatEdits != null) {
            formatEdits.apply(doc as IDocument)
            val var10000 = doc.get()
            Intrinsics.checkExpressionValueIsNotNull(var10000, "doc.get()")
            var10000
        } else {
            throw (RuntimeException("Can't format the code. Check syntax correctness of the code.") as Throwable)
        }
    }

    fun getFormatting(): Formatting {
        return formatting
    }

    fun setFormatting(var1: Formatting) {
        Intrinsics.checkParameterIsNotNull(var1, "<set-?>")
        formatting = var1
    }

    init {
        this.formatting = formatting
        val options = DefaultCodeFormatterOptions(DefaultCodeFormatterOptions.getJavaConventionsSettings().map)
        options.tab_size = this.formatting.tabulation.size
        options.tab_char = if (this.formatting.tabulation.tabChar == ' ') 2 else 1
        options.page_width = this.formatting.lineWidth
        formatter = DefaultCodeFormatter(options)
    }
}