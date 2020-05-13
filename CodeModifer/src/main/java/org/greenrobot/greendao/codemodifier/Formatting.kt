package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.FunsKt.mostPopular
import java.util.Collections.max
import kotlin.jvm.internal.Intrinsics

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

    companion object {
        fun detect(text: String, options: FormattingOptions?): Formatting {
            val lines: List<String> = text.lines()
            val maxLineLength: Int = options?.lineWidth
                    ?: Math.max(80, Math.round(max(lines).length.toFloat() / 10.0f) * 10)

            val lengthsOfLinesUntilSpace = mutableListOf<Int>()
            val lineIterator = lines.iterator()
            while (lineIterator.hasNext()) {
                val lineBeforeSpace = lineIterator.next().substringBefore(' ')
                lengthsOfLinesUntilSpace.add(lineBeforeSpace.length)
            }

            val lengthsOfLinesBeforeTabAtLeastTwo = mutableListOf<Int>()  // TODO: This value is never used
            val lengthBeforeSpaceIterator = lengthsOfLinesUntilSpace.iterator()
            while (lineIterator.hasNext()) {
                val spacesElement = lengthBeforeSpaceIterator.next()
                if (spacesElement > 1) {
                    lengthsOfLinesBeforeTabAtLeastTwo.add(spacesElement)
                }
            }

            val lengthOfLinesUntilTab = mutableListOf<Int>()
            val lineIterator2 = lines.iterator()
            while (lineIterator2.hasNext()) {
                val lineBeforeTab = lineIterator.next().substringBefore('\t')
                lengthOfLinesUntilTab.add(lineBeforeTab.length)
            }

            val lengthsOfLinesBeforeTabAtLeastOne = mutableListOf<Int>() // TODO This value is never used
            val lengthBeforeTabIterator = lengthOfLinesUntilTab.iterator()
            while (lengthBeforeTabIterator.hasNext()) {
                val integer: Int = lengthBeforeTabIterator.next()
                if (integer > 0) {
                    lengthsOfLinesBeforeTabAtLeastOne.add(integer)
                }
            }

            var linesWithAtLeastOneCharBeforeSpace = 0
            val lengthsOfLinesUntilSpaceIterator = lengthsOfLinesUntilSpace.iterator()
            while (lengthsOfLinesUntilSpaceIterator.hasNext()) {
                if (lengthsOfLinesUntilSpaceIterator.next() > 0) {
                    ++linesWithAtLeastOneCharBeforeSpace
                }
            }

            var linesWithAtLeastOneCharBeforeTab = 0
            val lengthOfLinesUntilTabIterator = lengthOfLinesUntilTab.iterator()
            while (lengthOfLinesUntilTabIterator.hasNext()) {
                if (lengthOfLinesUntilTabIterator.next() > 0) {
                    ++linesWithAtLeastOneCharBeforeTab
                }
            }

            var tabulation: Tabulation? = options?.tabulation
            if (tabulation == null) {
                val tabSize: Int
                if (linesWithAtLeastOneCharBeforeTab > linesWithAtLeastOneCharBeforeSpace) {
                    tabSize = detectTabLength(lengthsOfLinesUntilSpace, 4, 2)
                    tabulation = Tabulation(' ', tabSize)
                } else {
                    tabSize = detectTabLength(lengthOfLinesUntilTab, 1, 1)
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