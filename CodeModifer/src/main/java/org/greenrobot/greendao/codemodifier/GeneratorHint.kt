package org.greenrobot.greendao.codemodifier

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"], d2 = ["Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "", "()V", "Generated", "Keep", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint\$Keep;", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint\$Generated;", "greendao-code-modifier_main"])
abstract class GeneratorHint private constructor() {
//    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"], d2 = ["Lorg/greenrobot/greendao/codemodifier/GeneratorHint\$Keep;", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "()V", "greendao-code-modifier_main"])
    class Keep private constructor() : GeneratorHint() {
        companion object {
            val INSTANCE: Keep = Keep()
        }
    }

//    @Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"], d2 = ["Lorg/greenrobot/greendao/codemodifier/GeneratorHint\$Generated;", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "hash", "", "(I)V", "getHash", "()I", "equals", "", "other", "", "hashCode", "toString", "", "greendao-code-modifier_main"])
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