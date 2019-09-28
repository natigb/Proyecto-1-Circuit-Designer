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
public class USERGATE extends Compuerta{
    LinkedList circuito;
    LinkedList inputs;
    LinkedList outputs;

    public USERGATE(LinkedList circuito) {
        this.circuito = circuito;
        this.inputs = inputIDs();
        this.outputs = outputIDs();

    }
    
    /**
     * Función que mete en una lista todos los IDs de los inputs de las compuertas
     * @return Lista enlazada con los Ids de las compuertas de entrada
     */
    public LinkedList inputIDs(){
        LinkedList inputIds= new LinkedList();
        Node current = circuito.getHead();
        while (current!=null){
            Compuerta compuerta = (Compuerta)current.getData();
            if (compuerta.getID()<0 && compuerta.InputGates.getSize()==0){
                inputIds.insertFirst(compuerta.getID());
            }
            current= current.getNext();
        }
        return inputIds;
    }
    /**
     * Función que mete en una lista todos los IDs de los outputs de las compuertas
     * @return Lista enlazada con los Ids de las compuertas de salida
     */
    public LinkedList outputIDs(){
        LinkedList outputIds= new LinkedList();
        Node current = circuito.getHead();
        while (current!=null){
            Compuerta compuerta = (Compuerta)current.getData();
            if (compuerta.getID()>=0 && compuerta.OutputGates.getSize()==0){
                outputIds.insertFirst(compuerta.getID());
            }
            current= current.getNext();
        }
        return outputIds;
    }
    
    public LinkedList getCircuito() {
        return circuito;
    }

    public void setCircuito(LinkedList circuito) {
        this.circuito = circuito;
    }

    public LinkedList getInputs() {
        this.inputs = inputIDs();
        return inputs;
    }

    public void setInputs(LinkedList inputs) {
        this.inputs = inputs;
    }

    public LinkedList getOutputs() {
        this.outputs = outputIDs();
        return outputs;
    }

    public void setOutputs(LinkedList outputs) {
        this.outputs = outputs;
    }
    
    


}

