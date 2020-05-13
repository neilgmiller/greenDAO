package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.Templates.Entity
import org.greenrobot.greendao.generator.ToOne
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

internal class `Greendao3Generator$generateToOneRelations$1$2`(// $FF: synthetic field
        val `$toOne`: ToOne) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        val var10000 = Entity.INSTANCE
        val var10001 = `$toOne`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toOne")
        return var10000.oneRelationPeek(var10001)
    }

}