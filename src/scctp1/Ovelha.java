package scctp1;


import java.util.Random;



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

    
    


    /**
     * Ovelha tenta reproduzir-se.
     * @throws AnimalReproduziuException 
     */
    @Override
    public void tentaReproduzir() throws AnimalReproduziuException{
        Random rand = new Random();
        /* sorteia numero de 0 a 99 (100 numeros), calhar os primeiros quatro equivale a probabilidade de 4% */
        if (rand.nextInt(100) < 4) {
            throw new AnimalReproduziuException();
        }
            
    }

    /**
     * Ovelha come vegetação se esta for madura. Se houver mais ovelhas na sua casa, partilha a energia potencialmente adquirida.
     */
    @Override
    public void come() {
        Vegetacao vegetacaoLocal = mundo.getvegetacao(this);
        if (vegetacaoLocal.isReady()) {
            int numOvelhasLocais = mundo.getOvelhas(this).size();
            for (Ovelha ovelha : mundo.getOvelhas(this)) {
                ovelha.setEnergia(ovelha.getEnergia() + vegetacaoLocal.getEnergia()/numOvelhasLocais);
            } 
            vegetacaoLocal.morre();
        }
            
    }

    
}
