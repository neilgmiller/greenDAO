package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"], d2 = ["Lorg/greenrobot/greendao/codemodifier/OneRelation;", "", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "foreignKeyField", "", "columnName", "isNotNull", "", "unique", "(Lorg/greenrobot/greendao/codemodifier/Variable;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getColumnName", "()Ljava/lang/String;", "getForeignKeyField", "()Z", "getUnique", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
class OneRelation(val variable: Variable, val foreignKeyField: String?, val columnName: String?, val isNotNull: Boolean, val unique: Boolean) {

    fun copy(variable: Variable, foreignKeyField: String?, columnName: String?, isNotNull: Boolean, unique: Boolean): OneRelation {
        Intrinsics.checkParameterIsNotNull(variable, "variable")
        return OneRelation(variable, foreignKeyField, columnName, isNotNull, unique)
    }

    override fun toString(): String {
        return "OneRelation(variable=$variable, foreignKeyField=$foreignKeyField, columnName=$columnName, isNotNull=$isNotNull, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = variable
        var var1 = (var10000.hashCode() ?: 0) * 31
        var var10001 = foreignKeyField
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        var10001 = columnName
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        var var2: Byte = isNotNull.toByte()
        if (var2.toInt() != 0) {
            var2 = 1
        }
        var1 = (var1 + var2) * 31
        var2 = unique.toByte()
        if (var2.toInt() != 0) {
            var2 = 1
        }
        return var1 + var2
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is OneRelation) {
                val var2 = other
                if (Intrinsics.areEqual(variable, var2.variable) && Intrinsics.areEqual(foreignKeyField, var2.foreignKeyField) && Intrinsics.areEqual(columnName, var2.columnName) && isNotNull == var2.isNotNull && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}