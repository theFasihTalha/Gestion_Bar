/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.gestionBar.dao.BoissonDao;
import org.gestionBar.model.Boisson;
import org.gestionBar.model.Casier;
import org.gestionBar.model.Fournisseur;
import org.gestionBar.model.Marque;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class BoissonController implements Initializable {
        
        @FXML
    private TableView<Boisson> tableView;

    @FXML
    private TableColumn<Boisson, String> Nom;

    @FXML
    private TableColumn<Boisson,Integer > Quantité;

    @FXML
    private TableColumn<Boisson, String> Type;

    @FXML
    private TableColumn<Boisson, Double> prix;

    @FXML
    private TableColumn<Boisson, Marque> Marque;

    @FXML
    private TableColumn<Boisson, Casier> Casier;
    
       ObservableList<Boisson> list= FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       getBoi();
    }    
       
    public void getBoi() {
        
         try {
          
             for (int i = 0; i <BoissonDao.getAll().size() ; i++) {
                 list.add(BoissonDao.getAll().get(i));
             }
             Nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
             Quantité.setCellValueFactory(new PropertyValueFactory<>("quantité"));
             Type.setCellValueFactory(new PropertyValueFactory<>("type"));
             prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
             Marque.setCellValueFactory(new PropertyValueFactory<>("marque"));
             Casier.setCellValueFactory(new PropertyValueFactory<>("casier"));
         } catch (ClassNotFoundException ex) {
             System.out.println("erreur dans le controller");
         }
         tableView.setItems(list);
             
    }
}
