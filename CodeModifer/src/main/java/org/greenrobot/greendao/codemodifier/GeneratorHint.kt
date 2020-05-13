package org.greenrobot.greendao.codemodifier

abstract class GeneratorHint private constructor() {
    class Keep private constructor() : GeneratorHint() {
        companion object {
            val INSTANCE: Keep = Keep()
        }
    }

    class Generated(val hash: Int) : GeneratorHint() {
        override fun equals(other: Any?): Boolean {
            return when {
                this === other -> true
                other !is Generated -> false
                else -> hash == other.hash
            }
        }

        override fun hashCode(): Int {
            return hash
        }

        override fun toString(): String {
            return "Generated(hash=$hash)"
        }
    }
}