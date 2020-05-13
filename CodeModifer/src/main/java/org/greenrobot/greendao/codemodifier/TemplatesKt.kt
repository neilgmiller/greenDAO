package org.greenrobot.greendao.codemodifier

import freemarker.template.Template
import java.io.StringWriter
import java.io.Writer
import kotlin.jvm.internal.Intrinsics

object TemplatesKt {
    operator fun invoke(template: Template, bindings: Map<*, *>): String {
        val writer = StringWriter()
        template.process(bindings, writer as Writer)
        return writer.toString()
    }
}