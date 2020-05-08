package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/JoinOnProperty;", "", "source", "", "target", "(Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getTarget", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class JoinOnProperty {
   @NotNull
   private final String source;
   @NotNull
   private final String target;

   @NotNull
   public final String getSource() {
      return this.source;
   }

   @NotNull
   public final String getTarget() {
      return this.target;
   }

   public JoinOnProperty(@NotNull String source, @NotNull String target) {
      Intrinsics.checkParameterIsNotNull(source, "source");
      Intrinsics.checkParameterIsNotNull(target, "target");
      super();
      this.source = source;
      this.target = target;
   }

   @NotNull
   public final String component1() {
      return this.source;
   }

   @NotNull
   public final String component2() {
      return this.target;
   }

   @NotNull
   public final JoinOnProperty copy(@NotNull String source, @NotNull String target) {
      Intrinsics.checkParameterIsNotNull(source, "source");
      Intrinsics.checkParameterIsNotNull(target, "target");
      return new JoinOnProperty(source, target);
   }

   public String toString() {
      return "JoinOnProperty(source=" + this.source + ", target=" + this.target + ")";
   }

   public int hashCode() {
      String var10000 = this.source;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.target;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof JoinOnProperty) {
            JoinOnProperty var2 = (JoinOnProperty)var1;
            if (Intrinsics.areEqual(this.source, var2.source) && Intrinsics.areEqual(this.target, var2.target)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
