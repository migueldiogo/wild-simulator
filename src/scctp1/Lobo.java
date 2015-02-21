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

    public Lobo(Mundo mundo, double energia) {
        super(mundo, energia);
    }
    
    

    public Lobo(Mundo mundo, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        Random rand = new Random();
        energia = rand.nextInt(30);
       
    }
    
    public Lobo(Mundo mundo, double energia, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        this.energia = energia;

    }
    
    


    @Override
    public void morre() {
        mundo.getLobos().remove(this);
    }
    
    @Override
    public void ressuscita() {
        mundo.getLobos().add(this);
    }

    @Override
    public void tentaReproduzir() throws AnimalReproduziuException{
        Random rand = new Random();
        /* sorteia numero de 0 a 99 (100 numeros), calhar os primeiros cinco equivale a probabilidade de 5% */
        if (rand.nextInt(100) < 5 && energia > 2) {
            System.out.println("Reproduzi" + " eu - " + coordenada.getCoordX() + " " + coordenada.getCoordY() + ", ele " + coordenada.getCoordX() + " " + coordenada.getCoordY());
            throw new AnimalReproduziuException();
        }



    }

    @Override
    public void come() {
<<<<<<< HEAD
        /* lobo come uma ovelha inteira sem partilhar */
        if (!mundo.getOvelhas(this).isEmpty() && energia > 0) {
            /* primeira ovelha que encontra */
            mundo.getOvelhas().remove(mundo.getOvelhas(this).get(0));
            energia += 20;
=======
        if (!mundo.getOvelhas(this).isEmpty() && energia > 0) {
            double energiaTotal = 0;
            int numLobosLocais = mundo.getLobos(this).size();
            for (Ovelha ovelha : mundo.getOvelhas(this)) {
                energiaTotal += 20;
                mundo.getOvelhas().remove(ovelha);
            }
            for (Lobo lobo : mundo.getLobos(this)) {
                lobo.setEnergia(lobo.getEnergia() + energiaTotal/numLobosLocais);
            } 
>>>>>>> ArraysMerged
        } 
    }

    @Override
    public String identifica() {
        return "Lobo";
    }
}
