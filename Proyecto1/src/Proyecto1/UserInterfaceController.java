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
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Nati Gonzalez
 */
public class UserInterfaceController implements Initializable {
    
    Circuito circuit = new Circuito();
    LinkedList savedGates= new LinkedList();
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
    
    @FXML
    private VBox vbox;
    
    

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
       circuit.outputs.printList();
       circuit.inputs.printList();

       
   }
   @FXML
   public void resetPane(){
       pane.getChildren().clear();
   }
   @FXML
   public void guardarCircuito(){
        resetPane();
        
        Image imagen=new Image("Proyecto1/img/new.png");
        USERGATE usrgate =new USERGATE(circuit.circuito);
        int inputs= usrgate.inputs.getSize();
        int outputs = usrgate.outputs.getSize();
        String nombre = JOptionPane.showInputDialog("Nombre del circuito");
        usrgate.label.setText(nombre+"("+inputs+"IN/"+outputs+"OUT"+")");
        usrgate.label.setLayoutY(100);
        usrgate.setImage(imagen);
        
        
        Group g = new Group();
        g.setOnMousePressed(pressGate);
        g.setOnMouseDragged(dragGate);
        g.setOnMouseClicked(userGateEvents);
        g.getChildren().addAll(usrgate,usrgate.label);
        
        int y = 0;
        for (int i=0; i< inputs;i++){
            Label label = new Label(Integer.toString((int)usrgate.inputs.searchByIndex(i)));
            label.setLayoutY(y);
            label.setOnMouseClicked(userLabelEvents);
            g.getChildren().add(label);
            y+=10;
        }
        y=0;
        for (int i=0; i< outputs;i++){
            Label label = new Label(Integer.toString((int)usrgate.outputs.searchByIndex(i)));
            label.setLayoutY(y);
            label.setLayoutX(80);
            label.setOnMouseClicked(userLabelEvents);
            g.getChildren().add(label);
            y+=10;
        }
        
        
        pane.getChildren().addAll(g);  
        
        

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
       and.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(and,and.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
       
   }
   
   @FXML 
   public void crearNAND(){
       Image imagen=new Image("Proyecto1/img/nand.png");
       NAND nand =new NAND();
       circuit.nuevaCompuerta(nand);
       nand.label.setText("NAND"+Integer.toString(nand.getID()));
       nand.label.setLayoutY(80);
       nand.setImage(imagen);
       nand.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(nand,nand.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
   }
   
   @FXML 
   public void crearOR(){
       Image imagen=new Image("Proyecto1/img/or.png");
       OR or =new OR();
       circuit.nuevaCompuerta(or);
       or.label.setText("OR"+Integer.toString(or.getID()));
       or.label.setLayoutY(80);
       or.setImage(imagen);
       or.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(or,or.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
   }
   @FXML 
   public void crearNOR(){
       Image imagen=new Image("Proyecto1/img/nor.png");
       NOR nor =new NOR();
       circuit.nuevaCompuerta(nor);
       nor.label.setText("NOR"+Integer.toString(nor.getID()));
       nor.label.setLayoutY(80);
       nor.setImage(imagen);
       nor.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(nor,nor.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
   }
   
   @FXML 
   public void crearXOR(){
       Image imagen=new Image("Proyecto1/img/xor.png");
       XOR xor =new XOR();
       circuit.nuevaCompuerta(xor);
       xor.label.setText("XOR"+Integer.toString(xor.getID()));
       xor.label.setLayoutY(80);
       xor.setImage(imagen);
       xor.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(xor,xor.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
   }
   
   @FXML 
   public void crearXNOR(){
       Image imagen=new Image("Proyecto1/img/xnor.png");
       XNOR xnor =new XNOR();
       circuit.nuevaCompuerta(xnor);
       xnor.label.setText("XNOR"+Integer.toString(xnor.getID()));
       xnor.label.setLayoutY(80);
       xnor.setImage(imagen);
       xnor.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(xnor,xnor.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
   }
   
   @FXML 
   public void crearNOT(){
       Image imagen=new Image("Proyecto1/img/not.png");
       NOT not =new NOT();
       circuit.nuevaCompuerta(not);
       not.label.setText("NOT"+Integer.toString(not.getID()));
       not.label.setLayoutY(80);
       not.setImage(imagen);
       not.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(not,not.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
       
   }
   
   
   @FXML
   public void addEntrada(){
       Image imagen=new Image("Proyecto1/img/true.png");
       Entrada input=new Entrada();
       input.setImage(imagen);
       circuit.agregarEntrada(input);
       input.label.setText("i<"+Integer.toString(input.getID())+">");
       input.label.setLayoutY(40);
       input.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(input,input.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
   
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
            orgTranslateX=((Group)(t.getSource())).getTranslateX();
            orgTranslateY=((Group)(t.getSource())).getTranslateY();
           
        }
    };
   EventHandler<MouseEvent> dragGate= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            ((Group)(t.getSource())).setTranslateX(newTranslateX);
            ((Group)(t.getSource())).setTranslateY(newTranslateY);
            
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
   EventHandler<MouseEvent> userGateEvents= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            if(t.isAltDown()){
                Group g = (Group)(t.getSource());
                USERGATE usrgate=(USERGATE)(g.getChildren().get(0));
                for (int i=0;i<usrgate.getInputs().getSize();i++){
                    circuit.delete((int)usrgate.getInputs().searchByIndex(i));
                }
                for (int i=0;i<usrgate.getOutputs().getSize();i++){
                    circuit.delete((int)usrgate.getOutputs().searchByIndex(i));
                }
               
                pane.getChildren().remove(g);
                
                
                
            }
           
        }
    };
   EventHandler<MouseEvent> userLabelEvents= new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent t){
            Label label = (Label)t.getSource();
            int in = Integer.parseInt(label.getText());
            if (t.isShiftDown() && in<0){
                entrada = in;
                circuit.conectarCompuerta(salida, entrada);
                endX= t.getSceneX()-100;
                endY = t.getSceneY()-25;
                crearLinea();
            }
            if (t.isControlDown() && in>=0){
                salida= in;
                startX= t.getSceneX()-100;
                startY= t.getSceneY()-25;
                
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

