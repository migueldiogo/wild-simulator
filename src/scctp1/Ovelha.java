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
public class Ovelha extends Animal{

    public Ovelha() {
        /* energia de nova ovelha sorteada de 0 a 7 */
        Random rand = new Random();
        energia = rand.nextInt(8);
    }

    public Ovelha(Mundo mundo) {
        super(mundo);
        /* energia de nova ovelha sorteada de 0 a 7 */
        Random rand = new Random();
        energia = rand.nextInt(8);
    }

    public Ovelha(Mundo mundo, double energia) {
        super(mundo, energia);
    }

    public Ovelha(Mundo mundo, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        Random rand = new Random();
        energia = rand.nextInt(8);
    }
    
    public Ovelha(Mundo mundo, double energia, int coordX, int coordY) {
        super(mundo, coordX, coordY);
        this.energia = energia;

    }

    
    


    @Override
    public void morre() {
        mundo.getOvelhas().remove(this);
    }
    
    @Override
    public void ressuscita() {
        mundo.getOvelhas().add(this);
    }

    @Override
    public void tentaReproduzir() throws AnimalReproduziuException{
        Random rand = new Random();
        /* sorteia numero de 0 a 99 (100 numeros), calhar os primeiros quatro equivale a probabilidade de 4% */
        if (rand.nextInt(100) < 4) {
            throw new AnimalReproduziuException();
        }
            
    }

    @Override
    public void come() {
        Vegestacao vegestacaoLocal = mundo.getVegestacao(this);
        if (vegestacaoLocal.isReady() && energia > 0) {
            int numOvelhasLocais = mundo.getOvelhas(this).size();
            for (Ovelha ovelha : mundo.getOvelhas(this)) {
                ovelha.setEnergia(ovelha.getEnergia() + vegestacaoLocal.getEnergia()/numOvelhasLocais);
            } 
            vegestacaoLocal.morre();
        }
            
    }
    
    @Override
    public String identifica() {
        return "Ovelha";
    }
    
}
