package org.greenrobot.greendao.codemodifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00130\bHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00170\bHÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00190\bHÆ\u0003J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001b0\bHÆ\u0003J\t\u0010U\u001a\u00020\u001dHÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\t\u0010X\u001a\u00020\u0006HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010&HÆ\u0003J\t\u0010_\u001a\u00020\u0006HÆ\u0003J\u000f\u0010`\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003J\u000f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000e0\bHÆ\u0003J\t\u0010e\u001a\u00020\u0011HÆ\u0003J·\u0002\u0010f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001J\u0013\u0010g\u001a\u00020\u00062\b\u0010h\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\t\u0010j\u001a\u00020kHÖ\u0001J\t\u0010l\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010)R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010!\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010)R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010+R\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0013\u00104\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010:\u001a\u0004\u0018\u0001058F¢\u0006\u0006\u001a\u0004\b;\u00107R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\bE\u0010+R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0011\u0010G\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bH\u0010.R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010.R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010.R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\bM\u0010+¨\u0006m"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "", "name", "", "schema", "active", "", "properties", "", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "transientFields", "Lorg/greenrobot/greendao/codemodifier/TransientField;", "legacyTransientFields", "constructors", "Lorg/greenrobot/greendao/codemodifier/Method;", "methods", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "imports", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "packageName", "dbName", "oneRelations", "Lorg/greenrobot/greendao/codemodifier/OneRelation;", "manyRelations", "Lorg/greenrobot/greendao/codemodifier/ManyRelation;", "indexes", "Lorg/greenrobot/greendao/codemodifier/TableIndex;", "sourceFile", "Ljava/io/File;", "source", "keepSource", "createInDb", "generateConstructors", "generateGettersSetters", "protobufClassName", "notNullAnnotation", "lastFieldDeclaration", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/io/File;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;)V", "getActive", "()Z", "getConstructors", "()Ljava/util/List;", "getCreateInDb", "getDbName", "()Ljava/lang/String;", "getGenerateConstructors", "getGenerateGettersSetters", "getImports", "getIndexes", "getKeepSource", "lastConstructorDeclaration", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "getLastConstructorDeclaration", "()Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "getLastFieldDeclaration", "()Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "lastMethodDeclaration", "getLastMethodDeclaration", "getLegacyTransientFields", "getManyRelations", "getMethods", "getName", "getNode", "()Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "getNotNullAnnotation", "getOneRelations", "getPackageName", "getProperties", "getProtobufClassName", "qualifiedClassName", "getQualifiedClassName", "getSchema", "getSource", "getSourceFile", "()Ljava/io/File;", "getTransientFields", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getPropertiesInConstructorOrder", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class ParsedEntity {
   @NotNull
   private final String name;
   @NotNull
   private final String schema;
   private final boolean active;
   @NotNull
   private final List properties;
   @NotNull
   private final List transientFields;
   @NotNull
   private final List legacyTransientFields;
   @NotNull
   private final List constructors;
   @NotNull
   private final List methods;
   @NotNull
   private final TypeDeclaration node;
   @NotNull
   private final List imports;
   @NotNull
   private final String packageName;
   @Nullable
   private final String dbName;
   @NotNull
   private final List oneRelations;
   @NotNull
   private final List manyRelations;
   @NotNull
   private final List indexes;
   @NotNull
   private final File sourceFile;
   @NotNull
   private final String source;
   private final boolean keepSource;
   private final boolean createInDb;
   private final boolean generateConstructors;
   private final boolean generateGettersSetters;
   @Nullable
   private final String protobufClassName;
   @Nullable
   private final String notNullAnnotation;
   @Nullable
   private final FieldDeclaration lastFieldDeclaration;

   @NotNull
   public final String getQualifiedClassName() {
      return this.packageName + "." + this.name;
   }

   @Nullable
   public final MethodDeclaration getLastMethodDeclaration() {
      Method var10000 = (Method)CollectionsKt.lastOrNull(this.methods);
      return var10000 != null ? var10000.getNode() : null;
   }

   @Nullable
   public final MethodDeclaration getLastConstructorDeclaration() {
      Method var10000 = (Method)CollectionsKt.lastOrNull(this.constructors);
      return var10000 != null ? var10000.getNode() : null;
   }

   @Nullable
   public final List getPropertiesInConstructorOrder() {
      Iterable $receiver$iv = (Iterable)this.properties;
      Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      Iterator var5 = $receiver$iv.iterator();

      while(var5.hasNext()) {
         Object item$iv$iv = var5.next();
         ParsedProperty it = (ParsedProperty)item$iv$iv;
         Variable var12 = it.getVariable();
         destination$iv$iv.add(var12);
      }

      Set fieldVarsSet = CollectionsKt.toSet((Iterable)((List)destination$iv$iv));
      $receiver$iv = (Iterable)this.constructors;
      Iterator var14 = $receiver$iv.iterator();

      Object var10000;
      while(true) {
         if (var14.hasNext()) {
            Object var16 = var14.next();
            Method it = (Method)var16;
            if (!Intrinsics.areEqual(CollectionsKt.toSet((Iterable)it.getParameters()), fieldVarsSet)) {
               continue;
            }

            var10000 = var16;
            break;
         }

         var10000 = null;
         break;
      }

      Method var18 = (Method)var10000;
      List var19;
      if (var18 != null) {
         Method var13 = var18;
         Method constructor = (Method)var13;
         Iterable $receiver$iv = (Iterable)this.properties;
         Comparator var20 = (Comparator)(new ParsedEntity$$special$$inlined$sortedBy$1(constructor));
         var19 = (List)CollectionsKt.sortedWith($receiver$iv, var20);
      } else {
         var19 = null;
      }

      return var19;
   }

   @NotNull
   public final String getName() {
      return this.name;
   }

   @NotNull
   public final String getSchema() {
      return this.schema;
   }

   public final boolean getActive() {
      return this.active;
   }

   @NotNull
   public final List getProperties() {
      return this.properties;
   }

   @NotNull
   public final List getTransientFields() {
      return this.transientFields;
   }

   @NotNull
   public final List getLegacyTransientFields() {
      return this.legacyTransientFields;
   }

   @NotNull
   public final List getConstructors() {
      return this.constructors;
   }

   @NotNull
   public final List getMethods() {
      return this.methods;
   }

   @NotNull
   public final TypeDeclaration getNode() {
      return this.node;
   }

   @NotNull
   public final List getImports() {
      return this.imports;
   }

   @NotNull
   public final String getPackageName() {
      return this.packageName;
   }

   @Nullable
   public final String getDbName() {
      return this.dbName;
   }

   @NotNull
   public final List getOneRelations() {
      return this.oneRelations;
   }

   @NotNull
   public final List getManyRelations() {
      return this.manyRelations;
   }

   @NotNull
   public final List getIndexes() {
      return this.indexes;
   }

   @NotNull
   public final File getSourceFile() {
      return this.sourceFile;
   }

   @NotNull
   public final String getSource() {
      return this.source;
   }

   public final boolean getKeepSource() {
      return this.keepSource;
   }

   public final boolean getCreateInDb() {
      return this.createInDb;
   }

   public final boolean getGenerateConstructors() {
      return this.generateConstructors;
   }

   public final boolean getGenerateGettersSetters() {
      return this.generateGettersSetters;
   }

   @Nullable
   public final String getProtobufClassName() {
      return this.protobufClassName;
   }

   @Nullable
   public final String getNotNullAnnotation() {
      return this.notNullAnnotation;
   }

   @Nullable
   public final FieldDeclaration getLastFieldDeclaration() {
      return this.lastFieldDeclaration;
   }

   public ParsedEntity(@NotNull String name, @NotNull String schema, boolean active, @NotNull List properties, @NotNull List transientFields, @NotNull List legacyTransientFields, @NotNull List constructors, @NotNull List methods, @NotNull TypeDeclaration node, @NotNull List imports, @NotNull String packageName, @Nullable String dbName, @NotNull List oneRelations, @NotNull List manyRelations, @NotNull List indexes, @NotNull File sourceFile, @NotNull String source, boolean keepSource, boolean createInDb, boolean generateConstructors, boolean generateGettersSetters, @Nullable String protobufClassName, @Nullable String notNullAnnotation, @Nullable FieldDeclaration lastFieldDeclaration) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(schema, "schema");
      Intrinsics.checkParameterIsNotNull(properties, "properties");
      Intrinsics.checkParameterIsNotNull(transientFields, "transientFields");
      Intrinsics.checkParameterIsNotNull(legacyTransientFields, "legacyTransientFields");
      Intrinsics.checkParameterIsNotNull(constructors, "constructors");
      Intrinsics.checkParameterIsNotNull(methods, "methods");
      Intrinsics.checkParameterIsNotNull(node, "node");
      Intrinsics.checkParameterIsNotNull(imports, "imports");
      Intrinsics.checkParameterIsNotNull(packageName, "packageName");
      Intrinsics.checkParameterIsNotNull(oneRelations, "oneRelations");
      Intrinsics.checkParameterIsNotNull(manyRelations, "manyRelations");
      Intrinsics.checkParameterIsNotNull(indexes, "indexes");
      Intrinsics.checkParameterIsNotNull(sourceFile, "sourceFile");
      Intrinsics.checkParameterIsNotNull(source, "source");
      super();
      this.name = name;
      this.schema = schema;
      this.active = active;
      this.properties = properties;
      this.transientFields = transientFields;
      this.legacyTransientFields = legacyTransientFields;
      this.constructors = constructors;
      this.methods = methods;
      this.node = node;
      this.imports = imports;
      this.packageName = packageName;
      this.dbName = dbName;
      this.oneRelations = oneRelations;
      this.manyRelations = manyRelations;
      this.indexes = indexes;
      this.sourceFile = sourceFile;
      this.source = source;
      this.keepSource = keepSource;
      this.createInDb = createInDb;
      this.generateConstructors = generateConstructors;
      this.generateGettersSetters = generateGettersSetters;
      this.protobufClassName = protobufClassName;
      this.notNullAnnotation = notNullAnnotation;
      this.lastFieldDeclaration = lastFieldDeclaration;
   }

   @NotNull
   public final String component1() {
      return this.name;
   }

   @NotNull
   public final String component2() {
      return this.schema;
   }

   public final boolean component3() {
      return this.active;
   }

   @NotNull
   public final List component4() {
      return this.properties;
   }

   @NotNull
   public final List component5() {
      return this.transientFields;
   }

   @NotNull
   public final List component6() {
      return this.legacyTransientFields;
   }

   @NotNull
   public final List component7() {
      return this.constructors;
   }

   @NotNull
   public final List component8() {
      return this.methods;
   }

   @NotNull
   public final TypeDeclaration component9() {
      return this.node;
   }

   @NotNull
   public final List component10() {
      return this.imports;
   }

   @NotNull
   public final String component11() {
      return this.packageName;
   }

   @Nullable
   public final String component12() {
      return this.dbName;
   }

   @NotNull
   public final List component13() {
      return this.oneRelations;
   }

   @NotNull
   public final List component14() {
      return this.manyRelations;
   }

   @NotNull
   public final List component15() {
      return this.indexes;
   }

   @NotNull
   public final File component16() {
      return this.sourceFile;
   }

   @NotNull
   public final String component17() {
      return this.source;
   }

   public final boolean component18() {
      return this.keepSource;
   }

   public final boolean component19() {
      return this.createInDb;
   }

   public final boolean component20() {
      return this.generateConstructors;
   }

   public final boolean component21() {
      return this.generateGettersSetters;
   }

   @Nullable
   public final String component22() {
      return this.protobufClassName;
   }

   @Nullable
   public final String component23() {
      return this.notNullAnnotation;
   }

   @Nullable
   public final FieldDeclaration component24() {
      return this.lastFieldDeclaration;
   }

   @NotNull
   public final ParsedEntity copy(@NotNull String name, @NotNull String schema, boolean active, @NotNull List properties, @NotNull List transientFields, @NotNull List legacyTransientFields, @NotNull List constructors, @NotNull List methods, @NotNull TypeDeclaration node, @NotNull List imports, @NotNull String packageName, @Nullable String dbName, @NotNull List oneRelations, @NotNull List manyRelations, @NotNull List indexes, @NotNull File sourceFile, @NotNull String source, boolean keepSource, boolean createInDb, boolean generateConstructors, boolean generateGettersSetters, @Nullable String protobufClassName, @Nullable String notNullAnnotation, @Nullable FieldDeclaration lastFieldDeclaration) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      Intrinsics.checkParameterIsNotNull(schema, "schema");
      Intrinsics.checkParameterIsNotNull(properties, "properties");
      Intrinsics.checkParameterIsNotNull(transientFields, "transientFields");
      Intrinsics.checkParameterIsNotNull(legacyTransientFields, "legacyTransientFields");
      Intrinsics.checkParameterIsNotNull(constructors, "constructors");
      Intrinsics.checkParameterIsNotNull(methods, "methods");
      Intrinsics.checkParameterIsNotNull(node, "node");
      Intrinsics.checkParameterIsNotNull(imports, "imports");
      Intrinsics.checkParameterIsNotNull(packageName, "packageName");
      Intrinsics.checkParameterIsNotNull(oneRelations, "oneRelations");
      Intrinsics.checkParameterIsNotNull(manyRelations, "manyRelations");
      Intrinsics.checkParameterIsNotNull(indexes, "indexes");
      Intrinsics.checkParameterIsNotNull(sourceFile, "sourceFile");
      Intrinsics.checkParameterIsNotNull(source, "source");
      return new ParsedEntity(name, schema, active, properties, transientFields, legacyTransientFields, constructors, methods, node, imports, packageName, dbName, oneRelations, manyRelations, indexes, sourceFile, source, keepSource, createInDb, generateConstructors, generateGettersSetters, protobufClassName, notNullAnnotation, lastFieldDeclaration);
   }

   public String toString() {
      return "ParsedEntity(name=" + this.name + ", schema=" + this.schema + ", active=" + this.active + ", properties=" + this.properties + ", transientFields=" + this.transientFields + ", legacyTransientFields=" + this.legacyTransientFields + ", constructors=" + this.constructors + ", methods=" + this.methods + ", node=" + this.node + ", imports=" + this.imports + ", packageName=" + this.packageName + ", dbName=" + this.dbName + ", oneRelations=" + this.oneRelations + ", manyRelations=" + this.manyRelations + ", indexes=" + this.indexes + ", sourceFile=" + this.sourceFile + ", source=" + this.source + ", keepSource=" + this.keepSource + ", createInDb=" + this.createInDb + ", generateConstructors=" + this.generateConstructors + ", generateGettersSetters=" + this.generateGettersSetters + ", protobufClassName=" + this.protobufClassName + ", notNullAnnotation=" + this.notNullAnnotation + ", lastFieldDeclaration=" + this.lastFieldDeclaration + ")";
   }

   public int hashCode() {
      String var10000 = this.name;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.schema;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      byte var2 = this.active;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      List var3 = this.properties;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.transientFields;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.legacyTransientFields;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.constructors;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.methods;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      TypeDeclaration var4 = this.node;
      var1 = (var1 + (var4 != null ? var4.hashCode() : 0)) * 31;
      var3 = this.imports;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var10001 = this.packageName;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.dbName;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var3 = this.oneRelations;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.manyRelations;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.indexes;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      File var5 = this.sourceFile;
      var1 = (var1 + (var5 != null ? var5.hashCode() : 0)) * 31;
      var10001 = this.source;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var2 = this.keepSource;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      var2 = this.createInDb;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      var2 = this.generateConstructors;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      var2 = this.generateGettersSetters;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      var10001 = this.protobufClassName;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.notNullAnnotation;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      FieldDeclaration var6 = this.lastFieldDeclaration;
      return var1 + (var6 != null ? var6.hashCode() : 0);
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof ParsedEntity) {
            ParsedEntity var2 = (ParsedEntity)var1;
            if (Intrinsics.areEqual(this.name, var2.name) && Intrinsics.areEqual(this.schema, var2.schema) && this.active == var2.active && Intrinsics.areEqual(this.properties, var2.properties) && Intrinsics.areEqual(this.transientFields, var2.transientFields) && Intrinsics.areEqual(this.legacyTransientFields, var2.legacyTransientFields) && Intrinsics.areEqual(this.constructors, var2.constructors) && Intrinsics.areEqual(this.methods, var2.methods) && Intrinsics.areEqual(this.node, var2.node) && Intrinsics.areEqual(this.imports, var2.imports) && Intrinsics.areEqual(this.packageName, var2.packageName) && Intrinsics.areEqual(this.dbName, var2.dbName) && Intrinsics.areEqual(this.oneRelations, var2.oneRelations) && Intrinsics.areEqual(this.manyRelations, var2.manyRelations) && Intrinsics.areEqual(this.indexes, var2.indexes) && Intrinsics.areEqual(this.sourceFile, var2.sourceFile) && Intrinsics.areEqual(this.source, var2.source) && this.keepSource == var2.keepSource && this.createInDb == var2.createInDb && this.generateConstructors == var2.generateConstructors && this.generateGettersSetters == var2.generateGettersSetters && Intrinsics.areEqual(this.protobufClassName, var2.protobufClassName) && Intrinsics.areEqual(this.notNullAnnotation, var2.notNullAnnotation) && Intrinsics.areEqual(this.lastFieldDeclaration, var2.lastFieldDeclaration)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
