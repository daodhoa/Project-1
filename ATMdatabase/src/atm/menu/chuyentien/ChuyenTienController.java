/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.chuyentien;

import atm.Main;
import static atm.Main.Logined;
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
public class ChuyenTienController {
    private Main main;
   // private String cmnd;
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    @FXML
    private TextField nhanTxt;
    @FXML
    private TextField tienTxt;
    @FXML
    private Label lbTK, lbTen, lbCheck;
    
    public ChuyenTienController(){
        connection= DbConnection.connectDb();
    }
    
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
    
    @FXML
    private void checkInfor(){
        String ten = null;
        String cm = null;
        
        if(nhanTxt.getText().trim().length()==0){
            lbTK.setText("Vui lòng nhập số TK người nhận");
        }else{
            try {
                pS= connection.prepareStatement("select TenKH, CMND from KhachHang where CMND =?");
                pS.setString(1, nhanTxt.getText());
                resultSet= pS.executeQuery();
                while(resultSet.next()){
                    cm= resultSet.getString("CMND");
                    ten= resultSet.getString("TenKH");
                }
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenTienController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(cm == null){
                lbTK.setText("Người dùng không tồn tại");
                nhanTxt.setText(null);
            }else{
                lbTK.setText(cm);
                lbTen.setText(ten);
            }
        }
    }
    @FXML
    private void ChuyenTien() throws IOException{
        int mySoDu = 0;
        try {
            pS= connection.prepareStatement("select SoDu from KhachHang where ID= ?");
            pS.setString(1, Logined);
            resultSet= pS.executeQuery();
            if(resultSet.next()){
                mySoDu= resultSet.getInt("SoDu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChuyenTienController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!nhanTxt.getText().trim().equals("")){
            if(tienTxt.getText().trim().equals("")){
                lbCheck.setText("Bạn chưa nhập số tiền");
            }else{
                try {
                    int tien= Integer.parseInt(tienTxt.getText());
                    if(tien> 10000000){
                        lbCheck.setText("Chỉ được phép chuyển tối đa 10.000.000 VNĐ 1 lần");
                    }else{
                        if(tien> (mySoDu- 50000)){
                            lbCheck.setText("Tài khoản của bạn không đủ để giao dịch");
                        }else{
                            PreparedStatement ps= connection.prepareStatement("update KhachHang set SoDu= SoDu -? where ID= ?; update KhachHang set SoDu= SoDu +? where CMND= ?");
                            ps.setInt(1, tien);
                            ps.setString(2, Logined);
                            ps.setInt(3, tien);
                            ps.setString(4, lbTK.getText());
                            ps.execute();
                            Main.showChuyenTienTC();
                        }
                    }
                } catch (NumberFormatException e) {
                    lbCheck.setText("Số tiền bạn nhập chưa hợp lệ");
                } catch (SQLException ex) {
                    Logger.getLogger(ChuyenTienController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            lbCheck.setText("Vui lòng kiểm tra người nhận trước");
        }
    }
}
