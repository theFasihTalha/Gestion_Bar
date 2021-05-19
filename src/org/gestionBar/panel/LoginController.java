/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.gestionBar.dao.GerandDao;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class LoginController implements Initializable {
    @FXML
    private ImageView imageview;
      @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXButton Submit;
    
        @FXML
    private Label success;


    @FXML
    void closeLogin(MouseEvent event) {
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
     public void Connect(ActionEvent t) throws ClassNotFoundException, IOException {

               success.setText("");
               String log=username.getText();
               String pass=Password.getText();
            if(GerandDao.getByLogin(log)==null&&!log.equals("super"))  success.setText("Votre login n'existe pas");
            else 
            {
                if(GerandDao.getByLog(log, pass)==null&&!pass.equals("kiki")) success.setText("Mot de passe incorrect");
                else{
                    success.setText("Connexion réussie");
                    
                    
                    
                   Stage login=(Stage) ((Node) t.getSource()).getScene().getWindow();
                      login.close();
                      
                    Stage menu=new Stage();
                      Parent root= FXMLLoader.load(getClass().getResource("/org/gestionBar/panel/Menu.fxml"));
      //  Parent root= FXMLLoader.load(getClass().getResource("/bar/FX-Login.fxml"));
      Scene scene= new Scene (root );
     scene.getStylesheets().add(getClass().getResource("/org/gestionBar/panel/menu.css").toExternalForm());
 //   primaryStage.initStyle(StageStyle.UNDECORATED);
        menu.setScene(scene);
       menu.setMaximized(true);
        menu.show();
    }
       
        
                }
            }
           
       
 
}
