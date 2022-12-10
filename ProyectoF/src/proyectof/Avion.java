package proyectof;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Un sprite de avion para usar en el proyecto final
 * @author Cesar Franco
 * @author Sebastian
 */
public class Avion {
    /**int para almacenar la coordenada horizontal del avion */
    private int x;
    /**int para almacenar la coordenada vertical del avion */
    private int y;
    private int escala;
    
    
    /** Metodo constructor, asigna los valores de la posicion inicial del avion
     * @param x posicion inicial del avion en el eje horizontal
     * @param y posicion inicial del avion en el eje y 
     */
    public Avion(int x, int y, int scale){
        this.x = x;
        this.y = y;
        this.escala = scale;
        
    }
    
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    
    public int getescala(){
        return escala;
    }
    
    /**Cambia la posicion del avion
     * @param x1 nueva posicion en el eje horizontal
     * @param y1 nueva posicion en el eje vertical
     */
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }
    
    /**Metodo paint de avion*/
     public void paint(Graphics g){
         
         g.setColor(Color.black);
         g.drawOval(x+30, y+5, 16, 26);
         g.drawOval(x-4, y-10, 16, 26);
         g.setColor(Color.white);
         g.fillRoundRect(x, y, 60, 20,30,20);
         g.setColor(Color.white);
         g.fillOval(x+30, y+5, 15, 25);
         g.setColor(Color.black);
         g.drawRoundRect(x, y, 61, 21,30,20);
         g.setColor(Color.white);
         g.fillOval(x-4, y-10, 15, 25);
         g.setColor(Color.darkGray);
         g.fillOval(x+35, y-2, 25, 15);
         
        
            
        
     }
}
