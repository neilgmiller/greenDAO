package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class ParsedProperty(val variable: Variable, val id: EntityIdParams?, val index: PropertyIndex?, val isNotNull: Boolean, val dbName: String?, val customType: CustomType?, val unique: Boolean) {

    fun copy(variable: Variable, id: EntityIdParams?, index: PropertyIndex?, isNotNull: Boolean, dbName: String?, customType: CustomType?, unique: Boolean): ParsedProperty {
        Intrinsics.checkParameterIsNotNull(variable, "variable")
        return ParsedProperty(variable, id, index, isNotNull, dbName, customType, unique)
    }

    override fun toString(): String {
        return "ParsedProperty(variable=$variable, id=$id, index=$index, isNotNull=$isNotNull, dbName=$dbName, customType=$customType, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = variable
        var var1 = (var10000.hashCode() ?: 0) * 31
        val var10001 = id
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        val var2 = index
        var1 = (var1 + (var2?.hashCode() ?: 0)) * 31
        var var3 = isNotNull.toByte()
        if (var3.toInt() != 0) {
            var3 = 1
        }
        var1 = (var1 + var3) * 31
        val var4 = dbName
        var1 = (var1 + (var4?.hashCode() ?: 0)) * 31
        val var5 = customType
        var1 = (var1 + (var5?.hashCode() ?: 0)) * 31
        var3 = unique.toByte()
        if (var3.toInt() != 0) {
            var3 = 1
        }
        return var1 + var3
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is ParsedProperty) {
                val var2 = other
                if (Intrinsics.areEqual(variable, var2.variable) && Intrinsics.areEqual(id, var2.id) && Intrinsics.areEqual(index, var2.index) && isNotNull == var2.isNotNull && Intrinsics.areEqual(dbName, var2.dbName) && Intrinsics.areEqual(customType, var2.customType) && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}