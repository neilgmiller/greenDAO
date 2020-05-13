package org.greenrobot.greendao.codemodifier

import freemarker.template.Configuration
import freemarker.template.Template
import org.greenrobot.greendao.generator.ToManyBase
import org.greenrobot.greendao.generator.ToOne
import kotlin.jvm.internal.Intrinsics

class Templates private constructor() {
    private operator fun get(path: String): Template = config.getTemplate(path)

    companion object {
        private var config = Configuration(Configuration.VERSION_2_3_23)
        var INSTANCE = Templates()
    }

    init {
        val packageString: String = this.javaClass.getPackage().name.replace('.', '/', false)
        config.setClassForTemplateLoading(this.javaClass, "/$packageString")
    }

    class Entity private constructor() {
        // TODO: these are never used
        private val activeDelete = Templates.INSTANCE["entity/active_delete.ftl"]
        private val activeUpdate = Templates.INSTANCE["entity/active_update.ftl"]
        private val activeRefresh = Templates.INSTANCE["entity/active_refresh.ftl"]

        fun constructor(className: String, properties: List<*>, notNullAnnotation: String): String {
            return TemplatesKt.invoke(constructor, mapOf<Any?, Any>("className" to className, "properties" to properties, "notNullAnnotation" to notNullAnnotation))
        }

        fun daoSessionSetter(entity: org.greenrobot.greendao.generator.Entity): String {
            Intrinsics.checkParameterIsNotNull(entity, "entity")
            return TemplatesKt.invoke(daoSessionSetter, mapOf<String?, org.greenrobot.greendao.generator.Entity>("entity" to entity))
        }

        fun oneRelationSetter(one: ToOne, notNullAnnotation: String): String {
            Intrinsics.checkParameterIsNotNull(one, "one")
            Intrinsics.checkParameterIsNotNull(notNullAnnotation, "notNullAnnotation")
            return TemplatesKt.invoke(oneRelationSetter, mapOf<Any?, Any>("toOne" to one, "notNullAnnotation" to notNullAnnotation))
        }

        fun oneRelationGetter(one: ToOne, entity: org.greenrobot.greendao.generator.Entity): String {
            Intrinsics.checkParameterIsNotNull(one, "one")
            Intrinsics.checkParameterIsNotNull(entity, "entity")
            return TemplatesKt.invoke(oneRelationGetter, mapOf<Any?, Any>("entity" to entity, "toOne" to one))
        }

        fun oneRelationPeek(one: ToOne): String {
            Intrinsics.checkParameterIsNotNull(one, "one")
            return TemplatesKt.invoke(oneRelationPeek, mapOf<String?, ToOne>("toOne" to one))
        }

        fun manyRelationGetter(many: ToManyBase, entity: org.greenrobot.greendao.generator.Entity): String {
            Intrinsics.checkParameterIsNotNull(many, "many")
            Intrinsics.checkParameterIsNotNull(entity, "entity")
            return TemplatesKt.invoke(manyRelationGetter, mapOf<Any?, Any>("toMany" to many, "entity" to entity))
        }

        fun manyRelationReset(many: ToManyBase): String {
            Intrinsics.checkParameterIsNotNull(many, "many")
            return TemplatesKt.invoke(manyRelationReset, mapOf<String?, ToManyBase>("toMany" to many))
        }

        fun fieldGet(variable: Variable): String {
            Intrinsics.checkParameterIsNotNull(variable, "variable")
            return TemplatesKt.invoke(fieldGet, mapOf<String?, Variable>("variable" to variable))
        }

        fun fieldSet(variable: Variable): String {
            Intrinsics.checkParameterIsNotNull(variable, "variable")
            return TemplatesKt.invoke(fieldSet, mapOf<String?, Variable>("variable" to variable))
        }

        companion object {
            var INSTANCE = Entity()
            private var constructor = Templates.INSTANCE["entity/constructor.ftl"]
            private var daoSessionSetter = Templates.INSTANCE["entity/dao_session_setter.ftl"]
            private var oneRelationSetter = Templates.INSTANCE["entity/one_relation_setter.ftl"]
            private var oneRelationGetter = Templates.INSTANCE["entity/one_relation_getter.ftl"]
            private var oneRelationPeek = Templates.INSTANCE["entity/one_relation_peek.ftl"]
            private var manyRelationGetter = Templates.INSTANCE["entity/many_relation_getter.ftl"]
            private var manyRelationReset = Templates.INSTANCE["entity/many_relation_reset.ftl"]
            private var fieldGet = Templates.INSTANCE["entity/field_get.ftl"]
            private var fieldSet = Templates.INSTANCE["entity/field_set.ftl"]
        }
    }
}