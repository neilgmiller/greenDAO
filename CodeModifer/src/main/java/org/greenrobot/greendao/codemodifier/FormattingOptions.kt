package org.greenrobot.greendao.codemodifier

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"], d2 = ["Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "", "tabulation", "Lorg/greenrobot/greendao/codemodifier/Tabulation;", "lineWidth", "", "(Lorg/greenrobot/greendao/codemodifier/Tabulation;Ljava/lang/Integer;)V", "getLineWidth", "()Ljava/lang/Integer;", "setLineWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTabulation", "()Lorg/greenrobot/greendao/codemodifier/Tabulation;", "setTabulation", "(Lorg/greenrobot/greendao/codemodifier/Tabulation;)V", "toFormatting", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "greendao-code-modifier_main"])
class FormattingOptions(private val tabulation: Tabulation?, private val lineWidth: Int?) {
    fun toFormatting(): Formatting? =
            if (tabulation != null && lineWidth != null) Formatting(tabulation, lineWidth.toInt())
            else null

    //    // $FF: synthetic method
//    @JvmOverloads
//    constructor(var1: Tabulation? = null as Tabulation?, var2: Int? = null as Int?, var3: Int = 3) {
//        var tabulation = var1
//        var lineWidth = var2
//        if (var3 and 1 != 0) {
//            tabulation = null
//        }
//        if (var3 and 2 != 0) {
//            lineWidth = null
//        }
//        this(tabulation, lineWidth)
//    }
}