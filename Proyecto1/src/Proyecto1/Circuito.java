/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 *
 * @author Natalia Gonzalez
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
        circuito.updateGates();   
    }
    public void desconectarCompuerta(int id1, int id2){
        Compuerta compuertaA = (Compuerta)circuito.searchByID(id1);
        Compuerta compuertaB = (Compuerta)circuito.searchByID(id2);
        //compuertaA.InputGates.

    }
    
    public void simularCircuito(){
        circuito.updateGates();
        Node current = circuito.getHead();
        while (current != null){
            Compuerta actual = (Compuerta)current.getData();
            if (actual.InputGates.getSize()<2){
                System.out.println("Rellene todos los valores de entrada en la compuerta "+actual.id);
            }
            else{
                if (actual.OutputGates.getSize()==0){
                    System.out.println("Salida de la compuerta "+actual.getID()+"es: "+actual.isValor());
                }
            }
            current=current.getNext();
        }
    }
    
    public LinkedList getCircuito() {
        return circuito;
    }
    public void delete(int id){
        Compuerta compuerta = (Compuerta)circuito.searchByID(id);
        Node currenti=compuerta.OutputGates.getHead();
        while (currenti!= null){
            Compuerta actual = (Compuerta)currenti.getData();
            actual.InputGates.deleteByIndex(actual.InputGates.getIndexbyID(id));
            currenti=currenti.getNext(); 
        }
        Node currento=compuerta.InputGates.getHead();
        while (currento!= null){
            Compuerta actual = (Compuerta)currento.getData();
            actual.OutputGates.deleteByIndex(actual.OutputGates.getIndexbyID(id));
            currento=currento.getNext(); 
        }
       
        circuito.deleteByIndex(circuito.getIndexbyID(id));
        circuito.updateGates();
    }
    
    
    
}
