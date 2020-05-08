package org.greenrobot.greendao.codemodifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.greendao.generator.DaoUtil;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Index;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.PropertyType;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;
import org.greenrobot.greendao.generator.ToManyBase;
import org.greenrobot.greendao.generator.ToManyWithJoinEntity;
import org.greenrobot.greendao.generator.Property.PropertyBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J4\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J2\u0010 \u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010\"\u001a\u00020\u000b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J2\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00100\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0014\u0010$\u001a\u00020%*\u00020\u00102\u0006\u0010&\u001a\u00020\u0005H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006'"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/GreendaoModelTranslator;", "", "()V", "WRAPPER_TYPES", "", "", "getWRAPPER_TYPES", "()Ljava/util/List;", "setWRAPPER_TYPES", "(Ljava/util/List;)V", "addBasicProperties", "", "daoPackage", "it", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "addIndexes", "convertProperties", "parsedEntity", "convertProperty", "property", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "convertPropertyType", "Lorg/greenrobot/greendao/generator/PropertyType;", "javaTypeName", "mapEntityClassesToEntities", "", "entities", "", "schema", "Lorg/greenrobot/greendao/generator/Schema;", "resolveToManyRelations", "mapping", "resolveToOneRelations", "translate", "findProperty", "Lorg/greenrobot/greendao/generator/Property;", "name", "greendao-code-modifier_main"}
)
public final class GreendaoModelTranslator {
   @NotNull
   private static List WRAPPER_TYPES;
   public static final GreendaoModelTranslator INSTANCE;

   @NotNull
   public final List getWRAPPER_TYPES() {
      return WRAPPER_TYPES;
   }

   public final void setWRAPPER_TYPES(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      WRAPPER_TYPES = var1;
   }

   @NotNull
   public final Map translate(@NotNull Iterable entities, @NotNull Schema schema, @Nullable String daoPackage) {
      Intrinsics.checkParameterIsNotNull(entities, "entities");
      Intrinsics.checkParameterIsNotNull(schema, "schema");
      Map mapping = this.mapEntityClassesToEntities(entities, schema, daoPackage);
      this.resolveToOneRelations(mapping, entities, schema);
      this.resolveToManyRelations(mapping, entities, schema);
      return mapping;
   }

   private final Map mapEntityClassesToEntities(Iterable entities, Schema schema, String daoPackage) {
      Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(entities, 10)));
      Iterator var7 = entities.iterator();

      while(var7.hasNext()) {
         Object item$iv$iv = var7.next();
         ParsedEntity it = (ParsedEntity)item$iv$iv;
         Entity entity = schema.addEntity(it.getName());
         GreendaoModelTranslator var10000 = INSTANCE;
         Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
         var10000.addBasicProperties(daoPackage, it, entity);
         if (it.getDbName() != null) {
            entity.setDbName(it.getDbName());
         }

         if (it.getActive()) {
            entity.setActive(true);
         }

         entity.setSkipCreationInDb(!it.getCreateInDb());
         entity.setJavaPackage(it.getPackageName());
         var10000 = INSTANCE;
         Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
         var10000.convertProperties(it, entity);
         var10000 = INSTANCE;
         Intrinsics.checkExpressionValueIsNotNull(entity, "entity");
         var10000.addIndexes(it, entity);
         if (it.getProtobufClassName() != null) {
            Entity protobufEntity = schema.addProtobufEntity(StringsKt.substringAfterLast$default(it.getProtobufClassName(), ".", (String)null, 2, (Object)null));
            var10000 = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(protobufEntity, "protobufEntity");
            var10000.addBasicProperties(daoPackage, it, protobufEntity);
            protobufEntity.setDbName(entity.getDbName());
            protobufEntity.setActive(false);
            protobufEntity.setSkipCreationInDb(true);
            protobufEntity.setJavaPackage(StringsKt.substringBeforeLast$default(it.getProtobufClassName(), ".", (String)null, 2, (Object)null));
            var10000 = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(protobufEntity, "protobufEntity");
            var10000.convertProperties(it, protobufEntity);
            var10000 = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(protobufEntity, "protobufEntity");
            var10000.addIndexes(it, protobufEntity);
         }

         Pair var16 = TuplesKt.to(it, entity);
         destination$iv$iv.add(var16);
      }

      return MapsKt.toMap((Iterable)((List)destination$iv$iv));
   }

   private final void addBasicProperties(String daoPackage, ParsedEntity it, Entity entity) {
      entity.setConstructors(it.getGenerateConstructors());
      String var10001 = daoPackage;
      if (daoPackage == null) {
         var10001 = it.getPackageName();
      }

      entity.setJavaPackageDao(var10001);
      var10001 = daoPackage;
      if (daoPackage == null) {
         var10001 = it.getPackageName();
      }

      entity.setJavaPackageTest(var10001);
      entity.setSkipGeneration(true);
   }

   private final void convertProperties(ParsedEntity parsedEntity, Entity entity) {
      List var10000 = parsedEntity.getPropertiesInConstructorOrder();
      if (var10000 == null) {
         var10000 = parsedEntity.getProperties();
      }

      List properties = var10000;
      Iterable $receiver$iv = (Iterable)properties;
      Iterator var5 = $receiver$iv.iterator();

      while(var5.hasNext()) {
         Object element$iv = var5.next();
         ParsedProperty it = (ParsedProperty)element$iv;

         try {
            INSTANCE.convertProperty(entity, it);
         } catch (Exception var11) {
            throw (Throwable)(new RuntimeException("Can't add property '" + it.getVariable() + "' to entity " + parsedEntity.getName() + " " + "due to: " + var11.getMessage(), (Throwable)var11));
         }
      }

   }

   private final void addIndexes(ParsedEntity it, Entity entity) {
      // $FF: Couldn't be decompiled
   }

   private final void resolveToOneRelations(Map mapping, Iterable entities, Schema schema) {
      Collection destination$iv$iv = (Collection)(new ArrayList());
      Iterator var7 = entities.iterator();

      while(var7.hasNext()) {
         Object element$iv$iv = var7.next();
         ParsedEntity it = (ParsedEntity)element$iv$iv;
         if (!it.getOneRelations().isEmpty()) {
            destination$iv$iv.add(element$iv$iv);
         }
      }

      Iterable $receiver$iv = (Iterable)((List)destination$iv$iv);
      Iterator var5 = $receiver$iv.iterator();

      label84:
      while(var5.hasNext()) {
         Object element$iv = var5.next();
         ParsedEntity entity = (ParsedEntity)element$iv;
         Object var10000 = mapping.get(entity);
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         Entity source = (Entity)var10000;
         Iterable $receiver$iv = (Iterable)entity.getOneRelations();
         Iterator var10 = $receiver$iv.iterator();

         while(true) {
            while(true) {
               if (!var10.hasNext()) {
                  continue label84;
               }

               Object element$iv = var10.next();
               OneRelation relation = (OneRelation)element$iv;
               Iterable var13 = (Iterable)schema.getEntities();
               Iterator var15 = var13.iterator();

               while(true) {
                  if (!var15.hasNext()) {
                     var10000 = null;
                     break;
                  }

                  Object var16 = var15.next();
                  Entity it = (Entity)var16;
                  if (Intrinsics.areEqual(it.getClassName(), relation.getVariable().getType().getSimpleName())) {
                     var10000 = var16;
                     break;
                  }
               }

               Entity var31 = (Entity)var10000;
               if (var31 == null) {
                  throw (Throwable)(new RuntimeException("Class " + relation.getVariable().getType().getName() + " marked " + "with @ToOne in class " + entity.getName() + " is not an entity"));
               }

               Entity target = var31;
               if (relation.getForeignKeyField() != null) {
                  Iterable var14 = (Iterable)source.getProperties();
                  Iterator var30 = var14.iterator();

                  while(true) {
                     if (!var30.hasNext()) {
                        var10000 = null;
                        break;
                     }

                     Object var32 = var30.next();
                     Property it = (Property)var32;
                     if (Intrinsics.areEqual(it.getPropertyName(), relation.getForeignKeyField())) {
                        var10000 = var32;
                        break;
                     }
                  }

                  Property var33 = (Property)var10000;
                  if (var33 == null) {
                     throw (Throwable)(new RuntimeException("Can't find " + relation.getForeignKeyField() + " in " + entity.getName() + " " + "for @ToOne relation"));
                  }

                  Property fkProperty = var33;
                  if (relation.getColumnName() != null || relation.getUnique()) {
                     throw (Throwable)(new RuntimeException("If @ToOne with foreign property used, @Column and @Unique are ignored. " + "See " + entity.getName() + "." + relation.getVariable().getName()));
                  }

                  source.addToOne(target, fkProperty, relation.getVariable().getName());
               } else {
                  String var10001 = relation.getVariable().getName();
                  String var10003 = relation.getColumnName();
                  if (var10003 == null) {
                     var10003 = DaoUtil.dbName(relation.getVariable().getName());
                  }

                  source.addToOneWithoutProperty(var10001, target, var10003, relation.isNotNull(), relation.getUnique());
               }
            }
         }
      }

   }

   private final void resolveToManyRelations(Map mapping, Iterable entities, Schema schema) {
      // $FF: Couldn't be decompiled
   }

   private final void convertProperty(Entity entity, ParsedProperty property) {
      VariableType var5;
      label56: {
         CustomType var10001 = property.getCustomType();
         if (var10001 != null) {
            var5 = var10001.getColumnJavaType();
            if (var5 != null) {
               break label56;
            }
         }

         var5 = property.getVariable().getType();
      }

      PropertyType propertyType = this.convertPropertyType(var5.getName());
      PropertyBuilder propertyBuilder = entity.addProperty(propertyType, property.getVariable().getName());
      if (property.getVariable().getType().isPrimitive()) {
         propertyBuilder.notNull();
      } else if (WRAPPER_TYPES.contains(property.getVariable().getType().getName())) {
         propertyBuilder.nonPrimitiveType();
      }

      if (property.isNotNull()) {
         propertyBuilder.notNull();
      }

      if (property.getUnique() && property.getIndex() != null) {
         throw (Throwable)(new RuntimeException("greenDAO: having unique constraint and index on the field at the same time is redundant. Either @Unique or @Index should be used"));
      } else {
         if (property.getUnique()) {
            propertyBuilder.unique();
         }

         if (property.getIndex() != null) {
            propertyBuilder.indexAsc(property.getIndex().getName(), property.getIndex().getUnique());
         }

         if (property.getId() != null) {
            propertyBuilder.primaryKey();
            if (property.getId().getAutoincrement()) {
               propertyBuilder.autoincrement();
            }
         }

         if (property.getDbName() != null) {
            propertyBuilder.dbName(property.getDbName());
         } else if (property.getId() != null && Intrinsics.areEqual(propertyType, PropertyType.Long)) {
            propertyBuilder.dbName("_id");
         }

         if (property.getCustomType() != null) {
            propertyBuilder.customType(property.getVariable().getType().getName(), property.getCustomType().getConverterClassName());
         }

      }
   }

   private final PropertyType convertPropertyType(String javaTypeName) {
      PropertyType var10000;
      label209: {
         label210: {
            label211: {
               label212: {
                  label213: {
                     label214: {
                        label215: {
                           label216: {
                              switch(javaTypeName.hashCode()) {
                              case -2056817302:
                                 if (!javaTypeName.equals("java.lang.Integer")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label211;
                              case -1808118735:
                                 if (!javaTypeName.equals("String")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label216;
                              case -1374008726:
                                 if (!javaTypeName.equals("byte[]")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }

                                 var10000 = PropertyType.ByteArray;
                                 return var10000;
                              case -1325958191:
                                 if (!javaTypeName.equals("double")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label214;
                              case -672261858:
                                 if (!javaTypeName.equals("Integer")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label211;
                              case -527879800:
                                 if (!javaTypeName.equals("java.lang.Float")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label213;
                              case -515992664:
                                 if (!javaTypeName.equals("java.lang.Short")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label215;
                              case 104431:
                                 if (!javaTypeName.equals("int")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label211;
                              case 2086184:
                                 if (!javaTypeName.equals("Byte")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label210;
                              case 2122702:
                                 if (!javaTypeName.equals("Date")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break;
                              case 2374300:
                                 if (!javaTypeName.equals("Long")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label212;
                              case 3039496:
                                 if (!javaTypeName.equals("byte")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label210;
                              case 3327612:
                                 if (!javaTypeName.equals("long")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label212;
                              case 64711720:
                                 if (!javaTypeName.equals("boolean")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label209;
                              case 65575278:
                                 if (!javaTypeName.equals("java.util.Date")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break;
                              case 67973692:
                                 if (!javaTypeName.equals("Float")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label213;
                              case 79860828:
                                 if (!javaTypeName.equals("Short")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label215;
                              case 97526364:
                                 if (!javaTypeName.equals("float")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label213;
                              case 109413500:
                                 if (!javaTypeName.equals("short")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label215;
                              case 344809556:
                                 if (!javaTypeName.equals("java.lang.Boolean")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label209;
                              case 398507100:
                                 if (!javaTypeName.equals("java.lang.Byte")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label210;
                              case 398795216:
                                 if (!javaTypeName.equals("java.lang.Long")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label212;
                              case 761287205:
                                 if (!javaTypeName.equals("java.lang.Double")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label214;
                              case 1195259493:
                                 if (!javaTypeName.equals("java.lang.String")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label216;
                              case 1729365000:
                                 if (!javaTypeName.equals("Boolean")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label209;
                              case 2052876273:
                                 if (!javaTypeName.equals("Double")) {
                                    throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                                 }
                                 break label214;
                              default:
                                 throw (Throwable)(new RuntimeException("Unsupported type " + javaTypeName));
                              }

                              var10000 = PropertyType.Date;
                              return var10000;
                           }

                           var10000 = PropertyType.String;
                           return var10000;
                        }

                        var10000 = PropertyType.Short;
                        return var10000;
                     }

                     var10000 = PropertyType.Double;
                     return var10000;
                  }

                  var10000 = PropertyType.Float;
                  return var10000;
               }

               var10000 = PropertyType.Long;
               return var10000;
            }

            var10000 = PropertyType.Int;
            return var10000;
         }

         var10000 = PropertyType.Byte;
         return var10000;
      }

      var10000 = PropertyType.Boolean;
      return var10000;
   }

   private final Property findProperty(@NotNull Entity $receiver, String name) {
      Iterable var3 = (Iterable)$receiver.getProperties();
      Iterator var5 = var3.iterator();

      Object var10000;
      while(true) {
         if (var5.hasNext()) {
            Object var6 = var5.next();
            Property it = (Property)var6;
            if (!Intrinsics.areEqual(it.getPropertyName(), name)) {
               continue;
            }

            var10000 = var6;
            break;
         }

         var10000 = null;
         break;
      }

      Property var9 = (Property)var10000;
      if (var9 != null) {
         return var9;
      } else {
         throw (Throwable)(new RuntimeException("Can't find " + name + " field in " + $receiver.getClassName()));
      }
   }

   private GreendaoModelTranslator() {
      INSTANCE = (GreendaoModelTranslator)this;
      WRAPPER_TYPES = CollectionsKt.listOf(new String[]{"Boolean", "Byte", "Character", "Short", "Integer", "Long", "Float", "Double", "java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double"});
   }

   static {
      new GreendaoModelTranslator();
   }
}
