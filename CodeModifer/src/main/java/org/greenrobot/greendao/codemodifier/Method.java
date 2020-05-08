package org.greenrobot.greendao.codemodifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u001c\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\b\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006$"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Method;", "Lorg/greenrobot/greendao/codemodifier/Generatable;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "name", "", "parameters", "", "Lorg/greenrobot/greendao/codemodifier/Variable;", "node", "hint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "(Ljava/lang/String;Ljava/util/List;Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;Lorg/greenrobot/greendao/codemodifier/GeneratorHint;)V", "getHint", "()Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "getName", "()Ljava/lang/String;", "getNode", "()Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "getParameters", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hasFullSignature", "params", "hasSignature", "paramsTypes", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class Method implements Generatable {
   @NotNull
   private final String name;
   @NotNull
   private final List parameters;
   @NotNull
   private final MethodDeclaration node;
   @Nullable
   private final GeneratorHint hint;

   public final boolean hasSignature(@NotNull String name, @NotNull List paramsTypes) {
      boolean var10000;
      label45: {
         Intrinsics.checkParameterIsNotNull(name, "name");
         Intrinsics.checkParameterIsNotNull(paramsTypes, "paramsTypes");
         if (Intrinsics.areEqual(this.name, name)) {
            Iterable $receiver$iv = (Iterable)this.parameters;
            Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
            Iterator var6 = $receiver$iv.iterator();

            Object item$iv$iv;
            Variable it;
            String var13;
            while(var6.hasNext()) {
               item$iv$iv = var6.next();
               it = (Variable)item$iv$iv;
               var13 = it.getType().getName();
               destination$iv$iv.add(var13);
            }

            if (Intrinsics.areEqual((List)destination$iv$iv, paramsTypes)) {
               break label45;
            }

            $receiver$iv = (Iterable)this.parameters;
            destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
            var6 = $receiver$iv.iterator();

            while(true) {
               if (!var6.hasNext()) {
                  if (Intrinsics.areEqual((List)destination$iv$iv, paramsTypes)) {
                     break label45;
                  }
                  break;
               }

               item$iv$iv = var6.next();
               it = (Variable)item$iv$iv;
               var13 = it.getType().getSimpleName();
               destination$iv$iv.add(var13);
            }
         }

         var10000 = false;
         return var10000;
      }

      var10000 = true;
      return var10000;
   }

   public final boolean hasFullSignature(@NotNull String name, @NotNull List params) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(params, "params");
      return Intrinsics.areEqual(this.name, name) && Intrinsics.areEqual(this.parameters, params);
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final List getParameters() {
      return this.parameters;
   }

   @NotNull
   public MethodDeclaration getNode() {
      return this.node;
   }

   @Nullable
   public GeneratorHint getHint() {
      return this.hint;
   }

   public Method(@NotNull String name, @NotNull List parameters, @NotNull MethodDeclaration node, @Nullable GeneratorHint hint) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(parameters, "parameters");
      Intrinsics.checkParameterIsNotNull(node, "node");
      super();
      this.name = name;
      this.parameters = parameters;
      this.node = node;
      this.hint = hint;
   }

   public boolean getGenerated() {
      return Generatable.DefaultImpls.getGenerated(this);
   }

   public boolean getKeep() {
      return Generatable.DefaultImpls.getKeep(this);
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   @NotNull
   public final List component2() {
      return this.parameters;
   }

   @NotNull
   public final MethodDeclaration component3() {
      return this.getNode();
   }

   @Nullable
   public final GeneratorHint component4() {
      return this.getHint();
   }

   @NotNull
   public final Method copy(@NotNull String name, @NotNull List parameters, @NotNull MethodDeclaration node, @Nullable GeneratorHint hint) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(parameters, "parameters");
      Intrinsics.checkParameterIsNotNull(node, "node");
      return new Method(name, parameters, node, hint);
   }

   public String toString() {
      return "Method(name=" + this.name + ", parameters=" + this.parameters + ", node=" + this.getNode() + ", hint=" + this.getHint() + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      List var10001 = this.parameters;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      MethodDeclaration var2 = this.getNode();
      var1 = (var1 + (var2 != null ? var2.hashCode() : 0)) * 31;
      GeneratorHint var3 = this.getHint();
      return var1 + (var3 != null ? var3.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof Method) {
            Method var2 = (Method)var1;
            if (Intrinsics.areEqual(this.name, var2.name) && Intrinsics.areEqual(this.parameters, var2.parameters) && Intrinsics.areEqual(this.getNode(), var2.getNode()) && Intrinsics.areEqual(this.getHint(), var2.getHint())) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
