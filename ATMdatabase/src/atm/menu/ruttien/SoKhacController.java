/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.ruttien;

import atm.Main;
import static atm.Main.Logined;
import atm.connection.DbConnection;
import static atm.menu.ruttien.FXMLRutTienController.money;
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
public class SoKhacController {
    //money =0;
    
    private Main main;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField txt;
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public SoKhacController(){
        connection= DbConnection.connectDb();
    }
    private int getSoDu(){
        int x = 0;
        try {
            pS= connection.prepareStatement("select SoDu from KhachHang where ID= ?");
            pS.setString(1, Logined);
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                x= resultSet.getInt("SoDu");
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(SoKhacController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
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
    private void goBackRutTien() throws IOException{
        Main.showRutTienScene();
    }
    @FXML
    private void goBienLai() throws IOException{
        int x= getSoDu();
        //System.out.println(x);
        if(txt.getText().trim().equals("")){
            errorLabel.setText("Bạn chưa nhập số tiền cần rút");
            return;
        }
        try {
            int mon = Integer.parseInt(txt.getText());
            if((mon % 50000) != 0){
                errorLabel.setText("Bạn phải nhập số tiền chẵn");
            }else{
                if(mon> (x- 50000)){
                    errorLabel.setText("Tài Khoản của bạn không đủ!");
                }else{
                    if(mon<0 || mon> 5000000){
                        errorLabel.setText("Bạn chỉ được phép rút tối đa 5.000.000 VNĐ");
                    }else{
                        money= mon; truTien(); Main.showBienLai();
                    }
                }
            }
        } catch (NumberFormatException e) {
            errorLabel.setText("Bạn nhập vào chưa hợp lệ!");
            //System.out.println(txt.getText());
        }
       
       //money= Integer.parseInt(txtField.getText());
       //System.out.println(money);
        //Main.showBienLai();
    }
}
