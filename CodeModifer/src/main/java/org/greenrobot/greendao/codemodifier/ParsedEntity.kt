package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration
import org.greenrobot.eclipse.jdt.core.dom.ImportDeclaration
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclaration
import java.io.File
import java.util.*
import kotlin.jvm.internal.Intrinsics

class ParsedEntity(val name: String,
                   val schema: String,
                   val active: Boolean,
                   val properties: List<ParsedProperty>,
                   val transientFields: List<TransientField>,
                   val legacyTransientFields: List<TransientField>,
                   val constructors: List<Method>,
                   val methods: List<Method>,
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

    // TODO: this is never used
    val qualifiedClassName: String = "$packageName.$name"

    val lastMethodDeclaration: MethodDeclaration? = methods.lastOrNull()?.node

    val lastConstructorDeclaration: MethodDeclaration? = constructors.lastOrNull()?.node

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
                    val method = constructorIterator.next()
                    if (!Intrinsics.areEqual(method.parameters, fieldVarsSet)) {
                        continue
                    }
                    someMethod = method
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

    fun copy(name: String, schema: String, active: Boolean, properties: List<ParsedProperty>, transientFields: List<TransientField>, legacyTransientFields: List<TransientField>, constructors: List<Method>, methods: List<Method>, node: TypeDeclaration, imports: List<ImportDeclaration>, packageName: String, dbName: String?, oneRelations: List<OneRelation>, manyRelations: List<ManyRelation>, indexes: List<TableIndex>, sourceFile: File, source: String, keepSource: Boolean, createInDb: Boolean, generateConstructors: Boolean, generateGettersSetters: Boolean, protobufClassName: String?, notNullAnnotation: String?, lastFieldDeclaration: FieldDeclaration?): ParsedEntity {
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