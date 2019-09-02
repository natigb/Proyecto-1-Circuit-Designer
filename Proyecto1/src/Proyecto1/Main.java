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
public class Main {
    public static void main(String[] args){
        OR Comp = new OR();
        
        LinkedList lista = new LinkedList();
        lista.insertFirst(false);
        lista.insertFirst(false);
        lista.insertFirst(false);
        lista.insertFirst(false);
        lista.insertFirst(false);
        
        lista.printList(lista);
      
        Comp.inputs=lista;
        Comp.opOR(Comp.inputs);
        System.out.println("VALOR: "+Comp.valor);
        
        
        
    }
}
