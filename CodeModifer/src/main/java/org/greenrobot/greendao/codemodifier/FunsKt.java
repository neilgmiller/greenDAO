package org.greenrobot.greendao.codemodifier;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 2,
   d1 = {"\u0000,\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¢\u0006\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0003\u001a\u0010\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\f\u001a\u001d\u0010\r\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u000e¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u0011"},
   d2 = {"logTime", "T", "action", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "parseIndexSpec", "", "Lorg/greenrobot/greendao/codemodifier/OrderProperty;", "spec", "getJavaClassNames", "Ljava/io/File;", "mostPopular", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Object;", "nullIfBlank", "greendao-code-modifier_main"}
)
public final class FunsKt {
   @NotNull
   public static final List parseIndexSpec(@NotNull String spec) {
      Intrinsics.checkParameterIsNotNull(spec, "spec");
      CharSequence var1 = (CharSequence)spec;
      boolean var19 = !StringsKt.isBlank(var1);
      if (!var19) {
         String var21 = "Index spec should not be empty";
         throw (Throwable)(new IllegalArgumentException(var21.toString()));
      } else {
         Iterable $receiver$iv = (Iterable)StringsKt.split$default((CharSequence)spec, new char[]{','}, false, 0, 6, (Object)null);
         Collection destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
         Iterator var4 = $receiver$iv.iterator();

         Object item$iv$iv;
         String columnSpec;
         while(var4.hasNext()) {
            item$iv$iv = var4.next();
            columnSpec = (String)item$iv$iv;
            if (columnSpec == null) {
               throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }

            String var18 = StringsKt.trim((CharSequence)columnSpec).toString();
            destination$iv$iv.add(var18);
         }

         $receiver$iv = (Iterable)((List)destination$iv$iv);
         destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
         var4 = $receiver$iv.iterator();

         while(var4.hasNext()) {
            item$iv$iv = var4.next();
            columnSpec = (String)item$iv$iv;
            boolean var7 = columnSpec.length() > 0;
            if (!var7) {
               String var8 = "Wrong index spec: " + spec;
               throw (Throwable)(new IllegalArgumentException(var8.toString()));
            }

            List specPair = StringsKt.split$default((CharSequence)columnSpec, new char[]{' '}, false, 0, 6, (Object)null);
            OrderProperty var10000;
            if (specPair.size() == 1) {
               var10000 = new OrderProperty((String)specPair.get(0), Order.ASC);
            } else {
               var10000 = new OrderProperty;
               String var10002 = (String)specPair.get(0);
               String var9 = (String)specPair.get(1);
               String var10 = var10002;
               OrderProperty var11 = var10000;
               OrderProperty var12 = var10000;
               if (var9 == null) {
                  throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
               }

               String var23 = ((String)var9).toUpperCase();
               Intrinsics.checkExpressionValueIsNotNull(var23, "(this as java.lang.String).toUpperCase()");
               String var13 = var23;
               var10000 = var12;
               var11.<init>(var10, Order.valueOf(var13));
            }

            OrderProperty var24 = var10000;
            destination$iv$iv.add(var24);
         }

         return (List)destination$iv$iv;
      }
   }

   @Nullable
   public static final String nullIfBlank(@NotNull String $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      return StringsKt.isBlank((CharSequence)$receiver) ? null : $receiver;
   }

   @Nullable
   public static final Object mostPopular(@NotNull Sequence $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      Map counts = (Map)(new LinkedHashMap());
      Iterator iterator$iv = $receiver.iterator();

      Object var10000;
      while(iterator$iv.hasNext()) {
         Object t = iterator$iv.next();
         var10000 = counts.get(t);
         if (var10000 == null) {
            var10000 = 0;
         }

         Object var12 = var10000;
         counts.put(t, ((Number)var12).intValue() + 1);
      }

      Sequence $receiver$iv = MapsKt.asSequence(counts);
      iterator$iv = $receiver$iv.iterator();
      if (!iterator$iv.hasNext()) {
         var10000 = null;
      } else {
         Object maxElem$iv = iterator$iv.next();
         Entry it = (Entry)maxElem$iv;
         Comparable maxValue$iv = (Comparable)((Number)it.getValue()).intValue();

         while(iterator$iv.hasNext()) {
            Object e$iv = iterator$iv.next();
            Entry it = (Entry)e$iv;
            Comparable v$iv = (Comparable)((Number)it.getValue()).intValue();
            if (maxValue$iv.compareTo(v$iv) < 0) {
               maxElem$iv = e$iv;
               maxValue$iv = v$iv;
            }
         }

         var10000 = maxElem$iv;
      }

      return (Entry)var10000 != null ? ((Entry)var10000).getKey() : null;
   }

   @NotNull
   public static final List getJavaClassNames(@NotNull File $receiver) {
      Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
      boolean var1 = $receiver.isDirectory();
      if (!var1) {
         String var14 = "The file should be a directory";
         throw (Throwable)(new IllegalArgumentException(var14.toString()));
      } else {
         Object[] $receiver$iv = (Object[])$receiver.list();
         Object[] $receiver$iv$iv = $receiver$iv;
         Collection destination$iv$iv = (Collection)(new ArrayList());

         Object item$iv$iv;
         String it;
         for(int var4 = 0; var4 < $receiver$iv$iv.length; ++var4) {
            item$iv$iv = $receiver$iv$iv[var4];
            it = (String)item$iv$iv;
            if (StringsKt.endsWith(it, ".java", true)) {
               destination$iv$iv.add(item$iv$iv);
            }
         }

         Iterable $receiver$iv = (Iterable)((List)destination$iv$iv);
         destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
         Iterator var15 = $receiver$iv.iterator();

         while(var15.hasNext()) {
            item$iv$iv = var15.next();
            it = (String)item$iv$iv;
            File var11 = new File($receiver, it);
            destination$iv$iv.add(var11);
         }

         $receiver$iv = (Iterable)((List)destination$iv$iv);
         destination$iv$iv = (Collection)(new ArrayList());
         var15 = $receiver$iv.iterator();

         File it;
         while(var15.hasNext()) {
            item$iv$iv = var15.next();
            it = (File)item$iv$iv;
            if (it.isFile()) {
               destination$iv$iv.add(item$iv$iv);
            }
         }

         $receiver$iv = (Iterable)((List)destination$iv$iv);
         destination$iv$iv = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)));
         var15 = $receiver$iv.iterator();

         while(var15.hasNext()) {
            item$iv$iv = var15.next();
            it = (File)item$iv$iv;
            String var17 = FilesKt.getNameWithoutExtension(it);
            destination$iv$iv.add(var17);
         }

         return (List)destination$iv$iv;
      }
   }

   public static final Object logTime(@NotNull String action, @NotNull Function0 block) {
      Intrinsics.checkParameterIsNotNull(action, "action");
      Intrinsics.checkParameterIsNotNull(block, "block");
      long start = System.currentTimeMillis();
      Object result = block.invoke();
      long time = System.currentTimeMillis() - start;
      String var8 = action + " took " + time + " ms";
      System.out.println(var8);
      return result;
   }
}
