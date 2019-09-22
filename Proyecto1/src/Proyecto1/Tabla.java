/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.util.Iterator;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    int rows;
    Circuito circuit;
    private final TableView<ObservableList<Integer>> table;
    
    public Tabla(Circuito circuit) {
        this.rows = 0;
        this.circuit= circuit;
        this.table=new TableView();
    }
    
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

    public void setColumns(){
        int counter = circuit.contarEntradas()+circuit.contarSalidas();
        int columnas=circuit.contarEntradas()+circuit.contarSalidas()-1;
        int counterIn = circuit.contarEntradas();

        int ents =0;
        int sals =0;
        while (counter!=0){
            TableColumn<ObservableList<Integer>,Integer> column= new TableColumn();
            if (counterIn!=0){
                column.setText("I"+ents);
                ents++;
                counterIn--;}
            else{
                column.setText("O"+sals);
                sals++;
            }
            column.setMinWidth(25);
            //column.setCellValueFactory(new PropertyValueFactory<Boolean, Boolean>("ent"+ents));
            column.setCellValueFactory(row -> {
            Iterator<Integer>iterator = row.getValue().iterator();
            for (int i =0; i<columnas;++i){
                iterator.next();
            }
            return new SimpleIntegerProperty(iterator.next()).asObject();});
            
            table.getColumns().addAll(column);

            counter--;
            
        }
                    //table.setItems(getInputs());
       

    }
    
    
    public ObservableList<Integer> getInputs(){
        int entradas= circuit.contarEntradas();
        ObservableList<Integer> inputs = FXCollections.observableArrayList();
        
        String numB = Integer.toBinaryString(rows);
        while (numB.length()<entradas){
            numB= "0"+numB;

        }
        for(int i=0; i<numB.length(); i++){
            inputs.add(Integer.parseInt(Character.toString(numB.charAt(i))));
       }
            
      
        
        System.out.println(inputs);
        return inputs;
        
    
    }
    
   public void setRows(){
       int entradas= (int) Math.pow(2,circuit.contarEntradas());
       while (entradas != 0){
           
           table.getItems().addAll(getInputs());
           entradas--;
           rows++;
       }
   }
    
    
    
}


