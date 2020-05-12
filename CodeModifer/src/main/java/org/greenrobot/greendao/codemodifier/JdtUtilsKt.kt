package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import kotlin.jvm.internal.Intrinsics
import kotlin.reflect.KClass

object JdtUtilsKt {
    private val JavaLangTypes: Set<*> = setOf(*arrayOf("Long", "Byte", "Integer", "Boolean", "Short", "Float", "Double", "String"))
    fun has(`$receiver`: Iterable<*>, qualifiedName: String): Boolean {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        Intrinsics.checkParameterIsNotNull(qualifiedName, "qualifiedName")
        val packageName = qualifiedName.substringBeforeLast('.', "")
        val var4 = `$receiver`.iterator()
        val var10000: Boolean
        while (true) {
            if (!var4.hasNext()) {
                var10000 = false
                break
            }
            val `element$iv` = var4.next()!!
            val it = `element$iv` as ImportDeclaration
            val name = it.name
            if (Intrinsics.areEqual(name.fullyQualifiedName, qualifiedName) || it.isOnDemand && name is QualifiedName && Intrinsics.areEqual(name.fullyQualifiedName, packageName)) {
                var10000 = true
                break
            }
        }
        return var10000
    }

    fun getSimpleName(`$receiver`: Name): String {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        val var10000: String
        if (`$receiver` is QualifiedName) {
            var10000 = `$receiver`.name.fullyQualifiedName
            Intrinsics.checkExpressionValueIsNotNull(var10000, "this.name.fullyQualifiedName")
        } else {
            var10000 = `$receiver`.fullyQualifiedName
            Intrinsics.checkExpressionValueIsNotNull(var10000, "this.fullyQualifiedName")
        }
        return var10000
    }

    fun getQualifier(`$receiver`: Name): String {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        val var10000: String
        if (`$receiver` is QualifiedName) {
            var10000 = `$receiver`.qualifier.fullyQualifiedName
            Intrinsics.checkExpressionValueIsNotNull(var10000, "this.qualifier.fullyQualifiedName")
        } else {
            var10000 = ""
        }
        return var10000
    }

    fun isStrict(`$receiver`: Iterable<*>): Boolean {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        val var2 = `$receiver`.iterator()
        val var10000: Boolean
        while (true) {
            if (!var2.hasNext()) {
                var10000 = true
                break
            }
            val `element$iv` = var2.next()!!
            val it = `element$iv` as ImportDeclaration
            if (it.isOnDemand && !it.isStatic) {
                var10000 = false
                break
            }
        }
        return var10000
    }

    fun resolveName(`$receiver`: Name, outerClassName: String?, imports: Iterable<*>, sourcePkg: String?, classesInPackage: List<*>): String {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        Intrinsics.checkParameterIsNotNull(imports, "imports")
        Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage")
        val simpleName = `$receiver`.fullyQualifiedName
        var var15: String
        if (`$receiver` is SimpleName) {
            val var8 = imports.iterator()
            val var10000: Any?
            while (true) {
                if (!var8.hasNext()) {
                    var10000 = null
                    break
                }
                val var9 = var8.next()!!
                val it = var9 as ImportDeclaration
                if (Intrinsics.areEqual(getSimpleName(it.name), simpleName)) {
                    var10000 = var9
                    break
                }
            }
            val var14 = var10000 as ImportDeclaration?
            if (var14 != null) {
                val var6: ImportDeclaration = var14
                var15 = var6.name.fullyQualifiedName as String
                if (var15 != null) {
                    return var15
                }
            }
            val `$receiver` = `$receiver` as Name
            var15 = if (classesInPackage.contains(simpleName)) {
                if (sourcePkg != null) "$sourcePkg.$simpleName" else simpleName
            } else if (isStrict(imports) && !JavaLangTypes.contains(simpleName)) {
                if (outerClassName != null) if (sourcePkg != null) "$sourcePkg.$outerClassName.$simpleName" else "$outerClassName.$simpleName" else simpleName
            } else {
                if (!JavaLangTypes.contains(simpleName)) {
                    throw (IllegalArgumentException("Can't resolve qualified name for " + simpleName + ". " + "Try to not use on-demand imports or specify qualified name explicitly (line " + getLineNumber(`$receiver` as ASTNode) + ")") as Throwable)
                }
                simpleName
            }
            Intrinsics.checkExpressionValueIsNotNull(var15, "run {\n                //…          }\n            }")
            var15 = var15
        } else {
            if (`$receiver` is QualifiedName) {
                val var12 = `$receiver`.fullyQualifiedName[0]
                if (Character.isUpperCase(var12)) {
                    var15 = resolveName(`$receiver`.qualifier, outerClassName, imports, sourcePkg, classesInPackage) + "." + `$receiver`.name.identifier
                    return var15
                }
            }
            var15 = simpleName
            Intrinsics.checkExpressionValueIsNotNull(simpleName, "simpleName")
        }
        return var15
    }

    fun has(`$receiver`: Iterable<*>, klass: KClass<*>): Boolean {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        Intrinsics.checkParameterIsNotNull(klass, "klass")
        val var10000 = klass.qualifiedName
        val var5: Boolean
        var5 = if (var10000 != null) {
            val var2: String = var10000
            has(`$receiver`, var2)
        } else {
            false
        }
        return var5
    }

    operator fun get(`$receiver`: NormalAnnotation, fieldName: String): Expression? {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        Intrinsics.checkParameterIsNotNull(fieldName, "fieldName")
        val var2: Sequence<*> = `$receiver`.values().filterNotNull().asSequence()
        val var4 = var2.iterator()
        val var10000: Any?
        while (true) {
            if (var4.hasNext()) {
                val var5 = var4.next()!!
                val it = var5 as MemberValuePair
                if (!Intrinsics.areEqual(it.name.identifier, fieldName)) {
                    continue
                }
                var10000 = var5
                break
            }
            var10000 = null
            break
        }
        return if (var10000 as MemberValuePair? != null) (var10000 as MemberValuePair?)!!.value else null
    }

    fun typeName(`$receiver`: Type, containingClassIdentifier: String?, imports: Iterable<*>, sourcePkg: String?, classesInPackage: List<*>): String {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        Intrinsics.checkParameterIsNotNull(imports, "imports")
        Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage")
        val var10000: String
        if (`$receiver` is SimpleType) {
            var10000 = resolveName(`$receiver`.name, containingClassIdentifier, imports, sourcePkg, classesInPackage)
        } else if (`$receiver` is ArrayType) {
            var10000 = typeName(`$receiver`.elementType, null as String?, imports, sourcePkg, classesInPackage) + "[]"
        } else if (`$receiver` is QualifiedType) {
            var10000 = typeName(`$receiver`.qualifier, null as String?, imports, sourcePkg, classesInPackage) + "." + `$receiver`.name.identifier
        } else if (`$receiver` is ParameterizedType) {
            var10000 = typeName(`$receiver`.type, null as String?, imports, sourcePkg, classesInPackage)
        } else {
            var10000 = `$receiver`.toString()
            Intrinsics.checkExpressionValueIsNotNull(var10000, "toString()")
        }
        return var10000
    }

    fun getLineNumber(`$receiver`: ASTNode): Int? {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        val root = `$receiver`.root
        return if (root is CompilationUnit) root.getLineNumber(`$receiver`.startPosition) else null
    }
}

fun Boolean.toByte(): Byte = if(this) 1 else 0