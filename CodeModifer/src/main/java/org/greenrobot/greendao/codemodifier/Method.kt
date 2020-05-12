package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u001c\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Method;", "Lorg/greenrobot/greendao/codemodifier/Generatable;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "name", "", "parameters", "", "Lorg/greenrobot/greendao/codemodifier/Variable;", "node", "hint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "(Ljava/lang/String;Ljava/util/List;Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;Lorg/greenrobot/greendao/codemodifier/GeneratorHint;)V", "getHint", "()Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "getName", "()Ljava/lang/String;", "getNode", "()Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "getParameters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hasFullSignature", "params", "hasSignature", "paramsTypes", "hashCode", "", "toString", "greendao-code-modifier_main"])
class Method(val name: String, val parameters: List<*>, private val node: MethodDeclaration, private val hint: GeneratorHint?) : Generatable {

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

    override fun getNode(): MethodDeclaration {
        return node
    }

    override fun getHint(): GeneratorHint? {
        return hint
    }

    override fun getGenerated(): Boolean {
        return Generatable.DefaultImpls.getGenerated(this)
    }

    override fun getKeep(): Boolean {
        return Generatable.DefaultImpls.getKeep(this)
    }

    fun copy(name: String, parameters: List<*>, node: MethodDeclaration, hint: GeneratorHint?): Method {
        Intrinsics.checkParameterIsNotNull(name, "name")
        Intrinsics.checkParameterIsNotNull(parameters, "parameters")
        Intrinsics.checkParameterIsNotNull(node, "node")
        return Method(name, parameters, node, hint)
    }

    override fun toString(): String {
        return "Method(name=$name, parameters=$parameters, node=${getNode()}, hint=${getHint()})"
    }

    override fun hashCode(): Int {
        val var10000 = name
        var var1 = var10000.hashCode() * 31
        val var10001 = parameters
        var1 = (var1 + var10001.hashCode()) * 31
        val var2 = getNode()
        var1 = (var1 + var2.hashCode()) * 31
        val var3 = getHint()
        return var1 + (var3?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is Method) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && Intrinsics.areEqual(parameters, var2.parameters) && Intrinsics.areEqual(getNode(), var2.getNode()) && Intrinsics.areEqual(getHint(), var2.getHint())) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}