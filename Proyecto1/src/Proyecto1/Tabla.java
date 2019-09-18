/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.util.Iterator;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Nati Gonzalez
 */
public class Tabla{
    Circuito circuit;
    private final TableView table = new TableView();
    public Tabla(Circuito circuit) {
        this.circuit= circuit;
    }
    
    public void crearTabla(){
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("Truth Table");
        stage.setWidth(600);
        stage.setHeight(600);

        final Label label = new Label("Tabla de Verdad");
        label.setFont(new Font("Arial", 20));
        
        setInputColumns();
        //setOutputColumns();
        //table.setItems(getInputs());
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public void setInputColumns(){
        int counter = circuit.contarEntradas();
        while (counter != 0){
            TableColumn column= new TableColumn("I"+counter);
            column.setMinWidth(25);
            column.setCellValueFactory(row -> {
            Iterator<Boolean>iterator = row.getValue().iterator();
            for (int i =0; i<4;++i){
                iterator.next();
            }
            return new SimpleBooleanProperty(iterator.next()).asObject();});
            table.getColumns().add(column);
            
            //TableColumn Input = new TableColumn("I"+counter);
            //Input.setMinWidth(25);
            //Input.setVisible(true);
            table.setItems(getInputs());
            table.getColumns().add(column);
            //table.setItems(getInputs());
            
            
            
            counter--;
        }
    }
    public void setOutputColumns(){
        int counter = circuit.contarSalidas();
        while (counter != 0){
            TableColumn Output = new TableColumn("O"+counter);
            Output.setMinWidth(25);
            table.getColumns().addAll(Output);
            counter--;
        }
    }
    
    public ObservableList<Boolean> getInputs(){
        int entradasi= (int) Math.pow(2,circuit.contarEntradas());
        //ObservableList<value> inputsf;
        ObservableList<Boolean> inputs = FXCollections.observableArrayList();
        
        inputs.add(false);
        inputs.add(false);
        inputs.add(false);
        inputs.add(false);

        return inputs;
        
    
    }
    public void setInputRows(){
        
        
        
    }
    
    
}


