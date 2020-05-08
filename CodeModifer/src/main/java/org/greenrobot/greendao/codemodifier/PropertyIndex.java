package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/PropertyIndex;", "", "name", "", "unique", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getUnique", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class PropertyIndex {
   @Nullable
   private final String name;
   private final boolean unique;

   @Nullable
   public final String getName() {
      return this.name;
   }

   public final boolean getUnique() {
      return this.unique;
   }

   public PropertyIndex(@Nullable String name, boolean unique) {
      this.name = name;
      this.unique = unique;
   }

   @Nullable
   public final String component1() {
      return this.name;
   }

   public final boolean component2() {
      return this.unique;
   }

   @NotNull
   public final PropertyIndex copy(@Nullable String name, boolean unique) {
      return new PropertyIndex(name, unique);
   }

   public String toString() {
      return "PropertyIndex(name=" + this.name + ", unique=" + this.unique + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      byte var10001 = this.unique;
      if (var10001 != 0) {
         var10001 = 1;
      }

      return var1 + var10001;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof PropertyIndex) {
            PropertyIndex var2 = (PropertyIndex)var1;
            if (Intrinsics.areEqual(this.name, var2.name) && this.unique == var2.unique) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
