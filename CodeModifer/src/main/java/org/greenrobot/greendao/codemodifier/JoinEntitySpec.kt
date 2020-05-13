package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

class JoinEntitySpec(val entityName: String, val sourceIdProperty: String, val targetIdProperty: String) {
    fun copy(entityName: String, sourceIdProperty: String, targetIdProperty: String): JoinEntitySpec {
        Intrinsics.checkParameterIsNotNull(entityName, "entityName")
        Intrinsics.checkParameterIsNotNull(sourceIdProperty, "sourceIdProperty")
        Intrinsics.checkParameterIsNotNull(targetIdProperty, "targetIdProperty")
        return JoinEntitySpec(entityName, sourceIdProperty, targetIdProperty)
    }

    override fun toString(): String {
        return "JoinEntitySpec(entityName=$entityName, sourceIdProperty=$sourceIdProperty, targetIdProperty=$targetIdProperty)"
    }

    override fun hashCode(): Int {
        val var10000 = entityName
        var var1 = var10000.hashCode() * 31
        var var10001 = sourceIdProperty
        var1 = (var1 + var10001.hashCode()) * 31
        var10001 = targetIdProperty
        return var1 + var10001.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is JoinEntitySpec) {
                val var2 = other
                if (Intrinsics.areEqual(entityName, var2.entityName) && Intrinsics.areEqual(sourceIdProperty, var2.sourceIdProperty) && Intrinsics.areEqual(targetIdProperty, var2.targetIdProperty)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}