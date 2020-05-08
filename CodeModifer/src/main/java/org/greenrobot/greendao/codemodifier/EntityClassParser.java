package org.greenrobot.greendao.codemodifier;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eclipse.core.runtime.IProgressMonitor;
import org.greenrobot.eclipse.jdt.core.compiler.IProblem;
import org.greenrobot.eclipse.jdt.core.dom.ASTNode;
import org.greenrobot.eclipse.jdt.core.dom.ASTParser;
import org.greenrobot.eclipse.jdt.core.dom.ASTVisitor;
import org.greenrobot.eclipse.jdt.core.dom.Comment;
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/EntityClassParser;", "", "jdtOptions", "Ljava/util/Hashtable;", "", "encoding", "(Ljava/util/Hashtable;Ljava/lang/String;)V", "getEncoding", "()Ljava/lang/String;", "getJdtOptions", "()Ljava/util/Hashtable;", "parse", "Lorg/greenrobot/greendao/codemodifier/ParsedEntity;", "javaFile", "Ljava/io/File;", "classesInPackage", "", "Companion", "greendao-code-modifier_main"}
)
public final class EntityClassParser {
   @NotNull
   private final Hashtable jdtOptions;
   @NotNull
   private final String encoding;
   private static final int AST_PARSER_LEVEL = 8;
   @NotNull
   private static final int[] ignoredProblemIds = new int[]{16777218, 570425394, 33554502, 33554515, 67108964, 67108984, 134217857, 67109135, 268435846, 67109264, 16777541, 536871543, 67109498};
   public static final EntityClassParser.Companion Companion = new EntityClassParser.Companion((DefaultConstructorMarker)null);

   @Nullable
   public final ParsedEntity parse(@NotNull File javaFile, @NotNull List classesInPackage) {
      Intrinsics.checkParameterIsNotNull(javaFile, "javaFile");
      Intrinsics.checkParameterIsNotNull(classesInPackage, "classesInPackage");
      String var4 = this.encoding;
      Charset var10000 = Charset.forName(var4);
      Intrinsics.checkExpressionValueIsNotNull(var10000, "Charset.forName(charsetName)");
      Charset var19 = var10000;
      String source = FilesKt.readText(javaFile, var19);
      ASTParser parser = ASTParser.newParser(Companion.getAST_PARSER_LEVEL());
      parser.setCompilerOptions((Map)this.jdtOptions);
      parser.setKind(8);
      Object[] var40 = (Object[])(new String[0]);
      String[] var41 = (String[])var40;
      Object[] var20 = (Object[])(new String[0]);
      parser.setEnvironment(var41, (String[])var20, (String[])null, true);
      parser.setUnitName("/" + javaFile.getPath());
      parser.setBindingsRecovery(true);
      parser.setResolveBindings(true);
      if (source == null) {
         throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      } else {
         char[] var35 = ((String)source).toCharArray();
         Intrinsics.checkExpressionValueIsNotNull(var35, "(this as java.lang.String).toCharArray()");
         char[] var42 = var35;
         parser.setSource(var42);
         ASTNode var36 = parser.createAST((IProgressMonitor)null);
         if (var36 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.greenrobot.eclipse.jdt.core.dom.CompilationUnit");
         } else {
            CompilationUnit astRoot = (CompilationUnit)var36;
            IProblem[] var37 = astRoot.getProblems();
            Object element$iv$iv;
            List var38;
            if (var37 != null) {
               Object[] $receiver$iv = (Object[])var37;
               Object[] $receiver$iv$iv = $receiver$iv;
               Collection destination$iv$iv = (Collection)(new ArrayList());

               for(int var10 = 0; var10 < $receiver$iv$iv.length; ++var10) {
                  element$iv$iv = $receiver$iv$iv[var10];
                  IProblem it = (IProblem)element$iv$iv;
                  int problemId = it.getID();
                  boolean keep = Companion.shouldReportProblem(problemId);
                  if (!keep) {
                     System.out.println("[Verbose] Ignoring parser problem in " + javaFile + ":" + it.getSourceLineNumber() + ": " + it + ".");
                  }

                  if (keep) {
                     destination$iv$iv.add(element$iv$iv);
                  }
               }

               var38 = (List)destination$iv$iv;
            } else {
               var38 = null;
            }

            List problems = var38;
            if (problems != null) {
               Collection var22 = (Collection)problems;
               if (!var22.isEmpty()) {
                  System.err.println("Found " + problems.size() + " problem(s) parsing " + "\"" + javaFile + "\"" + ":");
                  Iterable $receiver$iv = (Iterable)problems;
                  int index$iv = 0;
                  Iterator var30 = $receiver$iv.iterator();

                  while(var30.hasNext()) {
                     Object item$iv = var30.next();
                     int var39 = index$iv++;
                     IProblem problem = (IProblem)item$iv;
                     int i = var39;
                     System.err.println("#" + (i + 1) + " @" + problem.getSourceLineNumber() + ": " + problem + " (ID: " + problem.getID() + "; error: " + problem.isError() + ")");
                  }

                  IProblem first = (IProblem)problems.get(0);
                  throw (Throwable)(new RuntimeException("Found " + problems.size() + " problem(s) parsing " + "\"" + javaFile + "\"" + ". First problem:" + "\n" + first + " (" + first.getID() + " at line " + first.getSourceLineNumber() + ")." + "\n" + "Run gradle with --info for more details."));
               }
            }

            KeepCommentVisitor commentVisitor = new KeepCommentVisitor(astRoot, StringsKt.split$default((CharSequence)source, new String[]{"\n"}, false, 0, 6, (Object)null));
            List commentList = astRoot.getCommentList();
            Iterable $receiver$iv = (Iterable)commentList;
            Iterator var31 = $receiver$iv.iterator();

            while(var31.hasNext()) {
               element$iv$iv = var31.next();
               if (element$iv$iv instanceof Comment) {
                  ((Comment)element$iv$iv).accept((ASTVisitor)commentVisitor);
               }
            }

            commentVisitor.validateLineNumbers();
            EntityClassASTVisitor visitor = new EntityClassASTVisitor(source, classesInPackage, commentVisitor.getKeepFieldsStartLineNumber(), commentVisitor.getKeepFieldsEndLineNumber());
            astRoot.accept((ASTVisitor)visitor);
            return visitor.createParsedEntity(javaFile, source);
         }
      }
   }

   @NotNull
   public final Hashtable getJdtOptions() {
      return this.jdtOptions;
   }

   @NotNull
   public final String getEncoding() {
      return this.encoding;
   }

   public EntityClassParser(@NotNull Hashtable jdtOptions, @NotNull String encoding) {
      Intrinsics.checkParameterIsNotNull(jdtOptions, "jdtOptions");
      Intrinsics.checkParameterIsNotNull(encoding, "encoding");
      super();
      this.jdtOptions = jdtOptions;
      this.encoding = encoding;
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/EntityClassParser$Companion;", "", "()V", "AST_PARSER_LEVEL", "", "getAST_PARSER_LEVEL", "()I", "ignoredProblemIds", "", "getIgnoredProblemIds", "()[I", "shouldReportProblem", "", "problemId", "greendao-code-modifier_main"}
   )
   public static final class Companion {
      public final int getAST_PARSER_LEVEL() {
         return EntityClassParser.AST_PARSER_LEVEL;
      }

      @NotNull
      public final int[] getIgnoredProblemIds() {
         return EntityClassParser.ignoredProblemIds;
      }

      public final boolean shouldReportProblem(int problemId) {
         return !ArraysKt.contains(((EntityClassParser.Companion)this).getIgnoredProblemIds(), problemId);
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
