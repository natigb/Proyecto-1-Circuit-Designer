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
   
    
    @Override
    public void start(Stage stage) throws Exception {
        
        AND and = new AND();
        AND and2 = new AND();
        AND and3 = new AND();
        NAND nand = new NAND();
        OR or = new OR();
        OR or2 = new OR();
        NOR nor =new NOR();
        XOR xor =new XOR();
        
        Circuito cto1=new Circuito();
       
        OR ent = new OR();
        OR ent2 = new OR();
        OR ent3 =new OR();
        ent.valor=false;
        ent2.valor=false;
        ent3.valor=false;
        LinkedList lista=new LinkedList();
        lista.insertFirst(ent);
        lista.insertFirst(ent2);
        LinkedList lista2=new LinkedList();
        lista2.insertFirst(ent3);
        
        cto1.nuevaCompuerta(or);//0
        cto1.nuevaCompuerta(and);//1
        and.InputGates=lista;
        cto1.nuevaCompuerta(nand);//2
        cto1.nuevaCompuerta(or2);//3
        or2.InputGates=lista2;
        cto1.nuevaCompuerta(and2);//4
        cto1.nuevaCompuerta(nor);//5 
        nor.InputGates=lista;
        cto1.nuevaCompuerta(and3);//6
        and3.InputGates=lista;
        cto1.nuevaCompuerta(xor);//7 
        
        
        cto1.conectarCompuerta(3, 0);
        cto1.conectarCompuerta(6, 7);
        cto1.conectarCompuerta(3, 2);
        cto1.conectarCompuerta(1, 2);
        cto1.conectarCompuerta(2, 7);
        cto1.conectarCompuerta(2, 4);
        cto1.conectarCompuerta(3, 4);
        cto1.conectarCompuerta(1, 0);
        cto1.conectarCompuerta(5, 3);
        cto1.conectarCompuerta(6, 4);
        cto1.conectarCompuerta(0, 4);
        
        
        //cto1.simularCircuito();
        
        
        cto1.circuito.printList();
        
        

        
        System.out.println("");
        cto1.circuito.printList();
        //cto1.simularCircuito();

        

      
        
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        
        
        stage.setTitle("CIRCUIT DESIGNER");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    
        
        
    }
    
    
    public static void main(String[] args) {
        
       
        
        Application.launch(MainClass.class, args);
        
    }
    
   

}


