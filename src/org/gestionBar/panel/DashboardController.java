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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author talhi
 */
public class DashboardController implements Initializable {

    
    @FXML
    private Pane paneView;

     @FXML
    private AreaChart<?, ?> AreaChartView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pieChartData();
       areaChartData();
    }    
    
    //AJOUT DES INFO A PIECHART ET AJOUT DU PIECHART AU PANE
    
    private void pieChartData(){
        paneView.getChildren().clear();
        ObservableList<PieChart.Data> list= FXCollections.observableArrayList();
        list.add(new PieChart.Data("Fanta",30000));
        list.add(new PieChart.Data("Coca",60000));
        list.add(new PieChart.Data("malta",1000));
        list.add(new PieChart.Data("Chill",17000));
        list.add(new PieChart.Data("voddy",14000));
        PieChart pie=new PieChart(list);
        pie.setTitle("Vente Hier");
        pie.setLegendSide(Side.RIGHT);
        paneView.getChildren().add(pie);
  }
    public void areaChartData(){
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Lundi",500));
       series.getData().add(new XYChart.Data("Mardi",750));
        series.getData().add(new XYChart.Data("Mercredi",300));
         series.getData().add(new XYChart.Data("jeudi",450));
          series.getData().add(new XYChart.Data("Vendredi",200));
           series.getData().add(new XYChart.Data("Samedi",1500));
            series.getData().add(new XYChart.Data("Dimanche",1000));
        
        AreaChartView.getData().add(series);
        
    }
}
