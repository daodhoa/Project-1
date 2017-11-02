/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.view;

import atm.Main;
import static atm.Main.Logined;
import java.io.IOException;
import javafx.fxml.FXML;

/**
 *
 * @author Đào D. Hòa
 */
public class MainViewController {
    private Main main;
    @FXML
    private void goHome() throws IOException{
        Main.showLoginItems();
        Logined = "";
    }
}
