package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.Templates.Entity
import org.greenrobot.greendao.generator.ToOne
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 3, d1 = ["\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"], d2 = ["<anonymous>", "", "invoke"])
internal class `Greendao3Generator$generateToOneRelations$1$2`(// $FF: synthetic field
        val `$toOne`: ToOne) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        val var10000 = Entity.INSTANCE
        val var10001 = `$toOne`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toOne")
        return var10000.oneRelationPeek(var10001)
    }

}