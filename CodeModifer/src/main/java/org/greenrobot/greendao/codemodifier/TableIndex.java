package org.greenrobot.greendao.codemodifier;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/TableIndex;", "", "name", "", "fields", "", "Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "unique", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getFields", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getUnique", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class TableIndex {
   @Nullable
   private final String name;
   @NotNull
   private final List fields;
   private final boolean unique;

   @Nullable
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final List getFields() {
      return this.fields;
   }

   public final boolean getUnique() {
      return this.unique;
   }

   public TableIndex(@Nullable String name, @NotNull List fields, boolean unique) {
      Intrinsics.checkParameterIsNotNull(fields, "fields");
      super();
      this.name = name;
      this.fields = fields;
      this.unique = unique;
   }

   @Nullable
   public final String component1() {
      return this.name;
   }

   @NotNull
   public final List component2() {
      return this.fields;
   }

   public final boolean component3() {
      return this.unique;
   }

   @NotNull
   public final TableIndex copy(@Nullable String name, @NotNull List fields, boolean unique) {
      Intrinsics.checkParameterIsNotNull(fields, "fields");
      return new TableIndex(name, fields, unique);
   }

   public String toString() {
      return "TableIndex(name=" + this.name + ", fields=" + this.fields + ", unique=" + this.unique + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      List var10001 = this.fields;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      byte var2 = this.unique;
      if (var2 != 0) {
         var2 = 1;
      }

      return var1 + var2;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof TableIndex) {
            TableIndex var2 = (TableIndex)var1;
            if (Intrinsics.areEqual(this.name, var2.name) && Intrinsics.areEqual(this.fields, var2.fields) && this.unique == var2.unique) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
