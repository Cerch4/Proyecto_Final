package proyectof;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *Un sprite movil del objetivo usado en el proyecto
 */
public class Target extends JPanel{
    /** int que almacena la posicion horizontal de la clase */
    private int x;
    /** int que almacena la posicion vertical de la clase*/
    private int y;
    private float radio;
    /**int para almacenar la escala del target respecto a la ventana*/
    private int escala;
    /**Metodo constructor, asigna las coordenadas iniciales al objeto 
     * @param x posicion inicial horizontal de target
     * @param y posicion inicial vertical de target
     */
    public Target(int x, int y){
        this.x = x;
        this.y = y;
        this.escala = Escala.getescala();
        radio = (20f)*escala/40;
    }
    
    public int getx(){return x;}
    public int gety(){return y;}
    public int getescala(){return escala;}
    public float getradio(){return radio;}
    /**Metodo que cambia la posicion de target
     * @param x1 nueva posicion en el eje horizontal
     * @param y1 nueva posicion en el eje vertical
     */
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }
    /**Metodo que detecta si un punto esta dentro del radio del blanco
     * @param x coordenada en eje horizontal del punto a analizar
     * @param y coordenada en eje vertical del punto a analizar
     * @return true si el punto se encuentra dentro del radio de deteccion, false en caso contrario
     */
    public boolean checkearObjectivo(float x, float y) {
        Vector dist = new Vector(x - (this.x*escala/40)-radio, y - this.y-radio);

        // si el objetivo esta fuera del rango radial, descartar
        float mag = dist.magnitud();
        if (mag > radio /*+15f || mag < radio-15f*/) {
            return false;
        }else{
            return true;
        }
    }
    /** Metodo que renderiza el objeto*/
    @Override
     public void paint(Graphics g){
         g.setColor(Color.black);
         g.drawOval(x*escala/40, y, (int)radio*2, (int)radio*2);
         g.setColor(Color.lightGray);
         g.fillOval(x*escala/40, y, (int)radio*2, (int)radio*2);
         g.setColor(Color.darkGray);
         g.fillRect(x*escala/40, (y+16*escala/40), (int)radio*2, 6*escala/40);
         g.fillRect((x+17)*escala/40, y, 6*escala/40, (int)radio*2);
     }
    
}
