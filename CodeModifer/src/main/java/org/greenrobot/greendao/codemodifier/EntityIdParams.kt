package org.greenrobot.greendao.codemodifier

class EntityIdParams(val autoincrement: Boolean) {
    fun copy(autoincrement: Boolean): EntityIdParams {
        return EntityIdParams(autoincrement)
    }

    override fun toString(): String {
        return "EntityIdParams(autoincrement=$autoincrement)"
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