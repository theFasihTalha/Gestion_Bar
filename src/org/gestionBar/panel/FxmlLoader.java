/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import bar.Bar;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author talhi
 */
public class FxmlLoader {
   private Pane view;
   
   
   
   //Methode pour recuperer le fichier fxml passé en commenataire
   
   public  Pane getPage(String fileName){
       try {
           URL fileUrl= Bar.class.getResource("/org/gestionBar/panel/" + fileName +".fxml");
           if (fileUrl==null) {
                throw new java.io.FileNotFoundException("fichier Fxml non trouver enfoiré");
           }
           view= new FXMLLoader().load(fileUrl);
       }catch(Exception e){
           System.out.println("pas de page sous le nom de "+ fileName);
       }
       return view;
       
   }
}
