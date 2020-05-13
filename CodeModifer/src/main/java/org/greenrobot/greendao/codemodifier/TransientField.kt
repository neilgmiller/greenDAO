package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration
import kotlin.jvm.internal.Intrinsics

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