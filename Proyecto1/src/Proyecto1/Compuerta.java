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
        this.valor = !inputs.search(false);
    }
}

class NAND extends Compuerta{

    public void opNAND(LinkedList inputs){
        this.valor = inputs.search(false);
    }
}

class OR extends Compuerta{
    public void opOR(LinkedList inputs){
        this.valor = inputs.search(true);
    }
}
