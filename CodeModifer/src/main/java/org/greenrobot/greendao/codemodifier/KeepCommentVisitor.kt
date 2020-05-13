package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit
import org.greenrobot.eclipse.jdt.core.dom.LineComment
import kotlin.jvm.internal.Intrinsics

class KeepCommentVisitor(private val entityUnit: CompilationUnit, private val sourceSplit: List<*>) : LazyVisitor() {
    var keepFieldsStartLineNumber: Int = -1
    var keepFieldsEndLineNumber: Int = -1

    override fun visit(node: LineComment): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        val lineNumber = entityUnit.getLineNumber(node.startPosition)
        val var4 = sourceSplit[lineNumber - 1] as String?
        return if (var4 == null) {
            throw TypeCastException("null cannot be cast to non-null type kotlin.CharSequence")
        } else {
            val lineComment: String = var4.trim()
            if (lineComment.startsWith("// KEEP FIELDS END",2, false)) {
                keepFieldsEndLineNumber = lineNumber
            } else if (lineComment.startsWith("// KEEP FIELDS", 2, false)) {
                keepFieldsStartLineNumber = lineNumber
            }
            false
        }
    }

    fun validateLineNumbers() {
        if (keepFieldsStartLineNumber == -1 || keepFieldsEndLineNumber == -1 || keepFieldsEndLineNumber < keepFieldsStartLineNumber) {
            keepFieldsStartLineNumber = -1
            keepFieldsEndLineNumber = -1
        }
    }
}