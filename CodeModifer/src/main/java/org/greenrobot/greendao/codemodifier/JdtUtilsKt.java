package org.greenrobot.greendao.codemodifier;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.greenrobot.eclipse.jdt.core.dom.ASTNode;
import org.greenrobot.eclipse.jdt.core.dom.ArrayType;
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit;
import org.greenrobot.eclipse.jdt.core.dom.Expression;
import org.greenrobot.eclipse.jdt.core.dom.ImportDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.MemberValuePair;
import org.greenrobot.eclipse.jdt.core.dom.Name;
import org.greenrobot.eclipse.jdt.core.dom.NormalAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.ParameterizedType;
import org.greenrobot.eclipse.jdt.core.dom.QualifiedName;
import org.greenrobot.eclipse.jdt.core.dom.QualifiedType;
import org.greenrobot.eclipse.jdt.core.dom.SimpleName;
import org.greenrobot.eclipse.jdt.core.dom.SimpleType;
import org.greenrobot.eclipse.jdt.core.dom.Type;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 2,
   d1 = {"\u0000R\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0086\u0002\u001a\u0018\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0002\u001a\u001c\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018\u001a\u0010\u0010\u0019\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00020\u00150\u0014\u001a:\u0010\u001a\u001a\u00020\u0002*\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\u001a:\u0010 \u001a\u00020\u0002*\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\b\u001a\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\f\u001a\u00020\u0002*\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006#"},
   d2 = {"JavaLangTypes", "", "", "lineNumber", "", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "getLineNumber", "(Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;)Ljava/lang/Integer;", "qualifier", "Lorg/greenrobot/eclipse/jdt/core/dom/Name;", "getQualifier", "(Lorg/greenrobot/eclipse/jdt/core/dom/Name;)Ljava/lang/String;", "simpleName", "getSimpleName", "get", "Lorg/greenrobot/eclipse/jdt/core/dom/Expression;", "Lorg/greenrobot/eclipse/jdt/core/dom/NormalAnnotation;", "fieldName", "has", "", "", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "qualifiedName", "klass", "Lkotlin/reflect/KClass;", "isStrict", "resolveName", "outerClassName", "imports", "sourcePkg", "classesInPackage", "", "typeName", "Lorg/greenrobot/eclipse/jdt/core/dom/Type;", "containingClassIdentifier", "greendao-code-modifier_main"}
)
public final class JdtUtilsKt {
   private static final Set JavaLangTypes = SetsKt.setOf(new String[]{"Long", "Byte", "Integer", "Boolean", "Short", "Float", "Double", "String"});

   public static final boolean has(@NotNull Iterable $receiver, @NotNull String qualifiedName) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Intrinsics.checkParameterIsNotNull(qualifiedName, "qualifiedName");
      String packageName = StringsKt.substringBeforeLast(qualifiedName, '.', "");
      Iterator var4 = $receiver.iterator();

      boolean var10000;
      while(true) {
         if (!var4.hasNext()) {
            var10000 = false;
            break;
         }

         Object element$iv = var4.next();
         ImportDeclaration it = (ImportDeclaration)element$iv;
         Name name = it.getName();
         if (Intrinsics.areEqual(name.getFullyQualifiedName(), qualifiedName) || it.isOnDemand() && name instanceof QualifiedName && Intrinsics.areEqual(((QualifiedName)name).getFullyQualifiedName(), packageName)) {
            var10000 = true;
            break;
         }
      }

      return var10000;
   }

   @NotNull
   public static final String getSimpleName(@NotNull Name $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      String var10000;
      if ($receiver instanceof QualifiedName) {
         var10000 = ((QualifiedName)$receiver).getName().getFullyQualifiedName();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "this.name.fullyQualifiedName");
      } else {
         var10000 = $receiver.getFullyQualifiedName();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "this.fullyQualifiedName");
      }

      return var10000;
   }

   @NotNull
   public static final String getQualifier(@NotNull Name $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      String var10000;
      if ($receiver instanceof QualifiedName) {
         var10000 = ((QualifiedName)$receiver).getQualifier().getFullyQualifiedName();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "this.qualifier.fullyQualifiedName");
      } else {
         var10000 = "";
      }

      return var10000;
   }

   public static final boolean isStrict(@NotNull Iterable $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Iterator var2 = $receiver.iterator();

      boolean var10000;
      while(true) {
         if (!var2.hasNext()) {
            var10000 = true;
            break;
         }

         Object element$iv = var2.next();
         ImportDeclaration it = (ImportDeclaration)element$iv;
         if (it.isOnDemand() && !it.isStatic()) {
            var10000 = false;
            break;
         }
      }

      return var10000;
   }

   @NotNull
   public static final String resolveName(@NotNull Name $receiver, @Nullable String outerClassName, @NotNull Iterable imports, @Nullable String sourcePkg, @NotNull List classesInPackage) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Intrinsics.checkParameterIsNotNull(imports, "imports");
      Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage");
      String simpleName = $receiver.getFullyQualifiedName();
      String var15;
      if ($receiver instanceof SimpleName) {
         Iterator var8 = imports.iterator();

         Object var10000;
         while(true) {
            if (!var8.hasNext()) {
               var10000 = null;
               break;
            }

            Object var9 = var8.next();
            ImportDeclaration it = (ImportDeclaration)var9;
            if (Intrinsics.areEqual(getSimpleName(it.getName()), simpleName)) {
               var10000 = var9;
               break;
            }
         }

         ImportDeclaration var14 = (ImportDeclaration)var10000;
         if (var14 != null) {
            ImportDeclaration var6 = var14;
            ImportDeclaration it = (ImportDeclaration)var6;
            var15 = (String)it.getName().getFullyQualifiedName();
            if (var15 != null) {
               return var15;
            }
         }

         Name $receiver = (Name)$receiver;
         if (classesInPackage.contains(simpleName)) {
            var15 = sourcePkg != null ? sourcePkg + "." + simpleName : simpleName;
         } else if (isStrict(imports) && !JavaLangTypes.contains(simpleName)) {
            var15 = outerClassName != null ? (sourcePkg != null ? sourcePkg + "." + outerClassName + "." + simpleName : outerClassName + "." + simpleName) : simpleName;
         } else {
            if (!JavaLangTypes.contains(simpleName)) {
               throw (Throwable)(new IllegalArgumentException("Can't resolve qualified name for " + simpleName + ". " + "Try to not use on-demand imports or specify qualified name explicitly (line " + getLineNumber((ASTNode)$receiver) + ")"));
            }

            var15 = simpleName;
         }

         Intrinsics.checkExpressionValueIsNotNull(var15, "run {\n                //…          }\n            }");
         var15 = (String)var15;
      } else {
         if ($receiver instanceof QualifiedName) {
            char var12 = ((QualifiedName)$receiver).getFullyQualifiedName().charAt(0);
            if (Character.isUpperCase(var12)) {
               var15 = resolveName(((QualifiedName)$receiver).getQualifier(), outerClassName, imports, sourcePkg, classesInPackage) + "." + ((QualifiedName)$receiver).getName().getIdentifier();
               return var15;
            }
         }

         var15 = simpleName;
         Intrinsics.checkExpressionValueIsNotNull(simpleName, "simpleName");
      }

      return var15;
   }

   public static final boolean has(@NotNull Iterable $receiver, @NotNull KClass klass) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Intrinsics.checkParameterIsNotNull(klass, "klass");
      String var10000 = klass.getQualifiedName();
      boolean var5;
      if (var10000 != null) {
         String var2 = var10000;
         String it = (String)var2;
         var5 = has($receiver, it);
      } else {
         var5 = false;
      }

      return var5;
   }

   @Nullable
   public static final Expression get(@NotNull NormalAnnotation $receiver, @NotNull String fieldName) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Intrinsics.checkParameterIsNotNull(fieldName, "fieldName");
      Sequence var2 = SequencesKt.map(CollectionsKt.asSequence((Iterable)$receiver.values()), (Function1)null.INSTANCE);
      Iterator var4 = var2.iterator();

      Object var10000;
      while(true) {
         if (var4.hasNext()) {
            Object var5 = var4.next();
            MemberValuePair it = (MemberValuePair)var5;
            if (!Intrinsics.areEqual(it.getName().getIdentifier(), fieldName)) {
               continue;
            }

            var10000 = var5;
            break;
         }

         var10000 = null;
         break;
      }

      return (MemberValuePair)var10000 != null ? ((MemberValuePair)var10000).getValue() : null;
   }

   @NotNull
   public static final String typeName(@NotNull Type $receiver, @Nullable String containingClassIdentifier, @NotNull Iterable imports, @Nullable String sourcePkg, @NotNull List classesInPackage) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Intrinsics.checkParameterIsNotNull(imports, "imports");
      Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage");
      String var10000;
      if ($receiver instanceof SimpleType) {
         var10000 = resolveName(((SimpleType)$receiver).getName(), containingClassIdentifier, imports, sourcePkg, classesInPackage);
      } else if ($receiver instanceof ArrayType) {
         var10000 = typeName(((ArrayType)$receiver).getElementType(), (String)null, imports, sourcePkg, classesInPackage) + "[]";
      } else if ($receiver instanceof QualifiedType) {
         var10000 = typeName(((QualifiedType)$receiver).getQualifier(), (String)null, imports, sourcePkg, classesInPackage) + "." + ((QualifiedType)$receiver).getName().getIdentifier();
      } else if ($receiver instanceof ParameterizedType) {
         var10000 = typeName(((ParameterizedType)$receiver).getType(), (String)null, imports, sourcePkg, classesInPackage);
      } else {
         var10000 = $receiver.toString();
         Intrinsics.checkExpressionValueIsNotNull(var10000, "toString()");
      }

      return var10000;
   }

   @Nullable
   public static final Integer getLineNumber(@NotNull ASTNode $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      ASTNode root = $receiver.getRoot();
      return root instanceof CompilationUnit ? ((CompilationUnit)root).getLineNumber($receiver.getStartPosition()) : null;
   }
}
