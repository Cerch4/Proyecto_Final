/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectof;

import java.awt.Point;
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
public class AngularTest {
    private Point dot;
    public AngularTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dot = new Point(5,9);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of generaPunto method, of class Angular.
     */
    @Test
    public void testGeneraPunto_3args() {
        System.out.println("generaPunto");
        Point expResult = new Point(5,18);
        Point result = Angular.generaPunto(dot, 9, -90);
        assertEquals(expResult, result);
    }

    /**
     * Test of generaPunto method, of class Angular.
     */
    @Test
    public void testGeneraPunto_4args() {
        System.out.println("generaPunto");

        Point expResult = new Point(5,18);
        Point Result = Angular.generaPunto(dot.x, dot.y, 9, -90);
        assertEquals(expResult, Result);

    }
    
}
