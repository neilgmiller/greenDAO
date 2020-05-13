package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.Templates.Entity
import org.greenrobot.greendao.generator.ToManyBase
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

internal class `Greendao3Generator$generateToManyRelations$1$1`(// $FF: synthetic field
        val `$toMany`: ToManyBase) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        val var10000 = Entity.INSTANCE
        val var10001 = `$toMany`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toMany")
        return var10000.manyRelationReset(var10001)
    }

}