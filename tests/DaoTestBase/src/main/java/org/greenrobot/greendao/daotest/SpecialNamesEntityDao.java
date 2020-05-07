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
 * DAO for table "ORDER TRANSACTION GROUP BY".
*/
public class SpecialNamesEntityDao extends AbstractDao<SpecialNamesEntity, Long> {

    public static final String TABLENAME = "ORDER TRANSACTION GROUP BY";

    /**
     * Properties of entity SpecialNamesEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property<Long, Long> Id = new Property<>(0, Long.class, Long.class, "id", true, "_id", null);
        public final static Property<String, String> Count = new Property<>(1, String.class, String.class, "count", false, "COUNT", null);
        public final static Property<String, String> Select = new Property<>(2, String.class, String.class, "select", false, "SELECT", null);
        public final static Property<String, String> Sum = new Property<>(3, String.class, String.class, "sum", false, "SUM", null);
        public final static Property<String, String> Avg = new Property<>(4, String.class, String.class, "avg", false, "AVG", null);
        public final static Property<String, String> Join = new Property<>(5, String.class, String.class, "join", false, "JOIN", null);
        public final static Property<String, String> Distinct = new Property<>(6, String.class, String.class, "distinct", false, "DISTINCT", null);
        public final static Property<String, String> On = new Property<>(7, String.class, String.class, "on", false, "ON", null);
        public final static Property<String, String> Index = new Property<>(8, String.class, String.class, "index", false, "INDEX", null);
        public final static Property<Integer, Integer> Order = new Property<>(9, Integer.class, Integer.class, "order", false, "ORDER", null);
    }


    public SpecialNamesEntityDao(DaoConfig config) {
        super(config);
    }
    
    public SpecialNamesEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ORDER TRANSACTION GROUP BY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"COUNT\" TEXT," + // 1: count
                "\"SELECT\" TEXT," + // 2: select
                "\"SUM\" TEXT," + // 3: sum
                "\"AVG\" TEXT," + // 4: avg
                "\"JOIN\" TEXT," + // 5: join
                "\"DISTINCT\" TEXT," + // 6: distinct
                "\"ON\" TEXT," + // 7: on
                "\"INDEX\" TEXT," + // 8: index
                "\"ORDER\" INTEGER);"); // 9: order
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ORDER TRANSACTION GROUP BY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SpecialNamesEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(2, count);
        }
 
        String select = entity.getSelect();
        if (select != null) {
            stmt.bindString(3, select);
        }
 
        String sum = entity.getSum();
        if (sum != null) {
            stmt.bindString(4, sum);
        }
 
        String avg = entity.getAvg();
        if (avg != null) {
            stmt.bindString(5, avg);
        }
 
        String join = entity.getJoin();
        if (join != null) {
            stmt.bindString(6, join);
        }
 
        String distinct = entity.getDistinct();
        if (distinct != null) {
            stmt.bindString(7, distinct);
        }
 
        String on = entity.getOn();
        if (on != null) {
            stmt.bindString(8, on);
        }
 
        String index = entity.getIndex();
        if (index != null) {
            stmt.bindString(9, index);
        }
 
        Integer order = entity.getOrder();
        if (order != null) {
            stmt.bindLong(10, order);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SpecialNamesEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String count = entity.getCount();
        if (count != null) {
            stmt.bindString(2, count);
        }
 
        String select = entity.getSelect();
        if (select != null) {
            stmt.bindString(3, select);
        }
 
        String sum = entity.getSum();
        if (sum != null) {
            stmt.bindString(4, sum);
        }
 
        String avg = entity.getAvg();
        if (avg != null) {
            stmt.bindString(5, avg);
        }
 
        String join = entity.getJoin();
        if (join != null) {
            stmt.bindString(6, join);
        }
 
        String distinct = entity.getDistinct();
        if (distinct != null) {
            stmt.bindString(7, distinct);
        }
 
        String on = entity.getOn();
        if (on != null) {
            stmt.bindString(8, on);
        }
 
        String index = entity.getIndex();
        if (index != null) {
            stmt.bindString(9, index);
        }
 
        Integer order = entity.getOrder();
        if (order != null) {
            stmt.bindLong(10, order);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public SpecialNamesEntity readEntity(Cursor cursor, int offset) {
        SpecialNamesEntity entity = new SpecialNamesEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // count
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // select
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sum
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // avg
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // join
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // distinct
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // on
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // index
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9) // order
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SpecialNamesEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCount(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSelect(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAvg(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setJoin(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDistinct(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setOn(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIndex(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOrder(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(SpecialNamesEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(SpecialNamesEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SpecialNamesEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
