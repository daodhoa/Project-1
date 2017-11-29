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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class NapTienController {
    private Main main;
    @FXML
    private Label lbCheck;
    @FXML
    private TextField txtCode;
    
    Date date= new Date();
    String str = String.format("%tc", date );
    
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
    private void napTien() throws IOException{
        if(txtCode.getText().equals(getCode())){
            int money = getMoney(txtCode.getText());
            System.out.println("Money: "+ money);
            try {
                pS= connection.prepareStatement("update TKKhachHang set SoDu= SoDu + ? where SoTK = ?; delete from TheNap where MaThe = ?; insert into BienLai (MaGiaoDich, SoTienGD, SoTK, ThoiGian) values (?,?,?,?)");
                pS.setInt(1, money);
                pS.setString(2, Logined);
                pS.setString(3, txtCode.getText());
                pS.setString(4, "#2");
                pS.setInt(5, money);
                pS.setString(6, Logined);
                pS.setString(7, str);
                pS.execute();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(NapTienController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Main.showNapTienTC();
        }else{
            lbCheck.setText("Bạn nạp sai, vui lòng thử lại!");
        }
    }
}
