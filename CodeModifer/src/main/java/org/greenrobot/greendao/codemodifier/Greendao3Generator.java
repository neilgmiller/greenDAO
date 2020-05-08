package org.greenrobot.greendao.codemodifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToManyBase;
import org.greenrobot.greendao.generator.ToOne;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010 \u001a\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b0%J$\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001e0%H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Greendao3Generator;", "", "formattingOptions", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "skipTestGeneration", "", "", "encoding", "(Lorg/greenrobot/greendao/codemodifier/FormattingOptions;Ljava/util/List;Ljava/lang/String;)V", "context", "Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "getContext", "()Lorg/greenrobot/greendao/codemodifier/JdtCodeContext;", "getSkipTestGeneration", "()Ljava/util/List;", "checkClass", "", "parsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "generateActiveMethodsAndFields", "transformer", "Lorg/greenrobot/greendao/codemodifier/EntityClassTransformer;", "generateConstructors", "generateGettersAndSetters", "generateSchema", "entities", "options", "Lorg/greenrobot/greendao/codemodifier/SchemaOptions;", "generateToManyRelations", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "generateToOneRelations", "run", "sourceFiles", "", "Ljava/io/File;", "schemaOptions", "", "transformClass", "mapping", "greendao-code-modifier_main"}
)
public final class Greendao3Generator {
   @NotNull
   private final JdtCodeContext context;
   @NotNull
   private final List skipTestGeneration;

   @NotNull
   public final JdtCodeContext getContext() {
      return this.context;
   }

   public final void run(@NotNull Iterable sourceFiles, @NotNull Map schemaOptions) {
      Intrinsics.checkParameterIsNotNull(sourceFiles, "sourceFiles");
      Intrinsics.checkParameterIsNotNull(schemaOptions, "schemaOptions");
      boolean var3 = schemaOptions.size() > 0;
      if (!var3) {
         String var5 = "There should be options for at least one schema";
         throw (Throwable)(new IllegalArgumentException(var5.toString()));
      } else {
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(sourceFiles, 10)));
         Iterator var7 = sourceFiles.iterator();

         Object item$iv$iv;
         File it;
         while(var7.hasNext()) {
            item$iv$iv = var7.next();
            it = (File)item$iv$iv;
            File var35 = it.getParentFile();
            destination$iv$iv.add(var35);
         }

         Iterable $receiver$iv = (Iterable)CollectionsKt.distinct((Iterable)((List)destination$iv$iv));
         destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
         var7 = $receiver$iv.iterator();

         while(var7.hasNext()) {
            item$iv$iv = var7.next();
            it = (File)item$iv$iv;
            Pair var50 = TuplesKt.to(it, FunsKt.getJavaClassNames(it));
            destination$iv$iv.add(var50);
         }

         final Map classesByDir = MapsKt.toMap((Iterable)((List)destination$iv$iv));
         long start = System.currentTimeMillis();
         List entities = SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence(sourceFiles), (Function1)(new Function1() {
            @Nullable
            public final ParsedEntity invoke(@NotNull File it) {
               Intrinsics.checkParameterIsNotNull(it, "it");
               JdtCodeContext var10000 = Greendao3Generator.this.getContext();
               Object var10002 = classesByDir.get(it.getParentFile());
               if (var10002 == null) {
                  Intrinsics.throwNpe();
               }

               ParsedEntity entity = var10000.parse(it, (List)var10002);
               ParsedEntity var3;
               if (entity != null && entity.getProperties().size() == 0) {
                  System.err.println("Skipping entity " + entity.getName() + " as it has no properties.");
                  var3 = null;
               } else {
                  var3 = entity;
               }

               return var3;
            }
         }))));
         long time = System.currentTimeMillis() - start;
         String var40 = "Parsed " + entities.size() + " entities in " + time + " ms among " + CollectionsKt.count(sourceFiles) + " source files: " + SequencesKt.joinToString$default(SequencesKt.map(CollectionsKt.asSequence((Iterable)entities), (Function1)null.INSTANCE), (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 63, (Object)null);
         System.out.println(var40);
         Collection var41 = (Collection)entities;
         if (!var41.isEmpty()) {
            Iterable $receiver$iv = (Iterable)entities;
            Map destination$iv$iv = (Map)(new LinkedHashMap());
            Iterator var12 = $receiver$iv.iterator();

            ParsedEntity it;
            String schemaName;
            while(var12.hasNext()) {
               Object element$iv$iv = var12.next();
               it = (ParsedEntity)element$iv$iv;
               schemaName = it.getSchema();
               Object value$iv$iv$iv = destination$iv$iv.get(schemaName);
               Object var10000;
               if (value$iv$iv$iv == null) {
                  Object answer$iv$iv$iv = new ArrayList();
                  destination$iv$iv.put(schemaName, answer$iv$iv$iv);
                  var10000 = answer$iv$iv$iv;
               } else {
                  var10000 = value$iv$iv$iv;
               }

               List list$iv$iv = (List)var10000;
               list$iv$iv.add(element$iv$iv);
            }

            Iterator var43 = destination$iv$iv.entrySet().iterator();

            while(var43.hasNext()) {
               Entry element$iv = (Entry)var43.next();
               Entry entry = (Entry)element$iv;
               schemaName = (String)entry.getKey();
               List schemaEntities = (List)entry.getValue();
               it = null;
               SchemaOptions var47 = (SchemaOptions)schemaOptions.get(schemaName);
               if (var47 == null) {
                  Greendao3Generator $receiver = (Greendao3Generator)this;
                  Iterable $receiver$iv = (Iterable)entities;
                  Collection destination$iv$iv = (Collection)(new ArrayList());
                  Iterator var22 = $receiver$iv.iterator();

                  Object item$iv$iv;
                  ParsedEntity it;
                  while(var22.hasNext()) {
                     item$iv$iv = var22.next();
                     it = (ParsedEntity)item$iv$iv;
                     if (Intrinsics.areEqual(it.getSchema(), schemaName)) {
                        destination$iv$iv.add(item$iv$iv);
                     }
                  }

                  $receiver$iv = (Iterable)((List)destination$iv$iv);
                  destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
                  var22 = $receiver$iv.iterator();

                  while(var22.hasNext()) {
                     item$iv$iv = var22.next();
                     it = (ParsedEntity)item$iv$iv;
                     String var26 = it.getName();
                     destination$iv$iv.add(var26);
                  }

                  String affectedEntities = CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 63, (Object)null);
                  throw (Throwable)(new RuntimeException(StringsKt.trimIndent("\n" + "                        Undefined schema " + "\\" + "\"" + schemaName + "\\" + "\"" + " (referenced in entities: " + affectedEntities + ")." + "\n" + "                        Please, define non-default schemas explicitly inside build.gradle" + "\n" + "                        ")));
               }

               SchemaOptions options = var47;
               this.generateSchema(schemaEntities, options);
            }
         } else {
            System.err.println("No entities found among specified files");
         }

      }
   }

   public final void generateSchema(@NotNull List entities, @NotNull SchemaOptions options) {
      Intrinsics.checkParameterIsNotNull(entities, "entities");
      Intrinsics.checkParameterIsNotNull(options, "options");
      File outputDir = options.getOutputDir();
      File testsOutputDir = options.getTestsOutputDir();
      Schema var10000 = new Schema;
      String var10002 = options.getName();
      int var10003 = options.getVersion();
      String var10004 = options.getDaoPackage();
      if (var10004 == null) {
         var10004 = ((ParsedEntity)CollectionsKt.first(entities)).getPackageName();
      }

      var10000.<init>(var10002, var10003, var10004);
      Schema schema = var10000;
      Map mapping = GreendaoModelTranslator.INSTANCE.translate((Iterable)entities, schema, options.getDaoPackage());
      Collection var7 = (Collection)this.skipTestGeneration;
      Iterator var8;
      Object element$iv;
      String qualifiedName;
      Iterable $receiver$iv;
      if (!var7.isEmpty()) {
         $receiver$iv = (Iterable)schema.getEntities();
         var8 = $receiver$iv.iterator();

         while(var8.hasNext()) {
            element$iv = var8.next();
            Entity e = (Entity)element$iv;
            qualifiedName = e.getJavaPackage() + "." + e.getClassName();
            Iterable $receiver$iv = (Iterable)this.skipTestGeneration;
            Iterator var14 = $receiver$iv.iterator();

            boolean var41;
            while(true) {
               if (!var14.hasNext()) {
                  var41 = false;
                  break;
               }

               Object element$iv = var14.next();
               String it = (String)element$iv;
               if (StringsKt.endsWith$default(qualifiedName, it, false, 2, (Object)null)) {
                  var41 = true;
                  break;
               }
            }

            boolean var17 = var41;
            e.setSkipGenerationTest(var17);
         }
      }

      outputDir.mkdirs();
      if (testsOutputDir != null) {
         testsOutputDir.mkdirs();
      }

      (new DaoGenerator()).generateAll(schema, outputDir.getPath(), outputDir.getPath(), testsOutputDir != null ? testsOutputDir.getPath() : null);
      $receiver$iv = (Iterable)entities;
      var8 = $receiver$iv.iterator();

      while(var8.hasNext()) {
         element$iv = var8.next();
         ParsedEntity entityClass = (ParsedEntity)element$iv;
         if (entityClass.getKeepSource()) {
            this.checkClass(entityClass);
            qualifiedName = "Keep source for " + entityClass.getName();
            System.out.println(qualifiedName);
         } else {
            this.transformClass(entityClass, mapping);
         }
      }

      Iterable $receiver$iv = (Iterable)entities;
      int count$iv = 0;
      Iterator var33 = $receiver$iv.iterator();

      while(var33.hasNext()) {
         Object element$iv = var33.next();
         ParsedEntity it = (ParsedEntity)element$iv;
         if (it.getKeepSource()) {
            ++count$iv;
         }
      }

      Iterable $receiver$iv = (Iterable)entities;
      int sum$iv = 0;

      int var26;
      for(Iterator var36 = $receiver$iv.iterator(); var36.hasNext(); sum$iv += var26) {
         Object element$iv = var36.next();
         ParsedEntity it = (ParsedEntity)element$iv;
         Iterable $receiver$iv = (Iterable)it.getConstructors();
         int count$iv = 0;
         Iterator var42 = $receiver$iv.iterator();

         Method it;
         Object element$iv;
         while(var42.hasNext()) {
            element$iv = var42.next();
            it = (Method)element$iv;
            if (it.getKeep()) {
               ++count$iv;
            }
         }

         $receiver$iv = (Iterable)it.getMethods();
         int var19 = count$iv;
         count$iv = 0;
         var42 = $receiver$iv.iterator();

         while(var42.hasNext()) {
            element$iv = var42.next();
            it = (Method)element$iv;
            if (it.getKeep()) {
               ++count$iv;
            }
         }

         var26 = var19 + count$iv;
      }

      if (count$iv + sum$iv > 0) {
         System.err.println("Kept source for " + count$iv + " classes and " + sum$iv + " methods because of @Keep annotation");
      }

   }

   private final void checkClass(ParsedEntity parsedEntity) {
      boolean var10000;
      label38: {
         List propertiesInConstructorOrder = parsedEntity.getPropertiesInConstructorOrder();
         if (propertiesInConstructorOrder == null) {
            Greendao3Generator $receiver = (Greendao3Generator)this;
            Iterable $receiver$iv = (Iterable)parsedEntity.getProperties();
            Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
            Iterator var9 = $receiver$iv.iterator();

            while(var9.hasNext()) {
               Object item$iv$iv = var9.next();
               ParsedProperty it = (ParsedProperty)item$iv$iv;
               Variable var13 = it.getVariable();
               destination$iv$iv.add(var13);
            }

            List fieldVars = (List)destination$iv$iv;
            $receiver$iv = (Iterable)parsedEntity.getConstructors();
            Iterator var7 = $receiver$iv.iterator();

            while(true) {
               if (!var7.hasNext()) {
                  var10000 = true;
                  break;
               }

               Object element$iv = var7.next();
               Method it = (Method)element$iv;
               if (it.hasFullSignature(parsedEntity.getName(), fieldVars)) {
                  var10000 = false;
                  break;
               }
            }

            if (var10000) {
               var10000 = true;
               break label38;
            }
         }

         var10000 = false;
      }

      boolean noConstructor = var10000;
      if (noConstructor) {
         throw (Throwable)(new RuntimeException("Can't find constructor for entity " + parsedEntity.getName() + " with all persistent fields. " + "Note parameter names of such constructor should be equal to field names"));
      }
   }

   private final void transformClass(ParsedEntity parsedEntity, Map mapping) {
      Object var10000 = mapping.get(parsedEntity);
      if (var10000 == null) {
         Intrinsics.throwNpe();
      }

      final Entity entity = (Entity)var10000;
      String daoPackage = entity.getSchema().getDefaultJavaPackage();
      EntityClassTransformer transformer = this.context.transformer(parsedEntity);
      transformer.ensureImport("org.greenrobot.greendao.annotation.Generated");
      transformer.annotateLegacyKeepFields();
      String daoSessionVarName = entity.getSchema().getPrefix() + "DaoSession";
      Boolean var7 = entity.getActive();
      Intrinsics.checkExpressionValueIsNotNull(var7, "entity.active");
      if (var7) {
         transformer.ensureImport("org.greenrobot.greendao.DaoException");
         transformer.defMethod("__setDaoSession", new String[]{daoPackage + "." + daoSessionVarName}, (Function0)(new Function0() {
            @NotNull
            public final String invoke() {
               return Templates.entity.INSTANCE.daoSessionSetter(entity);
            }
         }));
         this.generateActiveMethodsAndFields(transformer);
         this.generateToManyRelations(entity, transformer);
         this.generateToOneRelations(entity, parsedEntity, transformer);
      }

      this.generateGettersAndSetters(parsedEntity, transformer);
      this.generateConstructors(parsedEntity, transformer);
      var7 = entity.getActive();
      Intrinsics.checkExpressionValueIsNotNull(var7, "entity.active");
      if (var7) {
         String var10004 = entity.getJavaPackageDao() + "." + entity.getClassNameDao();
         String var10006 = entity.getClassNameDao();
         Intrinsics.checkExpressionValueIsNotNull(var10006, "entity.classNameDao");
         transformer.defField("myDao", new VariableType(var10004, false, var10006, (List)null, 8, (DefaultConstructorMarker)null), "Used for active entity operations.");
         transformer.defField("daoSession", new VariableType(daoPackage + "." + daoSessionVarName, false, daoSessionVarName, (List)null, 8, (DefaultConstructorMarker)null), "Used to resolve relations");
      }

      transformer.writeToFile();
   }

   private final void generateConstructors(final ParsedEntity parsedEntity, EntityClassTransformer transformer) {
      if (parsedEntity.getGenerateConstructors()) {
         List var10000 = parsedEntity.getPropertiesInConstructorOrder();
         if (var10000 == null) {
            var10000 = parsedEntity.getProperties();
         }

         List properties = var10000;
         Collection var4 = (Collection)properties;
         Iterable $receiver$iv;
         if (!var4.isEmpty()) {
            $receiver$iv = (Iterable)parsedEntity.getConstructors();
            Iterator var5 = $receiver$iv.iterator();

            boolean var19;
            while(true) {
               if (!var5.hasNext()) {
                  var19 = true;
                  break;
               }

               Object element$iv = var5.next();
               Method it = (Method)element$iv;
               if (it.getParameters().isEmpty() && !it.getGenerated()) {
                  var19 = false;
                  break;
               }
            }

            if (var19) {
               transformer.defConstructor(CollectionsKt.emptyList(), (Function0)(new Function0() {
                  @NotNull
                  public final String invoke() {
                     return " @Generated(hash = " + EntityClassTransformerKt.getHASH_STUB() + ")" + "\n" + "                        public " + parsedEntity.getName() + "() {" + "\n" + "                        }";
                  }
               }));
            }
         }

         $receiver$iv = (Iterable)properties;
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
         Iterator var18 = $receiver$iv.iterator();

         while(var18.hasNext()) {
            Object item$iv$iv = var18.next();
            ParsedProperty it = (ParsedProperty)item$iv$iv;
            String var15 = it.getVariable().getType().getName();
            destination$iv$iv.add(var15);
         }

         List var14 = (List)destination$iv$iv;
         transformer.defConstructor(var14, (Function0)(new Function0() {
            @NotNull
            public final String invoke() {
               Templates.entity var10000 = Templates.entity.INSTANCE;
               String var10001 = parsedEntity.getName();
               List var10002 = parsedEntity.getProperties();
               String var10003 = parsedEntity.getNotNullAnnotation();
               if (var10003 == null) {
                  var10003 = "@NotNull";
               }

               return var10000.constructor(var10001, var10002, var10003);
            }
         }));
      } else {
         transformer.ensureDefaultConstructor();
      }

   }

   private final void generateGettersAndSetters(ParsedEntity parsedEntity, EntityClassTransformer transformer) {
      if (!parsedEntity.getGenerateGettersSetters()) {
         String var11 = "Not generating getters or setters for " + parsedEntity.getName() + ".";
         System.out.println(var11);
      } else {
         Iterable $receiver$iv = (Iterable)CollectionsKt.reversed((Iterable)parsedEntity.getProperties());
         Iterator var4 = $receiver$iv.iterator();

         while(var4.hasNext()) {
            Object element$iv = var4.next();
            ParsedProperty field = (ParsedProperty)element$iv;
            transformer.defMethodIfMissing("set" + StringsKt.capitalize(field.getVariable().getName()), new String[]{field.getVariable().getType().getName()}, (Function0)(new Greendao3Generator$generateGettersAndSetters$1$1(field)));
            String var10001 = "get" + StringsKt.capitalize(field.getVariable().getName());
            Function0 var10002 = (Function0)(new Greendao3Generator$generateGettersAndSetters$1$2(field));
            String[] var7 = new String[0];
            Function0 var8 = var10002;
            transformer.defMethodIfMissing(var10001, var7, var8);
         }

      }
   }

   private final void generateToOneRelations(Entity entity, ParsedEntity parsedEntity, EntityClassTransformer transformer) {
      Iterable $receiver$iv = (Iterable)CollectionsKt.reversed((Iterable)entity.getToOneRelations());
      Iterator var5 = $receiver$iv.iterator();

      while(var5.hasNext()) {
         Object element$iv = var5.next();
         ToOne toOne = (ToOne)element$iv;
         transformer.ensureImport(toOne.getTargetEntity().getJavaPackageDao() + "." + toOne.getTargetEntity().getClassNameDao());
         String var10001 = "set" + StringsKt.capitalize(toOne.getName());
         String[] var10002 = new String[1];
         String var10005 = toOne.getTargetEntity().getClassName();
         Intrinsics.checkExpressionValueIsNotNull(var10005, "toOne.targetEntity.className");
         var10002[0] = var10005;
         transformer.defMethod(var10001, var10002, (Function0)(new Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$1(toOne, transformer, parsedEntity, entity)));
         String[] var8;
         Function0 var9;
         Function0 var12;
         if (!toOne.isUseFkProperty()) {
            var10001 = "peak" + StringsKt.capitalize(toOne.getName());
            var12 = (Function0)(new Greendao3Generator$generateToOneRelations$1$2(toOne));
            var8 = new String[0];
            var9 = var12;
            transformer.defMethod(var10001, var8, var9);
         }

         var10001 = "get" + StringsKt.capitalize(toOne.getName());
         var12 = (Function0)(new Greendao3Generator$generateToOneRelations$$inlined$forEach$lambda$2(toOne, transformer, parsedEntity, entity));
         var8 = new String[0];
         var9 = var12;
         transformer.defMethod(var10001, var8, var9);
         if (toOne.isUseFkProperty()) {
            var10001 = toOne.getName() + "__resolvedKey";
            String var10004 = toOne.getResolvedKeyJavaType()[0];
            Intrinsics.checkExpressionValueIsNotNull(var10004, "toOne.resolvedKeyJavaType[0]");
            String var10006 = toOne.getResolvedKeyJavaType()[0];
            Intrinsics.checkExpressionValueIsNotNull(var10006, "toOne.resolvedKeyJavaType[0]");
            EntityClassTransformer.defField$default(transformer, var10001, new VariableType(var10004, false, var10006, (List)null, 8, (DefaultConstructorMarker)null), (String)null, 4, (Object)null);
         } else {
            EntityClassTransformer.defField$default(transformer, toOne.getName() + "__refreshed", new VariableType("boolean", true, "boolean", (List)null, 8, (DefaultConstructorMarker)null), (String)null, 4, (Object)null);
         }
      }

   }

   private final void generateToManyRelations(Entity entity, EntityClassTransformer transformer) {
      Iterable $receiver$iv = (Iterable)CollectionsKt.reversed((Iterable)entity.getToManyRelations());
      Iterator var4 = $receiver$iv.iterator();

      while(var4.hasNext()) {
         Object element$iv = var4.next();
         ToManyBase toMany = (ToManyBase)element$iv;
         transformer.ensureImport(toMany.getTargetEntity().getJavaPackageDao() + "." + toMany.getTargetEntity().getClassNameDao());
         String var10001 = "reset" + StringsKt.capitalize(toMany.getName());
         Function0 var10002 = (Function0)(new Greendao3Generator$generateToManyRelations$1$1(toMany));
         String[] var7 = new String[0];
         Function0 var8 = var10002;
         transformer.defMethod(var10001, var7, var8);
         var10001 = "get" + StringsKt.capitalize(toMany.getName());
         var10002 = (Function0)(new Greendao3Generator$generateToManyRelations$$inlined$forEach$lambda$1(toMany, transformer, entity));
         var7 = new String[0];
         var8 = var10002;
         transformer.defMethod(var10001, var7, var8);
      }

   }

   private final void generateActiveMethodsAndFields(EntityClassTransformer transformer) {
      Function0 var10002 = (Function0)null.INSTANCE;
      String[] var2 = new String[0];
      Function0 var3 = var10002;
      transformer.defMethod("update", var2, var3);
      var10002 = (Function0)null.INSTANCE;
      var2 = new String[0];
      var3 = var10002;
      transformer.defMethod("refresh", var2, var3);
      var10002 = (Function0)null.INSTANCE;
      var2 = new String[0];
      var3 = var10002;
      transformer.defMethod("delete", var2, var3);
   }

   @NotNull
   public final List getSkipTestGeneration() {
      return this.skipTestGeneration;
   }

   public Greendao3Generator(@Nullable FormattingOptions formattingOptions, @NotNull List skipTestGeneration, @NotNull String encoding) {
      Intrinsics.checkParameterIsNotNull(skipTestGeneration, "skipTestGeneration");
      Intrinsics.checkParameterIsNotNull(encoding, "encoding");
      super();
      this.skipTestGeneration = skipTestGeneration;
      this.context = new JdtCodeContext(formattingOptions, encoding);
   }

   // $FF: synthetic method
   public Greendao3Generator(FormattingOptions var1, List var2, String var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 1) != 0) {
         var1 = (FormattingOptions)null;
      }

      if ((var4 & 2) != 0) {
         var2 = CollectionsKt.emptyList();
      }

      if ((var4 & 4) != 0) {
         var3 = "UTF-8";
      }

      this(var1, var2, var3);
   }

   public Greendao3Generator() {
      this((FormattingOptions)null, (List)null, (String)null, 7, (DefaultConstructorMarker)null);
   }
}
