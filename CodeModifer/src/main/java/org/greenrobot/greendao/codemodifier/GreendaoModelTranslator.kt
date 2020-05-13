package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.generator.*
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J4\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J2\u0010 \u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010\"\u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0014\u0010$\u001a\u00020%*\u00020\u00102\u0006\u0010&\u001a\u00020\u0005H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006'"], d2 = ["Lorg/greenrobot/greendao/codemodifier/GreendaoModelTranslator;", "", "()V", "WRAPPER_TYPES", "", "", "getWRAPPER_TYPES", "()Ljava/util/List;", "setWRAPPER_TYPES", "(Ljava/util/List;)V", "addBasicProperties", "", "daoPackage", "it", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "addIndexes", "convertProperties", "parsedEntity", "convertProperty", "property", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "convertPropertyType", "Lorg/greenrobot/greendao/generator/PropertyType;", "javaTypeName", "mapEntityClassesToEntities", "", "entities", "", "schema", "Lorg/greenrobot/greendao/generator/Schema;", "resolveToManyRelations", "mapping", "resolveToOneRelations", "translate", "findProperty", "Lorg/greenrobot/greendao/generator/Property;", "name", "greendao-code-modifier_main"])
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
//    private fun addIndexes(it: ParsedEntity, entity: Entity) { // $FF: Couldn't be decompiled
//    }

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
//    private fun resolveToManyRelations(mapping: Map<*, *>, entities: Iterable<ParsedEntity>, schema: Schema) { // $FF: Couldn't be decompiled
//    }

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