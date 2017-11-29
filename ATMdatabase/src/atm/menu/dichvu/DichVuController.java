/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.dichvu;

import atm.Main;
import java.io.IOException;
import javafx.fxml.FXML;


public class DichVuController {
    private Main main;
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
}
