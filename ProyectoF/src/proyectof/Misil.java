package proyectof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 * Un sprite movil de un misil 2D 
 * @author Cesar
 * @see Vector.java
 * @see Angular.java
 */
public class Misil {
    
    /**Floats que almacenan la posicion en horizontal y vertical del misil */
    float x, y;
    /** Float que almacena el angulo en que se mueve el misil, en sentido horario*/
    float angulo = 90; 
    /** Float que almacena el radio de deteccion de objetos del misil*/
    float radio = 80*FrameP.escala/40;
    /** Float que almacena la velocidad de giro del misil*/
    float velAngular = 5f;
    /** Float que almacena la velocidad de movimiento del misil */
    float velocidad = 10f;
    /** Float que la escala del tamaño del misil*/
    float t = 10f*FrameP.escala/40;
    
    /** Metodo constructor de la clase
     * @param x posicion inicial horizontal del misil
     * @param y posivion inicial vertical del misil
     */
    public Misil(float x, float y){
        this.x = x;
        this.y = y;
        
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
        }

        Vector frente = new Vector((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));

        dist.normalizar();
        frente.normalizar();

        // si el objetivo esta frente al misil, entonces retornar verdadero
        if(Vector.dot(dist, frente) > 0f){
            return true;
        } // sino, descartar
        else return false;
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
        
        if(x > 16*FrameP.escala) x = -100*FrameP.escala/40; // cambia a v = 0 *****
        if(x < 0) x = -100*FrameP.escala/40;
        
        if(y > 9*FrameP.escala) y = -100*FrameP.escala/40;
        if(y < 0) y =-100*FrameP.escala/40;
    }
    /** Metodo paint del misil, dibuja un misil de un tamaño determinado por el parametro t, contenido dentro un circulo de tamaño determinado por el parametro radio
     * @param g objeto de la clase Graphics que permite renderizar el objeto
     */

    public void paint(Graphics g) {
        g.setColor(Color.black);
        //g.drawOval((int) (x - radio), (int) (y - radio), (int) radio * 2, (int) radio * 2);

        //Vector linea = new Vector((float) Math.cos(Math.toRadians(angulo + 90)), (float) Math.sin(Math.toRadians(angulo + 90)));
        //linea.escalar(radio);

        //g.drawLine((int) (x + linea.x), (int) (y + linea.y), (int) (x - linea.x), (int) (y - linea.y));
        
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