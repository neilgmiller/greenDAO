package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class VariableType(val name: String, val isPrimitive: Boolean, val originalName: String, val typeArguments: List<*>?) {
    val simpleName: String = name.substringAfterLast(delimiter = '.')

    fun copy(name: String, isPrimitive: Boolean, originalName: String, typeArguments: List<*>?): VariableType {
        Intrinsics.checkParameterIsNotNull(name, "name")
        Intrinsics.checkParameterIsNotNull(originalName, "originalName")
        return VariableType(name, isPrimitive, originalName, typeArguments)
    }

    override fun toString(): String {
        return "VariableType(name=$name, isPrimitive=$isPrimitive, originalName=$originalName, typeArguments=$typeArguments)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        var var1 = var10000.hashCode() * 31
        var var10001 = isPrimitive.toByte()
        if (var10001.toInt() != 0) {
            var10001 = 1
        }
        var1 = (var1 + var10001) * 31
        val var2 = originalName
        var1 = (var1 + var2.hashCode()) * 31
        val var3 = typeArguments
        return var1 + (var3?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is VariableType) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && isPrimitive == var2.isPrimitive && Intrinsics.areEqual(originalName, var2.originalName) && Intrinsics.areEqual(typeArguments, var2.typeArguments)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}