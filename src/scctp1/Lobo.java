package scctp1;


import java.util.ListIterator;
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
        if (rand.nextInt(100) < 5) {
            throw new AnimalReproduziuException();
        }



    }

    @Override
    public void come() {
        if (!mundo.getOvelhas(this).isEmpty()) {
            System.out.println("Lobo - comi");
            double energiaTotal = 0;
            int numLobosLocais = mundo.getLobos(this).size();
            ListIterator<Ovelha> itOvelhas = mundo.getOvelhas(this).listIterator();
            while (itOvelhas.hasNext()) {
                itOvelhas.next();
                energiaTotal += 20;
                itOvelhas.remove();
            }
            ListIterator<Lobo> itLobos = mundo.getLobos(this).listIterator();
            for (Lobo lobo : mundo.getLobos(this)) {
                lobo.setEnergia(lobo.getEnergia() + energiaTotal/numLobosLocais);
            } 
        } 
    }

}
