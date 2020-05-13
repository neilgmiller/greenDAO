package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.generator.ToOne
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

internal class `Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$2`(// $FF: synthetic field
        val `$toOne`: ToOne, // $FF: synthetic field
        val `$transformer$inlined`: EntityClassTransformer, // $FF: synthetic field
        val `$parsedEntity$inlined`: ParsedEntity, // $FF: synthetic field
        val `$entity$inlined`: org.greenrobot.greendao.generator.Entity) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        val var10000 = Templates.Entity.INSTANCE
        val var10001 = `$toOne`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toOne")
        return var10000.oneRelationGetter(var10001, `$entity$inlined`)
    }

}