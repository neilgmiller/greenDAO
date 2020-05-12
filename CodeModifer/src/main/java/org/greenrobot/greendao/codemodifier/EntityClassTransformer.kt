package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import org.greenrobot.eclipse.jdt.core.dom.rewrite.ASTRewrite
import org.greenrobot.eclipse.jdt.core.dom.rewrite.ListRewrite
import org.greenrobot.eclipse.jface.text.Document
import org.greenrobot.eclipse.jface.text.IDocument
import org.greenrobot.eclipse.text.edits.TextEditGroup
import java.nio.charset.Charset
import java.util.*
import kotlin.jvm.internal.Intrinsics
import kotlin.text.Charsets.UTF_8

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010$\u001a\u00020%J\"\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060*J\"\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0006J5\u00100\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00062\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000601\"\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060*¢\u0006\u0002\u00102J5\u00103\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00062\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000601\"\u00020\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060*¢\u0006\u0002\u00102J\u0006\u00104\u001a\u00020%J\u000e\u00105\u001a\u00020%2\u0006\u0010,\u001a\u00020\u0006J\u001c\u00106\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0016H\u0002J$\u00108\u001a\u00020%2\u0006\u0010)\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u00162\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020\u0016J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0002J$\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020\u00162\b\u0010@\u001a\u0004\u0018\u00010\u00162\b\u0010A\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u0010B\u001a\u00020%J\b\u0010C\u001a\u0004\u0018\u00010\u0006J\u0010\u0010D\u001a\u00020%*\u0006\u0012\u0002\b\u00030EH\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u0010*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u00020\u0006*\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006F"], d2 = ["Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "", "parsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "jdtOptions", "Ljava/util/Hashtable;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "charset", "Ljava/nio/charset/Charset;", "(Lorg/greenrobot/greendao/codemodifier/ParsedEntity;Ljava/util/Hashtable;Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/nio/charset/Charset;)V", "addedImports", "", "astRewrite", "Lorg/greenrobot/eclipse/jdt/core/dom/rewrite/ASTRewrite;", "kotlin.jvm.PlatformType", "bodyRewrite", "Lorg/greenrobot/eclipse/jdt/core/dom/rewrite/ListRewrite;", "getCharset", "()Ljava/nio/charset/Charset;", "cu", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "formatter", "Lorg/greenrobot/greendao/codemodifier/Formatter;", "formatting", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "importsRewrite", "getJdtOptions", "()Ljava/util/Hashtable;", "keepNodes", "getParsedEntity", "()Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "sourceLine", "getSourceLine", "(Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;)Ljava/lang/String;", "annotateLegacyKeepFields", "", "defConstructor", "paramTypes", "", "code", "Lkotlin/Function0;", "defField", "name", "type", "Lorg/greenrobot/greendao/codemodifier/VariableType;", "comment", "defMethod", "", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "defMethodIfMissing", "ensureDefaultConstructor", "ensureImport", "insertField", "replaceOld", "insertMethod", "insertAfter", "remove", "node", "replaceHashStub", "source", "replaceNode", "newNode", "oldNode", "orInsertAfter", "writeToFile", "writeToString", "checkKeepPresent", "Lorg/greenrobot/greendao/codemodifier/Generatable;", "greendao-code-modifier_main"])
class EntityClassTransformer(private val parsedEntity: ParsedEntity, private val jdtOptions: Hashtable<String, String>,
                             private val formattingOptions: FormattingOptions?, val inputCharSet: Charset, val bits: Int = 0) {

    private val charset: Charset by lazy {
        if (bits and 8 != 0) {
            UTF_8
        } else {
            inputCharSet
        }
    }
    private var rootNode: ASTNode = parsedEntity.node.root
    private val formatting: Formatting =
            formattingOptions?.toFormatting()
                    ?: Formatting.detect(this.parsedEntity.source, formattingOptions)

    private val formatter: Formatter = Formatter(formatting)
    private val astRewrite: ASTRewrite = ASTRewrite.create(rootNode.ast)
    private val importsRewrite: ListRewrite = astRewrite.getListRewrite(parsedEntity.node as ASTNode, TypeDeclaration.BODY_DECLARATIONS_PROPERTY)
    private val bodyRewrite: ListRewrite = astRewrite.getListRewrite(parsedEntity.node as ASTNode, TypeDeclaration.BODY_DECLARATIONS_PROPERTY)
    private val keepNodes: MutableSet<ASTNode> = LinkedHashSet()
    private val addedImports: MutableSet<String> = LinkedHashSet()

    init {
        jdtOptions.put("org.greenrobot.eclipse.jdt.core.formatter.tabulation.char", if (formatting.tabulation.tabChar == ' ') "space" else "tab")
        jdtOptions.put("org.greenrobot.eclipse.jdt.core.formatter.tabulation.size", formatting.tabulation.size.toString())
    }

    fun ensureImport(name: String) {
        val packageName = name.substringBeforeLast('.', "")
        val maybeInnerClassName = packageName.substringAfterLast(".", "")
        if (Intrinsics.areEqual(packageName, parsedEntity.packageName) xor true
                && Intrinsics.areEqual(maybeInnerClassName, parsedEntity.name) xor true
                && !JdtUtilsKt.has((parsedEntity.imports as Iterable<*>), name)
                && !addedImports.contains(name)) {
            val id = rootNode.ast.newImportDeclaration()
            val rootAst = rootNode.ast
            var receiver = name.split(".", ignoreCase = false, limit = 6)
            val thisCollection = receiver
            id.name = rootAst.newName(thisCollection.toTypedArray())
            importsRewrite.insertLast(id as ASTNode, null as TextEditGroup?)
            receiver = addedImports.toMutableList()
            receiver.add(name)
        }
    }

    fun remove(node: ASTNode) = bodyRewrite.remove(node, null as TextEditGroup?)

    private fun insertMethod(code: String, replaceOld: ASTNode?, insertAfter: ASTNode?) {
        if (replaceOld != null && CodeCompare.INSTANCE.isSameCode(replaceOld, code)) {
            val var6 = keepNodes as MutableCollection<ASTNode>
            var6.add(replaceOld)
        } else {
            val newMethod = astRewrite.createStringPlaceholder(formatter.format(code), TypeDeclaration.METHOD_DECLARATION)
            replaceNode(newMethod, replaceOld, insertAfter)
        }
    }

    private fun insertField(code: String, replaceOld: ASTNode?) {
        if (replaceOld != null && CodeCompare.INSTANCE.isSameCode(replaceOld, code)) {
            val var5 = keepNodes as MutableCollection<ASTNode>
            var5.add(replaceOld)
        } else {
            val newField = astRewrite.createStringPlaceholder(formatter.format(code), TypeDeclaration.FIELD_DECLARATION)
            replaceNode(newField, replaceOld, parsedEntity.lastFieldDeclaration as ASTNode?)
        }
    }

    private fun replaceNode(newNode: ASTNode, oldNode: ASTNode?, orInsertAfter: ASTNode?) {
        when {
            oldNode != null -> {
                bodyRewrite.insertAfter(newNode, oldNode, null as TextEditGroup?)
                remove(oldNode)
            }
            orInsertAfter != null -> bodyRewrite.insertAfter(newNode, orInsertAfter, null as TextEditGroup?)
            else -> bodyRewrite.insertLast(newNode, null as TextEditGroup?)
        }
    }

    private fun getSourceLine(receiver: ASTNode): String =
            "${parsedEntity.sourceFile.path}:${JdtUtilsKt.getLineNumber(receiver)}"

    private fun checkKeepPresent(receiver: Generatable) {
        val node = receiver.node
        val place = if (node is MethodDeclaration) if (node.isConstructor) "constructor" else "method" else if (node is FieldDeclaration) "field" else "declaration"
        val hint = receiver.hint
        if (Intrinsics.areEqual(hint, GeneratorHint.Keep.INSTANCE)) {
            println("Keep $place in ${getSourceLine(node as ASTNode)}")
        }
    }

    fun defConstructor(paramTypes: List<*>, code: Function0<*>) {
        val parsedEntityIterator = parsedEntity.constructors.iterator()
        var var10000: Any?
        while (true) {
            if (parsedEntityIterator.hasNext()) {
                val entity = parsedEntityIterator.next()
                val it = entity as Method
                if (!it.hasSignature(parsedEntity.name, paramTypes)) {
                    continue
                }
                var10000 = entity
                break
            }
            var10000 = null
            break
        }

        val matchingConstructor = var10000 as Method?
        val code2: String
        val replaceOld2: ASTNode?
        val insertAfter2: MethodDeclaration?
        if (matchingConstructor != null) {
            if (matchingConstructor.generated) {
                code2 = replaceHashStub(code.invoke() as String)
                replaceOld2 = matchingConstructor.node
                insertAfter2 = parsedEntity.lastConstructorDeclaration
                insertMethod(code2, replaceOld2, insertAfter2 ?: parsedEntity.lastFieldDeclaration)
            } else {
                checkKeepPresent(matchingConstructor as Generatable)
            }
        } else {
            val parsedEntityIterator2 = parsedEntity.constructors.iterator()
            while (true) {
                if (!parsedEntityIterator2.hasNext()) {
                    var10000 = null
                    break
                }
                val var16 = parsedEntityIterator2.next()
                val it = var16 as Method
                if (it.generated) {
                    var10000 = var16
                    break
                }
            }

            val generatedConstructor = var10000 as Method?
            if (generatedConstructor != null) {
                val nodeToReplace: MethodDeclaration?
                nodeToReplace = if (generatedConstructor.parameters.isNotEmpty() && paramTypes.isNotEmpty()) {
                    generatedConstructor.node
                } else {
                    (keepNodes as MutableCollection<ASTNode>).add(generatedConstructor.node)
                    null
                }
                code2 = replaceHashStub(code.invoke() as String)
                replaceOld2 = nodeToReplace
                insertAfter2 = parsedEntity.lastConstructorDeclaration
                insertMethod(code2, replaceOld2, insertAfter2 ?: parsedEntity.lastFieldDeclaration)
            } else {
                code2 = replaceHashStub(code.invoke() as String)
                insertAfter2 = parsedEntity.lastConstructorDeclaration
                insertMethod(code2, null as ASTNode?, insertAfter2
                        ?: parsedEntity.lastFieldDeclaration)
            }
        }
    }

    fun ensureDefaultConstructor() {
        val constructorIterator = parsedEntity.constructors.iterator()
        val var10000: Any?
        while (true) {
            if (constructorIterator.hasNext()) {
                val var5 = constructorIterator.next()
                val it = var5 as Method
                if (it.parameters.isNotEmpty()) {
                    continue
                }
                var10000 = var5
                break
            }
            var10000 = null
            break
        }
        val defaultConstructor = var10000 as Method?
        if (defaultConstructor != null && !defaultConstructor.generated) {
            (keepNodes as MutableCollection<ASTNode>).add(defaultConstructor.node)
        } else {
            val defaultConstructorCode = "public ${parsedEntity.name}() {\n                    }"
            val replaceOld = defaultConstructor?.node as ASTNode?
            insertMethod(defaultConstructorCode, replaceOld, parsedEntity.lastConstructorDeclaration
                    ?: parsedEntity.lastFieldDeclaration)
        }
    }

    fun defMethod(name: String, paramTypes: Array<String>, code: Function0<*>) {
        val methodIterator = parsedEntity.methods.iterator()
        val var10000: Any?
        while (true) {
            if (methodIterator.hasNext()) {
                val var8 = methodIterator.next()
                val it = var8 as Method
                if (!it.hasSignature(name, paramTypes.toMutableList())) {
                    continue
                }
                var10000 = var8
                break
            }
            var10000 = null
            break
        }
        val method = var10000 as Method?
        if (method != null && !method.generated) {
            checkKeepPresent(method as Generatable)
        } else {
            var receiver = paramTypes
            val destination = mutableListOf<String>()
            for (var18 in receiver.indices) {
                val element: String = receiver[var18]

                if (element.contains('.', false)) {
                    destination.add(element)
                }
            }
            receiver = destination.toTypedArray()
            val receiverIterator = receiver.iterator()
            while (receiverIterator.hasNext()) {
                ensureImport(receiverIterator.next())
            }
            val code2 = replaceHashStub(code.invoke() as String)
            val replaceOld2 = method?.node as ASTNode?
            var insertAfter2: BodyDeclaration? = parsedEntity.lastMethodDeclaration
                    ?: parsedEntity.lastConstructorDeclaration
            if (insertAfter2 == null) {
                insertAfter2 = parsedEntity.lastFieldDeclaration
            }
            insertMethod(code2, replaceOld2, insertAfter2)
        }
    }

    fun defMethodIfMissing(name: String, paramTypes: Array<String>, code: Function0<*>) {
        val methodIterator = parsedEntity.methods.iterator()
        val var10000: Any?
        while (true) {
            if (methodIterator.hasNext()) {
                val var8 = methodIterator.next()
                val it = var8 as Method

                if (!it.hasSignature(name, paramTypes.asList())) {
                    continue
                }
                var10000 = var8
                break
            }
            var10000 = null
            break
        }
        val method = var10000 as Method?
        if (method == null) {
            var receiver = paramTypes
            val receiver2 = receiver
            val destination = mutableListOf<String>()
            for (var18 in receiver2.indices) {
                val element = receiver2[var18]
                if (element.contains('.', false)) {
                    destination.add(element)
                }
            }
            receiver = destination.toTypedArray()
            val receiverIterator = receiver.iterator()
            while (receiverIterator.hasNext()) {
                ensureImport(receiverIterator.next() as String)
            }
            val code2 = code.invoke() as String
            var insertAfter2: BodyDeclaration? = parsedEntity.lastMethodDeclaration
                    ?: parsedEntity.lastConstructorDeclaration
            if (insertAfter2 == null) {
                insertAfter2 = parsedEntity.lastFieldDeclaration
            }
            insertMethod(code2, null, insertAfter2)
        }
    }

    fun defField(name: String, type: VariableType, comment: String?) {
        val fieldIterator = parsedEntity.transientFields.iterator()
        val var10000: Any?
        while (true) {
            if (fieldIterator.hasNext()) {
                val var8 = fieldIterator.next()!!
                val it = var8 as TransientField
                if (!Intrinsics.areEqual(it.variable.name, name)) {
                    continue
                }
                var10000 = var8
                break
            }
            var10000 = null
            break
        }
        val field = var10000 as TransientField?
        if (field != null && !field.generated) {
            checkKeepPresent(field as Generatable)
        } else {
            if (!type.isPrimitive && Intrinsics.areEqual(type.name, type.simpleName) xor true) {
                ensureImport(type.name)
            }
            insertField(replaceHashStub("${if (comment != null) "/** $comment */\n" else ""}@Generated(hash = ${EntityClassTransformerKt.hASH_STUB})\nprivate transient ${type.simpleName} $name;"), field?.node as ASTNode?)
        }
    }

    fun annotateLegacyKeepFields() {
        if (parsedEntity.legacyTransientFields.isNotEmpty()) {
            ensureImport("org.greenrobot.greendao.annotation.Transient")
            val fieldIterator = parsedEntity.legacyTransientFields.iterator()
            while (fieldIterator.hasNext()) {
                val it = fieldIterator.next() as TransientField
                insertField("@Transient\n                       private ${it.variable.type.simpleName} ${it.variable.name};", it.node as ASTNode)
            }
        }
    }

    private fun replaceHashStub(source: String): String {
        val hash = CodeCompare.INSTANCE.codeHash(source)
        return source.replace(EntityClassTransformerKt.hASH_STUB, hash.toString(), false)
    }

    fun writeToFile() {
        val newSource = writeToString()
        if (newSource != null) {
            println("Change ${parsedEntity.sourceFile.path}")
            parsedEntity.sourceFile.writeText(newSource, charset)
        } else {
            println("Skip ${parsedEntity.sourceFile.path}")
        }
    }

    fun removeUnneeded(iterable: Iterable<*>) {
        val sequence: Sequence<*> = iterable.asSequence()
                .filter {
                    val item = it as Generatable
                    item.generated && keepNodes.contains(it.node)
                }

        for (item in sequence) {
            remove((item as Generatable).node)
        }
    }

    fun writeToString(): String? {
        removeUnneeded(parsedEntity.constructors)
        removeUnneeded(parsedEntity.methods)
        removeUnneeded(parsedEntity.transientFields)

        val document = Document(parsedEntity.source)
        val edits = astRewrite.rewriteAST(document as IDocument, jdtOptions as Map<*, *>)
        edits.apply(document as IDocument)
        val newSource = document.get()
        return if (Intrinsics.areEqual(newSource, parsedEntity.source) xor true) newSource else null
    }
}