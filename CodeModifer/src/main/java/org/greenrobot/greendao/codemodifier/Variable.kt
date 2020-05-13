package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class Variable(val type: VariableType, val name: String) {

    fun copy(type: VariableType, name: String): Variable {
        Intrinsics.checkParameterIsNotNull(type, "type")
        Intrinsics.checkParameterIsNotNull(name, "name")
        return Variable(type, name)
    }

    override fun toString(): String {
        return "Variable(type=$type, name=$name)"
    }

    override fun hashCode(): Int {
        val var10000 = type
        val var1 = var10000.hashCode() * 31
        val var10001 = name
        return var1 + var10001.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is Variable) {
                val var2 = other
                if (Intrinsics.areEqual(type, var2.type) && Intrinsics.areEqual(name, var2.name)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}