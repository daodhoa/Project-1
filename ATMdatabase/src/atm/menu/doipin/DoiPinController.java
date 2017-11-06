/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.doipin;

import atm.Main;
import static atm.Main.Logined;
import atm.connection.DbConnection;
import atm.connection.MaHoa;
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
    //UserLogin user= new UserLogin();
    ResultSet rs= null;
    Connection cnn = null;
    PreparedStatement ps =null;
    private String curpw;
    @FXML
    private void checkPass() throws IOException{
        try {
            PreparedStatement ps1 = cnn.prepareStatement("select Pass from KhachHang where ID= ?");
            ps1.setString(1, Logined);
            rs= ps1.executeQuery();
            while (rs.next()){
                curpw= rs.getString(1); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoiPinController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(curPw.getText().trim().equals("") || newPw.getText().trim().equals("") || reNewPw.getText().trim().equals("")){
            label.setText("Bạn chưa nhập đầy đủ!"); 
        }else{
            if( MaHoa.md5(curPw.getText()).equals(curpw)){
                if(newPw.getText().equals(curPw.getText())){
                    label.setText("Mật khẩu mới đã tồn tại");
                }else{
                    if(newPw.getText().equals(reNewPw.getText())){
                        try {
                            ps= cnn.prepareStatement("update KhachHang set Pass= ? where ID= ?");
                            ps.setString(1,  MaHoa.md5(newPw.getText()));
                            ps.setString(2, Logined);
                            ps.execute();
                            Main.showDoiPinTC();
                            curPw.setText(null);
                            newPw.setText(null);
                            reNewPw.setText(null);
                        } catch (SQLException ex) {
                            Logger.getLogger(DoiPinController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        label.setText("Nhập lại chưa khớp!");
                            newPw.setText(null);
                            reNewPw.setText(null);
                    }
                }
            }else{
                label.setText("Mật khẩu cũ chưa đúng!");
                curPw.setText(null);
                            newPw.setText(null);
                            reNewPw.setText(null);
            }
        }
    }
}
