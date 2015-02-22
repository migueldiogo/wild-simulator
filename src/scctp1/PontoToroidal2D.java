package scctp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MiguelDiogo
 */
public class PontoToroidal2D {

    private int coordX;
    private int coordY;
    
    /**
     * Cria um ponto 2D sem coordenadas definidas.
     */
    public PontoToroidal2D(){}

    /**
     * Cria um ponto 2D com coordenadas definidas.
     * @param coordX coordenada X.
     * @param coordY coordenada Y.
     */
    public PontoToroidal2D(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /**
     * Retorna coordenada X deste ponto.
     * @return coordenada X.
     */
    public int getCoordX() {
        return coordX;
    }

    /**
     * Retorna a coordenada Y deste ponto.
     * @return coordenada Y.
     */
    public int getCoordY() {
        return coordY;
    }

    /**
     * Retorna a coordenada X deste ponto.
     * @param coordX coordenada X.
     */
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    /**
     * Atribui coordenada Y a este ponto.
     * @param coordY coordenada Y.
     */
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    

    
    
   /**
     * Faz uma translacao do ponto de acordo com os seus parâmetros, mas de forma toroidal.
     * @param mundo mundo a que o ponto está associado.
     * @param dX unidades a transladar na horizontal.
     * @param dY unidades a transladar na vertical.
     */
    public void adiciona(Mundo mundo, int dX, int dY) {
            coordX = (coordX + dX < 0) ? coordX + dX + mundo.getLargura() : (coordX + dX)%mundo.getLargura();
            coordY = (coordY + dY < 0) ? coordY + dY + mundo.getComprimento() : (coordY + dY)%mundo.getComprimento();
            System.out.println(coordX + ", " + coordY);
    }
    
    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PontoToroidal2D ponto = (PontoToroidal2D) obj;
        if (this.coordX != ponto.coordX) {
            return false;
        }
        if (this.coordY != ponto.coordY) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + coordX + "," + coordY + ")";
    }
    
    /**
     * Faz deep-copy deste objeto, em vez de fazer shallow-copy que herda do método clone() original.
     * @return cópia deste ponto.
     * @see Object
     */
    @Override
    public PontoToroidal2D clone() {
        return new PontoToroidal2D(coordX, coordY);
    }
}
