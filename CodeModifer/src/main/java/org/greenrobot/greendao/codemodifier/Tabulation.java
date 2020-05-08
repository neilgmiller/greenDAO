package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Tabulation;", "", "tabChar", "", "size", "", "(CI)V", "getSize", "()I", "getTabChar", "()C", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "greendao-code-modifier_main"}
)
public final class Tabulation {
   private final char tabChar;
   private final int size;

   public final char getTabChar() {
      return this.tabChar;
   }

   public final int getSize() {
      return this.size;
   }

   public Tabulation(char tabChar, int size) {
      this.tabChar = tabChar;
      this.size = size;
   }

   public final char component1() {
      return this.tabChar;
   }

   public final int component2() {
      return this.size;
   }

   @NotNull
   public final Tabulation copy(char tabChar, int size) {
      return new Tabulation(tabChar, size);
   }

   public String toString() {
      return "Tabulation(tabChar=" + this.tabChar + ", size=" + this.size + ")";
   }

   public int hashCode() {
      return this.tabChar * 31 + this.size;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof Tabulation) {
            Tabulation var2 = (Tabulation)var1;
            if (this.tabChar == var2.tabChar && this.size == var2.size) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
