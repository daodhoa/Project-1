/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import static atm.Main.Logined;
import atm.connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Đào D. Hòa
 */
public class UserLogin {
    Connection connection= null;
    PreparedStatement pS= null;
   //ResultSet resultSet= null;
    public UserLogin(){
         connection= DbConnection.connectDb();
    }
    public ResultSet getInfor(){
        ResultSet rs= null;
        try {
            pS= connection.prepareStatement("select * from KhachHang where ID= ?");
            pS.setString(1, Logined);
            rs= pS.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
}
