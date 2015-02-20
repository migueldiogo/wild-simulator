/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scctp1;

import java.util.Iterator;


/**
 *
 * @author MiguelDiogo
 */
public class Simulacao {
    private final double numUnidadesCicloFita;
    private final double numLimiteUnidadesTempo;
    private final double unidadeTempoEmSegundos;
    Mundo mundo;

    public Simulacao(double numUnidadesCicloFita, double numLimiteUnidadesTempo, double unidadeTempoEmSegundos, int larguraMundo, int comprimentoMundo) {
        this.numUnidadesCicloFita = numUnidadesCicloFita;
        this.numLimiteUnidadesTempo = numLimiteUnidadesTempo;
        this.unidadeTempoEmSegundos = unidadeTempoEmSegundos;
        mundo = new Mundo(1000, 100, larguraMundo, comprimentoMundo);

    }
    
    public void run() { 
        int i,j;
        double timeInicio = System.currentTimeMillis()/1000;
        int contadorDeAnalises = 0;
        int contadorDeUnidadesTempo = 1;
        while (System.currentTimeMillis()/1000 < timeInicio+unidadeTempoEmSegundos*numLimiteUnidadesTempo) {
            
            for (i = 0; i < mundo.getQuadrados().length; i++) {
                for (j = 0; j < mundo.getQuadrados()[0].length; j++) {
                    for (Ovelha ovelha : mundo.getQuadrados()[i][j].getOvelhas())
                        ovelha.come();
                    for (Lobo lobo : mundo.getQuadrados()[i][j].getLobos())
                        lobo.come();
                }
            }
            
                        
            if (System.currentTimeMillis()/1000 >= timeInicio+unidadeTempoEmSegundos*contadorDeUnidadesTempo) {
                mundo.cresceVegestacao();
                contadorDeUnidadesTempo++;
            }
                
            
            if (System.currentTimeMillis()/1000 >= timeInicio+unidadeTempoEmSegundos*numUnidadesCicloFita*contadorDeAnalises) {
            for (i = 0; i < mundo.getQuadrados().length; i++) {
                for (j = 0; j < mundo.getQuadrados()[0].length; j++) {
                    Iterator<Ovelha> itOvelha = mundo.getQuadrados()[i][j].getOvelhas().iterator();
                    while (itOvelha.hasNext())
                        itOvelha.next().move();
                    Iterator<Ovelha> itLobo = mundo.getQuadrados()[i][j].getOvelhas().iterator();
                    while (itLobo.hasNext())
                        itLobo.next().move();
                }
            }
                System.out.println("Ovelhas: " + mundo.getNumeroOvelhasTotal() + ", Lobos: " + mundo.getNumeroLobosTotal() + 
                                    ", Casas com Vegestacao: " + mundo.getNumeroVegestacaoTotal());
                contadorDeAnalises++;
            }
        }
    }
    
}
