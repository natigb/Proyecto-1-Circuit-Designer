
package Proyecto1;

/**
 * Clase para crear una compuerta XNOR
 * @author Natalia Gonzalez
 */
public class XNOR extends Compuerta{
    /**
     * Operación ce una xnor, si hay una cantidad impares de true devuelve false
     */
    @Override
    public void operacion(){
        this.valor= !(searchAmount(true)%2!=0);
    }
}
