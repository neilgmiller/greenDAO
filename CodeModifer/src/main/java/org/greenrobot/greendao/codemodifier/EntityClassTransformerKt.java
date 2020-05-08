package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 2,
   d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
   d2 = {"HASH_STUB", "", "getHASH_STUB", "()Ljava/lang/String;", "greendao-code-modifier_main"}
)
public final class EntityClassTransformerKt {
   @NotNull
   private static final String HASH_STUB = "GENERATED_HASH_STUB";

   @NotNull
   public static final String getHASH_STUB() {
      return HASH_STUB;
   }
}
