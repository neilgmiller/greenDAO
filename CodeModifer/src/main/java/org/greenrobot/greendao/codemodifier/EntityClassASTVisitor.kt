package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import org.greenrobot.greendao.annotation.*
import java.io.File
import kotlin.jvm.internal.Intrinsics
import kotlin.jvm.internal.Reflection
import kotlin.reflect.KClass

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0003H\u0002J\b\u0010w\u001a\u00020tH\u0002J\u0018\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010z\u001a\u00020{2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010|\u001a\u00020t2\u0006\u0010}\u001a\u000202H\u0016J\u0010\u0010|\u001a\u00020t2\u0006\u0010}\u001a\u00020~H\u0016J$\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013H\u0002J,\u0010\u0084\u0001\u001a\u00020;2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J,\u0010\u0087\u0001\u001a\u00020A2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J4\u0010\u0088\u0001\u001a\u00020G2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010}\u001a\u0002022\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008a\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008b\u0001H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u000202H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020'H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008c\u0001H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020~H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008d\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008f\u0001H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020ZH\u0016J\u000f\u0010\u0090\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u001fJ\u0017\u0010\u0091\u0001\u001a\u00020t*\u00020c2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\u001d\u0010\u0094\u0001\u001a\u00020\u000b\"\u0007\b\u0000\u0010\u0095\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00020\u001f0\u0005H\u0082\bJ\u001b\u0010\u0096\u0001\u001a\u00020\u000b*\u00020\u001f2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u0001H\u0002J+\u0010\u0099\u0001\u001a\u0005\u0018\u0001H\u009a\u0001\"\f\b\u0000\u0010\u009a\u0001\u0018\u0001*\u00030\u009b\u0001*\b\u0012\u0004\u0012\u00020\u001f0\u0005H\u0082\b¢\u0006\u0003\u0010\u009c\u0001J\u000e\u0010\u009d\u0001\u001a\u00030\u0086\u0001*\u00020pH\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u001a\u0010)\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u001a\u0010.\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0011R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0013¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0011R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0011R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0011R\u001c\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0013¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0011R\u001c\u0010I\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010\u001dR\u001a\u0010L\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001bR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0011R \u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010VR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u0002080\u0013¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0011R\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001b\"\u0004\ba\u0010\u001dR\u001a\u0010b\u001a\u0004\u0018\u00010\u0003*\u00020c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR \u0010f\u001a\u0004\u0018\u00010g*\b\u0012\u0004\u0012\u00020\u001f0\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u001e\u0010j\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u001f0\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0018\u0010m\u001a\u00020\u0003*\u00020c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010eR\u0018\u0010o\u001a\u00020\u0003*\u00020p8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u0010r¨\u0006\u009e\u0001"], d2 = ["Lorg/greenrobot/greendao/codemodifier/EntityClassASTVisitor;", "Lorg/greenrobot/greendao/codemodifier/LazyVisitor;", "source", "", "classesInPackage", "", "keepFieldsStartLineNumber", "", "keepFieldsEndLineNumber", "(Ljava/lang/String;Ljava/util/List;II)V", "active", "", "getActive", "()Z", "setActive", "(Z)V", "getClassesInPackage", "()Ljava/util/List;", "constructors", "", "Lorg/greenrobot/greendao/codemodifier/Method;", "getConstructors", "createTable", "getCreateTable", "setCreateTable", "entityTableName", "getEntityTableName", "()Ljava/lang/String;", "setEntityTableName", "(Ljava/lang/String;)V", "fieldAnnotations", "Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "generateConstructors", "getGenerateConstructors", "setGenerateConstructors", "generateGettersSetters", "getGenerateGettersSetters", "setGenerateGettersSetters", "imports", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "getImports", "isEntity", "setEntity", "getKeepFieldsEndLineNumber", "()I", "getKeepFieldsStartLineNumber", "keepSource", "getKeepSource", "setKeepSource", "lastField", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "getLastField", "()Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "setLastField", "(Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;)V", "legacyTransientFields", "Lorg/greenrobot/greendao/codemodifier/TransientField;", "getLegacyTransientFields", "manyRelations", "Lorg/greenrobot/greendao/codemodifier/ManyRelation;", "getManyRelations", "methodAnnotations", "methods", "getMethods", "oneRelations", "Lorg/greenrobot/greendao/codemodifier/OneRelation;", "getOneRelations", "packageName", "getPackageName", "setPackageName", "properties", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "getProperties", "protobufClassName", "getProtobufClassName", "setProtobufClassName", "schemaName", "getSchemaName", "setSchemaName", "getSource", "staticInnerClasses", "getStaticInnerClasses", "tableIndexes", "Lorg/greenrobot/greendao/codemodifier/TableIndex;", "getTableIndexes", "setTableIndexes", "(Ljava/util/List;)V", "transientFields", "getTransientFields", "typeDeclaration", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "getTypeDeclaration", "()Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "setTypeDeclaration", "(Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;)V", "usedNotNullAnnotation", "getUsedNotNullAnnotation", "setUsedNotNullAnnotation", "codePlace", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "getCodePlace", "(Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;)Ljava/lang/String;", "generatorHint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "getGeneratorHint", "(Ljava/util/List;)Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "hasNotNull", "getHasNotNull", "(Ljava/util/List;)Z", "originalCode", "getOriginalCode", "typeName", "Lorg/greenrobot/eclipse/jdt/core/dom/Type;", "getTypeName", "(Lorg/greenrobot/eclipse/jdt/core/dom/Type;)Ljava/lang/String;", "checkIfInnerTypeThenStatic", "", "typeClassName", "outerClassName", "checkInnerCustomTypes", "createParsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "javaFile", "Ljava/io/File;", "endVisit", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "findConvert", "Lorg/greenrobot/greendao/codemodifier/CustomType;", "fieldName", "Lorg/greenrobot/eclipse/jdt/core/dom/SimpleName;", "fa", "manyRelation", "variableType", "Lorg/greenrobot/greendao/codemodifier/VariableType;", "oneRelation", "parseProperty", "visit", "Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnumDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/MarkerAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/NormalAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/PackageDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/SingleMemberAnnotation;", "visitAnnotation", "checkUntouched", "hint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint\$Generated;", "has", "A", "hasType", "klass", "Lkotlin/reflect/KClass;", "proxy", "T", "", "(Ljava/util/List;)Ljava/lang/annotation/Annotation;", "toVariableType", "greendao-code-modifier_main"])
class EntityClassASTVisitor(private val source: String,
                            private val classesInPackage: List<*>,
                            private val keepFieldsStartLineNumber: Int,
                            private val keepFieldsEndLineNumber: Int) : LazyVisitor() {
    var isEntity = false
    private var schemaName: String = "default"
    private val properties: MutableList<ParsedProperty> = mutableListOf()
    private val transientFields: MutableList<TransientField> = mutableListOf()
    private val legacyTransientFields: MutableList<TransientField> = mutableListOf()
    private val constructors: MutableList<MethodDeclaration> = mutableListOf()
    private val methods: MutableList<MethodDeclaration> = mutableListOf()
    private val imports: MutableList<ImportDeclaration> = mutableListOf()
    private val staticInnerClasses: MutableList<String> = mutableListOf()
    var packageName: String? = null
    var entityTableName: String? = null
    var typeDeclaration: TypeDeclaration? = null
    private val oneRelations: MutableList<OneRelation> = mutableListOf()
    private val manyRelations: MutableList<ManyRelation> = mutableListOf()
    private var tableIndexes: List<*> = emptyList<Any>()
    var active = false
    var keepSource = false
    var createTable = true
    var generateConstructors = true
    var generateGettersSetters = true
    var protobufClassName: String? = null
    private var usedNotNullAnnotation: String? = null
    var lastField: FieldDeclaration? = null
    private val methodAnnotations: MutableList<org.greenrobot.eclipse.jdt.core.dom.Annotation> = mutableListOf()
    private val fieldAnnotations: MutableList<org.greenrobot.eclipse.jdt.core.dom.Annotation> = mutableListOf()

    fun createParsedEntity(javaFile: File, source: String): ParsedEntity? {
        val parsedEntity: ParsedEntity?
        if (isEntity) {
            checkInnerCustomTypes()
            val td = typeDeclaration
            if (td == null) {
                Intrinsics.throwNpe()
            }
            var pName = packageName
            if (pName == null) {
                pName = ""
            }
            parsedEntity = ParsedEntity(typeDeclaration!!.name.identifier, schemaName, active, properties, transientFields, legacyTransientFields, constructors, methods,
                    td!!, imports, pName, entityTableName, oneRelations, manyRelations, tableIndexes, javaFile, source, keepSource, createTable, generateConstructors,
                    generateGettersSetters, protobufClassName, usedNotNullAnnotation, lastField)
        } else {
            parsedEntity = null
        }
        return parsedEntity
    }

    override fun visit(node: CompilationUnit): Boolean {
        return true
    }

    override fun visit(node: ImportDeclaration): Boolean {
        imports.add(node)
        return true
    }

    override fun visit(node: PackageDeclaration): Boolean {
        packageName = node.name.fullyQualifiedName
        return true
    }

    private fun hasType(annotation: org.greenrobot.eclipse.jdt.core.dom.Annotation, klass: KClass<*>): Boolean {
        return if (annotation.typeName.isSimpleName) Intrinsics.areEqual(annotation.typeName.fullyQualifiedName, klass.simpleName)
                && JdtUtilsKt.has((imports as Iterable<*>), klass)
        else Intrinsics.areEqual(annotation.typeName.fullyQualifiedName, klass.qualifiedName)
    }

    private fun toVariableType(type: Type): VariableType {
        val arguments = (type as ParameterizedType).typeArguments().mapNotNull {
            if (it is Type)
                toVariableType(type)
            else
                null
        }
        return VariableType(getTypeName(type), type.isPrimitiveType, type.toString(), arguments)
    }

    private fun getTypeName(type: Type): String {
        return try {
            val identifier = typeDeclaration?.name?.identifier
            JdtUtilsKt.typeName(type, identifier, imports, packageName, classesInPackage)
        } catch (exception: IllegalArgumentException) {
            val string = typeDeclaration?.name?.identifier
            val exceptionString = StringBuilder().append("Error processing ").append("\"").append(string).append("\"").append(": ").append(exception.message).toString()
            throw RuntimeException(exceptionString, exception)
        }
    }

    fun visitAnnotation(annotation: org.greenrobot.eclipse.jdt.core.dom.Annotation): Boolean {
        val parent = annotation.parent
        if (parent is TypeDeclaration) {
            if (hasType(annotation, Reflection.getOrCreateKotlinClass(Entity::class.java))) {
                isEntity = true

                val entity = AnnotationProxy.INSTANCE.invoke(annotation, Entity::class.java) as Entity
                schemaName = entity.schema()
                active = entity.active()
                entityTableName = FunsKt.nullIfBlank(entity.nameInDb())
                createTable = entity.createInDb()
                generateConstructors = entity.generateConstructors()
                generateGettersSetters = entity.generateGettersSetters()
                if (annotation is NormalAnnotation) {
                    var expression = JdtUtilsKt.get(annotation, "protobuf")
                    if (expression !is TypeLiteral) {
                        expression = null
                    }

                    val type = (expression as TypeLiteral?)?.type
                    val typeName = if (type != null) {
                        val tn: String = getTypeName(type)
                        FunsKt.nullIfBlank(tn)
                    } else {
                        null
                    }
                    protobufClassName = typeName
                    if (protobufClassName != null && entityTableName == null) {
                        throw (RuntimeException("Set nameInDb in the ${parent.name} @Entity annotation. An explicit table name is required when specifying a protobuf class.") as Throwable)
                    }
                }
                try {
                    val annotationIndexes = entity.indexes() as Array<Index>
                    val destination = mutableListOf<TableIndex>()
                    for (i in annotationIndexes.indices) {
                        val indexItem = annotationIndexes[i]
                        val tableIndex = TableIndex(FunsKt.nullIfBlank(indexItem.name()), FunsKt.parseIndexSpec(indexItem.value()), indexItem.unique())
                        destination.add(tableIndex)
                    }
                    val var15 = destination as List<*>
                    tableIndexes = var15
                } catch (exception: IllegalArgumentException) {
                    throw (RuntimeException("Can't parse @Index.value for ${parent.name} because of: ${exception.message}", exception as Throwable) as Throwable)
                }
            } else if (hasType(annotation, Reflection.getOrCreateKotlinClass(Keep::class.java))) {
                keepSource = true
            }
        } else {
            when (parent) {
                is MethodDeclaration -> methodAnnotations.add(annotation)
                is FieldDeclaration -> fieldAnnotations.add(annotation)
            }
        }
        return true
    }

    override fun visit(node: MarkerAnnotation): Boolean =
            visitAnnotation(node as org.greenrobot.eclipse.jdt.core.dom.Annotation)

    override fun visit(node: SingleMemberAnnotation): Boolean =
            visitAnnotation(node as org.greenrobot.eclipse.jdt.core.dom.Annotation)

    override fun visit(node: NormalAnnotation): Boolean =
            visitAnnotation(node as org.greenrobot.eclipse.jdt.core.dom.Annotation)

    override fun visit(node: FieldDeclaration): Boolean = isEntity

    override fun endVisit(fieldDeclaration: FieldDeclaration) {
        var fragmentIterable = fieldDeclaration.fragments() as Iterable<*>
        var destination = mutableListOf<VariableDeclarationFragment>()
        var fragmentIterator = fragmentIterable.iterator()
        var fragment: Any?
        while (fragmentIterator.hasNext()) {
            fragment = fragmentIterator.next()
            if (fragment is VariableDeclarationFragment) {
                destination.add(fragment)
            }
        }
        fragmentIterable = destination
        destination = mutableListOf()
        fragmentIterator = fragmentIterable.iterator()
        while (fragmentIterator.hasNext()) {
            fragment = fragmentIterator.next()
            destination.add(fragment)
        }
        fragmentIterable = destination
        val simpleNameList = mutableListOf<SimpleName>()
        fragmentIterator = fragmentIterable.iterator()
        while (fragmentIterator.hasNext()) {
            fragment = fragmentIterator.next()
            val it = fragment as VariableDeclarationFragment?
            simpleNameList.add(it!!.name)
        }

        val variableType = toVariableType(fieldDeclaration.type)
        val lineNumber = JdtUtilsKt.getLineNumber(fieldDeclaration as ASTNode)
        val isInLegacyKeepSection = lineNumber != null && lineNumber.toInt() > keepFieldsStartLineNumber && lineNumber.toInt() < keepFieldsEndLineNumber
        val annotations = fieldAnnotations
        val annotationIterator = annotations.iterator()
        var isTransient: Boolean
        while (true) {
            if (annotationIterator.hasNext()) {
                val annotation = annotationIterator.next()
                if (!Intrinsics.areEqual(annotation.typeName.fullyQualifiedName, "Transient")) {
                    continue
                }
                isTransient = true
                break
            }
            isTransient = false
            break
        }
        var transientField: TransientField
        if (!isTransient && !Modifier.isTransient(fieldDeclaration.modifiers) && !Modifier.isStatic(fieldDeclaration.modifiers)) {
            var iterator: Iterator<*>
            var simpleName: SimpleName
            if (isInLegacyKeepSection) {
                iterator = simpleNameList.iterator()
                while (iterator.hasNext()) {
                    simpleName = iterator.next()
                    transientField = TransientField(Variable(variableType, simpleName.toString()), fieldDeclaration, null as GeneratorHint?)
                    legacyTransientFields.add(transientField)
                }
                System.err.println("Field $simpleNameList in ${getCodePlace(fieldDeclaration as ASTNode)} will be annotated with @Transient, you can remove the KEEP FIELDS comments.")
            } else {
                iterator = annotations.iterator()
                while (true) {
                    if (!iterator.hasNext()) {
                        isTransient = false
                        break
                    }

                    if (hasType(iterator.next(), Reflection.getOrCreateKotlinClass(ToOne::class.java))) {
                        isTransient = true
                        break
                    }
                }
                if (isTransient) {
                    iterator = simpleNameList.iterator()
                    while (iterator.hasNext()) {
                        simpleName = iterator.next()
                        oneRelations.add(oneRelation(annotations, simpleName, variableType))
                    }
                } else {
                    iterator = annotations.iterator()
                    while (true) {
                        if (!iterator.hasNext()) {
                            isTransient = false
                            break
                        }
                        if (hasType(iterator.next(), Reflection.getOrCreateKotlinClass(ToMany::class.java))) {
                            isTransient = true
                            break
                        }
                    }
                    if (isTransient) {
                        iterator = simpleNameList.iterator()
                        while (iterator.hasNext()) {
                            val manyRelation = manyRelation(annotations, iterator.next(), variableType)
                            manyRelations.add(manyRelation)
                        }
                    } else {
                        iterator = simpleNameList.iterator()
                        while (iterator.hasNext()) {
                            val parsedProperty = parseProperty(annotations, iterator.next(), fieldDeclaration, variableType)
                            properties.add(parsedProperty)
                        }
                    }
                }
            }
        } else {
            val generatorHint = getGeneratorHint(annotations)
            if (generatorHint != null && generatorHint is GeneratorHint.Generated) {
                checkUntouched(fieldDeclaration as ASTNode, generatorHint)
            }
            val iterator = annotations.iterator()
            while (iterator.hasNext()) {
                transientField = TransientField(Variable(variableType, iterator.next().toString()), fieldDeclaration, generatorHint)
                transientFields.add(transientField)
            }

        }
        if (usedNotNullAnnotation == null) {
            val iterator = annotations.iterator()
            val annotation: org.greenrobot.eclipse.jdt.core.dom.Annotation?
            while (true) {
                if (!iterator.hasNext()) {
                    annotation = null
                    break
                }
                val it = iterator.next()
                if (Intrinsics.areEqual(it.typeName.fullyQualifiedName, "NotNull") || Intrinsics.areEqual(it.typeName.fullyQualifiedName, "NonNull")) {
                    annotation = it
                    break
                }
            }

            var fullName = annotation?.typeName?.fullyQualifiedName
            if (fullName != null) {
                fullName = "@$fullName"
            }

            usedNotNullAnnotation = fullName
        }
        lastField = fieldDeclaration
    }

    private fun getCodePlace(astNode: ASTNode): String {
        val sb = StringBuilder()

        val newString = typeDeclaration?.name?.identifier
        return if (newString != null)
            sb.append(newString).append(":").append(JdtUtilsKt.getLineNumber(astNode)).toString()
        else
            java.lang.StringBuilder().append(null as String?).append(":").append(JdtUtilsKt.getLineNumber(astNode)).toString()
    }

    private fun getOriginalCode(astNode: ASTNode): String =
            source.substring(IntRange(astNode.startPosition, astNode.startPosition + astNode.length - 1))

    private fun checkUntouched(astNode: ASTNode, hint: GeneratorHint.Generated) {
        if (hint.hash != -1 && hint.hash != CodeCompare.INSTANCE.codeHash(getOriginalCode(astNode))) {
            val var10000: String
            var10000 = if (astNode is MethodDeclaration) {
                if (astNode.isConstructor) "Constructor"
                else "Method '${astNode.name}'"
            } else if (astNode is FieldDeclaration) {
                StringBuilder().append("Field '").append(getOriginalCode(astNode).trim()).append("'").toString()
            } else {
                "Node"
            }
            throw (RuntimeException(("""
                        $var10000 (see ${getCodePlace(astNode)}) has been changed after generation.
                        Please either mark it with @Keep annotation instead of @Generated to keep it untouched,
                        or use @Generated (without hash) to allow to replace it.
                        """).trimIndent()) as Throwable)
        }
    }

    private fun getGeneratorHint(list: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>): GeneratorHint? {
        var iterable = list
        val isKeep: Boolean
        while (true) {
            val iterator = iterable.iterator()
            if (iterator.hasNext()) {
                if (!hasType(iterator.next(), Reflection.getOrCreateKotlinClass(Keep::class.java))) {
                    continue
                }
                isKeep = true
                break
            }
            isKeep = false
            break
        }
        val generatorHint: GeneratorHint?
        if (isKeep) {
            generatorHint = GeneratorHint.Keep.INSTANCE as GeneratorHint
        } else {
            iterable = list
            val iterator = iterable.iterator()
            val annotation: org.greenrobot.eclipse.jdt.core.dom.Annotation?
            while (true) {
                if (!iterator.hasNext()) {
                    annotation = null
                    break
                }
                val it = iterator.next()
                if (hasType(it, Reflection.getOrCreateKotlinClass(Generated::class.java))) {
                    annotation = it
                    break
                }
            }

            val generated = if (annotation != null) {
                AnnotationProxy.INSTANCE.invoke(annotation, Generated::class.java) as Generated?
            } else {
                null
            }
            val generated1: GeneratorHint.Generated? = if (generated != null) {
                GeneratorHint.Generated(generated.hash())
            } else {
                null
            }
            generatorHint = generated1
        }
        return generatorHint
    }

    private fun getHasNotNull(list: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>): Boolean {
        val iterator = list.iterator()
        val hasNotNull: Boolean
        while (true) {
            if (!iterator.hasNext()) {
                hasNotNull = false
                break
            }
            val it = iterator.next()
            if (Intrinsics.areEqual(it.typeName.fullyQualifiedName, "NotNull") || Intrinsics.areEqual(it.typeName.fullyQualifiedName, "NonNull")) {
                hasNotNull = true
                break
            }
        }
        return hasNotNull
    }

    private fun has(list: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>): Boolean {
        val iterator = list.iterator()
        val has: Boolean
        while (true) {
            if (iterator.hasNext()) {
                Intrinsics.reifiedOperationMarker(4, "A")
                if (!hasType(iterator.next(), Reflection.getOrCreateKotlinClass(Any::class.java))) {
                    continue
                }
                has = true
                break
            }
            has = false
            break
        }
        return has
    }

    private fun proxy(list: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>): Annotation? {
        val iterator = list.iterator()
        var annotation: org.greenrobot.eclipse.jdt.core.dom.Annotation?
        while (true) {
            if (iterator.hasNext()) {
                val it = iterator.next()
                Intrinsics.reifiedOperationMarker(4, "T")
                if (!hasType(it, Reflection.getOrCreateKotlinClass(Annotation::class.java))) {
                    continue
                }
                annotation = it
                break
            }
            annotation = null
            break
        }

        if (annotation != null) {
            Intrinsics.reifiedOperationMarker(4, "T")
            annotation = AnnotationProxy.INSTANCE.invoke(annotation, Annotation::class.java) as org.greenrobot.eclipse.jdt.core.dom.Annotation?
            Intrinsics.reifiedOperationMarker(1, "T")
        } else {
            annotation = null
        }
        return annotation as Annotation?
    }

    private fun oneRelation(annotationList: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>, fieldName: SimpleName, variableType: VariableType): OneRelation {
        var iterator = annotationList.iterator()
        var annotation: org.greenrobot.eclipse.jdt.core.dom.Annotation
        var holder: Any?
        while (true) {
            if (iterator.hasNext()) {
                annotation = iterator.next()
                if (!hasType(annotation, Reflection.getOrCreateKotlinClass(ToOne::class.java))) {
                    continue
                }
                holder = annotation
                break
            }
            holder = null
            break
        }
        var annotation1 = holder
        var annotation3: Annotation?
        if (annotation1 != null) {
            holder = AnnotationProxy.INSTANCE.invoke(annotation1 as org.greenrobot.eclipse.jdt.core.dom.Annotation, ToOne::class.java) as ToOne?
            if (holder == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.ToOne")
            }
            annotation3 = holder as ToOne?
        } else {
            annotation3 = null
        }
        if (annotation3 == null) {
            Intrinsics.throwNpe()
        }
        val proxy = annotation3 as ToOne?
        val variable = Variable(variableType, fieldName.toString())
        val foreignKeyField = FunsKt.nullIfBlank(proxy!!.joinProperty())
        iterator = annotationList.iterator()
        while (true) {
            if (iterator.hasNext()) {
                val item = iterator.next()
                if (!hasType(item, Reflection.getOrCreateKotlinClass(Property::class.java))) {
                    continue
                }
                holder = item
                break
            }
            holder = null
            break
        }
        annotation1 = holder as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        if (annotation1 != null) {
            holder = AnnotationProxy.INSTANCE.invoke(annotation1, Property::class.java) as Property?
            if (holder == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Property")
            }
            annotation3 = holder as Property?
        } else {
            annotation3 = null
        }
        var columnName: String? = (annotation3 as Property?)?.nameInDb
        if (columnName != null) columnName = FunsKt.nullIfBlank(columnName)

        val iterator1 = annotationList.iterator()
        val hasUnique: Boolean
        while (true) {
            if (iterator1.hasNext()) {
                if (!hasType(iterator1.next(), Reflection.getOrCreateKotlinClass(Unique::class.java))) {
                    continue
                }
                hasUnique = true
                break
            }
            hasUnique = false
            break
        }
        return OneRelation(variable, foreignKeyField, columnName, getHasNotNull(annotationList), hasUnique)
    }

    private fun manyRelation(annotationList: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>, fieldName: SimpleName, variableType: VariableType): ManyRelation {
        val var7 = annotationList as Iterable<*>
        val var9 = var7.iterator()
        var var10000: Any?
        while (true) {
            if (var9.hasNext()) {
                val var10 = var9.next()!!
                val `it$iv` = var10 as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(ToMany::class.java))) {
                    continue
                }
                var10000 = var10
                break
            }
            var10000 = null
            break
        }
        var var47 = var10000 as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        var var48: Annotation?
        if (var10000 != null) {
            val var26 = var47
            var10000 = AnnotationProxy.INSTANCE.invoke(var26!!, ToMany::class.java) as ToMany?
            if (var10000 == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.ToMany")
            }
            var48 = var10000 as ToMany?
        } else {
            var48 = null
        }
        if (var48 == null) {
            Intrinsics.throwNpe()
        }
        val proxy = var48 as ToMany?
        val var6 = annotationList as Iterable<*>
        val var29 = var6.iterator()
        while (true) {
            if (var29.hasNext()) {
                val var34 = var29.next()!!
                val `it$iv` = var34 as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(JoinEntity::class.java))) {
                    continue
                }
                var10000 = var34
                break
            }
            var10000 = null
            break
        }
        if (var10000 !is NormalAnnotation) {
            var10000 = null
        }
        val joinEntityAnnotation = var10000 as NormalAnnotation?
        val var35 = annotationList as Iterable<*>
        val var40 = var35.iterator()
        while (true) {
            if (var40.hasNext()) {
                val var12 = var40.next()!!
                val `it$iv` = var12 as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(OrderBy::class.java))) {
                    continue
                }
                var10000 = var12
                break
            }
            var10000 = null
            break
        }
        var47 = var10000 as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        if (var10000 != null) {
            val var37 = var47
            var10000 = AnnotationProxy.INSTANCE.invoke(var37!!, OrderBy::class.java) as OrderBy?
            if (var10000 == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.OrderBy")
            }
            var48 = var10000 as OrderBy?
        } else {
            var48 = null
        }
        val orderByAnnotation = var48 as OrderBy?
        val var10005 = fieldName.toString()
        var variable: Variable? = Variable(variableType, var10005)
        var mappedBy = FunsKt.nullIfBlank(proxy!!.referencedJoinProperty())
        val joinPropertyArray = proxy.joinProperties() as Array<org.greenrobot.greendao.annotation.JoinProperty>
        var var19 = mappedBy
        var var18 = variable

        val mutableList = mutableListOf<JoinOnProperty>()
        for (joinPropertyIndex in joinPropertyArray.indices) {
            val joinProperty = joinPropertyArray[joinPropertyIndex]
            val var21 = JoinOnProperty(joinProperty.name(), joinProperty.referencedName())
            mutableList.add(var21)
        }
        var var20: List<*>? = mutableList as List<*>

        variable = var18
        mappedBy = var19
        var joinOnProperties = var20
        var joinEntitySpec: JoinEntitySpec?
        var var54: JoinEntitySpec?
        if (joinEntityAnnotation != null) {
            val it = joinEntityAnnotation
            var10000 = AnnotationProxy.INSTANCE.invoke((it as org.greenrobot.eclipse.jdt.core.dom.Annotation), JoinEntity::class.java) as JoinEntity?
            if (var10000 == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.JoinEntity")
            }
            val joinProxy = var10000 as JoinEntity
            //         ;
            val var50 = JdtUtilsKt.get(it, "entity")
                    ?: throw TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.TypeLiteral")
            var54 = JoinEntitySpec(getTypeName((var50 as TypeLiteral).type), joinProxy.sourceProperty(), joinProxy.targetProperty())

            variable = var18
            mappedBy = var19
            joinOnProperties = var20
            joinEntitySpec = var54
        } else {
            joinEntitySpec = null
        }
        val order: List<*>?
        if (orderByAnnotation != null) {
            var54 = joinEntitySpec
            var20 = joinOnProperties
            var19 = mappedBy
            var18 = variable

            val it: OrderBy = orderByAnnotation
            val spec: String = it.value()
            val var57: List<*>
            if (spec.isBlank()) {
                var57 = emptyList<Any>()
            } else {
                val var45: List<*>
                var45 = try {
                    FunsKt.parseIndexSpec(spec)
                } catch (var23: IllegalArgumentException) {
                    val var52 = typeDeclaration
                    val var49 = "Can't parse @OrderBy.value for ${var52?.name}.$fieldName because of: ${var23.message}."
                    throw RuntimeException(var49, var23)
                }
                var57 = var45
            }

            variable = var18
            mappedBy = var19
            joinOnProperties = var20
            joinEntitySpec = var54
            order = var57
        } else {
            order = null
        }
        return ManyRelation(variable!!, mappedBy, joinOnProperties!!, joinEntitySpec, order)
    }

    private fun parseProperty(annotationList: List<org.greenrobot.eclipse.jdt.core.dom.Annotation>, fieldName: SimpleName, node: FieldDeclaration, variableType: VariableType): ParsedProperty {
        val var8: Iterable<*> = annotationList
        val var10 = var8.iterator()
        var var10000: Any?
        while (true) {
            if (var10.hasNext()) {
                val var11 = var10.next()!!
                val `it$iv` = var11 as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(Property::class.java))) {
                    continue
                }
                var10000 = var11
                break
            }
            var10000 = null
            break
        }
        var var50 = var10000 as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        var var51: Annotation?
        if (var50 != null) {
            val var29: org.greenrobot.eclipse.jdt.core.dom.Annotation = var50
            val `it$iv`: org.greenrobot.eclipse.jdt.core.dom.Annotation
            `it$iv` = var29
            var10000 = AnnotationProxy.INSTANCE.invoke(`it$iv`, Property::class.java) as Property?
            if (var10000 == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Property")
            }
            var51 = var10000 as Property?
        } else {
            var51 = null
        }
        val columnAnnotation = var51 as Property?
        val var32 = annotationList as Iterable<*>
        val var39 = var32.iterator()
        while (true) {
            if (var39.hasNext()) {
                val var44 = var39.next()!!
                val `it$iv` = var44 as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(Index::class.java))) {
                    continue
                }
                var10000 = var44
                break
            }
            var10000 = null
            break
        }
        var50 = var10000 as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        if (var50 != null) {
            val `it$iv`: org.greenrobot.eclipse.jdt.core.dom.Annotation?
            `it$iv` = var50
            var10000 = AnnotationProxy.INSTANCE.invoke(`it$iv`, Index::class.java) as Index?
            if (var10000 == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Index")
            }
            var51 = var10000 as Index?
        } else {
            var51 = null
        }
        val indexAnnotation = var51 as Index?
        val var38 = annotationList as Iterable<*>
        var var47 = var38.iterator()
        var `it$iv`: org.greenrobot.eclipse.jdt.core.dom.Annotation
        var `element$iv$iv`: Any
        while (true) {
            if (var47.hasNext()) {
                `element$iv$iv` = var47.next()!!
                `it$iv` = `element$iv$iv` as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(Id::class.java))) {
                    continue
                }
                var10000 = `element$iv$iv`
                break
            }
            var10000 = null
            break
        }
        var50 = var10000 as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        if (var50 != null) {
            `it$iv` = var50
            var10000 = AnnotationProxy.INSTANCE.invoke(`it$iv`, Id::class.java) as Id?
            if (var10000 == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Id")
            }
            var51 = var10000 as Id?
        } else {
            var51 = null
        }
        val idAnnotation: Id? = var51 as Id?

        var isUnique: Boolean = indexAnnotation?.value?.isBlank() ?: false

        if (isUnique) {
            val var56: String? = typeDeclaration?.name?.identifier
            throw RuntimeException(StringBuilder().append("greenDAO: setting value on @Index is not supported if @Index is used on the properties").append("\n").append("                See '").append(fieldName).append("' in ")
                    .append(var56).toString())
        } else {
            val customType = findConvert(fieldName, annotationList)
            val variable: Variable? = Variable(variableType, fieldName.toString())
            val entityIdParams: EntityIdParams? = if (idAnnotation != null) {
                EntityIdParams(idAnnotation.autoincrement())
            } else {
                null
            }
            val propertyIndex: PropertyIndex? = if (indexAnnotation != null) {
                PropertyIndex(FunsKt.nullIfBlank(indexAnnotation.name()), indexAnnotation.unique())
            } else {
                null
            }
            val isNotNull: Boolean = node.type.isPrimitiveType || getHasNotNull(annotationList)
            var dbName: String? = columnAnnotation?.nameInDb
            if (dbName != null) dbName = FunsKt.nullIfBlank(dbName)

            val `$receiver$iv$iv` = annotationList as Iterable<*>
            var47 = `$receiver$iv$iv`.iterator()
            while (true) {
                if (var47.hasNext()) {
                    `element$iv$iv` = var47.next()!!
                    `it$iv` = `element$iv$iv` as org.greenrobot.eclipse.jdt.core.dom.Annotation
                    if (!hasType(`it$iv`, Reflection.getOrCreateKotlinClass(Unique::class.java))) {
                        continue
                    }
                    isUnique = true
                    break
                }
                isUnique = false
                break
            }
            return ParsedProperty(variable!!, entityIdParams, propertyIndex, isNotNull, dbName, customType, isUnique)
        }
    }

    private fun findConvert(fieldName: SimpleName, fa: List<*>): CustomType? {
        val var4 = fa as Iterable<*>
        val var6 = var4.iterator()
        val var10000: Any?
        while (true) {
            if (var6.hasNext()) {
                val var7 = var6.next()!!
                val it = var7 as org.greenrobot.eclipse.jdt.core.dom.Annotation
                if (!hasType(it, Reflection.getOrCreateKotlinClass(Convert::class.java))) {
                    continue
                }
                var10000 = var7
                break
            }
            var10000 = null
            break
        }
        val convert = var10000 as org.greenrobot.eclipse.jdt.core.dom.Annotation?
        return if (convert !is NormalAnnotation) {
            null
        } else {
            var var11 = JdtUtilsKt.get((convert as NormalAnnotation?)!!, "converter")
            if (var11 !is TypeLiteral) {
                var11 = null
            }

            val type = (var11 as TypeLiteral?)?.type
            val var14: String? = if (type != null) getTypeName(type)
            else null

            val converterClassName = var14
            var11 = JdtUtilsKt.get((convert as NormalAnnotation?)!!, "columnType")
            if (var11 !is TypeLiteral) {
                var11 = null
            }
            val columnType = if (var11 as TypeLiteral? != null) (var11 as TypeLiteral?)!!.type else null
            if (converterClassName != null && columnType != null) {
                CustomType(converterClassName, toVariableType(columnType))
            } else {
                val s: String? = typeDeclaration?.name?.identifier
                val var10002: StringBuilder = StringBuilder().append("Missing @Convert arguments for field '").append(fieldName).append("' in ")
                throw RuntimeException(var10002.append(s).toString())
            }
        }
    }

    override fun visit(node: MethodDeclaration): Boolean = isEntity

    override fun endVisit(methodDeclaration: MethodDeclaration) {
        Intrinsics.checkParameterIsNotNull(methodDeclaration, "node")
        val generatorHint = getGeneratorHint(methodAnnotations)
        if (generatorHint is GeneratorHint.Generated) {
            checkUntouched(methodDeclaration as ASTNode, generatorHint)
        }
//        var var10000: Method
        val name = methodDeclaration.name.fullyQualifiedName
        Intrinsics.checkExpressionValueIsNotNull(name, "node.name.fullyQualifiedName")
        var `$receiver$iv` = methodDeclaration.parameters()
//        var var14 = var10000
//        val var13 :Method
        var `destination$iv$iv` = mutableListOf<Any?>()
        var var7 = `$receiver$iv`.iterator()
        var `item$iv$iv`: Any?
        while (var7.hasNext()) {
            `item$iv$iv` = var7.next()
            if (`item$iv$iv` is SingleVariableDeclaration) {
                `destination$iv$iv`.add(`item$iv$iv`)
            }
        }
        var parameters = `destination$iv$iv` as List<*>
        `$receiver$iv` = parameters
        `destination$iv$iv` = mutableListOf()
        var7 = `$receiver$iv`.iterator()
        while (var7.hasNext()) {
            `item$iv$iv` = var7.next()
            if (`item$iv$iv` == null) {
                throw TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.SingleVariableDeclaration")
            }
            val var17 = `item$iv$iv` as SingleVariableDeclaration
            `destination$iv$iv`.add(var17)
        }
        parameters = `destination$iv$iv`
        `$receiver$iv` = parameters
        `destination$iv$iv` = mutableListOf()
        var7 = `$receiver$iv`.iterator()
        while (var7.hasNext()) {
            `item$iv$iv` = var7.next()
            val it = `item$iv$iv` as SingleVariableDeclaration?
            val var20 = toVariableType(it!!.type)
            val var10003 = it.name.identifier
            Intrinsics.checkExpressionValueIsNotNull(var10003, "it.name.identifier")
            val var19 = Variable(var20, var10003)
            `destination$iv$iv`.add(var19)
        }
        parameters = `destination$iv$iv`
        var var14 = Method(name, parameters, methodDeclaration, generatorHint) // TODO: Looks like this should be added to the lists, but wrong type (Method vs MethodDeclaration)
        if (methodDeclaration.isConstructor) {
            constructors.add(methodDeclaration)
        } else {
            methods.add(methodDeclaration)
        }
        methodAnnotations.clear()
    }

    override fun visit(enumDeclaration: EnumDeclaration): Boolean {
        staticInnerClasses.add(enumDeclaration.name.identifier)
        return false
    }

    override fun visit(node: TypeDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return if (node.parent is TypeDeclaration) {
            if (Modifier.isStatic(node.modifiers)) {
                val var10000 = staticInnerClasses
                val var10001 = node.name.identifier
                Intrinsics.checkExpressionValueIsNotNull(var10001, "node.name.identifier")
                var10000.add(var10001)
            }
            false
        } else {
            typeDeclaration = node
            true
        }
    }

    private fun checkInnerCustomTypes() {
        val var10000 = typeDeclaration
        if (var10000 != null) {
            val var10 = var10000.name
            if (var10 != null) {
                val var11 = var10.identifier
                if (var11 != null) {
                    val `$receiver$iv` = properties as Iterable<*>
                    val var3 = `$receiver$iv`.iterator()
                    while (var3.hasNext()) {
                        val `element$iv` = var3.next()!!
                        val it = `element$iv` as ParsedProperty
                        if (it.customType != null) {
                            val variableClassName = it.variable.type.name
                            checkIfInnerTypeThenStatic(variableClassName, var11)
                            val converterClassName = it.customType!!.converterClassName
                            checkIfInnerTypeThenStatic(converterClassName, var11)
                        }
                    }
                    return
                }
            }
        }
    }

    private fun checkIfInnerTypeThenStatic(typeClassName: String, outerClassName: String) {
        val split = typeClassName.split(".", ignoreCase = false, limit = 6)
        if (split.size >= 2) {
            val qualifiedNames: List<*> = split.takeLast<Any>(2)
            require(!(outerClassName == qualifiedNames[0] && !staticInnerClasses.contains(qualifiedNames[1]))) { "Inner class $typeClassName in $outerClassName has to be static. Only static classes are supported if converters or custom types (@Convert) are defined as inner classes." }
        }
    }

//    fun getSchemaName(): String {
//        return schemaName
//    }
//
//    fun setSchemaName(var1: String) {
//        Intrinsics.checkParameterIsNotNull(var1, "<set-?>")
//        schemaName = var1
//    }
//
//    fun getProperties(): List<*> {
//        return properties
//    }
//
//    fun getTransientFields(): List<*> {
//        return transientFields
//    }
//
//    fun getLegacyTransientFields(): List<*> {
//        return legacyTransientFields
//    }
//
//    fun getConstructors(): List<*> {
//        return constructors
//    }
//
//    fun getMethods(): List<*> {
//        return methods
//    }
//
//    fun getImports(): List<*> {
//        return imports
//    }
//
//    fun getStaticInnerClasses(): List<*> {
//        return staticInnerClasses
//    }
//
//    fun getOneRelations(): List<*> {
//        return oneRelations
//    }
//
//    fun getManyRelations(): List<*> {
//        return manyRelations
//    }
//
//    fun getTableIndexes(): List<*> {
//        return tableIndexes
//    }
//
//    fun setTableIndexes(var1: List<*>) {
//        Intrinsics.checkParameterIsNotNull(var1, "<set-?>")
//        tableIndexes = var1
//    }
//
//    fun getUsedNotNullAnnotation(): String? {
//        return usedNotNullAnnotation
//    }
//
//    fun setUsedNotNullAnnotation(var1: String?) {
//        usedNotNullAnnotation = var1
//    }

//    companion object {
//        // $FF: synthetic method
//        fun `access$hasType`(`$this`: EntityClassASTVisitor, `$receiver`: org.greenrobot.eclipse.jdt.core.dom.Annotation, klass: KClass<*>): Boolean {
//            return `$this`.hasType(`$receiver`, klass)
//        }
//    }
}