/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.chuyentien;

import atm.Main;
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


public class ChuyenTienTCController {
    
     @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    public ChuyenTienTCController(){
        connection= DbConnection.connectDb();
    }
    @FXML
    private Label lbTitle, soGD, codeGD, tkChuyen, accChuyen, tkNhan, accNhan, soTien, amount, ngayGD, lbDate;
    
    @FXML 
    private void showBienLai(){
        int mabienlai = 0, sotien = 0;
        String soTk = null, soTkNhan = null, thoigian = null;
        try {
            pS= connection.prepareStatement("select MaBienLai, SoTK, SoTienGD, SoTKNhan, ThoiGian"
                    + " from BienLai where MaBienLai >= all(select MaBienLai from BienLai)");
            resultSet= pS.executeQuery();
            while(resultSet.next()){
                mabienlai= resultSet.getInt(1);
                sotien= resultSet.getInt(3);
                soTk= resultSet.getString(2);
                soTkNhan= resultSet.getString(4);
                thoigian= resultSet.getString(5);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenTienTCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lbTitle.setText("GIAO DỊCH CHUYỂN TIỀN");
        soGD.setText("Số G/D: ");
        codeGD.setText(String.valueOf(mabienlai));
        tkChuyen.setText("TK chuyển: ");
        accChuyen.setText(soTk);
        tkNhan.setText("TK nhận: ");
        accNhan.setText(soTkNhan);
        soTien.setText("Số tiền: ");
        amount.setText(String.valueOf(sotien));
        ngayGD.setText("Ngày G/D: ");
        lbDate.setText(thoigian);
        
    }
}
