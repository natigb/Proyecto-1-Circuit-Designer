
package Proyecto1;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Clase Padre compuerta que de ella se derivan las clases de las que se van a crear los objetos que van a formar
 * parte del circuito
 * @author Natalia Gonzalez
 */
public class Compuerta extends ImageView{
    int id;
    LinkedList InputGates;
    LinkedList OutputGates;
    boolean valor;
    Label label;
    
    /**
     * Inicializa InputGates, OutputGates y el label
     */
    public Compuerta(){
        InputGates=new LinkedList();
        OutputGates= new LinkedList();
        label= new Label();
        label.setFont(new Font("Simular",15));
        label.setTextFill(Color.web("#ffde00", 0.8));

        
    }
    /**
     * Operación dependiendo de cual compuerta se crea
     */
    public void operacion( ){
    }
    /**
     * Función para saber el ID de la compuerta
     * @return el ID de la compuerta
     */
    public int getID() {
        return id;
    }
    /**
     * Método que retorna el valor de la compuerta
     * @return el valor de la compuerta
     */
    public boolean isValor() {
        return valor;
    }
    /**
     * Función que busca un objeto en la lista y retorna la cantidad de veces que se encontró dicho parámetro
     * @param x 
     * @return La cantidad de veces que encontró a x en la lista
     */
    public int searchAmount(boolean x){ 
          int amount=0;
          Node current = InputGates.getHead();

          while (current != null){ 
              Compuerta actual =(Compuerta)current.getData();
              if (actual.valor == x) 
                  amount++; 

              current = current.getNext(); 
          } 
          return amount;     
      }  
  }
 