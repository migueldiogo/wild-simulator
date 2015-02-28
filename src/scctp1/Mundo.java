package scctp1;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;



/**
 *
 * @author MiguelDiogo
 */
public class Mundo {

    private int comprimento;
    private int largura;
    private CopyOnWriteArrayList<Ovelha> ovelhas;
    private CopyOnWriteArrayList<Lobo> lobos;
    private Vegetacao[][] vegetacao;

    
    public Mundo() {
        int i, j;
        Random rand = new Random();
        int numeroLobos = 30;
        int numeroOvelhas = 100;
        largura = 51;
        comprimento = 51;
        vegetacao = new Vegetacao[largura][comprimento];
        ovelhas = new CopyOnWriteArrayList();
        lobos = new CopyOnWriteArrayList();
        
        for (i = 0; i < vegetacao.length; i++) {
            for (j = 0; j < vegetacao[0].length; j++) {
                /* probabilidade de haver vegetacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    vegetacao[i][j] = new Vegetacao(true);
                else
                    vegetacao[i][j] = new Vegetacao(false);
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
        vegetacao = new Vegetacao[largura][comprimento];
        
        ovelhas = new CopyOnWriteArrayList();
        lobos = new CopyOnWriteArrayList();
        
        for (i = 0; i < vegetacao.length; i++) {
            for (j = 0; j < vegetacao[0].length; j++) {
                /* probabilidade de haver vegetacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    vegetacao[i][j] = new Vegetacao(true);
                else
                    vegetacao[i][j] = new Vegetacao(false);
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
        vegetacao = new Vegetacao[largura][comprimento];
        
        ovelhas = new CopyOnWriteArrayList();
        lobos = new CopyOnWriteArrayList();
        
        for (i = 0; i < vegetacao.length; i++) {
            for (j = 0; j < vegetacao[0].length; j++) {
                /* probabilidade de haver vegetacao = 50% = 0.5 */
                if (rand.nextInt(2) == 0)
                    vegetacao[i][j] = new Vegetacao(true);
                else
                    vegetacao[i][j] = new Vegetacao(false);
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

    /** 
     * Retorna array de ovelhas cujas coordenadas coincidem com o animal em argumento.
     * @param animal
     * @return lista de ovelhas na casa do animal passado em parâmetro.
     */
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

    public Vegetacao[][] getvegetacao() {
        return vegetacao;
    }
    
    /**
     * Devolve vegetacao onde se encontra o animal passado em parâmetro.
     * @param animal
     * @return vegetacao onde se encontra o animal passado em parâmetro.
     */
    public Vegetacao getvegetacao(Animal animal) {
        Vegetacao veges = null;
        try {
            veges = vegetacao[animal.getCoordenadas().getCoordX()][animal.getCoordenadas().getCoordY()];
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

    public void setvegetacao(Vegetacao[][] vegetacao) {
        this.vegetacao = vegetacao;
    }
    
    
    
    public int getNumerovegetacaoTotal() {
        int soma = 0;
        for (int i = 0; i < vegetacao.length; i++) {
            for (int j = 0; j < vegetacao[0].length; j++) {
                if (vegetacao[i][j].isReady())
                    soma++;
            }
        }
        return soma;
    }
    

    
    public void crescevegetacao() {
        for (int i = 0; i < vegetacao.length; i++) {
            for (int j = 0; j < vegetacao[0].length; j++) {
                vegetacao[i][j].cresce();
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

        for (int i = 0; i < vegetacao.length; i++) {
            for (int j = 0; j < vegetacao[0].length; j++) {
                if (vegetacao[i][j].isReady())
                    g.setColor(new Color(0, 128, 0));
                else 
                    g.setColor(new Color(255, 204, 102));
  
                g.fillRect(i*dX+1, j*dY+1, dX -1, dY -1);
                
                if (vegetacao[i][j].getCrescimento() >= 30)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(new Color(0, 128, 0));

                g.drawString("" + (int)vegetacao[i][j].getCrescimento(), i*dX, j*dY+dY);
            }
        }
        
        
        //desenhar os objectos
        for(Ovelha ovelha : ovelhas) {
            g.setColor(Color.BLUE);
            g.fillRect(ovelha.getCoordenadas().getCoordX()*dX+1, ovelha.getCoordenadas().getCoordY()*dY+1, dX-1, dY-1);
            if (getOvelhas(ovelha).size()>1)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.BLACK);
            g.drawString("" + (int)ovelha.getEnergia(), ovelha.getCoordenadas().getCoordX()*dX, ovelha.getCoordenadas().getCoordY()*dY+dY);

        }
       
        for(Lobo lobo : lobos) {
            g.setColor(Color.RED);
            g.fillRect(lobo.getCoordenadas().getCoordX()*dX+1, lobo.getCoordenadas().getCoordY()*dY+1, dX-1, dY-1);
            if (getLobos(lobo).size()>1)
                g.setColor(Color.WHITE);
            else
                g.setColor(Color.BLACK);
 
            
            g.drawString("" + (int)lobo.getEnergia(), lobo.getCoordenadas().getCoordX()*dX, lobo.getCoordenadas().getCoordY()*dY+dY);
        }
             
    }
    
}
