package proyectof;
import java.awt.Point;
public class Angular {
    public static Point generaPunto(Point uno, double r, double alfaGiro) {
        int x = (int) ((double) uno.x + r * Math.cos(alfaGiro * Math.PI / 180f));
        int y = (int) ((double) uno.y - r * Math.sin(alfaGiro * Math.PI / 180f));
        Point p = new Point(x, y);
        return p;
    }
    public static Point generaPunto(int x, int y, double r, double alfaGiro) {
        int xx = (int) ((double) x + r * Math.cos(alfaGiro * Math.PI / 180f));
        int yy = (int) ((double) y - r * Math.sin(alfaGiro * Math.PI / 180f));
        Point p = new Point(xx, yy);
        return p;
    }
}