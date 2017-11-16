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
import javafx.fxml.FXML;
import static atm.menu.ruttien.FXMLRutTienController.money;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
public class BienLaiController {
    
    private Main main;
    @FXML
    private Label lbAcc;
    @FXML
    private Label lbAmount;
    @FXML
    private Label lbLG;
    @FXML
    private Label lbAB;
    @FXML
    private Label lbDate;
    @FXML
    private Label account;
    @FXML
    private Label amount;
    @FXML
    private Label lgBalance;
    @FXML
    private Label abBalance;
    @FXML
    private Label date;
            
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public BienLaiController(){
        connection= DbConnection.connectDb();
    }
    
    private String cmnd;
    private int sodu;
    Date dt= new Date();
    String str = String.format("%tc", dt );
    @FXML
    private void goBackRutTien() throws IOException{
       Main.showMenuScene();
       money= 0;
    }
    @FXML
    private void rutTien(){
        try {        
            pS= connection.prepareStatement("select SoTK, SoDu from TKKhachHang where SoTK= ?");
            pS.setString(1, Logined);
            resultSet= pS.executeQuery();
            while(resultSet.next()){
                cmnd= resultSet.getString("SoTK");
                sodu= resultSet.getInt("SoDu");
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(BienLaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        account.setText("Account: ");
        amount.setText("Amount: ");
        lgBalance.setText("L/G Balace: ");
        abBalance.setText("A/B Balance: ");
        date.setText("Date: ");
        
        lbAcc.setText(cmnd);
        lbAmount.setText(String.valueOf(money));
        lbLG.setText(String.valueOf(sodu)+ " VND");
        lbAB.setText(String.valueOf(sodu - 50000)+ " VND");
        lbDate.setText(str);
    }
}
