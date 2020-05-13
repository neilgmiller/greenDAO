package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.generator.*
import kotlin.jvm.internal.Intrinsics

class GreendaoModelTranslator private constructor() {

    fun translate(entities: Iterable<ParsedEntity>, schema: Schema, daoPackage: String?): Map<ParsedEntity, Entity> {
        val mapping = mapEntityClassesToEntities(entities, schema, daoPackage)
        resolveToOneRelations(mapping, entities, schema)
        resolveToManyRelations(mapping, entities, schema)
        return mapping
    }

    private fun mapEntityClassesToEntities(entities: Iterable<ParsedEntity>, schema: Schema, daoPackage: String?): Map<ParsedEntity, Entity> {
        val newList = mutableListOf<Pair<ParsedEntity, Entity>>()
        val iterator = entities.iterator()
        while (iterator.hasNext()) {
            val parsedEntity = iterator.next()
            val entity = schema.addEntity(parsedEntity.name)
            Intrinsics.checkExpressionValueIsNotNull(entity, "entity")
            INSTANCE.addBasicProperties(daoPackage, parsedEntity, entity)
            if (parsedEntity.dbName != null) {
                entity.dbName = parsedEntity.dbName
            }
            if (parsedEntity.active) {
                entity.active = true
            }
            entity.isSkipCreationInDb = !parsedEntity.createInDb
            entity.javaPackage = parsedEntity.packageName
            Intrinsics.checkExpressionValueIsNotNull(entity, "entity")
            INSTANCE.convertProperties(parsedEntity, entity)
            Intrinsics.checkExpressionValueIsNotNull(entity, "entity")
            INSTANCE.addIndexes(parsedEntity, entity)
            if (parsedEntity.protobufClassName != null) {
                val protobufEntity = schema.addProtobufEntity(parsedEntity.protobufClassName.substringAfterLast("."))
                Intrinsics.checkExpressionValueIsNotNull(protobufEntity, "protobufEntity")
                INSTANCE.addBasicProperties(daoPackage, parsedEntity, protobufEntity)
                protobufEntity.dbName = entity.dbName
                protobufEntity.active = false
                protobufEntity.isSkipCreationInDb = true
                protobufEntity.javaPackage = parsedEntity.protobufClassName.substringAfterLast(".")
                Intrinsics.checkExpressionValueIsNotNull(protobufEntity, "protobufEntity")
                INSTANCE.convertProperties(parsedEntity, protobufEntity)
                Intrinsics.checkExpressionValueIsNotNull(protobufEntity, "protobufEntity")
                INSTANCE.addIndexes(parsedEntity, protobufEntity)
            }
            newList.add(parsedEntity to entity)
        }
        return newList.toMap()
    }

    private fun addBasicProperties(daoPackage: String?, it: ParsedEntity, entity: Entity) {
        entity.isConstructors = it.generateConstructors
        var var10001 = daoPackage
        if (daoPackage == null) {
            var10001 = it.packageName
        }
        entity.javaPackageDao = var10001
        var10001 = daoPackage
        if (daoPackage == null) {
            var10001 = it.packageName
        }
        entity.javaPackageTest = var10001
        entity.isSkipGeneration = true
    }

    private fun convertProperties(parsedEntity: ParsedEntity, entity: Entity) {
        var var10000: List<*>? = parsedEntity.propertiesInConstructorOrder
        if (var10000 == null) {
            var10000 = parsedEntity.properties
        }
        val properties: List<*> = var10000
        val `$receiver$iv` = properties as Iterable<*>
        val var5 = `$receiver$iv`.iterator()
        while (var5.hasNext()) {
            val `element$iv` = var5.next()!!
            val it = `element$iv` as ParsedProperty
            try {
                INSTANCE.convertProperty(entity, it)
            } catch (var11: Exception) {
                throw RuntimeException("Can't add property '${it.variable}' to entity ${parsedEntity.name} due to: ${var11.message}", var11 as Throwable)
            }
        }
    }

    // TODO: What to do?
    private fun addIndexes(it: ParsedEntity, entity: Entity) { // $FF: Couldn't be decompiled
    }

    private fun resolveToOneRelations(mapping: Map<ParsedEntity, Entity>, entities: Iterable<ParsedEntity>, schema: Schema) {
        val parsedEntityList = mutableListOf<ParsedEntity>()
        val iterator = entities.iterator()
        while (iterator.hasNext()) {
            val it = iterator.next()
            if (!it.oneRelations.isEmpty()) {
                parsedEntityList.add(it)
            }
        }
        val parsedEntityIterator = parsedEntityList.iterator()
        label84@ while (parsedEntityIterator.hasNext()) {
            val entity = parsedEntityIterator.next()
            var var10000 = mapping[entity]
            if (var10000 == null) {
                Intrinsics.throwNpe()
            }
            val source = var10000
            val oneRelationIterator = entity.oneRelations.iterator()
            while (true) {
                while (true) {
                    if (!oneRelationIterator.hasNext()) {
                        continue@label84
                    }
                    val relation = oneRelationIterator.next()
                    val entityIterator = schema.entities.iterator()
                    while (true) {
                        if (!entityIterator.hasNext()) {
                            var10000 = null
                            break
                        }

                        val entity1 = entityIterator.next()
                        if (Intrinsics.areEqual(entity1.className, relation.variable.type.simpleName)) {
                            var10000 = entity1
                            break
                        }
                    }
                    val targetEntity = var10000
                            ?: throw RuntimeException("Class ${relation.variable.type.name} marked with @ToOne in class ${entity.name} is not an entity")
                    val newProperty :Property?
                    if (relation.foreignKeyField != null) {
                        val propertyIterator = source!!.properties.iterator()
                        while (true) {
                            if (!propertyIterator.hasNext()) {
                                newProperty = null
                                break
                            }
                            val property = propertyIterator.next()
                            if (Intrinsics.areEqual(property.propertyName, relation.foreignKeyField)) {
                                newProperty = property
                                break
                            }
                        }
                        val property = newProperty
                                ?: throw RuntimeException("Can't find ${relation.foreignKeyField} in ${entity.name} for @ToOne relation")
                        if (relation.columnName != null || relation.unique) {
                            throw (RuntimeException("If @ToOne with foreign property used, @Column and @Unique are ignored. See ${entity.name}.${relation.variable.name}") as Throwable)
                        }
                        source.addToOne(targetEntity, property, relation.variable.name)
                    } else {
                        val name = relation.variable.name
                        var fkColumnName = relation.columnName
                        if (fkColumnName == null) {
                            fkColumnName = DaoUtil.dbName(relation.variable.name)
                        }
                        source!!.addToOneWithoutProperty(name, targetEntity, fkColumnName, relation.isNotNull, relation.unique)
                    }
                }
            }
        }
    }

    // TODO: What to do?
    private fun resolveToManyRelations(mapping: Map<*, *>, entities: Iterable<ParsedEntity>, schema: Schema) { // $FF: Couldn't be decompiled
    }

    private fun convertProperty(entity: Entity, property: ParsedProperty) {
        val variableType: VariableType = property.customType?.columnJavaType
                ?: property.variable.type

        val propertyType = convertPropertyType(variableType.name)
        val propertyBuilder = entity.addProperty(propertyType, property.variable.name)
        if (property.variable.type.isPrimitive) {
            propertyBuilder.notNull()
        } else if (WRAPPER_TYPES.contains(property.variable.type.name)) {
            propertyBuilder.nonPrimitiveType()
        }
        if (property.isNotNull) {
            propertyBuilder.notNull()
        }
        if (property.unique && property.index != null) {
            throw (RuntimeException("greenDAO: having unique constraint and index on the field at the same time is redundant. Either @Unique or @Index should be used") as Throwable)
        } else {
            if (property.unique) {
                propertyBuilder.unique()
            }
            if (property.index != null) {
                propertyBuilder.indexAsc(property.index.name, property.index.unique)
            }
            if (property.id != null) {
                propertyBuilder.primaryKey()
                if (property.id.autoincrement) {
                    propertyBuilder.autoincrement()
                }
            }
            if (property.dbName != null) {
                propertyBuilder.dbName(property.dbName)
            } else if (property.id != null && Intrinsics.areEqual(propertyType, PropertyType.Long)) {
                propertyBuilder.dbName("_id")
            }
            if (property.customType != null) {
                propertyBuilder.customType(property.variable.type.name, property.customType.converterClassName)
            }
        }
    }

    private fun convertPropertyType(javaTypeName: String): PropertyType {
        when (javaTypeName.hashCode()) {
            -2056817302 -> {
                if (javaTypeName != "java.lang.Integer") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Int
            }
            -1808118735 -> {
                if (javaTypeName != "String") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.String
            }
            -1374008726 -> {
                if (javaTypeName != "byte[]") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.ByteArray
            }
            -1325958191 -> {
                if (javaTypeName != "double") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Double
            }
            -672261858 -> {
                if (javaTypeName != "Integer") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Int
            }
            -527879800 -> {
                if (javaTypeName != "java.lang.Float") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Float
            }
            -515992664 -> {
                if (javaTypeName != "java.lang.Short") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Short
            }
            104431 -> {
                if (javaTypeName != "int") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Int
            }
            2086184 -> {
                if (javaTypeName != "Byte") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Byte
            }
            2122702 -> {
                if (javaTypeName != "Date") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Date
            }
            2374300 -> {
                if (javaTypeName != "Long") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Long
            }
            3039496 -> {
                if (javaTypeName != "byte") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Byte
            }
            3327612 -> {
                if (javaTypeName != "long") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Long
            }
            64711720 -> {
                if (javaTypeName != "boolean") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Boolean
            }
            65575278 -> {
                if (javaTypeName != "java.util.Date") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Date
            }
            67973692 -> {
                if (javaTypeName != "Float") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Float
            }
            79860828 -> {
                if (javaTypeName != "Short") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Short
            }
            97526364 -> {
                if (javaTypeName != "float") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Float
            }
            109413500 -> {
                if (javaTypeName != "short") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Short
            }
            344809556 -> {
                if (javaTypeName != "java.lang.Boolean") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Boolean
            }
            398507100 -> {
                if (javaTypeName != "java.lang.Byte") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Byte
            }
            398795216 -> {
                if (javaTypeName != "java.lang.Long") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Long
            }
            761287205 -> {
                if (javaTypeName != "java.lang.Double") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Double
            }
            1195259493 -> {
                if (javaTypeName != "java.lang.String") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.String
            }
            1729365000 -> {
                if (javaTypeName != "Boolean") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Boolean
            }
            2052876273 -> {
                if (javaTypeName != "Double") throw RuntimeException("Unsupported type $javaTypeName")
                return PropertyType.Double
            }
            else -> throw RuntimeException("Unsupported type $javaTypeName")
        }
    }

    // TODO: What's happening with this?
    object WhenMappings {
        // $FF: synthetic field
        private val enumSwitchMapping0 = IntArray(Order.values().size)
        // $FF: synthetic field
        private val enumSwitchMapping1: IntArray

        init {
            enumSwitchMapping0[Order.ASC.ordinal] = 1
            enumSwitchMapping0[Order.DESC.ordinal] = 2
            enumSwitchMapping1 = IntArray(Order.values().size)
            enumSwitchMapping1[Order.ASC.ordinal] = 1
            enumSwitchMapping1[Order.DESC.ordinal] = 2
        }
    }

    // TODO Never used? Called by code that wasn't decompiled?
    private fun findProperty(`$receiver`: Entity, name: String): Property {
        val var3 = `$receiver`.properties as Iterable<*>
        val var5 = var3.iterator()
        val var10000: Any?
        while (true) {
            if (var5.hasNext()) {
                val var6 = var5.next()!!
                val it = var6 as Property
                if (!Intrinsics.areEqual(it.propertyName, name)) {
                    continue
                }
                var10000 = var6
                break
            }
            var10000 = null
            break
        }
        val var9 = var10000 as Property?
        return var9
                ?: throw (RuntimeException("Can't find $name field in ${`$receiver`.className}") as Throwable)
    }

    companion object {
        var INSTANCE: GreendaoModelTranslator = GreendaoModelTranslator()
        private var WRAPPER_TYPES = listOf("Boolean", "Byte", "Character", "Short", "Integer", "Long", "Float", "Double", "java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double")
    }
}