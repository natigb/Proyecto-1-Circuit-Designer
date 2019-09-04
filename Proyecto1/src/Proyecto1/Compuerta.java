/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author Nati Gonzalez
 */
public class Compuerta{
    int id;
    LinkedList inputs;
    LinkedList InputGates;
    LinkedList OutputGates;
    boolean valor;
    
    public Compuerta(){
        inputs=new LinkedList();
        OutputGates= new LinkedList();
    }
    public void operacion( ){
    }
    
}
  
class AND extends Compuerta{
    
    @Override
    public void operacion(){
        this.valor = !(inputs.searchAmount(false)!=0);
    }
}

class NAND extends Compuerta{

    @Override
    public void operacion(){
        this.valor = (inputs.searchAmount(false)!=0);
    }
}

class OR extends Compuerta{
    @Override
    public void operacion(){
        this.valor = (inputs.searchAmount(true)!=0);
    }
}
class NOR extends Compuerta{
    @Override
    public void operacion(){
        this.valor = !(inputs.searchAmount(true)!=0);
    } 
}
class NOT extends Compuerta{
    boolean inputs;
    @Override
    public void operacion(){
        this.valor= !inputs; 
    }
}

class XOR extends Compuerta{
    @Override
    public void operacion(){
        this.valor= (inputs.searchAmount(true)%2!=0);
    }
}

class XNOR extends Compuerta{
    @Override
    public void operacion(){
        this.valor= !(inputs.searchAmount(true)%2!=0);
    }
}
