package proyectof;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
    public MenuPanel(int escala, int vp){
        this.escala = escala;
        xt = 0;yt = 295*escala/40;xp = 30*escala/40;yp = 40*escala/40;vt = 3;this.vp = vp;
        mState=false;
        target = new Target(xt,yt,escala);plane = new Avion(xp, yp, escala);
        this.setPreferredSize(new Dimension(16*escala, 12*escala));
        this.setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        temp2 = new ImageIcon(this.getClass().getResource("background.png"));
        backGround = new ImageIcon(temp2.getImage().getScaledInstance(16*escala, 9*escala, Image.SCALE_SMOOTH)).getImage();
        timer = new Timer(20, (ActionListener) this);
        timer.start();
        posicionMouse = new Vector(0,0);
    }
    public void misilLaunch(){
        boom = new Misil(20+xp,yp+20);
        mState = true;
    }
    public void startGame(){
        timer.start();
    } 
    
    public void stopGame(){
        timer.stop();
    }
    public void checkColition(){ 
        if(((int)boom.x+10 < xt+20) && ((int)boom.x+10 > xt)){ //verifica colision horizontal
            if(((int)boom.y + 10 < yt + 40) && ((int)boom.y + 10 > yt)){
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
    public void actionPerformed(ActionEvent e) {
        if(mState == true){
            boom.y= boom.y+1;
            this.checkColition();
            xp = xp + vp;
            if(boom.checkearObjectivo((float)target.x, (float)target.y)){
                boom.girar((float)target.x, (float)target.y);
            }
           boom.mover(); 
        }
        if(mState == false){
            xt = xt + vt;
            if(xt<=(16*escala)) {
		xp = xp + vp;
            }
        }
        if (xt>16*escala-40 || xt < 0) {
            vt = vt*-1;
        }
        if (xp>16*escala) {
            xp = -60;
        }
        target.changexy(xt, yt);
        plane.changexy(xp, yp);
        repaint();
    }
}
