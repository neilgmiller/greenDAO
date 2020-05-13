package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class PropertyIndex(val name: String?, val unique: Boolean) {

    fun copy(name: String?, unique: Boolean): PropertyIndex {
        return PropertyIndex(name, unique)
    }

    override fun toString(): String {
        return "PropertyIndex(name=$name, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        val var1 = (var10000?.hashCode() ?: 0) * 31
        var var10001 = unique.toByte()
        if (var10001.toInt() != 0) {
            var10001 = 1
        }
        return var1 + var10001
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is PropertyIndex) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}