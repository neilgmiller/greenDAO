package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/CustomType;", "", "converterClassName", "", "columnJavaType", "Lorg/greenrobot/greendao/codemodifier/VariableType;", "(Ljava/lang/String;Lorg/greenrobot/greendao/codemodifier/VariableType;)V", "getColumnJavaType", "()Lorg/greenrobot/greendao/codemodifier/VariableType;", "getConverterClassName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class CustomType {
   @NotNull
   private final String converterClassName;
   @NotNull
   private final VariableType columnJavaType;

   @NotNull
   public final String getConverterClassName() {
      return this.converterClassName;
   }

   @NotNull
   public final VariableType getColumnJavaType() {
      return this.columnJavaType;
   }

   public CustomType(@NotNull String converterClassName, @NotNull VariableType columnJavaType) {
      Intrinsics.checkParameterIsNotNull(converterClassName, "converterClassName");
      Intrinsics.checkParameterIsNotNull(columnJavaType, "columnJavaType");
      super();
      this.converterClassName = converterClassName;
      this.columnJavaType = columnJavaType;
   }

   @NotNull
   public final String component1() {
      return this.converterClassName;
   }

   @NotNull
   public final VariableType component2() {
      return this.columnJavaType;
   }

   @NotNull
   public final CustomType copy(@NotNull String converterClassName, @NotNull VariableType columnJavaType) {
      Intrinsics.checkParameterIsNotNull(converterClassName, "converterClassName");
      Intrinsics.checkParameterIsNotNull(columnJavaType, "columnJavaType");
      return new CustomType(converterClassName, columnJavaType);
   }

   public String toString() {
      return "CustomType(converterClassName=" + this.converterClassName + ", columnJavaType=" + this.columnJavaType + ")";
   }

   public int hashCode() {
      String var10000 = this.converterClassName;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      VariableType var10001 = this.columnJavaType;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof CustomType) {
            CustomType var2 = (CustomType)var1;
            if (Intrinsics.areEqual(this.converterClassName, var2.converterClassName) && Intrinsics.areEqual(this.columnJavaType, var2.columnJavaType)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
