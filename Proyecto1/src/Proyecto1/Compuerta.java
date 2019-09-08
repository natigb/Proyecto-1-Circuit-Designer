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
public class Compuerta{
    int id;
    LinkedList InputGates;
    LinkedList OutputGates;
    boolean valor;
    ImageView imagen;
    
    
    public Compuerta(){
        InputGates=new LinkedList();
        OutputGates= new LinkedList();
        imagen= new ImageView();
    }
    public void operacion( ){
    }

    public int getID() {
        return id;
    }

    public boolean isValor() {
        return valor;
    }
    
}
  
class AND extends Compuerta{

    
    @Override
    public void operacion(){
        this.valor = !(InputGates.searchAmount(false)!=0);
    }
}

class NAND extends Compuerta{

    @Override
    public void operacion(){
        this.valor = (InputGates.searchAmount(false)!=0);
    }
}

class OR extends Compuerta{
    @Override
    public void operacion(){
        this.valor = (InputGates.searchAmount(true)!=0);
    }
}
class NOR extends Compuerta{
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
