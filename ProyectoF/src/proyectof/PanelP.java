/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;



import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
/**
 *
 * @author Cesar
 */
public class PanelP extends  JPanel implements ActionListener{   
    
    final int PANEL_WIDTH = 700;
    final int PANEL_HEIGHT = 400;
    Image target;
    Image backGround;
    Timer timer;
    ImageIcon temp, temp2;
    int xVelocity;
    int yVelocity;
    int x = 0;
    int y = 320;
    
    
    PanelP(int xVelocity){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.white);
        temp =  new ImageIcon(this.getClass().getResource("target.png")); //new ImageIcon("target.png");
        target = temp.getImage().getScaledInstance(60,60, SCALE_SMOOTH); //temp.getImage().getScaledInstance(60,60, SCALE_SMOOTH);
        temp2 = new ImageIcon(this.getClass().getResource("background.png"));
        backGround = temp2.getImage();
        timer = new Timer(10,this);
        timer.start();

        this.xVelocity = xVelocity;
       // this.yVelocity = yVelocity;
        
    }
    
   
   
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(backGround, 0, 0, this);
        g2D.drawImage(target, x, y, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(x>=PANEL_WIDTH-target.getWidth(null) || x<0) {
			xVelocity = xVelocity * -1;
		}
        x = x + xVelocity;
        repaint();
       // if(y>=PANEL_HEIGHT-target.getHeight(null) || y<0) {
	//		yVelocity = yVelocity * -1;}

        // y = y + yVelocity;
         
       
    }
    
    
}
