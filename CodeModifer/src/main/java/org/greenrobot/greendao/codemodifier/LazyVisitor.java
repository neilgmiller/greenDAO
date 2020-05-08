package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eclipse.jdt.core.dom.ASTVisitor;
import org.greenrobot.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.AnnotationTypeMemberDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ArrayAccess;
import org.greenrobot.eclipse.jdt.core.dom.ArrayCreation;
import org.greenrobot.eclipse.jdt.core.dom.ArrayInitializer;
import org.greenrobot.eclipse.jdt.core.dom.ArrayType;
import org.greenrobot.eclipse.jdt.core.dom.AssertStatement;
import org.greenrobot.eclipse.jdt.core.dom.Assignment;
import org.greenrobot.eclipse.jdt.core.dom.Block;
import org.greenrobot.eclipse.jdt.core.dom.BlockComment;
import org.greenrobot.eclipse.jdt.core.dom.BooleanLiteral;
import org.greenrobot.eclipse.jdt.core.dom.BreakStatement;
import org.greenrobot.eclipse.jdt.core.dom.CastExpression;
import org.greenrobot.eclipse.jdt.core.dom.CatchClause;
import org.greenrobot.eclipse.jdt.core.dom.CharacterLiteral;
import org.greenrobot.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit;
import org.greenrobot.eclipse.jdt.core.dom.ConditionalExpression;
import org.greenrobot.eclipse.jdt.core.dom.ConstructorInvocation;
import org.greenrobot.eclipse.jdt.core.dom.ContinueStatement;
import org.greenrobot.eclipse.jdt.core.dom.CreationReference;
import org.greenrobot.eclipse.jdt.core.dom.Dimension;
import org.greenrobot.eclipse.jdt.core.dom.DoStatement;
import org.greenrobot.eclipse.jdt.core.dom.EmptyStatement;
import org.greenrobot.eclipse.jdt.core.dom.EnhancedForStatement;
import org.greenrobot.eclipse.jdt.core.dom.EnumConstantDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.EnumDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ExpressionMethodReference;
import org.greenrobot.eclipse.jdt.core.dom.ExpressionStatement;
import org.greenrobot.eclipse.jdt.core.dom.FieldAccess;
import org.greenrobot.eclipse.jdt.core.dom.FieldDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ForStatement;
import org.greenrobot.eclipse.jdt.core.dom.IfStatement;
import org.greenrobot.eclipse.jdt.core.dom.ImportDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.InfixExpression;
import org.greenrobot.eclipse.jdt.core.dom.Initializer;
import org.greenrobot.eclipse.jdt.core.dom.InstanceofExpression;
import org.greenrobot.eclipse.jdt.core.dom.IntersectionType;
import org.greenrobot.eclipse.jdt.core.dom.Javadoc;
import org.greenrobot.eclipse.jdt.core.dom.LabeledStatement;
import org.greenrobot.eclipse.jdt.core.dom.LambdaExpression;
import org.greenrobot.eclipse.jdt.core.dom.LineComment;
import org.greenrobot.eclipse.jdt.core.dom.MarkerAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.MemberRef;
import org.greenrobot.eclipse.jdt.core.dom.MemberValuePair;
import org.greenrobot.eclipse.jdt.core.dom.MethodDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.MethodInvocation;
import org.greenrobot.eclipse.jdt.core.dom.MethodRef;
import org.greenrobot.eclipse.jdt.core.dom.MethodRefParameter;
import org.greenrobot.eclipse.jdt.core.dom.Modifier;
import org.greenrobot.eclipse.jdt.core.dom.NameQualifiedType;
import org.greenrobot.eclipse.jdt.core.dom.NormalAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.NullLiteral;
import org.greenrobot.eclipse.jdt.core.dom.NumberLiteral;
import org.greenrobot.eclipse.jdt.core.dom.PackageDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.ParameterizedType;
import org.greenrobot.eclipse.jdt.core.dom.ParenthesizedExpression;
import org.greenrobot.eclipse.jdt.core.dom.PostfixExpression;
import org.greenrobot.eclipse.jdt.core.dom.PrefixExpression;
import org.greenrobot.eclipse.jdt.core.dom.PrimitiveType;
import org.greenrobot.eclipse.jdt.core.dom.QualifiedName;
import org.greenrobot.eclipse.jdt.core.dom.QualifiedType;
import org.greenrobot.eclipse.jdt.core.dom.ReturnStatement;
import org.greenrobot.eclipse.jdt.core.dom.SimpleName;
import org.greenrobot.eclipse.jdt.core.dom.SimpleType;
import org.greenrobot.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.greenrobot.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.StringLiteral;
import org.greenrobot.eclipse.jdt.core.dom.SuperConstructorInvocation;
import org.greenrobot.eclipse.jdt.core.dom.SuperFieldAccess;
import org.greenrobot.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.greenrobot.eclipse.jdt.core.dom.SuperMethodReference;
import org.greenrobot.eclipse.jdt.core.dom.SwitchCase;
import org.greenrobot.eclipse.jdt.core.dom.SwitchStatement;
import org.greenrobot.eclipse.jdt.core.dom.SynchronizedStatement;
import org.greenrobot.eclipse.jdt.core.dom.TagElement;
import org.greenrobot.eclipse.jdt.core.dom.TextElement;
import org.greenrobot.eclipse.jdt.core.dom.ThisExpression;
import org.greenrobot.eclipse.jdt.core.dom.ThrowStatement;
import org.greenrobot.eclipse.jdt.core.dom.TryStatement;
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclaration;
import org.greenrobot.eclipse.jdt.core.dom.TypeDeclarationStatement;
import org.greenrobot.eclipse.jdt.core.dom.TypeLiteral;
import org.greenrobot.eclipse.jdt.core.dom.TypeMethodReference;
import org.greenrobot.eclipse.jdt.core.dom.TypeParameter;
import org.greenrobot.eclipse.jdt.core.dom.UnionType;
import org.greenrobot.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.greenrobot.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.greenrobot.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.greenrobot.eclipse.jdt.core.dom.WhileStatement;
import org.greenrobot.eclipse.jdt.core.dom.WildcardType;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000\u0084\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\rH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0010H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0011H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0012H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0013H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0014H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0015H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0016H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0017H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0018H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0019H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001aH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001cH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001dH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001eH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020 H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020!H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\"H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020#H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020$H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020%H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020&H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020'H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020(H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020)H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020*H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020+H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020,H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020-H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020.H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020/H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000200H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000201H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000202H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000203H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000204H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000205H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000206H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000207H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000208H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u000209H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020:H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020;H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020<H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020=H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020>H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020?H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020@H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020AH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020BH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020CH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020DH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020EH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020FH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020GH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020HH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020IH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020JH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020KH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020LH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020MH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020NH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020OH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020PH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020QH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020RH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020SH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020TH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020UH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020VH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020WH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020XH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020YH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020ZH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020[H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\\H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020]H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020^H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020_H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020`H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020aH\u0016¨\u0006b"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/LazyVisitor;", "Lorg/greenrobot/eclipse/jdt/core/dom/ASTVisitor;", "()V", "visit", "", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/AnnotationTypeDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/AnnotationTypeMemberDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/AnonymousClassDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayAccess;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayCreation;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayInitializer;", "Lorg/greenrobot/eclipse/jdt/core/dom/ArrayType;", "Lorg/greenrobot/eclipse/jdt/core/dom/AssertStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/Assignment;", "Lorg/greenrobot/eclipse/jdt/core/dom/Block;", "Lorg/greenrobot/eclipse/jdt/core/dom/BlockComment;", "Lorg/greenrobot/eclipse/jdt/core/dom/BooleanLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/BreakStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/CastExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/CatchClause;", "Lorg/greenrobot/eclipse/jdt/core/dom/CharacterLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/ClassInstanceCreation;", "Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "Lorg/greenrobot/eclipse/jdt/core/dom/ConditionalExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/ConstructorInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/ContinueStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/CreationReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/Dimension;", "Lorg/greenrobot/eclipse/jdt/core/dom/DoStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/EmptyStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnhancedForStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnumConstantDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/EnumDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ExpressionMethodReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/ExpressionStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldAccess;", "Lorg/greenrobot/eclipse/jdt/core/dom/FieldDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ForStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/IfStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/ImportDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/InfixExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/Initializer;", "Lorg/greenrobot/eclipse/jdt/core/dom/InstanceofExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/IntersectionType;", "Lorg/greenrobot/eclipse/jdt/core/dom/Javadoc;", "Lorg/greenrobot/eclipse/jdt/core/dom/LabeledStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/LambdaExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/LineComment;", "Lorg/greenrobot/eclipse/jdt/core/dom/MarkerAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/MemberRef;", "Lorg/greenrobot/eclipse/jdt/core/dom/MemberValuePair;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodRef;", "Lorg/greenrobot/eclipse/jdt/core/dom/MethodRefParameter;", "Lorg/greenrobot/eclipse/jdt/core/dom/Modifier;", "Lorg/greenrobot/eclipse/jdt/core/dom/NameQualifiedType;", "Lorg/greenrobot/eclipse/jdt/core/dom/NormalAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/NullLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/NumberLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/PackageDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/ParameterizedType;", "Lorg/greenrobot/eclipse/jdt/core/dom/ParenthesizedExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/PostfixExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/PrefixExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/PrimitiveType;", "Lorg/greenrobot/eclipse/jdt/core/dom/QualifiedName;", "Lorg/greenrobot/eclipse/jdt/core/dom/QualifiedType;", "Lorg/greenrobot/eclipse/jdt/core/dom/ReturnStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/SimpleName;", "Lorg/greenrobot/eclipse/jdt/core/dom/SimpleType;", "Lorg/greenrobot/eclipse/jdt/core/dom/SingleMemberAnnotation;", "Lorg/greenrobot/eclipse/jdt/core/dom/SingleVariableDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/StringLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperConstructorInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperFieldAccess;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperMethodInvocation;", "Lorg/greenrobot/eclipse/jdt/core/dom/SuperMethodReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/SwitchCase;", "Lorg/greenrobot/eclipse/jdt/core/dom/SwitchStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/SynchronizedStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TagElement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TextElement;", "Lorg/greenrobot/eclipse/jdt/core/dom/ThisExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/ThrowStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TryStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclaration;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeDeclarationStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeLiteral;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeMethodReference;", "Lorg/greenrobot/eclipse/jdt/core/dom/TypeParameter;", "Lorg/greenrobot/eclipse/jdt/core/dom/UnionType;", "Lorg/greenrobot/eclipse/jdt/core/dom/VariableDeclarationExpression;", "Lorg/greenrobot/eclipse/jdt/core/dom/VariableDeclarationFragment;", "Lorg/greenrobot/eclipse/jdt/core/dom/VariableDeclarationStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/WhileStatement;", "Lorg/greenrobot/eclipse/jdt/core/dom/WildcardType;", "greendao-code-modifier_main"}
)
public class LazyVisitor extends ASTVisitor {
   public boolean visit(@NotNull AnnotationTypeDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull AnnotationTypeMemberDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull AnonymousClassDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ArrayAccess node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ArrayCreation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ArrayInitializer node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ArrayType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull AssertStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull Assignment node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull Block node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull BlockComment node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull BooleanLiteral node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull BreakStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull CastExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull CatchClause node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull CharacterLiteral node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ClassInstanceCreation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull CompilationUnit node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ConditionalExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ConstructorInvocation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ContinueStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull CreationReference node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull Dimension node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull DoStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull EmptyStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull EnhancedForStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull EnumConstantDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull EnumDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ExpressionMethodReference node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ExpressionStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull FieldAccess node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull FieldDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ForStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull IfStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ImportDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull InfixExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull Initializer node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull InstanceofExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull IntersectionType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull Javadoc node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull LabeledStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull LambdaExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull LineComment node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MarkerAnnotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MemberRef node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MemberValuePair node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MethodRef node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MethodRefParameter node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MethodDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull MethodInvocation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull Modifier node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull NameQualifiedType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull NormalAnnotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull NullLiteral node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull NumberLiteral node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull PackageDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ParameterizedType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ParenthesizedExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull PostfixExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull PrefixExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull PrimitiveType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull QualifiedName node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull QualifiedType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ReturnStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SimpleName node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SimpleType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SingleMemberAnnotation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SingleVariableDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull StringLiteral node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SuperConstructorInvocation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SuperFieldAccess node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SuperMethodInvocation node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SuperMethodReference node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SwitchCase node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SwitchStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull SynchronizedStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TagElement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TextElement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ThisExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull ThrowStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TryStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TypeDeclaration node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TypeDeclarationStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TypeLiteral node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TypeMethodReference node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull TypeParameter node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull UnionType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull VariableDeclarationExpression node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull VariableDeclarationStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull VariableDeclarationFragment node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull WhileStatement node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }

   public boolean visit(@NotNull WildcardType node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      return false;
   }
}
