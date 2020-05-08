package org.greenrobot.greendao.codemodifier;

import freemarker.template.Template;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 2,
   d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\u0002¨\u0006\u0006"},
   d2 = {"invoke", "", "Lfreemarker/template/Template;", "bindings", "", "", "greendao-code-modifier_main"}
)
public final class TemplatesKt {
   @NotNull
   public static final String invoke(@NotNull Template $receiver, @NotNull Map bindings) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Intrinsics.checkParameterIsNotNull(bindings, "bindings");
      StringWriter writer = new StringWriter();
      $receiver.process(bindings, (Writer)writer);
      String var10000 = writer.toString();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "writer.toString()");
      return var10000;
   }
}
