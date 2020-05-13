package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.FunsKt.mostPopular
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

            val somethingAboutSpaces = mutableListOf<Int>()
            val lineIterator = lines.iterator()
            while (lineIterator.hasNext()) {
                var someString: String

                label196@ run {
                    val line = lineIterator.next() as String
                    var localEndIndex = line.length - 1
                    if (localEndIndex <= localEndIndex) {
                        while (true) {
                            val lastChar = line[localEndIndex]
                            if (lastChar != ' ') {
                                someString = line.substring(0, localEndIndex)
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
                somethingAboutSpaces.add(someString.length)
            }


            val spacesMoreThanOne = mutableListOf<Int>() // Maybe duplicated spaces in a row?
            val somethingAboutSpacesIterator = somethingAboutSpaces.iterator()
            while (lineIterator.hasNext()) {
                val spacesElement = somethingAboutSpacesIterator.next()
                if (spacesElement > 1) {
                    spacesMoreThanOne.add(spacesElement)
                }
            }

            val somethingAboutTabs = mutableListOf<Int>()
            val linesIterable2 = lines.iterator()
            while (linesIterable2.hasNext()) {
                var someString: String

                label197@ run {
                    val line = linesIterable2.next()
                    var startIndex = 0
                    val lineEndIndex = line.length - 1
                    if (startIndex <= lineEndIndex) {
                        while (true) {
                            val it = line[startIndex]
                            if (it != '\t') {
                                someString = line.substring(0, startIndex)
                                Intrinsics.checkExpressionValueIsNotNull(someString, "(this as java.lang.Strin…ing(startIndex, endIndex)")
                                break@label197
                            }
                            if (startIndex == lineEndIndex) {
                                break
                            }
                            ++startIndex
                        }
                    }
                    someString = line
                }
                somethingAboutTabs.add(someString.length)
            }

            val tabsMoreThanZero = mutableListOf<Int>()
            val somethingAboutTabsIterator = somethingAboutTabs.iterator()
            while (somethingAboutTabsIterator.hasNext()) {
                val integer: Int = somethingAboutTabsIterator.next()
                if (integer > 0) {
                    tabsMoreThanZero.add(integer)
                }
            }

            var spaceCount = 0
            val spacesIterator = somethingAboutSpaces.iterator()
            while (spacesIterator.hasNext()) {
                if (spacesIterator.next() > 0) {
                    ++spaceCount
                }
            }

            var tabCount = 0
            val tabIterator = somethingAboutTabs.iterator()
            while (tabIterator.hasNext()) {
                if (tabIterator.next() > 0) {
                    ++tabCount
                }
            }

            var tabulation: Tabulation? = options?.tabulation
            if (tabulation == null) {
                val tabSize: Int
                if (tabCount > spaceCount) {
                    tabSize = detectTabLength(somethingAboutSpaces, 4, 2)
                    tabulation = Tabulation(' ', tabSize)
                } else {
                    tabSize = detectTabLength(somethingAboutTabs, 1, 1)
                    tabulation = Tabulation('\t', tabSize)
                }
            }
            return Formatting(tabulation, maxLineLength)
        }

        private fun detectTabLength(tabLengths: List<Int>, defaultLength: Int, min: Int): Int {
            val tabLength = mostPopular(tabLengths.asSequence()
                    .mapIndexed { index: Int, tab: Int ->
                        if (index == 0) tab
                        else tab - (tabLengths[index - 1])
                    }
                    .filter { it >= min })

            return tabLength ?: defaultLength
        }
    }
}