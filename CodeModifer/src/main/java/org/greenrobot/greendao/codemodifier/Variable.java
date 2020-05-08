package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Variable;", "", "type", "Lorg/greenrobot/greendao/codemodifier/VariableType;", "name", "", "(Lorg/greenrobot/greendao/codemodifier/VariableType;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getType", "()Lorg/greenrobot/greendao/codemodifier/VariableType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class Variable {
   @NotNull
   private final VariableType type;
   @NotNull
   private final String name;

   @NotNull
   public final VariableType getType() {
      return this.type;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public Variable(@NotNull VariableType type, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.type = type;
      this.name = name;
   }

   @NotNull
   public final VariableType component1() {
      return this.type;
   }

   @NotNull
   public final String component2() {
      return this.name;
   }

   @NotNull
   public final Variable copy(@NotNull VariableType type, @NotNull String name) {
      Intrinsics.checkParameterIsNotNull(type, "type");
      Intrinsics.checkParameterIsNotNull(name, "name");
      return new Variable(type, name);
   }

   public String toString() {
      return "Variable(type=" + this.type + ", name=" + this.name + ")";
   }

   public int hashCode() {
      VariableType var10000 = this.type;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.name;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof Variable) {
            Variable var2 = (Variable)var1;
            if (Intrinsics.areEqual(this.type, var2.type) && Intrinsics.areEqual(this.name, var2.name)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
