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
public class Circuito {
    LinkedList circuito;
    int numero;

    public Circuito() {
        this.numero = 0;
        circuito= new LinkedList();
    }
    
    
    public void nuevaCompuerta(Object nueva){
        
        Compuerta comp =(Compuerta)nueva;
        comp.id=numero;
        circuito.insertFirst(nueva);
        numero++;
    
    }
    public void conectarCompuerta(int idIn, int IdOut){
        
        
    }
}
