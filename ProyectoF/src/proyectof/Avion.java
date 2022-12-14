package proyectof;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
/**
 *Un sprite de avion para usar en el proyecto final
 */
public class Avion extends JPanel{
    /**int para almacenar la coordenada horizontal del avion */
    private int x;
    /**int para almacenar la coordenada vertical del avion */
    private int y;
    /**int para almacenar la escala del avion respecto a la ventana*/
    private int escala;
    /**int que sirve de bandera para dibujar el avion dependiendo de su direccion */
    private int rotate;
    /** Metodo constructor, asigna los valores de la posicion inicial del avion
     * @param x posicion inicial del avion en el eje horizontal
     * @param y posicion inicial del avion en el eje y 
     */
    public Avion(int x, int y){
        this.x = x;
        this.y = y;
        this.escala = Escala.getescala();
        this.rotate = 1;
    }
    public int getx(){return x;}
    public int gety(){return y;}
    public int getescala(){return escala;}
    /**Cambia la posicion del avion
     * @param x1 nueva posicion en el eje horizontal
     * @param y1 nueva posicion en el eje vertical
     */
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }    
    /**Cambia la variable rotate que que determina la direccion del paint de avion
     */
    public void rotateP(){
        rotate = rotate*-1;
    }
    /**Metodo paint de avion*/
    @Override
     public void paint(Graphics g){
         Graphics2D g2d = (Graphics2D)g;
         if(rotate == 1){
            g2d.setColor(Color.black);
            g2d.drawOval(x+30*escala/40, y+5*escala/40, 16*escala/40, 26*escala/40);
            g2d.drawOval(x-4*escala/40, y-10*escala/40, 16*escala/40, 26*escala/40);
            g2d.setColor(Color.white);
            g2d.fillRoundRect(x, y, 60*escala/40, 20*escala/40,30*escala/40,20*escala/40);
            g2d.setColor(Color.white);
            g2d.fillOval(x+30*escala/40, y+5*escala/40, 15*escala/40, 25*escala/40);
            g2d.setColor(Color.black);
            g2d.drawRoundRect(x, y, 61*escala/40, 21*escala/40,30*escala/40,20*escala/40);
            g2d.setColor(Color.white);
            g2d.fillOval(x-4*escala/40, y-10*escala/40, 15*escala/40, 25*escala/40);
            g2d.setColor(Color.darkGray);
            g2d.fillOval(x+35*escala/40, y-2*escala/40, 25*escala/40, 15*escala/40);
         }else{
            g2d.setColor(Color.black);
            g2d.drawOval(x+14*escala/40, y+5*escala/40, 16*escala/40, 26*escala/40);
            g2d.drawOval(x+48*escala/40, y-10*escala/40, 16*escala/40, 26*escala/40);
            g2d.setColor(Color.white);
            g2d.fillRoundRect(x, y, 60*escala/40, 20*escala/40,30*escala/40,20*escala/40);
            g2d.setColor(Color.white);
            g2d.fillOval(x+14*escala/40, y+5*escala/40, 15*escala/40, 25*escala/40);
            g2d.setColor(Color.black);
            g2d.drawRoundRect(x, y, 61*escala/40, 21*escala/40,30*escala/40,20*escala/40);
            g2d.setColor(Color.white);
            g2d.fillOval(x+48*escala/40, y-10*escala/40, 15*escala/40, 25*escala/40);
            g2d.setColor(Color.darkGray);
            g2d.fillOval(x*escala/40, y-2*escala/40, 25*escala/40, 15*escala/40);
         }
     }
}
