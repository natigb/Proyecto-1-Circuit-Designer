/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Nati Gonzalez
 */
public class Tabla {
    Circuito circuit;
    Stage ventana;
    TableView<Tabla> tabla;
    public void crearTabla(){
        
        ventana.setTitle("Tabla de estudiantes");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(tabla);
        Scene escena = new Scene(vbox);
        ventana.setScene(escena);
        ventana.show(); 
    }
    
}
