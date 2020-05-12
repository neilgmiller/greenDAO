package org.greenrobot.greendao.codemodifier

import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"], d2 = ["Lorg/greenrobot/greendao/codemodifier/PropertyIndex;", "", "name", "", "unique", "", "(Ljava/lang/String;Z)V", "getName", "()Ljava/lang/String;", "getUnique", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"])
class PropertyIndex(val name: String?, val unique: Boolean) {

    fun copy(name: String?, unique: Boolean): PropertyIndex {
        return PropertyIndex(name, unique)
    }

    override fun toString(): String {
        return "PropertyIndex(name=$name, unique=$unique)"
    }

    override fun hashCode(): Int {
        val var10000 = name
        val var1 = (var10000?.hashCode() ?: 0) * 31
        var var10001 = unique.toByte()
        if (var10001.toInt() != 0) {
            var10001 = 1
        }
        return var1 + var10001
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is PropertyIndex) {
                val var2 = other
                if (Intrinsics.areEqual(name, var2.name) && unique == var2.unique) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}