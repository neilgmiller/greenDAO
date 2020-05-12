package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"], d2 = ["Lorg/greenrobot/greendao/codemodifier/ManyRelation;", "", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "mappedBy", "", "joinOnProperties", "", "Lorg/greenrobot/greendao/codemodifier/JoinOnProperty;", "joinEntitySpec", "Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;", "order", "Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "(Lorg/greenrobot/greendao/codemodifier/Variable;Ljava/lang/String;Ljava/util/List;Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;Ljava/util/List;)V", "getJoinEntitySpec", "()Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;", "getJoinOnProperties", "()Ljava/util/List;", "getMappedBy", "()Ljava/lang/String;", "getOrder", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
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