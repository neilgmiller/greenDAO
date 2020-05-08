package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "", "name", "", "order", "Lorg/greenrobot/greendao/codemodifier/Order;", "(Ljava/lang/String;Lorg/greenrobot/greendao/codemodifier/Order;)V", "getName", "()Ljava/lang/String;", "getOrder", "()Lorg/greenrobot/greendao/codemodifier/Order;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class OrderProperty {
   @NotNull
   private final String name;
   @NotNull
   private final Order order;

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final Order getOrder() {
      return this.order;
   }

   public OrderProperty(@NotNull String name, @NotNull Order order) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(order, "order");
      super();
      this.name = name;
      this.order = order;
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   @NotNull
   public final Order component2() {
      return this.order;
   }

   @NotNull
   public final OrderProperty copy(@NotNull String name, @NotNull Order order) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(order, "order");
      return new OrderProperty(name, order);
   }

   public String toString() {
      return "OrderProperty(name=" + this.name + ", order=" + this.order + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      Order var10001 = this.order;
      return var1 + (var10001 != null ? var10001.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof OrderProperty) {
            OrderProperty var2 = (OrderProperty)var1;
            if (Intrinsics.areEqual(this.name, var2.name) && Intrinsics.areEqual(this.order, var2.order)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
