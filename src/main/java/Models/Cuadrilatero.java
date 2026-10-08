/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.Color;

/**
 *
 * @author michael
 */
public abstract class Cuadrilatero extends Figura {
    
    public Punto2d [] puntos = new Punto2d [4];

    public Cuadrilatero(Color color, String descripcion, Punto2d vertice1, Punto2d vertice2, Punto2d vertice3, Punto2d vertice4) {
        super(color, descripcion);
        puntos[0] = vertice1;
        puntos[1] = vertice2;
        puntos[2] = vertice3;
        puntos[3] = vertice4;
    }
    
    @Override
    public double calcularArea(){
        int x1 = puntos[0].getX();
        int y1 = puntos[0].getY();

        int x2 = puntos[1].getX();
        int y2 = puntos[1].getY();
        
        
        int x3 = puntos[2].getX();
        int y3 = puntos[2].getY();
        
        int x4 = puntos[3].getX();
        int y4 = puntos[3].getY();
        
        double sumaDirecta = (x1 * y2) + (x2 * y3) + (x3 * y4) + (x4 * y1);
        double sumaCruzada = (y1 * x2) + (y2 * x3) + (y3 * x4) + (y4 * x1);
        
        double area = Math.abs(sumaDirecta - sumaCruzada) / 2.0;

        return area;
    }
    
    @Override
    public Punto2d [] getPuntos(){
        return puntos;
    }

}
