/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.admin;

import atm.Main;
import atm.connection.DbConnection;
import atm.connection.MaHoa;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class AdminLoginController {
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public AdminLoginController(){
        connection= DbConnection.connectDb();
    }
    
    @FXML
    private JFXTextField txtID;
    @FXML
    private JFXPasswordField txtPW;
    @FXML
    private Label errorLabel;
    
    private String getID(){
        String id= "";
        try {
            pS= connection.prepareStatement("Select ID from Admin where ID = ?");
            pS.setString(1, txtID.getText());
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                id= resultSet.getString(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    private String getPass(){
        String pw= "";
        try {
            pS= connection.prepareStatement("Select PW from Admin where PW= ?");
            pS.setString(1, MaHoa.md5(txtPW.getText()));
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                pw= resultSet.getString(1);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pw;
    }
    
    @FXML
    private void DangNhap() throws IOException{
        if(txtID.getText().trim().length()== 0 || txtPW.getText().trim().length()== 0){
            errorLabel.setText("Bạn chưa nhập ID hoặc Password");
            return;
        }
        if((txtID.getText()).equals(getID())&&  MaHoa.md5(txtPW.getText()).equals(getPass())){
            Main.showMenuAdmin();
        }else{
            errorLabel.setText("Tai khoan khong ton tai");
        }
    }
    
    @FXML
    private void goTheNap() throws IOException{
        Main.showTheNap();
    }
}


