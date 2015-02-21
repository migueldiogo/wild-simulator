/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scctp1;

/**
 *
 * @author MiguelDiogo
 */
public class SccTp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mundo mundo = new Mundo();
        
        Simulacao sim = new Simulacao(1, 40, 1, mundo);
        sim.run();
    }
    
}
