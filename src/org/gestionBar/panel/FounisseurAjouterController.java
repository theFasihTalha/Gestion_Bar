/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.gestionBar.dao.FournisseurDao;
import org.gestionBar.model.Fournisseur;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class FounisseurAjouterController implements Initializable {
@FXML
private JFXButton save;

 @FXML
    private JFXTextField RaisonSociale;

    @FXML
    private JFXTextField Adresse;

    @FXML
    private JFXTextField Contact;

   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void Create(ActionEvent event) throws ClassNotFoundException {
        String rs=RaisonSociale.getText();
          String ad=Adresse.getText();
            int ct= Integer.parseInt(Contact.getText());
            Fournisseur f= new Fournisseur(rs,ad,ct);
            FournisseurDao.createFournisseur(f);   
             Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
                      stage.close();
              
        
        
    }
            
    
}
