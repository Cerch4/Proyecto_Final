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
    Target target;
    Image backGround;
    Avion plane;
    Misil boom;
    Timer timer;
    ImageIcon temp, temp2;
    
    int xVelocity;

    int x = 0;
    int y = 320;
    int planex = 30;
    int planey = 40;
    int escala = 160;
    int planeVelocity = 2;
    
    public PanelP(int xVelocity){
        target = new Target(x,y,escala);
        plane = new Avion(planex, planey, escala);
        boom = new Misil(planex+20,planey+20,escala);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.white);
        
        temp2 = new ImageIcon(this.getClass().getResource("background.png"));
        backGround = temp2.getImage();
        timer = new Timer(20,this);
        timer.start();

        this.xVelocity = xVelocity;
       // this.yVelocity = yVelocity;
        
    }
    
   
   
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(backGround, 0, 0, this);
        target.paint(g2D);
        plane.paint(g2D);
        boom.paint(g2D);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        /*if(x>=PANEL_WIDTH-60 || x<0) {
			xVelocity = xVelocity * -1;
		} */
        if(x<=PANEL_WIDTH-60) {
		planex = planex + planeVelocity;
		}
        else{
           planex = planex;
        }
        
        
        
        x = x + xVelocity;
        /*if(xVelocity >0){
         planex = planex + planeVelocity-xVelocity;   
        }
        else{
         planex = planex + planeVelocity +xVelocity ;   
        } */
        
        target.changexy(x,y);
        plane.changexy(planex, planey);
        repaint();
       // if(y>=PANEL_HEIGHT-target.getHeight(null) || y<0) {
	//		yVelocity = yVelocity * -1;}

        // y = y + yVelocity;
         
       
    }
    
    
}
