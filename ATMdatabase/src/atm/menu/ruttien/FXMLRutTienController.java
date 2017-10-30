/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.ruttien;

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

/**
 *
 * @author Đào D. Hòa
 */
public class FXMLRutTienController {
    private Main main;
    public static int money= 0;
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    public FXMLRutTienController(){
        connection= DbConnection.connectDb();
    }
    private int soTienHienTai(){
        int curMoney=0;
        try {
            pS= connection.prepareStatement("select SoDu from KhachHang where ID= ?");
            pS.setString(1, Logined);
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                curMoney= resultSet.getInt(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLRutTienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return curMoney;
    }
    private void truTien(){
         try {
            pS= connection.prepareStatement("update KhachHang set SoDu = (SoDu- ?) where ID= ? ");
            pS.setInt(1, money);
            pS.setString(2, Logined);
            pS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(BienLaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void tien100() throws IOException{
        int x= soTienHienTai()- 50000;
        money= 100000;
        if(money > x){
            Main.showThongBaoRT();
        }else Main.showBienLai(); truTien();
    }
    @FXML
    private void tien500() throws IOException{
         int x= soTienHienTai()- 50000;
        money= 500000;
        if(money > x){
            Main.showThongBaoRT();
        }else Main.showBienLai(); truTien();
    }
    @FXML
    private void tien1k() throws IOException{
         int x= soTienHienTai()- 50000;
        money= 1000000;
        if(money > x){
            Main.showThongBaoRT();
        }else Main.showBienLai(); truTien();
    }
    @FXML
    private void tien1k5() throws IOException{
         int x= soTienHienTai()- 50000;
        System.out.println(x);
        money= 1500000;
        if(money > x){
            Main.showThongBaoRT();
        }else Main.showBienLai(); truTien();
    }
    
    @FXML
    private void tien2k() throws IOException{
         int x= soTienHienTai()- 50000;
        money= 2000000;
        if(money > x){
            Main.showThongBaoRT();
        }else  Main.showBienLai(); truTien();
    }
    
    @FXML
    private void goSoKhac() throws IOException{
        Main.showSoKhac();
    }
    @FXML
    private void goBackMenu() throws IOException{
       Main.showMenuScene();
    }
}
