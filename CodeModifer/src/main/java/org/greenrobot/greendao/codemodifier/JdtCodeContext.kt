package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.JavaCore
import java.io.File
import java.nio.charset.Charset
import java.util.*

class JdtCodeContext(val formattingOptions: FormattingOptions?, encoding: String) {
    private val jdtOptions: Hashtable<String, String> = JavaCore.getOptions()
    private val classParser: EntityClassParser

    fun parse(javaFile: File, classesInPackage: List<*>): ParsedEntity? =
            classParser.parse(javaFile, classesInPackage)

    fun transformer(parsedEntity: ParsedEntity): EntityClassTransformer =
            EntityClassTransformer(parsedEntity, jdtOptions, formattingOptions, (null as Charset?)!!, 8)

    init {
        jdtOptions["org.greenrobot.eclipse.jdt.core.compiler.source"] = JAVA_LEVEL
        jdtOptions["org.greenrobot.eclipse.jdt.core.compiler.compliance"] = JAVA_LEVEL
        jdtOptions["org.greenrobot.eclipse.jdt.core.encoding"] = encoding
        classParser = EntityClassParser(jdtOptions, encoding)
    }

    companion object {
        private const val JAVA_LEVEL = "1.7"
    }
}