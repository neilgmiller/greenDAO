package org.greenrobot.greendao.codemodifier

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"], d2 = ["Lorg/greenrobot/greendao/codemodifier/EntityIdParams;", "", "autoincrement", "", "(Z)V", "getAutoincrement", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "greendao-code-modifier_main"])
class EntityIdParams(val autoincrement: Boolean) {

    operator fun component1(): Boolean {
        return autoincrement
    }

    fun copy(autoincrement: Boolean): EntityIdParams {
        return EntityIdParams(autoincrement)
    }

    override fun toString(): String {
        return "EntityIdParams(autoincrement=" + autoincrement + ")"
    }

    override fun hashCode(): Int {
        return if (autoincrement) 1 else 0
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is EntityIdParams) {
                if (autoincrement == other.autoincrement) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}