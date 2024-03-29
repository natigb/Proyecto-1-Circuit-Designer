/*
 * Instituto Tecnológico de Costa Rica
 * Estudiante: Natalia González
 */
package Proyecto1;

import javax.swing.JOptionPane;

/**
 * Clase Circuito se encarga de guardar, conectar, eliminar y ejecutar circuitos de compuertas lógicas
 * @author Natalia Gonzalez
 */
public class Circuito {
   
    LinkedList circuito;
    LinkedList inputIds;
    LinkedList outputs;
    LinkedList outputIds;
    int numId;
    int numIn;

    public Circuito() {
        this.numId = 0;
        this.numIn = -1;
        circuito = new LinkedList();
        
        outputs = new LinkedList();
        inputIds = new LinkedList();
        outputIds = new LinkedList();
    }
    
    /**
     * Función que recibe un objeto (Compuerta) y la añade a la lista del circuito
     * @param nueva 
     */
    public void nuevaCompuerta(Object nueva){
        
        Compuerta comp =(Compuerta)nueva;
        comp.id=numId;
        circuito.insertFirst(nueva);
        numId++;
    
    }
    /**
     * Agrega una entrada al circuito
     * @param nueva Es la entrada que se debe agregar
     */
    public void agregarEntrada(Object nueva){
        Entrada ent = (Entrada)nueva;
        ent.id=numIn;
        circuito.insertFirst(nueva);
        numIn--;

    }
    /**
     * Función que recibe una lista de compuertas y las agrega al circuito
     * @param list
     * @return 
     */
    public LinkedList agregarCircuito (LinkedList list){
        Node current = list.getHead();
        while (current!=null){
            Compuerta compuerta = (Compuerta)current.getData();
            circuito.insertFirst(compuerta);
            current = current.getNext();
        }
        return list;
    }
    /**
     * Método que recibe las IDs de las compuertas y guarda las conexiones entre ellas, toma el output y 
     * lo guarda en los inputs de la otra y viceversa
     * @param idOut
     * @param idIn 
     */
    public void conectarCompuerta(int idOut, int idIn){
        
            Compuerta salida= (Compuerta)searchByID(idOut);
            Compuerta entrada= (Compuerta)searchByID(idIn);
            entrada.InputGates.insertFirst(salida);
            salida.OutputGates.insertFirst(entrada);
            updateGates();   
            System.out.println("Compuerta "+idOut+" conectada con "+idIn);
    
    }
    /**
     * Desconecta dos compuertas 
     * @param idOut
     * @param idIn 
     */
    public void desconectarCompuerta(int idOut, int idIn){
        Compuerta compuertaA = (Compuerta)searchByID(idOut);
        Compuerta compuertaB = (Compuerta)searchByID(idIn);
        compuertaA.OutputGates.deleteByIndex(compuertaA.OutputGates.getIndexbyID(idIn));
        compuertaB.InputGates.deleteByIndex(compuertaB.InputGates.getIndexbyID(idOut));
        System.out.println("Se ha desconectado la compuerta "+idOut+"de la "+idIn);
    }
    
    /**
     * Función para simular el circuito, actualiza los valores y luego revisa si hacen falta entradas e imprime un mensaje diciendo
     * que las llene y si no imprime el valor que tienen las compuertas de salida (Su output vací
     */
    public void simularCircuito(){
        updateGates();
        
        Node current = circuito.getHead();
        while (current != null){
            Compuerta actual = (Compuerta)current.getData();
            if (actual.getID()>=0){
                if (actual.InputGates.getSize()<2 && actual.getClass()!=(new NOT().getClass())){
                    JOptionPane.showMessageDialog(null,"Rellene todos los valores de entrada en la compuerta "+actual.id);
                    System.out.println("Rellene todos los valores de entrada en la compuerta "+actual.id);
                }
                else{
                    if (actual.OutputGates.getSize()==0){
                        JOptionPane.showMessageDialog(null,"Salida de la compuerta #"+actual.getID()+" es: "+actual.isValor() );
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
        Compuerta compuerta = (Compuerta)searchByID(id);
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
        updateGates();
        
       
    }
    
   /**
    * Retorna la cantidad de entradas del circuito
    * @return La cantidad de entradas que tiene el circuito 
    */
   public int contarEntradas(){
       int counter= 0;
       inputIds.clearList();
       Node current = circuito.getHead();
       while (current != null){
           Compuerta temporal = (Compuerta)current.getData();
           if (temporal.id < 0 && temporal.InputGates.getSize()==0){
               counter++;
               inputIds.insertFirst(temporal.id);
           }
           current = current.getNext();
       }
       return counter;
   }
   /**
    * Retorna la cantidad de salidas del circuito
    * @return La cantidad de salidas que tiene el circuito 
    */
   public int contarSalidas(){
       int counter= 0;
       outputs.clearList();
       outputIds.clearList();
       Node current = circuito.getHead();
       while (current != null){
           Compuerta temporal = (Compuerta)current.getData();
           if (temporal.OutputGates.getSize() == 0 && temporal.id >= 0){
               counter++;
               outputs.insertLast(temporal.valor);
               outputIds.insertLast(temporal.getID());
           }
           updateGates();
           current = current.getNext();
       }
       return counter;
   }
   /**
     * Función para actualizar todos los valores de todas las compuertas que tiene un circuito
     */
    public void updateGates(){
        
        Node current = circuito.getHead();
        while (current != null){
            Compuerta actual = (Compuerta)current.getData();
            actual.operacion();
            current = current.getNext();
        }
    }
   /**
     * Función que busca un nodo en una lista de instancias de Compuerta según su atributo de ID
     * @param id
     * @return La información del nodo que tiene esa ID o null si la ID no existe
     */
    public Object searchByID(int id){
        Node current= circuito.getHead();
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
    * Método que recibe una lista enlazada con las entradas nuevas que se le quiere asignar al circuito.
    * @param newInputs 
    */
   public void changeInputs(LinkedList newInputs){
       int i = 0;
       LinkedList inIDs = getInputIDs(); 
       while (i<newInputs.getSize()){
           Entrada entrada = (Entrada)searchByID((int)inIDs.searchByIndex(i));
           Boolean valor = (Boolean)newInputs.searchByIndex(i);
           if (valor){
               entrada.setToTrue();
           }
           else{
               entrada.setToFalse();
           }
           i++;
                   
       }
       
   }
   
   public LinkedList getInputIDs(){
       contarEntradas();
       return inputIds;
   }
   public LinkedList getOutputIDs(){
       contarSalidas();
       return outputIds;
   }
   public LinkedList getOutputValues(){
       updateGates();
       contarSalidas();
       return outputs;
   }
   /**
    * Función para ver que hay dentro del circuito
    * @return circuito La lista con todas las compuertas que fueron agregadas
    */
   public LinkedList getCircuito() {
        return circuito;
    } 
    
}
