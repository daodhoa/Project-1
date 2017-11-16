/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view;

import atm.Main;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Đào D. Hòa
 */
public class LoginItemsController {
   //public String logined;
    private Main main;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPass;
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    public LoginItemsController(){
        connection= DbConnection.connectDb();
    }
    
    private String getID(){
        String id= "";
        try {
            pS= connection.prepareStatement("Select SoTK from TKKhachHang where SoTK= ?");
            pS.setString(1, txtId.getText());
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                id= resultSet.getString(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    private String getPass(){
        String pass= "";
        try {
            pS= connection.prepareStatement("Select MatKhau from TKKhachHang where MatKhau= ?");
            pS.setString(1, MaHoa.md5(txtPass.getText()));
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                pass= resultSet.getString(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pass;
    }

    @FXML
    private void goMenu() throws IOException{
        if(txtId.getText().trim().length()== 0 || txtPass.getText().trim().length()== 0){
            errorLabel.setText("Bạn chưa nhập Số TK hoặc Password");
            return;
        }
        if((txtId.getText()).equals(getID())&&  MaHoa.md5(txtPass.getText()).equals(getPass())){
            Main.showMenuScene();
            Main.Logined = txtId.getText();
        }else{
            errorLabel.setText("Sai Số TK hoặc mật khẩu");
        }
    }
    @FXML
    private void goDangKi() throws IOException{
        Main.showDangKi();
    }
}
