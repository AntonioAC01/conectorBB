/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conectorbb;




/**
 * Fecha: 24/07/2017
 * Autor: Antonio Aburto Cortez 
 */
public class ConectorBB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ConectarBD connected=new ConectarBD();
       connected.consulta();
    }

}
