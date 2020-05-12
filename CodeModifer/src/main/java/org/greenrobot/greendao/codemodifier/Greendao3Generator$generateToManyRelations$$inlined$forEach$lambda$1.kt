package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.Templates.entity
import org.greenrobot.greendao.generator.Entity
import org.greenrobot.greendao.generator.ToManyBase
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 3, d1 = ["\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"], d2 = ["<anonymous>", "", "invoke"])
internal class `Greendao3Generator$generateToManyRelations$$inlined$forEach$lambda$1`(// $FF: synthetic field
        val `$toMany`: ToManyBase, // $FF: synthetic field
        val `$transformer$inlined`: EntityClassTransformer, // $FF: synthetic field
        val `$entity$inlined`: Entity) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        val var10000 = entity.INSTANCE
        val var10001 = `$toMany`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toMany")
        return var10000.manyRelationGetter(var10001, `$entity$inlined`)
    }

}