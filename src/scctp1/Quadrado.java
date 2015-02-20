package scctp1;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MiguelDiogo
 */
public class Quadrado {
    //private PontoToroidal2D coordenada;
    private Vegestacao vegestacao;
    private ArrayList<Animal> animais;
    private ArrayList<Ovelha> ovelhas;
    private ArrayList<Lobo> lobos;

    public Quadrado() {
        animais = new ArrayList();
        ovelhas = new ArrayList();
        lobos = new ArrayList();
    }

    
    
    public Vegestacao getVegestacao() {
        return vegestacao;
    }

    public ArrayList<Ovelha> getOvelhas() {
        return ovelhas;
    }

    public ArrayList<Lobo> getLobos() {
        return lobos;
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }
    
    
    
    
    public void setVegestacao(Vegestacao vegestacao) {
        this.vegestacao = vegestacao;
    }
    
    public void adiciona(Ovelha ovelha) {
        ovelhas.add(ovelha);
        animais.add(ovelha);
    }
    
    public void adiciona(Lobo lobo) {
        lobos.add(lobo);
        animais.add(lobo);
    }
    
    public void remove(Ovelha ovelha) {
        ovelhas.remove(ovelha);
        animais.remove(ovelha);
    }
    
    public void remove(Lobo lobo) {
        lobos.remove(lobo);
        animais.remove(lobo);
    }


    
    
}
