package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/JoinEntitySpec;", "", "entityName", "", "sourceIdProperty", "targetIdProperty", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntityName", "()Ljava/lang/String;", "getSourceIdProperty", "getTargetIdProperty", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class JoinEntitySpec {
   @NotNull
   private final String entityName;
   @NotNull
   private final String sourceIdProperty;
   @NotNull
   private final String targetIdProperty;

   @NotNull
   public final String getEntityName() {
      return this.entityName;
   }

   @NotNull
   public final String getSourceIdProperty() {
      return this.sourceIdProperty;
   }

   @NotNull
   public final String getTargetIdProperty() {
      return this.targetIdProperty;
   }

   public JoinEntitySpec(@NotNull String entityName, @NotNull String sourceIdProperty, @NotNull String targetIdProperty) {
      Intrinsics.checkParameterIsNotNull(entityName, "entityName");
      Intrinsics.checkParameterIsNotNull(sourceIdProperty, "sourceIdProperty");
      Intrinsics.checkParameterIsNotNull(targetIdProperty, "targetIdProperty");
      super();
      this.entityName = entityName;
      this.sourceIdProperty = sourceIdProperty;
      this.targetIdProperty = targetIdProperty;
   }

   @NotNull
   public final String component1() {
      return this.entityName;
   }

   @NotNull
   public final String component2() {
      return this.sourceIdProperty;
   }

   @NotNull
   public final String component3() {
      return this.targetIdProperty;
   }

   @NotNull
   public final JoinEntitySpec copy(@NotNull String entityName, @NotNull String sourceIdProperty, @NotNull String targetIdProperty) {
      Intrinsics.checkParameterIsNotNull(entityName, "entityName");
      Intrinsics.checkParameterIsNotNull(sourceIdProperty, "sourceIdProperty");
      Intrinsics.checkParameterIsNotNull(targetIdProperty, "targetIdProperty");
      return new JoinEntitySpec(entityName, sourceIdProperty, targetIdProperty);
   }

   public String toString() {
      return "JoinEntitySpec(entityName=" + this.entityName + ", sourceIdProperty=" + this.sourceIdProperty + ", targetIdProperty=" + this.targetIdProperty + ")";
   }

   public int hashCode() {
      String var10000 = this.entityName;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.sourceIdProperty;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.targetIdProperty;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof JoinEntitySpec) {
            JoinEntitySpec var2 = (JoinEntitySpec)var1;
            if (Intrinsics.areEqual(this.entityName, var2.entityName) && Intrinsics.areEqual(this.sourceIdProperty, var2.sourceIdProperty) && Intrinsics.areEqual(this.targetIdProperty, var2.targetIdProperty)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
