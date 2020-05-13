package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class ManyRelation(val variable: Variable, val mappedBy: String?, val joinOnProperties: List<*>, val joinEntitySpec: JoinEntitySpec?, val order: List<*>?) {

    fun copy(variable: Variable, mappedBy: String?, joinOnProperties: List<*>, joinEntitySpec: JoinEntitySpec?, order: List<*>?): ManyRelation =
            ManyRelation(variable, mappedBy, joinOnProperties, joinEntitySpec, order)

    override fun toString(): String {
        return "ManyRelation(variable=$variable, mappedBy=$mappedBy, joinOnProperties=$joinOnProperties, joinEntitySpec=$joinEntitySpec, order=$order)"
    }

    override fun hashCode(): Int {
        val var10000 = variable
        var var1 = (var10000.hashCode() ?: 0) * 31
        val var10001 = mappedBy
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        var var2: List<*>? = joinOnProperties
        var1 = (var1 + (var2?.hashCode() ?: 0)) * 31
        val var3 = joinEntitySpec
        var1 = (var1 + (var3?.hashCode() ?: 0)) * 31
        var2 = order
        return var1 + (var2?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is ManyRelation) {
                val var2 = other
                if (Intrinsics.areEqual(variable, var2.variable) && Intrinsics.areEqual(mappedBy, var2.mappedBy) && Intrinsics.areEqual(joinOnProperties, var2.joinOnProperties) && Intrinsics.areEqual(joinEntitySpec, var2.joinEntitySpec) && Intrinsics.areEqual(order, var2.order)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}