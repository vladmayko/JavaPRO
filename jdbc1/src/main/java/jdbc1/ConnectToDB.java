package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MacUser on 09.06.19.
 */
public class ConnectToDB {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mydb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "";

    public static Connection connectionToDB() throws SQLException{
        return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }

    public static void closeConnection(Connection connection){
        if(connection == null) return;
        try {
            connection.close();
        }catch (SQLException e){

        }
    }
}
