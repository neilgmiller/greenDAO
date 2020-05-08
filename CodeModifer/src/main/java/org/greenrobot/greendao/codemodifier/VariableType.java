package org.greenrobot.greendao.codemodifier;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bHÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/VariableType;", "", "name", "", "isPrimitive", "", "originalName", "typeArguments", "", "(Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "()Z", "getName", "()Ljava/lang/String;", "getOriginalName", "simpleName", "getSimpleName", "getTypeArguments", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class VariableType {
   @NotNull
   private final String name;
   private final boolean isPrimitive;
   @NotNull
   private final String originalName;
   @Nullable
   private final List typeArguments;

   @NotNull
   public final String getSimpleName() {
      return StringsKt.substringAfterLast$default(this.name, '.', (String)null, 2, (Object)null);
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   public final boolean isPrimitive() {
      return this.isPrimitive;
   }

   @NotNull
   public final String getOriginalName() {
      return this.originalName;
   }

   @Nullable
   public final List getTypeArguments() {
      return this.typeArguments;
   }

   public VariableType(@NotNull String name, boolean isPrimitive, @NotNull String originalName, @Nullable List typeArguments) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(originalName, "originalName");
      super();
      this.name = name;
      this.isPrimitive = isPrimitive;
      this.originalName = originalName;
      this.typeArguments = typeArguments;
   }

   // $FF: synthetic method
   public VariableType(String var1, boolean var2, String var3, List var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = (List)null;
      }

      this(var1, var2, var3, var4);
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   public final boolean component2() {
      return this.isPrimitive;
   }

   @NotNull
   public final String component3() {
      return this.originalName;
   }

   @Nullable
   public final List component4() {
      return this.typeArguments;
   }

   @NotNull
   public final VariableType copy(@NotNull String name, boolean isPrimitive, @NotNull String originalName, @Nullable List typeArguments) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(originalName, "originalName");
      return new VariableType(name, isPrimitive, originalName, typeArguments);
   }

   public String toString() {
      return "VariableType(name=" + this.name + ", isPrimitive=" + this.isPrimitive + ", originalName=" + this.originalName + ", typeArguments=" + this.typeArguments + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      byte var10001 = this.isPrimitive;
      if (var10001 != 0) {
         var10001 = 1;
      }

      var1 = (var1 + var10001) * 31;
      String var2 = this.originalName;
      var1 = (var1 + (var2 != null ? var2.hashCode() : 0)) * 31;
      List var3 = this.typeArguments;
      return var1 + (var3 != null ? var3.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof VariableType) {
            VariableType var2 = (VariableType)var1;
            if (Intrinsics.areEqual(this.name, var2.name) && this.isPrimitive == var2.isPrimitive && Intrinsics.areEqual(this.originalName, var2.originalName) && Intrinsics.areEqual(this.typeArguments, var2.typeArguments)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
