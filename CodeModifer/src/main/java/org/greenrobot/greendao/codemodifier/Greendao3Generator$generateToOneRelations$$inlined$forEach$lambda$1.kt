package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.generator.ToOne
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Lambda

internal class `Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$1`(// $FF: synthetic field
        val `$toOne`: ToOne, // $FF: synthetic field
        val `$transformer$inlined`: EntityClassTransformer, // $FF: synthetic field
        val `$parsedEntity$inlined`: ParsedEntity, // $FF: synthetic field
        val `$entity$inlined`: org.greenrobot.greendao.generator.Entity) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        if (`$parsedEntity$inlined`.notNullAnnotation == null && `$toOne`.fkProperties[0].isNotNull) {
            `$transformer$inlined`.ensureImport("org.greenrobot.greendao.annotation.NotNull")
        }
        val var10000 = Templates.Entity.INSTANCE
        val var10001 = `$toOne`
        Intrinsics.checkExpressionValueIsNotNull(var10001, "toOne")
        var var10002 = `$parsedEntity$inlined`.notNullAnnotation
        if (var10002 == null) {
            var10002 = "@NotNull"
        }
        return var10000.oneRelationSetter(var10001, var10002)
    }

}