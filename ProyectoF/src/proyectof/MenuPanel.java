package proyectof;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
/**
 * JPanel que anima las fisicas de lanzamiento de misiles desde un avion
 * @see Avion
 * @see Misil
 * @see Target
 */
public class MenuPanel extends JPanel implements MouseListener, ActionListener, MouseMotionListener{
    /** Int que almacena la escala del panel */
    private int escala;  
    /** Target que almacena el blanco que se usara en la simulacion*/
    Target target;
    /** Image que almacena el fondo que se usara en la simulacion*/
    Image backGround;
    /** Almacena el Avion que se usara en la simulacion*/
    Avion plane;
    /** Almacena el Misil que se usara en la simulacion*/
    Misil boom;
    /** Timer que determinara la velocidad de ejecucion del programa*/
    Timer timer;
    /** ImageIcon que almacena el png que se le asignara de fondo en la simulacion*/
    ImageIcon  temp2;
    /** Boolean que almacena el estado del misil, true si el misil ha sido disparado*/
    Boolean mState;
    /**Ints que almacena la posicion del blanco en el eje horizontal y vertical respespectivamente y el ultimo almacena su velocidad*/
    int xt,yt,vt;    
    /**Ints que almacena la posicion del avion en el eje horizontal y vertical respespectivamente y el ultimo almacena su velocidad*/
    int xp,yp,vp;
    /** Vector que almacena la posicion del mouse en la pantalla*/
    public Vector posicionMouse;
    /** Metodo constructor de la clase
     * @param escala int que asigna velocidad al blanco
     */
    public MenuPanel(){
        this.escala = Escala.getescala();
        xt = 0;yt = 295*escala/40;xp = 30*escala/40;yp = 40*escala/40;vt = 3;vp = 0;
        mState=false;
        target = new Target(xt,yt);plane = new Avion(xp, yp);
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
    public void setvt(int vt){this.vt = vt;}
    public void rotateP(){plane.rotateP();}
    public int getyp(){return yp;}
    public int getvp(){return vp;}
    public int getxp(){return xp;}
    public int getxt(){return xt;}
    public int getvt(){return vt;}
    public Misil getMisil(){return boom;}
    /** Metodo que lanza el misil, lo lansa desde la parte inferior del avion, cambia el valor de mState a True*/
    public void misilLaunch(){
        boom = new Misil(xp+20*escala/40,yp-15*escala/40);        
        boom.angulo = (float) Math.toDegrees(Math.atan2(yp-15 - posicionMouse.y, xp+20 - posicionMouse.x)) - (180);
        boom.mover(); 
        mState = true;
    }
    /** Metodo que inicia el timer de ejecucion de la simulacion*/
    public void startGame(){
        timer.start();
    } 
    /** Metodo que detiene el timer de ejecucion de la simulacion*/
    public void stopGame(){
        timer.stop();
    }
    /** Metodo que evalua la posicion del misil respecto al blanco, en casi de que esten en contacto detiene la simulacion*/
    public void checkColition(){ 
        if((target.checkearObjectivo(boom.x,boom.y)) == true){ //verifica colision horizontal
            this.stopGame();
        }
    }
    /** Metodo que cambia la direccion de movimiento del blanco, si esta moviendose a la derecha cambia el valor de xVelocity, caso contrario no hace nada*/
    public void goLEFT(){
        if(vt > 0){
            vt = vt*-1;
        }
    }
    /** Metodo que cambia la direccion de movimiento del blanco, si esta moviendose a la izquirda cambia el valor de xVelocity, caso contrario no hace nada*/
    public void goRIGHT(){
        if(vt < 0){
            vt = vt*-1;
        }
    }
    /** Metodo que renderiza el panel junto con todos sus componentes
     * @param g objeto de la clase Graphics que permite renderizar el objeto 
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage(backGround, 0, 0, this);
        target.paint(g2D);
        plane.paint(g2D);
        for(int k = yp-15; k<16*escala; k = k+1){
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
    /** Metodo que detecta si se ha realizado una accion especifica, en este caso el paso del tiempo basado en el timer, cada vez que se ejecuta actualiza la posicion de todos los objetos del panel
        al llamar al metodo repaint, */
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
                if(boom.checkearObjectivo((float)(target.x*escala/40)+target.radio, (float)target.y+target.radio)){
                    boom.girar((float)(target.x*escala/40)+target.radio, (float)target.y+target.radio);
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
