package org.greenrobot.greendao.codemodifier;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/ManyRelation;", "", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "mappedBy", "", "joinOnProperties", "", "Lorg/greenrobot/greendao/codemodifier/JoinOnProperty;", "joinEntitySpec", "Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;", "order", "Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "(Lorg/greenrobot/greendao/codemodifier/Variable;Ljava/lang/String;Ljava/util/List;Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;Ljava/util/List;)V", "getJoinEntitySpec", "()Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;", "getJoinOnProperties", "()Ljava/util/List;", "getMappedBy", "()Ljava/lang/String;", "getOrder", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class ManyRelation {
   @NotNull
   private final Variable variable;
   @Nullable
   private final String mappedBy;
   @NotNull
   private final List joinOnProperties;
   @Nullable
   private final JoinEntitySpec joinEntitySpec;
   @Nullable
   private final List order;

   @NotNull
   public final Variable getVariable() {
      return this.variable;
   }

   @Nullable
   public final String getMappedBy() {
      return this.mappedBy;
   }

   @NotNull
   public final List getJoinOnProperties() {
      return this.joinOnProperties;
   }

   @Nullable
   public final JoinEntitySpec getJoinEntitySpec() {
      return this.joinEntitySpec;
   }

   @Nullable
   public final List getOrder() {
      return this.order;
   }

   public ManyRelation(@NotNull Variable variable, @Nullable String mappedBy, @NotNull List joinOnProperties, @Nullable JoinEntitySpec joinEntitySpec, @Nullable List order) {
      Intrinsics.checkParameterIsNotNull(variable, "variable");
      Intrinsics.checkParameterIsNotNull(joinOnProperties, "joinOnProperties");
      super();
      this.variable = variable;
      this.mappedBy = mappedBy;
      this.joinOnProperties = joinOnProperties;
      this.joinEntitySpec = joinEntitySpec;
      this.order = order;
   }

   // $FF: synthetic method
   public ManyRelation(Variable var1, String var2, List var3, JoinEntitySpec var4, List var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 2) != 0) {
         var2 = (String)null;
      }

      if ((var6 & 4) != 0) {
         var3 = CollectionsKt.emptyList();
      }

      if ((var6 & 8) != 0) {
         var4 = (JoinEntitySpec)null;
      }

      if ((var6 & 16) != 0) {
         var5 = (List)null;
      }

      this(var1, var2, var3, var4, var5);
   }

   @NotNull
   public final Variable component1() {
      return this.variable;
   }

   @Nullable
   public final String component2() {
      return this.mappedBy;
   }

   @NotNull
   public final List component3() {
      return this.joinOnProperties;
   }

   @Nullable
   public final JoinEntitySpec component4() {
      return this.joinEntitySpec;
   }

   @Nullable
   public final List component5() {
      return this.order;
   }

   @NotNull
   public final ManyRelation copy(@NotNull Variable variable, @Nullable String mappedBy, @NotNull List joinOnProperties, @Nullable JoinEntitySpec joinEntitySpec, @Nullable List order) {
      Intrinsics.checkParameterIsNotNull(variable, "variable");
      Intrinsics.checkParameterIsNotNull(joinOnProperties, "joinOnProperties");
      return new ManyRelation(variable, mappedBy, joinOnProperties, joinEntitySpec, order);
   }

   public String toString() {
      return "ManyRelation(variable=" + this.variable + ", mappedBy=" + this.mappedBy + ", joinOnProperties=" + this.joinOnProperties + ", joinEntitySpec=" + this.joinEntitySpec + ", order=" + this.order + ")";
   }

   public int hashCode() {
      Variable var10000 = this.variable;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.mappedBy;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      List var2 = this.joinOnProperties;
      var1 = (var1 + (var2 != null ? var2.hashCode() : 0)) * 31;
      JoinEntitySpec var3 = this.joinEntitySpec;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var2 = this.order;
      return var1 + (var2 != null ? var2.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof ManyRelation) {
            ManyRelation var2 = (ManyRelation)var1;
            if (Intrinsics.areEqual(this.variable, var2.variable) && Intrinsics.areEqual(this.mappedBy, var2.mappedBy) && Intrinsics.areEqual(this.joinOnProperties, var2.joinOnProperties) && Intrinsics.areEqual(this.joinEntitySpec, var2.joinEntitySpec) && Intrinsics.areEqual(this.order, var2.order)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
