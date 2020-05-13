package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"], d2 = ["Lorg/greenrobot/greendao/codemodifier/TransientField;", "Lorg/greenrobot/greendao/codemodifier/Generatable;", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "node", "hint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "(Lorg/greenrobot/greendao/codemodifier/Variable;Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;Lorg/greenrobot/greendao/codemodifier/GeneratorHint;)V", "getHint", "()Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "getNode", "()Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "greendao-code-modifier_main"])
class TransientField(val variable: Variable, override val node: FieldDeclaration, override val hint: GeneratorHint?) : Generatable {

    override val generated: Boolean = hint is GeneratorHint.Generated

    override val keep: Boolean = Intrinsics.areEqual(hint, GeneratorHint.Keep.INSTANCE)

    fun copy(variable: Variable, node: FieldDeclaration, hint: GeneratorHint?): TransientField {
        Intrinsics.checkParameterIsNotNull(variable, "variable")
        Intrinsics.checkParameterIsNotNull(node, "node")
        return TransientField(variable, node, hint)
    }

    override fun toString(): String {
        return "TransientField(variable=$variable, node=${node}, hint=${hint})"
    }

    override fun hashCode(): Int {
        val var10000 = variable
        var var1 = var10000.hashCode() * 31
        val var10001 = node
        var1 = (var1 + var10001.hashCode()) * 31
        val var2 = hint
        return var1 + (var2?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is TransientField) {
                val var2 = other
                if (Intrinsics.areEqual(variable, var2.variable) && Intrinsics.areEqual(node, var2.node) && Intrinsics.areEqual(hint, var2.hint)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}