package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Reflection

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n¢\u0006\u0002\u0010\bJ\u001d\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J=\u0010\u000b\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\n*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\fH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0013"], d2 = ["Lorg/greenrobot/greendao/codemodifier/AnnotationProxy;", "", "()V", "invoke", "T", "", "jdtAnnotation", "Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "(Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;)Ljava/lang/annotation/Annotation;", "type", "Ljava/lang/Class;", "javaValue", "C", "Lorg/greenrobot/eclipse/jdt/core/dom/Expression;", "methodName", "", "expected", "(Lorg/greenrobot/eclipse/jdt/core/dom/Expression;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Handler", "greendao-code-modifier_main"])
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
        @JvmField
        var INSTANCE: AnnotationProxy = AnnotationProxy()
    }

//    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\rH\u0096\u0002¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"], d2 = ["Lorg/greenrobot/greendao/codemodifier/AnnotationProxy\$Handler;", "Ljava/lang/reflect/InvocationHandler;", "jdtAnnotation", "Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "(Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;)V", "getJdtAnnotation", "()Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "greendao-code-modifier_main"])
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