package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/OneRelation;", "", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "foreignKeyField", "", "columnName", "isNotNull", "", "unique", "(Lorg/greenrobot/greendao/codemodifier/Variable;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getColumnName", "()Ljava/lang/String;", "getForeignKeyField", "()Z", "getUnique", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class OneRelation {
   @NotNull
   private final Variable variable;
   @Nullable
   private final String foreignKeyField;
   @Nullable
   private final String columnName;
   private final boolean isNotNull;
   private final boolean unique;

   @NotNull
   public final Variable getVariable() {
      return this.variable;
   }

   @Nullable
   public final String getForeignKeyField() {
      return this.foreignKeyField;
   }

   @Nullable
   public final String getColumnName() {
      return this.columnName;
   }

   public final boolean isNotNull() {
      return this.isNotNull;
   }

   public final boolean getUnique() {
      return this.unique;
   }

   public OneRelation(@NotNull Variable variable, @Nullable String foreignKeyField, @Nullable String columnName, boolean isNotNull, boolean unique) {
      Intrinsics.checkParameterIsNotNull(variable, "variable");
      super();
      this.variable = variable;
      this.foreignKeyField = foreignKeyField;
      this.columnName = columnName;
      this.isNotNull = isNotNull;
      this.unique = unique;
   }

   // $FF: synthetic method
   public OneRelation(Variable var1, String var2, String var3, boolean var4, boolean var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 2) != 0) {
         var2 = (String)null;
      }

      if ((var6 & 4) != 0) {
         var3 = (String)null;
      }

      if ((var6 & 8) != 0) {
         var4 = false;
      }

      if ((var6 & 16) != 0) {
         var5 = false;
      }

      this(var1, var2, var3, var4, var5);
   }

   @NotNull
   public final Variable component1() {
      return this.variable;
   }

   @Nullable
   public final String component2() {
      return this.foreignKeyField;
   }

   @Nullable
   public final String component3() {
      return this.columnName;
   }

   public final boolean component4() {
      return this.isNotNull;
   }

   public final boolean component5() {
      return this.unique;
   }

   @NotNull
   public final OneRelation copy(@NotNull Variable variable, @Nullable String foreignKeyField, @Nullable String columnName, boolean isNotNull, boolean unique) {
      Intrinsics.checkParameterIsNotNull(variable, "variable");
      return new OneRelation(variable, foreignKeyField, columnName, isNotNull, unique);
   }

   public String toString() {
      return "OneRelation(variable=" + this.variable + ", foreignKeyField=" + this.foreignKeyField + ", columnName=" + this.columnName + ", isNotNull=" + this.isNotNull + ", unique=" + this.unique + ")";
   }

   public int hashCode() {
      Variable var10000 = this.variable;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.foreignKeyField;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.columnName;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      byte var2 = this.isNotNull;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      var2 = this.unique;
      if (var2 != 0) {
         var2 = 1;
      }

      return var1 + var2;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof OneRelation) {
            OneRelation var2 = (OneRelation)var1;
            if (Intrinsics.areEqual(this.variable, var2.variable) && Intrinsics.areEqual(this.foreignKeyField, var2.foreignKeyField) && Intrinsics.areEqual(this.columnName, var2.columnName) && this.isNotNull == var2.isNotNull && this.unique == var2.unique) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
