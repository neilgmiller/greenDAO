package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/EntityIdParams;", "", "autoincrement", "", "(Z)V", "getAutoincrement", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "greendao-code-modifier_main"}
)
public final class EntityIdParams {
   private final boolean autoincrement;

   public final boolean getAutoincrement() {
      return this.autoincrement;
   }

   public EntityIdParams(boolean autoincrement) {
      this.autoincrement = autoincrement;
   }

   public final boolean component1() {
      return this.autoincrement;
   }

   @NotNull
   public final EntityIdParams copy(boolean autoincrement) {
      return new EntityIdParams(autoincrement);
   }

   public String toString() {
      return "EntityIdParams(autoincrement=" + this.autoincrement + ")";
   }

   public int hashCode() {
      byte var10000 = this.autoincrement;
      if (var10000 != 0) {
         var10000 = 1;
      }

      return var10000;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof EntityIdParams) {
            EntityIdParams var2 = (EntityIdParams)var1;
            if (this.autoincrement == var2.autoincrement) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
