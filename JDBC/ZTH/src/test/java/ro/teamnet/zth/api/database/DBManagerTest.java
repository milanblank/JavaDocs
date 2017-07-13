package ro.teamnet.zth.api.database;

import org.junit.Test;
import ro.teamnet.zth.api.database.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;
/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class DBManagerTest {

    @Test
    public void testGetConnection(){
        Connection connection = DBManager.getConnection();
        //boolean closed = connection.isClosed();
        //assertEquals(false,closed);
        assertNotNull(connection);
    }

    @Test
    public void testCheckConnection(){
        Connection connection = DBManager.getConnection();
        String s = DBManager.checkConnection(connection);
        assertNotNull(s);
    }

}
