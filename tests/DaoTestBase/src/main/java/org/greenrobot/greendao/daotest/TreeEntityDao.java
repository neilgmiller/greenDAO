package org.greenrobot.greendao.daotest;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TREE_ENTITY".
*/
public class TreeEntityDao extends AbstractDao<TreeEntity, Long> {

    public static final String TABLENAME = "TREE_ENTITY";

    /**
     * Properties of entity TreeEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property<Long, Long> Id = new Property<>(0, Long.class, Long.class, "id", true, "_id", null);
        public final static Property<Long, Long> ParentId = new Property<>(1, Long.class, Long.class, "parentId", false, "PARENT_ID", null);
    }

    private DaoSession daoSession;

    private Query<TreeEntity> treeEntity_ChildrenQuery;

    public TreeEntityDao(DaoConfig config) {
        super(config);
    }
    
    public TreeEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TREE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"PARENT_ID\" INTEGER);"); // 1: parentId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TREE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TreeEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long parentId = entity.getParentId();
        if (parentId != null) {
            stmt.bindLong(2, parentId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TreeEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long parentId = entity.getParentId();
        if (parentId != null) {
            stmt.bindLong(2, parentId);
        }
    }

    @Override
    protected final void attachEntity(TreeEntity entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TreeEntity readEntity(Cursor cursor, int offset) {
        TreeEntity entity = new TreeEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1) // parentId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TreeEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setParentId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TreeEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TreeEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TreeEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "children" to-many relationship of TreeEntity. */
    public List<TreeEntity> _queryTreeEntity_Children(Long parentId) {
        synchronized (this) {
            if (treeEntity_ChildrenQuery == null) {
                QueryBuilder<TreeEntity> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ParentId.eq(null));
                treeEntity_ChildrenQuery = queryBuilder.build();
            }
        }
        Query<TreeEntity> query = treeEntity_ChildrenQuery.forCurrentThread();
        query.setParameter(0, parentId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTreeEntityDao().getAllColumns());
            builder.append(" FROM TREE_ENTITY T");
            builder.append(" LEFT JOIN TREE_ENTITY T0 ON T.\"PARENT_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected TreeEntity loadCurrentDeep(Cursor cursor, boolean lock) {
        TreeEntity entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        TreeEntity parent = loadCurrentOther(daoSession.getTreeEntityDao(), cursor, offset);
        entity.setParent(parent);

        return entity;    
    }

    public TreeEntity loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<TreeEntity> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<TreeEntity> list = new ArrayList<TreeEntity>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<TreeEntity> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<TreeEntity> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
