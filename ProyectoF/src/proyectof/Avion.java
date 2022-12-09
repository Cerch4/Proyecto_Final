package proyectof;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Cesar
 */
public class Avion extends JPanel{
    private int x;
    private int y;
    private int escala;
    
    
    
    public Avion(int x, int y, int escale){
        this.x = x;
        this.y = y;
        this.escala = escale;
        
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
         Graphics2D g2d = (Graphics2D)g;
         g2d.setColor(Color.black);
         g2d.drawOval(x+30, y+5, 16, 26);
         g2d.drawOval(x-4, y-10, 16, 26);
         g2d.setColor(Color.white);
         g2d.fillRoundRect(x, y, 60, 20,30,20);
         g2d.setColor(Color.white);
         g2d.fillOval(x+30, y+5, 15, 25);
         g2d.setColor(Color.black);
         g2d.drawRoundRect(x, y, 61, 21,30,20);
         g2d.setColor(Color.white);
         g2d.fillOval(x-4, y-10, 15, 25);
         g2d.setColor(Color.darkGray);
         g2d.fillOval(x+35, y-2, 25, 15);
         
        
            
        
     }
}
