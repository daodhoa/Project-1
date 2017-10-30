/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.vantin;

import atm.Main;
import static atm.Main.Logined;
import atm.connection.DbConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author Đào D. Hòa
 */
public class VanTinController {
    private Main main;
    @FXML
    private Label KhachHang;
    @FXML
    private Label lbTen;
    @FXML
    private Label SoTK;
    @FXML
    private Label lbSoTK;
    @FXML
    private Label SoDuTK;
    @FXML
    private Label lbSoDu;
    @FXML
    private Label Date;
    @FXML
    private Label lbDate;
    
    private String taiKhoan= "";
    private String soTK = "";
    private int soDu= 0;
    Date date= new Date();
    String str = String.format("%tc", date );
    
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet resultSet= null;
    
    public VanTinController(){
        connection= DbConnection.connectDb();
    }
    
    public void layDuLieu(){
        try {
            pS= connection.prepareStatement("select TenKH, CMND, SoDu from KhachHang where ID= ?");
            pS.setString(1, Logined);
            resultSet= pS.executeQuery();
            while(resultSet.next()){
                this.taiKhoan = resultSet.getString("TenKH");
                this.soTK= resultSet.getString("CMND");
                this.soDu= resultSet.getInt("SoDu");
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(VanTinController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void vanTin(){
        layDuLieu();
        KhachHang.setText("Khách Hàng:");
        SoTK.setText("Số TK:");
        SoDuTK.setText("Số Dư:");
        Date.setText("Ngày/Tháng/Năm:");
        lbTen.setText(taiKhoan);
        lbSoTK.setText(soTK);
        lbSoDu.setText(String.valueOf(soDu)+" VND");
        lbDate.setText(str);
    }
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
}
