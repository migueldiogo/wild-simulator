/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scctp1.gui;

import java.awt.Graphics;
import javax.swing.JPanel;
import scctp1.Mundo;

/**
 *
 * @author MiguelDiogo
 */
public class Desenho extends JPanel{
        private Mundo mundo;
        
    	public Desenho(Mundo mundo) {
		super();
		this.mundo  = mundo;
	}
	
	public void setAmbiente(Mundo mundo){
		this.mundo = mundo;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(mundo!=null)
			mundo.desenha(g);	
	}
}
