/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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
    private final TableView<value> table = new TableView();
    value t = new value(true);
    value f = new value(false);
    int entradas;
    public Tabla(Circuito circuit) {
        this.circuit= circuit;
        entradas= (int)Math.pow(2,circuit.contarEntradas());
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
        setOutputColumns();
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
            TableColumn<value, Boolean> Input= new TableColumn<>("I"+counter);
            Input.setMinWidth(25);
            Input.setCellValueFactory(new PropertyValueFactory<value, Boolean>("ent"));
            //TableColumn Input = new TableColumn("I"+counter);
            //Input.setMinWidth(25);
            //Input.setVisible(true);
            table.setItems(getInputs());
            table.getColumns().add(Input);
            this.entradas = this.entradas/2;
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
    
    public ObservableList<value> getInputs(){
        int counter = entradas;
        int entradasi= (int) Math.pow(2,circuit.contarEntradas());
        //ObservableList<value> inputsf;
        ObservableList<value> inputs = FXCollections.observableArrayList();
        
        while (entradasi!=0){
            int counterf= counter/2;
            int countert= counter/2;
            while (counterf!=0){
                inputs.add(f);
                counterf--;
                entradasi--;
            }
            while (countert!=0){
                inputs.add(t);
                countert--;
                entradasi--;
            
           }
            
            
        }
        
        return inputs;
        
    }
    public void setInputRows(){
        
        
        
    }
    
    
}


