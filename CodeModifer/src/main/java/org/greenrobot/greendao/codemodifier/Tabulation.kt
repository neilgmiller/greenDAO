package org.greenrobot.greendao.codemodifier

class Tabulation(val tabChar: Char, val size: Int) {

    fun copy(tabChar: Char, size: Int): Tabulation {
        return Tabulation(tabChar, size)
    }

    override fun toString(): String {
        return "Tabulation(tabChar=$tabChar, size=$size)"
    }

    override fun hashCode(): Int {
        return tabChar.toInt() * 31 + size
    }

    override fun equals(other: Any?): Boolean {
        return if (this !== other) {
            if (other is Tabulation) {
                val var2 = other
                if (tabChar == var2.tabChar && size == var2.size) {
                    return true
                }
            }
            false
        } else {
            true
        }
    }

}