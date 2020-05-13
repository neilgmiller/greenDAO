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

class EntityClassTransformer(private val parsedEntity: ParsedEntity, private val jdtOptions: Hashtable<String, String>,
                             formattingOptions: FormattingOptions?, val inputCharSet: Charset, val bits: Int = 0) {

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

    private fun remove(node: ASTNode) = bodyRewrite.remove(node, null as TextEditGroup?)

    private fun insertMethod(codeString: String, replaceOldNode: ASTNode?, insertAfterNode: ASTNode?) {
        if (replaceOldNode != null && CodeCompare.INSTANCE.isSameCode(replaceOldNode, codeString)) {
            val var6 = keepNodes as MutableCollection<ASTNode>
            var6.add(replaceOldNode)
        } else {
            val newMethod = astRewrite.createStringPlaceholder(formatter.format(codeString), TypeDeclaration.METHOD_DECLARATION)
            replaceNode(newMethod, replaceOldNode, insertAfterNode)
        }
    }

    private fun insertField(codeString: String, replaceOldNode: ASTNode?) {
        if (replaceOldNode != null && CodeCompare.INSTANCE.isSameCode(replaceOldNode, codeString)) {
            val var5 = keepNodes as MutableCollection<ASTNode>
            var5.add(replaceOldNode)
        } else {
            val newField = astRewrite.createStringPlaceholder(formatter.format(codeString), TypeDeclaration.FIELD_DECLARATION)
            replaceNode(newField, replaceOldNode, parsedEntity.lastFieldDeclaration as ASTNode?)
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
                val nodeToReplace: MethodDeclaration? = if (generatedConstructor.parameters.isNotEmpty() && paramTypes.isNotEmpty()) {
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

    fun defMethod(name: String, paramTypes: Array<String>, codeFunction: Function0<*>) {
        val methodIterator = parsedEntity.methods.iterator()
        val method: Method?
        while (true) {
            if (methodIterator.hasNext()) {
                val newMethod = methodIterator.next()
                if (newMethod.hasSignature(name, paramTypes.toMutableList())) {
                    method = newMethod
                    break
                } else {
                    continue
                }
            }
            method = null
            break
        }
        if (method != null && !method.generated) {
            checkKeepPresent(method as Generatable)
        } else {
            val paramTypesWithDot = mutableListOf<String>()
            for (index in paramTypes.indices) {
                val paramType: String = paramTypes[index]

                if (paramType.contains('.', false)) {
                    paramTypesWithDot.add(paramType)
                }
            }

            val paramTypeIterator = paramTypesWithDot.toTypedArray().iterator()
            while (paramTypeIterator.hasNext()) {
                ensureImport(paramTypeIterator.next())
            }
            val codeString = replaceHashStub(codeFunction.invoke() as String)
            val replaceOldNode = method?.node as ASTNode?
            val insertAfterNode: BodyDeclaration? = parsedEntity.lastMethodDeclaration
                    ?: parsedEntity.lastConstructorDeclaration
                    ?: parsedEntity.lastFieldDeclaration
            insertMethod(codeString, replaceOldNode, insertAfterNode)
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
                val var8 = fieldIterator.next()
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
            insertField(replaceHashStub("${if (comment != null) "/** $comment */\n" else ""}@Generated(hash = ${EntityClassTransformerKt.HASH_STUB})\nprivate transient ${type.simpleName} $name;"), field?.node as ASTNode?)
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
        return source.replace(EntityClassTransformerKt.HASH_STUB, hash.toString(), false)
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

    private fun removeUnneeded(iterable: Iterable<*>) {
        val sequence: Sequence<*> = iterable.asSequence()
                .filter {
                    val item = it as Generatable
                    item.generated && keepNodes.contains(it.node)
                }

        for (item in sequence) {
            remove((item as Generatable).node)
        }
    }

    private fun writeToString(): String? {
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