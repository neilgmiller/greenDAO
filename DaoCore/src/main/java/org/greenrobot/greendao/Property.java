/*
 * Copyright (C) 2011-2016 Markus Junginger, greenrobot (http://greenrobot.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.greenrobot.greendao;

import org.greenrobot.greendao.converter.PropertyConverter;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.WhereCondition;
import org.greenrobot.greendao.query.WhereCondition.PropertyCondition;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * Meta data describing a property mapped to a database column; used to create WhereCondition object used by the query builder.
 * 
 * @author Markus
 */
public class Property<T, D> {
    public final int ordinal;
    public final Class<D> type;
    public final String name;
    public final boolean primaryKey;
    public final String columnName;
    @Nullable
    private final PropertyConverter<T, D> propertyConverter;

    public Property(int ordinal, Class<D> type, String name, boolean primaryKey, String columnName, @Nullable PropertyConverter<T, D> propertyConverter) {
        this.ordinal = ordinal;
        this.type = type;
        this.name = name;
        this.primaryKey = primaryKey;
        this.columnName = columnName;
        this.propertyConverter = propertyConverter;
    }

    /** Creates an "equal ('=')" condition  for this property. */
    public WhereCondition eq(T value) {
        return new PropertyCondition(this, "=?", convert(value));
    }

    /** Creates an "not equal ('<>')" condition  for this property. */
    public WhereCondition notEq(T value) {
        return new PropertyCondition(this, "<>?", convert(value));
    }

    /** Creates an "LIKE" condition  for this property. */
    public WhereCondition like(String value) {
        return new PropertyCondition(this, " LIKE ?", value);
    }

    /** Creates an "BETWEEN ... AND ..." condition  for this property. */
    public WhereCondition between(T value1, T value2) {
        Object[] values = { convert(value1), convert(value2) };
        return new PropertyCondition(this, " BETWEEN ? AND ?", values);
    }

    /** Creates an "IN (..., ..., ...)" condition  for this property. */
    public WhereCondition in(T... inValues) {
        StringBuilder condition = new StringBuilder(" IN (");
        SqlUtils.appendPlaceholders(condition, inValues.length).append(')');
        return new PropertyCondition(this, condition.toString(), convert(inValues));
    }

    /** Creates an "IN (..., ..., ...)" condition  for this property. */
    public WhereCondition in(Collection<T> inValues) {
        //noinspection unchecked
        return in((T[])inValues.toArray());
    }

    /** Creates an "NOT IN (..., ..., ...)" condition  for this property. */
    public WhereCondition notIn(T... notInValues) {
        StringBuilder condition = new StringBuilder(" NOT IN (");
        SqlUtils.appendPlaceholders(condition, notInValues.length).append(')');
        return new PropertyCondition(this, condition.toString(), convert(notInValues));
    }

    /** Creates an "NOT IN (..., ..., ...)" condition  for this property. */
    public WhereCondition notIn(Collection<T> notInValues) {
        //noinspection unchecked
        return notIn((T[])notInValues.toArray());
    }

    /** Creates an "greater than ('>')" condition  for this property. */
    public WhereCondition gt(T value) {
        return new PropertyCondition(this, ">?", convert(value));
    }

    /** Creates an "less than ('<')" condition  for this property. */
    public WhereCondition lt(T value) {
        return new PropertyCondition(this, "<?", convert(value));
    }

    /** Creates an "greater or equal ('>=')" condition  for this property. */
    public WhereCondition ge(T value) {
        return new PropertyCondition(this, ">=?", convert(value));
    }

    /** Creates an "less or equal ('<=')" condition  for this property. */
    public WhereCondition le(T value) {
        return new PropertyCondition(this, "<=?", convert(value));
    }

    /** Creates an "IS NULL" condition  for this property. */
    public WhereCondition isNull() {
        return new PropertyCondition(this, " IS NULL");
    }

    /** Creates an "IS NOT NULL" condition  for this property. */
    public WhereCondition isNotNull() {
        return new PropertyCondition(this, " IS NOT NULL");
    }

    public T convertToEntityProperty(D databaseValue) {
        return propertyConverter.convertToEntityProperty(databaseValue);
    }

    public D convertToDatabaseValue(T entityProperty) {
        return propertyConverter.convertToDatabaseValue(entityProperty);
    }

    private D convert(T value) {
        if (type.isInstance(value)) {
            return type.cast(value);
        } else {
            return propertyConverter.convertToDatabaseValue(value);
        }
    }

    private D[] convert(T[] values) {
        if (values.length == 0) {
            //noinspection unchecked
            return (D[]) new Object[0];
        } else {
            //noinspection unchecked
            D[] convertedValues = (D[]) new Object[values.length];
            if (type.isInstance(values[0])) {
                for (int i = 0; i < values.length; i++) {
                    convertedValues[i] = type.cast(values[i]);
                }
            } else {
                for (int i = 0; i < values.length; i++) {
                    convertedValues[i] = propertyConverter.convertToDatabaseValue(values[i]);
                }
            }
            return convertedValues;
        }
    }
}
