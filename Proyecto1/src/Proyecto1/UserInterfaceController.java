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
import javafx.scene.shape.Line;
import javafx.scene.text.Font;


/**
 * FXML Controller class
 *
 * @author Nati Gonzalez
 */
public class UserInterfaceController implements Initializable {
    
    Circuito circuit = new Circuito();
    int entrada;
    int salida;
    double startX;
    double startY;
    double endX;
    double endY;
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
       circuit.simularCircuito();
       circuit.circuito.printList();
       
       
   }
   @FXML
   public void resetPane(){
       circuit.circuito.clearList();
       pane.getChildren().clear();
   }
   @FXML 
   public void crearAND(){
       Image imagen=new Image("Proyecto1/img/and.png");
       AND and =new AND();
       circuit.nuevaCompuerta(and);
       and.setImage(imagen);
       and.setOnMousePressed(pressGate);
       and.setOnMouseDragged(dragGate);
       and.setOnMouseClicked(eraseGate);
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
       nand.setOnMouseClicked(eraseGate);
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
       or.setOnMouseClicked(eraseGate);
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
       nor.setOnMouseClicked(eraseGate);
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
       xor.setOnMouseClicked(eraseGate);
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
       xnor.setOnMouseClicked(eraseGate);
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
       not.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(not);
       
   }
   EventHandler<MouseEvent> eraseGate= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            Compuerta compuerta=(Compuerta)(t.getSource());
            if(t.isAltDown()){
                circuit.delete(compuerta.getID());
                compuerta.setImage(null);
            }
            if(t.isControlDown()){
                salida= compuerta.getID();
                startX= t.getSceneX()-100;
                startY= t.getSceneY()-25;
            }
            if (t.isShiftDown()){
                entrada = compuerta.getID();
                circuit.conectarCompuerta(salida, entrada);
                endX= t.getSceneX()-100;
                endY = t.getSceneY()-25;
                crearLinea();

            
                
                
                
                
            }
        }
    };
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
   EventHandler<MouseEvent> eraseLine= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            if(t.isAltDown()){
            Line linea=(Line)t.getSource();
            pane.getChildren().removeAll(linea);
            }
        }
   
   };
   public void crearLinea(){
        Line line=new Line();
        line.setStartX(startX); 
        line.setStartY(startY); 
        line.setEndX(endX); 
        line.setEndY(endY);
        line.setStrokeWidth(3);
        line.setOnMouseClicked(eraseLine);
        pane.getChildren().addAll(line);
       
   
   }
   /*public Color colorLine(){
       Color color= new Color();
       int r = 4;
       int g = 3;
       int b = 2;
       
   }*/
   
}

