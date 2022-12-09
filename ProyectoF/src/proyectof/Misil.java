/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectof;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 *
 * @author Cesar
 */
public class Misil {
    
   /* public int x;
    public int y;
    private int escala; */
    float x, y;
    float angulo = 43; // 0 - 360, sentido del reloj
    float radio = 80;
    float velAngular = 5f;
    float velocidad = 15f;
    float t = 10f;
    
    public Misil(float x, float y){
        this.x = x;
        this.y = y;
        
    }
    
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
    
    public void mover(){
        Vector frente = new Vector((float) Math.cos(Math.toRadians(angulo)), (float) Math.sin(Math.toRadians(angulo)));
        frente.escalar(velocidad);
        
        x += frente.x;
        y += frente.y;
        
        if(x > PanelP.WIDTH) x -= PanelP.WIDTH;
        if(x < 0) x += PanelP.WIDTH;
        
        if(y > PanelP.HEIGHT) y -= PanelP.HEIGHT;
        if(y < 0) y += PanelP.HEIGHT;
    }
    
    
    public void changexy(int x1, int y1){
        x = x1;
        y= y1;
    }

     public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawOval((int) (x - radio), (int) (y - radio), (int) radio * 2, (int) radio * 2);

        Vector linea = new Vector((float) Math.cos(Math.toRadians(angulo + 90)), (float) Math.sin(Math.toRadians(angulo + 90)));
        linea.escalar(radio);

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
