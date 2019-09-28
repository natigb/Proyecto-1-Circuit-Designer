
package Proyecto1;

/**
 *  Clase para crear una compuerta AND
 * @author Natalia Gonzalez
 */
public class AND extends Compuerta{
    /**
     * Operación de una and, si hay aunque sea un false, retorna un false
     */
    @Override
    public void operacion(){
        this.valor = !(searchAmount(false)!=0);
    }
}
    

