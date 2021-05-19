/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import static javafx.scene.control.Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import org.gestionBar.dao.AchatDao;
import org.gestionBar.dao.BoissonDao;
import org.gestionBar.dao.GerandDao;
import org.gestionBar.dao.ServeurDao;
import org.gestionBar.model.Achat;
import org.gestionBar.model.Boisson;
import org.gestionBar.model.CommandePerso;
import org.gestionBar.model.Ligne;
import org.gestionBar.model.Serveur;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class CaisseController implements Initializable {
    
    
       @FXML
    private BorderPane borderPane;
       ObservableList Oblist=FXCollections.observableArrayList();
         @FXML
    private TableView<Ligne> tableview;
         
           @FXML
    private Label total;

    @FXML
    private TableColumn<Ligne, String> article;

    @FXML
    private TableColumn<Ligne, Integer> quantite;

    @FXML
    private TableColumn<Ligne, Double> prix;

    @FXML
    private TableColumn<Ligne, Double> remise;
    
 @FXML
      private Spinner<Integer> quantité;
 
    @FXML
    private ChoiceBox<Serveur> serveur;
    ObservableList<Serveur> serveurList  = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
               // TODO
                
             choicebox();
               FxmlLoader object = new FxmlLoader();
               Pane view=object.getPage("catalogue");
               borderPane.setCenter(view);
               final int initialValue = 0;
               //  quantité.getStyleClass().add(STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
               // Value factory.
               SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 30, initialValue);
              
               quantité.setValueFactory(valueFactory);
               
               

               
         
        

        
    }  
    public void choicebox(){
                   try {
               for (int i = 0; i <ServeurDao.getAll().size() ; i++) {
                   serveurList.add(ServeurDao.getAll().get(i));
                   System.out.println("bien");
               }
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(CaisseController.class.getName()).log(Level.SEVERE, null, ex);
           }
           serveur.setItems(serveurList);
            
               
    }
    
    @FXML
    private void bierre(ActionEvent A){
         borderPane.setCenter(null);
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Bierre");
         borderPane.setCenter(view);
    }
        @FXML
    private void sucrerie(ActionEvent A){
         borderPane.setCenter(null);
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Sucrerie");
         borderPane.setCenter(view);
    }
        @FXML
    private void vin(ActionEvent A){
         borderPane.setCenter(null);
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Vin");
         borderPane.setCenter(view);
    }
        @FXML
    private void energisante(ActionEvent A){
         borderPane.setCenter(null);
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("Energie");
         borderPane.setCenter(view);
    }
      @FXML
     private void All(ActionEvent A){
         borderPane.setCenter(null);
        System.out.println("tu a clické ici enfoiré");
        FxmlLoader object = new FxmlLoader();
        Pane view=object.getPage("catalogue");
         borderPane.setCenter(view);
    }
     //    @FXML
//    public void vendre(ActionEvent event) {
//           try {
//               Button button = (Button)event.getSource();
//               String boisson = button.getText();
//               if (Boisson.ifExist(boisson)) {
//                 Ligne ligne = new Ligne(boisson, 1, BoissonDao.getByNom(boisson).getPrix(), 0.0);
//                 Oblist.add(ligne);
//              } 
//               article.setCellValueFactory(new PropertyValueFactory<>("article"));
//             quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
//             prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
//             remise.setCellValueFactory(new PropertyValueFactory<>("remise"));
//           tableview.setItems(Oblist);
//           } catch (ClassNotFoundException ex) {
//               System.out.println("erreur dans la methode vendre");
//               Logger.getLogger(CaisseController.class.getName()).log(Level.SEVERE, null, ex);
//           }
//        
 //   }

       @FXML
    public void Delete(ActionEvent event) {
       Ligne del;
           System.out.println("element selectionné"+tableview.getSelectionModel().getSelectedItems());
         Oblist=tableview.getItems();
           if (Oblist==null) {
                 CatalogueController.somme=0.0; 
           }
          Double prix=Double.parseDouble(total.getText());
           for (int i = 0; i < Oblist.size(); i++) {
               System.out.println("Objet Apres"+ Oblist.get(i));
               if (Oblist.get(i).equals(tableview.getSelectionModel().getSelectedItem())) {
                    
                   Ligne Objet=(Ligne)Oblist.get(i);
                 
                   prix=prix-Objet.getPrix();
                   Objet.setPrix(Objet.getPrix()/Objet.getQuantite());
                     System.out.println("objet avant"+ Oblist.get(i));
                   Oblist.remove(Oblist.get(i));
                      total.setText(prix.toString());
                      System.out.println("somme"+ CatalogueController.somme);
                      System.out.println("ceci dois donner 1000fr"+Objet.getPrix()*Objet.getQuantite());
                      Double rien=Objet.getPrix()*Objet.getQuantite();
                   CatalogueController.somme=CatalogueController.somme-rien-Objet.getPrix();
                   System.out.println("somme"+CatalogueController.somme);
               }
               tableview.setItems(Oblist);
           }
          
    }
    
        @FXML   
    public void Quantité(ActionEvent event) {
      //  System.out.println("love");
      Oblist=tableview.getItems();
        int qte=quantité.getValue();
            System.out.println(qte);
            Double Prix=Double.parseDouble(total.getText());
         
           for (int i = 0; i < Oblist.size(); i++) {
               System.out.println( Oblist.get(i));
               if (Oblist.get(i).equals(tableview.getSelectionModel().getSelectedItem())) {
                   System.out.println("love");
                   Ligne Objet=(Ligne)Oblist.get(i);
                     Oblist.remove(Oblist.get(i));
                    
                   Ligne ligne=new Ligne(Objet.getArticle(), qte,Objet.getPrix()*qte , Objet.getRemise());
                    Prix=Prix+Objet.getPrix()*qte;
                    Prix=Prix-Objet.getPrix();
                      CatalogueController.somme=CatalogueController.somme+Prix;
                    total.setText(Prix.toString());
                   Oblist.add(ligne);
               }
               tableview.setItems(Oblist);
           }
    }
    
     @FXML   
    public void Sale(MouseEvent event) throws ClassNotFoundException, SQLException{
       
          Achat achat =new Achat(java.time.LocalDate.now(), GerandDao.getByLogin("ahmad"), Double.parseDouble(total.getText()),   serveur.getSelectionModel().getSelectedItem());
          AchatDao.createAchat(achat);
          System.out.println("achat creer avec succes");
       Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText("Merci Pour votre Achat");
alert.setContentText("vente effectuer avec succes");

alert.showAndWait();
    }
    
    
}
