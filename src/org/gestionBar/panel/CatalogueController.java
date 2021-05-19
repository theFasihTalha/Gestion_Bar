/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import com.jfoenix.controls.JFXSpinner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
import org.gestionBar.dao.BoissonDao;
import org.gestionBar.model.Boisson;
import org.gestionBar.model.Ligne;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class CatalogueController implements Initializable {
      @FXML
    private JFXSpinner loading;
TableView<Ligne> tb;
 Label PrixTotal;
 public static  Double somme=0.0;
       ObservableList oblist=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
     @FXML
    public void vendre(ActionEvent event) throws ClassNotFoundException {
    //    System.out.println(bf.getParent().getParent().getParent().getParent().getParent());
         
             
        
    
       Button button = (Button)event.getSource();
       String boisson = button.getText();
         if (Boisson.ifExist(boisson)==true) {
             
               Ligne ligne = new Ligne(boisson, 1,BoissonDao.getByNom(boisson).getPrix(), 0.0);
               somme= somme+BoissonDao.getByNom(boisson).getPrix();
             
         
              oblist.add(ligne);
        
        BorderPane borderpane=(BorderPane)button.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
        for (int i = 0; i < borderpane.getChildren().size(); i++) {
           String box=borderpane.getChildren().get(i).getId();
     //       System.out.println(box);
     if ("calcul".equals(box)) {
                VBox vbox=(VBox)borderpane.getChildren().get(i);
             for (int j = 0; j < vbox.getChildren().size(); j++) {
             //    System.out.println("la vBox"+ vbox.getChildren().get(j));
                 Pane pane= (Pane)vbox.getChildren().get(j);
                 for (int k = 0; k < pane.getChildren().size(); k++) {
                 //    System.out.println(pane.getChildren().get(k));
                String table= pane.getChildren().get(k).getId();
                   // System.out.println(table);
                     if ("total".equals(table)) {
                        PrixTotal=(Label)pane.getChildren().get(k);
                         
                     }
                     if ("tableview".equals(table)) {
                       tb=(TableView)pane.getChildren().get(k);
                    
                         for (int l = 0; l < tb.getColumns().size(); l++) {
                               TableColumn tbc=(TableColumn) tb.getColumns().get(l);
                             //  System.out.println(tbc.getId());
                               String id=tbc.getId();
                               if (id.equals("article")) {
                                   TableColumn<Ligne,String> article=tbc;
                                    article.setCellValueFactory(new PropertyValueFactory<>("article"));
                       }
                                 if (id.equals("quantite")) {
                                   TableColumn<Ligne,Integer> quantite=tbc;
                                     quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
                                   
                      }
                                 if (id.equals("prix")) {
                                   TableColumn<Ligne,Double> prix=tbc;
                                    prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                         }
                                 if (id.equals("remise")) {
                                   TableColumn<Ligne,Double> remise=tbc;
                                    remise.setCellValueFactory(new PropertyValueFactory<>("remise"));
                         }
                     }
                           
                 }
        
         }
        }


                
            }

        }  
        
        tb.setItems(oblist);
        PrixTotal.setText(somme.toString()+"Frcfa");
     
//          for (int i = 0; i < oblist.size(); i++) {
//                PrixTotal.setText(somme.toString());
//                 
//             }
       }
        else{
            
               Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Boisson finis dans le stock");

alert.showAndWait();
//            System.out.println(boisson+"est fini");
        }
                       
    }       
  
}
