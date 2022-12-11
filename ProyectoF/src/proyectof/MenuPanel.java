package proyectof;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
public class MenuPanel extends JPanel implements MouseListener, ActionListener, MouseMotionListener{
    private int escala;  
    Target target;
    Image backGround;
    Avion plane;
    Misil boom;
    Timer timer;
    ImageIcon  temp2;
    Boolean mState;
    int xt,yt,xp,yp,vt,vp;
    public Vector posicionMouse;
    public MenuPanel(int escala){
        this.escala = escala;
        xt = 0;yt = 295*escala/40;xp = 30*escala/40;yp = 40*escala/40;vt = 3;vp = 0;
        mState=false;
        target = new Target(xt,yt,escala);plane = new Avion(xp, yp, escala);
        this.setBounds(0, 0, 16*escala, 9*escala);
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        temp2 = new ImageIcon(this.getClass().getResource("background.png"));
        backGround = new ImageIcon(temp2.getImage().getScaledInstance(16*escala, 9*escala, Image.SCALE_SMOOTH)).getImage();
        timer = new Timer(20, (ActionListener) this);
        posicionMouse = new Vector(0,0);
    }
    public void setvp(int vp){this.vp = vp;}
    public void setyp(int yp){this.yp = yp;}
    public void setxp(int xp){this.xp = xp;}
    public void setxt(int xt){this.xt = xt;}
    public int getyp(){return yp;}
    public int getvp(){return vp;}
    public int getxp(){return xp;}
    public int getxt(){return xt;}
    public void misilLaunch(){
        boom = new Misil(xp+20,yp-15);        
        boom.angulo = (float) Math.toDegrees(Math.atan2(yp-15 - posicionMouse.y, xp+20 - posicionMouse.x)) - (180);
        boom.mover(); 
        mState = true;
    }
    public void startGame(){
        timer.start();
    } 
    
    public void stopGame(){
        timer.stop();
    }
    public void checkColition(){ 
        if((target.checkearObjectivo(boom.x,boom.y)) == true){ //verifica colision horizontal
            this.stopGame();
        }
    }
    public void goLEFT(){
        if(vt > 0){
            vt = vt*-1;
        }
    }
    public void goRIGHT(){
        if(vt < 0){
            vt = vt*-1;
        }
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage(backGround, 0, 0, this);
        target.paint(g2D);
        plane.paint(g2D);
        for(int k = yp-15; k<16*FrameP.escala; k = k+1){
            double angle = (double) Math.toDegrees(Math.atan2(yp-15 - posicionMouse.y, xp+20 - posicionMouse.x));
            Point p = Angular.generaPunto((int)xp+20, (int)yp-15, k, -angle+180);
            if(k%5 == 0){
               g2D.fillRect(p.x-1, p.y-1, 2 , 2); 
            }
            
        }
        if(mState == true){
            boom.paint(g2D);
        }
    }
     public void mouseDragged(MouseEvent me) {
        
    }

     public void mouseMoved(MouseEvent me) {
        posicionMouse.x = me.getX();
        posicionMouse.y = me.getY();
    }

    public void mouseClicked(MouseEvent me) {
        this.misilLaunch();
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
    public void actionPerformed(ActionEvent e) {
        if(mState == true){
            if(boom != null && boom.y >= 400*escala/40){
                mState = false;
            }else {
                boom.y= boom.y+1;
                this.checkColition();
                xt = xt + vt;
                xp = xp + vp;
                if(boom.checkearObjectivo((float)target.x*escala/40, (float)target.y)){
                    boom.girar((float)target.x*escala/40, (float)target.y);
                }
                boom.mover();  
            }
        }
        if(mState == false){
            xt = xt + vt;
            if(xt<=(16*escala)) {
		xp = xp + vp;
            }
        }
        if (xt*escala/40>(16*escala)-(escala) || xt < 0) {
            vt = vt*-1;
        }
        if (xp>16*escala) {
            xp = -60;
        }
        if (xp<-60) {
            xp = 16*escala;
        }
        target.changexy(xt, yt);
        plane.changexy(xp, yp);
        repaint();
    }
}
