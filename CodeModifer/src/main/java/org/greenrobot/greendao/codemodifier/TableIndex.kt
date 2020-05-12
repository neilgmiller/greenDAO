package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"], d2 = ["Lorg/greenrobot/greendao/codemodifier/TableIndex;", "", "name", "", "fields", "", "Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "unique", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getFields", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getUnique", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
class TableIndex(val name: String?, val fields: List<*>, val unique: Boolean) {

    fun copy(name: String?, fields: List<*>, unique: Boolean): TableIndex {
        Intrinsics.checkParameterIsNotNull(fields, "fields")
        return TableIndex(name, fields, unique)
    }

    override fun toString(): String {
        return "TableIndex(name=$name, fields=$fields, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        var var1 = (var10000?.hashCode() ?: 0) * 31
        val var10001 = fields
        var1 = (var1 + var10001.hashCode()) * 31
        var var2 = unique.toByte()
        if (var2.toInt() != 0) {
            var2 = 1
        }
        return var1 + var2
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is TableIndex) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && Intrinsics.areEqual(fields, var2.fields) && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}