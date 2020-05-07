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
 * DAO for table "SIMPLE_ENTITY".
*/
public class SimpleEntityDao extends AbstractDao<SimpleEntity, Long> {

    public static final String TABLENAME = "SIMPLE_ENTITY";

    /**
     * Properties of entity SimpleEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property<Long, Long> Id = new Property<>(0, Long.class, Long.class, "id", true, "_id", null);
        public final static Property<Boolean, Boolean> SimpleBoolean = new Property<>(1, Boolean.class, Boolean.class, "simpleBoolean", false, "SIMPLE_BOOLEAN", null);
        public final static Property<Byte, Byte> SimpleByte = new Property<>(2, Byte.class, Byte.class, "simpleByte", false, "SIMPLE_BYTE", null);
        public final static Property<Short, Short> SimpleShort = new Property<>(3, Short.class, Short.class, "simpleShort", false, "SIMPLE_SHORT", null);
        public final static Property<Integer, Integer> SimpleInt = new Property<>(4, Integer.class, Integer.class, "simpleInt", false, "SIMPLE_INT", null);
        public final static Property<Long, Long> SimpleLong = new Property<>(5, Long.class, Long.class, "simpleLong", false, "SIMPLE_LONG", null);
        public final static Property<Float, Float> SimpleFloat = new Property<>(6, Float.class, Float.class, "simpleFloat", false, "SIMPLE_FLOAT", null);
        public final static Property<Double, Double> SimpleDouble = new Property<>(7, Double.class, Double.class, "simpleDouble", false, "SIMPLE_DOUBLE", null);
        public final static Property<String, String> SimpleString = new Property<>(8, String.class, String.class, "simpleString", false, "SIMPLE_STRING", null);
        public final static Property<byte[], byte[]> SimpleByteArray = new Property<>(9, byte[].class, byte[].class, "simpleByteArray", false, "SIMPLE_BYTE_ARRAY", null);
    }


    public SimpleEntityDao(DaoConfig config) {
        super(config);
    }
    
    public SimpleEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SIMPLE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SIMPLE_BOOLEAN\" INTEGER," + // 1: simpleBoolean
                "\"SIMPLE_BYTE\" INTEGER," + // 2: simpleByte
                "\"SIMPLE_SHORT\" INTEGER," + // 3: simpleShort
                "\"SIMPLE_INT\" INTEGER," + // 4: simpleInt
                "\"SIMPLE_LONG\" INTEGER," + // 5: simpleLong
                "\"SIMPLE_FLOAT\" REAL," + // 6: simpleFloat
                "\"SIMPLE_DOUBLE\" REAL," + // 7: simpleDouble
                "\"SIMPLE_STRING\" TEXT," + // 8: simpleString
                "\"SIMPLE_BYTE_ARRAY\" BLOB);"); // 9: simpleByteArray
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SIMPLE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SimpleEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Boolean simpleBoolean = entity.getSimpleBoolean();
        if (simpleBoolean != null) {
            stmt.bindLong(2, simpleBoolean ? 1L: 0L);
        }
 
        Byte simpleByte = entity.getSimpleByte();
        if (simpleByte != null) {
            stmt.bindLong(3, simpleByte);
        }
 
        Short simpleShort = entity.getSimpleShort();
        if (simpleShort != null) {
            stmt.bindLong(4, simpleShort);
        }
 
        Integer simpleInt = entity.getSimpleInt();
        if (simpleInt != null) {
            stmt.bindLong(5, simpleInt);
        }
 
        Long simpleLong = entity.getSimpleLong();
        if (simpleLong != null) {
            stmt.bindLong(6, simpleLong);
        }
 
        Float simpleFloat = entity.getSimpleFloat();
        if (simpleFloat != null) {
            stmt.bindDouble(7, simpleFloat);
        }
 
        Double simpleDouble = entity.getSimpleDouble();
        if (simpleDouble != null) {
            stmt.bindDouble(8, simpleDouble);
        }
 
        String simpleString = entity.getSimpleString();
        if (simpleString != null) {
            stmt.bindString(9, simpleString);
        }
 
        byte[] simpleByteArray = entity.getSimpleByteArray();
        if (simpleByteArray != null) {
            stmt.bindBlob(10, simpleByteArray);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SimpleEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Boolean simpleBoolean = entity.getSimpleBoolean();
        if (simpleBoolean != null) {
            stmt.bindLong(2, simpleBoolean ? 1L: 0L);
        }
 
        Byte simpleByte = entity.getSimpleByte();
        if (simpleByte != null) {
            stmt.bindLong(3, simpleByte);
        }
 
        Short simpleShort = entity.getSimpleShort();
        if (simpleShort != null) {
            stmt.bindLong(4, simpleShort);
        }
 
        Integer simpleInt = entity.getSimpleInt();
        if (simpleInt != null) {
            stmt.bindLong(5, simpleInt);
        }
 
        Long simpleLong = entity.getSimpleLong();
        if (simpleLong != null) {
            stmt.bindLong(6, simpleLong);
        }
 
        Float simpleFloat = entity.getSimpleFloat();
        if (simpleFloat != null) {
            stmt.bindDouble(7, simpleFloat);
        }
 
        Double simpleDouble = entity.getSimpleDouble();
        if (simpleDouble != null) {
            stmt.bindDouble(8, simpleDouble);
        }
 
        String simpleString = entity.getSimpleString();
        if (simpleString != null) {
            stmt.bindString(9, simpleString);
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
    public SimpleEntity readEntity(Cursor cursor, int offset) {
        SimpleEntity entity = new SimpleEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0, // simpleBoolean
            cursor.isNull(offset + 2) ? null : (byte) cursor.getShort(offset + 2), // simpleByte
            cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3), // simpleShort
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // simpleInt
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5), // simpleLong
            cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6), // simpleFloat
            cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7), // simpleDouble
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // simpleString
            cursor.isNull(offset + 9) ? null : cursor.getBlob(offset + 9) // simpleByteArray
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SimpleEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSimpleBoolean(cursor.isNull(offset + 1) ? null : cursor.getShort(offset + 1) != 0);
        entity.setSimpleByte(cursor.isNull(offset + 2) ? null : (byte) cursor.getShort(offset + 2));
        entity.setSimpleShort(cursor.isNull(offset + 3) ? null : cursor.getShort(offset + 3));
        entity.setSimpleInt(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setSimpleLong(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setSimpleFloat(cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6));
        entity.setSimpleDouble(cursor.isNull(offset + 7) ? null : cursor.getDouble(offset + 7));
        entity.setSimpleString(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSimpleByteArray(cursor.isNull(offset + 9) ? null : cursor.getBlob(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SimpleEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SimpleEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SimpleEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
