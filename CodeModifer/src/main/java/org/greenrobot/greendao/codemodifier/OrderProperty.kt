package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"], d2 = ["Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "", "name", "", "order", "Lorg/greenrobot/greendao/codemodifier/Order;", "(Ljava/lang/String;Lorg/greenrobot/greendao/codemodifier/Order;)V", "getName", "()Ljava/lang/String;", "getOrder", "()Lorg/greenrobot/greendao/codemodifier/Order;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
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
        val var1 = (var10000?.hashCode() ?: 0) * 31
        val var10001 = order
        return var1 + (var10001?.hashCode() ?: 0)
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