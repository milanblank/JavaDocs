package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.database.DBManager;
import ro.teamnet.zth.appl.domain.Location;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {

    public <T> T findById(Class<T> entityClass, Long id) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        List<ColumnInfo> columnInfos = EntityUtils.getColumns(entityClass);

        Condition condition = new Condition();

        for (ColumnInfo columnInfo: columnInfos) {
            if (columnInfo.isId()){
                condition.setColumnName(columnInfo.getDbColumnName());
                condition.setValue(id);

            }
        }

        QueryBuilder queryBuilder = new QueryBuilder();

        queryBuilder.setQueryType(QueryType.SELECT).addQueryColumns(columnInfos).setTableName(tableName)
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
                for (ColumnInfo columnInfo: columnInfos) {
                    Field declaredField = t.getClass().getDeclaredField(columnInfo.getColumnName());
                    declaredField.setAccessible(true);
                    declaredField.set(t,EntityUtils.castFromSqlType(resultSet.getObject(columnInfo.getDbColumnName()), declaredField.getType()));
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
        try {
            Statement stmt = conn.createStatement();

           // query: SELECT max(location_id) FROM locations;
            String query = "SELECT MAX(" + columnIdName + ") FROM " + tableName ;

            ResultSet resultSet = stmt.executeQuery(query);
            long result = resultSet.getLong(0) + 1;
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public <T> Object insert(T entity) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entity.getClass());
        final List<ColumnInfo> columnInfos = EntityUtils.getColumns(entity.getClass());
        long id = 0;
        for (ColumnInfo columnInfo: columnInfos) {
            if (columnInfo.isId()){
                id = getNextIdVal(tableName,columnInfo.getDbColumnName());
                columnInfo.setValue(id);
            } else {
                Field declaredField = null;
                try {
                    declaredField = entity.getClass().getDeclaredField(columnInfo.getColumnName());
                    declaredField.setAccessible(true);
                    Object value = declaredField.get(entity);
                    declaredField.set(entity, value);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            Statement stmt = conn.createStatement();
            QueryBuilder queryBuilder = new QueryBuilder();
            queryBuilder.setQueryType(QueryType.INSERT)
                    .setTableName(tableName)
                    .addQueryColumns(columnInfos);

            final ResultSet resultSet = stmt.executeQuery(queryBuilder.createQuery());
            Object byId = findById(entity.getClass(), resultSet.getLong(0));

            return byId;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        Connection conn = DBManager.getConnection();
        String tableName = EntityUtils.getTableName(entityClass);
        final List<ColumnInfo> columns = EntityUtils.getColumns(entityClass);
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setQueryType(QueryType.SELECT)
                .addQueryColumns(columns)
                .setTableName(tableName);
        final String query = queryBuilder.createQuery();

        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            List<T> result = new ArrayList<>();
            while (resultSet.next()){
                T t = entityClass.newInstance();
                for (ColumnInfo column: columns) {
                    String columnName = column.getColumnName();
                    final Field declaredField = t.getClass().getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t,EntityUtils.castFromSqlType(resultSet.getObject(column.getDbColumnName()), declaredField.getType()));

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
}
