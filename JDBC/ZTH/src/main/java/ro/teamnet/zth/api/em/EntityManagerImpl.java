package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.database.DBManager;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class EntityManagerImpl implements EntityManager {

    public <T> T findById(Class<T> entityClass, Long id) {
        Connection conn = DBManager.getConnection();
        return null;
    }

    public String getNextIdVal(String tableName, String columnIdName) {
        return null;
    }

    public <T> Object insert(T entity) {
        return null;
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        return null;
    }
}
