package org.greenrobot.greendao.codemodifier

import java.io.File
import java.util.*

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

    fun mostPopular(sequence: Sequence<Int>): Int? {
        val countMap = mutableMapOf<Int, Int>()
        val itemIterator = sequence.iterator()
        var countOfItem: Int?
        while (itemIterator.hasNext()) {
            val sequenceItem = itemIterator.next()
            countOfItem = countMap[sequenceItem]
            if (countOfItem == null) {
                countOfItem = 0
            }
            countMap[sequenceItem] = countOfItem + 1
        }

        val countMapIterator = countMap.asSequence().iterator()
        val foundMapEntry : Map.Entry<Int, Int>?
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

    fun getJavaClassNames(directory: File): List<String> {
        return if (!directory.isDirectory) {
            throw IllegalArgumentException("The file should be a directory")
        } else {
            val pathNameList = directory.list()
            val newPathNameList = mutableListOf<String>()
            for (index in pathNameList!!.indices) {
                val pathName = pathNameList[index]
                if (pathName.endsWith(".java", true)) {
                    newPathNameList.add(pathName)
                }
            }

            val newFileList = mutableListOf<File>()
            val newPathNameIterator = newPathNameList.iterator()
            while (newPathNameIterator.hasNext()) {
                val file = File(directory, newPathNameIterator.next())
                newFileList.add(file)
            }

            val newFileList2 = mutableListOf<File>()
            val fileIterator1 = newFileList.iterator()
            while (fileIterator1.hasNext()) {
                val file = fileIterator1.next()
                if (file.isFile) {
                    newFileList2.add(file)
                }
            }

            val fileNameList = mutableListOf<String>()
            val fileIterator2 = newFileList2.iterator()
            while (fileIterator2.hasNext()) {
                val it2 : File = fileIterator2.next()
                fileNameList.add(it2.nameWithoutExtension)
            }
            fileNameList
        }
    }

    // TODO: is never used
    fun logTime(action: String, block: Function0<*>): Any {
        val start = System.currentTimeMillis()
        val result = block.invoke()!!
        val time = System.currentTimeMillis() - start
        println("$action took $time ms")
        return result
    }
}