package proyectof;


/**  */
public class Vector{
    public float x,y;
    
    public Vector(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public static float dot(Vector a, Vector b){
        return a.x * b.x + a.y * b.y;
    }
    
    public void escalar(float f){
        x *= f;
        y *= f;
    }
    
    public float magnitud(){
        return (float)Math.sqrt(x*x + y*y);
    }
    
    public void normalizar(){
        float mag = magnitud();
        x /= mag;
        y /= mag;
    }
}
