/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.dangki;

import atm.Main;
import atm.connection.DbConnection;
import atm.connection.MaHoa;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Đào D. Hòa
 */
public class DangKiController {
    Connection connection= null;
    PreparedStatement pS= null, ps= null;
    ResultSet resultSet= null;
    public DangKiController(){
        connection= DbConnection.connectDb();
    }
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    String date = format1.format(cal.getTime());
    
    @FXML
    private DatePicker birthTxt;
    @FXML
    private TextField hoTen, cmnd, diaChi, pwTxt, rePwTxt, email;
    @FXML
    private Label checkLb;
    
    @FXML
    private void Huy() throws IOException{
        Main.showLoginItems();
    }
    @FXML
    private void DangKi() throws IOException{
        String checkCMND = "";
        if(hoTen.getText().trim().equals("") || cmnd.getText().trim().equals("") || diaChi.getText().trim().equals("") || pwTxt.getText().trim().equals("") || rePwTxt.getText().trim().equals("") || birthTxt.getValue().toString().trim().equals("")){
            checkLb.setText("Bạn phải nhập đầy đủ thông tin");
        }else{
            try {
                pS= connection.prepareStatement("select CMND from KhachHang where CMND = ?");
                pS.setString(1, cmnd.getText());
                resultSet= pS.executeQuery();
                if(resultSet.next()){
                    checkCMND= resultSet.getString("CMND");
                }
                resultSet.close();
                //System.out.println("check CMND" +checkCMND);
                
                if("".equals(checkCMND)){
                    if(pwTxt.getText().equals(rePwTxt.getText())){
                    ps= connection.prepareStatement("insert into KhachHang values (?,?,?,?,?); insert into TKKhachHang (CMND, NgayTao, MatKhau, SoDu) values (?,?,?,?)");
                    ps.setString(1, cmnd.getText());
                    ps.setString(2, hoTen.getText());
                    ps.setString(3, birthTxt.getValue().toString());
                    ps.setString(4, email.getText());
                    ps.setString(5, diaChi.getText());
               
                    ps.setString(6, cmnd.getText());
                    ps.setString(7, date);
                    ps.setString(8, MaHoa.md5(pwTxt.getText())); 
                    ps.setInt(9, 50000);
                    ps.execute();
                    ps.close();
                    Main.showDangKiTC();
                    }else{
                        checkLb.setText("Nhập lại mật khẩu không đúng");
                        pwTxt.setText(null);
                        rePwTxt.setText(null);
                    }
                }else{
                    checkLb.setText("Người dùng đã tồn tại");
                    cmnd.setText(null);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
