/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author Đào D. Hòa
 */
public class Main extends Application {
    public static String Logined;

    
    private Stage primaryStage;
    private static BorderPane mainLayout;
    @Override
    public void start(Stage primaryStage) throws IOException {
       this.primaryStage= primaryStage;
       this.primaryStage.setTitle("ATM App");
       showMainView();
       showLoginItems();
    }
private void showMainView() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("view/MainViewFXML.fxml"));
    mainLayout= loader.load();
    Scene scene= new Scene(mainLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public static void showLoginItems() throws IOException{
    FXMLLoader loader=new FXMLLoader();
    loader.setLocation(Main.class.getResource("view/LoginItems.fxml"));
    BorderPane loginItems= loader.load();
    mainLayout.setCenter(loginItems);
}


public static void showMenuScene() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/MenuFXML.fxml"));
    BorderPane menuScene = loader.load();
    mainLayout.setCenter(menuScene);
}
public static void showRutTienScene() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/ruttien/FXMLRutTien.fxml"));
    BorderPane rutTien= loader.load();
    mainLayout.setCenter(rutTien);
}

public static void showChuyenTienView() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/chuyentien/FXMLChuyenTien.fxml"));
    BorderPane chuyenTien= loader.load();
    mainLayout.setCenter(chuyenTien);
}

public static void showDoiPinView() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/doipin/FXMLDoiPin.fxml"));
    BorderPane doiPin= loader.load();
    mainLayout.setCenter(doiPin);
}
public static void showNapTienView() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/naptien/FXMLNapTien.fxml"));
    BorderPane napTien= loader.load();
    mainLayout.setCenter(napTien);
}
public static void showVanTinView() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/vantin/FXMLVanTin.fxml"));
    BorderPane vanTin= loader.load();
    mainLayout.setCenter(vanTin);
}
public static void showDichVuView() throws IOException{
    FXMLLoader loader= new FXMLLoader();
    loader.setLocation(Main.class.getResource("menu/dichvu/FXMLDichVu.fxml"));
    BorderPane dichVu= loader.load();
    mainLayout.setCenter(dichVu);
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
