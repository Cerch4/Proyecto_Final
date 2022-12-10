package proyectof;

import java.awt.Point;

/**Clase que entrega un punto en una posicion relativa a otro 
 * @author Cesar
 */
public class Angular {
    
    /**Metodo que genera un punto en posicion relativa a uno dado segun un angulo y distancia determinada
     * @param uno Point en base al que se generara el nuevo punto
     * @param r double que determina la distancia a la que se encontrara el nuevo punto respecto al Point [uno] 
     * @param alfaGiro double que determina el angulo respecto a [uno] en que se encontrara el nuevo punto
     * @return un nuevo punto a distancia [r] y angulo [alfaGiro] del punto [uno]
     */
    public static Point generaPunto(Point uno, double r, double alfaGiro) {
        int x = (int) ((double) uno.x + r * Math.cos(alfaGiro * Math.PI / 180f));
        int y = (int) ((double) uno.y - r * Math.sin(alfaGiro * Math.PI / 180f));
        Point p = new Point(x, y);
        return p;
    }
    /**Metodo que genera un punto en posicion relativa a uno dado segun un angulo y distancia determinada
     * @param x coordenada horizontal del punto en base al cual se generara el nuevo punto
     * @param y coordenada vertical del punto en base al cual se generara un nuevo punto
     * @param r double que determina la distancia a la que se encontrara el nuevo punto respecto al punto [x,y] 
     * @param alfaGiro double que determina el angulo respecto a [x,y] en que se encontrara el nuevo punto
     * @return un nuevo punto a distancia [r] y angulo [alfaGiro] del punto [x,y]
     */
    public static Point generaPunto(int x, int y, double r, double alfaGiro) {
        int xx = (int) ((double) x + r * Math.cos(alfaGiro * Math.PI / 180f));
        int yy = (int) ((double) y - r * Math.sin(alfaGiro * Math.PI / 180f));
        Point p = new Point(xx, yy);
        return p;
    }
}
