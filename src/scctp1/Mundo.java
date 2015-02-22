package scctp1;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

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
    private CopyOnWriteArrayList<Ovelha> ovelhas;
    private CopyOnWriteArrayList<Lobo> lobos;
    private Vegestacao[][] vegestacao;

    
    public Mundo() {
        int i, j;
        Random rand = new Random();
        int numeroLobos = 30;
        int numeroOvelhas = 100;
        largura = 51;
        comprimento = 51;
        vegestacao = new Vegestacao[largura][comprimento];
        ovelhas = new CopyOnWriteArrayList();
        lobos = new CopyOnWriteArrayList();
        
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
        Random rand = new Random();
        largura = 51;
        comprimento = 51;
        vegestacao = new Vegestacao[largura][comprimento];
        
        ovelhas = new CopyOnWriteArrayList();
        lobos = new CopyOnWriteArrayList();
        
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
        for (i = 0; i < numeroLobos ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Lobo lobo = new Lobo(this, coordX, coordY);
            lobos.add(lobo);
        }
        
        /* insere aleatoriamente y ovelhas no mundo */
        for (i = 0; i < numeroOvelhas ; i++) {
            int coordX = rand.nextInt(51);
            int coordY = rand.nextInt(51);

            Ovelha ovelha = new Ovelha(this, coordX, coordY);
            ovelhas.add(ovelha);
        }
    }
    
    public Mundo(int numeroLobos, int numeroOvelhas, int largura, int comprimento) {
        int i, j;
        Random rand = new Random();
        this.largura = largura;
        this.comprimento = comprimento;
        vegestacao = new Vegestacao[largura][comprimento];
        
        ovelhas = new CopyOnWriteArrayList();
        lobos = new CopyOnWriteArrayList();
        
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
        for (i = 0; i < numeroLobos ; i++) {
            int coordX = rand.nextInt(largura);
            int coordY = rand.nextInt(comprimento);

            Lobo lobo = new Lobo(this, coordX, coordY);
            lobos.add(lobo);
        }
        
        /* insere aleatoriamente y ovelhas no mundo */
        for (i = 0; i < numeroOvelhas ; i++) {
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
        return ovelhas.size();
    }

    public int getNumeroLobos() {
        return lobos.size();
    }
    

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }



    
    
    public CopyOnWriteArrayList<Ovelha> getOvelhas() {
        return ovelhas;
    }
    
    public CopyOnWriteArrayList<Lobo> getLobos() {
        return lobos;
    }

    /* retorna array de ovelhas cujas coordenadas coincidem com o animal em argumento */
    public ArrayList<Ovelha> getOvelhas(Animal animal) {
        ArrayList<Ovelha> ovelhasRetornadas = new ArrayList();
        ListIterator<Ovelha> itOvelhas = ovelhas.listIterator();
        while(itOvelhas.hasNext()) {
            Ovelha ovelhaAtual = itOvelhas.next();
            if (ovelhaAtual.getCoordenadas().equals(animal.getCoordenadas()))
                ovelhasRetornadas.add(ovelhaAtual);
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
        Vegestacao veges = null;
        try {
            veges = vegestacao[animal.getCoordenadas().getCoordX()][animal.getCoordenadas().getCoordY()];
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(animal.getCoordenadas().getCoordX() + " -- " + animal.getCoordenadas().getCoordY());
        }
        
        return veges;
    }

    public void setOvelhas(CopyOnWriteArrayList<Ovelha> ovelhas) {
        this.ovelhas = ovelhas;
    }

    public void setLobos(CopyOnWriteArrayList<Lobo> lobos) {
        this.lobos = lobos;
    }

    public void setVegestacao(Vegestacao[][] vegestacao) {
        this.vegestacao = vegestacao;
    }
    
    
    
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
    
    
    
    public void desenha (Graphics g) {
        Rectangle r = g.getClipBounds();
        int dX = (int)(r.getWidth()/(double)largura);
        int dY = (int)(r.getHeight()/(double)comprimento);

        // desenhar a grelha
        for(int i = 0; i <= largura; i++)
                g.drawLine(i*dX, 0, i*dX, comprimento*dY);
        for(int i = 0; i<= comprimento; i++)
                g.drawLine(0, i*dY, largura*dX, i*dY);

        for (int i = 0; i < vegestacao.length; i++) {
            for (int j = 0; j < vegestacao[0].length; j++) {
                if (vegestacao[i][j].isReady())
                    g.setColor(new Color(0, 128, 0));
                else
                    g.setColor(new Color(255, 204, 102));

                    
                g.fillRect(i*dX+1, j*dY+1, dX -1, dY -1);

            }
        }
        
        
        //desenhar os objectos
        for(Ovelha ovelha : ovelhas) {
            g.setColor(Color.BLUE);
            g.fillRect(ovelha.getCoordenadas().getCoordX()*dX+dX/4, ovelha.getCoordenadas().getCoordY()*dY+dY/4, dX/2, dY/2);
        }
       
        for(Lobo lobo : lobos) {
            g.setColor(Color.RED);
            g.fillRect(lobo.getCoordenadas().getCoordX()*dX+dX/4, lobo.getCoordenadas().getCoordY()*dY+dY/4, dX/2, dY/2);
            g.setColor(Color.BLACK);
            //g.draw
            //g.drawString("1", lobo.getCoordenadas().getCoordX()*dX+dX/4, lobo.getCoordenadas().getCoordY()*dY+dY);
        }
             
    }
    
}
