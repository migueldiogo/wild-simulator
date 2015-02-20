package scctp1;


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
public class Lobo extends Animal{

    public Lobo() {
        /* energia de novo lobo sorteada de 0 a 30 */
        Random rand = new Random();
        energia = rand.nextInt(30);
    }

    public Lobo(Mundo mundo) {
        super(mundo);
        /* energia de novo lobo sorteada de 0 a 30 */
        Random rand = new Random();
        energia = rand.nextInt(30);
    }

    public Lobo(Mundo mundo, int energia) {
        super(mundo, energia);
    }
    
    

    public Lobo(Mundo mundo, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        Random rand = new Random();
        energia = rand.nextInt(30);
       
    }
    
    public Lobo(Mundo mundo, int energia, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        this.energia = energia;

    }
    
    


    @Override
    public void morre() {
        mundo.getQuadrado(this).remove(this);
    }
    
    @Override
    public void ressuscita() {
        mundo.getQuadrado(this).adiciona(this);
    }

    @Override
    public void tentaReproduzir() {
        Random rand = new Random();
        /* sorteia numero de 0 a 99 (100 numeros), calhar os primeiros cinco equivale a probabilidade de 5% */
        if (rand.nextInt(100) < 5) {
            mundo.getQuadrado(this).adiciona(new Lobo(mundo, energia/2, coordenada.getCoordX(), coordenada.getCoordY()));
            System.out.println("Reproduzi" + " eu - " + coordenada.getCoordX() + " " + coordenada.getCoordY() + ", ele " + coordenada.getCoordX() + " " + coordenada.getCoordY());

        }



    }

    @Override
    public void come() {
        /* lobo come uma ovelha inteira sem partilhar */
        if (!mundo.getQuadrado(this).getOvelhas().isEmpty() && energia > 0) {
            /* primeira ovelha que encontra */
            mundo.getQuadrado(this).getOvelhas().get(0).morre();
            energia += 20;
            System.out.println("comi");
        } 
    }

    @Override
    public String identifica() {
        return "Lobo";
    }
}
