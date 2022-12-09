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
public class PanelP extends JPanel implements MouseListener, ActionListener, MouseMotionListener {   
    
    public static int WIDTH = 700;
    public static int HEIGHT = 400;
    Target target;
    Image backGround;
    Avion plane;
    Misil boom;
    Timer timer, timer2;
    ImageIcon  temp2;
    Boolean mState;
    public Vector posicionMouse;
    
    int xVelocity;

    int x = 0;
    int y = 320;
    int planex = 30;
    int planey = 40;
    int escala = 160;
    int planeVelocity = 2;
    
    public PanelP(int xVelocity){
        mState = false;
        target = new Target(x,y,escala);
        plane = new Avion(planex, planey, escala);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        temp2 = new ImageIcon(this.getClass().getResource("background.png"));
        backGround = temp2.getImage();
        timer = new Timer(20,this);
        timer2 = new Timer(20,this);
        timer.start();

        this.xVelocity = xVelocity;
        posicionMouse = new Vector(0,0);
        
    }
    
    public void misilLaunch(){
        boom = new Misil(20+planex,planey+20);
        mState = true;
    }
    
    public void startGame(){
        timer.start();
    } 
    
    public void stopGame(){
        timer.stop();
    }
    public void checkColition(){
        
        if(((int)boom.x+10 < x+20) && ((int)boom.x+10 > x)){ //verifica colision horizontal
            if(((int)boom.y + 10 < y + 40) && ((int)boom.y + 10 > y)){
                
               this.stopGame();
        
            }
    }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2D = (Graphics2D)g;
        
        g2D.drawImage(backGround, 0, 0, this);
        target.paint(g2D);
        plane.paint(g2D);
        if(mState == true){
            boom.paint(g2D);
        }
    }
    /*
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(mState == true){
            boom.y= boom.y+1;
            this.checkColition();
            planex = planex + planeVelocity;
        }
        
        
        
        if(mState == false){
            x = x + xVelocity;
            if(x<=WIDTH-60) {
		planex = planex + planeVelocity;
		}
        }
        
        
        target.changexy(x,y);
        plane.changexy(planex, planey);
        repaint();
         
       
    } */
    
    
    public void mouseDragged(MouseEvent me) {
        
    }

     public void mouseMoved(MouseEvent me) {
        posicionMouse.x = me.getX();
        posicionMouse.y = me.getY();
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
        
    }

    public void mouseReleased(MouseEvent me) {
        
    }

    public void mouseEntered(MouseEvent me) {;
    }

    @Override
    public void mouseExited(MouseEvent me) {;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(mState == true){
            boom.y= boom.y+1;
            this.checkColition();
            planex = planex + planeVelocity;
            if(boom.checkearObjectivo((float)target.x, (float)target.y)){
            boom.girar((float)target.x, (float)target.y);
            
            }
           boom.mover(); 
        }
        
        
        
        if(mState == false){
            x = x + xVelocity;
            if(x<=WIDTH-60) {
		planex = planex + planeVelocity;
		}
        }
        
        
        target.changexy(x,y);
        plane.changexy(planex, planey);
        
        //System.out.println(m.checkearObjectivo(posicionMouse.x, posicionMouse.y));
        /*if(boom.checkearObjectivo(posicionMouse.x, posicionMouse.y)){
            boom.girar(posicionMouse.x, posicionMouse.y);
            
        }
           boom.mover(); */
        
        repaint();
    } 
    
}
