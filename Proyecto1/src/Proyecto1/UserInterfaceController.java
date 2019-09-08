/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.awt.Rectangle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;


/**
 * FXML Controller class
 *
 * @author Nati Gonzalez
 */
public class UserInterfaceController implements Initializable {
    Circle circleRed;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    @FXML
    private Font x1;
    @FXML
    private Color x2;
    @FXML
    private Font x3;
    @FXML
    private Color x4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
   @FXML 
   public void circulo(ActionEvent event){
        System.out.println("d");
        Circle circle_Red = new Circle(50.0f, Color.RED);
        circle_Red.setCursor(Cursor.HAND);
        circle_Red.setCenterX(150);
        circle_Red.setCenterY(150);
        
        
        //circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
        //circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        
    }
   
   /*EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
        }
    };
     
    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
             
            ((Circle)(t.getSource())).setTranslateX(newTranslateX);
            ((Circle)(t.getSource())).setTranslateY(newTranslateY);
        }
    };*/
   @FXML 
   public void crearAND(){
       System.out.println(":)");
   }
}

