package org.greenrobot.greendao.codemodifier;

import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eclipse.jdt.core.dom.CompilationUnit;
import org.greenrobot.eclipse.jdt.core.dom.LineComment;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/KeepCommentVisitor;", "Lorg/greenrobot/greendao/codemodifier/LazyVisitor;", "entityUnit", "Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "sourceSplit", "", "", "(Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;Ljava/util/List;)V", "getEntityUnit", "()Lorg/greenrobot/eclipse/jdt/core/dom/CompilationUnit;", "keepFieldsEndLineNumber", "", "getKeepFieldsEndLineNumber", "()I", "setKeepFieldsEndLineNumber", "(I)V", "keepFieldsStartLineNumber", "getKeepFieldsStartLineNumber", "setKeepFieldsStartLineNumber", "getSourceSplit", "()Ljava/util/List;", "validateLineNumbers", "", "visit", "", "node", "Lorg/greenrobot/eclipse/jdt/core/dom/LineComment;", "greendao-code-modifier_main"}
)
public final class KeepCommentVisitor extends LazyVisitor {
   private int keepFieldsStartLineNumber;
   private int keepFieldsEndLineNumber;
   @NotNull
   private final CompilationUnit entityUnit;
   @NotNull
   private final List sourceSplit;

   public final int getKeepFieldsStartLineNumber() {
      return this.keepFieldsStartLineNumber;
   }

   public final void setKeepFieldsStartLineNumber(int var1) {
      this.keepFieldsStartLineNumber = var1;
   }

   public final int getKeepFieldsEndLineNumber() {
      return this.keepFieldsEndLineNumber;
   }

   public final void setKeepFieldsEndLineNumber(int var1) {
      this.keepFieldsEndLineNumber = var1;
   }

   public boolean visit(@NotNull LineComment node) {
      Intrinsics.checkParameterIsNotNull(node, "node");
      int lineNumber = this.entityUnit.getLineNumber(node.getStartPosition());
      String var4 = (String)this.sourceSplit.get(lineNumber - 1);
      if (var4 == null) {
         throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
      } else {
         String lineComment = StringsKt.trim((CharSequence)var4).toString();
         if (StringsKt.startsWith$default(lineComment, "// KEEP FIELDS END", false, 2, (Object)null)) {
            this.keepFieldsEndLineNumber = lineNumber;
         } else if (StringsKt.startsWith$default(lineComment, "// KEEP FIELDS", false, 2, (Object)null)) {
            this.keepFieldsStartLineNumber = lineNumber;
         }

         return false;
      }
   }

   public final void validateLineNumbers() {
      if (this.keepFieldsStartLineNumber == -1 || this.keepFieldsEndLineNumber == -1 || this.keepFieldsEndLineNumber < this.keepFieldsStartLineNumber) {
         this.keepFieldsStartLineNumber = -1;
         this.keepFieldsEndLineNumber = -1;
      }

   }

   @NotNull
   public final CompilationUnit getEntityUnit() {
      return this.entityUnit;
   }

   @NotNull
   public final List getSourceSplit() {
      return this.sourceSplit;
   }

   public KeepCommentVisitor(@NotNull CompilationUnit entityUnit, @NotNull List sourceSplit) {
      Intrinsics.checkParameterIsNotNull(entityUnit, "entityUnit");
      Intrinsics.checkParameterIsNotNull(sourceSplit, "sourceSplit");
      super();
      this.entityUnit = entityUnit;
      this.sourceSplit = sourceSplit;
      this.keepFieldsStartLineNumber = -1;
      this.keepFieldsEndLineNumber = -1;
   }
}
