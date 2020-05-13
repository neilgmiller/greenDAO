package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class CustomType(val converterClassName: String, val columnJavaType: VariableType) {
    fun copy(converterClassName: String, columnJavaType: VariableType): CustomType {
        return CustomType(converterClassName, columnJavaType)
    }

    override fun toString(): String {
        return "CustomType(converterClassName=$converterClassName, columnJavaType=$columnJavaType)"
    }

    override fun hashCode(): Int {
        return converterClassName.hashCode() * 31 +
                columnJavaType.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is CustomType) {
                if (Intrinsics.areEqual(converterClassName, other.converterClassName) && Intrinsics.areEqual(columnJavaType, other.columnJavaType)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}