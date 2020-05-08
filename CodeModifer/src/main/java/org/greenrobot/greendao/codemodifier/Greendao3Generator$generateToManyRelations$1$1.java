package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.greendao.generator.ToManyBase;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 3,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"},
   d2 = {"<anonymous>", "", "invoke"}
)
final class Greendao3Generator$generateToManyRelations$1$1 extends Lambda implements Function0 {
   // $FF: synthetic field
   final ToManyBase $toMany;

   @NotNull
   public final String invoke() {
      Templates.entity var10000 = Templates.entity.INSTANCE;
      ToManyBase var10001 = this.$toMany;
      Intrinsics.checkExpressionValueIsNotNull(var10001, "toMany");
      return var10000.manyRelationReset(var10001);
   }

   Greendao3Generator$generateToManyRelations$1$1(ToManyBase var1) {
      super(0);
      this.$toMany = var1;
   }
}
