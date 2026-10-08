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
public abstract class Triangulo extends Figura {
    
    protected Punto2d [] puntos = new Punto2d [3];

    public Triangulo(Color color, String descripcion, Punto2d vertice1, Punto2d vertice2, Punto2d vertice3) {
        super(color, descripcion);
        puntos[0] = vertice1;
        puntos[1] = vertice2;
        puntos[2] = vertice3;
    }
    
    @Override
    public double calcularArea(){
        
        int x1 = puntos[0].getX();
        int y1 = puntos[0].getY();
        
        int x2 = puntos[1].getX();
        int y2 = puntos[1].getY();
        
        int x3 = puntos[2].getX();
        int y3 = puntos[2].getY();
        
        double area = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
        
        return area;
    }
    
    @Override
    public Punto2d [] getPuntos(){
        return puntos;
    }
}
