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
public class AvionTest {
    
    public AvionTest() {
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
     * Test of getx method, of class Avion.
     */
    @Test
    public void testGetx() {
        System.out.println("getx");
        Avion instance = null;
        int expResult = 0;
        int result = instance.getx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gety method, of class Avion.
     */
    @Test
    public void testGety() {
        System.out.println("gety");
        Avion instance = null;
        int expResult = 0;
        int result = instance.gety();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getescala method, of class Avion.
     */
    @Test
    public void testGetescala() {
        System.out.println("getescala");
        Avion instance = null;
        int expResult = 0;
        int result = instance.getescala();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changexy method, of class Avion.
     */
    @Test
    public void testChangexy() {
        System.out.println("changexy");
        int x1 = 0;
        int y1 = 0;
        Avion instance = null;
        instance.changexy(x1, y1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class Avion.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        Avion instance = null;
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
