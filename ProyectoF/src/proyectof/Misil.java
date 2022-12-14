package proyectof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 * Un sprite movil de un misil 2D 
 * @see Vector
 * @see Angular
 */
public class Misil extends JPanel{
    
    /**Floats que almacenan la posicion en horizontal y vertical del misil */
    private float x, y;
    /** Float que almacena el angulo en que se mueve el misil, en sentido horario*/
    private float angulo;
    /**int para almacenar la escala del Misil respecto a la ventana*/
    private int escala;
    /** Float que almacena el radio de deteccion de objetos del misil*/
    private float radio;
    /** Float que almacena la velocidad de giro del misil*/
    private float velAngular;
    /** Float que almacena la velocidad de movimiento del misil */
    private float velocidad;
    /** Float que la escala del tamaño del misil*/
    private float t;

    /** Metodo constructor de la clase
     * @param x posicion inicial horizontal del misil
     * @param y posivion inicial vertical del misil
     */
    public Misil(float x, float y){
        this.x = x;
        this.y = y;
        this.angulo = 90; 
        this.escala = Escala.getescala();
        this.radio = 80*escala/40;
        this.velAngular = 10f;
        this.velocidad = 10f*escala/40;
        this.t = 10f*escala/40;
    }

    public void setangulo(float angulo){this.angulo = angulo;}
    public void setx(float x){this.x = x;}
    public void sety(float y){this.y = y;}
    public float getangulo(){return angulo;}
    public float getradio(){return radio;}
    public float getvelAngular(){return velAngular;}
    public float getvelocidad(){return velocidad;}
    public float getx(){return x;}
    public float gety(){return y;}
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }
    /**Metodo que detecta si un punto esta en el rango de deteccion del Misil
     * @param x coordenada en eje horizontal del punto a analizar
     * @param y coordenada en eje vertical del punto a analizar
     * @return true si el punto se encuentra dentro del radio de deteccion, false en caso contrario
     */
    public boolean checkearObjectivo(float x, float y) { 
        Vector dist = new Vector(x - this.x, y - this.y);
        // si el objetivo esta fuera del rango radial, descartar
        float mag = dist.magnitud();
        if (mag > radio) {
            return false;
        }else{
            return true;
        }
    }
    /**Metodo que gira el misil en la direccion de un punto determinado en base a la diferencia de angulo entre el misil y el punto, y la velocidad angular  
     * @param x coordenada en eje horizontal del punto al que se desea girar
     * @param y coordenada en eje vertical del punto al que se desea girar
     */
    public void girar(float x, float y) {
        Vector dist = new Vector(x - this.x, y - this.y);

        // pasamos el angulo a Vector en 2 dimensiones
        float anguloObjetivo = (float) Math.toDegrees(Math.atan2(dist.y, dist.x));

        // encontrar la direccion con menor dif de angulo
        float delta = anguloObjetivo - angulo;
        float delta2 = anguloObjetivo - angulo - 360f;
        float delta3 = anguloObjetivo - angulo + 360f;
        if (Math.abs(delta2) < Math.abs(delta) && Math.abs(delta2) < Math.abs(delta3)) {
            delta = delta2;
        }
        if (Math.abs(delta3) < Math.abs(delta) && Math.abs(delta3) < Math.abs(delta2)) {
            delta = delta3;
        }

        // si la diferencia de angulo es menor a la velocidad angular, rotar directamente al objetivo
        if (Math.abs(delta) < velAngular) {
            angulo = anguloObjetivo;
        } else {
            angulo += Math.signum(delta) * velAngular;
        }

        // ajuste de angulo final al rango -180, 180
        if (angulo < -180) {
            angulo += 360f;
        } else if (angulo > 180) {
            angulo -= 360f;
        }
    }
    /**Metodo para mover el misil en base al angulo al que apunta y la velocidad de movimiento en el instante dado */
    public void mover(){
        Vector frente = new Vector((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));
        frente.escalar(velocidad);
        
        x += frente.x;
        y += frente.y;
        
        if(x > 16*escala) x = -100*escala/40; // cambia a v = 0 *****
        if(x < 0) x = -100*escala/40;
        
        if(y > 9*escala) y = -100*escala/40;
        if(y < 0) y =-100*escala/40;
    }
    /** Metodo paint del misil, dibuja un misil de un tamaño determinado por el parametro t, contenido dentro un circulo de tamaño determinado por el parametro radio
     * @param g objeto de la clase Graphics que permite renderizar el objeto
     */

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawOval((int) (x - radio+20), (int) (y - radio+20), (int) (radio-20) * 2, (int) (radio-20) * 2);

        Vector linea = new Vector((float) Math.cos(Math.toRadians(angulo + 90)), (float) Math.sin(Math.toRadians(angulo + 90)));
        linea.escalar(radio-20);

        g.drawLine((int) (x + linea.x), (int) (y + linea.y), (int) (x - linea.x), (int) (y - linea.y));
        
        Polygon poly = new Polygon();
        
        Point p = Angular.generaPunto((int)x, (int)y, t * 2, -angulo);
        poly.addPoint(p.x, p.y);
        
        p = Angular.generaPunto((int)x, (int)y, t, -angulo + 30);
        poly.addPoint(p.x, p.y);
        
        p = Angular.generaPunto((int)x, (int)y, t, -angulo + 150);
        poly.addPoint(p.x, p.y);
        
        p = Angular.generaPunto((int)x, (int)y, t * 2, -angulo + 150);
        poly.addPoint(p.x, p.y);
        
        p = Angular.generaPunto((int)x, (int)y, t * 2, -angulo - 150);
        poly.addPoint(p.x, p.y);
        
        p = Angular.generaPunto((int)x, (int)y, t, -angulo - 150);
        poly.addPoint(p.x, p.y);
        
        p = Angular.generaPunto((int)x, (int)y, t, -angulo - 30);
        poly.addPoint(p.x, p.y);
        
        g.setColor(Color.red);
        g.fillPolygon(poly);
        
        g.setColor(Color.blue);
        g.drawPolygon(poly);
        
    }


    
}