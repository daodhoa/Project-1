/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view;

import atm.Main;
import static atm.Main.Logined;
//import atm.connection.DbConnection;
import java.io.IOException;
import javafx.fxml.FXML;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.fxml.FXML;

/**
 *
 * @author Đào D. Hòa
 */
public class MainViewController {
    private Main main;
    /*Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    public MainViewController(){
        connection= DbConnection.connectDb();
    }
    private void deleteDangNhap(){
        String query= "delete from DangNhap";
        try {
            pS= connection.prepareStatement(query);
            pS.execute();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    @FXML
    private void goHome() throws IOException{
        Main.showLoginItems();
        Logined = "";
    }
    
}
