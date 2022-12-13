/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package proyectof;

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
public class VectorTest {
    private Vector Atlas;
    public VectorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    Atlas = new Vector(10f,10f);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of dot method, of class Vector.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        Vector a = new Vector (5f,2f);
        Vector b = new Vector (7f,9f);
        float expResult = a.x*b.x + a.y*b.y;
        float result = Vector.dot(a, b);
        assertEquals(expResult, result,0);
        
    }

    /**
     * Test of escalar method, of class Vector.
     */
    @Test
    public void testEscalar() {
        System.out.println("escalar");
        float f = 7.0f;
        float a = Atlas.x*f;
        float b = Atlas.y*f;
        Atlas.escalar(f);
        assertEquals(a, Atlas.x,0);
        assertEquals(b, Atlas.y,0);
    }

    /**
     * Test of magnitud method, of class Vector.
     */
    @Test
    public void testMagnitud() {
        System.out.println("magnitud");
        float expResult = (float)Math.sqrt(Atlas.x*Atlas.x + Atlas.y*Atlas.y);
        float result = Atlas.magnitud();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of normalizar method, of class Vector.
     */
    @Test
    public void testNormalizar() {
        System.out.println("normalizar");
        float mag = Atlas.magnitud();
        float a = Atlas.x/mag;
        float b = Atlas.x/mag;
        Atlas.normalizar();
        assertEquals(a, Atlas.x, 0);
        assertEquals(b, Atlas.y, 0);
    }
    
}
