/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *Un sprite movil del objetivo usado en el proyecto
 * @author Cesar
 */
public class Target{
    /** int que almacena la posicion horizontal de la clase */
    int x;
    /** int que almacena la posicion vertical de la clase*/
    int y;
    private int escala;
    /**Metodo constructor, asigna las coordenadas iniciales al objeto 
     * @param x posicion inicial horizontal de target
     * @param y posicion inicial vertical de target
     */
    public Target(int x, int y, int scale){
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
    /**Metodo que cambia la posicion de target
     * @param x1 nueva posicion en el eje horizontal
     * @param y1 nueva posicion en el eje vertical
     */
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }
    
    /** Metodo que renderiza el objeto*/
     public void paint(Graphics g){
         g.setColor(Color.black);
         g.drawRoundRect(x, y, 40, 40, 60, 60);
         g.setColor(Color.lightGray);
         g.fillRoundRect(x, y, 40, 40, 60, 60);
        
         g.setColor(Color.darkGray);
         g.fillRect(x, y+16, 40, 6);
         g.fillRect(x+17, y, 6, 40);
        //ImageIcon imagen = new ImageIcon(getClass().getResource("Target.png"));
        //g.drawImage(imagen.getImage(), getx(), gety(), 3*getescala()/16, getescala()/4, this);
     }
    
}
