package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.ASTNode
import org.greenrobot.essentials.hash.Murmur3F
import java.nio.charset.Charset
import kotlin.jvm.internal.Intrinsics
import kotlin.text.Charsets.UTF_8

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"], d2 = ["Lorg/greenrobot/greendao/codemodifier/CodeCompare;", "", "()V", "murmur", "Lorg/greenrobot/essentials/hash/Murmur3F;", "regexGeneratedAnnotation", "Lkotlin/text/Regex;", "regexJavaCommentMl", "regexJavaCommentSl", "regexTooManySpaces", "regexUselessSpaces", "codeHash", "", "code", "", "isSameCode", "", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "unformatCode", "greendao-code-modifier_main"])
class CodeCompare private constructor() {
    private fun unformatCode(code: String): String {
        var codeCharSequence = code as CharSequence
        codeCharSequence = regexJavaCommentSl.replace(codeCharSequence, "/*$1*/")

        val var6 : Function1<*, *> = null.INSTANCE as Function1<*, *>
        codeCharSequence = regexJavaCommentMl.replace(codeCharSequence, var6) as CharSequence
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

        @JvmField
        var INSTANCE: CodeCompare = CodeCompare()
    }
}