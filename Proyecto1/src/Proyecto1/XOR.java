
package Proyecto1;

/**
 * Clase para crear una compuerta XOR
 * @author Nati Gonzalez
 */
public class XOR extends Compuerta{
    /**
     * Operación ce una xor, si hay una cantidad impares de true devuelve true
     */
    @Override
    public void operacion(){
        this.valor= (searchAmount(true)%2!=0);
    }
}