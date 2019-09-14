/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

import javafx.scene.image.ImageView;

/**
 *
 * @author Nati Gonzalez
 */
public class Compuerta extends ImageView{
    int id;
    LinkedList InputGates;
    LinkedList OutputGates;
    boolean valor;
    
    
    
    public Compuerta(){
        InputGates=new LinkedList();
        OutputGates= new LinkedList();
        
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
    
}
 
class AND extends Compuerta{
    /**
     * Operación de una and, si hay aunque sea un false, retorna un false
     */
    @Override
    public void operacion(){
        this.valor = !(InputGates.searchAmount(false)!=0);
    }
}

class NAND extends Compuerta{
    /**
     * Operación de una nand, si hay un true, retorna true
     */
    @Override
    public void operacion(){
        this.valor = (InputGates.searchAmount(false)!=0);
    }
}

class OR extends Compuerta{
    /**
     * Operacion de una or, si hay un true. devuelve false
     */
    @Override
    public void operacion(){
        this.valor = (InputGates.searchAmount(true)!=0);
    }
}
class NOR extends Compuerta{
    /**
     * Operacion de una nor, si hay un true. devuelve ture
     */
    @Override
    public void operacion(){
        this.valor = !(InputGates.searchAmount(true)!=0);
    } 
}
class NOT extends Compuerta{
    
    @Override
    public void operacion(){
        this.valor= !((boolean)InputGates.getHead().getData()); 
    }
}

class XOR extends Compuerta{
    @Override
    public void operacion(){
        this.valor= (InputGates.searchAmount(true)%2!=0);
    }
}

class XNOR extends Compuerta{
    @Override
    public void operacion(){
        this.valor= !(InputGates.searchAmount(true)%2!=0);
    }
}
    
class Verdadero extends Compuerta{
    
    public Verdadero() {
        this.id=-1;
        this.valor=true;
        
    }
    
}
class Falso extends Compuerta{

    public Falso() {
        this.id=-2;
        this.valor=false;
    }
    
}

