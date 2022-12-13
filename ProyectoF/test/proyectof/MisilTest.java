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
        Point center = new Point((int)explosive.x,(int)explosive.y);
        Point test = generaPunto(center, explosive.radio, 0);
        Point test2 = generaPunto(center,explosive.radio+1, 30);
        Misil instance = null;
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
        Point center = new Point((int)explosive.x,(int)explosive.y);
        Point test = generaPunto(center, explosive.radio, explosive.angulo+(explosive.velAngular));
        float expResult = explosive.angulo-(explosive.velAngular);
        explosive.girar(test.x, test.y);
        assertEquals(expResult, explosive.angulo,0);
        
    }

    /**
     * Test of mover method, of class Misil.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Vector testVec = new Vector((float) Math.cos(Math.toRadians(explosive.angulo)), (float) Math.sin(Math.toRadians(explosive.angulo)));
        testVec.escalar(explosive.velocidad);
        Float exp_posx = explosive.x+testVec.x;
        Float exp_y = explosive.y+testVec.y;
        explosive.mover();
        
        
        assertEquals(exp_posx, explosive.x,0);
        assertEquals(exp_y, explosive.y,0);
    }

    /**
     * Test of paint method, of class Misil.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        Misil instance = null;
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
