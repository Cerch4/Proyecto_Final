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
    private Avion nine11;
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
    nine11 = new Avion(0,0, 160);
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
        int expResult = 0;
        int result = nine11.getx();
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testGetxTrascambiarValordex() {
        System.out.println("getx");
        
        nine11.changexy(5, nine11.gety());
        int expResult = 5;
        int result = nine11.getx();
        assertEquals(expResult, result);  
    }

    
    /**
     * Test of gety method, of class Avion.
     */
    @Test
    public void testGety() {
        System.out.println("gety");
        int expResult = 0;
        int result = nine11.gety();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetyTrascambiarValordey() {
        System.out.println("gety");
        
        nine11.changexy(nine11.getx(), 5);
        int expResult = 5;
        int result = nine11.gety();
        assertEquals(expResult, result);  
    }

    /**
     * Test of getescala method, of class Avion.
     */
    @Test
    public void testGetescala() {
        System.out.println("getescala");
        int expResult = 160;
        int result = nine11.getescala();
        assertEquals(expResult, result);
    }

    /**
     * Test of changexy method, of class Avion.
     */
    @Test
    public void testChangexy() {
        System.out.println("changexy");
        int x1 = 5;
        int y1 = 10;
        nine11.changexy(x1, y1);
        assertEquals(y1, nine11.gety());
        assertEquals(x1, nine11.getx());
    }

    
}