/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.menu.doipin;

import atm.Main;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Đào D. Hòa
 */
public class DoiPinController {
    private Main  main;
    @FXML
    private void goBackMenu() throws IOException{
        Main.showMenuScene();
    }
}