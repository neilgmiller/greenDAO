package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"], d2 = ["Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;", "", "entityName", "", "sourceIdProperty", "targetIdProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntityName", "()Ljava/lang/String;", "getSourceIdProperty", "getTargetIdProperty", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
class JoinEntitySpec(val entityName: String, val sourceIdProperty: String, val targetIdProperty: String) {
    fun copy(entityName: String, sourceIdProperty: String, targetIdProperty: String): JoinEntitySpec {
        Intrinsics.checkParameterIsNotNull(entityName, "entityName")
        Intrinsics.checkParameterIsNotNull(sourceIdProperty, "sourceIdProperty")
        Intrinsics.checkParameterIsNotNull(targetIdProperty, "targetIdProperty")
        return JoinEntitySpec(entityName, sourceIdProperty, targetIdProperty)
    }

    override fun toString(): String {
        return "JoinEntitySpec(entityName=" + entityName + ", sourceIdProperty=" + sourceIdProperty + ", targetIdProperty=" + targetIdProperty + ")"
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