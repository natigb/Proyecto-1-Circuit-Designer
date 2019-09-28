
package Proyecto1;

/**
 * Clase para crear una compuerta NOR
 * @author Natalia Gonzalez
 */
public class NOR extends Compuerta{
    /**
     * Operacion de una nor, si hay un true. devuelve true
     */
    @Override
    public void operacion(){
        this.valor = !(searchAmount(true)!=0);
    } 
}