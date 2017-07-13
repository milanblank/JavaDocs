package ro.teamnet.zth.api.database;

import javax.security.auth.callback.UnsupportedCallbackException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Milan.Stojiljkovic on 7/13/2017.
 */
public class DBManager {

    private DBManager() throws UnsupportedOperationException{
        throw new UnsupportedOperationException();
    }

    public static final String CONNECTION_STRING= "jdbc:oracle:thin:@"
            + DBProperties.IP + ":" + DBProperties.PORT
            + ":xe";

    private static void registerDriver(){
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Properties info = new Properties();
        info.put("user", DBProperties.USER);
        info.put("password", DBProperties.PASS);
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING, info);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String checkConnection(Connection conn){
        String SQL = "SELECT City FROM Locations";
        try {
            Statement stmt = conn.createStatement();
            final ResultSet resultSet = stmt.executeQuery(SQL);
            while(resultSet.next()){
            String result = resultSet.getString("CITY");
            return result;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
