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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;


/**
 * FXML Controller class
 *
 * @author Nati Gonzalez
 */
public class UserInterfaceController implements Initializable {
    
    Circuito circuit = new Circuito();
    
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
    @FXML
    private Pane pane;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    
    } 
   @FXML
   public void imprimirCircuito(){
       circuit.circuito.printList();
   }
   
   @FXML 
   public void crearAND(){
       Image imagen=new Image("Proyecto1/img/and.png");
       AND and =new AND();
       circuit.nuevaCompuerta(and);
       and.setImage(imagen);
       and.setOnMousePressed(pressGate);
       and.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(and);
       
   }
   
   @FXML 
   public void crearNAND(){
       Image imagen=new Image("Proyecto1/img/nand.png");
       NAND nand =new NAND();
       circuit.nuevaCompuerta(nand);
       nand.setImage(imagen);
       nand.setOnMousePressed(pressGate);
       nand.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(nand);
       
   }
   
   @FXML 
   public void crearOR(){
       Image imagen=new Image("Proyecto1/img/or.png");
       OR or =new OR();
       circuit.nuevaCompuerta(or);
       or.setImage(imagen);
       or.setOnMousePressed(pressGate);
       or.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(or);
       
   }
   @FXML 
   public void crearNOR(){
       Image imagen=new Image("Proyecto1/img/nor.png");
       NOR nor =new NOR();
       circuit.nuevaCompuerta(nor);
       nor.setImage(imagen);
       nor.setOnMousePressed(pressGate);
       nor.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(nor);
       
   }
   
   @FXML 
   public void crearXOR(){
       Image imagen=new Image("Proyecto1/img/xor.png");
       XOR xor =new XOR();
       circuit.nuevaCompuerta(xor);
       xor.setImage(imagen);
       xor.setOnMousePressed(pressGate);
       xor.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(xor);
       
   }
   
   @FXML 
   public void crearXNOR(){
       Image imagen=new Image("Proyecto1/img/xnor.png");
       XNOR xnor =new XNOR();
       circuit.nuevaCompuerta(xnor);
       xnor.setImage(imagen);
       xnor.setOnMousePressed(pressGate);
       xnor.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(xnor);
       
   }
   
   @FXML 
   public void crearNOT(){
       Image imagen=new Image("Proyecto1/img/not.png");
       NOT not =new NOT();
       circuit.nuevaCompuerta(not);
       not.setImage(imagen);
       not.setOnMousePressed(pressGate);
       not.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(not);
       
   }
   
   EventHandler<MouseEvent> pressGate= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX=((Compuerta)(t.getSource())).getTranslateX();
            orgTranslateY=((Compuerta)(t.getSource())).getTranslateY();
        }
    };
   EventHandler<MouseEvent> dragGate= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            
            ((Compuerta)(t.getSource())).setTranslateX(newTranslateX);
            ((Compuerta)(t.getSource())).setTranslateY(newTranslateY);
        }
   
   };
   
   
}

