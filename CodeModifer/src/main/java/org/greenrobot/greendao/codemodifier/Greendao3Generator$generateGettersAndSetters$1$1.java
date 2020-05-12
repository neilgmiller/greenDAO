package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 3,
   d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"},
   d2 = {"<anonymous>", "", "invoke"}
)
final class Greendao3Generator$generateGettersAndSetters$1$1 extends Lambda implements Function0 {
   // $FF: synthetic field
   final ParsedProperty $field;

   @NotNull
   public final String invoke() {
      return Templates.entity.INSTANCE.fieldSet(this.$field.variable);
   }

   Greendao3Generator$generateGettersAndSetters$1$1(ParsedProperty var1) {
      super(0);
      this.$field = var1;
   }
}
