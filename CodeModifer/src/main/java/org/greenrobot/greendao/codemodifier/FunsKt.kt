package org.greenrobot.greendao.codemodifier

import java.io.File
import java.util.*
import kotlin.jvm.internal.Intrinsics

object FunsKt {
    @Throws(IllegalArgumentException::class)
    fun parseIndexSpec(spec: String): List<OrderProperty> {
        return if (spec.isBlank()) {
            throw IllegalArgumentException("Index spec should not be empty")
        } else {
            val specList = spec.split(',', ignoreCase = false, limit = 6)
            val trimmedSpecList = mutableListOf<String>()
            var splitSpecIterator = specList.iterator()
            while (splitSpecIterator.hasNext()) {
                trimmedSpecList.add(splitSpecIterator.next().trim())
            }

            val orderPropertyList = mutableListOf<OrderProperty>()
            splitSpecIterator = trimmedSpecList.iterator()
            while (splitSpecIterator.hasNext()) {
                val columnSpec = splitSpecIterator.next()
                if (columnSpec.isEmpty()) {
                    throw IllegalArgumentException("Wrong index spec: $spec")
                }
                val specPair: List<String> = columnSpec.split(' ', ignoreCase = false, limit = 6)
                var orderProperty: OrderProperty
                orderProperty = if (specPair.size == 1) {
                    OrderProperty(specPair[0], Order.ASC)
                } else {
                    val name = specPair[0]
                    val orderString = specPair[1].toUpperCase(Locale.getDefault())
                    OrderProperty(name, Order.valueOf(orderString))
                }
                orderPropertyList.add(orderProperty)
            }
            orderPropertyList
        }
    }

    fun nullIfBlank(string: String): String? {
        return if (!string.isBlank()) string else null
    }

    fun mostPopular(sequence: Sequence<*>): Any? {
        val countMap = mutableMapOf<Any, Int>()
        val itemIterator = sequence.iterator()
        var countOfItem: Int?
        while (itemIterator.hasNext()) {
            val sequenceItem = itemIterator.next()!!
            countOfItem = countMap[sequenceItem]
            if (countOfItem == null) {
                countOfItem = 0
            }
            countMap[sequenceItem] = countOfItem + 1
        }

        val countMapIterator = countMap.asSequence().iterator()
        val foundMapEntry : Map.Entry<Any, Int>?
        if (!countMapIterator.hasNext()) {
            foundMapEntry = null
        } else {
            var maxEntry = countMapIterator.next()
            var maxCount = maxEntry.value
            while (countMapIterator.hasNext()) {
                val entry = countMapIterator.next()
                val value = entry.value
                if (maxCount < value) {
                    maxEntry = entry
                    maxCount = value
                }
            }
            foundMapEntry = maxEntry
        }
        return foundMapEntry?.key
    }

    fun getJavaClassNames(directory: File): List<*> {
        val isDirectory = directory.isDirectory
        return if (!isDirectory) {
            throw IllegalArgumentException("The file should be a directory")
        } else {
            val pathNameList = directory.list()
//            var newPathNameList = mutableListOf<String>()
            var pathName: String
            var pathName2: String
            for (index in pathNameList.indices) {
                pathName = pathNameList[index]
                if (pathName.endsWith(".java", true)) {
                    newPathNameList.add(pathName)
                }
            }

            var newPathNameIterable = newPathNameList
            newPathNameList = ArrayList<Any?>(newPathNameIterable.collectionSizeOrDefault<Any>(10))
            var newPathNameIterator = newPathNameIterable.iterator()
            while (newPathNameIterator.hasNext()) {
                pathName = newPathNameIterator.next()
                pathName2 = pathName
                val file = File(directory, pathName2)
                newPathNameList.add(file)
            }

            newPathNameIterable = newPathNameList
            newPathNameList = ArrayList<Any?>()
            newPathNameIterator = newPathNameIterable.iterator()
            var it: File
            while (newPathNameIterator.hasNext()) {
                pathName = newPathNameIterator.next()
                it = pathName as File
                if (it.isFile) {
                    newPathNameList.add(pathName)
                }
            }

            newPathNameIterable = newPathNameList
            newPathNameList = ArrayList<Any?>(newPathNameIterable.collectionSizeOrDefault<Any>(10))
            newPathNameIterator = newPathNameIterable.iterator()
            while (newPathNameIterator.hasNext()) {
                pathName = newPathNameIterator.next()
                it = pathName as File
                val var17 = it.nameWithoutExtension
                newPathNameList.add(var17)
            }
            newPathNameList as List<*>
        }
    }

    fun logTime(action: String, block: Function0<*>): Any {
        val start = System.currentTimeMillis()
        val result = block.invoke()!!
        val time = System.currentTimeMillis() - start
        println("$action took $time ms")
        return result
    }
}