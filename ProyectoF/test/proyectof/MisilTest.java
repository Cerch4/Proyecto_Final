/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectof;

import java.awt.Graphics;
import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static proyectof.Angular.generaPunto;

/**
 *s
 * @author Cesar
 */
public class MisilTest {
    private Misil explosive;
    
    
    public MisilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Escala.setescala(40);
        explosive = new Misil( 20f, 20f);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkearObjectivo method, of class Misil. En este test se crean dos puntos y se verifica si estan o no dentro el rango de deteccion del misil
     */
    @Test
    public void testCheckearObjectivo() {
        System.out.println("checkearObjectivo");
        Point center = new Point((int)explosive.getx(),(int)explosive.gety());
        Point test = generaPunto(center, explosive.getradio(), 0);
        Point test2 = generaPunto(center,explosive.getradio()+1, 30);
        boolean t1 = explosive.checkearObjectivo(test.x, test.y);
        boolean t2 = explosive.checkearObjectivo(test2.x, test2.y);
        boolean expResult_tooClose = true;
        boolean expResult_tooFar = false;
        
        assertEquals(expResult_tooClose, t1);
        assertEquals(expResult_tooFar, t2);
    }

    /**
     * Test of girar method, of class Misil.
     */
    @Test
    public void testGirar() {
        System.out.println("girar");
        Point center = new Point((int)explosive.getx(),(int)explosive.gety());
        Point test = generaPunto(center, explosive.getradio(), explosive.getangulo()+(explosive.getvelAngular()));
        float expResult = explosive.getangulo()+(explosive.getvelAngular());
        explosive.girar(test.x, test.y);
        assertEquals(expResult, explosive.getangulo(),0);
        
    }

    /**
     * Test of mover method, of class Misil.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Escala.setescala(40);
        Vector testVec = new Vector((float) Math.cos(Math.toRadians(explosive.getangulo())), (float) Math.sin(Math.toRadians(explosive.getangulo())));
        testVec.escalar(explosive.getvelocidad());
        Float exp_posx = explosive.getx()+(float)testVec.x;
        Float exp_y = explosive.gety()+(float)testVec.y;

        explosive.mover();
        
        assertEquals(exp_y, explosive.gety(),0);
        assertEquals(exp_posx, explosive.getx(),0);
    }
    
}
