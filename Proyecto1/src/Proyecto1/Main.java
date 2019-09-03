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
        
        
        LinkedList lista = new LinkedList();
        lista.insertFirst(false);
        lista.insertFirst(false);
        lista.insertFirst(false);
        lista.insertFirst(false);
        lista.insertFirst(false);
        
        
        
        
        XNOR comp = new XNOR();
        comp.opXNOR(lista);
        System.out.println(comp.valor);
        
        
        
        
        
        
    }
}
