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
 *
 * @author Cesar
 */
public class TargetTest {
    private Target bullseye;
    public TargetTest() {
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
        bullseye = new Target(10,300);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getx method, of class Target.
     */
    @Test
    public void testGetx() {
        System.out.println("getx");
        int expResult = 10;
        int result = bullseye.getx();
        assertEquals(expResult, result);
    }

    /**
     * Test of gety method, of class Target.
     */
    @Test
    public void testGety() {
        System.out.println("gety");
        int expResult = 300;
        int result = bullseye.gety();
        assertEquals(expResult, result);
    }

    /**
     * Test of getescala method, of class Target.
     */
    @Test
    public void testGetescala() {
        System.out.println("getescala");

        int expResult = Escala.getescala();;
        int result = bullseye.getescala();
        assertEquals(expResult, result);

    }

    /**
     * Test of changexy method, of class Target.
     */
    @Test
    public void testChangexy() {
        System.out.println("changexy");
        int x1 = 0;
        int y1 = 0;

        bullseye.changexy(x1, y1);
        assertEquals(x1, bullseye.getx());
        assertEquals(y1, bullseye.gety());
    }

    /**
     * Test of checkearObjectivo method, of class Target.
     */
    @Test
    public void testCheckearObjectivo() {
        System.out.println("checkearObjectivo");
        System.out.println("checkearObjectivo");
        Point center = new Point(bullseye.getx(),bullseye.gety());
        Point test = generaPunto(center, bullseye.getradio(), 0);
        Point test2 = generaPunto(center,bullseye.getradio()+1, 30);
        boolean t1 = bullseye.checkearObjectivo(test.x, test.y);
        boolean t2 = bullseye.checkearObjectivo(test2.x, test2.y);
        boolean expResult_tooClose = true;
        boolean expResult_tooFar = false;
        assertEquals(expResult_tooClose, t1);
        assertEquals(expResult_tooFar, t2);
    }
}
