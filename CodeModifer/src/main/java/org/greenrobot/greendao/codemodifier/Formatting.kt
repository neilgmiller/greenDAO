package org.greenrobot.greendao.codemodifier

import java.util.Collections.max
import kotlin.jvm.internal.Intrinsics
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt




//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Formatting;", "", "tabulation", "Lorg/greenrobot/greendao/codemodifier/Tabulation;", "lineWidth", "", "(Lorg/greenrobot/greendao/codemodifier/Tabulation;I)V", "getLineWidth", "()I", "getTabulation", "()Lorg/greenrobot/greendao/codemodifier/Tabulation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "greendao-code-modifier_main"])
class Formatting(val tabulation: Tabulation, val lineWidth: Int) {

//    operator fun component1(): Tabulation {
//        return tabulation
//    }
//
//    operator fun component2(): Int {
//        return lineWidth
//    }

    fun copy(tabulation: Tabulation, lineWidth: Int): Formatting = Formatting(tabulation, lineWidth)

    override fun toString(): String = "Formatting(tabulation=$tabulation, lineWidth=$lineWidth)"

    override fun hashCode(): Int = tabulation.hashCode() * 31 + lineWidth

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
    companion object {
        fun detect(text: String, options: FormattingOptions?): Formatting {
            val lineWidth: Int

            val lines: List<String> = text.lines()
            if (options != null) {
                val var10000 = options.lineWidth
                lineWidth = if (var10000 != null) {
                    var10000.toInt()
                } else {
                    val longestLineLength: Int? = lines.max()?.length
                    Math.max(80, Math.round((longestLineLength ?: 0).toFloat() / 10.0f) * 10)
                }
            }

            var tabulation1: Tabulation?
            label173@ run {
                if (options != null) {
                    tabulation1 = options.tabulation
                    if (tabulation1 != null) {
                        break@label173
                    }
                }
                val receiver = this
                val linesIterable = lines as Iterable<String>
                val destination = mutableListOf<String>()
                var linesIterator = linesIterable.iterator()
                var element: Any
                var receiver2: String
                var index: Int
                var var20: Int
                var var39: String
                while (linesIterator.hasNext()) {
                    label196@ run {
                        element = linesIterator.next()
                        val line = element as String
                        receiver2 = line
                        var endIndex = 0
                        endIndex = line.length - 1
                        if (endIndex <= endIndex) {
                            while (true) {
                                val it = receiver2[endIndex]
                                if (it != ' ') {
                                    val var19: Byte = 0
                                    var39 = receiver2.substring(var19.toInt(), endIndex)
                                    break@label196
                                }
                                if (endIndex == endIndex) {
                                    break
                                }
                                ++endIndex
                            }
                        }
                        var39 = receiver2
                    }
                    var20 = var39.length
                    destination.add(var20)
                }
                receiver2 = destination
                destination.clear()
                linesIterator = receiver2.iterator()
                var it: Int

                while (linesIterator.hasNext()) {
                    element = linesIterator.next()
                    it = (element as Number).intValue()
                    if (it > 1) {
                        destination.add(element)
                    }
                }

                val spaces = destination.toList()
                var lineIterable = lines.asIterable()
                var destination2 = mutableListOf<String>()
                var lineIterator = lineIterable.iterator()
                var element2: String
                while (lineIterator.hasNext()) {
                    label197@ run {
                        element2 = lineIterator.next()
                        lineIterable = element2.asIterable()
                        val receiver3: String = lineIterable
                        index = 0
                        val endIndex = receiver3.length - 1
                        if (index <= endIndex) {
                            while (true) {
                                val it2 = receiver3[index]
                                if (it2 != '\t') {
                                    val var22: Byte = 0
                                    var39 = receiver3.substring(var22.toInt(), index)
                                    break@label197
                                }
                                if (index == endIndex) {
                                    break
                                }
                                ++index
                            }
                        }
                        var39 = receiver3
                    }
                    var20 = var39.length
                    destination2.add(var20)
                }

                lineIterable = destination2
                destination2.clear()
                lineIterator = lineIterable.iterator()
                while (lineIterator.hasNext()) {
                    element2 = lineIterator.next() // TODO: check which Element
                    val it3: Int = element2.toInt() // TODO: Check this is right everywhere
                    if (it3 > 0) {
                        destination2.add(element2)
                    }
                }

                val tabs = destination2
                lineIterable = spaces
                var count = 0
                linesIterator = lineIterable.iterator()
                while (linesIterator.hasNext()) {
                    element = linesIterator.next()  // TODO: check which Element
                    it = (element as Number).intValue()
                    if (it > 0) {
                        ++count
                    }
                }

                lineIterable = tabs
                val var14 = count
                count = 0
                linesIterator = lineIterable.iterator()
                while (linesIterator.hasNext()) {
                    element = linesIterator.next()  // TODO: check which Element
                    it = (element as Number).intValue()
                    if (it > 0) {
                        ++count
                    }
                }

                val tabSize: Int
                if (var14 > count) {
                    tabSize = receiver.detectTabLength(spaces, 4, 2)
                    tabulation1 = Tabulation(' ', tabSize)
                } else {
                    tabSize = receiver.detectTabLength(tabs, 1, 1)
                    tabulation1 = Tabulation('\t', tabSize)
                }
                tabulation1 = tabulation1 as Tabulation
            }
            val tabulation = tabulation1
            return Formatting(tabulation!!, lineWidth)
        }

        // TODO:
        fun detectTabLength(tabLengths: List<*>, defaultLength: Int, min: Int): Int {
            val var100001 = FunsKt
                    .mostPopular(tabLengths
                            .toTypedArray()
                            .mapIndexed { index: Int, tab: Int ->
                                if (index == 0)
                                    tab
                                else
                                    tab - tabLengths[index - 1]
                            }
//                            .filter { it >= min }

//                            .filter({ it: Int -> it >= min }) as Int?

                            return var10000 ?: defaultLength
        }
    }

}