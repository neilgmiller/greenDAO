package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.generator.ToManyBase
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

internal class `Greendao3Generator$generateToManyRelations$$inlined$forEach$lambda$1`(// $FF: synthetic field
        val `$toMany`: ToManyBase, // $FF: synthetic field
        val `$transformer$inlined`: EntityClassTransformer, // $FF: synthetic field
        val `$entity$inlined`: org.greenrobot.greendao.generator.Entity) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        val var10000 = Templates.Entity.INSTANCE
        val var10001 = `$toMany`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toMany")
        return var10000.manyRelationGetter(var10001, `$entity$inlined`)
    }

}