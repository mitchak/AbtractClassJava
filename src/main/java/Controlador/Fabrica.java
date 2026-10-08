/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Models.Equilatero;
import Models.Escaleno;
import Models.Figura;
import Models.Isosceles;
import Models.Punto2d;
import Models.Cuadrado;
import Models.Trapecio;
import java.awt.Color;

/**
 *
 * @author michael
 */
public class Fabrica {
    
    public static Figura crearTipoCuadrilatero(Color color, String descripcion,Punto2d p1, Punto2d p2, Punto2d p3, Punto2d p4){
        
        double l1 = p1.calcularDistancia(p2);
        double l2 = p2.calcularDistancia(p3);
        double l3 = p3.calcularDistancia(p4);
        double l4 = p4.calcularDistancia(p1);

        // 2. Calcular las 2 diagonales (clave para distinguir ángulos rectos)
        double d1 = p1.calcularDistancia(p3);
        double d2 = p2.calcularDistancia(p4);

        double e = 0.001; // Tolerancia para errores de redondeo
        
        if (sonIguales(l1, l2, e) && sonIguales(l2, l3, e) && sonIguales(l3, l4, e) && sonIguales(d1, d2, e)) {
            return new Cuadrado(color, descripcion, p1, p2, p3, p4);
        }
        
        // Si no es ninguno de los anteriores, lo tratamos como un Trapecio o Cuadrilátero general
        return new Trapecio(color, descripcion, p1, p2, p3, p4);
    }
    
    
    private static boolean sonIguales(double a, double b, double e) {
        return Math.abs(a - b) < e;
    }
    
    public static Figura crearTipoTriangulo(Color color, String descripcion,Punto2d p1, Punto2d p2, Punto2d p3){
        
        double a = p1.calcularDistancia(p2);
        double b = p2.calcularDistancia(p3);
        double c = p3.calcularDistancia(p1);

        double epsilon = 0.001; 

        if (Math.abs(a - b) < epsilon && Math.abs(b - c) < epsilon) {
            return new Equilatero(color, descripcion, p1, p2, p3);
        } else if (Math.abs(a - b) < epsilon || Math.abs(b - c) < epsilon || Math.abs(a - c) < epsilon) {
            return new Isosceles(color, descripcion, p1, p2, p3);
        } 
        
        return new Escaleno(color, descripcion, p1, p2, p3);
        
    }
    
    
}
