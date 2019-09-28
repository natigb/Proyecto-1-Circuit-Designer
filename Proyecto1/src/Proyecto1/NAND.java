/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1;

/**
 * Clase para crear una compuerta NAND
 * @author Natalia Gonzalez
 */
public class NAND extends Compuerta{
    /**
     * Operación de una nand, si hay un true, retorna true
     */
    @Override
    public void operacion(){
        this.valor = (searchAmount(false)!=0);
    }
}