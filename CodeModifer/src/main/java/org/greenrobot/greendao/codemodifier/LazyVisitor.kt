package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import kotlin.jvm.internal.Intrinsics

open class LazyVisitor : ASTVisitor() {
    override fun visit(node: AnnotationTypeDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: AnnotationTypeMemberDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: AnonymousClassDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ArrayAccess): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ArrayCreation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ArrayInitializer): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ArrayType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: AssertStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: Assignment): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: Block): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: BlockComment): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: BooleanLiteral): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: BreakStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: CastExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: CatchClause): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: CharacterLiteral): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ClassInstanceCreation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: CompilationUnit): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ConditionalExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ConstructorInvocation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ContinueStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: CreationReference): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: Dimension): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: DoStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: EmptyStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: EnhancedForStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: EnumConstantDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: EnumDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ExpressionMethodReference): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ExpressionStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: FieldAccess): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: FieldDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ForStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: IfStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ImportDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: InfixExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: Initializer): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: InstanceofExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: IntersectionType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: Javadoc): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: LabeledStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: LambdaExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: LineComment): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MarkerAnnotation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MemberRef): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MemberValuePair): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MethodRef): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MethodRefParameter): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MethodDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: MethodInvocation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: Modifier): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: NameQualifiedType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: NormalAnnotation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: NullLiteral): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: NumberLiteral): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: PackageDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ParameterizedType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ParenthesizedExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: PostfixExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: PrefixExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: PrimitiveType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: QualifiedName): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: QualifiedType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ReturnStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SimpleName): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SimpleType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SingleMemberAnnotation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SingleVariableDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: StringLiteral): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SuperConstructorInvocation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SuperFieldAccess): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SuperMethodInvocation): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SuperMethodReference): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SwitchCase): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SwitchStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: SynchronizedStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TagElement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TextElement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ThisExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: ThrowStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TryStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TypeDeclaration): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TypeDeclarationStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TypeLiteral): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TypeMethodReference): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: TypeParameter): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: UnionType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: VariableDeclarationExpression): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: VariableDeclarationStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: VariableDeclarationFragment): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: WhileStatement): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }

    override fun visit(node: WildcardType): Boolean {
        Intrinsics.checkParameterIsNotNull(node, "node")
        return false
    }
}