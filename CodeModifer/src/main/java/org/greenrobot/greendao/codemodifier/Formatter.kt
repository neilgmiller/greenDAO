package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.internal.formatter.DefaultCodeFormatter
import org.greenrobot.eclipse.jdt.internal.formatter.DefaultCodeFormatterOptions
import org.greenrobot.eclipse.jface.text.Document
import org.greenrobot.eclipse.jface.text.IDocument
import kotlin.jvm.internal.Intrinsics

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