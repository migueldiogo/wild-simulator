/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scctp1;

import java.util.Iterator;
import java.util.ListIterator;


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
            

            for (Ovelha ovelha : mundo.getOvelhas())
                ovelha.come();
            for (Lobo lobo : mundo.getLobos())
                lobo.come();
                
            
            
                        
            if (System.currentTimeMillis()/1000 >= timeInicio+unidadeTempoEmSegundos*contadorDeUnidadesTempo) {
                mundo.cresceVegestacao();
                contadorDeUnidadesTempo++;
            }
                
            
            if (System.currentTimeMillis()/1000 >= timeInicio+unidadeTempoEmSegundos*numUnidadesCicloFita*contadorDeAnalises) {
                    ListIterator<Ovelha> itOvelha = mundo.getOvelhas().listIterator();
                    while (itOvelha.hasNext()) {
                        Ovelha ovelhaAtual = itOvelha.next();
                        try {
                            ovelhaAtual.move();
                        }
                        catch (AnimalMorreuException e) {
                            itOvelha.remove();
                        }
                        catch (AnimalReproduziuException e) {
                            itOvelha.add(new Ovelha(mundo, ovelhaAtual.getEnergia()/2, ovelhaAtual.getCoordenadas().getCoordX(), ovelhaAtual.getCoordenadas().getCoordY()));
                        }
                        
                    }
                    ListIterator<Lobo> itLobo = mundo.getLobos().listIterator();
                    while (itLobo.hasNext()) {
                        Lobo loboAtual = itLobo.next();

                        try {
                            loboAtual.move();
                        }
                        catch (AnimalMorreuException e) {
                            itLobo.remove();
                        }
                        catch (AnimalReproduziuException e) {
                            itLobo.add(new Lobo(mundo, loboAtual.getEnergia()/2, loboAtual.getCoordenadas().getCoordX(), loboAtual.getCoordenadas().getCoordY()));
                        }
                        
                    }
                    
                System.out.println("Ovelhas: " + mundo.getOvelhas().size()+ ", Lobos: " + mundo.getLobos().size() + 
                                    ", Casas com Vegestacao: " + mundo.getNumeroVegestacaoTotal());
                contadorDeAnalises++;
            }
        }
    }
    
}
