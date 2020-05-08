package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "", "()V", "Generated", "Keep", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint$Keep;", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint$Generated;", "greendao-code-modifier_main"}
)
public abstract class GeneratorHint {
   private GeneratorHint() {
   }

   // $FF: synthetic method
   public GeneratorHint(DefaultConstructorMarker $constructor_marker) {
      this();
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/GeneratorHint$Keep;", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "()V", "greendao-code-modifier_main"}
   )
   public static final class Keep extends GeneratorHint {
      public static final GeneratorHint.Keep INSTANCE;

      private Keep() {
         super((DefaultConstructorMarker)null);
         INSTANCE = (GeneratorHint.Keep)this;
      }

      static {
         new GeneratorHint.Keep();
      }
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/GeneratorHint$Generated;", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "hash", "", "(I)V", "getHash", "()I", "equals", "", "other", "", "hashCode", "toString", "", "greendao-code-modifier_main"}
   )
   public static final class Generated extends GeneratorHint {
      private final int hash;

      public boolean equals(@Nullable Object other) {
         if ((GeneratorHint.Generated)this == other) {
            return true;
         } else if (!(other instanceof GeneratorHint.Generated)) {
            return false;
         } else {
            return this.hash == ((GeneratorHint.Generated)other).hash;
         }
      }

      public int hashCode() {
         return this.hash;
      }

      @NotNull
      public String toString() {
         return "Generated(hash=" + this.hash + ")";
      }

      public final int getHash() {
         return this.hash;
      }

      public Generated(int hash) {
         super((DefaultConstructorMarker)null);
         this.hash = hash;
      }
   }
}
