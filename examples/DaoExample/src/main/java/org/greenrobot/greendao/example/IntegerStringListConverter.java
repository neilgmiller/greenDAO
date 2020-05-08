/*
 * Copyright (C) 2011-2015 Markus Junginger, greenrobot (http://greenrobot.de)
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
package org.greenrobot.greendao.example;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Just a sketch how an embedded List could be done using PropertyConverter. Usually, doing a separate table is
 * preferred because the values can be indexed and queried for.
 */
public class IntegerStringListConverter implements PropertyConverter<List<Integer>, String> {
    @Override
    public List<Integer> convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        return Arrays.stream(databaseValue.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public String convertToDatabaseValue(List<Integer> entityProperty) {
        return entityProperty.stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
