/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.gestionBar.dao.FournisseurDao;
import org.gestionBar.model.Fournisseur;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class FournisseurController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Pane pane;


    @FXML
    private TableView<Fournisseur> tableView;

    @FXML
    private TableColumn<Fournisseur, String> Nom;

    @FXML
    private TableColumn<Fournisseur, String> Adresse;

    @FXML
    private TableColumn<Fournisseur, Integer> Contact;

    @FXML
    private TableColumn<?, ?> none;
    
       @FXML
    private JFXTextField rsField;

    @FXML
    private JFXTextField adField;

    @FXML
    private JFXTextField ctField;

      ObservableList<Fournisseur> list= FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Select();
               
}
    public  void Select () {
      
         try {
          
             for (int i = 0; i <FournisseurDao.getAll().size() ; i++) {
                 list.add(FournisseurDao.getAll().get(i));
             }
             Nom.setCellValueFactory(new PropertyValueFactory<>("raisonSocial"));
             Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
             Contact.setCellValueFactory(new PropertyValueFactory<>("numerotel"));
         } catch (ClassNotFoundException ex) {
             System.out.println("erreur dans le controller");
         }
         tableView.setItems(list);
             
    }
            
//     @FXML
//    public void ajouterFournisseur(ActionEvent event) throws IOException{
//         System.out.println("Bonjour");
//       Stage secondStage=new Stage();
//                   Parent root= FXMLLoader.load(getClass().getResource("/org/gestionBar/panel/FounisseurAjouter.fxml"));
//      Scene scene= new Scene (root );
//      scene.getStylesheets().add(getClass().getResource("/org/gestionBar/panel/founisseurajouter.css").toExternalForm());
//        
//        secondStage.setTitle("Ajouter un Fournisseur");
//        secondStage.setScene(scene);
//        secondStage.show();
//                
//}

      @FXML
    public void Create(ActionEvent event) throws ClassNotFoundException {
        String rs=rsField.getText();
          String ad=adField.getText();
            int ct= Integer.parseInt(ctField.getText());
            Fournisseur f= new Fournisseur(rs,ad,ct);
            FournisseurDao.createFournisseur(f);   
                JOptionPane.showMessageDialog(null, "Users Add succes");
                 Select();
        rsField.setText("");
        adField.setText("");
        ctField.setText("");
        
    }
}

