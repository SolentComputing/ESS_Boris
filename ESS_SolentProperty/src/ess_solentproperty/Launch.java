package ess_solentproperty;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Dean Leszman - 1LESZD34
 */
public class Launch extends Application {
    
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));        
            Scene scene = new Scene(root);        
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Testing_Dean test = new Testing_Dean();
//        try {
//            System.in.read();
//        } catch (IOException ex) {
//            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
//        }
        launch(args);
    }
    
}
