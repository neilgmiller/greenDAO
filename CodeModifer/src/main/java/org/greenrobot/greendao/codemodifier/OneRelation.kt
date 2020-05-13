package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class OneRelation(val variable: Variable, val foreignKeyField: String?, val columnName: String?, val isNotNull: Boolean, val unique: Boolean) {

    fun copy(variable: Variable, foreignKeyField: String?, columnName: String?, isNotNull: Boolean, unique: Boolean): OneRelation {
        Intrinsics.checkParameterIsNotNull(variable, "variable")
        return OneRelation(variable, foreignKeyField, columnName, isNotNull, unique)
    }

    override fun toString(): String {
        return "OneRelation(variable=$variable, foreignKeyField=$foreignKeyField, columnName=$columnName, isNotNull=$isNotNull, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = variable
        var var1 = (var10000.hashCode() ?: 0) * 31
        var var10001 = foreignKeyField
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        var10001 = columnName
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        var var2: Byte = isNotNull.toByte()
        if (var2.toInt() != 0) {
            var2 = 1
        }
        var1 = (var1 + var2) * 31
        var2 = unique.toByte()
        if (var2.toInt() != 0) {
            var2 = 1
        }
        return var1 + var2
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is OneRelation) {
                val var2 = other
                if (Intrinsics.areEqual(variable, var2.variable) && Intrinsics.areEqual(foreignKeyField, var2.foreignKeyField) && Intrinsics.areEqual(columnName, var2.columnName) && isNotNull == var2.isNotNull && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}