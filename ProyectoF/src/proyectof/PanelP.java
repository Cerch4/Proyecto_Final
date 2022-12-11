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
 * JPanel que anima las fisicas de lanzamiento de misiles desde un avion
 * @see Avion
 * @see Misil
 * @see Target
 * @author Cesar
 */
public class PanelP extends JPanel implements MouseListener, ActionListener, MouseMotionListener {   
    /** Int que almacena el ancho del panel */
    public static int WIDTH = 700;
    /** Int que almacena el alto del panel */
    public static int HEIGHT = 400;
    /** Target que almacena el blanco que se usara en la simulacion*/
    Target target;
    /** Image que almacena el fondo que se usara en la simulacion*/
    Image backGround;
    /** Almacena el Avion que se usara en la simulacion*/
    Avion plane;
    /** Almacena el Misil que se usara en la simulacion*/
    Misil boom;
    /** Timer que determinara la velocidad de ejecucion del programa*/
    Timer timer, timer2;
    /** ImageIcon que almacena el png que se le asignara de fondo en la simulacion*/
    ImageIcon  temp2;
    /** Boolean que almacena el estado del misil, true si el misil ha sido disparado*/
    Boolean mState;
    /** Vector que almacena la posicion del mouse en la pantalla*/
    public Vector posicionMouse;
    /** Int que almacena la velocidad a la que se mueve el blanco*/
    int xVelocity;
    /** Int que almacena la posicion del blanco en el eje horizontal*/
    int x = 0;
    /** Int que almacena la posicion del blanco en el eje vertical*/
    int y = 340;
    /** Int que almacena la posicion del avion en el eje horizontal*/
    int planex = 30;
    /** Int que almacena la posicion del avion en el eje vertical*/
    int planey = 40;
    
    int escala = 160;
    /** Int que almacena la velocidad a la que se mueve el avion*/
    int planeVelocity = 2;
    
    /** Metodo constructor de la clase
     * @param xVelocity int que asigna velocidad al blanco
     */
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
    /** Metodo que lanza el misil, lo lansa desde la parte inferior del avion, cambia el valor de mState a True*/
    public void misilLaunch(){
        boom = new Misil(planex+20,planey-15);
        boom.angulo = (float) Math.toDegrees(Math.atan2(planey-15 - posicionMouse.y, planex+20 - posicionMouse.x)) - (180);
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
        if(xVelocity > 0){
            xVelocity = xVelocity*-1;
        }
    }
    
    /** Metodo que cambia la direccion de movimiento del blanco, si esta moviendose a la izquirda cambia el valor de xVelocity, caso contrario no hace nada*/
    public void goRIGHT(){
        if(xVelocity < 0){
            xVelocity = xVelocity*-1;
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
        
        for(int k = planey-15; k<600; k = k+1){
            double angle = (double) Math.toDegrees(Math.atan2(planey-15 - posicionMouse.y, planex+20 - posicionMouse.x));
            Point p = Angular.generaPunto((int)planex+20, (int)planey-15, k, -angle+180);
            if(k%5 == 0){
               g2D.fillRect(p.x-1, p.y-1, 2 , 2); 
            }
            
        }
        if(mState == true){
            boom.paint(g2D);
        }
    }
    
    
    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
     public void mouseMoved(MouseEvent me) {
        posicionMouse.x = me.getX();
        posicionMouse.y = me.getY();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.misilLaunch();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {;
    }

    @Override
    public void mouseExited(MouseEvent me) {;
    }
    /** Metodo que detecta si se ha realizado una accion especifica, en este caso el paso del tiempo basado en el timer, cada vez que se ejecuta actualiza la posicion de todos los objetos del panel
        al llamar al metodo repaint, */
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(mState == true){
            if(boom != null && boom.y >= 400){
            mState = false;
            
            }
            else {
               boom.y= boom.y+1;
                this.checkColition();
                x = x + xVelocity;
                planex = planex + planeVelocity;
                if(boom.checkearObjectivo((float)target.x, (float)target.y)){
                boom.girar((float)target.x, (float)target.y);
            
                }
            boom.mover();  
            }
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
