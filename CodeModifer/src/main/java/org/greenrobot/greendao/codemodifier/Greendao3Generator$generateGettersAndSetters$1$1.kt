package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Lambda

internal class `Greendao3Generator$generateGettersAndSetters$1$1`(// $FF: synthetic field
        val `$field`: ParsedProperty) : Lambda(0), Function0<Any?> {

    override fun invoke(): String {
        return Templates.Entity.INSTANCE.fieldSet(`$field`.variable)
    }

}