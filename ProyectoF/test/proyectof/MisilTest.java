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
public class MisilTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkearObjectivo method, of class Misil.
     */
    @Test
    public void testCheckearObjectivo() {
        System.out.println("checkearObjectivo");
        float x = 0.0F;
        float y = 0.0F;
        Misil instance = null;
        boolean expResult = false;
        boolean result = instance.checkearObjectivo(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of girar method, of class Misil.
     */
    @Test
    public void testGirar() {
        System.out.println("girar");
        float x = 0.0F;
        float y = 0.0F;
        Misil instance = null;
        instance.girar(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mover method, of class Misil.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Misil instance = null;
        instance.mover();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
