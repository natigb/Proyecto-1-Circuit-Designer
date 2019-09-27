/*
 * Instituto Tecnológico de Costa Rica
 * Estudiante: Natalia González
 */
package Proyecto1;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

/**
 * Clase Padre compuerta que de ella se derivan las clases de las que se van a crear los objetos que van a objetos 
 * @author Natalia Gonzalez
 */
public class Compuerta extends ImageView{
    int id;
    LinkedList InputGates;
    LinkedList OutputGates;
    boolean valor;
    Label label;
    
    
    public Compuerta(){
        InputGates=new LinkedList();
        OutputGates= new LinkedList();
        label= new Label();
        label.setFont(new Font("Simular",15));
        label.setTextFill(Color.web("#ffde00", 0.8));

        
    }
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
 
class AND extends Compuerta{
    /**
     * Operación de una and, si hay aunque sea un false, retorna un false
     */
    @Override
    public void operacion(){
        this.valor = !(searchAmount(false)!=0);
    }
}

class NAND extends Compuerta{
    /**
     * Operación de una nand, si hay un true, retorna true
     */
    @Override
    public void operacion(){
        this.valor = (searchAmount(false)!=0);
    }
}

class OR extends Compuerta{
    /**
     * Operacion de una or, si hay un true. devuelve false
     */
    @Override
    public void operacion(){
        this.valor = (searchAmount(true)!=0);
    }
}
class NOR extends Compuerta{
    /**
     * Operacion de una nor, si hay un true. devuelve true
     */
    @Override
    public void operacion(){
        this.valor = !(searchAmount(true)!=0);
    } 
}
class NOT extends Compuerta{
    /**
     * Operaciín ce una not, si hay un true devuelve false y si hay un false devuelve true
     */
    @Override
    public void operacion(){
        AND and = new AND();
        InputGates.insertFirst(and);
        Compuerta compuerta= (Compuerta)InputGates.getHead().getData();
        this.valor= !(compuerta.valor); 
    }
}

class XOR extends Compuerta{
    /**
     * Operación ce una xor, si hay una cantidad impares de true devuelve true
     */
    @Override
    public void operacion(){
        this.valor= (searchAmount(true)%2!=0);
    }
}

class XNOR extends Compuerta{
    /**
     * Operación ce una xnor, si hay una cantidad impares de true devuelve false
     */
    @Override
    public void operacion(){
        this.valor= !(searchAmount(true)%2!=0);
    }
}
    
class Entrada extends Compuerta{
    
    public Entrada() {
        this.valor=true;
    }
    /**
     * Si tiene algo en la entrada entonces devuelve el valor que tiene en la primera posición
     */
    @Override
    public void operacion(){
        if (this.InputGates.getSize()!=0){
           Compuerta c =(Compuerta)InputGates.getHead().getData();
           this.valor= c.valor;
        }
    }
    /**
     * Si el valor de entrada es false lo cambia a true y viceversa
     */
    public void change(){
        if (valor){
            this.valor=false;
        }
        else{
            this.valor=true;
        }
        System.out.println("Cambio");
        }
    /**
     * Establece el valor a true
     */
    public void setToTrue(){
        this.valor = true;
    }
    /**
     * Establece el valor a false
     */
    public void setToFalse(){
        this.valor = false;
    }   
}

class USERGATE extends Compuerta{
    LinkedList circuito;
    LinkedList inputs;
    LinkedList outputs;

    public USERGATE(LinkedList circuito) {
        this.circuito = circuito;
        this.inputs = inputIDs();
        this.outputs = outputIDs();

    }
    
    public LinkedList inputIDs(){
        LinkedList inputIds= new LinkedList();
        Node current = circuito.getHead();
        while (current!=null){
            Compuerta compuerta = (Compuerta)current.getData();
            if (compuerta.getID()<0 && compuerta.InputGates.getSize()==0){
                inputIds.insertFirst(compuerta.getID());
            }
            current= current.getNext();
        }
        return inputIds;
    }
    
    public LinkedList outputIDs(){
        LinkedList outputIds= new LinkedList();
        Node current = circuito.getHead();
        while (current!=null){
            Compuerta compuerta = (Compuerta)current.getData();
            if (compuerta.getID()>=0 && compuerta.OutputGates.getSize()==0){
                outputIds.insertFirst(compuerta.getID());
            }
            current= current.getNext();
        }
        return outputIds;
    }
    public LinkedList getCircuito() {
        return circuito;
    }

    public void setCircuito(LinkedList circuito) {
        this.circuito = circuito;
    }

    public LinkedList getInputs() {
        this.inputs = inputIDs();
        return inputs;
    }

    public void setInputs(LinkedList inputs) {
        this.inputs = inputs;
    }

    public LinkedList getOutputs() {
        this.outputs = outputIDs();
        return outputs;
    }

    public void setOutputs(LinkedList outputs) {
        this.outputs = outputs;
    }
    
    


}

        
    



