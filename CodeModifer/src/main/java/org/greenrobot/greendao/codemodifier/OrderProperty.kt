package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class OrderProperty(val name: String, val order: Order) {

    fun copy(name: String, order: Order): OrderProperty {
        Intrinsics.checkParameterIsNotNull(name, "name")
        Intrinsics.checkParameterIsNotNull(order, "order")
        return OrderProperty(name, order)
    }

    override fun toString(): String {
        return "OrderProperty(name=$name, order=$order)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        val var1 = var10000.hashCode() * 31
        val var10001 = order
        return var1 + var10001.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is OrderProperty) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && Intrinsics.areEqual(order, var2.order)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}