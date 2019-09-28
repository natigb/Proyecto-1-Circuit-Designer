/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 * La clase se encarga de guardar los nodos que se enlazan en las listas. Guarda los datos que tiene el nodo y la 
 * referencia al nodo siguiente.
 * @author Natalia Gonzalez
 */
public class Node {
    
    private Object data;
    private Node next;
    
    /**
     * Crea un nodo con los datos especificados
     * @param data 
     */
    public Node(Object data){
        this.next= null;
        this.data = data;
    }
    /**
     * Para acceder a la infomación del nodo
     * @return data
     */
    public Object getData(){
        return this.data;

            }

    /**
     * Para editar a la infomación del nodo
     * 
     */
    public void setData(Object data){
        this.data = data;

    }
    
    /**
     * Método para obtener el nodo siguiente
     * @return el nodo al que está apuntando el actual
     */
    public Node getNext(){
        return this.next;

    }

    /**
     * Método para asignar quien es el nodo siguiente
     * @param node 
     */
    public void setNext(Node node){
        this.next = node;

    } 
}
