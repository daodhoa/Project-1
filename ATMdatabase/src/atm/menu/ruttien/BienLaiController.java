/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.ruttien;

import atm.Main;
import java.io.IOException;
import javafx.fxml.FXML;
import static atm.menu.ruttien.FXMLRutTienController.money;
import javafx.scene.control.Label;
public class BienLaiController {
    private Main main;
    @FXML
    private Label label;
    @FXML
    private void goBackRutTien() throws IOException{
       Main.showMenuScene();
       money= 0;
    }
    @FXML
    private void showMoney(){
        System.out.println(money);
        label.setText(String.valueOf(money));
    }
}
