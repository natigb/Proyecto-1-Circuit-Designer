
package Proyecto1;

import java.util.Iterator;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Clase encargada de realizar todas las operaciones relacionadas con la creación de la tabla de la verdad del circuito
 * @author Natalia Gonzalez
 */
public class Tabla{
    int rows;
    int columna;
    Circuito circuit;
    private final TableView<ObservableList<Integer>> table;
    
    public Tabla(Circuito circuit) {
        this.rows = 0;
        this.columna = 0;
        this.circuit= circuit;
        this.table=new TableView();
    }
    
    /**
     * Crea la ventana y la escena donde va a estar la tabla y manda a llamar a 
     * otros métodos que crean las filas y las columnas de dicha tabla
     */
    public void crearTabla(){
        Scene scene = new Scene(new Group());

        Stage stage = new Stage();
        stage.setTitle("Truth Table");
        stage.setWidth(600);
        stage.setHeight(600);
        
        final Label label = new Label("Tabla de Verdad");
        label.setFont(new Font("Arial", 20));
        table.setMaxSize(500, 500);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); 
       
        setColumns();
        
        setRows();
       
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Cuenta la cantidad de entradas y salidas que tiene el circuito para crear una equivalente de las columnas,
     * también toma el nombre de las entradas y salidas y se lo coloca a cada columna y también tiene una función que 
     * al crear las columnas le dice que datos de la lista observable tomar.
     */
    private void setColumns(){
        int counter = circuit.contarEntradas()+circuit.contarSalidas();
        int counterIn = circuit.contarEntradas();

        int ents =0;
        int sals =0;
        LinkedList inputIds = circuit.getInputIDs();
        LinkedList outputIds = circuit.getOutputIDs();
        while (counter!=0){
            TableColumn<ObservableList<Integer>,Integer> column= new TableColumn();
            if (counterIn!=0){
                int numIn = (int)inputIds.searchByIndex(ents);
                column.setText("i<"+numIn+">");
                ents++;
                counterIn--;}
            else{
                int numOut = (int)outputIds.searchByIndex(sals);
                column.setText("o<"+numOut+">");
                sals++;
            }
            column.setMinWidth(25);
            int columnaActual =columna;
            column.setCellValueFactory(row -> {
            Iterator<Integer>iterator = row.getValue().iterator();
            for (int i =0; i<columnaActual;++i){
                iterator.next();
            }
            return new SimpleIntegerProperty(iterator.next()).asObject();});
            
            table.getColumns().addAll(column);
            columna++;
            counter--;
            
        }
       
    }
    
    /**
     * Crea las filas de la tabla, cuenta la cantidad de entradas n que hay y crea 2^n filas con todas las combinaciones 
     * de 1s y 0s que pueden tener. Para rellenar cada fila llama a la función getInfo()
     */
    private void setRows(){
       int entradas= (int) Math.pow(2,circuit.contarEntradas());
       while (entradas != 0){
           
           table.getItems().addAll(getInfo());
           entradas--;
           rows++;
       }
   }
    /**
     * Método que crea cada fila de la lista. Toma la variable rows que es un contador de la fila en la que se encuentra
     * la convierte a binario y dependiendo de las entradas agrega los 0s a la izquierda que necesita para completar la fila 
     * y la agrega a la lista observable, luego toma este valor de entrada, se lo manda al circuito y toma los outputs generados
     * y lo agrega a la lista
     * @return La lista completa con outputs e inputs en orden
     */
    private ObservableList<Integer> getInfo(){
        int entradas= circuit.contarEntradas();
        LinkedList ins = new LinkedList();
        ObservableList<Integer> inputs = FXCollections.observableArrayList();
        
        String numB = Integer.toBinaryString(rows);
        while (numB.length()<entradas){
            numB= "0"+numB;
        }
        for(int i=0; i<numB.length(); i++){
            inputs.add(Integer.parseInt(Character.toString(numB.charAt(i))));
            if (Integer.parseInt(Character.toString(numB.charAt(i)))== 0){
                ins.insertLast(false);
            }
            else{ins.insertLast(true);}
        }
        circuit.changeInputs(ins);
        
        LinkedList outs = circuit.getOutputValues();
        int out =0;
        while(out < circuit.contarSalidas()){
            if ((Boolean)outs.searchByIndex(out)){
                inputs.add(1);
            }
            else {inputs.add(0);}
            out++;
        }
        //outs.printList();
        //System.out.println(inputs);
        return inputs;
        
    
    }
    
   
    
    
    
}


