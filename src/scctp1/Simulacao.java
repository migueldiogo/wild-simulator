
package scctp1;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import scctp1.gui.Desenho;


/**
 *
 * @author MiguelDiogo
 */
public class Simulacao {
    private final double numUnidadesCicloFita;
    private final double numLimiteUnidadesTempo;
    private final double unidadeTempoEmSegundos;
    Mundo mundo;

    public Simulacao(double numUnidadesCicloFita, double numLimiteUnidadesTempo, double unidadeTempoEmSegundos, int larguraMundo, int comprimentoMundo) {
        this.numUnidadesCicloFita = numUnidadesCicloFita;
        this.numLimiteUnidadesTempo = numLimiteUnidadesTempo;
        this.unidadeTempoEmSegundos = unidadeTempoEmSegundos;
        mundo = new Mundo(1000, 100, larguraMundo, comprimentoMundo);

    }
    
    public Simulacao(double numUnidadesCicloFita, double numLimiteUnidadesTempo, double unidadeTempoEmSegundos, Mundo mundo) {
        this.numUnidadesCicloFita = numUnidadesCicloFita;
        this.numLimiteUnidadesTempo = numLimiteUnidadesTempo;
        this.unidadeTempoEmSegundos = unidadeTempoEmSegundos;
        this.mundo = mundo;
    }
    

    
    
    public void run() { 
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset(); 

        /* GRELHA DE SIMULACAO */
        JFrame frameWorld = new JFrame();
        frameWorld.setSize(mundo.getLargura()*15,mundo.getComprimento()*15);
        frameWorld.setTitle("Simulação Gráfica");
        Desenho desenho = new Desenho(mundo);
        
        frameWorld.add(desenho);
        frameWorld.setLocationRelativeTo(null);
        frameWorld.setVisible(true);
        
        
        
        int i,j;
        double timeInicio = System.currentTimeMillis()/1000;
        int contadorDeAnalises = 0;
        int contadorDeUnidadesTempo = 1;
        while (System.currentTimeMillis()/1000 < timeInicio+unidadeTempoEmSegundos*numLimiteUnidadesTempo) {
            

            for (Ovelha ovelha : mundo.getOvelhas())
                ovelha.come();
            for (Lobo lobo : mundo.getLobos())
                lobo.come();
                
            
            
                        
            if (System.currentTimeMillis()/1000 >= timeInicio+unidadeTempoEmSegundos*contadorDeUnidadesTempo) {
                mundo.crescevegetacao();
                contadorDeUnidadesTempo++;
            }
                
            
            if (System.currentTimeMillis()/1000 >= timeInicio+unidadeTempoEmSegundos*numUnidadesCicloFita*contadorDeAnalises) {
                    for (Ovelha ovelha : mundo.getOvelhas()) {
                        try {
                            ovelha.move();
                        }
                        catch (AnimalMorreuException e) {
                            mundo.getOvelhas().remove(ovelha);
                        }
                        catch (AnimalReproduziuException e) {
                            mundo.getOvelhas().add(new Ovelha(mundo, ovelha.getEnergia()/2, ovelha.getCoordenadas().getCoordX(), ovelha.getCoordenadas().getCoordY()));
                        }
                        
                    }
                    for (Lobo lobo : mundo.getLobos()) {

                        try {
                            lobo.move();
                        }
                        catch (AnimalMorreuException e) {
                            mundo.getLobos().remove(lobo);
                        }
                        catch (AnimalReproduziuException e) {
                            mundo.getLobos().add(new Lobo(mundo, lobo.getEnergia()/2, lobo.getCoordenadas().getCoordX(), lobo.getCoordenadas().getCoordY()));
                        }
                        
                    }
                 
                System.out.println("Ovelhas: " + mundo.getOvelhas().size()+ ", Lobos: " + mundo.getLobos().size() + 
                                    ", Casas com vegetacao: " + mundo.getNumerovegetacaoTotal());
                
                line_chart_dataset.addValue((double)mundo.getNumeroLobos(), "lobos", "" + contadorDeAnalises);
                line_chart_dataset.addValue((double)mundo.getNumeroOvelhas(), "ovelhas", "" + contadorDeAnalises);
                line_chart_dataset.addValue((double)mundo.getNumerovegetacaoTotal(), "vegetacao", "" + contadorDeAnalises);


                contadorDeAnalises++;
                desenho.paintImmediately(desenho.getX(), desenho.getY(), desenho.getWidth(), desenho.getWidth());

                

                        
            }

        }
        JFreeChart lineChartObject = ChartFactory.createLineChart("Mundo","Unidades de Tempo","Contagem",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false); 
        ChartPanel chartPanel = new ChartPanel(lineChartObject);    
        panel.add(chartPanel, BorderLayout.CENTER);
        lineChartObject.getCategoryPlot().getDomainAxis().setTickLabelsVisible(false);
        lineChartObject.getCategoryPlot().getDomainAxis().setTickMarksVisible(false);
        
        CategoryItemRenderer renderer = lineChartObject.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(2, new Color(0, 128, 0));
        
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frameWorld, "Simulação terminada!", "Simulação Terminada", JOptionPane.INFORMATION_MESSAGE);   

        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    
}
