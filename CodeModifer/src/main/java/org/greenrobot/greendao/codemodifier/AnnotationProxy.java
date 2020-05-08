package org.greenrobot.greendao.codemodifier;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.greenrobot.eclipse.jdt.core.dom.Annotation;
import org.greenrobot.eclipse.jdt.core.dom.ArrayInitializer;
import org.greenrobot.eclipse.jdt.core.dom.BooleanLiteral;
import org.greenrobot.eclipse.jdt.core.dom.Expression;
import org.greenrobot.eclipse.jdt.core.dom.NormalAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.NumberLiteral;
import org.greenrobot.eclipse.jdt.core.dom.PrefixExpression;
import org.greenrobot.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.StringLiteral;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n¢\u0006\u0002\u0010\bJ\u001d\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J=\u0010\u000b\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\n*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u0002H\fH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0013"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/AnnotationProxy;", "", "()V", "invoke", "T", "", "jdtAnnotation", "Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "(Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;)Ljava/lang/annotation/Annotation;", "type", "Ljava/lang/Class;", "javaValue", "C", "Lorg/greenrobot/eclipse/jdt/core/dom/Expression;", "methodName", "", "expected", "(Lorg/greenrobot/eclipse/jdt/core/dom/Expression;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "Handler", "greendao-code-modifier_main"}
)
public final class AnnotationProxy {
   public static final AnnotationProxy INSTANCE;

   @NotNull
   public final Object invoke(@NotNull Annotation jdtAnnotation, @NotNull Class type) {
      Intrinsics.checkParameterIsNotNull(jdtAnnotation, "jdtAnnotation");
      Intrinsics.checkParameterIsNotNull(type, "type");
      ClassLoader var10000 = type.getClassLoader();
      Object[] elements$iv = new Class[]{type};
      ClassLoader var4 = var10000;
      Object[] var5 = (Object[])elements$iv;
      Object var6 = Proxy.newProxyInstance(var4, (Class[])var5, (InvocationHandler)(new AnnotationProxy.Handler(jdtAnnotation)));
      Intrinsics.checkExpressionValueIsNotNull(var6, "Proxy.newProxyInstance(t…, Handler(jdtAnnotation))");
      return var6;
   }

   private final java.lang.annotation.Annotation invoke(Annotation jdtAnnotation) {
      Intrinsics.reifiedOperationMarker(4, "T");
      Object var10000 = this.invoke(jdtAnnotation, java.lang.annotation.Annotation.class);
      Intrinsics.reifiedOperationMarker(1, "T");
      return (java.lang.annotation.Annotation)var10000;
   }

   private final Object javaValue(@NotNull Expression $receiver, String methodName, Class expected) {
      if (expected.isArray()) {
         if ($receiver instanceof ArrayInitializer) {
            Class componentType = expected.getComponentType();
            List expressions = ((ArrayInitializer)$receiver).expressions();
            Object result = Array.newInstance(componentType, expressions.size());
            Iterable $receiver$iv = (Iterable)expressions;
            int index$iv = 0;
            Iterator var9 = $receiver$iv.iterator();

            while(var9.hasNext()) {
               Object item$iv = var9.next();
               int i = index$iv++;
               AnnotationProxy var10002 = INSTANCE;
               if (item$iv == null) {
                  throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.Expression");
               }

               Array.set(result, i, var10002.javaValue((Expression)item$iv, methodName, componentType));
            }

            if (result == null) {
               throw new TypeCastException("null cannot be cast to non-null type T");
            }

            return (Object)result;
         }
      } else {
         Object constantValue;
         if (Intrinsics.areEqual(expected, JvmClassMappingKt.getJavaPrimitiveType(Reflection.getOrCreateKotlinClass(Boolean.TYPE)))) {
            if ($receiver instanceof BooleanLiteral) {
               return (Object)((BooleanLiteral)$receiver).booleanValue();
            }

            if ($receiver instanceof Expression) {
               constantValue = $receiver.resolveConstantExpressionValue();
               if (constantValue != null && constantValue instanceof Boolean) {
                  if (constantValue == null) {
                     throw new TypeCastException("null cannot be cast to non-null type T");
                  }

                  return (Object)constantValue;
               }
            }
         } else if (Intrinsics.areEqual(expected, JvmClassMappingKt.getJavaPrimitiveType(Reflection.getOrCreateKotlinClass(Integer.TYPE)))) {
            if ($receiver instanceof NumberLiteral || $receiver instanceof PrefixExpression) {
               Integer var16 = Integer.decode($receiver.toString());
               if (var16 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type T");
               } else {
                  return (Object)var16;
               }
            }
         } else if (Intrinsics.areEqual(expected, String.class)) {
            if ($receiver instanceof StringLiteral) {
               String var17 = ((StringLiteral)$receiver).getLiteralValue();
               if (var17 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type T");
               }

               return (Object)var17;
            }

            if ($receiver instanceof Expression) {
               constantValue = $receiver.resolveConstantExpressionValue();
               if (constantValue != null && constantValue instanceof String) {
                  if (constantValue == null) {
                     throw new TypeCastException("null cannot be cast to non-null type T");
                  }

                  return (Object)constantValue;
               }
            }
         } else if (expected.isAnnotation() && $receiver instanceof Annotation) {
            Object var18 = INSTANCE.invoke((Annotation)$receiver, expected);
            if (var18 == null) {
               throw new TypeCastException("null cannot be cast to non-null type T");
            }

            return (Object)var18;
         }
      }

      throw (Throwable)(new RuntimeException("Value for " + methodName + " should be of type " + expected.getSimpleName() + " " + "(could not convert from " + $receiver.getClass() + "). Note: only inline constants are supported."));
   }

   private AnnotationProxy() {
      INSTANCE = (AnnotationProxy)this;
   }

   static {
      new AnnotationProxy();
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\rH\u0096\u0002¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/AnnotationProxy$Handler;", "Ljava/lang/reflect/InvocationHandler;", "jdtAnnotation", "Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "(Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;)V", "getJdtAnnotation", "()Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "greendao-code-modifier_main"}
   )
   public static final class Handler implements InvocationHandler {
      @NotNull
      private final Annotation jdtAnnotation;

      @Nullable
      public Object invoke(@NotNull Object proxy, @NotNull java.lang.reflect.Method method, @Nullable Object[] args) {
         Intrinsics.checkParameterIsNotNull(proxy, "proxy");
         Intrinsics.checkParameterIsNotNull(method, "method");
         Annotation var4 = this.jdtAnnotation;
         Object var8;
         AnnotationProxy var10000;
         String var10002;
         if (var4 instanceof SingleMemberAnnotation) {
            if (Intrinsics.areEqual(method.getName(), "value")) {
               var10000 = AnnotationProxy.INSTANCE;
               Expression var10001 = ((SingleMemberAnnotation)this.jdtAnnotation).getValue();
               var10002 = method.getName();
               Intrinsics.checkExpressionValueIsNotNull(var10002, "method.name");
               var8 = var10000.javaValue(var10001, var10002, method.getReturnType());
            } else {
               var8 = method.getDefaultValue();
            }
         } else if (var4 instanceof NormalAnnotation) {
            NormalAnnotation var9 = (NormalAnnotation)this.jdtAnnotation;
            String var10 = method.getName();
            Intrinsics.checkExpressionValueIsNotNull(var10, "method.name");
            Expression var11 = JdtUtilsKt.get(var9, var10);
            if (var11 != null) {
               Expression var5 = var11;
               Expression it = (Expression)var5;
               var10000 = AnnotationProxy.INSTANCE;
               var10002 = method.getName();
               Intrinsics.checkExpressionValueIsNotNull(var10002, "method.name");
               var8 = var10000.javaValue(it, var10002, method.getReturnType());
               if (var8 != null) {
                  return var8;
               }
            }

            var8 = method.getDefaultValue();
         } else {
            var8 = method.getDefaultValue();
         }

         return var8;
      }

      @NotNull
      public final Annotation getJdtAnnotation() {
         return this.jdtAnnotation;
      }

      public Handler(@NotNull Annotation jdtAnnotation) {
         Intrinsics.checkParameterIsNotNull(jdtAnnotation, "jdtAnnotation");
         super();
         this.jdtAnnotation = jdtAnnotation;
      }
   }
}
