package org.greenrobot.greendao.codemodifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.greenrobot.eclipse.jdt.core.dom.ASTNode;
import org.greenrobot.eclipse.jdt.core.dom.Annotation;
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit;
import org.greenrobot.eclipse.jdt.core.dom.EnumDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.Expression;
import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ImportDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.MarkerAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.Modifier;
import org.greenrobot.eclipse.jdt.core.dom.Name;
import org.greenrobot.eclipse.jdt.core.dom.NormalAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.PackageDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ParameterizedType;
import org.greenrobot.eclipse.jdt.core.dom.SimpleName;
import org.greenrobot.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.Type;
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.TypeLiteral;
import org.greenrobot.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0003H\u0002J\b\u0010w\u001a\u00020tH\u0002J\u0018\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010z\u001a\u00020{2\u0006\u0010\u0002\u001a\u00020\u0003J\u0010\u0010|\u001a\u00020t2\u0006\u0010}\u001a\u000202H\u0016J\u0010\u0010|\u001a\u00020t2\u0006\u0010}\u001a\u00020~H\u0016J$\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013H\u0002J,\u0010\u0084\u0001\u001a\u00020;2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J,\u0010\u0087\u0001\u001a\u00020A2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J4\u0010\u0088\u0001\u001a\u00020G2\r\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00132\b\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0006\u0010}\u001a\u0002022\b\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0002J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008a\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008b\u0001H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u000202H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020'H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008c\u0001H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020~H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008d\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008e\u0001H\u0016J\u0012\u0010\u0089\u0001\u001a\u00020\u000b2\u0007\u0010}\u001a\u00030\u008f\u0001H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020ZH\u0016J\u000f\u0010\u0090\u0001\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u001fJ\u0017\u0010\u0091\u0001\u001a\u00020t*\u00020c2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0002J\u001d\u0010\u0094\u0001\u001a\u00020\u000b\"\u0007\b\u0000\u0010\u0095\u0001\u0018\u0001*\b\u0012\u0004\u0012\u00020\u001f0\u0005H\u0082\bJ\u001b\u0010\u0096\u0001\u001a\u00020\u000b*\u00020\u001f2\f\u0010\u0097\u0001\u001a\u0007\u0012\u0002\b\u00030\u0098\u0001H\u0002J+\u0010\u0099\u0001\u001a\u0005\u0018\u0001H\u009a\u0001\"\f\b\u0000\u0010\u009a\u0001\u0018\u0001*\u00030\u009b\u0001*\b\u0012\u0004\u0012\u00020\u001f0\u0005H\u0082\b¢\u0006\u0003\u0010\u009c\u0001J\u000e\u0010\u009d\u0001\u001a\u00030\u0086\u0001*\u00020pH\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000fR\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0011R\u001a\u0010)\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u001a\u0010.\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0013¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0011R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0013¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0011R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0011R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0011R\u001c\u0010C\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001b\"\u0004\bE\u0010\u001dR\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0013¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0011R\u001c\u0010I\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u001b\"\u0004\bK\u0010\u001dR\u001a\u0010L\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001b\"\u0004\bN\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u001bR\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0011R \u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0011\"\u0004\bU\u0010VR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u0002080\u0013¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u0011R\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001b\"\u0004\ba\u0010\u001dR\u001a\u0010b\u001a\u0004\u0018\u00010\u0003*\u00020c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR \u0010f\u001a\u0004\u0018\u00010g*\b\u0012\u0004\u0012\u00020\u001f0\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bh\u0010iR\u001e\u0010j\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u001f0\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0018\u0010m\u001a\u00020\u0003*\u00020c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010eR\u0018\u0010o\u001a\u00020\u0003*\u00020p8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u0010r¨\u0006\u009e\u0001"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/EntityClassASTVisitor;", "Lorg/greenrobot/greendao/codemodifier/LazyVisitor;", "source", "", "classesInPackage", "", "keepFieldsStartLineNumber", "", "keepFieldsEndLineNumber", "(Ljava/lang/String;Ljava/util/List;II)V", "active", "", "getActive", "()Z", "setActive", "(Z)V", "getClassesInPackage", "()Ljava/util/List;", "constructors", "", "Lorg/greenrobot/greendao/codemodifier/Method;", "getConstructors", "createTable", "getCreateTable", "setCreateTable", "entityTableName", "getEntityTableName", "()Ljava/lang/String;", "setEntityTableName", "(Ljava/lang/String;)V", "fieldAnnotations", "Lorg/greenrobot/eclipse/jdt/core/dom/Annotation;", "generateConstructors", "getGenerateConstructors", "setGenerateConstructors", "generateGettersSetters", "getGenerateGettersSetters", "setGenerateGettersSetters", "imports", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "getImports", "isEntity", "setEntity", "getKeepFieldsEndLineNumber", "()I", "getKeepFieldsStartLineNumber", "keepSource", "getKeepSource", "setKeepSource", "lastField", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "getLastField", "()Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "setLastField", "(Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;)V", "legacyTransientFields", "Lorg/greenrobot/greendao/codemodifier/TransientField;", "getLegacyTransientFields", "manyRelations", "Lorg/greenrobot/greendao/codemodifier/ManyRelation;", "getManyRelations", "methodAnnotations", "methods", "getMethods", "oneRelations", "Lorg/greenrobot/greendao/codemodifier/OneRelation;", "getOneRelations", "packageName", "getPackageName", "setPackageName", "properties", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "getProperties", "protobufClassName", "getProtobufClassName", "setProtobufClassName", "schemaName", "getSchemaName", "setSchemaName", "getSource", "staticInnerClasses", "getStaticInnerClasses", "tableIndexes", "Lorg/greenrobot/greendao/codemodifier/TableIndex;", "getTableIndexes", "setTableIndexes", "(Ljava/util/List;)V", "transientFields", "getTransientFields", "typeDeclaration", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "getTypeDeclaration", "()Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "setTypeDeclaration", "(Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;)V", "usedNotNullAnnotation", "getUsedNotNullAnnotation", "setUsedNotNullAnnotation", "codePlace", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;", "getCodePlace", "(Lorg/greenrobot/eclipse/jdt/core/dom/ASTNode;)Ljava/lang/String;", "generatorHint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "getGeneratorHint", "(Ljava/util/List;)Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "hasNotNull", "getHasNotNull", "(Ljava/util/List;)Z", "originalCode", "getOriginalCode", "typeName", "Lorg/greenrobot/eclipse/jdt/core/dom/Type;", "getTypeName", "(Lorg/greenrobot/eclipse/jdt/core/dom/Type;)Ljava/lang/String;", "checkIfInnerTypeThenStatic", "", "typeClassName", "outerClassName", "checkInnerCustomTypes", "createParsedEntity", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "javaFile", "Ljava/io/File;", "endVisit", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "findConvert", "Lorg/greenrobot/greendao/codemodifier/CustomType;", "fieldName", "Lorg/greenrobot/eclipse/jdt/core/dom/SimpleName;", "fa", "manyRelation", "variableType", "Lorg/greenrobot/greendao/codemodifier/VariableType;", "oneRelation", "parseProperty", "visit", "Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnumDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/MarkerAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/NormalAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/PackageDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/SingleMemberAnnotation;", "visitAnnotation", "checkUntouched", "hint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint$Generated;", "has", "A", "hasType", "klass", "Lkotlin/reflect/KClass;", "proxy", "T", "", "(Ljava/util/List;)Ljava/lang/annotation/Annotation;", "toVariableType", "greendao-code-modifier_main"}
)
public final class EntityClassASTVisitor extends LazyVisitor {
   private boolean isEntity;
   @NotNull
   private String schemaName;
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
   private final List imports;
   @NotNull
   private final List staticInnerClasses;
   @Nullable
   private String packageName;
   @Nullable
   private String entityTableName;
   @Nullable
   private TypeDeclaration typeDeclaration;
   @NotNull
   private final List oneRelations;
   @NotNull
   private final List manyRelations;
   @NotNull
   private List tableIndexes;
   private boolean active;
   private boolean keepSource;
   private boolean createTable;
   private boolean generateConstructors;
   private boolean generateGettersSetters;
   @Nullable
   private String protobufClassName;
   @Nullable
   private String usedNotNullAnnotation;
   @Nullable
   private FieldDeclaration lastField;
   private final List methodAnnotations;
   private final List fieldAnnotations;
   @NotNull
   private final String source;
   @NotNull
   private final List classesInPackage;
   private final int keepFieldsStartLineNumber;
   private final int keepFieldsEndLineNumber;

   public final boolean isEntity() {
      return this.isEntity;
   }

   public final void setEntity(boolean var1) {
      this.isEntity = var1;
   }

   @NotNull
   public final String getSchemaName() {
      return this.schemaName;
   }

   public final void setSchemaName(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.schemaName = var1;
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
   public final List getImports() {
      return this.imports;
   }

   @NotNull
   public final List getStaticInnerClasses() {
      return this.staticInnerClasses;
   }

   @Nullable
   public final String getPackageName() {
      return this.packageName;
   }

   public final void setPackageName(@Nullable String var1) {
      this.packageName = var1;
   }

   @Nullable
   public final String getEntityTableName() {
      return this.entityTableName;
   }

   public final void setEntityTableName(@Nullable String var1) {
      this.entityTableName = var1;
   }

   @Nullable
   public final TypeDeclaration getTypeDeclaration() {
      return this.typeDeclaration;
   }

   public final void setTypeDeclaration(@Nullable TypeDeclaration var1) {
      this.typeDeclaration = var1;
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
   public final List getTableIndexes() {
      return this.tableIndexes;
   }

   public final void setTableIndexes(@NotNull List var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.tableIndexes = var1;
   }

   public final boolean getActive() {
      return this.active;
   }

   public final void setActive(boolean var1) {
      this.active = var1;
   }

   public final boolean getKeepSource() {
      return this.keepSource;
   }

   public final void setKeepSource(boolean var1) {
      this.keepSource = var1;
   }

   public final boolean getCreateTable() {
      return this.createTable;
   }

   public final void setCreateTable(boolean var1) {
      this.createTable = var1;
   }

   public final boolean getGenerateConstructors() {
      return this.generateConstructors;
   }

   public final void setGenerateConstructors(boolean var1) {
      this.generateConstructors = var1;
   }

   public final boolean getGenerateGettersSetters() {
      return this.generateGettersSetters;
   }

   public final void setGenerateGettersSetters(boolean var1) {
      this.generateGettersSetters = var1;
   }

   @Nullable
   public final String getProtobufClassName() {
      return this.protobufClassName;
   }

   public final void setProtobufClassName(@Nullable String var1) {
      this.protobufClassName = var1;
   }

   @Nullable
   public final String getUsedNotNullAnnotation() {
      return this.usedNotNullAnnotation;
   }

   public final void setUsedNotNullAnnotation(@Nullable String var1) {
      this.usedNotNullAnnotation = var1;
   }

   @Nullable
   public final FieldDeclaration getLastField() {
      return this.lastField;
   }

   public final void setLastField(@Nullable FieldDeclaration var1) {
      this.lastField = var1;
   }

   public boolean visit(@NotNull CompilationUnit node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return true;
   }

   public boolean visit(@NotNull ImportDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      Collection var2 = (Collection)this.imports;
      var2.add(node);
      return true;
   }

   public boolean visit(@NotNull PackageDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      this.packageName = node.getName().getFullyQualifiedName();
      return true;
   }

   private final boolean hasType(@NotNull Annotation $receiver, KClass klass) {
      return $receiver.getTypeName().isSimpleName() ? Intrinsics.areEqual($receiver.getTypeName().getFullyQualifiedName(), klass.getSimpleName()) && JdtUtilsKt.has((Iterable)this.imports, klass) : Intrinsics.areEqual($receiver.getTypeName().getFullyQualifiedName(), klass.getQualifiedName());
   }

   private final VariableType toVariableType(@NotNull Type $receiver) {
      List arguments = $receiver instanceof ParameterizedType ? SequencesKt.toList(SequencesKt.filterNotNull(SequencesKt.map(CollectionsKt.asSequence((Iterable)((ParameterizedType)$receiver).typeArguments()), (Function1)(new Function1() {
         @Nullable
         public final VariableType invoke(@Nullable Object it) {
            return it instanceof Type ? EntityClassASTVisitor.this.toVariableType((Type)it) : null;
         }
      })))) : null;
      String var10002 = this.getTypeName($receiver);
      boolean var10003 = $receiver.isPrimitiveType();
      String var10004 = $receiver.toString();
      Intrinsics.checkExpressionValueIsNotNull(var10004, "toString()");
      return new VariableType(var10002, var10003, var10004, arguments);
   }

   private final String getTypeName(@NotNull Type $receiver) {
      try {
         String var6;
         label26: {
            TypeDeclaration var10001 = this.typeDeclaration;
            if (var10001 != null) {
               SimpleName var5 = var10001.getName();
               if (var5 != null) {
                  var6 = var5.getIdentifier();
                  break label26;
               }
            }

            var6 = null;
         }

         String var2 = JdtUtilsKt.typeName($receiver, var6, (Iterable)this.imports, this.packageName, this.classesInPackage);
         return var2;
      } catch (IllegalArgumentException var4) {
         RuntimeException var10000;
         StringBuilder var10002;
         String var8;
         label21: {
            var10000 = new RuntimeException;
            var10002 = (new StringBuilder()).append("Error processing ").append("\"");
            TypeDeclaration var10003 = this.typeDeclaration;
            if (var10003 != null) {
               SimpleName var7 = var10003.getName();
               if (var7 != null) {
                  var8 = var7.getIdentifier();
                  break label21;
               }
            }

            var8 = null;
         }

         var10000.<init>(var10002.append(var8).append("\"").append(": ").append(var4.getMessage()).toString(), (Throwable)var4);
         throw (Throwable)var10000;
      }
   }

   public final boolean visitAnnotation(@NotNull Annotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      ASTNode parent = node.getParent();
      if (parent instanceof TypeDeclaration) {
         if (this.hasType(node, Reflection.getOrCreateKotlinClass(Entity.class))) {
            this.isEntity = true;
            AnnotationProxy this_$iv = AnnotationProxy.INSTANCE;
            Object var10000 = this_$iv.invoke(node, Entity.class);
            if (var10000 == null) {
               throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Entity");
            }

            Entity entityAnnotation = (Entity)((Entity)var10000);
            this.schemaName = entityAnnotation.schema();
            this.active = entityAnnotation.active();
            this.entityTableName = FunsKt.nullIfBlank(entityAnnotation.nameInDb());
            this.createTable = entityAnnotation.createInDb();
            this.generateConstructors = entityAnnotation.generateConstructors();
            this.generateGettersSetters = entityAnnotation.generateGettersSetters();
            if (node instanceof NormalAnnotation) {
               Expression var10001 = JdtUtilsKt.get((NormalAnnotation)node, "protobuf");
               if (!(var10001 instanceof TypeLiteral)) {
                  var10001 = null;
               }

               String var22;
               label57: {
                  TypeLiteral var20 = (TypeLiteral)var10001;
                  if ((TypeLiteral)var10001 != null) {
                     Type var21 = var20.getType();
                     if (var21 != null) {
                        var22 = this.getTypeName(var21);
                        if (var22 != null) {
                           var22 = FunsKt.nullIfBlank(var22);
                           break label57;
                        }
                     }
                  }

                  var22 = null;
               }

               this.protobufClassName = var22;
               if (this.protobufClassName != null && this.entityTableName == null) {
                  throw (Throwable)(new RuntimeException("Set nameInDb in the " + ((TypeDeclaration)parent).getName() + " @Entity annotation. " + "An explicit table name is required when specifying a protobuf class."));
               }
            }

            try {
               Object[] $receiver$iv = (Object[])entityAnnotation.indexes();
               Object[] $receiver$iv$iv = $receiver$iv;
               Collection destination$iv$iv = (Collection)(new ArrayList($receiver$iv.length));

               for(int var8 = 0; var8 < $receiver$iv$iv.length; ++var8) {
                  Object item$iv$iv = $receiver$iv$iv[var8];
                  Index it = (Index)item$iv$iv;
                  TableIndex var16 = new TableIndex(FunsKt.nullIfBlank(it.name()), FunsKt.parseIndexSpec(it.value()), it.unique());
                  destination$iv$iv.add(var16);
               }

               List var15 = (List)destination$iv$iv;
               this.tableIndexes = var15;
            } catch (IllegalArgumentException var17) {
               throw (Throwable)(new RuntimeException("Can't parse @Index.value for " + ((TypeDeclaration)parent).getName() + " " + "because of: " + var17.getMessage(), (Throwable)var17));
            }
         } else if (this.hasType(node, Reflection.getOrCreateKotlinClass(Keep.class))) {
            this.keepSource = true;
         }
      } else {
         Collection var18;
         if (parent instanceof MethodDeclaration) {
            var18 = (Collection)this.methodAnnotations;
            var18.add(node);
         } else if (parent instanceof FieldDeclaration) {
            var18 = (Collection)this.fieldAnnotations;
            var18.add(node);
         }
      }

      return true;
   }

   public boolean visit(@NotNull MarkerAnnotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return this.visitAnnotation((Annotation)node);
   }

   public boolean visit(@NotNull SingleMemberAnnotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return this.visitAnnotation((Annotation)node);
   }

   public boolean visit(@NotNull NormalAnnotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return this.visitAnnotation((Annotation)node);
   }

   public boolean visit(@NotNull FieldDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return this.isEntity;
   }

   public void endVisit(@NotNull FieldDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      Iterable $receiver$iv = (Iterable)node.fragments();
      Collection destination$iv$iv = (Collection)(new ArrayList());
      Iterator var6 = $receiver$iv.iterator();

      Object item$iv$iv;
      while(var6.hasNext()) {
         item$iv$iv = var6.next();
         if (item$iv$iv instanceof VariableDeclarationFragment) {
            destination$iv$iv.add(item$iv$iv);
         }
      }

      $receiver$iv = (Iterable)((List)destination$iv$iv);
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      var6 = $receiver$iv.iterator();

      while(var6.hasNext()) {
         item$iv$iv = var6.next();
         if (item$iv$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.VariableDeclarationFragment");
         }

         VariableDeclarationFragment var19 = (VariableDeclarationFragment)item$iv$iv;
         destination$iv$iv.add(var19);
      }

      $receiver$iv = (Iterable)((List)destination$iv$iv);
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      var6 = $receiver$iv.iterator();

      while(var6.hasNext()) {
         item$iv$iv = var6.next();
         VariableDeclarationFragment it = (VariableDeclarationFragment)item$iv$iv;
         SimpleName var46 = it.getName();
         destination$iv$iv.add(var46);
      }

      List variableNames = (List)destination$iv$iv;
      VariableType variableType = this.toVariableType(node.getType());
      Integer lineNumber = JdtUtilsKt.getLineNumber((ASTNode)node);
      boolean isInLegacyKeepSection = lineNumber != null && lineNumber.intValue() > this.keepFieldsStartLineNumber && lineNumber.intValue() < this.keepFieldsEndLineNumber;
      List annotations = this.fieldAnnotations;
      Iterable $receiver$iv = (Iterable)annotations;
      Iterator var24 = $receiver$iv.iterator();

      boolean var10000;
      while(true) {
         if (var24.hasNext()) {
            Object element$iv = var24.next();
            Annotation it = (Annotation)element$iv;
            if (!Intrinsics.areEqual(it.getTypeName().getFullyQualifiedName(), "Transient")) {
               continue;
            }

            var10000 = true;
            break;
         }

         var10000 = false;
         break;
      }

      String var10005;
      Iterable $receiver$iv$iv;
      TransientField var47;
      if (!var10000 && !Modifier.isTransient(node.getModifiers()) && !Modifier.isStatic(node.getModifiers())) {
         Collection var26;
         Iterable $receiver$iv;
         Collection destination$iv$iv;
         Iterator var35;
         Object item$iv$iv;
         SimpleName it;
         if (isInLegacyKeepSection) {
            var26 = (Collection)this.legacyTransientFields;
            $receiver$iv = (Iterable)variableNames;
            destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
            var35 = $receiver$iv.iterator();

            while(var35.hasNext()) {
               item$iv$iv = var35.next();
               it = (SimpleName)item$iv$iv;
               var10005 = it.toString();
               Intrinsics.checkExpressionValueIsNotNull(var10005, "it.toString()");
               var47 = new TransientField(new Variable(variableType, var10005), node, (GeneratorHint)null);
               destination$iv$iv.add(var47);
            }

            $receiver$iv = (Iterable)((List)destination$iv$iv);
            CollectionsKt.addAll(var26, $receiver$iv);
            System.err.println("Field " + variableNames + " in " + this.getCodePlace((ASTNode)node) + " will be annotated with @Transient, " + "you can remove the KEEP FIELDS comments.");
         } else {
            EntityClassASTVisitor this_$iv = this;
            $receiver$iv$iv = (Iterable)annotations;
            Iterator var32 = $receiver$iv$iv.iterator();

            Object element$iv$iv;
            Annotation it$iv;
            while(true) {
               if (!var32.hasNext()) {
                  var10000 = false;
                  break;
               }

               element$iv$iv = var32.next();
               it$iv = (Annotation)element$iv$iv;
               if (access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(ToOne.class))) {
                  var10000 = true;
                  break;
               }
            }

            if (var10000) {
               var26 = (Collection)this.oneRelations;
               $receiver$iv = (Iterable)variableNames;
               destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
               var35 = $receiver$iv.iterator();

               while(var35.hasNext()) {
                  item$iv$iv = var35.next();
                  it = (SimpleName)item$iv$iv;
                  Intrinsics.checkExpressionValueIsNotNull(it, "it");
                  OneRelation var49 = this.oneRelation(annotations, it, variableType);
                  destination$iv$iv.add(var49);
               }

               $receiver$iv = (Iterable)((List)destination$iv$iv);
               CollectionsKt.addAll(var26, $receiver$iv);
            } else {
               this_$iv = this;
               $receiver$iv$iv = (Iterable)annotations;
               var32 = $receiver$iv$iv.iterator();

               while(true) {
                  if (!var32.hasNext()) {
                     var10000 = false;
                     break;
                  }

                  element$iv$iv = var32.next();
                  it$iv = (Annotation)element$iv$iv;
                  if (access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(ToMany.class))) {
                     var10000 = true;
                     break;
                  }
               }

               if (var10000) {
                  var26 = (Collection)this.manyRelations;
                  $receiver$iv = (Iterable)variableNames;
                  destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
                  var35 = $receiver$iv.iterator();

                  while(var35.hasNext()) {
                     item$iv$iv = var35.next();
                     it = (SimpleName)item$iv$iv;
                     Intrinsics.checkExpressionValueIsNotNull(it, "it");
                     ManyRelation var50 = this.manyRelation(annotations, it, variableType);
                     destination$iv$iv.add(var50);
                  }

                  $receiver$iv = (Iterable)((List)destination$iv$iv);
                  CollectionsKt.addAll(var26, $receiver$iv);
               } else {
                  var26 = (Collection)this.properties;
                  $receiver$iv = (Iterable)variableNames;
                  destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
                  var35 = $receiver$iv.iterator();

                  while(var35.hasNext()) {
                     item$iv$iv = var35.next();
                     it = (SimpleName)item$iv$iv;
                     Intrinsics.checkExpressionValueIsNotNull(it, "it");
                     ParsedProperty var51 = this.parseProperty(annotations, it, node, variableType);
                     destination$iv$iv.add(var51);
                  }

                  $receiver$iv = (Iterable)((List)destination$iv$iv);
                  CollectionsKt.addAll(var26, $receiver$iv);
               }
            }
         }
      } else {
         GeneratorHint generatorHint = this.getGeneratorHint(annotations);
         if (generatorHint != null && generatorHint instanceof GeneratorHint.Generated) {
            this.checkUntouched((ASTNode)node, (GeneratorHint.Generated)generatorHint);
         }

         Collection var27 = (Collection)this.transientFields;
         $receiver$iv$iv = (Iterable)variableNames;
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv$iv, 10)));
         Iterator var12 = $receiver$iv$iv.iterator();

         while(var12.hasNext()) {
            Object item$iv$iv = var12.next();
            SimpleName it = (SimpleName)item$iv$iv;
            var10005 = it.toString();
            Intrinsics.checkExpressionValueIsNotNull(var10005, "it.toString()");
            var47 = new TransientField(new Variable(variableType, var10005), node, generatorHint);
            destination$iv$iv.add(var47);
         }

         $receiver$iv$iv = (Iterable)((List)destination$iv$iv);
         CollectionsKt.addAll(var27, $receiver$iv$iv);
      }

      if (this.usedNotNullAnnotation == null) {
         $receiver$iv = (Iterable)annotations;
         Iterator var33 = $receiver$iv.iterator();

         Object var45;
         while(true) {
            if (!var33.hasNext()) {
               var45 = null;
               break;
            }

            Object var39 = var33.next();
            Annotation it = (Annotation)var39;
            if (Intrinsics.areEqual(it.getTypeName().getFullyQualifiedName(), "NotNull") || Intrinsics.areEqual(it.getTypeName().getFullyQualifiedName(), "NonNull")) {
               var45 = var39;
               break;
            }
         }

         String var44;
         EntityClassASTVisitor var48;
         label97: {
            Object var52 = var45;
            var48 = this;
            Annotation var10001 = (Annotation)var52;
            if ((Annotation)var52 != null) {
               Name var43 = var10001.getTypeName();
               if (var43 != null) {
                  var44 = var43.getFullyQualifiedName();
                  if (var44 != null) {
                     String var34 = var44;
                     String it = (String)var34;
                     String var53 = "@" + it;
                     var48 = this;
                     var44 = (String)var53;
                     break label97;
                  }
               }
            }

            var44 = null;
         }

         var48.usedNotNullAnnotation = var44;
      }

      annotations.clear();
      this.lastField = node;
   }

   private final String getCodePlace(@NotNull ASTNode $receiver) {
      StringBuilder var10000 = new StringBuilder();
      TypeDeclaration var10001 = this.typeDeclaration;
      String var3;
      if (var10001 != null) {
         SimpleName var2 = var10001.getName();
         if (var2 != null) {
            var3 = var2.getIdentifier();
            return var10000.append(var3).append(":").append(JdtUtilsKt.getLineNumber($receiver)).toString();
         }
      }

      var3 = null;
      return var10000.append(var3).append(":").append(JdtUtilsKt.getLineNumber($receiver)).toString();
   }

   private final String getOriginalCode(@NotNull ASTNode $receiver) {
      return StringsKt.substring(this.source, new IntRange($receiver.getStartPosition(), $receiver.getStartPosition() + $receiver.getLength() - 1));
   }

   private final void checkUntouched(@NotNull ASTNode $receiver, GeneratorHint.Generated hint) {
      if (hint.getHash() != -1 && hint.getHash() != CodeCompare.INSTANCE.codeHash(this.getOriginalCode($receiver))) {
         String var10000;
         if ($receiver instanceof MethodDeclaration) {
            var10000 = ((MethodDeclaration)$receiver).isConstructor() ? "Constructor" : "Method '" + ((MethodDeclaration)$receiver).getName() + "'";
         } else if ($receiver instanceof FieldDeclaration) {
            StringBuilder var8 = (new StringBuilder()).append("Field '");
            String var5 = this.getOriginalCode($receiver);
            StringBuilder var6 = var8;
            if (var5 == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }

            String var7 = StringsKt.trim((CharSequence)var5).toString();
            var10000 = var6.append(var7).append("'").toString();
         } else {
            var10000 = "Node";
         }

         String place = var10000;
         throw (Throwable)(new RuntimeException(StringsKt.trimIndent("\n" + "                        " + place + " (see " + this.getCodePlace($receiver) + ") has been changed after generation." + "\n" + "                        Please either mark it with @Keep annotation instead of @Generated to keep it untouched," + "\n" + "                        or use @Generated (without hash) to allow to replace it." + "\n" + "                        ")));
      }
   }

   private final GeneratorHint getGeneratorHint(@NotNull List $receiver) {
      EntityClassASTVisitor this_$iv = this;
      Iterable $receiver$iv$iv = (Iterable)$receiver;
      Iterator var5 = $receiver$iv$iv.iterator();

      boolean var10000;
      while(true) {
         if (var5.hasNext()) {
            Object element$iv$iv = var5.next();
            Annotation it$iv = (Annotation)element$iv$iv;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Keep.class))) {
               continue;
            }

            var10000 = true;
            break;
         }

         var10000 = false;
         break;
      }

      GeneratorHint var17;
      if (var10000) {
         var17 = (GeneratorHint)GeneratorHint.Keep.INSTANCE;
      } else {
         this_$iv = this;
         $receiver$iv$iv = (Iterable)$receiver;
         Iterator var14 = $receiver$iv$iv.iterator();

         Object var18;
         while(true) {
            if (!var14.hasNext()) {
               var18 = null;
               break;
            }

            Object var16 = var14.next();
            Annotation it$iv = (Annotation)var16;
            if (access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Generated.class))) {
               var18 = var16;
               break;
            }
         }

         Annotation var19 = (Annotation)var18;
         java.lang.annotation.Annotation var20;
         if (var19 != null) {
            Annotation var12 = var19;
            Annotation it$iv = (Annotation)var12;
            AnnotationProxy this_$iv$iv = AnnotationProxy.INSTANCE;
            var18 = this_$iv$iv.invoke(it$iv, Generated.class);
            if (var18 == null) {
               throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Generated");
            }

            var20 = (java.lang.annotation.Annotation)((Generated)var18);
         } else {
            var20 = null;
         }

         Generated var21 = (Generated)var20;
         GeneratorHint.Generated var22;
         if (var21 != null) {
            Generated var11 = var21;
            Generated it = (Generated)var11;
            var22 = (GeneratorHint.Generated)(new GeneratorHint.Generated(it.hash()));
         } else {
            var22 = null;
         }

         var17 = (GeneratorHint)var22;
      }

      return var17;
   }

   private final boolean getHasNotNull(@NotNull List $receiver) {
      Iterable $receiver$iv = (Iterable)$receiver;
      Iterator var3 = $receiver$iv.iterator();

      boolean var10000;
      while(true) {
         if (!var3.hasNext()) {
            var10000 = false;
            break;
         }

         Object element$iv = var3.next();
         Annotation it = (Annotation)element$iv;
         if (Intrinsics.areEqual(it.getTypeName().getFullyQualifiedName(), "NotNull") || Intrinsics.areEqual(it.getTypeName().getFullyQualifiedName(), "NonNull")) {
            var10000 = true;
            break;
         }
      }

      return var10000;
   }

   private final boolean has(@NotNull List $receiver) {
      Iterable $receiver$iv = (Iterable)$receiver;
      Iterator var4 = $receiver$iv.iterator();

      boolean var10000;
      while(true) {
         if (var4.hasNext()) {
            Object element$iv = var4.next();
            Annotation it = (Annotation)element$iv;
            Intrinsics.reifiedOperationMarker(4, "A");
            if (!access$hasType(this, it, Reflection.getOrCreateKotlinClass(Object.class))) {
               continue;
            }

            var10000 = true;
            break;
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   private final java.lang.annotation.Annotation proxy(@NotNull List $receiver) {
      Iterable var3 = (Iterable)$receiver;
      Iterator var5 = var3.iterator();

      Object var10000;
      while(true) {
         if (var5.hasNext()) {
            Object var6 = var5.next();
            Annotation it = (Annotation)var6;
            Intrinsics.reifiedOperationMarker(4, "T");
            if (!access$hasType(this, it, Reflection.getOrCreateKotlinClass(java.lang.annotation.Annotation.class))) {
               continue;
            }

            var10000 = var6;
            break;
         }

         var10000 = null;
         break;
      }

      Annotation var11 = (Annotation)var10000;
      java.lang.annotation.Annotation var12;
      if (var11 != null) {
         Annotation var9 = var11;
         Annotation it = (Annotation)var9;
         AnnotationProxy this_$iv = AnnotationProxy.INSTANCE;
         Intrinsics.reifiedOperationMarker(4, "T");
         var10000 = this_$iv.invoke(it, java.lang.annotation.Annotation.class);
         Intrinsics.reifiedOperationMarker(1, "T");
         var12 = (java.lang.annotation.Annotation)((java.lang.annotation.Annotation)var10000);
      } else {
         var12 = null;
      }

      return var12;
   }

   private final OneRelation oneRelation(List fa, SimpleName fieldName, VariableType variableType) {
      EntityClassASTVisitor this_$iv = this;
      Iterable $receiver$iv$iv = (Iterable)fa;
      Iterator var9 = $receiver$iv$iv.iterator();

      Object var10;
      Annotation it$iv;
      Object var10000;
      while(true) {
         if (var9.hasNext()) {
            var10 = var9.next();
            it$iv = (Annotation)var10;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(ToOne.class))) {
               continue;
            }

            var10000 = var10;
            break;
         }

         var10000 = null;
         break;
      }

      Annotation var26 = (Annotation)var10000;
      Annotation it$iv;
      Annotation var21;
      AnnotationProxy this_$iv$iv;
      java.lang.annotation.Annotation var27;
      if (var26 != null) {
         var21 = var26;
         it$iv = (Annotation)var21;
         this_$iv$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv$iv.invoke(it$iv, ToOne.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.ToOne");
         }

         var27 = (java.lang.annotation.Annotation)((ToOne)var10000);
      } else {
         var27 = null;
      }

      if (var27 == null) {
         Intrinsics.throwNpe();
      }

      ToOne proxy = (ToOne)var27;
      OneRelation var29 = new OneRelation;
      String var10005 = fieldName.toString();
      Intrinsics.checkExpressionValueIsNotNull(var10005, "fieldName.toString()");
      Variable var10002 = new Variable(variableType, var10005);
      String var10003 = FunsKt.nullIfBlank(proxy.joinProperty());
      this_$iv = this;
      String var17 = var10003;
      Variable var16 = var10002;
      OneRelation var15 = var29;
      OneRelation var14 = var29;
      $receiver$iv$iv = (Iterable)fa;
      var9 = $receiver$iv$iv.iterator();

      while(true) {
         if (var9.hasNext()) {
            var10 = var9.next();
            it$iv = (Annotation)var10;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Property.class))) {
               continue;
            }

            var10000 = var10;
            break;
         }

         var10000 = null;
         break;
      }

      var26 = (Annotation)var10000;
      if (var26 != null) {
         var21 = var26;
         it$iv = (Annotation)var21;
         this_$iv$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv$iv.invoke(it$iv, Property.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Property");
         }

         var27 = (java.lang.annotation.Annotation)((Property)var10000);
      } else {
         var27 = null;
      }

      String var30;
      label59: {
         java.lang.annotation.Annotation var18 = var27;
         Property var10004 = (Property)var18;
         if ((Property)var18 != null) {
            var30 = var10004.nameInDb();
            if (var30 != null) {
               var30 = FunsKt.nullIfBlank(var30);
               break label59;
            }
         }

         var30 = null;
      }

      boolean var31 = this.getHasNotNull(fa);
      this_$iv = this;
      boolean var19 = var31;
      String var28 = var30;
      $receiver$iv$iv = (Iterable)fa;
      Iterator var22 = $receiver$iv$iv.iterator();

      boolean var32;
      while(true) {
         if (var22.hasNext()) {
            Object element$iv$iv = var22.next();
            Annotation it$iv = (Annotation)element$iv$iv;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Unique.class))) {
               continue;
            }

            var32 = true;
            break;
         }

         var32 = false;
         break;
      }

      boolean var20 = var32;
      var15.<init>(var16, var17, var28, var19, var20);
      return var14;
   }

   private final ManyRelation manyRelation(List fa, SimpleName fieldName, VariableType variableType) {
      EntityClassASTVisitor this_$iv = this;
      Iterable var7 = (Iterable)fa;
      Iterator var9 = var7.iterator();

      Object var10000;
      while(true) {
         if (var9.hasNext()) {
            Object var10 = var9.next();
            Annotation it$iv = (Annotation)var10;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(ToMany.class))) {
               continue;
            }

            var10000 = var10;
            break;
         }

         var10000 = null;
         break;
      }

      Annotation var47 = (Annotation)var10000;
      AnnotationProxy this_$iv;
      java.lang.annotation.Annotation var48;
      if ((Annotation)var10000 != null) {
         Annotation var26 = var47;
         Annotation it$iv = (Annotation)var26;
         this_$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv.invoke(it$iv, ToMany.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.ToMany");
         }

         var48 = (java.lang.annotation.Annotation)((ToMany)var10000);
      } else {
         var48 = null;
      }

      if (var48 == null) {
         Intrinsics.throwNpe();
      }

      ToMany proxy = (ToMany)var48;
      Iterable var6 = (Iterable)fa;
      Iterator var29 = var6.iterator();

      Annotation it$iv;
      while(true) {
         if (var29.hasNext()) {
            Object var34 = var29.next();
            it$iv = (Annotation)var34;
            if (!this.hasType(it$iv, Reflection.getOrCreateKotlinClass(JoinEntity.class))) {
               continue;
            }

            var10000 = var34;
            break;
         }

         var10000 = null;
         break;
      }

      if (!(var10000 instanceof NormalAnnotation)) {
         var10000 = null;
      }

      NormalAnnotation joinEntityAnnotation = (NormalAnnotation)var10000;
      EntityClassASTVisitor this_$iv = this;
      Iterable var35 = (Iterable)fa;
      Iterator var40 = var35.iterator();

      while(true) {
         if (var40.hasNext()) {
            Object var12 = var40.next();
            Annotation it$iv = (Annotation)var12;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(OrderBy.class))) {
               continue;
            }

            var10000 = var12;
            break;
         }

         var10000 = null;
         break;
      }

      var47 = (Annotation)var10000;
      if ((Annotation)var10000 != null) {
         Annotation var37 = var47;
         it$iv = (Annotation)var37;
         AnnotationProxy this_$iv$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv$iv.invoke(it$iv, OrderBy.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.OrderBy");
         }

         var48 = (java.lang.annotation.Annotation)((OrderBy)var10000);
      } else {
         var48 = null;
      }

      OrderBy orderByAnnotation = (OrderBy)var48;
      ManyRelation var55 = new ManyRelation;
      String var10005 = fieldName.toString();
      Intrinsics.checkExpressionValueIsNotNull(var10005, "fieldName.toString()");
      Variable var10002 = new Variable(variableType, var10005);
      String var10003 = FunsKt.nullIfBlank(proxy.referencedJoinProperty());
      Object[] $receiver$iv = (Object[])proxy.joinProperties();
      String var19 = var10003;
      Variable var18 = var10002;
      ManyRelation var17 = var55;
      ManyRelation var16 = var55;
      Object[] $receiver$iv$iv = $receiver$iv;
      Collection destination$iv$iv = (Collection)(new ArrayList($receiver$iv.length));

      for(int var39 = 0; var39 < $receiver$iv$iv.length; ++var39) {
         Object item$iv$iv = $receiver$iv$iv[var39];
         JoinProperty it = (JoinProperty)item$iv$iv;
         JoinOnProperty var21 = new JoinOnProperty(it.name(), it.referencedName());
         destination$iv$iv.add(var21);
      }

      List var20 = (List)destination$iv$iv;
      var55 = var16;
      ManyRelation var10001 = var17;
      var10002 = var18;
      var10003 = var19;
      List var10004 = var20;
      JoinEntitySpec var53;
      JoinEntitySpec var54;
      if (joinEntityAnnotation != null) {
         NormalAnnotation it = (NormalAnnotation)joinEntityAnnotation;
         this_$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv.invoke((Annotation)it, JoinEntity.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.JoinEntity");
         }

         JoinEntity joinProxy = (JoinEntity)((JoinEntity)var10000);
         JoinEntitySpec var56 = new JoinEntitySpec;
         Expression var50 = JdtUtilsKt.get(it, "entity");
         if (var50 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.TypeLiteral");
         }

         var56.<init>(this.getTypeName(((TypeLiteral)var50).getType()), joinProxy.sourceProperty(), joinProxy.targetProperty());
         var54 = var56;
         var55 = var16;
         var10001 = var17;
         var10002 = var18;
         var10003 = var19;
         var10004 = var20;
         var53 = (JoinEntitySpec)var54;
      } else {
         var53 = null;
      }

      List var10006;
      if (orderByAnnotation != null) {
         var54 = var53;
         var20 = var10004;
         var19 = var10003;
         var18 = var10002;
         var17 = var10001;
         var16 = var55;
         OrderBy it = (OrderBy)orderByAnnotation;
         String spec = it.value();
         List var57;
         if (StringsKt.isBlank((CharSequence)spec)) {
            var57 = CollectionsKt.emptyList();
         } else {
            List var45;
            try {
               var45 = FunsKt.parseIndexSpec(spec);
            } catch (IllegalArgumentException var23) {
               StringBuilder var49 = (new StringBuilder()).append("Can't parse @OrderBy.value for ");
               StringBuilder var51 = new StringBuilder();
               TypeDeclaration var52 = this.typeDeclaration;
               throw (Throwable)(new RuntimeException(var49.append(var51.append(var52 != null ? var52.getName() : null).append(".").append(fieldName).append(" because of: ").append(var23.getMessage()).append(".").toString()).toString(), (Throwable)var23));
            }

            var57 = var45;
         }

         List var22 = var57;
         var55 = var16;
         var10001 = var17;
         var10002 = var18;
         var10003 = var19;
         var10004 = var20;
         var53 = var54;
         var10006 = (List)var22;
      } else {
         var10006 = null;
      }

      var10001.<init>(var10002, var10003, var10004, var53, var10006);
      return var55;
   }

   private final ParsedProperty parseProperty(List fa, SimpleName fieldName, FieldDeclaration node, VariableType variableType) {
      EntityClassASTVisitor this_$iv = this;
      Iterable var8 = (Iterable)fa;
      Iterator var10 = var8.iterator();

      Object var10000;
      while(true) {
         if (var10.hasNext()) {
            Object var11 = var10.next();
            Annotation it$iv = (Annotation)var11;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Property.class))) {
               continue;
            }

            var10000 = var11;
            break;
         }

         var10000 = null;
         break;
      }

      Annotation var50 = (Annotation)var10000;
      Annotation it$iv;
      java.lang.annotation.Annotation var51;
      if (var50 != null) {
         Annotation var29 = var50;
         it$iv = (Annotation)var29;
         AnnotationProxy this_$iv$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv$iv.invoke(it$iv, Property.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Property");
         }

         var51 = (java.lang.annotation.Annotation)((Property)var10000);
      } else {
         var51 = null;
      }

      Property columnAnnotation = (Property)var51;
      EntityClassASTVisitor this_$iv = this;
      Iterable var32 = (Iterable)fa;
      Iterator var39 = var32.iterator();

      while(true) {
         if (var39.hasNext()) {
            Object var44 = var39.next();
            Annotation it$iv = (Annotation)var44;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Index.class))) {
               continue;
            }

            var10000 = var44;
            break;
         }

         var10000 = null;
         break;
      }

      var50 = (Annotation)var10000;
      Annotation it$iv;
      if (var50 != null) {
         it$iv = var50;
         it$iv = (Annotation)it$iv;
         AnnotationProxy this_$iv$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv$iv.invoke(it$iv, Index.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Index");
         }

         var51 = (java.lang.annotation.Annotation)((Index)var10000);
      } else {
         var51 = null;
      }

      Index indexAnnotation = (Index)var51;
      EntityClassASTVisitor this_$iv = this;
      Iterable var38 = (Iterable)fa;
      Iterator var47 = var38.iterator();

      Annotation it$iv;
      Object element$iv$iv;
      while(true) {
         if (var47.hasNext()) {
            element$iv$iv = var47.next();
            it$iv = (Annotation)element$iv$iv;
            if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Id.class))) {
               continue;
            }

            var10000 = element$iv$iv;
            break;
         }

         var10000 = null;
         break;
      }

      var50 = (Annotation)var10000;
      if (var50 != null) {
         it$iv = var50;
         Annotation it$iv = (Annotation)it$iv;
         AnnotationProxy this_$iv$iv = AnnotationProxy.INSTANCE;
         var10000 = this_$iv$iv.invoke(it$iv, Id.class);
         if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.greendao.annotation.Id");
         }

         var51 = (java.lang.annotation.Annotation)((Id)var10000);
      } else {
         var51 = null;
      }

      Id idAnnotation;
      boolean var58;
      label115: {
         idAnnotation = (Id)var51;
         if (indexAnnotation != null) {
            String var57 = indexAnnotation.value();
            if (var57 != null) {
               CharSequence var31 = (CharSequence)var57;
               var58 = !StringsKt.isBlank(var31);
               break label115;
            }
         }

         var58 = false;
      }

      if (var58) {
         StringBuilder var52;
         String var56;
         RuntimeException var60;
         label89: {
            var60 = new RuntimeException;
            var52 = (new StringBuilder()).append("greenDAO: setting value on @Index is not supported if @Index is used on the properties").append("\n").append("                See '").append(fieldName).append("' in ");
            TypeDeclaration var53 = this.typeDeclaration;
            if (var53 != null) {
               SimpleName var55 = var53.getName();
               if (var55 != null) {
                  var56 = var55.getIdentifier();
                  break label89;
               }
            }

            var56 = null;
         }

         var60.<init>(var52.append(var56).toString());
         throw (Throwable)var60;
      } else {
         CustomType customType = this.findConvert(fieldName, fa);
         ParsedProperty var59 = new ParsedProperty;
         ParsedProperty var10001 = var59;
         String var10005 = fieldName.toString();
         Intrinsics.checkExpressionValueIsNotNull(var10005, "fieldName.toString()");
         Variable var10002 = new Variable(variableType, var10005);
         ParsedProperty var18;
         ParsedProperty var19;
         EntityIdParams var10003;
         Variable var20;
         EntityIdParams var21;
         if (idAnnotation != null) {
            var20 = var10002;
            var19 = var59;
            var18 = var59;
            Id it = (Id)idAnnotation;
            var21 = new EntityIdParams(it.autoincrement());
            var59 = var18;
            var10001 = var19;
            var10002 = var20;
            var10003 = (EntityIdParams)var21;
         } else {
            var10003 = null;
         }

         PropertyIndex var10004;
         PropertyIndex var22;
         if (indexAnnotation != null) {
            var21 = var10003;
            var20 = var10002;
            var19 = var10001;
            var18 = var59;
            Index it = (Index)indexAnnotation;
            var22 = new PropertyIndex(FunsKt.nullIfBlank(indexAnnotation.name()), indexAnnotation.unique());
            var59 = var18;
            var10001 = var19;
            var10002 = var20;
            var10003 = var21;
            var10004 = (PropertyIndex)var22;
         } else {
            var10004 = null;
         }

         String var10006;
         boolean var23;
         String var24;
         boolean var54;
         label102: {
            var54 = node.getType().isPrimitiveType() || this.getHasNotNull(fa);
            if (columnAnnotation != null) {
               var10006 = columnAnnotation.nameInDb();
               if (var10006 != null) {
                  String var34 = var10006;
                  var23 = var54;
                  var22 = var10004;
                  var21 = var10003;
                  var20 = var10002;
                  var19 = var10001;
                  var18 = var59;
                  String it = (String)var34;
                  var24 = FunsKt.nullIfBlank(it);
                  var59 = var18;
                  var10001 = var19;
                  var10002 = var20;
                  var10003 = var21;
                  var10004 = var22;
                  var54 = var23;
                  var10006 = (String)var24;
                  break label102;
               }
            }

            var10006 = null;
         }

         EntityClassASTVisitor this_$iv = this;
         var24 = var10006;
         var23 = var54;
         var22 = var10004;
         var21 = var10003;
         var20 = var10002;
         var19 = var10001;
         var18 = var59;
         Iterable $receiver$iv$iv = (Iterable)fa;
         var47 = $receiver$iv$iv.iterator();

         while(true) {
            if (var47.hasNext()) {
               element$iv$iv = var47.next();
               it$iv = (Annotation)element$iv$iv;
               if (!access$hasType(this_$iv, it$iv, Reflection.getOrCreateKotlinClass(Unique.class))) {
                  continue;
               }

               var58 = true;
               break;
            }

            var58 = false;
            break;
         }

         boolean var26 = var58;
         var19.<init>(var20, var21, var22, var23, var24, customType, var26);
         return var18;
      }
   }

   private final CustomType findConvert(SimpleName fieldName, List fa) {
      Iterable var4 = (Iterable)fa;
      Iterator var6 = var4.iterator();

      Object var10000;
      while(true) {
         if (var6.hasNext()) {
            Object var7 = var6.next();
            Annotation it = (Annotation)var7;
            if (!this.hasType(it, Reflection.getOrCreateKotlinClass(Convert.class))) {
               continue;
            }

            var10000 = var7;
            break;
         }

         var10000 = null;
         break;
      }

      Annotation convert = (Annotation)var10000;
      if (!(convert instanceof NormalAnnotation)) {
         return null;
      } else {
         Expression var11 = JdtUtilsKt.get((NormalAnnotation)convert, "converter");
         if (!(var11 instanceof TypeLiteral)) {
            var11 = null;
         }

         String var14;
         label47: {
            TypeLiteral var12 = (TypeLiteral)var11;
            if (var12 != null) {
               Type var13 = var12.getType();
               if (var13 != null) {
                  var14 = this.getTypeName(var13);
                  break label47;
               }
            }

            var14 = null;
         }

         String converterClassName = var14;
         var11 = JdtUtilsKt.get((NormalAnnotation)convert, "columnType");
         if (!(var11 instanceof TypeLiteral)) {
            var11 = null;
         }

         Type columnType = (TypeLiteral)var11 != null ? ((TypeLiteral)var11).getType() : null;
         if (converterClassName != null && columnType != null) {
            return new CustomType(converterClassName, this.toVariableType(columnType));
         } else {
            String var16;
            RuntimeException var17;
            StringBuilder var10002;
            label39: {
               var17 = new RuntimeException;
               var10002 = (new StringBuilder()).append("Missing @Convert arguments for field '").append(fieldName).append("' in ");
               TypeDeclaration var10003 = this.typeDeclaration;
               if (var10003 != null) {
                  SimpleName var15 = var10003.getName();
                  if (var15 != null) {
                     var16 = var15.getIdentifier();
                     break label39;
                  }
               }

               var16 = null;
            }

            var17.<init>(var10002.append(var16).toString());
            throw (Throwable)var17;
         }
      }
   }

   public boolean visit(@NotNull MethodDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return this.isEntity;
   }

   public void endVisit(@NotNull MethodDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      GeneratorHint generatorHint = this.getGeneratorHint(this.methodAnnotations);
      if (generatorHint instanceof GeneratorHint.Generated) {
         this.checkUntouched((ASTNode)node, (GeneratorHint.Generated)generatorHint);
      }

      Method var10000 = new Method;
      String var10002 = node.getName().getFullyQualifiedName();
      Intrinsics.checkExpressionValueIsNotNull(var10002, "node.name.fullyQualifiedName");
      Iterable $receiver$iv = (Iterable)node.parameters();
      String var15 = var10002;
      Method var14 = var10000;
      Method var13 = var10000;
      Collection destination$iv$iv = (Collection)(new ArrayList());
      Iterator var7 = $receiver$iv.iterator();

      Object item$iv$iv;
      while(var7.hasNext()) {
         item$iv$iv = var7.next();
         if (item$iv$iv instanceof SingleVariableDeclaration) {
            destination$iv$iv.add(item$iv$iv);
         }
      }

      List var16 = (List)destination$iv$iv;
      $receiver$iv = (Iterable)var16;
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      var7 = $receiver$iv.iterator();

      while(var7.hasNext()) {
         item$iv$iv = var7.next();
         if (item$iv$iv == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.SingleVariableDeclaration");
         }

         SingleVariableDeclaration var17 = (SingleVariableDeclaration)item$iv$iv;
         destination$iv$iv.add(var17);
      }

      var16 = (List)destination$iv$iv;
      $receiver$iv = (Iterable)var16;
      destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
      var7 = $receiver$iv.iterator();

      while(var7.hasNext()) {
         item$iv$iv = var7.next();
         SingleVariableDeclaration it = (SingleVariableDeclaration)item$iv$iv;
         VariableType var20 = this.toVariableType(it.getType());
         String var10003 = it.getName().getIdentifier();
         Intrinsics.checkExpressionValueIsNotNull(var10003, "it.name.identifier");
         Variable var19 = new Variable(var20, var10003);
         destination$iv$iv.add(var19);
      }

      var16 = (List)destination$iv$iv;
      var14.<init>(var15, var16, node, generatorHint);
      Collection var18;
      if (node.isConstructor()) {
         var18 = (Collection)this.constructors;
         var18.add(var13);
      } else {
         var18 = (Collection)this.methods;
         var18.add(var13);
      }

      this.methodAnnotations.clear();
   }

   public boolean visit(@NotNull EnumDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      List var10000 = this.staticInnerClasses;
      String var10001 = node.getName().getIdentifier();
      Intrinsics.checkExpressionValueIsNotNull(var10001, "node.name.identifier");
      var10000.add(var10001);
      return false;
   }

   public boolean visit(@NotNull TypeDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      if (node.getParent() instanceof TypeDeclaration) {
         if (Modifier.isStatic(node.getModifiers())) {
            List var10000 = this.staticInnerClasses;
            String var10001 = node.getName().getIdentifier();
            Intrinsics.checkExpressionValueIsNotNull(var10001, "node.name.identifier");
            var10000.add(var10001);
         }

         return false;
      } else {
         this.typeDeclaration = node;
         return true;
      }
   }

   private final void checkInnerCustomTypes() {
      TypeDeclaration var10000 = this.typeDeclaration;
      if (var10000 != null) {
         SimpleName var10 = var10000.getName();
         if (var10 != null) {
            String var11 = var10.getIdentifier();
            if (var11 != null) {
               String entityClassName = var11;
               Iterable $receiver$iv = (Iterable)this.properties;
               Iterator var3 = $receiver$iv.iterator();

               while(var3.hasNext()) {
                  Object element$iv = var3.next();
                  ParsedProperty it = (ParsedProperty)element$iv;
                  if (it.getCustomType() != null) {
                     String variableClassName = it.getVariable().getType().getName();
                     this.checkIfInnerTypeThenStatic(variableClassName, entityClassName);
                     String converterClassName = it.getCustomType().getConverterClassName();
                     this.checkIfInnerTypeThenStatic(converterClassName, entityClassName);
                  }
               }

               return;
            }
         }
      }

   }

   private final void checkIfInnerTypeThenStatic(String typeClassName, String outerClassName) {
      List split = StringsKt.split$default((CharSequence)typeClassName, new String[]{"."}, false, 0, 6, (Object)null);
      if (split.size() >= 2) {
         List qualifiedNames = CollectionsKt.takeLast(split, 2);
         if (outerClassName.equals(qualifiedNames.get(0)) && !this.staticInnerClasses.contains(qualifiedNames.get(1))) {
            throw (Throwable)(new IllegalArgumentException("Inner class " + typeClassName + " in " + outerClassName + " has to be static. " + "Only static classes are supported if converters or custom types (@Convert) are defined as inner classes."));
         }
      }
   }

   @Nullable
   public final ParsedEntity createParsedEntity(@NotNull File javaFile, @NotNull String source) {
      Intrinsics.checkParameterIsNotNull(javaFile, "javaFile");
      Intrinsics.checkParameterIsNotNull(source, "source");
      ParsedEntity var4;
      if (this.isEntity) {
         this.checkInnerCustomTypes();
         TypeDeclaration var10000 = this.typeDeclaration;
         if (var10000 == null) {
            Intrinsics.throwNpe();
         }

         TypeDeclaration node = var10000;
         var4 = new ParsedEntity;
         String var10002 = node.getName().getIdentifier();
         Intrinsics.checkExpressionValueIsNotNull(var10002, "node.name.identifier");
         String var10003 = this.schemaName;
         boolean var10004 = this.active;
         List var10005 = this.properties;
         List var10006 = this.transientFields;
         List var10007 = this.legacyTransientFields;
         List var10008 = this.constructors;
         List var10009 = this.methods;
         List var10011 = this.imports;
         String var10012 = this.packageName;
         if (var10012 == null) {
            var10012 = "";
         }

         var4.<init>(var10002, var10003, var10004, var10005, var10006, var10007, var10008, var10009, node, var10011, var10012, this.entityTableName, this.oneRelations, this.manyRelations, this.tableIndexes, javaFile, source, this.keepSource, this.createTable, this.generateConstructors, this.generateGettersSetters, this.protobufClassName, this.usedNotNullAnnotation, this.lastField);
      } else {
         var4 = null;
      }

      return var4;
   }

   @NotNull
   public final String getSource() {
      return this.source;
   }

   @NotNull
   public final List getClassesInPackage() {
      return this.classesInPackage;
   }

   public final int getKeepFieldsStartLineNumber() {
      return this.keepFieldsStartLineNumber;
   }

   public final int getKeepFieldsEndLineNumber() {
      return this.keepFieldsEndLineNumber;
   }

   public EntityClassASTVisitor(@NotNull String source, @NotNull List classesInPackage, int keepFieldsStartLineNumber, int keepFieldsEndLineNumber) {
      Intrinsics.checkParameterIsNotNull(source, "source");
      Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage");
      super();
      this.source = source;
      this.classesInPackage = classesInPackage;
      this.keepFieldsStartLineNumber = keepFieldsStartLineNumber;
      this.keepFieldsEndLineNumber = keepFieldsEndLineNumber;
      this.schemaName = "default";
      List var6 = (List)(new ArrayList());
      this.properties = var6;
      var6 = (List)(new ArrayList());
      this.transientFields = var6;
      var6 = (List)(new ArrayList());
      this.legacyTransientFields = var6;
      var6 = (List)(new ArrayList());
      this.constructors = var6;
      var6 = (List)(new ArrayList());
      this.methods = var6;
      var6 = (List)(new ArrayList());
      this.imports = var6;
      var6 = (List)(new ArrayList());
      this.staticInnerClasses = var6;
      var6 = (List)(new ArrayList());
      this.oneRelations = var6;
      var6 = (List)(new ArrayList());
      this.manyRelations = var6;
      this.tableIndexes = CollectionsKt.emptyList();
      this.createTable = true;
      this.generateConstructors = true;
      this.generateGettersSetters = true;
      var6 = (List)(new ArrayList());
      this.methodAnnotations = var6;
      var6 = (List)(new ArrayList());
      this.fieldAnnotations = var6;
   }

   // $FF: synthetic method
   public EntityClassASTVisitor(String var1, List var2, int var3, int var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 2) != 0) {
         var2 = CollectionsKt.emptyList();
      }

      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static final boolean access$hasType(EntityClassASTVisitor $this, @NotNull Annotation $receiver, @NotNull KClass klass) {
      return $this.hasType($receiver, klass);
   }
}
