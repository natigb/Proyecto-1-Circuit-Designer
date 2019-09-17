/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Nati Gonzalez
 */
public class UserInterfaceController implements Initializable {
    
    Circuito circuit = new Circuito();
    int entrada;
    int salida;
    int counter;
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
   public void simularCircuito(){
       circuit.circuito.printList();
       circuit.simularCircuito();
       System.out.println("In "+circuit.contarEntradas());
       System.out.println("Out "+circuit.contarSalidas());

       
   }
   @FXML
   public void resetPane(){
       circuit.circuito.clearList();
       circuit.numId = 0;
       circuit.numIn = 0;
       pane.getChildren().clear();
   }
   @FXML
   public void tabla(){
      Tabla tabla = new Tabla(circuit);
      tabla.crearTabla();
   }
   
   @FXML 
   public void crearAND(){
       Image imagen=new Image("Proyecto1/img/and.png");
       AND and =new AND();
       circuit.nuevaCompuerta(and);
       and.label.setText("AND"+Integer.toString(and.getID()));
       and.label.setLayoutY(80);
       and.setImage(imagen);
       and.setOnMousePressed(pressGate);
       and.setOnMouseDragged(dragGate);
       and.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(and,and.label);
       
       
   }
   
   @FXML 
   public void crearNAND(){
       Image imagen=new Image("Proyecto1/img/nand.png");
       NAND nand =new NAND();
       circuit.nuevaCompuerta(nand);
       nand.label.setText("NAND"+Integer.toString(nand.getID()));
       nand.label.setLayoutY(80);
       nand.setImage(imagen);
       nand.setOnMousePressed(pressGate);
       nand.setOnMouseDragged(dragGate);
       nand.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(nand,nand.label);
       
   }
   
   @FXML 
   public void crearOR(){
       Image imagen=new Image("Proyecto1/img/or.png");
       OR or =new OR();
       circuit.nuevaCompuerta(or);
       or.label.setText("OR"+Integer.toString(or.getID()));
       or.label.setLayoutY(80);
       or.setImage(imagen);
       or.setOnMousePressed(pressGate);
       or.setOnMouseDragged(dragGate);
       or.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(or,or.label);
       
   }
   @FXML 
   public void crearNOR(){
       Image imagen=new Image("Proyecto1/img/nor.png");
       NOR nor =new NOR();
       circuit.nuevaCompuerta(nor);
       nor.label.setText("NOR"+Integer.toString(nor.getID()));
       nor.label.setLayoutY(80);
       nor.setImage(imagen);
       nor.setOnMousePressed(pressGate);
       nor.setOnMouseDragged(dragGate);
       nor.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(nor,nor.label);
       
   }
   
   @FXML 
   public void crearXOR(){
       Image imagen=new Image("Proyecto1/img/xor.png");
       XOR xor =new XOR();
       circuit.nuevaCompuerta(xor);
       xor.label.setText("XOR"+Integer.toString(xor.getID()));
       xor.label.setLayoutY(80);
       xor.setImage(imagen);
       xor.setOnMousePressed(pressGate);
       xor.setOnMouseDragged(dragGate);
       xor.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(xor, xor.label);
       
   }
   
   @FXML 
   public void crearXNOR(){
       Image imagen=new Image("Proyecto1/img/xnor.png");
       XNOR xnor =new XNOR();
       circuit.nuevaCompuerta(xnor);
       xnor.label.setText("XNOR"+Integer.toString(xnor.getID()));
       xnor.label.setLayoutY(80);
       xnor.setImage(imagen);
       xnor.setOnMousePressed(pressGate);
       xnor.setOnMouseDragged(dragGate);
       xnor.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(xnor, xnor.label);
       
   }
   
   @FXML 
   public void crearNOT(){
       Image imagen=new Image("Proyecto1/img/not.png");
       NOT not =new NOT();
       circuit.nuevaCompuerta(not);
       not.label.setText("NOT"+Integer.toString(not.getID()));
       not.label.setLayoutY(80);
       not.setImage(imagen);
       not.setOnMousePressed(pressGate);
       not.setOnMouseDragged(dragGate);
       not.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(not, not.label);
       
   }
   
   
   @FXML
   public void addEntrada(){
       Image imagen=new Image("Proyecto1/img/true.png");
       Entrada entrada=new Entrada();
       entrada.setImage(imagen);
       circuit.agregarEntrada(entrada);
       entrada.setOnMousePressed(pressGate);
       entrada.setOnMouseDragged(dragGate);
       entrada.setOnMouseClicked(eraseGate);
       pane.getChildren().addAll(entrada);
   
   }
   
   EventHandler<MouseEvent> eraseGate= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            Compuerta compuerta=(Compuerta)(t.getSource());
            if(t.isAltDown()){
                circuit.delete(compuerta.getID());
                compuerta.setImage(null);
                compuerta.label.setText(null);
            }
            if(t.isControlDown()){
                
                salida= compuerta.getID();
                startX= t.getSceneX()-100;
                startY= t.getSceneY()-25;
            }
            if (t.isShiftDown()){
                if (compuerta.getID()>=0 ){
                    entrada = compuerta.getID();
                    circuit.conectarCompuerta(salida, entrada);
                    endX= t.getSceneX()-100;
                    endY = t.getSceneY()-25;
                    crearLinea();
                }
                else{
                    Entrada entrada=(Entrada)(t.getSource());
                    if (entrada.valor){
                        Image imagen=new Image("Proyecto1/img/false.png");
                        entrada.setImage(imagen);
                    }
                    else{
                        Image imagen=new Image("Proyecto1/img/true.png");
                        entrada.setImage(imagen);
                    }
                    entrada.change();
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
            ((Compuerta)(t.getSource())).label.setTranslateX(newTranslateX);
            ((Compuerta)(t.getSource())).label.setTranslateY(newTranslateY);
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
   EventHandler<MouseEvent> eraseLabel= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            if(t.isAltDown()){
                Label label=(Label)t.getSource();
                circuit.desconectarCompuerta(Integer.valueOf(label.getText().split("/")[0]),Integer.valueOf(label.getText().split("/")[1]));
                label.setText(null);
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
        Label label = new Label();
        label.setText(salida+"/"+entrada);
        label.setLayoutX(endX-50);
        label.setLayoutY(endY);
        label.setOnMouseClicked(eraseLabel);
        pane.getChildren().addAll(line, label);
        line.toBack();
        if (salida<0){
            counter++;
        }
   }
   
   public Color colorLine(){
       int r = (int) (Math.random() * 255);
       int g = (int) (Math.random() * 255);
       int b = (int) (Math.random() * 255);
       Color c = Color.rgb(r,g,b);
       return c;
   }
   
  
   
}

