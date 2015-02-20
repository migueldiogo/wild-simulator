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
public class Vegestacao extends SerVivo{
    private int crescimento;
    
    public Vegestacao() {
        crescimento = 1;
        energia = 4;
    }
    
    public Vegestacao(boolean jaDesenvolvida) {
        if (jaDesenvolvida) 
            crescimento = 30;
        else {
            Random rand = new Random();
            crescimento = rand.nextInt(31);
        }
        energia = 4;
    }

    public int getCrescimento() {
        return crescimento;
    }

    public void setCrescimento(int crescimento) {
        this.crescimento = crescimento;
    }
    
    
    public void cresce() {
        crescimento++;
    }
    
    public boolean isReady() {
        return (crescimento >= 30);
    }
    

    @Override
    public void morre() {
        crescimento = 1;
    }
    

    
}
