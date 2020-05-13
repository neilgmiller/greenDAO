package org.greenrobot.greendao.codemodifier

class FormattingOptions(val tabulation: Tabulation?, val lineWidth: Int?) {
    fun toFormatting(): Formatting? =
            if (tabulation != null && lineWidth != null) Formatting(tabulation, lineWidth.toInt())
            else null
}