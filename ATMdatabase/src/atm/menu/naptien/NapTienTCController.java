/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.naptien;

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

/**
 *
 * @author Đào D. Hòa
 */
public class NapTienTCController {
    private Main main;
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public NapTienTCController(){
        connection= DbConnection.connectDb();
    }
    
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
    @FXML
    private void tiepTuc() throws IOException{
        Main.showNapTienView();
    }
    @FXML
    private Label soGD, soTK, soTien, soDuHienTai, ngayGD, lbTitle;
    @FXML
    private Label codeGD, acc, amount, balance, lbDate;
    
    @FXML
    private void showBienLai(){
        String taikhoan = null, ngay = null;
        int magd = 0, sotien = 0, sodu = 0;
        try {
            pS= connection.prepareStatement("select MaBienLai, SoTK, SoTienGD, ThoiGian from BienLai where MaBienLai >= all(select MaBienLai from BienLai)");
            resultSet = pS.executeQuery();
            while(resultSet.next()){
                magd= resultSet.getInt(1);
                taikhoan= resultSet.getString(2);
                sotien= resultSet.getInt(3);
                ngay= resultSet.getString(4);
            }
            resultSet.close();
            
            PreparedStatement ps= connection.prepareStatement("select SoDu from TKKhachHang where SoTK = ?");
            ps.setString(1, taikhoan);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                sodu= rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NapTienTCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        codeGD.setText(String.valueOf(magd));
        acc.setText(taikhoan);
        amount.setText(String.valueOf(sotien));
        balance.setText(String.valueOf(sodu));
        lbDate.setText(ngay);
        
        lbTitle.setText("GIAO DỊCH NẠP TIỀN");
        soTK.setText("Số TK: ");
        soGD.setText("Số G/D: ");
        soTien.setText("Số tiền: ");
        soDuHienTai.setText("Số dư hiện tại: ");
        ngayGD.setText("Ngày G/D: ");
    }
}
