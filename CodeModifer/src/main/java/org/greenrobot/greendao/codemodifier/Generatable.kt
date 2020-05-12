package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.BodyDeclaration
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"], d2 = ["Lorg/greenrobot/greendao/codemodifier/Generatable;", "NodeType", "Lorg/greenrobot/eclipse/jdt/core/dom/BodyDeclaration;", "", "generated", "", "getGenerated", "()Z", "hint", "Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "getHint", "()Lorg/greenrobot/greendao/codemodifier/GeneratorHint;", "keep", "getKeep", "node", "getNode", "()Lorg/greenrobot/eclipse/jdt/core/dom/BodyDeclaration;", "greendao-code-modifier_main"])
interface Generatable {
    val hint: GeneratorHint?
    val node: BodyDeclaration
    val generated: Boolean
    val keep: Boolean

//    object DefaultImpls {
//        fun getGenerated(`$this`: Generatable): Boolean {
//            return `$this`.hint is GeneratorHint.Generated
//        }
//
//        fun getKeep(`$this`: Generatable): Boolean {
//            return Intrinsics.areEqual(`$this`.hint, GeneratorHint.Keep.INSTANCE)
//        }
//    }
}