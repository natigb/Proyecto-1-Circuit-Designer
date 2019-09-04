/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.lang.reflect.Field;

/**
 *
 * @author Nati Gonzalez
 */

public class MainClass extends Application {
    private Stage primaryStage;
   
    
    @Override
    public void start(Stage stage) throws Exception {
        
        AND and = new AND();
        NAND nand = new NAND();
        OR or = new OR();
        OR or2 = new OR();
      
        and.inputs.insertFirst(true);
      
        or.inputs.insertFirst(true);
       
        
        Circuito cto1=new Circuito();
        
        cto1.nuevaCompuerta(or);
        cto1.nuevaCompuerta(and);
        cto1.nuevaCompuerta(nand);
        System.out.println(cto1.circuito.searchByID(3));
        
        //cto1.circuito.printList(cto1.circuito);
        
        
        

      
        
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        
        
        stage.setTitle("CIRCUIT DESIGNER");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    
        
        
    }
    
    
    public static void main(String[] args) {
        
       
        
        Application.launch(MainClass.class, args);
        
    }
    
   

}


