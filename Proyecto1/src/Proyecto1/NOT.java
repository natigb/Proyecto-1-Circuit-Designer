
package Proyecto1;

/**
 * Clase para crear compuerta NOT
 * @author Natalia Gonzalez
 */
public class NOT extends Compuerta{
    /**
     * Operaciín ce una not, si hay un true devuelve false y si hay un false devuelve true
     */
    @Override
    public void operacion(){
        AND and = new AND();
        InputGates.insertFirst(and);
        Compuerta compuerta= (Compuerta)InputGates.getHead().getData();
        this.valor= !(compuerta.valor); 
    }
}
