package org.greenrobot.greendao.codemodifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/Formatting;", "", "tabulation", "Lorg/greenrobot/greendao/codemodifier/Tabulation;", "lineWidth", "", "(Lorg/greenrobot/greendao/codemodifier/Tabulation;I)V", "getLineWidth", "()I", "getTabulation", "()Lorg/greenrobot/greendao/codemodifier/Tabulation;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "greendao-code-modifier_main"}
)
public final class Formatting {
   @NotNull
   private final Tabulation tabulation;
   private final int lineWidth;
   public static final Formatting.Companion Companion = new Formatting.Companion((DefaultConstructorMarker)null);

   @NotNull
   public final Tabulation getTabulation() {
      return this.tabulation;
   }

   public final int getLineWidth() {
      return this.lineWidth;
   }

   public Formatting(@NotNull Tabulation tabulation, int lineWidth) {
      Intrinsics.checkParameterIsNotNull(tabulation, "tabulation");
      super();
      this.tabulation = tabulation;
      this.lineWidth = lineWidth;
   }

   @NotNull
   public final Tabulation component1() {
      return this.tabulation;
   }

   public final int component2() {
      return this.lineWidth;
   }

   @NotNull
   public final Formatting copy(@NotNull Tabulation tabulation, int lineWidth) {
      Intrinsics.checkParameterIsNotNull(tabulation, "tabulation");
      return new Formatting(tabulation, lineWidth);
   }

   public String toString() {
      return "Formatting(tabulation=" + this.tabulation + ", lineWidth=" + this.lineWidth + ")";
   }

   public int hashCode() {
      Tabulation var10000 = this.tabulation;
      return (var10000 != null ? var10000.hashCode() : 0) * 31 + this.lineWidth;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof Formatting) {
            Formatting var2 = (Formatting)var1;
            if (Intrinsics.areEqual(this.tabulation, var2.tabulation) && this.lineWidth == var2.lineWidth) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @Metadata(
      mv = {1, 1, 5},
      bv = {1, 0, 1},
      k = 1,
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bJ$\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n¨\u0006\u000f"},
      d2 = {"Lorg/greenrobot/greendao/codemodifier/Formatting$Companion;", "", "()V", "detect", "Lorg/greenrobot/greendao/codemodifier/Formatting;", "text", "", "options", "Lorg/greenrobot/greendao/codemodifier/FormattingOptions;", "detectTabLength", "", "tabLengths", "", "defaultLength", "min", "greendao-code-modifier_main"}
   )
   public static final class Companion {
      @NotNull
      public final Formatting detect(@NotNull String text, @Nullable FormattingOptions options) {
         List lines;
         int var36;
         label172: {
            Intrinsics.checkParameterIsNotNull(text, "text");
            lines = StringsKt.lines((CharSequence)text);
            if (options != null) {
               Integer var10000 = options.getLineWidth();
               if (var10000 != null) {
                  var36 = var10000.intValue();
                  break label172;
               }
            }

            Integer var10001 = (Integer)SequencesKt.max(SequencesKt.map(CollectionsKt.asSequence((Iterable)lines), (Function1)null.INSTANCE));
            var36 = Math.max(80, Math.round((float)(var10001 != null ? var10001.intValue() : 0) / 10.0F) * 10);
         }

         int lineWidth;
         Tabulation var38;
         label173: {
            lineWidth = var36;
            if (options != null) {
               var38 = options.getTabulation();
               if (var38 != null) {
                  break label173;
               }
            }

            Formatting.Companion $receiver = (Formatting.Companion)this;
            Iterable $receiver$iv = (Iterable)lines;
            Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
            Iterator var11 = $receiver$iv.iterator();

            Object element$iv;
            String $receiver$iv;
            int index$iv;
            Integer var20;
            String var39;
            while(var11.hasNext()) {
               label196: {
                  element$iv = var11.next();
                  String line = (String)element$iv;
                  $receiver$iv = line;
                  int index$iv = 0;
                  index$iv = line.length() - 1;
                  if (index$iv <= index$iv) {
                     while(true) {
                        char it = $receiver$iv.charAt(index$iv);
                        if (it != ' ') {
                           byte var19 = 0;
                           if ($receiver$iv == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           var39 = ((String)$receiver$iv).substring(var19, index$iv);
                           Intrinsics.checkExpressionValueIsNotNull(var39, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                           break label196;
                        }

                        if (index$iv == index$iv) {
                           break;
                        }

                        ++index$iv;
                     }
                  }

                  var39 = $receiver$iv;
               }

               var20 = var39.length();
               destination$iv$iv.add(var20);
            }

            $receiver$iv = (Iterable)((List)destination$iv$iv);
            destination$iv$iv = (Collection)(new ArrayList());
            var11 = $receiver$iv.iterator();

            int it;
            while(var11.hasNext()) {
               element$iv = var11.next();
               it = ((Number)element$iv).intValue();
               if (it > 1) {
                  destination$iv$iv.add(element$iv);
               }
            }

            List spaces = (List)destination$iv$iv;
            Iterable $receiver$iv = (Iterable)lines;
            Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
            Iterator var32 = $receiver$iv.iterator();

            Object element$iv$iv;
            while(var32.hasNext()) {
               label197: {
                  element$iv$iv = var32.next();
                  $receiver$iv = (String)element$iv$iv;
                  String $receiver$iv = $receiver$iv;
                  index$iv = 0;
                  int var40 = $receiver$iv.length() - 1;
                  if (index$iv <= var40) {
                     while(true) {
                        char it = $receiver$iv.charAt(index$iv);
                        if (it != '\t') {
                           byte var22 = 0;
                           if ($receiver$iv == null) {
                              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                           }

                           var39 = ((String)$receiver$iv).substring(var22, index$iv);
                           Intrinsics.checkExpressionValueIsNotNull(var39, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                           break label197;
                        }

                        if (index$iv == var40) {
                           break;
                        }

                        ++index$iv;
                     }
                  }

                  var39 = $receiver$iv;
               }

               var20 = var39.length();
               destination$iv$iv.add(var20);
            }

            $receiver$iv = (Iterable)((List)destination$iv$iv);
            destination$iv$iv = (Collection)(new ArrayList());
            var32 = $receiver$iv.iterator();

            while(var32.hasNext()) {
               element$iv$iv = var32.next();
               int it = ((Number)element$iv$iv).intValue();
               if (it > 0) {
                  destination$iv$iv.add(element$iv$iv);
               }
            }

            List tabs = (List)destination$iv$iv;
            $receiver$iv = (Iterable)spaces;
            int count$iv = 0;
            var11 = $receiver$iv.iterator();

            while(var11.hasNext()) {
               element$iv = var11.next();
               it = ((Number)element$iv).intValue();
               if (it > 0) {
                  ++count$iv;
               }
            }

            $receiver$iv = (Iterable)tabs;
            int var14 = count$iv;
            count$iv = 0;
            var11 = $receiver$iv.iterator();

            while(var11.hasNext()) {
               element$iv = var11.next();
               it = ((Number)element$iv).intValue();
               if (it > 0) {
                  ++count$iv;
               }
            }

            int tabSize;
            if (var14 > count$iv) {
               tabSize = $receiver.detectTabLength(spaces, 4, 2);
               var38 = new Tabulation(' ', tabSize);
            } else {
               tabSize = $receiver.detectTabLength(tabs, 1, 1);
               var38 = new Tabulation('\t', tabSize);
            }

            var38 = (Tabulation)var38;
         }

         Tabulation tabulation = var38;
         return new Formatting(tabulation, lineWidth);
      }

      public final int detectTabLength(@NotNull final List tabLengths, int defaultLength, final int min) {
         Intrinsics.checkParameterIsNotNull(tabLengths, "tabLengths");
         Integer var10000 = (Integer)FunsKt.mostPopular(SequencesKt.filter(SequencesKt.mapIndexed(CollectionsKt.asSequence((Iterable)tabLengths), (Function2)(new Function2() {
            public final int invoke(int index, int tab) {
               return index == 0 ? tab : tab - ((Number)tabLengths.get(index - 1)).intValue();
            }
         })), (Function1)(new Function1() {
            public final boolean invoke(int it) {
               return it >= min;
            }
         })));
         return var10000 != null ? var10000.intValue() : defaultLength;
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
