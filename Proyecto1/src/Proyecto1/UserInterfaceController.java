/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


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
    LinkedList colores;
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
   
   @FXML
   public void addFalse(){
       Image imagen=new Image("Proyecto1/img/false.png");
       Falso falso=new Falso();
       falso.setImage(imagen);
       circuit.agregarEntrada(falso);
       falso.setOnMousePressed(pressGate);
       falso.setOnMouseDragged(dragGate);
       falso.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(falso);
       
   }
   @FXML
   public void addTrue(){
       Image imagen=new Image("Proyecto1/img/true.png");
       Verdadero verdadero=new Verdadero();
       verdadero.setImage(imagen);
       circuit.agregarEntrada(verdadero);
       verdadero.setOnMousePressed(pressGate);
       verdadero.setOnMouseDragged(dragGate);
       verdadero.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(verdadero);
   
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
                if (compuerta.getID()!=-1 && compuerta.getID()!=-2 ){
                    entrada = compuerta.getID();
                    circuit.conectarCompuerta(salida, entrada);
                    endX= t.getSceneX()-100;
                    endY = t.getSceneY()-25;
                    crearLinea();
                }
                else{
                    System.out.println("No se puede hacer la linea");
                }
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
        line.setStroke(colorLine());
        line.setOnMouseClicked(eraseLine);
        pane.getChildren().addAll(line);
        line.toBack();
   }
   
   public Color colorLine(){
       int r = (int) (Math.random() * 255);
       int g = (int) (Math.random() * 255);
       int b = (int) (Math.random() * 255);
       Color c = Color.rgb(r,g,b);
       return c;
   }
   
  
   
}

