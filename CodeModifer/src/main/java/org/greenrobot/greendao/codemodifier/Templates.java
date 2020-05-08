package org.greenrobot.greendao.codemodifier;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.ToManyBase;
import org.greenrobot.greendao.generator.ToOne;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Templates;", "", "()V", "config", "Lfreemarker/template/Configuration;", "get", "Lfreemarker/template/Template;", "kotlin.jvm.PlatformType", "path", "", "entity", "greendao-code-modifier_main"}
)
public final class Templates {
   private static final Configuration config;
   public static final Templates INSTANCE;

   private final Template get(String path) {
      return config.getTemplate(path);
   }

   private Templates() {
      INSTANCE = (Templates)this;
      config = new Configuration(Configuration.VERSION_2_3_23);
      Configuration var10000 = config;
      Class var10001 = this.getClass();
      char var1 = '/';
      String var2 = StringsKt.replace$default(this.getClass().getPackage().getName(), '.', '/', false, 4, (Object)null);
      Class var4 = var10001;
      Configuration var3 = var10000;
      String var5 = var1 + var2;
      var3.setClassForTemplateLoading(var4, var5);
   }

   static {
      new Templates();
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\r\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010\u0012\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0015R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/Templates$entity;", "", "()V", "activeDelete", "Lfreemarker/template/Template;", "kotlin.jvm.PlatformType", "getActiveDelete", "()Lfreemarker/template/Template;", "activeRefresh", "getActiveRefresh", "activeUpdate", "getActiveUpdate", "constructor", "daoSessionSetter", "fieldGet", "fieldSet", "manyRelationGetter", "manyRelationReset", "oneRelationGetter", "oneRelationPeek", "oneRelationSetter", "", "className", "properties", "", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "notNullAnnotation", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "many", "Lorg/greenrobot/greendao/generator/ToManyBase;", "one", "Lorg/greenrobot/greendao/generator/ToOne;", "greendao-code-modifier_main"}
   )
   public static final class entity {
      private static final Template constructor;
      private static final Template daoSessionSetter;
      private static final Template oneRelationSetter;
      private static final Template oneRelationGetter;
      private static final Template oneRelationPeek;
      private static final Template manyRelationGetter;
      private static final Template manyRelationReset;
      private static final Template fieldGet;
      private static final Template fieldSet;
      private static final Template activeDelete;
      private static final Template activeUpdate;
      private static final Template activeRefresh;
      public static final Templates.entity INSTANCE;

      public final Template getActiveDelete() {
         return activeDelete;
      }

      public final Template getActiveUpdate() {
         return activeUpdate;
      }

      public final Template getActiveRefresh() {
         return activeRefresh;
      }

      @NotNull
      public final String constructor(@NotNull String className, @NotNull List properties, @NotNull String notNullAnnotation) {
         Intrinsics.checkParameterIsNotNull(className, "className");
         Intrinsics.checkParameterIsNotNull(properties, "properties");
         Intrinsics.checkParameterIsNotNull(notNullAnnotation, "notNullAnnotation");
         return TemplatesKt.invoke(constructor, MapsKt.mapOf(new Pair[]{TuplesKt.to("className", className), TuplesKt.to("properties", properties), TuplesKt.to("notNullAnnotation", notNullAnnotation)}));
      }

      @NotNull
      public final String daoSessionSetter(@NotNull Entity entity) {
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         return TemplatesKt.invoke(daoSessionSetter, MapsKt.mapOf(TuplesKt.to("entity", entity)));
      }

      @NotNull
      public final String oneRelationSetter(@NotNull ToOne one, @NotNull String notNullAnnotation) {
         Intrinsics.checkParameterIsNotNull(one, "one");
         Intrinsics.checkParameterIsNotNull(notNullAnnotation, "notNullAnnotation");
         return TemplatesKt.invoke(oneRelationSetter, MapsKt.mapOf(new Pair[]{TuplesKt.to("toOne", one), TuplesKt.to("notNullAnnotation", notNullAnnotation)}));
      }

      @NotNull
      public final String oneRelationGetter(@NotNull ToOne one, @NotNull Entity entity) {
         Intrinsics.checkParameterIsNotNull(one, "one");
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         return TemplatesKt.invoke(oneRelationGetter, MapsKt.mapOf(new Pair[]{TuplesKt.to("entity", entity), TuplesKt.to("toOne", one)}));
      }

      @NotNull
      public final String oneRelationPeek(@NotNull ToOne one) {
         Intrinsics.checkParameterIsNotNull(one, "one");
         return TemplatesKt.invoke(oneRelationPeek, MapsKt.mapOf(TuplesKt.to("toOne", one)));
      }

      @NotNull
      public final String manyRelationGetter(@NotNull ToManyBase many, @NotNull Entity entity) {
         Intrinsics.checkParameterIsNotNull(many, "many");
         Intrinsics.checkParameterIsNotNull(entity, "entity");
         return TemplatesKt.invoke(manyRelationGetter, MapsKt.mapOf(new Pair[]{TuplesKt.to("toMany", many), TuplesKt.to("entity", entity)}));
      }

      @NotNull
      public final String manyRelationReset(@NotNull ToManyBase many) {
         Intrinsics.checkParameterIsNotNull(many, "many");
         return TemplatesKt.invoke(manyRelationReset, MapsKt.mapOf(TuplesKt.to("toMany", many)));
      }

      @NotNull
      public final String fieldGet(@NotNull Variable variable) {
         Intrinsics.checkParameterIsNotNull(variable, "variable");
         return TemplatesKt.invoke(fieldGet, MapsKt.mapOf(TuplesKt.to("variable", variable)));
      }

      @NotNull
      public final String fieldSet(@NotNull Variable variable) {
         Intrinsics.checkParameterIsNotNull(variable, "variable");
         return TemplatesKt.invoke(fieldSet, MapsKt.mapOf(TuplesKt.to("variable", variable)));
      }

      private entity() {
         INSTANCE = (Templates.entity)this;
         constructor = Templates.INSTANCE.get("entity/constructor.ftl");
         daoSessionSetter = Templates.INSTANCE.get("entity/dao_session_setter.ftl");
         oneRelationSetter = Templates.INSTANCE.get("entity/one_relation_setter.ftl");
         oneRelationGetter = Templates.INSTANCE.get("entity/one_relation_getter.ftl");
         oneRelationPeek = Templates.INSTANCE.get("entity/one_relation_peek.ftl");
         manyRelationGetter = Templates.INSTANCE.get("entity/many_relation_getter.ftl");
         manyRelationReset = Templates.INSTANCE.get("entity/many_relation_reset.ftl");
         fieldGet = Templates.INSTANCE.get("entity/field_get.ftl");
         fieldSet = Templates.INSTANCE.get("entity/field_set.ftl");
         activeDelete = Templates.INSTANCE.get("entity/active_delete.ftl");
         activeUpdate = Templates.INSTANCE.get("entity/active_update.ftl");
         activeRefresh = Templates.INSTANCE.get("entity/active_refresh.ftl");
      }

      static {
         new Templates.entity();
      }
   }
}
