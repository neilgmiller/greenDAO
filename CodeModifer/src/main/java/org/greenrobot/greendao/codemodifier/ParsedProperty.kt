package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"], d2 = ["Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "id", "Lorg/greenrobot/greendao/codemodifier/EntityIdParams;", "index", "Lorg/greenrobot/greendao/codemodifier/PropertyIndex;", "isNotNull", "", "dbName", "", "customType", "Lorg/greenrobot/greendao/codemodifier/CustomType;", "unique", "(Lorg/greenrobot/greendao/codemodifier/Variable;Lorg/greenrobot/greendao/codemodifier/EntityIdParams;Lorg/greenrobot/greendao/codemodifier/PropertyIndex;ZLjava/lang/String;Lorg/greenrobot/greendao/codemodifier/CustomType;Z)V", "getCustomType", "()Lorg/greenrobot/greendao/codemodifier/CustomType;", "getDbName", "()Ljava/lang/String;", "getId", "()Lorg/greenrobot/greendao/codemodifier/EntityIdParams;", "getIndex", "()Lorg/greenrobot/greendao/codemodifier/PropertyIndex;", "()Z", "getUnique", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
class ParsedProperty(val variable: Variable, val id: EntityIdParams?, val index: PropertyIndex?, val isNotNull: Boolean, val dbName: String?, val customType: CustomType?, val unique: Boolean) {

    fun copy(variable: Variable, id: EntityIdParams?, index: PropertyIndex?, isNotNull: Boolean, dbName: String?, customType: CustomType?, unique: Boolean): ParsedProperty {
        Intrinsics.checkParameterIsNotNull(variable, "variable")
        return ParsedProperty(variable, id, index, isNotNull, dbName, customType, unique)
    }

    override fun toString(): String {
        return "ParsedProperty(variable=$variable, id=$id, index=$index, isNotNull=$isNotNull, dbName=$dbName, customType=$customType, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = variable
        var var1 = (var10000.hashCode() ?: 0) * 31
        val var10001 = id
        var1 = (var1 + (var10001?.hashCode() ?: 0)) * 31
        val var2 = index
        var1 = (var1 + (var2?.hashCode() ?: 0)) * 31
        var var3 = isNotNull.toByte()
        if (var3.toInt() != 0) {
            var3 = 1
        }
        var1 = (var1 + var3) * 31
        val var4 = dbName
        var1 = (var1 + (var4?.hashCode() ?: 0)) * 31
        val var5 = customType
        var1 = (var1 + (var5?.hashCode() ?: 0)) * 31
        var3 = unique.toByte()
        if (var3.toInt() != 0) {
            var3 = 1
        }
        return var1 + var3
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is ParsedProperty) {
                val var2 = other
                if (Intrinsics.areEqual(variable, var2.variable) && Intrinsics.areEqual(id, var2.id) && Intrinsics.areEqual(index, var2.index) && isNotNull == var2.isNotNull && Intrinsics.areEqual(dbName, var2.dbName) && Intrinsics.areEqual(customType, var2.customType) && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }
}