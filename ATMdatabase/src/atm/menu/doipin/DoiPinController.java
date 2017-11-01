/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.doipin;

import atm.Main;
import static atm.Main.Logined;
import atm.UserLogin;
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
public class DoiPinController {
    private Main  main;
    @FXML
    private Label label;
    @FXML
    private TextField curPw;
    @FXML
    private TextField newPw;
    @FXML
    private TextField reNewPw;
    
    public DoiPinController(){
        cnn= DbConnection.connectDb();
    }
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
    UserLogin user= new UserLogin();
    ResultSet rs= user.getInfor();
    Connection cnn = null;
    
    private void changePass(String pwd){
        try {
            PreparedStatement ps= cnn.prepareStatement("update KhachHang set Pass = ? where ID = ?");
            ps.setString(1, pwd);
            ps.setString(2, Logined);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DoiPinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void checkPass() throws IOException{
        String curpw = null;
        try {
            while(rs.next()){
                curpw = rs.getString("Pass");               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoiPinController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(curPw.getText().trim().equals("") || newPw.getText().trim().equals("") || reNewPw.getText().trim().equals("")){
            label.setText("Bạn chưa nhập đầy đủ!"); 
        }else{
            //System.out.println("zzzzz "+ curPw.getText());
            //System.out.println("zz "+ newPw.getText());
            //System.out.println("z "+ reNewPw.getText());
            if(curPw.getText().equals(curpw)){
                System.out.println(curPw.getText());
                System.out.println(curpw);
                if(curPw.getText().equals(newPw.getText())) label.setText("Mật khẩu mới trùng với Mật khẩu cũ");
                else if(newPw.getText().equals(reNewPw.getText())== false) label.setText("Nhập lại mật khẩu chưa đúng");
                else{
                    System.out.println("Đổi mật khẩu thành công");
                    changePass(newPw.getText());
                    Main.showDoiPinTC();
                }
            }else{
                label.setText("Mật khẩu cũ chưa đúng!");
                //System.out.println(""+ curPw.getText());
                System.out.println(curpw);
            }
        }
    }
}
