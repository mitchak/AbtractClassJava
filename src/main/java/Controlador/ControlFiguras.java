/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Models.*;
import java.awt.Color;
//import Controlador.Fabrica;
/**
 *
 * @author michael
 */
public class ControlFiguras {
    
    Figura estandar;

    public void creacionFigura(Color color, String descripcion, String x1, String y1,String x2, String y2, String x3, String y3, String x4, String y4){
        try {
            Punto2d p1 = new Punto2d(Integer.parseInt(x1),Integer.parseInt(y1));
            Punto2d p2 = new Punto2d(Integer.parseInt(x2),Integer.parseInt(y2));
            Punto2d p3 = new Punto2d(Integer.parseInt(x3),Integer.parseInt(y3));
            
            Color figuraColor = (color != null ? color : Color.BLACK);
            
            if (x4.trim().isEmpty() || y4.trim().isEmpty()) {
                //creacion de tipo triangulo
                estandar = Fabrica.crearTipoTriangulo(figuraColor, descripcion, p1, p2, p3);
            }
            else{
                Punto2d p4 = new Punto2d(Integer.parseInt(x4),Integer.parseInt(y4));
                //creacion de tipo cuadrado
                estandar = Fabrica.crearTipoCuadrilatero(figuraColor, descripcion, p1, p2, p3, p4);
            }

        } catch (NumberFormatException e) {
            System.out.println("ERROR INGRESE NUMEROS");
        }
    }
    
    public String calcularArea(){
        return String.valueOf(estandar.calcularArea());
    }
    
    public Figura getFigura(){
        return estandar;
    }
    
}
