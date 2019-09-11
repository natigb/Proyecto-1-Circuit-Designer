 /*
 * Clase LinkedList para crear listas enlazadas
 */
package Proyecto1;
/**
 * Es la clase que se encarga de las listas enlazadas, contiene métodos estándar como agregar nodos, eliminar nodos
 * y también métodos específicamente para una lista con solo objetos de la clase Compuerta para actualizar sus valores 
 * entre otras cosas
 * @author Natalia Gonzalez
 */

public class LinkedList{

    private Node head;
    private int size;
  
    public LinkedList(){
        this.head= null;
        this.size = 0;
    }
    /**
     * Función para saber si la lista está vacía
     * @return true si está vacía o false si no lo está
     */
    public boolean isEmpty(){
        return this.head == null;
    }
    
    
    /**
     * Función qe crea un nodo a partir de los datos que se ingresen y lo pone al inicio de la lista
     * @param data 
     */
    public void insertFirst(Object data){
        if (head==null){
            head = new Node(data);
        }
        else{
          Node temp = head;
          Node newNode = new Node(data);
          newNode.setNext(temp);
          head = newNode;
          
        }
        this.size++;

    }
   
    /**
     * Función que elimina el primer nodo de una lista
     * @return El nodo que se eliminó o null si la lista estaba vacía
     */
    public Node deleteFirst(){

        if (this.head != null) {
            Node temp = this.head;
            this.head = this.head.getNext();
            this.size--;
            return temp;

        }else{
             return null;

        }
    }
    /**
     * Función que busca un objeto en la lista y retorna la cantidad de veces que se encontró dicho parámetro
     * @param x 
     * @return La cantidad de veces que encontró a x en la lista
     */
    public int searchAmount(boolean x){ 
        int amount=0;
        Node current = head;
        
        while (current != null){ 
            Compuerta actual =(Compuerta)current.getData();
            if (actual.valor == x) 
                amount++; 
                 
            current = current.getNext(); 
        } 
        return amount;     
    }
    
    
    /**
     * Función que permite buscar un nodo de la lista por el ídice en el que se encuentra
     * @param index Indice de la lista que se quiere buscar
     * @return datos que contiene el nodo que se encuetra en ese índice
     */
    public Object searchByIndex(int index){
        int counter=0;
        Node temp= head;
        while (counter<index){
            temp=temp.getNext();
            counter++;
            
        }
        return temp.getData();
    } 
    /**
     * Función que busca un nodo en una lista de instancias de Compuerta según su atributo de ID
     * @param id
     * @return La información del nodo que tiene esa ID o null si la ID no existe
     */
    public Object searchByID(int id){
        Node current=head;
        while(current!=null){
            Compuerta actual= (Compuerta)current.getData();
            if(actual.id==id){
                return current.getData();
            }
            else{
                current=current.getNext();
            }
        }
        return null;
    }
    /**
     * Borra un elemento del circuito según el ID de la compuerta
     * @param id
     *  
     */
    public int getIndexbyID(int id){
        int counter =0;
        Node current=head;        
        while(current!=null){
            Compuerta actual= (Compuerta)current.getData();
            if(actual.id==id){
                return counter;
                
            }
            current=current.getNext();
            counter++;
            
        }
        return 0;
    }
    public void deleteByIndex(int index){
        if (index==0){
            head = head.getNext();
        }
        else{
            int counter = 0;
            Node current = head;
             while(counter<index-1){
                 current = current.getNext();
                 counter++;
             }
             current.setNext(current.getNext().getNext());
        }
        size--;
    }
   
    /**
     * Método para imprimir en consola una lista
     * 
     */
    public void printList() { 
        if (size==0){
            System.out.println("null");
        }
        Node current = head; 
        
        System.out.print("LinkedList: "); 
        while (current != null) { 
            System.out.print(current.getData() + " "); 
   
            current = current.getNext(); 
        } 
    }

    
    
    /**
     * Función para actualizar todos los valores de todas las compuertas que tiene un circuito
     */
    public void updateGates(){
        
        Node current = head;
        while (current != null){
            Compuerta actual = (Compuerta)current.getData();
            actual.operacion();
            current = current.getNext();
        }
    }
    
    /**
     * Función para saber el tamaño de la lista
     * @return El tamaño de la lista
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Función para obtener la cabeza de la lista
     * @return La cabeza de la lista
     */
    public Node getHead() {
        return head;
    }
    }

