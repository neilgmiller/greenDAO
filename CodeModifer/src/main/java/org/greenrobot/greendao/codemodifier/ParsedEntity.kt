package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration
import org.greenrobot.eclipse.jdt.core.dom.ImportDeclaration
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclaration
import java.io.File
import java.util.*
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130\bHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00170\bHÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190\bHÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001b0\bHÆ\u0003J\t\u0010U\u001a\u00020\u001dHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010&HÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003J\t\u0010e\u001a\u00020\u0011HÆ\u0003J·\u0002\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001J\u0013\u0010g\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\t\u0010j\u001a\u00020kHÖ\u0001J\t\u0010l\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010!\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0013\u00104\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b;\u00107R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0011\u0010G\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bH\u0010.R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010.R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010.R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010+¨\u0006m"], d2 = ["Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "", "name", "", "schema", "active", "", "properties", "", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "transientFields", "Lorg/greenrobot/greendao/codemodifier/TransientField;", "legacyTransientFields", "constructors", "Lorg/greenrobot/greendao/codemodifier/Method;", "methods", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "imports", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "packageName", "dbName", "oneRelations", "Lorg/greenrobot/greendao/codemodifier/OneRelation;", "manyRelations", "Lorg/greenrobot/greendao/codemodifier/ManyRelation;", "indexes", "Lorg/greenrobot/greendao/codemodifier/TableIndex;", "sourceFile", "Ljava/io/File;", "source", "keepSource", "createInDb", "generateConstructors", "generateGettersSetters", "protobufClassName", "notNullAnnotation", "lastFieldDeclaration", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/io/File;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;)V", "getActive", "()Z", "getConstructors", "()Ljava/util/List;", "getCreateInDb", "getDbName", "()Ljava/lang/String;", "getGenerateConstructors", "getGenerateGettersSetters", "getImports", "getIndexes", "getKeepSource", "lastConstructorDeclaration", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "getLastConstructorDeclaration", "()Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "getLastFieldDeclaration", "()Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "lastMethodDeclaration", "getLastMethodDeclaration", "getLegacyTransientFields", "getManyRelations", "getMethods", "getName", "getNode", "()Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "getNotNullAnnotation", "getOneRelations", "getPackageName", "getProperties", "getProtobufClassName", "qualifiedClassName", "getQualifiedClassName", "getSchema", "getSource", "getSourceFile", "()Ljava/io/File;", "getTransientFields", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPropertiesInConstructorOrder", "hashCode", "", "toString", "greendao-code-modifier_main"])
class ParsedEntity(val name: String,
                   val schema: String,
                   val active: Boolean,
                   val properties: List<ParsedProperty>,
                   val transientFields: List<TransientField>,
                   val legacyTransientFields: List<TransientField>,
                   val constructors: List<MethodDeclaration>,
                   val methods: List<MethodDeclaration>,
                   val node: TypeDeclaration,
                   val imports: List<ImportDeclaration>,
                   val packageName: String,
                   val dbName: String?,
                   val oneRelations: List<OneRelation>,
                   val manyRelations: List<ManyRelation>,
                   val indexes: List<TableIndex>,
                   val sourceFile: File,
                   val source: String,
                   val keepSource: Boolean,
                   val createInDb: Boolean,
                   val generateConstructors: Boolean,
                   val generateGettersSetters: Boolean,
                   val protobufClassName: String?,
                   val notNullAnnotation: String?,
                   val lastFieldDeclaration: FieldDeclaration?) {

    val qualifiedClassName: String = "$packageName.$name"

    val lastMethodDeclaration: MethodDeclaration?
        get() {
            val var10000 = methods.lastOrNull() as Method?
            return var10000?.node
        }

    val lastConstructorDeclaration: MethodDeclaration?
        get() {
            val var10000 = constructors.lastOrNull() as Method?
            return var10000?.node
        }

    val propertiesInConstructorOrder: List<ParsedProperty>?
        get() {
            val variableList = mutableListOf<Variable>()
            val propertyIterator = properties.iterator()
            while (propertyIterator.hasNext()) {
                val variable = propertyIterator.next().variable
                variableList.add(variable)
            }

            val fieldVarsSet: Set<Variable> = variableList.toSet()
            val constructorIterator = constructors.iterator()
            val someMethod: Method?
            while (true) {
                if (constructorIterator.hasNext()) {
                    val constructorMethodDeclaration :MethodDeclaration? = constructorIterator.next()

                    val it = constructorMethodDeclaration as Method?
                    if (!Intrinsics.areEqual(it!!.parameters, fieldVarsSet)) {
                        continue
                    }
                    someMethod = constructorMethodDeclaration
                    break
                }
                someMethod = null
                break
            }

            return if (someMethod != null) {
                val propertiesIterable = properties
                propertiesIterable.sortedWith(ParsedEntityComparator(someMethod))
            } else {
                null
            }
        }

    fun copy(name: String, schema: String, active: Boolean, properties: List<ParsedProperty>, transientFields: List<TransientField>, legacyTransientFields: List<TransientField>, constructors: List<MethodDeclaration>, methods: List<MethodDeclaration>, node: TypeDeclaration, imports: List<ImportDeclaration>, packageName: String, dbName: String?, oneRelations: List<OneRelation>, manyRelations: List<ManyRelation>, indexes: List<TableIndex>, sourceFile: File, source: String, keepSource: Boolean, createInDb: Boolean, generateConstructors: Boolean, generateGettersSetters: Boolean, protobufClassName: String?, notNullAnnotation: String?, lastFieldDeclaration: FieldDeclaration?): ParsedEntity {
        return ParsedEntity(name, schema, active, properties, transientFields, legacyTransientFields, constructors, methods, node, imports, packageName, dbName, oneRelations, manyRelations, indexes, sourceFile, source, keepSource, createInDb, generateConstructors, generateGettersSetters, protobufClassName, notNullAnnotation, lastFieldDeclaration)
    }

    override fun toString(): String =
            "ParsedEntity(name=$name, schema=$schema, active=$active, properties=$properties, transientFields=$transientFields, legacyTransientFields=$legacyTransientFields, constructors=$constructors, methods=$methods, node=$node, imports=$imports, packageName=$packageName, dbName=$dbName, oneRelations=$oneRelations, manyRelations=$manyRelations, indexes=$indexes, sourceFile=$sourceFile, source=$source, keepSource=$keepSource, createInDb=$createInDb, generateConstructors=$generateConstructors, generateGettersSetters=$generateGettersSetters, protobufClassName=$protobufClassName, notNullAnnotation=$notNullAnnotation, lastFieldDeclaration=$lastFieldDeclaration)"

    override fun hashCode(): Int {
        var hash = name.hashCode() * 31
        hash = (hash + (schema.hashCode() ?: 0)) * 31

        var activeByte: Byte = if ( !active) 0 else 1
        hash = (hash + activeByte) * 31

        hash = (hash + properties.hashCode()) * 31
        hash = (hash + transientFields.hashCode()) * 31
        hash = (hash + legacyTransientFields.hashCode()) * 31
        hash = (hash + constructors.hashCode()) * 31
        hash = (hash + methods.hashCode()) * 31
        hash = (hash + node.hashCode()) * 31
        hash = (hash + imports.hashCode()) * 31
        hash = (hash + packageName.hashCode()) * 31
        hash = (hash + (dbName?.hashCode() ?: 0)) * 31
        hash = (hash + oneRelations.hashCode()) * 31
        hash = (hash + manyRelations.hashCode()) * 31
        hash = (hash + indexes.hashCode()) * 31
        hash = (hash + sourceFile.hashCode()) * 31
        hash = (hash + (source.hashCode() ?: 0)) * 31

        activeByte = if ( !keepSource) 0 else 1
        hash = (hash + activeByte) * 31

        activeByte = if ( !createInDb) 0 else 1
        hash = (hash + activeByte) * 31

        activeByte = if ( !generateConstructors) 0 else 1
        hash = (hash + activeByte) * 31

        activeByte = if ( !generateGettersSetters) 0 else 1
        hash = (hash + activeByte) * 31

        hash = (hash + (protobufClassName?.hashCode() ?: 0)) * 31
        hash = (hash + (notNullAnnotation?.hashCode() ?: 0)) * 31
        return hash + (lastFieldDeclaration?.hashCode() ?: 0)
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is ParsedEntity) {
                if (Intrinsics.areEqual(name, other.name) && Intrinsics.areEqual(schema, other.schema) && active == other.active && Intrinsics.areEqual(properties, other.properties) && Intrinsics.areEqual(transientFields, other.transientFields) && Intrinsics.areEqual(legacyTransientFields, other.legacyTransientFields) && Intrinsics.areEqual(constructors, other.constructors) && Intrinsics.areEqual(methods, other.methods) && Intrinsics.areEqual(node, other.node) && Intrinsics.areEqual(imports, other.imports) && Intrinsics.areEqual(packageName, other.packageName) && Intrinsics.areEqual(dbName, other.dbName) && Intrinsics.areEqual(oneRelations, other.oneRelations) && Intrinsics.areEqual(manyRelations, other.manyRelations) && Intrinsics.areEqual(indexes, other.indexes) && Intrinsics.areEqual(sourceFile, other.sourceFile) && Intrinsics.areEqual(source, other.source) && keepSource == other.keepSource && createInDb == other.createInDb && generateConstructors == other.generateConstructors && generateGettersSetters == other.generateGettersSetters && Intrinsics.areEqual(protobufClassName, other.protobufClassName) && Intrinsics.areEqual(notNullAnnotation, other.notNullAnnotation) && Intrinsics.areEqual(lastFieldDeclaration, other.lastFieldDeclaration)) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

    //@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"], d2 = ["kotlin/comparisons/ComparisonsKt__ComparisonsKt\$compareBy$2", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlin/jvm/functions/Function1;)V", "compare", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin-stdlib"])
    class ParsedEntityComparator internal constructor(val `$constructor$inlined`: Method) : Comparator<Any?> {

        override fun compare(a: Any?, b: Any?): Int {
            var it = a as ParsedProperty?
            val var10000 = `$constructor$inlined`.parameters.indexOf(it!!.variable) as Comparable<*>
            it = b as ParsedProperty?
            val var6 = `$constructor$inlined`.parameters.indexOf(it!!.variable)
            return compareValues(var10000, var6 as Comparable<*>)
        }
    }
}