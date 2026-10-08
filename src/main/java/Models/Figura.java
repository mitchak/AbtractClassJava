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
public abstract class Figura {
    protected Color color;
    protected String descripcion;
    
    protected Figura(Color color, String descripcion){
        this.color = color;
        this.descripcion = descripcion;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public abstract double calcularArea();
    public abstract Punto2d [] getPuntos();
    
}
