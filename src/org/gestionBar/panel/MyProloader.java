/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gestionBar.panel;

import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author talhi
 */
public class MyProloader extends Preloader {
    private Stage preloaderStage;
    private Scene scene;
    
    @Override
    public void init() throws Exception{
                                              
    Parent root1 = FXMLLoader.load(getClass().getResource("Splash.fxml")); 
    scene = new Scene(root1); 
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       this.preloaderStage = primaryStage;

               
       
       // preloaderStage.initStyle(StageStyle.TRANSPARENT); 
       
        // Set preloader scene and show stage.
        preloaderStage.setScene(scene);  
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
        
    }
    public void handleApplicationNotification(PreloaderNotification info){
        if (info instanceof ProgressNotification) {
            SplashController.label.setText("Loading "+((ProgressNotification) info).getProgress()*100 + "%");
            
        }

        
    }
    
    public void handleStateChangeNotification(StateChangeNotification info){
        StateChangeNotification.Type type = info.getType();
        switch (type) {
            
            case BEFORE_START:
                // Called after MyApplication#init and before MyApplication#start is called.
                System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }
    }
    
}
