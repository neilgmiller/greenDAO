package org.greenrobot.greendao.daotest;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEST_ENTITY".
*/
public class TestEntityDao extends AbstractDao<TestEntity, Long> {

    public static final String TABLENAME = "TEST_ENTITY";

    /**
     * Properties of entity TestEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property<Long, Long> Id = new Property<>(0, Long.class, Long.class, "id", true, "_id", null);
        public final static Property<Integer, Integer> SimpleInt = new Property<>(1, int.class, int.class, "simpleInt", false, "SIMPLE_INT", null);
        public final static Property<Integer, Integer> SimpleInteger = new Property<>(2, Integer.class, Integer.class, "simpleInteger", false, "SIMPLE_INTEGER", null);
        public final static Property<String, String> SimpleStringNotNull = new Property<>(3, String.class, String.class, "simpleStringNotNull", false, "SIMPLE_STRING_NOT_NULL", null);
        public final static Property<String, String> SimpleString = new Property<>(4, String.class, String.class, "simpleString", false, "SIMPLE_STRING", null);
        public final static Property<String, String> IndexedString = new Property<>(5, String.class, String.class, "indexedString", false, "INDEXED_STRING", null);
        public final static Property<String, String> IndexedStringAscUnique = new Property<>(6, String.class, String.class, "indexedStringAscUnique", false, "INDEXED_STRING_ASC_UNIQUE", null);
        public final static Property<java.util.Date, java.util.Date> SimpleDate = new Property<>(7, java.util.Date.class, java.util.Date.class, "simpleDate", false, "SIMPLE_DATE", null);
        public final static Property<Boolean, Boolean> SimpleBoolean = new Property<>(8, Boolean.class, Boolean.class, "simpleBoolean", false, "SIMPLE_BOOLEAN", null);
        public final static Property<byte[], byte[]> SimpleByteArray = new Property<>(9, byte[].class, byte[].class, "simpleByteArray", false, "SIMPLE_BYTE_ARRAY", null);
    }


    public TestEntityDao(DaoConfig config) {
        super(config);
    }
    
    public TestEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEST_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SIMPLE_INT\" INTEGER NOT NULL ," + // 1: simpleInt
                "\"SIMPLE_INTEGER\" INTEGER," + // 2: simpleInteger
                "\"SIMPLE_STRING_NOT_NULL\" TEXT NOT NULL ," + // 3: simpleStringNotNull
                "\"SIMPLE_STRING\" TEXT," + // 4: simpleString
                "\"INDEXED_STRING\" TEXT," + // 5: indexedString
                "\"INDEXED_STRING_ASC_UNIQUE\" TEXT," + // 6: indexedStringAscUnique
                "\"SIMPLE_DATE\" INTEGER," + // 7: simpleDate
                "\"SIMPLE_BOOLEAN\" INTEGER," + // 8: simpleBoolean
                "\"SIMPLE_BYTE_ARRAY\" BLOB);"); // 9: simpleByteArray
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_TEST_ENTITY_INDEXED_STRING ON \"TEST_ENTITY\"" +
                " (\"INDEXED_STRING\");");
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_TEST_ENTITY_INDEXED_STRING_ASC_UNIQUE ON \"TEST_ENTITY\"" +
                " (\"INDEXED_STRING_ASC_UNIQUE\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEST_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TestEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getSimpleInt());
 
        Integer simpleInteger = entity.getSimpleInteger();
        if (simpleInteger != null) {
            stmt.bindLong(3, simpleInteger);
        }
        stmt.bindString(4, entity.getSimpleStringNotNull());
 
        String simpleString = entity.getSimpleString();
        if (simpleString != null) {
            stmt.bindString(5, simpleString);
        }
 
        String indexedString = entity.getIndexedString();
        if (indexedString != null) {
            stmt.bindString(6, indexedString);
        }
 
        String indexedStringAscUnique = entity.getIndexedStringAscUnique();
        if (indexedStringAscUnique != null) {
            stmt.bindString(7, indexedStringAscUnique);
        }
 
        java.util.Date simpleDate = entity.getSimpleDate();
        if (simpleDate != null) {
            stmt.bindLong(8, simpleDate.getTime());
        }
 
        Boolean simpleBoolean = entity.getSimpleBoolean();
        if (simpleBoolean != null) {
            stmt.bindLong(9, simpleBoolean ? 1L: 0L);
        }
 
        byte[] simpleByteArray = entity.getSimpleByteArray();
        if (simpleByteArray != null) {
            stmt.bindBlob(10, simpleByteArray);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TestEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getSimpleInt());
 
        Integer simpleInteger = entity.getSimpleInteger();
        if (simpleInteger != null) {
            stmt.bindLong(3, simpleInteger);
        }
        stmt.bindString(4, entity.getSimpleStringNotNull());
 
        String simpleString = entity.getSimpleString();
        if (simpleString != null) {
            stmt.bindString(5, simpleString);
        }
 
        String indexedString = entity.getIndexedString();
        if (indexedString != null) {
            stmt.bindString(6, indexedString);
        }
 
        String indexedStringAscUnique = entity.getIndexedStringAscUnique();
        if (indexedStringAscUnique != null) {
            stmt.bindString(7, indexedStringAscUnique);
        }
 
        java.util.Date simpleDate = entity.getSimpleDate();
        if (simpleDate != null) {
            stmt.bindLong(8, simpleDate.getTime());
        }
 
        Boolean simpleBoolean = entity.getSimpleBoolean();
        if (simpleBoolean != null) {
            stmt.bindLong(9, simpleBoolean ? 1L: 0L);
        }
 
        byte[] simpleByteArray = entity.getSimpleByteArray();
        if (simpleByteArray != null) {
            stmt.bindBlob(10, simpleByteArray);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TestEntity readEntity(Cursor cursor, int offset) {
        TestEntity entity = new TestEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // simpleInt
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // simpleInteger
            cursor.getString(offset + 3), // simpleStringNotNull
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // simpleString
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // indexedString
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // indexedStringAscUnique
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // simpleDate
            cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0, // simpleBoolean
            cursor.isNull(offset + 9) ? null : cursor.getBlob(offset + 9) // simpleByteArray
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TestEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSimpleInt(cursor.getInt(offset + 1));
        entity.setSimpleInteger(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setSimpleStringNotNull(cursor.getString(offset + 3));
        entity.setSimpleString(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIndexedString(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setIndexedStringAscUnique(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSimpleDate(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setSimpleBoolean(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setSimpleByteArray(cursor.isNull(offset + 9) ? null : cursor.getBlob(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TestEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TestEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TestEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
