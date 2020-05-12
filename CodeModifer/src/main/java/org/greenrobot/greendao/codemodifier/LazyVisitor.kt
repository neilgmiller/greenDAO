package org.greenrobot.greendao.codemodifier

import org.greenrobot.eclipse.jdt.core.dom.*
import kotlin.jvm.internal.Intrinsics

//@Metadata(mv = [1, 1, 5], bv = [1, 0, 1], k = 1, d1 = ["\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0012H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0013H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0014H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0015H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0016H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0017H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0018H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0019H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001aH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001cH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001dH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001eH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020 H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020!H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\"H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020#H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\$H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020%H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020&H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020'H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020(H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020)H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020*H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020+H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020,H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020-H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020.H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020/H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000200H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000201H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000202H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000203H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000204H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000205H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000206H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000207H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000208H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000209H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020:H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020;H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020<H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020=H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020>H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020?H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020@H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020AH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020BH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020CH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020DH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020EH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020FH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020GH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020HH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020IH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020JH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020KH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020LH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020MH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020NH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020OH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020PH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020QH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020RH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020SH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020TH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020UH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020VH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020WH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020XH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020YH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020ZH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020[H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\\H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020]H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020^H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020_H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020`H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020aH\u0016¨\u0006b"], d2 = ["Lorg/greenrobot/greendao/codemodifier/LazyVisitor;", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTVisitor;", "()V", "visit", "", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/AnnotationTypeDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/AnnotationTypeMemberDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/AnonymousClassDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayAccess;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayCreation;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayInitializer;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayType;", "Lorg/greenrobot/eclipse/jdt/core/dom/AssertStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/Assignment;", "Lorg/greenrobot/eclipse/jdt/core/dom/Block;", "Lorg/greenrobot/eclipse/jdt/core/dom/BlockComment;", "Lorg/greenrobot/eclipse/jdt/core/dom/BooleanLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/BreakStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/CastExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/CatchClause;", "Lorg/greenrobot/eclipse/jdt/core/dom/CharacterLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/ClassInstanceCreation;", "Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "Lorg/greenrobot/eclipse/jdt/core/dom/ConditionalExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/ConstructorInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/ContinueStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/CreationReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/Dimension;", "Lorg/greenrobot/eclipse/jdt/core/dom/DoStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/EmptyStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnhancedForStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnumConstantDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnumDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ExpressionMethodReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/ExpressionStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldAccess;", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ForStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/IfStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/InfixExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/Initializer;", "Lorg/greenrobot/eclipse/jdt/core/dom/InstanceofExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/IntersectionType;", "Lorg/greenrobot/eclipse/jdt/core/dom/Javadoc;", "Lorg/greenrobot/eclipse/jdt/core/dom/LabeledStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/LambdaExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/LineComment;", "Lorg/greenrobot/eclipse/jdt/core/dom/MarkerAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/MemberRef;", "Lorg/greenrobot/eclipse/jdt/core/dom/MemberValuePair;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodRef;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodRefParameter;", "Lorg/greenrobot/eclipse/jdt/core/dom/Modifier;", "Lorg/greenrobot/eclipse/jdt/core/dom/NameQualifiedType;", "Lorg/greenrobot/eclipse/jdt/core/dom/NormalAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/NullLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/NumberLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/PackageDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ParameterizedType;", "Lorg/greenrobot/eclipse/jdt/core/dom/ParenthesizedExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/PostfixExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/PrefixExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/PrimitiveType;", "Lorg/greenrobot/eclipse/jdt/core/dom/QualifiedName;", "Lorg/greenrobot/eclipse/jdt/core/dom/QualifiedType;", "Lorg/greenrobot/eclipse/jdt/core/dom/ReturnStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/SimpleName;", "Lorg/greenrobot/eclipse/jdt/core/dom/SimpleType;", "Lorg/greenrobot/eclipse/jdt/core/dom/SingleMemberAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/SingleVariableDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/StringLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperConstructorInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperFieldAccess;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperMethodInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperMethodReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/SwitchCase;", "Lorg/greenrobot/eclipse/jdt/core/dom/SwitchStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/SynchronizedStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TagElement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TextElement;", "Lorg/greenrobot/eclipse/jdt/core/dom/ThisExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/ThrowStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TryStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclarationStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeMethodReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeParameter;", "Lorg/greenrobot/eclipse/jdt/core/dom/UnionType;", "Lorg/greenrobot/eclipse/jdt/core/dom/VariableDeclarationExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/VariableDeclarationFragment;", "Lorg/greenrobot/eclipse/jdt/core/dom/VariableDeclarationStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/WhileStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/WildcardType;", "greendao-code-modifier_main"])
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