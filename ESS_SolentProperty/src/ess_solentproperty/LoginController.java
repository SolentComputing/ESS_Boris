package ess_solentproperty;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Mahtarr Jeng
 */
public class LoginController implements Initializable {
    
    @FXML
    private AnchorPane apLogin;
    @FXML public AnchorPane getApLogin() { return apLogin; }
    @FXML public void setApLogin(AnchorPane ap) { apLogin = ap; }
    
    @FXML 
    private Label lblStatus;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private TextField txtPassword; 
   
    @FXML
    public void Login(ActionEvent event)throws IOException  {  
           
        System.out.println(txtUserName);
        System.out.println(event.toString());
        
        // Need to be able to login as other users.
        if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass")){
            lblStatus.setText("Login Success");
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));        
            Scene scene = new Scene(root);        
            stage.setScene(scene);
            stage.show();         
            ((Node) (event.getSource())).getScene().getWindow().hide();
            
            // Get the verified user and pass it to the main controller
            //MainPageController ctrl = new MainPageController();
            //User user = myUser;
            //ctrl.setUser(user);
        }
        else{
            lblStatus.setText("Login Failed");
         } 
       
    }
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}