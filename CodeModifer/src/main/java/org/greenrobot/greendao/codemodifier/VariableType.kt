package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"], d2 = ["Lorg/greenrobot/greendao/codemodifier/VariableType;", "", "name", "", "isPrimitive", "", "originalName", "typeArguments", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "()Z", "getName", "()Ljava/lang/String;", "getOriginalName", "simpleName", "getSimpleName", "getTypeArguments", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
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