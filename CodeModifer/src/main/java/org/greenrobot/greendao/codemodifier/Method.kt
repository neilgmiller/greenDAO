package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration
import kotlin.jvm.internal.Intrinsics

class Method(val name: String, val parameters: List<*>, override val node: MethodDeclaration, override val hint: GeneratorHint?) : Generatable {

    override val generated: Boolean = hint is GeneratorHint.Generated

    override val keep: Boolean = Intrinsics.areEqual(hint, GeneratorHint.Keep.INSTANCE)

    fun hasSignature(name: String, paramsTypes: List<*>): Boolean {
        var hasSignature = false
        if (Intrinsics.areEqual(this.name, name)) {
            var stringList = mutableListOf<String>()
            var variableIterator = parameters.iterator()
            var variable: Variable
            while (variableIterator.hasNext()) {
                variable = variableIterator.next() as Variable
                stringList.add(variable.type.name)
            }
            if (Intrinsics.areEqual(stringList, paramsTypes)) {
                hasSignature = true
            }

            stringList = mutableListOf()
            variableIterator = parameters.iterator()
            while (true) {
                if (!variableIterator.hasNext()) {
                    if (Intrinsics.areEqual(stringList, paramsTypes)) {
                        hasSignature = true
                    }
                    break
                }
                variable = variableIterator.next() as Variable
                stringList.add(variable.type.simpleName)
            }
        }

        return hasSignature
    }

    fun hasFullSignature(name: String, params: List<*>): Boolean {
        Intrinsics.checkParameterIsNotNull(name, "name")
        Intrinsics.checkParameterIsNotNull(params, "params")
        return Intrinsics.areEqual(this.name, name) && Intrinsics.areEqual(parameters, params)
    }

    fun copy(name: String, parameters: List<*>, node: MethodDeclaration, hint: GeneratorHint?): Method {
        Intrinsics.checkParameterIsNotNull(name, "name")
        Intrinsics.checkParameterIsNotNull(parameters, "parameters")
        Intrinsics.checkParameterIsNotNull(node, "node")
        return Method(name, parameters, node, hint)
    }

    override fun toString(): String {
        return "Method(name=$name, parameters=$parameters, node=${node}, hint=${hint})"
    }

    override fun hashCode(): Int {
        val var10000 = name
        var var1 = var10000.hashCode() * 31
        val var10001 = parameters
        var1 = (var1 + var10001.hashCode()) * 31
        val var2 = node
        var1 = (var1 + var2.hashCode()) * 31
        val var3 = hint
        return var1 + (var3?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is Method) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && Intrinsics.areEqual(parameters, var2.parameters) && Intrinsics.areEqual(node, var2.node) && Intrinsics.areEqual(hint, var2.hint)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}