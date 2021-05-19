/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class MenuController implements Initializable {

   
    @FXML
    private VBox Contenu;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Dashboard");
        Contenu.getChildren().add(view);
        
    }    
    @FXML
    private void Dashboard(ActionEvent A){
         Contenu.getChildren().clear();
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Dashboard");
        Contenu.getChildren().add(view);
        
    }
    @FXML
    private void Fournisseur(ActionEvent A){
         Contenu.getChildren().clear();
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Fournisseur");
        Contenu.getChildren().add(view);
                  
        
    }
      @FXML
    private void Caisse(ActionEvent A){
         Contenu.getChildren().clear();
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Caisse");
        Contenu.getChildren().add(view);
        
    }
    
     @FXML
     private void Boisson(ActionEvent A){
         Contenu.getChildren().clear();
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Boisson");
        Contenu.getChildren().add(view);
        
    }
}
