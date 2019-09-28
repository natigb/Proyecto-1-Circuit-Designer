
package Proyecto1;

/**
 * Clase para crear entradas de los circuitos
 * @author Natalia Gonzalez
 */
public class Entrada extends Compuerta{
    
    public Entrada() {
        this.valor=true;
    }
    /**
     * Si tiene algo en la entrada entonces devuelve el valor que tiene en la primera posición
     */
    @Override
    public void operacion(){
        if (this.InputGates.getSize()!=0){
           Compuerta c =(Compuerta)InputGates.getHead().getData();
           this.valor= c.valor;
        }
    }
    /**
     * Si el valor de entrada es false lo cambia a true y viceversa
     */
    public void change(){
        if (valor){
            this.valor=false;
        }
        else{
            this.valor=true;
        }
        System.out.println("Cambio");
        }
    /**
     * Establece el valor de la compuerta a true
     */
    public void setToTrue(){
        this.valor = true;
    }
    /**
     * Establece el valor de la compuerta a false
     */
    public void setToFalse(){
        this.valor = false;
    }   
}
