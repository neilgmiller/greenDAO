package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit
import org.greenrobot.eclipse.jdt.core.dom.LineComment
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"], d2 = ["Lorg/greenrobot/greendao/codemodifier/KeepCommentVisitor;", "Lorg/greenrobot/greendao/codemodifier/LazyVisitor;", "entityUnit", "Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "sourceSplit", "", "", "(Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;Ljava/util/List;)V", "getEntityUnit", "()Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "keepFieldsEndLineNumber", "", "getKeepFieldsEndLineNumber", "()I", "setKeepFieldsEndLineNumber", "(I)V", "keepFieldsStartLineNumber", "getKeepFieldsStartLineNumber", "setKeepFieldsStartLineNumber", "getSourceSplit", "()Ljava/util/List;", "validateLineNumbers", "", "visit", "", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/LineComment;", "greendao-code-modifier_main"])
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