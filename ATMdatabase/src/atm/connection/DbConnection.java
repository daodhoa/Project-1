/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnection {
    static Connection conn= null;   
    public static Connection connectDb(){
        String stringConn= "jdbc:sqlserver://;databaseName=CayLamRoi";
        try {
            conn = DriverManager.getConnection(stringConn,"sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
