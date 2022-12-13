/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectof;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cesar
 */
public class TargetTest {
    
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
        Target instance = null;
        int expResult = 0;
        int result = instance.getx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gety method, of class Target.
     */
    @Test
    public void testGety() {
        System.out.println("gety");
        Target instance = null;
        int expResult = 0;
        int result = instance.gety();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getescala method, of class Target.
     */
    @Test
    public void testGetescala() {
        System.out.println("getescala");
        Target instance = null;
        int expResult = 0;
        int result = instance.getescala();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changexy method, of class Target.
     */
    @Test
    public void testChangexy() {
        System.out.println("changexy");
        int x1 = 0;
        int y1 = 0;
        Target instance = null;
        instance.changexy(x1, y1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkearObjectivo method, of class Target.
     */
    @Test
    public void testCheckearObjectivo() {
        System.out.println("checkearObjectivo");
        float x = 0.0F;
        float y = 0.0F;
        Target instance = null;
        boolean expResult = false;
        boolean result = instance.checkearObjectivo(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class Target.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        Target instance = null;
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
