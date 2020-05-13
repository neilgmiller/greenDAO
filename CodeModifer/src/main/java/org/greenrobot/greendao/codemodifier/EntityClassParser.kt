package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.compiler.IProblem
import org.greenrobot.eclipse.jdt.core.dom.ASTParser
import org.greenrobot.eclipse.jdt.core.dom.ASTVisitor
import org.greenrobot.eclipse.jdt.core.dom.Comment
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit
import java.io.File
import java.nio.charset.Charset
import java.util.*

class EntityClassParser(private val jdtOptions: Hashtable<String, String>, private val encoding: String) {

    fun parse(javaFile: File, classesInPackage: List<*>): ParsedEntity? {
        val source = javaFile.readText(Charset.forName(encoding))
        val parser = ASTParser.newParser(Companion.AST_PARSER_LEVEL)
        parser.setCompilerOptions(jdtOptions as MutableMap<String, String>)
        parser.setKind(8)
        parser.setEnvironment(arrayOfNulls<String>(0), arrayOfNulls<String>(0) , null, true)
        parser.setUnitName("/" + javaFile.path)
        parser.setBindingsRecovery(true)
        parser.setResolveBindings(true)
        return run {
            parser.setSource(source.toCharArray())
            val astNode = parser.createAST(null)
            if (astNode == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.CompilationUnit")
            } else {
                val astRoot = astNode as CompilationUnit
                val problems = astRoot.problems
                val reportableProblems = if (problems != null) {
                    val destination = mutableListOf<Any?>()
                    for (p in problems) {
                        val keep: Boolean = shouldReportProblem(p.id)
                        if (!keep) {
                            println("[Verbose] Ignoring parser problem in $javaFile:${p.sourceLineNumber}: $p.")
                        }
                        if (keep) {
                            destination.add(p)
                        }
                    }
                    destination
                } else {
                    null
                }

                if (reportableProblems != null) {
                    if (reportableProblems.isNotEmpty()) {
                        System.err.println("Found " + reportableProblems.size + " problem(s) parsing " + "\"" + javaFile + "\"" + ":")
                        var index = 0
                        for (item in reportableProblems) {
                            index++
                            val problem = item as IProblem
                            System.err.println("#${index + 1} @${problem.sourceLineNumber}: $problem (ID: ${problem.id}; error: ${problem.isError})")
                        }
                        val first = reportableProblems.first() as IProblem
                        throw RuntimeException("Found ${reportableProblems.size} problem(s) parsing \"$javaFile\". First problem:\n$first (${first.id} at line ${first.sourceLineNumber}).\nRun gradle with --info for more details.")
                    }
                }
                val sourceSplit = source.split("\n", ignoreCase = false, limit = 6)
                val commentVisitor = KeepCommentVisitor(astRoot, sourceSplit)
                for (element in astRoot.commentList) {
                    if (element is Comment) {
                        element.accept(commentVisitor as ASTVisitor)
                    }
                }
                commentVisitor.validateLineNumbers()
                val visitor = EntityClassASTVisitor(source, classesInPackage, commentVisitor.keepFieldsStartLineNumber, commentVisitor.keepFieldsEndLineNumber)
                astRoot.accept(visitor)
                visitor.createParsedEntity(javaFile, source)
            }
        }
    }

    private fun shouldReportProblem(problemId: Int): Boolean {
        return !ignoredProblemIds.contains(problemId)
    }

    companion object {
        private const val AST_PARSER_LEVEL = 8
        private val ignoredProblemIds = intArrayOf(16777218, 570425394, 33554502, 33554515, 67108964, 67108984, 134217857, 67109135, 268435846, 67109264, 16777541, 536871543, 67109498)
    }


}