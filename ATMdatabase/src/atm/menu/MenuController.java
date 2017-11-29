/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu;

import atm.Main;
import static atm.Main.Logined;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class MenuController {
    private Main main;
    @FXML
    private Label lbHello;
    @FXML
    private void showLabel(){
        lbHello.setText(Logined);
    }
    
    @FXML
    private void goRutTien() throws IOException{
        Main.showRutTienScene();
    }
    
    @FXML
    private void goChuyenTien() throws IOException{
        Main.showChuyenTienView();
    }
    @FXML
    private void goNapTien() throws IOException{
        Main.showNapTienView();
    }
    @FXML
    private void goVanTin() throws IOException{
        Main.showVanTinView();
    }
    @FXML
    private void goDichVu() throws IOException{
        Main.showDichVuView();
    }
    @FXML
    private void goDoiPin() throws IOException{
        Main.showDoiPinView();
    }
}
