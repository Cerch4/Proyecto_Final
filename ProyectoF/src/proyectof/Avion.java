package proyectof;


import java.awt.Color;
import java.awt.Graphics;
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
    
    
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }
    
    @Override
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
