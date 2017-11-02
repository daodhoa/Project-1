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
    PreparedStatement pS= null, ps= null, ps1 = null;
    ResultSet resultSet= null, rs = null;
    public DangKiController(){
        connection= DbConnection.connectDb();
    }
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    String date = format1.format(cal.getTime());
    @FXML
    private DatePicker birthTxt;
    @FXML
    private TextField hoTen, cmnd, diaChi, idTxt, pwTxt, rePwTxt;
    @FXML
    private Label checkLb;
    
    @FXML
    private void Huy() throws IOException{
        Main.showLoginItems();
    }
    @FXML
    private void DangKi() throws IOException{
        String checkCMND = "", checkID = "";
        if(hoTen.getText().trim().equals("") || cmnd.getText().trim().equals("") || diaChi.getText().trim().equals("") || idTxt.getText().trim().equals("")|| pwTxt.getText().trim().equals("") || rePwTxt.getText().trim().equals("") || birthTxt.getValue().toString().trim().equals("")){
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
                System.out.println("check CMND" +checkCMND);
                ps1= connection.prepareStatement("select ID from KhachHang where ID = ?");
                ps1.setString(1, idTxt.getText());
                rs= ps1.executeQuery();
                if(rs.next()){
                    checkID= rs.getString("ID");
                } 
                rs.close();
                
                if("".equals(checkCMND)&& "".equals(checkID)){
                    if(pwTxt.getText().equals(rePwTxt.getText())){
                    ps= connection.prepareStatement("insert into KhachHang values (?,?,?,?,?,?,?,?)");
                    ps.setString(1, hoTen.getText());
                    ps.setString(2, cmnd.getText());
                    ps.setString(3, birthTxt.getValue().toString());
                    ps.setString(4, diaChi.getText());
                    ps.setString(5, date);
                    ps.setString(6, idTxt.getText());
                    ps.setString(7, pwTxt.getText());
                    ps.setInt(8, 50000);
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
                    idTxt.setText(null);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DangKiController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
