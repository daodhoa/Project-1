/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.ruttien;

import atm.Main;
import java.io.IOException;
import javafx.fxml.FXML;
//import static atm.menu.ruttien.FXMLRutTienController.money;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 *
 * @author Đào D. Hòa
 */
public class SoKhacController {
    private Main main;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField txt;
    
    @FXML
    private void goBackRutTien() throws IOException{
        Main.showRutTienScene();
    }
    @FXML
    private void goBienLai() throws IOException{
        //String str = txt.getText(); 
        if(txt.getText()!= null){}
        System.out.println(txt.getText());
        //int x= Integer.parseInt(str);
        //System.out.println(x);
       
       //money= Integer.parseInt(txtField.getText());
       //System.out.println(money);
        //Main.showBienLai();
    }
}
