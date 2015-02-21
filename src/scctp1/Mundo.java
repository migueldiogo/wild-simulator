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
    private int numeroOvelhas;
    private int numeroLobos;
    private ArrayList<Ovelha> ovelhas;
    private ArrayList<Lobo> lobos;
    private Vegestacao[][] vegestacao;

    
    public Mundo() {
        int i, j;
        Random rand = new Random();
        numeroLobos = 30;
        numeroOvelhas = 100;
        largura = 51;
        comprimento = 51;
        vegestacao = new Vegestacao[largura][comprimento];
        ovelhas = new ArrayList();
        lobos = new ArrayList();
        
        for (i = 0; i < vegestacao.length; i++) {
            for (j = 0; j < vegestacao[0].length; j++) {
                /* probabilidade de haver vegestacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    vegestacao[i][j] = new Vegestacao(true);
                else
                    vegestacao[i][j] = new Vegestacao(false);
            }
        }
        
        
        /* insere aleatoriamente 30 lobos no mundo */
        for (i = 0; i < numeroLobos ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Lobo lobo = new Lobo(this, coordX, coordY);
            lobos.add(lobo);
        }
        
        /* insere aleatoriamente 100 ovelhas no mundo */
        for (i = 0; i < numeroOvelhas ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            ovelhas.add(ovelha);
        }
    }

    public Mundo(int numeroLobos, int numeroOvelhas) {
        int i, j;
        this.numeroLobos = numeroLobos;
        this.numeroOvelhas = numeroOvelhas;
        Random rand = new Random();
        largura = 51;
        comprimento = 51;
        vegestacao = new Vegestacao[largura][comprimento];
        
        ovelhas = new ArrayList();
        lobos = new ArrayList();
        
        for (i = 0; i < vegestacao.length; i++) {
            for (j = 0; j < vegestacao[0].length; j++) {
                /* probabilidade de haver vegestacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    vegestacao[i][j] = new Vegestacao(true);
                else
                    vegestacao[i][j] = new Vegestacao(false);
            }
        }
        
        
        /* insere aleatoriamente x lobos no mundo */
        for (i = 0; i < this.numeroLobos ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Lobo lobo = new Lobo(this, coordX, coordY);
            lobos.add(lobo);
        }
        
        /* insere aleatoriamente y ovelhas no mundo */
        for (i = 0; i < this.numeroOvelhas ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            ovelhas.add(ovelha);
        }
    }
    
    public Mundo(int numeroLobos, int numeroOvelhas, int largura, int comprimento) {
        int i, j;
        this.numeroLobos = numeroLobos;
        this.numeroOvelhas = numeroOvelhas;
        Random rand = new Random();
        this.largura = largura;
        this.comprimento = comprimento;
        vegestacao = new Vegestacao[largura][comprimento];
        
        ovelhas = new ArrayList();
        lobos = new ArrayList();
        
        for (i = 0; i < vegestacao.length; i++) {
            for (j = 0; j < vegestacao[0].length; j++) {
                /* probabilidade de haver vegestacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    vegestacao[i][j] = new Vegestacao(true);
                else
                    vegestacao[i][j] = new Vegestacao(false);
            }
        }
        
        
        /* insere aleatoriamente x lobos no mundo */
        for (i = 0; i < this.numeroLobos ; i++) {
            int coordX = rand.nextInt(largura);
            int coordY = rand.nextInt(comprimento);

            Lobo lobo = new Lobo(this, coordX, coordY);
            lobos.add(lobo);
        }
        
        /* insere aleatoriamente y ovelhas no mundo */
        for (i = 0; i < this.numeroOvelhas ; i++) {
            int coordX = rand.nextInt(largura);
            int coordY = rand.nextInt(comprimento);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            ovelhas.add(ovelha);
        }
    }
    


    public int getComprimento() {
        return comprimento;
    }

    public int getLargura() {
        return largura;
    }

    public int getNumeroOvelhas() {
        return numeroOvelhas;
    }

    public int getNumeroLobos() {
        return numeroLobos;
    }
    

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }



    
    
    public ArrayList<Ovelha> getOvelhas() {
        return ovelhas;
    }
    
    public ArrayList<Lobo> getLobos() {
        return lobos;
    }

    /* retorna array de ovelhas cujas coordenadas coincidem com o animal em argumento */
    public ArrayList<Ovelha> getOvelhas(Animal animal) {
        ArrayList<Ovelha> ovelhasRetornadas = new ArrayList();
        for (Ovelha ovelha : ovelhas) {
            if (ovelha.getCoordenadas().equals(animal.getCoordenadas()))
                ovelhasRetornadas.add(ovelha);
        } 
        return ovelhasRetornadas;
    }
    
    public ArrayList<Lobo> getLobos(Animal animal) {
        ArrayList<Lobo> lobosRetornados = new ArrayList();
        for (Lobo lobo : lobos) {
            if (lobo.getCoordenadas().equals(animal.getCoordenadas()))
                lobosRetornados.add(lobo);
        } 
        return lobosRetornados;
    }

    public Vegestacao[][] getVegestacao() {
        return vegestacao;
    }
    
    public Vegestacao getVegestacao(Animal animal) {
        return vegestacao[animal.getCoordenadas().getCoordX()][animal.getCoordenadas().getCoordY()];
    }

    public void setOvelhas(ArrayList<Ovelha> ovelhas) {
        this.ovelhas = ovelhas;
    }

    public void setLobos(ArrayList<Lobo> lobos) {
        this.lobos = lobos;
    }

    public void setVegestacao(Vegestacao[][] vegestacao) {
        this.vegestacao = vegestacao;
    }
    
    
    
    /*
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
    */
    public int getNumeroVegestacaoTotal() {
        int soma = 0;
        for (int i = 0; i < vegestacao.length; i++) {
            for (int j = 0; j < vegestacao[0].length; j++) {
                if (vegestacao[i][j].isReady())
                    soma++;
            }
        }
        return soma;
    }
    

    
    public void cresceVegestacao() {
        for (int i = 0; i < vegestacao.length; i++) {
            for (int j = 0; j < vegestacao[0].length; j++) {
                vegestacao[i][j].cresce();
            }
        }    
    }
}
