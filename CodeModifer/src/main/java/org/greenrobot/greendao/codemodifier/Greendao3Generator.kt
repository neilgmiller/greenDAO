package org.greenrobot.greendao.codemodifier

import org.greenrobot.greendao.codemodifier.FunsKt.getJavaClassNames
import org.greenrobot.greendao.codemodifier.Templates.entity
import org.greenrobot.greendao.generator.*
import java.io.File
import java.util.*
import kotlin.jvm.internal.DefaultConstructorMarker
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0%J$\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0%H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("], d2 = ["Lorg/greenrobot/greendao/codemodifier/Greendao3Generator;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "skipTestGeneration", "", "", "encoding", "(Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/util/List;Ljava/lang/String;)V", "context", "Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "getContext", "()Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "getSkipTestGeneration", "()Ljava/util/List;", "checkClass", "", "parsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "generateActiveMethodsAndFields", "transformer", "Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "generateConstructors", "generateGettersAndSetters", "generateSchema", "entities", "options", "Lorg/greenrobot/greendao/codemodifier/SchemaOptions;", "generateToManyRelations", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "generateToOneRelations", "run", "sourceFiles", "", "Ljava/io/File;", "schemaOptions", "", "transformClass", "mapping", "greendao-code-modifier_main"])
class Greendao3Generator(val formattingOptions: FormattingOptions?, private val skipTestGeneration: List<*>, encoding: String) {
    private val context: JdtCodeContext = JdtCodeContext(formattingOptions, encoding)

    fun run(sourceFiles: Iterable<File>, schemaOptions: Map<*, *>) {
        if (schemaOptions.isEmpty()) {
            throw IllegalArgumentException("There should be options for at least one schema")
        } else {
            val destinationFileList = mutableListOf<File>()
            var iterator = sourceFiles.iterator()
            while (iterator.hasNext()) {
                destinationFileList.add(iterator.next().parentFile)
            }

            val iterable2: Iterable<File> = destinationFileList.distinct()
            val destinationPairList = mutableListOf<Pair<File, List<*>>>()
            iterator = iterable2.iterator()
            while (iterator.hasNext()) {
                val file: File = iterator.next()
                val fileAndNamePair: Pair<File, List<*>> = file to getJavaClassNames(file)
                destinationPairList.add(fileAndNamePair)
            }

            val classesByDir: Map<File, List<*>> = destinationPairList.toMap()
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
                val destinationMapList = mutableMapOf<>()
                val parsedEntityIterator = parsedEntities.iterator()
                var schemaName: String
                while (parsedEntityIterator.hasNext()) {
                    val parsedEntity = parsedEntityIterator.next()
                    schemaName = parsedEntity.schema
                    val destinationMapEntry = destinationMapList[schemaName]
                    var var10000: MutableList<ParsedEntity>
                    if (destinationMapEntry == null) {
                        val newAnswerList = mutableListOf<ParsedEntity>()
                        destinationMapList[schemaName] = newAnswerList
                        var10000 = newAnswerList
                    } else {
                        var10000 = destinationMapEntry
                    }
                    var10000.add(parsedEntity)
                }
                val mapListIterator = destinationMapList.entries.iterator()
                while (mapListIterator.hasNext()) {
                    val mapEntry = mapListIterator.next() as Map.Entry<*, *>
                    schemaName = mapEntry.key as String
                    val schemaEntities = mapEntry.value as List<*>
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

    fun generateSchema(entities: List<*>, options: SchemaOptions) {
        Intrinsics.checkParameterIsNotNull(entities, "entities")
        Intrinsics.checkParameterIsNotNull(options, "options")
        val outputDir = options.outputDir
        val testsOutputDir = options.testsOutputDir
        val var10000: Schema
        val var10002 = options.name
        val var10003 = options.version
        var var10004 = options.daoPackage
        if (var10004 == null) {
            var10004 = (entities.first<Any>() as ParsedEntity).packageName
        }
        var10000 = Schema(var10002, var10003, var10004)
        val mapping = GreendaoModelTranslator.INSTANCE.translate(entities as Iterable<*>, var10000, options.daoPackage)
        val var7 = skipTestGeneration as Collection<*>
        var var8: Iterator<*>
        var `element$iv`: Any
        var qualifiedName: String
        var `$receiver$iv`: Iterable<*>
        if (!var7.isEmpty()) {
            `$receiver$iv` = var10000.entities as Iterable<*>
            var8 = `$receiver$iv`.iterator()
            while (var8.hasNext()) {
                `element$iv` = var8.next()!!
                val e = `element$iv` as Entity
                qualifiedName = e.javaPackage + "." + e.className
                val `$receiver$iv` = skipTestGeneration as Iterable<*>
                val var14 = `$receiver$iv`.iterator()
                var var41: Boolean
                while (true) {
                    if (!var14.hasNext()) {
                        var41 = false
                        break
                    }
                    val `element$iv` = var14.next()!!
                    val it = `element$iv` as String
                    if (`endsWith$default`(qualifiedName, it, false, 2, null as Any?)) {
                        var41 = true
                        break
                    }
                }
                val var17 = var41
                e.isSkipGenerationTest = var17
            }
        }
        outputDir.mkdirs()
        testsOutputDir?.mkdirs()
        DaoGenerator().generateAll(var10000, outputDir.path, outputDir.path, testsOutputDir?.path)
        `$receiver$iv` = entities
        var8 = `$receiver$iv`.iterator()
        while (var8.hasNext()) {
            `element$iv` = var8.next()!!
            val entityClass = `element$iv` as ParsedEntity
            if (entityClass.keepSource) {
                checkClass(entityClass)
                qualifiedName = "Keep source for " + entityClass.name
                println(qualifiedName)
            } else {
                transformClass(entityClass, mapping)
            }
        }
        val `$receiver$iv` = entities as Iterable<*>
        var `count$iv` = 0
        val var33 = `$receiver$iv`.iterator()
        while (var33.hasNext()) {
            val `element$iv` = var33.next()!!
            val it = `element$iv` as ParsedEntity
            if (it.keepSource) {
                ++`count$iv`
            }
        }
        val `$receiver$iv` = entities as Iterable<*>
        var `sum$iv` = 0
        var var26: Int
        val var36 = `$receiver$iv`.iterator()
        while (var36.hasNext()) {
            val `element$iv` = var36.next()!!
            val it = `element$iv` as ParsedEntity
            var `$receiver$iv` = it.constructors as Iterable<*>
            var `count$iv` = 0
            var var42 = `$receiver$iv`.iterator()
            var it: Method
            var `element$iv`: Any
            while (var42.hasNext()) {
                `element$iv` = var42.next()!!
                it = `element$iv` as Method
                if (it.getKeep()) {
                    ++`count$iv`
                }
            }
            `$receiver$iv` = it.getMethods() as Iterable<*>
            val var19 = `count$iv`
            `count$iv` = 0
            var42 = `$receiver$iv`.iterator()
            while (var42.hasNext()) {
                `element$iv` = var42.next()!!
                it = `element$iv` as Method
                if (it.getKeep()) {
                    ++`count$iv`
                }
            }
            var26 = var19 + `count$iv`
            `sum$iv` += var26
        }
        if (`count$iv` + `sum$iv` > 0) {
            System.err.println("Kept source for $`count$iv` classes and $`sum$iv` methods because of @Keep annotation")
        }
    }

    private fun checkClass(parsedEntity: ParsedEntity) {
        var var10000: Boolean
        label38@{
            val propertiesInConstructorOrder: List<*>? = parsedEntity.propertiesInConstructorOrder
            if (propertiesInConstructorOrder == null) {
                val `$receiver` = this
                var `$receiver$iv` = parsedEntity.properties as Iterable<*>
                val `destination$iv$iv` = ArrayList<Any?>(`$receiver$iv`.collectionSizeOrDefault<Any>(10)) as MutableCollection<*>
                val var9 = `$receiver$iv`.iterator()
                while (var9.hasNext()) {
                    val `item$iv$iv` = var9.next()!!
                    val it = `item$iv$iv` as ParsedProperty
                    val var13 = it.variable
                    `destination$iv$iv`.add(var13)
                }
                val fieldVars = `destination$iv$iv` as List<*>
                `$receiver$iv` = parsedEntity.constructors
                val var7 = `$receiver$iv`.iterator()
                while (true) {
                    if (!var7.hasNext()) {
                        var10000 = true
                        break
                    }
                    val `element$iv` = var7.next()!!
                    val it = `element$iv` as Method
                    if (it.hasFullSignature(parsedEntity.name, fieldVars)) {
                        var10000 = false
                        break
                    }
                }
                if (var10000) {
                    var10000 = true
                    break@label38
                }
            }
            var10000 = false
        }
        val noConstructor = var10000
        if (noConstructor) {
            throw (RuntimeException("Can't find constructor for entity " + parsedEntity.name + " with all persistent fields. " + "Note parameter names of such constructor should be equal to field names") as Throwable)
        }
    }

    private fun transformClass(parsedEntity: ParsedEntity, mapping: Map<*, *>) {
        val var10000 = mapping[parsedEntity]
        if (var10000 == null) {
            Intrinsics.throwNpe()
        }
        val entity = var10000 as Entity?
        val daoPackage = entity!!.schema.defaultJavaPackage
        val transformer = context.transformer(parsedEntity)
        transformer.ensureImport("org.greenrobot.greendao.annotation.Generated")
        transformer.annotateLegacyKeepFields()
        val daoSessionVarName = entity.schema.prefix + "DaoSession"
        var var7 = entity.active
        Intrinsics.checkExpressionValueIsNotNull(var7, "entity.active")
        if (var7) {
            transformer.ensureImport("org.greenrobot.greendao.DaoException")
            transformer.defMethod("__setDaoSession", arrayOf("$daoPackage.$daoSessionVarName"), { Templates.entity.INSTANCE.daoSessionSetter(entity) } as Function0<*>)
            generateActiveMethodsAndFields(transformer)
            generateToManyRelations(entity, transformer)
            generateToOneRelations(entity, parsedEntity, transformer)
        }
        generateGettersAndSetters(parsedEntity, transformer)
        generateConstructors(parsedEntity, transformer)
        var7 = entity.active
        Intrinsics.checkExpressionValueIsNotNull(var7, "entity.active")
        if (var7) {
            val var10004 = entity.javaPackageDao + "." + entity.classNameDao
            val var10006 = entity.classNameDao
            Intrinsics.checkExpressionValueIsNotNull(var10006, "entity.classNameDao")
            transformer.defField("myDao", VariableType(var10004, false, var10006, null as List<*>?, 8, null as DefaultConstructorMarker?), "Used for active entity operations.")
            transformer.defField("daoSession", VariableType("$daoPackage.$daoSessionVarName", false, daoSessionVarName, null as List<*>?, 8, null as DefaultConstructorMarker?), "Used to resolve relations")
        }
        transformer.writeToFile()
    }

    private fun generateConstructors(parsedEntity: ParsedEntity, transformer: EntityClassTransformer) {
        if (parsedEntity.generateConstructors) {
            var var10000: List<*>? = parsedEntity.propertiesInConstructorOrder
            if (var10000 == null) {
                var10000 = parsedEntity.properties
            }
            val properties: List<*> = var10000
            val var4 = properties as Collection<*>
            var `$receiver$iv`: Iterable<*>
            if (!var4.isEmpty()) {
                `$receiver$iv` = parsedEntity.constructors
                val var5 = `$receiver$iv`.iterator()
                val var19: Boolean
                while (true) {
                    if (!var5.hasNext()) {
                        var19 = true
                        break
                    }
                    val `element$iv` = var5.next()!!
                    val it = `element$iv` as Method
                    if (it.parameters.isEmpty() && !it.getGenerated()) {
                        var19 = false
                        break
                    }
                }
                if (var19) {
                    transformer.defConstructor(emptyList<Any>(), { " @Generated(hash = " + EntityClassTransformerKt.getHASH_STUB().toString() + ")" + "\n" + "                        public " + parsedEntity.name + "() {" + "\n" + "                        }" } as Function0<*>)
                }
            }
            `$receiver$iv` = properties
            val `destination$iv$iv` = ArrayList<Any?>(`$receiver$iv`.collectionSizeOrDefault<Any>(10)) as MutableCollection<*>
            val var18 = `$receiver$iv`.iterator()
            while (var18.hasNext()) {
                val `item$iv$iv` = var18.next()!!
                val it = `item$iv$iv` as ParsedProperty
                val var15 = it.variable.type.name
                `destination$iv$iv`.add(var15)
            }
            val var14 = `destination$iv$iv` as List<*>
            transformer.defConstructor(var14, {
                val var10000 = entity.INSTANCE
                val var10001 = parsedEntity.name
                val var10002: List<*> = parsedEntity.properties
                var var10003 = parsedEntity.notNullAnnotation
                if (var10003 == null) {
                    var10003 = "@NotNull"
                }
                var10000.constructor(var10001, var10002, var10003)
            } as Function0<*>)
        } else {
            transformer.ensureDefaultConstructor()
        }
    }

    private fun generateGettersAndSetters(parsedEntity: ParsedEntity, transformer: EntityClassTransformer) {
        if (!parsedEntity.generateGettersSetters) {
            val var11 = "Not generating getters or setters for " + parsedEntity.name + "."
            println(var11)
        } else {
            val `$receiver$iv`: Iterable<*> = parsedEntity.properties as Iterable<*>?. reversed < kotlin . Any ? > () as Iterable<*>
            val var4 = `$receiver$iv`.iterator()
            while (var4.hasNext()) {
                val `element$iv` = var4.next()!!
                val field = `element$iv` as ParsedProperty
                transformer.defMethodIfMissing("set" + field.variable.name.capitalize(), arrayOf(field.variable.type.name), `Greendao3Generator$generateGettersAndSetters$1$1`(field) as Function0<*>)
                val var10001 = "get" + field.variable.name.capitalize()
                val var10002 = `Greendao3Generator$generateGettersAndSetters$1$2`(field) as Function0<*>
                val var7 = arrayOfNulls<String>(0)
                transformer.defMethodIfMissing(var10001, var7, var10002)
            }
        }
    }

    private fun generateToOneRelations(entity: Entity?, parsedEntity: ParsedEntity, transformer: EntityClassTransformer) {
        val `$receiver$iv`: Iterable<*> = entity!!.toOneRelations as Iterable<*>?. reversed < kotlin . Any ? > () as Iterable<*>
        val var5 = `$receiver$iv`.iterator()
        while (var5.hasNext()) {
            val `element$iv` = var5.next()!!
            val toOne = `element$iv` as ToOne
            transformer.ensureImport(toOne.targetEntity.javaPackageDao + "." + toOne.targetEntity.classNameDao)
            var var10001 = "set" + toOne.name.capitalize()
            val var10002 = arrayOfNulls<String>(1)
            val var10005 = toOne.targetEntity.className
            Intrinsics.checkExpressionValueIsNotNull(var10005, "toOne.targetEntity.className")
            var10002[0] = var10005
            transformer.defMethod(var10001, var10002, `Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$1`(toOne, transformer, parsedEntity, entity) as Function0<*>)
            var var8: Array<String?>
            var var9: Function0<*>?
            var var12: Function0<*>
            if (!toOne.isUseFkProperty) {
                var10001 = "peak" + toOne.name.capitalize()
                var12 = `Greendao3Generator$generateToOneRelations$1$2`(toOne)
                var8 = arrayOfNulls(0)
                var9 = var12
                transformer.defMethod(var10001, var8, var9)
            }
            var10001 = "get" + toOne.name.capitalize()
            var12 = `Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$2`(toOne, transformer, parsedEntity, entity)
            var8 = arrayOfNulls(0)
            var9 = var12
            transformer.defMethod(var10001, var8, var9)
            if (toOne.isUseFkProperty) {
                var10001 = toOne.name + "__resolvedKey"
                val var10004 = toOne.resolvedKeyJavaType[0]
                Intrinsics.checkExpressionValueIsNotNull(var10004, "toOne.resolvedKeyJavaType[0]")
                val var10006 = toOne.resolvedKeyJavaType[0]
                Intrinsics.checkExpressionValueIsNotNull(var10006, "toOne.resolvedKeyJavaType[0]")
                EntityClassTransformer.`defField$default`(transformer, var10001, VariableType(var10004, false, var10006, null as List<*>?, 8, null as DefaultConstructorMarker?), null as String?, 4, null as Any?)
            } else {
                EntityClassTransformer.`defField$default`(transformer, toOne.name + "__refreshed", VariableType("boolean", true, "boolean", null as List<*>?, 8, null as DefaultConstructorMarker?), null as String?, 4, null as Any?)
            }
        }
    }

    private fun generateToManyRelations(entity: Entity?, transformer: EntityClassTransformer) {
        val `$receiver$iv`: Iterable<*> = entity!!.toManyRelations as Iterable<*>?. reversed < kotlin . Any ? > () as Iterable<*>
        val var4 = `$receiver$iv`.iterator()
        while (var4.hasNext()) {
            val `element$iv` = var4.next()!!
            val toMany = `element$iv` as ToManyBase
            transformer.ensureImport(toMany.targetEntity.javaPackageDao + "." + toMany.targetEntity.classNameDao)
            var var10001 = "reset" + toMany.name.capitalize()
            var var10002 = `Greendao3Generator$generateToManyRelations$1$1`(toMany) as Function0<*>
            var var7 = arrayOfNulls<String>(0)
            var var8 = var10002
            transformer.defMethod(var10001, var7, var8)
            var10001 = "get" + toMany.name.capitalize()
            var10002 = `Greendao3Generator$generateToManyRelations$$inlined$forEach$lambda$1`(toMany, transformer, entity)
            var7 = arrayOfNulls(0)
            var8 = var10002
            transformer.defMethod(var10001, var7, var8)
        }
    }

    private fun generateActiveMethodsAndFields(transformer: EntityClassTransformer) {
        var var10002 = null.INSTANCE as Function0<*>?
        var var2 = arrayOfNulls<String>(0)
        var var3 = var10002
        transformer.defMethod("update", var2, var3)
        var10002 = null.INSTANCE as Function0<*>?
        var2 = arrayOfNulls(0)
        var3 = var10002
        transformer.defMethod("refresh", var2, var3)
        var10002 = null.INSTANCE as Function0<*>?
        var2 = arrayOfNulls(0)
        var3 = var10002
        transformer.defMethod("delete", var2, var3)
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