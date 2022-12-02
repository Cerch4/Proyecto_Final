/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Cesar
 */
public class Misil extends JPanel{
    public int x;
    public int y;
    private int escala;
    
    public Misil(int x, int y, int scale){
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
         
         
         
         g.setColor(Color.darkGray);
         g.fillOval(x-2, y-4, 5, 10);
         g.fillOval(x+7, y-4, 5, 10);
         
         g.setColor(Color.lightGray);
         g.fillRoundRect(x, y, 10, 30, 50, 60);
         g.setColor(Color.BLACK);
         g.drawRoundRect(x, y, 10, 30, 50, 60);
         g.drawOval(x+1, y+20, 8, 10);
         
         g.setColor(Color.darkGray);
         g.fillOval(x+3, y-4, 4, 10);
         
         g.setColor(Color.red);
         g.fillOval(x+1, y+20, 8, 10);
         
        
         
         
            
        //ImageIcon imagen = new ImageIcon(getClass().getResource("Target.png"));
        //g.drawImage(imagen.getImage(), getx(), gety(), 3*getescala()/16, getescala()/4, this);
     } 
}
