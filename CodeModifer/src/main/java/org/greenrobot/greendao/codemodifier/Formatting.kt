package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.FunsKt.mostPopular
import java.util.*
import java.util.Collections.max
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Formatting;", "", "tabulation", "Lorg/greenrobot/greendao/codemodifier/Tabulation;", "lineWidth", "", "(Lorg/greenrobot/greendao/codemodifier/Tabulation;I)V", "getLineWidth", "()I", "getTabulation", "()Lorg/greenrobot/greendao/codemodifier/Tabulation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "greendao-code-modifier_main"])
class Formatting(val tabulation: Tabulation, val lineWidth: Int) {

    fun copy(tabulation: Tabulation, lineWidth: Int): Formatting {
        Intrinsics.checkParameterIsNotNull(tabulation, "tabulation")
        return Formatting(tabulation, lineWidth)
    }

    override fun toString(): String {
        return "Formatting(tabulation=$tabulation, lineWidth=$lineWidth)"
    }

    override fun hashCode(): Int {
        return tabulation.hashCode() * 31 + lineWidth
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is Formatting) {
                if (Intrinsics.areEqual(tabulation, other.tabulation) && lineWidth == other.lineWidth) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

    //    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ$\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n¨\u0006\u000f"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Formatting\$Companion;", "", "()V", "detect", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "text", "", "options", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "detectTabLength", "", "tabLengths", "", "defaultLength", "min", "greendao-code-modifier_main"])
    class Companion {
        fun detect(text: String, options: FormattingOptions?): Formatting {
            val lines: List<String> = text.lines()
            val maxLineLength: Int = options?.lineWidth
                    ?: Math.max(80, Math.round(max(lines).length.toFloat() / 10.0f) * 10)

//            val lineWidth: Int = maxLineLength

            val `$receiver` = this
            val `$receiver$iv` = lines as Iterable<*>
            var `destination$iv$iv` = ArrayList<Any?>(`$receiver$iv`.collectionSizeOrDefault<Any>(10)) as MutableCollection<*>
            var var11 = `$receiver$iv`.iterator()
            var `element$iv`: Any
            var `$receiver$iv`: String
            var `index$iv`: Int
            var var20: Int
            var var39: String
            while (var11.hasNext()) {
                label196@ run {
                    `element$iv` = var11.next()!!
                    val line = `element$iv` as String
                    `$receiver$iv` = line
                    var `index$iv` = 0
                    `index$iv` = line.length - 1
                    if (`index$iv` <= `index$iv`) {
                        while (true) {
                            val it = `$receiver$iv`[`index$iv`]
                            if (it != ' ') {
                                val var19: Byte = 0
                                if (`$receiver$iv` == null) {
                                    throw TypeCastException("null cannot be cast to non-null type java.lang.String")
                                }
                                var39 = `$receiver$iv`.substring(var19.toInt(), `index$iv`)
                                Intrinsics.checkExpressionValueIsNotNull(var39, "(this as java.lang.Strin…ing(startIndex, endIndex)")
                                break@label196
                            }
                            if (`index$iv` == `index$iv`) {
                                break
                            }
                            ++`index$iv`
                        }
                    }
                    var39 = `$receiver$iv`
                }
                var20 = var39.length
                `destination$iv$iv`.add(var20)
            }
            `$receiver$iv` = `destination$iv$iv` as List<*>
            `destination$iv$iv` = ArrayList<Any?>()
            var11 = `$receiver$iv`.iterator()
            var it: Int
            while (var11.hasNext()) {
                `element$iv` = var11.next()
                it = (`element$iv` as Number).intValue()
                if (it > 1) {
                    `destination$iv$iv`.add(`element$iv`)
                }
            }
            val spaces = `destination$iv$iv` as List<*>
            var `$receiver$iv` = lines as Iterable<*>
            var `destination$iv$iv` = ArrayList<Any?>(`$receiver$iv`.collectionSizeOrDefault<Any>(10)) as MutableCollection<*>
            var var32 = `$receiver$iv`.iterator()
            var `element$iv$iv`: Any
            while (var32.hasNext()) {
                label197@ run {
                    `element$iv$iv` = var32.next()!!
                    `$receiver$iv` = `element$iv$iv` as String
                    val `$receiver$iv`: String? = `$receiver$iv`
                    `index$iv` = 0
                    val var40 = `$receiver$iv`!!.length - 1
                    if (`index$iv` <= var40) {
                        while (true) {
                            val it = `$receiver$iv`[`index$iv`]
                            if (it != '\t') {
                                val var22: Byte = 0
                                if (`$receiver$iv` == null) {
                                    throw TypeCastException("null cannot be cast to non-null type java.lang.String")
                                }
                                var39 = `$receiver$iv`.substring(var22.toInt(), `index$iv`)
                                Intrinsics.checkExpressionValueIsNotNull(var39, "(this as java.lang.Strin…ing(startIndex, endIndex)")
                                break@label197
                            }
                            if (`index$iv` == var40) {
                                break
                            }
                            ++`index$iv`
                        }
                    }
                    var39 = `$receiver$iv`
                }
                var20 = var39.length
                `destination$iv$iv`.add(var20)
            }
            `$receiver$iv` = `destination$iv$iv` as List<*>
            `destination$iv$iv` = ArrayList<Any?>()
            var32 = `$receiver$iv`.iterator()
            while (var32.hasNext()) {
                `element$iv$iv` = var32.next()!!
                val it: Int = (`element$iv$iv` as Number).intValue()
                if (it > 0) {
                    `destination$iv$iv`.add(`element$iv$iv`)
                }
            }
            val tabs = `destination$iv$iv` as List<*>
            `$receiver$iv` = spaces
            var `count$iv` = 0
            var11 = `$receiver$iv`.iterator()
            while (var11.hasNext()) {
                `element$iv` = var11.next()!!
                it = (`element$iv` as Number).intValue()
                if (it > 0) {
                    ++`count$iv`
                }
            }
            `$receiver$iv` = tabs
            val var14 = `count$iv`
            `count$iv` = 0
            var11 = `$receiver$iv`.iterator()
            while (var11.hasNext()) {
                `element$iv` = var11.next()!!
                it = (`element$iv` as Number).intValue()
                if (it > 0) {
                    ++`count$iv`
                }
            }

            var tabulation: Tabulation? = options?.tabulation
            if (tabulation == null) {
                val tabSize: Int
                if (var14 > `count$iv`) {
                    tabSize = `$receiver`.detectTabLength(spaces, 4, 2)
                    tabulation = Tabulation(' ', tabSize)
                } else {
                    tabSize = `$receiver`.detectTabLength(tabs, 1, 1)
                    tabulation = Tabulation('\t', tabSize)
                }
                tabulation = tabulation as Tabulation
            }
            return Formatting(tabulation, maxLineLength)
        }

        private fun detectTabLength(tabLengths: List<*>, defaultLength: Int, min: Int): Int {
            val var10000 = mostPopular(tabLengths
                    .mapIndexed({ index: Int, tab: Int ->
                        if (index == 0) tab else tab - (tabLengths[index - 1] as Number).intValue()
                    }
                            as Function2<*, *, *>)
                    .filter { it: Int -> it >= min })


            val var10000 = mostPopular(tabLengths as Iterable<*>?. asSequence < kotlin . Any ? > ().mapIndexed({ index: Int, tab: Int -> if (index == 0) tab else tab - (tabLengths[index - 1] as Number).intValue() } as Function2<*, *, *>).filter({ it: Int -> it >= min })) as Int?
            return var10000 ?: defaultLength
        }
    }
}