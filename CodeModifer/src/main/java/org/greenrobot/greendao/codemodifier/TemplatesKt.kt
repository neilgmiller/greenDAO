package org.greenrobot.greendao.codemodifier

import freemarker.template.Template
import java.io.StringWriter
import java.io.Writer
import kotlin.jvm.internal.Intrinsics

object TemplatesKt {
    operator fun invoke(`$receiver`: Template, bindings: Map<*, *>): String {
        Intrinsics.checkParameterIsNotNull(`$receiver`, "\$receiver")
        Intrinsics.checkParameterIsNotNull(bindings, "bindings")
        val writer = StringWriter()
        `$receiver`.process(bindings, writer as Writer)
        val var10000 = writer.toString()
        Intrinsics.checkExpressionValueIsNotNull(var10000, "writer.toString()")
        return var10000
    }
}