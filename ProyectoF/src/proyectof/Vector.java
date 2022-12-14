package proyectof;
public class Vector{
    public float x,y;
    /** Metodo constructor de la clase
     * @param x posicion inicial horizontal del Vector
     * @param y posivion inicial vertical del Vector
     */
    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }
    public static float dot(Vector a, Vector b){
        return a.x * b.x + a.y * b.y;
    }
    /**Metodo que aumenta el vector por un escalar
    * @param f es un escalar el cual se multiplicara con las cordenadas x e y en aumenta el tamaño del vector
    */
    public void escalar(float f){
        x *= f;
        y *= f;
    }
    /**Metodo que calcula la distancia del 0,0 hacia vector en otras palabras su magnitud
    * @return la hipotenusa resultante de la aplicacion del teorema de pitagoras con las variables x e y de Vector
    */
    public float magnitud(){
        return (float)Math.sqrt(x*x + y*y);
    }
    public void normalizar(){
        float mag = magnitud();
        x /= mag;
        y /= mag;
    }
}