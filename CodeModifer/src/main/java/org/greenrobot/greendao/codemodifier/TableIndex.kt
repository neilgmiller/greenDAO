package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class TableIndex(val name: String?, val fields: List<*>, val unique: Boolean) {

    fun copy(name: String?, fields: List<*>, unique: Boolean): TableIndex {
        Intrinsics.checkParameterIsNotNull(fields, "fields")
        return TableIndex(name, fields, unique)
    }

    override fun toString(): String {
        return "TableIndex(name=$name, fields=$fields, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        var var1 = (var10000?.hashCode() ?: 0) * 31
        val var10001 = fields
        var1 = (var1 + var10001.hashCode()) * 31
        var var2 = unique.toByte()
        if (var2.toInt() != 0) {
            var2 = 1
        }
        return var1 + var2
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is TableIndex) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && Intrinsics.areEqual(fields, var2.fields) && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}