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
    private Label date, lbTitle, soGD, codeGD;
            
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public BienLaiController(){
        connection= DbConnection.connectDb();
    }
    
    private String cmnd;
    private int sodu;
    private int maGD;
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
               // maGD= resultSet.getInt("3");
            }
            resultSet.close();
            
            PreparedStatement ps= connection.prepareStatement("select MaBienLai from BienLai where MaBienLai >= all(select MaBienLai from BienLai)");
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                maGD= rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BienLaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbTitle.setText("GIAO DỊCH RÚT TIỀN");
        soGD.setText("Số G/D: ");
        account.setText("Số TK: ");
        amount.setText("Số tiền: ");
        lgBalance.setText("Số dư: ");
        abBalance.setText("Số dư dùng được: ");
        date.setText("Ngày GD: ");
        
        codeGD.setText(String.valueOf(maGD));
        lbAcc.setText(cmnd);
        lbAmount.setText(String.valueOf(money));
        lbLG.setText(String.valueOf(sodu)+ " VND");
        lbAB.setText(String.valueOf(sodu - 50000)+ " VND");
        lbDate.setText(str);
    }
}
