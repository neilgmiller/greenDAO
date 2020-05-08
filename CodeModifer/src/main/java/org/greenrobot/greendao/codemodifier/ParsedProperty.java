package org.greenrobot.greendao.codemodifier;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 1, 5},
   bv = {1, 0, 1},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003JW\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"},
   d2 = {"Lorg/greenrobot/greendao/codemodifier/ParsedProperty;", "", "variable", "Lorg/greenrobot/greendao/codemodifier/Variable;", "id", "Lorg/greenrobot/greendao/codemodifier/EntityIdParams;", "index", "Lorg/greenrobot/greendao/codemodifier/PropertyIndex;", "isNotNull", "", "dbName", "", "customType", "Lorg/greenrobot/greendao/codemodifier/CustomType;", "unique", "(Lorg/greenrobot/greendao/codemodifier/Variable;Lorg/greenrobot/greendao/codemodifier/EntityIdParams;Lorg/greenrobot/greendao/codemodifier/PropertyIndex;ZLjava/lang/String;Lorg/greenrobot/greendao/codemodifier/CustomType;Z)V", "getCustomType", "()Lorg/greenrobot/greendao/codemodifier/CustomType;", "getDbName", "()Ljava/lang/String;", "getId", "()Lorg/greenrobot/greendao/codemodifier/EntityIdParams;", "getIndex", "()Lorg/greenrobot/greendao/codemodifier/PropertyIndex;", "()Z", "getUnique", "getVariable", "()Lorg/greenrobot/greendao/codemodifier/Variable;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "greendao-code-modifier_main"}
)
public final class ParsedProperty {
   @NotNull
   private final Variable variable;
   @Nullable
   private final EntityIdParams id;
   @Nullable
   private final PropertyIndex index;
   private final boolean isNotNull;
   @Nullable
   private final String dbName;
   @Nullable
   private final CustomType customType;
   private final boolean unique;

   @NotNull
   public final Variable getVariable() {
      return this.variable;
   }

   @Nullable
   public final EntityIdParams getId() {
      return this.id;
   }

   @Nullable
   public final PropertyIndex getIndex() {
      return this.index;
   }

   public final boolean isNotNull() {
      return this.isNotNull;
   }

   @Nullable
   public final String getDbName() {
      return this.dbName;
   }

   @Nullable
   public final CustomType getCustomType() {
      return this.customType;
   }

   public final boolean getUnique() {
      return this.unique;
   }

   public ParsedProperty(@NotNull Variable variable, @Nullable EntityIdParams id, @Nullable PropertyIndex index, boolean isNotNull, @Nullable String dbName, @Nullable CustomType customType, boolean unique) {
      Intrinsics.checkParameterIsNotNull(variable, "variable");
      super();
      this.variable = variable;
      this.id = id;
      this.index = index;
      this.isNotNull = isNotNull;
      this.dbName = dbName;
      this.customType = customType;
      this.unique = unique;
   }

   // $FF: synthetic method
   public ParsedProperty(Variable var1, EntityIdParams var2, PropertyIndex var3, boolean var4, String var5, CustomType var6, boolean var7, int var8, DefaultConstructorMarker var9) {
      if ((var8 & 2) != 0) {
         var2 = (EntityIdParams)null;
      }

      if ((var8 & 4) != 0) {
         var3 = (PropertyIndex)null;
      }

      if ((var8 & 8) != 0) {
         var4 = false;
      }

      if ((var8 & 16) != 0) {
         var5 = (String)null;
      }

      if ((var8 & 32) != 0) {
         var6 = (CustomType)null;
      }

      if ((var8 & 64) != 0) {
         var7 = false;
      }

      this(var1, var2, var3, var4, var5, var6, var7);
   }

   @NotNull
   public final Variable component1() {
      return this.variable;
   }

   @Nullable
   public final EntityIdParams component2() {
      return this.id;
   }

   @Nullable
   public final PropertyIndex component3() {
      return this.index;
   }

   public final boolean component4() {
      return this.isNotNull;
   }

   @Nullable
   public final String component5() {
      return this.dbName;
   }

   @Nullable
   public final CustomType component6() {
      return this.customType;
   }

   public final boolean component7() {
      return this.unique;
   }

   @NotNull
   public final ParsedProperty copy(@NotNull Variable variable, @Nullable EntityIdParams id, @Nullable PropertyIndex index, boolean isNotNull, @Nullable String dbName, @Nullable CustomType customType, boolean unique) {
      Intrinsics.checkParameterIsNotNull(variable, "variable");
      return new ParsedProperty(variable, id, index, isNotNull, dbName, customType, unique);
   }

   public String toString() {
      return "ParsedProperty(variable=" + this.variable + ", id=" + this.id + ", index=" + this.index + ", isNotNull=" + this.isNotNull + ", dbName=" + this.dbName + ", customType=" + this.customType + ", unique=" + this.unique + ")";
   }

   public int hashCode() {
      Variable var10000 = this.variable;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      EntityIdParams var10001 = this.id;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      PropertyIndex var2 = this.index;
      var1 = (var1 + (var2 != null ? var2.hashCode() : 0)) * 31;
      byte var3 = this.isNotNull;
      if (var3 != 0) {
         var3 = 1;
      }

      var1 = (var1 + var3) * 31;
      String var4 = this.dbName;
      var1 = (var1 + (var4 != null ? var4.hashCode() : 0)) * 31;
      CustomType var5 = this.customType;
      var1 = (var1 + (var5 != null ? var5.hashCode() : 0)) * 31;
      var3 = this.unique;
      if (var3 != 0) {
         var3 = 1;
      }

      return var1 + var3;
   }

   public boolean equals(Object var1) {
      if (this != var1) {
         if (var1 instanceof ParsedProperty) {
            ParsedProperty var2 = (ParsedProperty)var1;
            if (Intrinsics.areEqual(this.variable, var2.variable) && Intrinsics.areEqual(this.id, var2.id) && Intrinsics.areEqual(this.index, var2.index) && this.isNotNull == var2.isNotNull && Intrinsics.areEqual(this.dbName, var2.dbName) && Intrinsics.areEqual(this.customType, var2.customType) && this.unique == var2.unique) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}
