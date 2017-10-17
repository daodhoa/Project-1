/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.naptien;

import atm.Main;
import static atm.Main.Logined;
import atm.connection.DbConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Đào D. Hòa
 */
public class NapTienController {
    private Main main;
    @FXML
    private Label lbCheck;
    @FXML
    private TextField txtCode;
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public NapTienController(){
        connection= DbConnection.connectDb();
    }
    
    private String getCode(){
        String code= "";
        try {
            pS= connection.prepareStatement("select MaThe from TheNap where MaThe =?");
            pS.setString(1, txtCode.getText());
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                code= resultSet.getString(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(NapTienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return code;
    }
    
    private int getMoney(String code){
        int money= 0;
        try {
            pS= connection.prepareStatement("select SoTien from TheNap where MaThe= ?");
            pS.setString(1, code);
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                money= resultSet.getInt(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(NapTienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return money;
    }
    
    
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
    
    @FXML
    private void napTien(){
        if(txtCode.getText().equals(getCode())){
            int money = getMoney(txtCode.getText());
            System.out.println("Money: "+ money);
            try {
                pS= connection.prepareStatement("update KhachHang set SoDu= SoDu + ? where ID = ?");
                pS.setInt(1, money);
                pS.setString(2, Logined);
                pS.execute();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(NapTienController.class.getName()).log(Level.SEVERE, null, ex);
            }
            lbCheck.setText("Bạn nạp thành công");
        }else{
            lbCheck.setText("Bạn nạp sai, vui lòng thử lại!");
        }
    }
}
