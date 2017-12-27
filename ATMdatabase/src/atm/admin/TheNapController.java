/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.admin;

import atm.Main;
import atm.connection.DbConnection;
import com.jfoenix.controls.JFXTextField;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author Đào D. Hòa
 */
public class TheNapController {
    ObservableList<String> listMenhGia= FXCollections.observableArrayList("1.000.000 VND","2.000.000 VND",
            "5.000.000 VND", "10.000.000 VND");
    ObservableList<String> listSoLuong= FXCollections.observableArrayList("1","2",
            "5", "10");
    Connection connection= null;
    PreparedStatement pS= null;
    ResultSet rs= null;
    
    public TheNapController(){
        connection= DbConnection.connectDb();
    }
    
    @FXML
    private ChoiceBox choiceBox, choiceBox1, choiceBox2;
    @FXML
    private JFXTextField maTheTxt;
    @FXML
    private Label thongBaoLb;
    @FXML
    private Label thongBao2Lb;
    @FXML
    private void initialize(){
        choiceBox.setValue("1.000.000 VND");
        choiceBox.setItems(listMenhGia);
        choiceBox1.setValue("1.000.000 VND");
        choiceBox1.setItems(listMenhGia);
        choiceBox2.setValue("1");
        choiceBox2.setItems(listSoLuong);
    }
    
    
    private boolean checkMaThe(){
        String mathe= "";
        try {
            pS= connection.prepareStatement("select MaThe from TheNap where MaThe= ?");
            pS.setString(1, maTheTxt.getText());
            rs= pS.executeQuery();
            while(rs.next()){
                mathe= rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheNapController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mathe.equals("");
    }
    @FXML
    private void themTheNap(){   
        long menhgia = 0;
        Object item = choiceBox.getSelectionModel().getSelectedItem();
       if(item.equals("1.000.000 VND")) menhgia= 1000000;
       if(item.equals("2.000.000 VND")) menhgia= 2000000;
       if(item.equals("5.000.000 VND")) menhgia= 5000000;
       if(item.equals("10.000.000 VND")) menhgia= 10000000;
        System.out.println("menh gia:"+ menhgia);
       
       if(maTheTxt.getText().trim().length()==0){
           thongBaoLb.setText("Chưa nhập mã thẻ");
       }else{
           if(maTheTxt.getText().trim().length()<10 || maTheTxt.getText().trim().length()>10){
               thongBaoLb.setText("Phải nhập đầy đủ 10 chữ số mã thẻ");
           }else{
           try {
               long mathe= Long.parseLong(maTheTxt.getText());
               if(checkMaThe()){
                   try {
                       pS= connection.prepareStatement("insert into TheNap values (?, ?)");
                       pS.setString(1, maTheTxt.getText());
                       pS.setLong(2, menhgia);
                       pS.execute();
                       thongBaoLb.setText("Thêm thành công");
                       maTheTxt.setText("");
                   } catch (SQLException ex) {
                       Logger.getLogger(TheNapController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }else{
                   thongBaoLb.setText("Mã thẻ đã tồn tại");
               }
           } catch (NumberFormatException e) {
               thongBaoLb.setText("Mã thẻ phải gồm các chữ số");
           }}
       }
    }
    @FXML
    private void readThenap() throws FileNotFoundException, IOException{
        int count=0;
        long menhgia = 0;
        Object item = choiceBox1.getSelectionModel().getSelectedItem();
       if(item.equals("1.000.000 VND")) menhgia= 1000000;
       if(item.equals("2.000.000 VND")) menhgia= 2000000;
       if(item.equals("5.000.000 VND")) menhgia= 5000000;
       if(item.equals("10.000.000 VND")) menhgia= 10000000;
       
       int soluong = 0;
        Object item1 = choiceBox2.getSelectionModel().getSelectedItem();
       if(item1.equals("1")) soluong= 1;
       if(item1.equals("2")) soluong= 2;
       if(item1.equals("5")) soluong= 5;
       if(item1.equals("10")) soluong= 10;
            try {
                PreparedStatement ps= connection.prepareStatement("select count(*) from TheNap where SoTien = ?");
                ps.setLong(1, menhgia);
                ResultSet rs1= ps.executeQuery();
                if(rs1.next()){
                    count= rs1.getInt(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TheNapController.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(count<soluong){
            thongBao2Lb.setText("Hết thẻ");
        }else{
        File file= new File("Output.txt");
        try {
            try (PrintWriter pw = new PrintWriter(file)) {
                pS= connection.prepareStatement("select top "+ soluong +" MaThe, SoTien from TheNap where SoTien = ?" );
                //pS.setInt(1, soluong);
                pS.setLong(1, menhgia);
                rs= pS.executeQuery();
                pw.println("MÃ THẺ"+"        "+"MỆNH GIÁ");
                while(rs.next()){
                    System.out.println(rs.getString("MaThe")+ "  " + rs.getString("SoTien"));
                    pw.println(rs.getString("MaThe")+"    "+rs.getString("SoTien"));
                }
                thongBao2Lb.setText("Thao tác thành công, kiểm tra file Output.txt để lấy kết quả.");
                //Main.showThongBaoNhanThe();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheNapController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    /*@FXML
    private void testChoiceBox(){
        thongBaoLb.setText(choiceBox.getSelectionModel().getSelectedItem().toString());
    }*/
    
    @FXML
    private void troVe() throws IOException{
        Main.showMenuAdmin();
    }
    
    
}
