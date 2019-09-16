/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nati Gonzalez
 */

public class MainClass extends Application {
   
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
        
        stage.setTitle("CIRCUIT DESIGNER");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    
    }
    
    
    public static void main(String[] args) {
        
        Application.launch(MainClass.class, args);
        
    }
    
   

}


