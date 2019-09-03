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
    LinkedList inputs;
    LinkedList outputs;
    boolean valor;
    
    
}
class AND extends Compuerta{
    
    public void opAND(LinkedList inputs){
        this.valor = !(inputs.search(false)!=0);
    }
}

class NAND extends Compuerta{

    public void opNAND(LinkedList inputs){
        this.valor = (inputs.search(false)!=0);
    }
}

class OR extends Compuerta{
    public void opOR(LinkedList inputs){
        this.valor = (inputs.search(true)!=0);
    }
}
class NOR extends Compuerta{
    public void opNOR(LinkedList inputs){
        this.valor = !(inputs.search(true)!=0);
    } 
}
class NOT extends Compuerta{
    boolean inputs;
    public void opNOT(boolean inputs){
    this.valor= !inputs; 
    }
}

class XOR extends Compuerta{
    public void opXOR(LinkedList inputs){
        this.valor= (inputs.search(true)%2!=0);
    }
}

class XNOR extends Compuerta{
    public void opXNOR(LinkedList inputs){
        this.valor= !(inputs.search(true)%2!=0);
    }
}
