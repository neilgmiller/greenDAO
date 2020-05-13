package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Reflection

class AnnotationProxy private constructor() {
    operator fun invoke(jdtAnnotation: org.greenrobot.eclipse.jdt.core.dom.Annotation, type: Class<*>): Any =
            Proxy.newProxyInstance(type.classLoader, arrayOf(type), Handler(jdtAnnotation) as InvocationHandler)

    private operator fun invoke(jdtAnnotation: org.greenrobot.eclipse.jdt.core.dom.Annotation): Annotation =
            this.invoke(jdtAnnotation, Annotation::class.java) as Annotation

    private fun javaValue(receiver: Expression, methodName: String, expected: Class<*>): Any {
        if (expected.isArray) {
            if (receiver is ArrayInitializer) {
                val componentType = expected.componentType
                val expressions = receiver.expressions()
                val result = java.lang.reflect.Array.newInstance(componentType, expressions.size)
                var index = 0
                val receiverIterator = expressions.iterator()
                while (receiverIterator.hasNext()) {
                    val item = receiverIterator.next()
                    val i = index++
                    val annotationProxy = INSTANCE
                    if (item == null) {
                        throw TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.Expression")
                    }
                    java.lang.reflect.Array.set(result, i, annotationProxy.javaValue(item as Expression, methodName, componentType))
                }
                if (result == null) {
                    throw TypeCastException("null cannot be cast to non-null type T")
                }
                return result as Any
            }
        } else {
            val constantValue: Any?
            if (Intrinsics.areEqual(expected, Reflection.getOrCreateKotlinClass(java.lang.Boolean.TYPE).javaPrimitiveType)) {
                if (receiver is BooleanLiteral) {
                    return receiver.booleanValue()
                }
                constantValue = receiver.resolveConstantExpressionValue()
                if (constantValue != null && constantValue is Boolean) {
                    return constantValue
                }
            } else if (Intrinsics.areEqual(expected, Reflection.getOrCreateKotlinClass(Integer.TYPE).javaPrimitiveType)) {
                if (receiver is NumberLiteral || receiver is PrefixExpression) {
                    return Integer.decode(receiver.toString()) ?: throw TypeCastException("null cannot be cast to non-null type T")
                }
            } else if (Intrinsics.areEqual(expected, String::class.java)) {
                if (receiver is StringLiteral) {
                    return receiver.literalValue
                            ?: throw TypeCastException("null cannot be cast to non-null type T")
                }
                constantValue = receiver.resolveConstantExpressionValue()
                if (constantValue != null && constantValue is String) {
                    return constantValue
                }
            } else if (expected.isAnnotation && receiver is org.greenrobot.eclipse.jdt.core.dom.Annotation) {
                return INSTANCE.invoke(receiver, expected)
            }
        }
        throw RuntimeException("Value for $methodName should be of type ${expected.simpleName} (could not convert from ${receiver.javaClass}). Note: only inline constants are supported.")
    }

    companion object {
        var INSTANCE: AnnotationProxy = AnnotationProxy()
    }

    class Handler(private val jdtAnnotation: org.greenrobot.eclipse.jdt.core.dom.Annotation) : InvocationHandler {
        override fun invoke(proxy: Any, method: Method, args: Array<Any>?): Any? {
            when (jdtAnnotation) {
                is SingleMemberAnnotation -> {
                    return if (Intrinsics.areEqual(method.name, "value")) {
                        INSTANCE.javaValue(jdtAnnotation.value, method.name, method.returnType)
                    } else {
                        method.defaultValue
                    }
                }
                is NormalAnnotation -> {
                    val var11 = JdtUtilsKt.get(jdtAnnotation, method.name)
                    if (var11 != null)
                        return INSTANCE.javaValue(var11, method.name, method.returnType)
                    return method.defaultValue
                }
                else -> {
                    return method.defaultValue
                }
            }
        }
    }
}