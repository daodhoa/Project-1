/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.dangki;

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


public class DangKiTCController {
    Connection connection= null;
    PreparedStatement ps= null;
    ResultSet rs= null;
    public DangKiTCController(){
        connection= DbConnection.connectDb();
    }
    
    @FXML
    private Label soTK, khachHang, Ngay;
    @FXML
    private Label sotk, khachhang, ngay;
    
    @FXML
    private void showThongTin(){
        String hoten= null, taikhoan= null, ngaydk= null;
        try {
            ps= connection.prepareStatement("select HoTen, SoTK, NgayTao from TKKhachHang, KhachHang where KhachHang.CMND= TKKhachHang.CMND and SoTK >=all(select SoTK from TKKhachHang)");
            rs= ps.executeQuery();
            while(rs.next()){
                 hoten= rs.getString("HoTen");
                 taikhoan= rs.getString("SoTK");
                 ngaydk= rs.getString("NgayTao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DangKiTCController.class.getName()).log(Level.SEVERE, null, ex);
        }
        soTK.setText("Số TK: ");
        khachHang.setText("Khách Hàng: ");
        Ngay.setText("Ngày: ");
        sotk.setText(taikhoan);
        khachhang.setText(hoten);
        ngay.setText(ngaydk);
    }
    @FXML
    private void huy() throws IOException{
        Main.showLoginItems();
    }
}
