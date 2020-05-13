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

            var destination0 = mutableListOf<>()
            var someInt: Int
            var someString: String

            val lineIterator = lines.iterator()
            while (lineIterator.hasNext()) {
                label196@ run {
                    val line = lineIterator.next() as String
                    var localEndIndex = 0
                    localEndIndex = line.length - 1
                    if (localEndIndex <= localEndIndex) {
                        while (true) {
                            val it = line[localEndIndex]
                            if (it != ' ') {
                                val var19: Byte = 0
                                if (line == null) {
                                    throw TypeCastException("null cannot be cast to non-null type java.lang.String")
                                }
                                someString = line.substring(var19.toInt(), localEndIndex)
                                Intrinsics.checkExpressionValueIsNotNull(someString, "(this as java.lang.Strin…ing(startIndex, endIndex)")
                                break@label196
                            }
                            if (localEndIndex == localEndIndex) {
                                break
                            }
                            ++localEndIndex
                        }
                    }
                    someString = line
                }
                someInt = someString.length
                destination0.add(someInt)
            }



            val receiver1 = destination0 as List<*>
            destination0 = ArrayList<Any?>()
            val iterator1 = receiver1.iterator()
            while (lineIterator.hasNext()) {
                val element1 = iterator1.next()
                val it = (element1 as Number).intValue()
                if (it > 1) {
                    destination0.add(element1)
                }
            }
            val spaces = destination0 as List<*>
            var receiver2 = lines as Iterable<*>
            var destination2 = ArrayList<Any?>(receiver2.collectionSizeOrDefault<Any>(10)) as MutableCollection<*>
            var var32 = receiver2.iterator()
            var element0: Any
            var globalEndIndex: Int
            while (var32.hasNext()) {
                label197@ run {
                    element0 = var32.next()!!
                    receiver2 = element0 as String
                    val `$receiver$iv`: String? = receiver2
                    globalEndIndex = 0
                    val var40 = `$receiver$iv`!!.length - 1
                    if (globalEndIndex <= var40) {
                        while (true) {
                            val it = `$receiver$iv`[globalEndIndex]
                            if (it != '\t') {
                                val var22: Byte = 0
                                if (`$receiver$iv` == null) {
                                    throw TypeCastException("null cannot be cast to non-null type java.lang.String")
                                }
                                someString = `$receiver$iv`.substring(var22.toInt(), globalEndIndex)
                                Intrinsics.checkExpressionValueIsNotNull(someString, "(this as java.lang.Strin…ing(startIndex, endIndex)")
                                break@label197
                            }
                            if (globalEndIndex == var40) {
                                break
                            }
                            ++globalEndIndex
                        }
                    }
                    someString = `$receiver$iv`
                }
                someInt = someString.length
                destination2.add(someInt)
            }
            receiver2 = destination2 as List<*>
            destination2 = ArrayList<Any?>()
            var32 = receiver2.iterator()
            while (var32.hasNext()) {
                element0 = var32.next()!!
                val it: Int = (element0 as Number).intValue()
                if (it > 0) {
                    destination2.add(element0)
                }
            }
            val tabs = destination2 as List<*>
            receiver2 = spaces
            var counter0 = 0
            val iterator2 = receiver2.iterator()
            while (iterator2.hasNext()) {
                val element1 = iterator2.next()!!
                val it = (element1 as Number).intValue()
                if (it > 0) {
                    ++counter0
                }
            }
            receiver2 = tabs
            val var14 = counter0
            counter0 = 0
            val iterator3 = receiver2.iterator()
            while (iterator3.hasNext()) {
                val element1 = iterator3.next()!!
                val it = (element1 as Number).intValue()
                if (it > 0) {
                    ++counter0
                }
            }

            var tabulation: Tabulation? = options?.tabulation
            if (tabulation == null) {
                val tabSize: Int
                if (var14 > counter0) {
                    tabSize = detectTabLength(spaces, 4, 2)
                    tabulation = Tabulation(' ', tabSize)
                } else {
                    tabSize = detectTabLength(tabs, 1, 1)
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