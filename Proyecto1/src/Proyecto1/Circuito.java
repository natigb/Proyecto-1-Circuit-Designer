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
    /**
     * Método que recibe las IDs de las compuertas y guarda las conexiones entre ellas
     * @param idOut
     * @param idIn 
     */
    public void conectarCompuerta(int idOut, int idIn){
        Compuerta salida= (Compuerta)circuito.searchByID(idOut);
        Compuerta entrada= (Compuerta)circuito.searchByID(idIn);
        entrada.InputGates.insertFirst(salida);
        salida.OutputGates.insertFirst(entrada);
        entrada.inputs.insertFirst(salida.valor);
        
        
        
        
    }
}
