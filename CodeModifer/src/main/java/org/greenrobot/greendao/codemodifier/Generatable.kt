package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.BodyDeclaration
import kotlin.jvm.internal.Intrinsics

interface Generatable {
    val hint: GeneratorHint?
    val node: BodyDeclaration
    val generated: Boolean
    val keep: Boolean
}