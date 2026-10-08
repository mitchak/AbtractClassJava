/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Models.Figura;
import Models.Punto2d;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author michael
 */
public class PanelLienzo extends JPanel{
    private Figura figuraADibujar; // La figura que el controlador nos asigne

    // El Controlador usará este método para pasarnos la figura
    public void setFigura(Figura f) {
        this.figuraADibujar = f;
        this.repaint(); // <--- FUNDAMENTAL: Le dice al panel "Bórrate y vuelve a dibujarte"
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpia el panel antes de dibujar
        
        if (figuraADibujar != null) {
            Punto2d[] pts = figuraADibujar.getPuntos();
            
            Color colorFigura = figuraADibujar.getColor();
            
            g.setColor(colorFigura);

            // Bucle polimórfico: Conecta punto con punto
            for (int i = 0; i < pts.length; i++) {
                Punto2d pActual = pts[i];
                // El siguiente punto. Si es el último, vuelve al primero (i=0) para cerrar la figura
                Punto2d pSiguiente = pts[(i + 1) % pts.length];

                // g.drawLine(x1, y1, x2, y2)
                g.drawLine(pActual.getX(), pActual.getY(), pSiguiente.getX(), pSiguiente.getY());
            }
            
            
        }
    }
}
