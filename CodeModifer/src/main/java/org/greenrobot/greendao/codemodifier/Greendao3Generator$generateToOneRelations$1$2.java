package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.greendao.generator.ToOne;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 3,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"},
   d2 = {"<anonymous>", "", "invoke"}
)
final class Greendao3Generator$generateToOneRelations$1$2 extends Lambda implements Function0 {
   // $FF: synthetic field
   final ToOne $toOne;

   @NotNull
   public final String invoke() {
      Templates.entity var10000 = Templates.entity.INSTANCE;
      ToOne var10001 = this.$toOne;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "toOne");
      return var10000.oneRelationPeek(var10001);
   }

   Greendao3Generator$generateToOneRelations$1$2(ToOne var1) {
      super(0);
      this.$toOne = var1;
   }
}
