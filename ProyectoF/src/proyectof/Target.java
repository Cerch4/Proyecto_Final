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
 *
 * @author Cesar
 */
public class Target extends JPanel{
     int x;
    int y;
    private int escala;
    
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
    
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }
    
    @Override
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
