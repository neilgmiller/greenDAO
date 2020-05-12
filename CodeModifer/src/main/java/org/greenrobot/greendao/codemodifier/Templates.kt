package org.greenrobot.greendao.codemodifier

import freemarker.template.Configuration
import freemarker.template.Template
import org.greenrobot.greendao.generator.Entity
import org.greenrobot.greendao.generator.ToManyBase
import org.greenrobot.greendao.generator.ToOne
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Templates;", "", "()V", "config", "Lfreemarker/template/Configuration;", "get", "Lfreemarker/template/Template;", "kotlin.jvm.PlatformType", "path", "", "entity", "greendao-code-modifier_main"])
class Templates private constructor() {
    private operator fun get(path: String): Template {
        return config.getTemplate(path)
    }

    companion object {
        private var config: Configuration
        var INSTANCE: Templates

        init {
            Templates()
        }
    }

//    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\r\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010\u0012\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u0013\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0015R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0016\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Templates\$entity;", "", "()V", "activeDelete", "Lfreemarker/template/Template;", "kotlin.jvm.PlatformType", "getActiveDelete", "()Lfreemarker/template/Template;", "activeRefresh", "getActiveRefresh", "activeUpdate", "getActiveUpdate", "constructor", "daoSessionSetter", "fieldGet", "fieldSet", "manyRelationGetter", "manyRelationReset", "oneRelationGetter", "oneRelationPeek", "oneRelationSetter", "", "className", "properties", "", "Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "notNullAnnotation", "entity", "Lorg/greenrobot/greendao/generator/Entity;", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "many", "Lorg/greenrobot/greendao/generator/ToManyBase;", "one", "Lorg/greenrobot/greendao/generator/ToOne;", "greendao-code-modifier_main"])
    class entity private constructor() {
        val activeDelete: Template
        val activeUpdate: Template
        val activeRefresh: Template

        @JvmStatic
        fun constructor(className: String, properties: List<*>, notNullAnnotation: String): String {
            Intrinsics.checkParameterIsNotNull(className, "className")
            Intrinsics.checkParameterIsNotNull(properties, "properties")
            Intrinsics.checkParameterIsNotNull(notNullAnnotation, "notNullAnnotation")
            return TemplatesKt.invoke(constructor, mapOf<Any?, Any>(*arrayOf<Pair<*, *>?>("className".to(className), "properties".to(properties), "notNullAnnotation".to(notNullAnnotation))))
        }

        @JvmStatic
        fun daoSessionSetter(entity: Entity): String {
            Intrinsics.checkParameterIsNotNull(entity, "entity")
            return TemplatesKt.invoke(entity.Companion.daoSessionSetter, mapOf<String?, Entity>("entity".to(entity)))
        }

        @JvmStatic
        fun oneRelationSetter(one: ToOne, notNullAnnotation: String): String {
            Intrinsics.checkParameterIsNotNull(one, "one")
            Intrinsics.checkParameterIsNotNull(notNullAnnotation, "notNullAnnotation")
            return TemplatesKt.invoke(oneRelationSetter, mapOf<Any?, Any>(*arrayOf<Pair<*, *>?>("toOne".to(one), "notNullAnnotation".to(notNullAnnotation))))
        }

        @JvmStatic
        fun oneRelationGetter(one: ToOne, entity: Entity): String {
            Intrinsics.checkParameterIsNotNull(one, "one")
            Intrinsics.checkParameterIsNotNull(entity, "entity")
            return TemplatesKt.invoke(entity.Companion.oneRelationGetter, mapOf<Any?, Any>(*arrayOf<Pair<*, *>?>("entity".to(entity), "toOne".to(one))))
        }

        @JvmStatic
        fun oneRelationPeek(one: ToOne): String {
            Intrinsics.checkParameterIsNotNull(one, "one")
            return TemplatesKt.invoke(oneRelationPeek, mapOf<String?, ToOne>("toOne".to(one)))
        }

        @JvmStatic
        fun manyRelationGetter(many: ToManyBase, entity: Entity): String {
            Intrinsics.checkParameterIsNotNull(many, "many")
            Intrinsics.checkParameterIsNotNull(entity, "entity")
            return TemplatesKt.invoke(entity.Companion.manyRelationGetter, mapOf<Any?, Any>(*arrayOf<Pair<*, *>?>("toMany".to(many), "entity".to(entity))))
        }

        @JvmStatic
        fun manyRelationReset(many: ToManyBase): String {
            Intrinsics.checkParameterIsNotNull(many, "many")
            return TemplatesKt.invoke(manyRelationReset, mapOf<String?, ToManyBase>("toMany".to(many)))
        }

        @JvmStatic
        fun fieldGet(variable: Variable): String {
            Intrinsics.checkParameterIsNotNull(variable, "variable")
            return TemplatesKt.invoke(fieldGet, mapOf<String?, Variable>("variable".to(variable)))
        }

        @JvmStatic
        fun fieldSet(variable: Variable): String {
            Intrinsics.checkParameterIsNotNull(variable, "variable")
            return TemplatesKt.invoke(fieldSet, mapOf<String?, Variable>("variable".to(variable)))
        }

        companion object {
            private var constructor: Template
            private var daoSessionSetter: Template
            private var oneRelationSetter: Template
            private var oneRelationGetter: Template
            private var oneRelationPeek: Template
            private var manyRelationGetter: Template
            private var manyRelationReset: Template
            private var fieldGet: Template
            private var fieldSet: Template
            private val activeDelete: Template
            private val activeUpdate: Template
            private val activeRefresh: Template
            @JvmField
            var INSTANCE: entity

            init {
                entity()
            }
        }

        init {
            INSTANCE = this
            constructor = Templates.INSTANCE["entity/constructor.ftl"]
            daoSessionSetter = Templates.INSTANCE["entity/dao_session_setter.ftl"]
            oneRelationSetter = Templates.INSTANCE["entity/one_relation_setter.ftl"]
            oneRelationGetter = Templates.INSTANCE["entity/one_relation_getter.ftl"]
            oneRelationPeek = Templates.INSTANCE["entity/one_relation_peek.ftl"]
            manyRelationGetter = Templates.INSTANCE["entity/many_relation_getter.ftl"]
            manyRelationReset = Templates.INSTANCE["entity/many_relation_reset.ftl"]
            fieldGet = Templates.INSTANCE["entity/field_get.ftl"]
            fieldSet = Templates.INSTANCE["entity/field_set.ftl"]
            activeDelete = Templates.INSTANCE["entity/active_delete.ftl"]
            activeUpdate = Templates.INSTANCE["entity/active_update.ftl"]
            activeRefresh = Templates.INSTANCE["entity/active_refresh.ftl"]
        }
    }

    init {
        INSTANCE = this
        config = Configuration(Configuration.VERSION_2_3_23)
        val var10000 = config
        val var10001: Class<*> = this.javaClass
        val var1 = '/'
        val var2: String = this.javaClass.getPackage().name.replace('.', '/', false)
        val var5 = var1.toString() + var2
        var10000.setClassForTemplateLoading(var10001, var5)
    }
}