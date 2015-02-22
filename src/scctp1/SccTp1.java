/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scctp1;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import scctp1.gui.Desenho;

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
 
      
        Mundo mundo = new Mundo(30, 100, 51, 51);
        //Mundo mundo = new Mundo(100, 100, 51, 51);
       


        //Simulacao sim = new Simulacao(1, 5000, 0.006, mundo);
        //Simulacao sim = new Simulacao(1, 60, 1, mundo);
        Simulacao sim = new Simulacao(1, 5000, 0.024, mundo);

        sim.run();
                
    }
    
}
