/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.ruttien;


import atm.Main;
import java.io.IOException;
import javafx.fxml.FXML;


public class ThongBaoController {
    private Main main;
    @FXML
    private void troVe() throws IOException{
        Main.showRutTienScene();
    }
}
