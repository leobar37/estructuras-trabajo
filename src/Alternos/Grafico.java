/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alternos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Leobar37
 */
public class Grafico {
    //grafico de barras

    //grafico de barras
    public static JFreeChart GraficoBarrasG(JDialog frm, JDialog panelAbrir, DefaultCategoryDataset datos, String titulo, String linx, String liny) {

        Image retorno = null;

        JFreeChart graficoBarras = ChartFactory.createBarChart(titulo, linx, liny, datos, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(graficoBarras);
        BufferedImage img = graficoBarras.createBufferedImage(700, 300);
        // File image = new File("provi.png");
        retorno = new ImageIcon(img).getImage();
        //ImageIO.write(img, "jpg", image);
        // Rectangle rectangulo= panelMuestra.getBounds();
        //int x = panelMuestra.getX();
        //int y = panelMuestra.getY();
        //panel.setBounds(rectangulo);
        //panel.setLocation(x, y);
        //panel.setVisible(true);
        //frm.getContentPane().add(panel);

        //  panelMuestra.setVisible(false);
        panelAbrir.setSize(700, 300);
        panelAbrir.setLocationRelativeTo(null);
        panelAbrir.getContentPane().add(panel);
        panelAbrir.setVisible(true);

        return graficoBarras;

    }

    //guardar reporte 
    public static void GuardarReporte(JFreeChart jfr, String nombre) {

        try {
            ChartPanel panel = new ChartPanel(jfr);
            JFreeChart frmAux = panel.getChart();
            BufferedImage image = frmAux.createBufferedImage(700, 300);
            File archivo = new File("reportes/" + nombre + ".jpg");
            ImageIO.write(image, "jpg", archivo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "problemas al crear la imagen");
        }
    }

    public static void GraficoLinea(JDialog frm, XYSeriesCollection data, String titulo, String x, String y) {
        JFreeChart grafico = ChartFactory.createXYLineChart(titulo, x, y, data, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(grafico);
        JDialog form = new JDialog(frm, false);
        form.setSize(600, 400);
        form.setLocationRelativeTo(null);
        form.getContentPane().add(panel);
        form.setVisible(true);
    }
    //grafico mujeres y varones

    public static void GraficoCircular(JPanel panel, int[] ejem, String[] mat) {
        //edades suma de edades igual a total 
        //ejem = arreglo de mujeres y varones
        //mujeres 0
        if (ejem.length < 2) {
            return;
        }
        Graphics pintor = panel.getGraphics();
        int total = ejem[0] + ejem[1];
        if(total < 0)return;
        //transformacion a grados
        int mujeres = ejem[0] * 360 / total;int varones = ejem[1] * 360 / total;        
        pintor.setColor(Color.yellow);
        pintor.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        pintor.setColor(Color.BLUE);
        pintor.fillArc(10, 10, panel.getWidth() - 120, panel.getHeight() - 40, 0, mujeres);
        pintor.fillRect(panel.getWidth() - 80, 40, 20, 20);
        pintor.drawString(mat[0], panel.getWidth() - 55, 60);
        pintor.setColor(Color.BLACK);
        pintor.drawString(mat[0]+": " + ejem[0],10, panel.getHeight() - 15);
        pintor.setColor(Color.RED);

        pintor.fillArc(10, 10, panel.getWidth() - 120, panel.getHeight() - 40, mujeres, varones);
        pintor.fillRect(panel.getWidth() - 80, 70, 20, 20);
        pintor.drawString(mat[1], panel.getWidth() - 55, 90);
        //letras debajo del grafico
        pintor.setColor(Color.BLACK);
        pintor.drawString(mat[1]+" :" + ejem[1], 110, panel.getHeight() - 15);
 
    }

}
