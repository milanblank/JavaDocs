package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {

    public <T> T findById(Class<T> entityClass, Long id) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        Condition condition = new Condition();

        for (ColumnInfo column: columns) {
            if (column.isId()){
                condition.setColumnName(column.getDbColumnName());
                condition.setValue(id);

            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();

        queryBuilder.setQueryType(QueryType.SELECT)
                .addQueryColumns(columns)
                .setTableName(tableName)
                .addCondition(condition);
        String query = queryBuilder.createQuery();
        //    "SELECT DEPARTMENT_NAME, ID FROM DEPARTAMENTS WHERE DEPARTMENT_ID = 1"

        Statement stmt;
        T t = null;
        try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            if (resultSet.next()){
                t = entityClass.newInstance();
                for (ColumnInfo column: columns) {
                    Field field = t.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    field.set(t,EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), field.getType()));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return t;
    }

    public long getNextIdVal(String tableName, String columnIdName) {
        Connection conn = DBManager.getConnection();
        long id;
        try {
            Statement stmt = conn.createStatement();

           // query: SELECT max(location_id) FROM locations;
            String query = "SELECT MAX(" + columnIdName + ") FROM " + tableName;


            ResultSet resultSet = stmt.executeQuery(query);
            resultSet.next();
            long result = resultSet.getLong(1) + 10;
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public <T> Object insert(T entity) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        final List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        long id = 0;
        try {
            for (ColumnInfo column : columns) {
                if (column.isId()) {
                    id = getNextIdVal(tableName, column.getDbColumnName());
                    column.setValue(id);
                } else {
                    Field field = entity.getClass().getDeclaredField(column.getColumnName());
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    field.set(entity, value);
                }
            }

            Statement stmt = conn.createStatement();

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.INSERT)
                    .setTableName(tableName)
                    .addQueryColumns(columns);

            String query = queryBuilder.createQuery();

            int i = stmt.executeUpdate(query);
            System.out.println(i + " rows affected");

            Object insertedEntity = findById(entity.getClass(), id);

            return insertedEntity;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        final List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        try {
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.SELECT)
                    .addQueryColumns(columns)
                    .setTableName(tableName);
            final String query = queryBuilder.createQuery();

            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            List<T> result = new ArrayList<>();
            while (resultSet.next()) {
                T t = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    String columnName = column.getColumnName();
                    final Field declaredField = t.getClass().getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t, EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), declaredField.getType()));

                }
                result.add(t);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> T update(T entity) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        final List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());

        try {
            Long id  = null;
            Condition condition = new Condition();
            for (ColumnInfo column : columns) {
                final Field field = entity.getClass().getDeclaredField(column.getColumnName());
                field.setAccessible(true);
                Object value = field.get(entity);
                column.setValue(value);

                if(column.isId()) {
                    condition.setColumnName(column.getDbColumnName());
                    condition.setValue(column.getValue());
                    id = (Long) column.getValue();
                }
            }


            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.UPDATE)
                    .setTableName(tableName)
                    .addQueryColumns(columns)
                    .addCondition(condition);
            final String query = queryBuilder.createQuery();

            Statement stmt = conn.createStatement();
            int numberOfRowsAffected = stmt.executeUpdate(query);
            System.out.println(numberOfRowsAffected + " rows affected");

            T t = (T) findById(entity.getClass(), id);
            return t;

        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e1) {
            e1.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void delete(Object entity) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        List<ColumnInfo> columns = EntityUtils.getColumns(entity.getClass());
        try {
            Condition condition = new Condition();

            for (ColumnInfo column : columns) {
                Field field = entity.getClass().getDeclaredField(column.getColumnName());
                field.setAccessible(true);
                Object value = field.get(entity);

                if(column.isId()) {
                    condition.setColumnName(column.getDbColumnName());
                    condition.setValue(value);
                }
            }

            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.DELETE)
                    .setTableName(tableName)
                    .addCondition(condition);

            String query = queryBuilder.createQuery();

            Statement stmt = conn.createStatement();
            int i = stmt.executeUpdate(query);
            System.out.println(i + " rows affected");

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public <T> List<T> findByParams(Class<T> entityClass, Map<String, Object> params) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);

        List<T> result = new ArrayList<>();

        try {
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.SELECT)
                    .addQueryColumns(columns)
                    .setTableName(tableName);

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                Condition condition = new Condition();
                condition.setValue(entry.getValue());
                condition.setColumnName(entry.getKey());
                queryBuilder.addCondition(condition);
            }


            String query = queryBuilder.createQuery();


            Statement stmt = conn.createStatement();

            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                T t = entityClass.newInstance();
                for (ColumnInfo column : columns) {
                    Field field = t.getClass().getDeclaredField(column.getColumnName()); // access info of the current field
                    field.setAccessible(true);
                    Object value = resultSet.getObject(column.getDbColumnName());
                    field.set(t, EntityUtils.castFromSqlType(value, column.getColumnType()));
                }
                result.add(t);
            }
            return result;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
