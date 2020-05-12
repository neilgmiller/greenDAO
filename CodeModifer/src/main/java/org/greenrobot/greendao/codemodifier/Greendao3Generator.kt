package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.FunsKt.getJavaClassNames
import org.greenrobot.greendao.codemodifier.Templates.entity
import org.greenrobot.greendao.generator.*
import java.io.File
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0%J$\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0%H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("], d2 = ["Lorg/greenrobot/greendao/codemodifier/Greendao3Generator;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "skipTestGeneration", "", "", "encoding", "(Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/util/List;Ljava/lang/String;)V", "context", "Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "getContext", "()Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "getSkipTestGeneration", "()Ljava/util/List;", "checkClass", "", "parsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "generateActiveMethodsAndFields", "transformer", "Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "generateConstructors", "generateGettersAndSetters", "generateSchema", "entities", "options", "Lorg/greenrobot/greendao/codemodifier/SchemaOptions;", "generateToManyRelations", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "generateToOneRelations", "run", "sourceFiles", "", "Ljava/io/File;", "schemaOptions", "", "transformClass", "mapping", "greendao-code-modifier_main"])
class Greendao3Generator(val formattingOptions: FormattingOptions?, private val skipTestGeneration: List<String>, encoding: String) {
    private val context: JdtCodeContext = JdtCodeContext(formattingOptions, encoding)

    fun run(sourceFiles: Iterable<File>, schemaOptions: Map<String, SchemaOptions>) {
        if (schemaOptions.isEmpty()) {
            throw IllegalArgumentException("There should be options for at least one schema")
        } else {
            val destinationFileList = mutableListOf<File>()
            var iterator = sourceFiles.iterator()
            while (iterator.hasNext()) {
                destinationFileList.add(iterator.next().parentFile)
            }

            val iterable2: Iterable<File> = destinationFileList.distinct()
            val destinationPairList = mutableListOf<Pair<File, List<ParsedEntity>>>()
            iterator = iterable2.iterator()
            while (iterator.hasNext()) {
                val file: File = iterator.next()
                val fileAndNamePair: Pair<File, List<ParsedEntity>> = file to getJavaClassNames(file)
                destinationPairList.add(fileAndNamePair)
            }

            val classesByDir: Map<File, List<ParsedEntity>> = destinationPairList.toMap()
            val start = System.currentTimeMillis()
            val parsedEntities: List<ParsedEntity> = sourceFiles.asSequence()
                    .map { file: File ->
                        val javaClassNames = classesByDir[file.parentFile]
                        if (javaClassNames == null) {
                            Intrinsics.throwNpe()
                        }
                        val parsedEntity = context.parse(file, javaClassNames!!)
                        if (parsedEntity != null && parsedEntity.properties.isEmpty()) {
                            System.err.println("Skipping entity ${parsedEntity.name} as it has no properties.")
                            null
                        } else {
                            parsedEntity
                        }
                    }
                    .filterNotNull()
                    .toList()

            val time = System.currentTimeMillis() - start
            println("Parsed ${parsedEntities.size} entities in $time ms among ${sourceFiles.count<Any>()} source files: ${parsedEntities.joinToString()}")
            if (parsedEntities.isNotEmpty()) {
                val destinationMapList = mutableMapOf<String, List<ParsedEntity>>()
                val parsedEntityIterator = parsedEntities.iterator()
                var schemaName: String
                while (parsedEntityIterator.hasNext()) {
                    val parsedEntity = parsedEntityIterator.next()
                    schemaName = parsedEntity.schema
                    val destinationMapEntry = destinationMapList[schemaName] as MutableList?
                    if (destinationMapEntry == null) {
                        val newAnswerList = mutableListOf<ParsedEntity>()
                        destinationMapList[schemaName] = newAnswerList
                        newAnswerList.add(parsedEntity)
                    } else {
                        destinationMapEntry.add(parsedEntity)
                    }
                }

                val mapListIterator = destinationMapList.entries.iterator()
                while (mapListIterator.hasNext()) {
                    val mapEntry = mapListIterator.next() as Map.Entry<String, List<ParsedEntity>>
                    schemaName = mapEntry.key
                    val schemaEntities = mapEntry.value
                    val schemaOptions1 = schemaOptions[schemaName] as SchemaOptions?
                    if (schemaOptions1 == null) {
                        var parsedEntityIterable = parsedEntities
                        val destinationList2 = mutableListOf<ParsedEntity>()
                        var parsedEntityIterator2 = parsedEntityIterable.iterator()
                        var parsedEntity: ParsedEntity
                        while (parsedEntityIterator2.hasNext()) {
                            parsedEntity = parsedEntityIterator2.next()
                            if (Intrinsics.areEqual(parsedEntity.schema, schemaName)) {
                                destinationList2.add(parsedEntity)
                            }
                        }
                        parsedEntityIterable = destinationList2
                        val destinationList3 = mutableListOf<String>()
                        parsedEntityIterator2 = parsedEntityIterable.iterator()
                        while (parsedEntityIterator2.hasNext()) {
                            parsedEntity = parsedEntityIterator2.next()
                            destinationList3.add(parsedEntity.name)
                        }
                        val affectedEntities: String = destinationList2.joinToString()
                        throw RuntimeException("\n                        Undefined schema \\\"$schemaName\\\" (referenced in entities: $affectedEntities).\n                        Please, define non-default schemas explicitly inside build.gradle\n                        ".trimIndent())
                    }
                    val options: SchemaOptions = schemaOptions1
                    generateSchema(schemaEntities, options)
                }
            } else {
                System.err.println("No entities found among specified files")
            }
        }
    }

    fun generateSchema(entities: List<ParsedEntity>, options: SchemaOptions) {
        val outputDir = options.outputDir
        val testsOutputDir = options.testsOutputDir
        val schema: Schema
        val name = options.name
        val version = options.version
        var defaultJavaPackage = options.daoPackage
        if (defaultJavaPackage == null) {
            defaultJavaPackage = entities.first().packageName
        }
        schema = Schema(name, version, defaultJavaPackage)
        val mapping = GreendaoModelTranslator.INSTANCE.translate(entities, schema, options.daoPackage)
        val var7 = skipTestGeneration as Collection<*>
//        var var8: Iterator<*>
        var `element$iv`: Any
        var qualifiedName: String
        if (!var7.isEmpty()) {
            val iterator = schema.entities.iterator()
            while (iterator.hasNext()) {
                val e = iterator.next()
                qualifiedName = "${e.javaPackage}.${e.className}"
                val iterator1 = skipTestGeneration.iterator()
                var foundMatch: Boolean
                while (true) {
                    if (!iterator1.hasNext()) {
                        foundMatch = false
                        break
                    }
                    if (qualifiedName.endsWith(iterator1.next(), ignoreCase = false)) {
                        foundMatch = true
                        break
                    }
                }
                e.isSkipGenerationTest = foundMatch
            }
        }
        outputDir.mkdirs()
        testsOutputDir?.mkdirs()
        DaoGenerator().generateAll(schema, outputDir.path, outputDir.path, testsOutputDir?.path)

        val iterator = entities.iterator()
        while (iterator.hasNext()) {
            val entityClass = iterator.next()
            if (entityClass.keepSource) {
                checkClass(entityClass)
                qualifiedName = "Keep source for ${entityClass.name}"
                println(qualifiedName)
            } else {
                transformClass(entityClass, mapping)
            }
        }
        var count = 0
        val iterator1 = entities.iterator()
        while (iterator1.hasNext()) {
            if (iterator1.next().keepSource) {
                ++count
            }
        }
        var sum = 0
        val iterator2 = entities.iterator()
        while (iterator2.hasNext()) {
            var count2 = 0
            val parsedEntity = iterator2.next()
            var constructorIterator = parsedEntity.constructors.iterator()
            while (constructorIterator.hasNext()) {
                val method = constructorIterator.next()
                if (method.getKeep()) {
                    ++count2
                }
            }

            val methods = parsedEntity.methods
            var count3 = 0
            constructorIterator = methods.iterator()
            while (constructorIterator.hasNext()) {
                if (constructorIterator.next().getKeep()) {
                    ++count3
                }
            }
            sum += count2 + count3
        }
        if (count + sum > 0) {
            System.err.println("Kept source for $count classes and $sum methods because of @Keep annotation")
        }
    }

    private fun checkClass(parsedEntity: ParsedEntity) {
        val noConstructor: Boolean
        val propertiesInConstructorOrder: List<ParsedProperty>? = parsedEntity.propertiesInConstructorOrder
        if (propertiesInConstructorOrder == null) {
            val propertyIterable = parsedEntity.properties as Iterable<ParsedProperty>
            val destinationVariableList = mutableListOf<Variable>()
            val iterator = propertyIterable.iterator()
            while (iterator.hasNext()) {
                destinationVariableList.add(iterator.next().variable)
            }

            val fieldVars = destinationVariableList as List<*>
            val entityIterator = parsedEntity.constructors.iterator()
            while (true) {
                if (!entityIterator.hasNext()) {
                    noConstructor = true
                    break
                }
                val method = entityIterator.next()
                if (method.hasFullSignature(parsedEntity.name, fieldVars)) {
                    noConstructor = false
                    break
                }
            }
        } else {
            noConstructor = false
        }

        if (noConstructor) {
            throw (RuntimeException("Can't find constructor for entity ${parsedEntity.name} with all persistent fields. Note parameter names of such constructor should be equal to field names") as Throwable)
        }
    }

    private fun transformClass(parsedEntity: ParsedEntity, mapping: Map<*, Entity>) {
        val entity = mapping[parsedEntity]
        if (entity == null) {
            Intrinsics.throwNpe()
        }
        val daoPackage = entity!!.schema.defaultJavaPackage
        val transformer = context.transformer(parsedEntity)
        transformer.ensureImport("org.greenrobot.greendao.annotation.Generated")
        transformer.annotateLegacyKeepFields()
        val daoSessionVarName = entity.schema.prefix + "DaoSession"

        if (entity.active) {
            transformer.ensureImport("org.greenrobot.greendao.DaoException")
            transformer.defMethod("__setDaoSession", arrayOf("$daoPackage.$daoSessionVarName")) { Templates.entity.INSTANCE.daoSessionSetter(entity) }
            generateActiveMethodsAndFields(transformer)
            generateToManyRelations(entity, transformer)
            generateToOneRelations(entity, parsedEntity, transformer)
        }
        generateGettersAndSetters(parsedEntity, transformer)
        generateConstructors(parsedEntity, transformer)
        if (entity.active) {
            val name = "${entity.javaPackageDao}.${entity.classNameDao}"
            val originalName = entity.classNameDao
            Intrinsics.checkExpressionValueIsNotNull(originalName, "entity.classNameDao")
            transformer.defField("myDao", VariableType(name, false, originalName, null), "Used for active entity operations.")
            transformer.defField("daoSession", VariableType("$daoPackage.$daoSessionVarName", false, daoSessionVarName, null), "Used to resolve relations")
        }
        transformer.writeToFile()
    }

    private fun generateConstructors(parsedEntity: ParsedEntity, transformer: EntityClassTransformer) {
        if (parsedEntity.generateConstructors) {
            var parsedProperties: List<ParsedProperty>? = parsedEntity.propertiesInConstructorOrder
            if (parsedProperties == null) {
                parsedProperties = parsedEntity.properties
            }
            val properties: List<ParsedProperty> = parsedProperties
            if (!properties.isEmpty()) {
                val iterator = parsedEntity.constructors.iterator()
                val var19: Boolean
                while (true) {
                    if (!iterator.hasNext()) {
                        var19 = true
                        break
                    }
                    val it = iterator.next()
                    if (it.parameters.isEmpty() && !it.getGenerated()) {
                        var19 = false
                        break
                    }
                }
                if (var19) {
                    transformer.defConstructor(emptyList<Any>()) {
                        """ @Generated(hash = ${EntityClassTransformerKt.hASH_STUB})
                                    public ${parsedEntity.name}() {
                                    }"""
                    }
                }
            }
            val destinationStringList = mutableListOf<String>()
            val iterator = properties.iterator()
            while (iterator.hasNext()) {
                val it = iterator.next()
                val var15 = it.variable.type.name
                destinationStringList.add(var15)
            }
            transformer.defConstructor(destinationStringList) {
                val className = parsedEntity.name
                val properties2: List<*> = parsedEntity.properties
                var notNullAnnotation = parsedEntity.notNullAnnotation
                if (notNullAnnotation == null) {
                    notNullAnnotation = "@NotNull"
                }
                entity.INSTANCE.constructor(className, properties2, notNullAnnotation)
            }
        } else {
            transformer.ensureDefaultConstructor()
        }
    }

    private fun generateGettersAndSetters(parsedEntity: ParsedEntity, transformer: EntityClassTransformer) {
        if (!parsedEntity.generateGettersSetters) {
            println("Not generating getters or setters for ${parsedEntity.name}.")
        } else {
            val iterator = parsedEntity.properties.reversed().iterator()
            while (iterator.hasNext()) {
                val field = iterator.next()
                transformer.defMethodIfMissing("set" + field.variable.name.capitalize(), arrayOf(field.variable.type.name), `Greendao3Generator$generateGettersAndSetters$1$1`(field) as Function0<*>)

                val name = "get${field.variable.name.capitalize()}"
                val code = `Greendao3Generator$generateGettersAndSetters$1$2`(field)
                val paramTypes = emptyArray<String>()
                transformer.defMethodIfMissing(name, paramTypes, code)
            }
        }
    }

    private fun generateToOneRelations(entity: Entity?, parsedEntity: ParsedEntity, transformer: EntityClassTransformer) {
        val iterator = entity!!.toOneRelations.reversed().iterator()
        while (iterator.hasNext()) {
            val toOne = iterator.next()
            transformer.ensureImport(toOne.targetEntity.javaPackageDao + "." + toOne.targetEntity.classNameDao)
            var name = "set" + toOne.name.capitalize()
            var paramTypes = arrayOf(toOne.targetEntity.className)
            transformer.defMethod(name, paramTypes, `Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$1`(toOne, transformer, parsedEntity, entity))

            var code: Function0<*>
            if (!toOne.isUseFkProperty) {
                name = "peak${toOne.name.capitalize()}"
                paramTypes = emptyArray()
                code = `Greendao3Generator$generateToOneRelations$1$2`(toOne)
                transformer.defMethod(name, paramTypes, code)
            }

            name = "get${toOne.name.capitalize()}"
            code = `Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$2`(toOne, transformer, parsedEntity, entity)
            paramTypes = emptyArray<String>()
            transformer.defMethod(name, paramTypes, code)

            if (toOne.isUseFkProperty) {
                name = "${toOne.name}__resolvedKey"
                name = toOne.resolvedKeyJavaType[0]
                Intrinsics.checkExpressionValueIsNotNull(name, "toOne.resolvedKeyJavaType[0]")
                val originalName = toOne.resolvedKeyJavaType[0]
                Intrinsics.checkExpressionValueIsNotNull(originalName, "toOne.resolvedKeyJavaType[0]")
                transformer.defField(name, VariableType(name, false, originalName, null), null)
            } else {
                transformer.defField("${toOne.name}__refreshed", VariableType("boolean", true, "boolean", null), null)
            }
        }
    }

    private fun generateToManyRelations(entity: Entity?, transformer: EntityClassTransformer) {
        val iterator = entity!!.toManyRelations.reversed().iterator()
        while (iterator.hasNext()) {
            val toMany = iterator.next()
            transformer.ensureImport("${toMany.targetEntity.javaPackageDao}.${toMany.targetEntity.classNameDao}")
            val name = "reset${toMany.name.capitalize()}"
            val paramTypes = emptyArray<String>()
            val code = `Greendao3Generator$generateToManyRelations$1$1`(toMany)
            transformer.defMethod(name, paramTypes, code)

            val name2 = "get${toMany.name.capitalize()}"
            val paramTypes2 = emptyArray<String>()
            val code2 = `Greendao3Generator$generateToManyRelations$$inlined$forEach$lambda$1`(toMany, transformer, entity)
            transformer.defMethod(name2, paramTypes2, code2)
        }
    }

    // TODO:
    private fun generateActiveMethodsAndFields(transformer: EntityClassTransformer) {
        var paramTypes = emptyArray<String>()
        var code = function
        transformer.defMethod("update", paramTypes, code)

        code = function
        transformer.defMethod("refresh", paramTypes, code)

        code = function
        transformer.defMethod("delete", paramTypes, code)
    }

//    // $FF: synthetic method
//    @JvmOverloads
//    constructor(var1: FormattingOptions? = null as FormattingOptions?, var2: List<*>? = null as List<*>?, var3: String? = null as String?, var4: Int = 7, var5: DefaultConstructorMarker? = null as DefaultConstructorMarker?) {
//        var var1 = var1
//        var var2 = var2
//        var var3 = var3
//        if (var4 and 1 != 0) {
//            var1 = null as FormattingOptions?
//        }
//        if (var4 and 2 != 0) {
//            var2 = emptyList<Any>()
//        }
//        if (var4 and 4 != 0) {
//            var3 = "UTF-8"
//        }
//        this(var1, var2, var3)
//    }
}