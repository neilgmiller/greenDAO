package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class JoinOnProperty(val source: String, val target: String) {

    fun copy(source: String, target: String): JoinOnProperty = JoinOnProperty(source, target)

    override fun toString(): String {
        return "JoinOnProperty(source=$source, target=$target)"
    }

    override fun hashCode(): Int {
        val var10000 = source
        val var1 = var10000.hashCode() * 31
        val var10001 = target
        return var1 + var10001.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is JoinOnProperty) {
                val var2 = other
                if (Intrinsics.areEqual(source, var2.source) && Intrinsics.areEqual(target, var2.target)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}