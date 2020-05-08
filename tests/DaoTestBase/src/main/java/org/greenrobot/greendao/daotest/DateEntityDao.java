package org.greenrobot.greendao.daotest;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATE_ENTITY".
*/
public class DateEntityDao extends AbstractDao<DateEntity, Long> {

    public static final String TABLENAME = "DATE_ENTITY";

    /**
     * Properties of entity DateEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property<Long, Long> Id = new Property<>(0, Long.class, "id", true, "_id", null);
        public final static Property<java.util.Date, java.util.Date> Date = new Property<>(1, java.util.Date.class, "date", false, "DATE", null);
        public final static Property<java.util.Date, java.util.Date> DateNotNull = new Property<>(2, java.util.Date.class, "dateNotNull", false, "DATE_NOT_NULL", null);
    }

    private Query<DateEntity> toManyEntity_DateEntityListQuery;

    public DateEntityDao(DaoConfig config) {
        super(config);
    }
    
    public DateEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"DATE\" INTEGER," + // 1: date
                "\"DATE_NOT_NULL\" INTEGER NOT NULL );"); // 2: dateNotNull
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DateEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(2, date.getTime());
        }
        stmt.bindLong(3, entity.getDateNotNull().getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DateEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(2, date.getTime());
        }
        stmt.bindLong(3, entity.getDateNotNull().getTime());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DateEntity readEntity(Cursor cursor, int offset) {
        DateEntity entity = new DateEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // date
            new java.util.Date(cursor.getLong(offset + 2)) // dateNotNull
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DateEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDate(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setDateNotNull(new java.util.Date(cursor.getLong(offset + 2)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DateEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DateEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DateEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "dateEntityList" to-many relationship of ToManyEntity. */
    public List<DateEntity> _queryToManyEntity_DateEntityList(Long idToMany) {
        synchronized (this) {
            if (toManyEntity_DateEntityListQuery == null) {
                QueryBuilder<DateEntity> queryBuilder = queryBuilder();
                queryBuilder.join(JoinManyToDateEntity.class, JoinManyToDateEntityDao.Properties.IdDate)
                    .where(JoinManyToDateEntityDao.Properties.IdToMany.eq(idToMany));
                toManyEntity_DateEntityListQuery = queryBuilder.build();
            }
        }
        Query<DateEntity> query = toManyEntity_DateEntityListQuery.forCurrentThread();
        query.setParameter(0, idToMany);
        return query.list();
    }

}
