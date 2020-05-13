package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.ASTNode
import org.greenrobot.essentials.hash.Murmur3F
import java.nio.charset.Charset
import kotlin.jvm.internal.Intrinsics
import kotlin.text.Charsets.UTF_8

class CodeCompare private constructor() {
    private fun unformatCode(code: String): String {
        var codeCharSequence = code as CharSequence
        codeCharSequence = regexJavaCommentSl.replace(codeCharSequence, "/*$1*/")
        codeCharSequence = regexJavaCommentMl.replace(codeCharSequence, "")
        codeCharSequence = regexTooManySpaces.replace(codeCharSequence, " ")
        return regexUselessSpaces.replace(codeCharSequence, "$1").trim()
    }

    fun codeHash(code: String): Int {
        Intrinsics.checkParameterIsNotNull(code, "code")
        murmur.reset()
        val var3 = code as CharSequence
        val var4 = regexGeneratedAnnotation
        val var5 = ""
        val var8 = var4.replace(var3, var5)
        val unformattedCode = unformatCode(var8)
        val var10: Charset?
        val var7 = murmur
        var10 = UTF_8
        return run {
            val var10000 = unformattedCode.toByteArray(var10)
            Intrinsics.checkExpressionValueIsNotNull(var10000, "(this as java.lang.String).getBytes(charset)")
            var7.update(var10000)
            val intHash = murmur.value.toInt()
            intHash shl 1 ushr 1
        }
    }

    fun isSameCode(node: ASTNode, code: String): Boolean {
        val nodeCode = INSTANCE.unformatCode(node.toString())
        val unformattedCode = INSTANCE.unformatCode(code)
        return Intrinsics.areEqual(nodeCode, unformattedCode)
    }

    companion object {
        private val regexTooManySpaces = Regex("[ \\n\\t\\r]+")
        private val regexUselessSpaces = Regex("\\s?(\\W)\\s?")
        private val regexJavaCommentMl = Regex("/\\*([^\\*]|\\*(?!/))*?\\*/")
        private val regexJavaCommentSl = Regex("//(.*)$")
        private val regexGeneratedAnnotation = Regex("@(org.greenrobot.greendao.annotation.)?Generated[(][^)]+[)]")
        private val murmur = Murmur3F()

        var INSTANCE: CodeCompare = CodeCompare()
    }
}