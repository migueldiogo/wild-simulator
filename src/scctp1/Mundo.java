package scctp1;


import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MiguelDiogo
 */
public class Mundo {
    /**
     * Comprimento do mundo (dimensão vertical)
     */
    private int comprimento;
    /**
     * Largura do mundo (dimensão horizontal)
     */
    private int largura;
    private Quadrado[][] quadrados;

    
    public Mundo() {
        int i, j;
        Random rand = new Random();
        largura = 51;
        comprimento = 51;
        quadrados = new Quadrado[largura][comprimento];
        
        for (i = 0; i < quadrados.length; i++) {
            for (j = 0; j < quadrados[0].length; j++) {
                quadrados[i][j] = new Quadrado();
                /* probabilidade de haver vegestacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    quadrados[i][j].setVegestacao(new Vegestacao(true));
                else
                    quadrados[i][j].setVegestacao(new Vegestacao(false));
            }
        }
        
        
        /* insere aleatoriamente 30 lobos no mundo */
        for (i = 0; i < 30 ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Lobo lobo = new Lobo(this, coordX, coordY);
            quadrados[coordX][coordY].adiciona(lobo);
        }
        
        /* insere aleatoriamente 100 ovelhas no mundo */
        for (i = 0; i < 100 ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            quadrados[coordX][coordY].adiciona(ovelha);
        }
    }

    public Mundo(int numeroLobos, int numeroOvelhas) {
        int i, j;
        Random rand = new Random();
        largura = 51;
        comprimento = 51;
        quadrados = new Quadrado[largura][comprimento];
        
        for (i = 0; i < quadrados.length; i++) {
            for (j = 0; j < quadrados[0].length; j++) {
                quadrados[i][j] = new Quadrado();
                /* probabilidade de haver vegestacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    quadrados[i][j].setVegestacao(new Vegestacao(true));
                else
                    quadrados[i][j].setVegestacao(new Vegestacao(false)); 
            }
        }
        
        
        /* insere aleatoriamente x lobos no mundo */
        for (i = 0; i < numeroLobos ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Lobo lobo = new Lobo(this, coordX, coordY);
            quadrados[coordX][coordY].adiciona(lobo);
        }
        
        /* insere aleatoriamente y ovelhas no mundo */
        for (i = 0; i < numeroOvelhas ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            quadrados[coordX][coordY].adiciona(ovelha);
        }
    }
    
    public Mundo(int numeroLobos, int numeroOvelhas, int largura, int comprimento) {
        int i, j;
        Random rand = new Random();
        this.largura = largura;
        this.comprimento = comprimento;
        quadrados = new Quadrado[largura][comprimento];
        
        for (i = 0; i < largura; i++) {
            for (j = 0; j < comprimento; j++) {
                quadrados[i][j] = new Quadrado();
                /* probabilidade de haver vegestacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0) 
                    quadrados[i][j].setVegestacao(new Vegestacao(true));
                else
                   quadrados[i][j].setVegestacao(new Vegestacao(false)); 
            }
        }
        
        
        /* insere aleatoriamente x lobos no mundo */
        for (i = 0; i < numeroLobos ; i++) {
            int coordX = rand.nextInt(largura);
            int coordY = rand.nextInt(comprimento);

            Lobo lobo = new Lobo(this, coordX, coordY);
            quadrados[coordX][coordY].adiciona(lobo);
        }
        
        /* insere aleatoriamente y ovelhas no mundo */
        for (i = 0; i < numeroOvelhas ; i++) {
            int coordX = rand.nextInt(largura);
            int coordY = rand.nextInt(comprimento);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            quadrados[coordX][coordY].adiciona(ovelha);
        }
    }
    


    public int getComprimento() {
        return comprimento;
    }

    public int getLargura() {
        return largura;
    }
    

    public Quadrado[][] getQuadrados() {
        return quadrados;
    }
    
    public Quadrado getQuadrado(Animal animal) {
        return quadrados[animal.getCoordenadas().getCoordX()][animal.getCoordenadas().getCoordY()];
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }
    
    
    public int getNumeroOvelhasTotal() {
        int soma = 0;
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[0].length; j++) {
                soma += quadrados[i][j].getOvelhas().size();
            }
        }
        return soma;
    }
    
    public int getNumeroLobosTotal() {
        int soma = 0;
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[0].length; j++) {
                soma += quadrados[i][j].getLobos().size();
            }
        }
        return soma;
    }
    
    public int getNumeroVegestacaoTotal() {
        int soma = 0;
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[0].length; j++) {
                if (quadrados[i][j].getVegestacao().isReady())
                    soma++;
            }
        }
        return soma;
    }
    

    
    public void cresceVegestacao() {
        for (int i = 0; i < quadrados.length; i++) {
            for (int j = 0; j < quadrados[0].length; j++) {
                quadrados[i][j].getVegestacao().cresce();
            }
        }    
    }
}
