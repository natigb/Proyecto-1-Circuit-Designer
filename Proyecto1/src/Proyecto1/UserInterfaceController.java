
package Proyecto1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 * Clase que se encarga de controlar todos los procesos relacionados con la interfaz gráfica de usuario
 * @author Nati Gonzalez
 */
public class UserInterfaceController implements Initializable {
    private Circuito circuit = new Circuito();
    private LinkedList encapsular = new LinkedList();
    private LinkedList savedGates= new LinkedList();
    private int savedGatesNum = 0;
    private int entrada;
    private int salida;
    private int counter;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;
    
    @FXML
    private Pane pane;
    
    @FXML
    private VBox vbox;
    
    @FXML
    private AnchorPane anchorpane;
    
    @FXML
    private ScrollPane scrollpane;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        anchorpane.getStyleClass().add("anchorpane");
        scrollpane.getStyleClass().addAll("scroll-pane","scroll-bar");
    }
   /**
    * MMétodo asociado a un botón que simula el circuito diseñado
    */
   @FXML
   public void simularCircuito(){
       
       circuit.circuito.printList();
       circuit.simularCircuito();
      
   }
   
   /**
    * Método asociado a un botón para eliminar todos los elementos del panel donde están las compuertas
    */
   @FXML
   public void resetPane(){
       pane.getChildren().clear();
   }
   
   /**
    * Método asociado a un botón que encapsula el circuito y lo pone en la paleta de circuitos
    */
   @FXML
   public void guardarCircuito(){
        resetPane();
        
        Image imagen=new Image("Proyecto1/img/new.png");
        USERGATE usrgate =new USERGATE(encapsular);
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
        savedGates.insertLast(g);
        int y = 0;
        for (int i=0; i< inputs;i++){
            Label label = new Label(Integer.toString((int)usrgate.inputs.searchByIndex(i)));
            label.setLayoutY(y);
            label.setOnMouseClicked(userLabelEvents);
            label.setFont(new Font("Simular",15));
            label.setTextFill(Color.web("#ffde00", 0.8));
            g.getChildren().add(label);
            y+=10;
        }
        y=0;
        for (int i=0; i< outputs;i++){
            Label label = new Label(Integer.toString((int)usrgate.outputs.searchByIndex(i)));
            label.setLayoutY(y);
            label.setLayoutX(80);
            label.setOnMouseClicked(userLabelEvents);
            label.setFont(new Font("Simular",15));
            label.setTextFill(Color.web("#ffde00", 0.8));
            g.getChildren().add(label);
            y+=10;
        }
        encapsular.clearList();
        Label gateNumber = new Label (savedGatesNum+": "+nombre);
        gateNumber.setFont(new Font("Simular",15));
        gateNumber.setTextFill(Color.web("#ffde00", 0.8));
        gateNumber.setOnMouseClicked(createUserGate);
        vbox.getChildren().add(gateNumber);
        
        savedGatesNum++;
        

   }
   
   /**
    * Método asociado a un botón que se encarga de llamar a la clase que crea la tabla de verdad del circuito.
    */
   @FXML
   public void tabla(){
      Tabla tabla = new Tabla(circuit);
      tabla.crearTabla();
        
        
        
   }
   
   /**
    * Función asociada a la imagen de una AND en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearAND(){
       Image imagen=new Image("Proyecto1/img/and.png");
       AND and =new AND();
       circuit.nuevaCompuerta(and);
       encapsular.insertFirst(and);
       and.label.setText("AND"+Integer.toString(and.getID())+" o<"+Integer.toString(and.getID())+">");
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
   /**
    * Función asociada a la imagen de una NAND en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearNAND(){
       Image imagen=new Image("Proyecto1/img/nand.png");
       NAND nand =new NAND();
       circuit.nuevaCompuerta(nand);
       encapsular.insertFirst(nand);

       nand.label.setText("NAND"+Integer.toString(nand.getID())+" o<"+Integer.toString(nand.getID())+">");
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
   /**
    * Función asociada a la imagen de una OR en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearOR(){
       Image imagen=new Image("Proyecto1/img/or.png");
       OR or =new OR();
       circuit.nuevaCompuerta(or);
       encapsular.insertFirst(or);
       or.label.setText("OR"+Integer.toString(or.getID())+" o<"+Integer.toString(or.getID())+">");
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
   /**
    * Función asociada a la imagen de una NOR en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearNOR(){
       Image imagen=new Image("Proyecto1/img/nor.png");
       NOR nor =new NOR();
       circuit.nuevaCompuerta(nor);
       encapsular.insertFirst(nor);
       nor.label.setText("NOR"+Integer.toString(nor.getID())+" o<"+Integer.toString(nor.getID())+">");
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
   /**
    * Función asociada a la imagen de una XOR en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearXOR(){
       Image imagen=new Image("Proyecto1/img/xor.png");
       XOR xor =new XOR();
       circuit.nuevaCompuerta(xor);
       encapsular.insertFirst(xor);
       xor.label.setText("XOR"+Integer.toString(xor.getID())+" o<"+Integer.toString(xor.getID())+">");
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
   /**
    * Función asociada a la imagen de una XNOR en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearXNOR(){
       Image imagen=new Image("Proyecto1/img/xnor.png");
       XNOR xnor =new XNOR();
       circuit.nuevaCompuerta(xnor);
       encapsular.insertFirst(xnor);
       xnor.label.setText("XNOR"+Integer.toString(xnor.getID())+" o<"+Integer.toString(xnor.getID())+">");
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
   /**
    * Función asociada a la imagen de una NOT en la paleta de compuertas que crea la compuerta y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML 
   public void crearNOT(){
       Image imagen=new Image("Proyecto1/img/not.png");
       NOT not =new NOT();
       circuit.nuevaCompuerta(not);
       encapsular.insertFirst(not);
       not.label.setText("NOT"+Integer.toString(not.getID())+" o<"+Integer.toString(not.getID())+">");
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
   
   /**
    * Función asociada a un botón del menú de una entrada en la paleta de compuertas que crea la entrada y la agrega al circuito
    * con todos los eventos asociados respectivos
    */
   @FXML
   public void addEntrada(){
       Image imagen=new Image("Proyecto1/img/true.png");
       Entrada input=new Entrada();
       input.setImage(imagen);
       circuit.agregarEntrada(input);
       encapsular.insertFirst(input);
       input.label.setText("i<"+Integer.toString(input.getID())+">");
       input.label.setLayoutY(45);
       input.label.setLayoutX(8);
       input.setOnMouseClicked(eraseGate);
       Group g = new Group();
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       g.getChildren().addAll(input,input.label);
       g.setOnMousePressed(pressGate);
       g.setOnMouseDragged(dragGate);
       pane.getChildren().addAll(g);
   
   }
   /**
    * Evento asociado a todas las compuertas creadas que se encarga de eliminiar una compuerta con Alt+click, La asigna
    * como salida a conectar con Ctrl+click y a entrada a conectar creando la línea con Shift+Click si es una compuerta normal
    * pero si es una entrada lo que hace es cambiar su valor de 1 o 0
    */
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
                    circuit.updateGates();
                }
            }
            
        }
    };
   
   /**
    * Evento para el drag and drop qe captura las coordenadas de la compuerta para después moverla
    */
   EventHandler<MouseEvent> pressGate= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX=((Group)(t.getSource())).getTranslateX();
            orgTranslateY=((Group)(t.getSource())).getTranslateY();
           
        }
    };
   
   /**
    * Evento para el drag and drop que toma las coordenadas de la compuerta y dependiendo de la posición del mouse
    * la arrastra
    */
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
   /**
    * Evento para eliminar la línea que representa las conexiones entre las compuertas
    */
   EventHandler<MouseEvent> eraseLine= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            if(t.isAltDown()){
                Line linea=(Line)t.getSource();
                pane.getChildren().removeAll(linea);
            }
        }
   };
   /**
    * Evento que elimina las etiquetas que se cren al conectar 2 compuertas entre ellas que es equivalernte
    * también a desconectar las compuertas
    */
   EventHandler<MouseEvent> eraseLabel= new EventHandler<MouseEvent>(){

        @Override
        public void handle(MouseEvent t) {
            if(t.isAltDown()){
                Label label=(Label)t.getSource();
                try{
                circuit.desconectarCompuerta(Integer.valueOf(label.getText().split("/")[0]),Integer.valueOf(label.getText().split("/")[1]));
                }catch (Exception e){
                    
                }
                label.setText(null);
            }
        }
   };
   
   /**
    * Evento para eliminar una compuerta de usuario de la interfaz
    */
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
   
   /**
    * Evento que asocia las etiqutas de la compuerta para poder realizar conexiones con otras compuertas
    */
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
   
   /**
    * Función que crea la compuerta de usuario a partir del label que se creó en la paleta de compuertas
    */
   EventHandler<MouseEvent> createUserGate= new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent t){
            Label l = (Label)(t.getSource());
            int groupIndex = Integer.parseInt(Character.toString(l.getText().charAt(0)));
            Group savedGroup = (Group)savedGates.searchByIndex(groupIndex);
            USERGATE savedGate=(USERGATE)savedGroup.getChildren().get(0);
            
            circuit.agregarCircuito(savedGate.circuito);
            
            pane.getChildren().addAll(savedGroup);  
            vbox.getChildren().removeAll(l);
            
        } 
   };
   
   /**
    * Método para crear la línea que representan las conexiones de las compuertas
    */
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
        label.setFont(new Font("Simular",15));
        label.setTextFill(Color.web("white", 0.8));
        label.setOnMouseClicked(eraseLabel);
        pane.getChildren().addAll(line, label);
        line.toBack();
        if (salida<0){
            counter++;
        }
   }
   
   /**
    * Método para asignar un color aleatorio a la linea
    * @return Un color aleatorio
    */
   public Color colorLine(){
       int r = (int) (Math.random() * 255);
       int g = (int) (Math.random() * 255);
       int b = (int) (Math.random() * 255);
       Color c = Color.rgb(r,g,b);
       return c;
   }
   
  
   
}

