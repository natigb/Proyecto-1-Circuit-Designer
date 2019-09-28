/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 * Clase para crear una compuerta OR
 * @author Natalia Gonzalez
 */
public class OR extends Compuerta{
    /**
     * Operacion de una or, si hay un true. devuelve false
     */
    @Override
    public void operacion(){
        this.valor = (searchAmount(true)!=0);
    }
}
