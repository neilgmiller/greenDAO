package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.compiler.IProblem
import org.greenrobot.eclipse.jdt.core.dom.ASTParser
import org.greenrobot.eclipse.jdt.core.dom.ASTVisitor
import org.greenrobot.eclipse.jdt.core.dom.Comment
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit
import java.io.File
import java.nio.charset.Charset
import java.util.*

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"], d2 = ["Lorg/greenrobot/greendao/codemodifier/EntityClassParser;", "", "jdtOptions", "Ljava/util/Hashtable;", "", "encoding", "(Ljava/util/Hashtable;Ljava/lang/String;)V", "getEncoding", "()Ljava/lang/String;", "getJdtOptions", "()Ljava/util/Hashtable;", "parse", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "javaFile", "Ljava/io/File;", "classesInPackage", "", "Companion", "greendao-code-modifier_main"])
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

//    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"], d2 = ["Lorg/greenrobot/greendao/codemodifier/EntityClassParser\$Companion;", "", "()V", "AST_PARSER_LEVEL", "", "getAST_PARSER_LEVEL", "()I", "ignoredProblemIds", "", "getIgnoredProblemIds", "()[I", "shouldReportProblem", "", "problemId", "greendao-code-modifier_main"])
    companion object {
        private const val AST_PARSER_LEVEL = 8
        private val ignoredProblemIds = intArrayOf(16777218, 570425394, 33554502, 33554515, 67108964, 67108984, 134217857, 67109135, 268435846, 67109264, 16777541, 536871543, 67109498)
    }


}