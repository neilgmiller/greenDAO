package org.greenrobot.greendao.daotest2.to1_specialdao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import org.greenrobot.greendao.daotest2.dao.DaoSession;

import org.greenrobot.greendao.daotest2.to1_specialentity.ToOneTarget2;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TO_ONE_TARGET2".
*/
public class ToOneTarget2Dao extends AbstractDao<ToOneTarget2, Long> {

    public static final String TABLENAME = "TO_ONE_TARGET2";

    /**
     * Properties of entity ToOneTarget2.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property<Long, Long> Id = new Property<>(0, Long.class, Long.class, "id", true, "_id", null);
    }


    public ToOneTarget2Dao(DaoConfig config) {
        super(config);
    }
    
    public ToOneTarget2Dao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TO_ONE_TARGET2\" (" + //
                "\"_id\" INTEGER PRIMARY KEY );"); // 0: id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TO_ONE_TARGET2\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ToOneTarget2 entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ToOneTarget2 entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ToOneTarget2 readEntity(Cursor cursor, int offset) {
        ToOneTarget2 entity = new ToOneTarget2( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0) // id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ToOneTarget2 entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ToOneTarget2 entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ToOneTarget2 entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ToOneTarget2 entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
