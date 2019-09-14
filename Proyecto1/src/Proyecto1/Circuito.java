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
    
    /**
     * Función que recibe un objeto (Compuerta) y la añade a la lista del circuito
     * @param nueva 
     */
    public void nuevaCompuerta(Object nueva){
        
        Compuerta comp =(Compuerta)nueva;
        comp.id=numero;
        circuito.insertFirst(nueva);
        numero++;
    
    }
    public void agregarEntrada(Object nueva){
       
        circuito.insertFirst(nueva);

    }
    /**
     * Método que recibe las IDs de las compuertas y guarda las conexiones entre ellas, toma el output y 
     * lo guarda en los inputs de la otra y viceversa
     * @param idOut
     * @param idIn 
     */
    public void conectarCompuerta(int idOut, int idIn){
        if (idIn==-1 || idIn==-2){
            System.out.println("Solo pueden ser inputs");
        }
        else{
            Compuerta salida= (Compuerta)circuito.searchByID(idOut);
            Compuerta entrada= (Compuerta)circuito.searchByID(idIn);
            entrada.InputGates.insertFirst(salida);
            salida.OutputGates.insertFirst(entrada);
            circuito.updateGates();   
            System.out.println("Compuerta "+idOut+" conectada con "+idIn);
    
        }
    }
    //Sin terminar
    public void desconectarCompuerta(int id1, int id2){
        Compuerta compuertaA = (Compuerta)circuito.searchByID(id1);
        Compuerta compuertaB = (Compuerta)circuito.searchByID(id2);
        //compuertaA.InputGates.

    }
    /**
     * Función para simular el circuito, actualiza los valores y luego revisa si hacen falta entradas e imprime un mensaje diciendo
     * que las llene y si no imprime el valor que tienen las compuertas de salida (Su output vací
     */
    public void simularCircuito(){
        circuito.updateGates();
        Node current = circuito.getHead();
        while (current != null){
            Compuerta actual = (Compuerta)current.getData();
            if (actual.getID()!= -1 && actual.getID() != -2){
                if (actual.InputGates.getSize()<2){
                    System.out.println("Rellene todos los valores de entrada en la compuerta "+actual.id);
                }
                else{
                    if (actual.OutputGates.getSize()==0){
                        System.out.println("Salida de la compuerta "+actual.getID()+"es: "+actual.isValor());
                    }
                }
            }
            current=current.getNext();
        }
    }
    
    /**
     * Función que elimina una compuerta del circuito según su Id
     * @param id de la compuerta
     */
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
   /**
    * Función para vere que hay dentro del circuito
    * @return La lista con todas las compuertas que fueron agregadas
    */
   public LinkedList getCircuito() {
        return circuito;
    } 
    
}
