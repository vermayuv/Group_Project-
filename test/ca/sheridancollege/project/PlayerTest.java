/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yuvra
 */
public class PlayerTest {
    
    public PlayerTest() {
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

    
   


    @Test
    public void testEqualsGood() {
        System.out.println("equals");
        Player p1 = new Player("GOOD");
        Player instance = new Player("BAD");
        boolean expResult = false;
        boolean result = instance.equals(p1);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testEqualsBad() {
        System.out.println("equals");
        Player p1 = new Player("bad");
        Player instance =new Player("bad");
        boolean expResult = true;
        boolean result = instance.equals(p1);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testEqualsBoundary() {
        System.out.println("equals");
        Player p1 =new Player("boundary");
        Player instance = new Player("boundaries");
        boolean expResult = false;
        boolean result = instance.equals(p1);
        assertEquals(expResult, result);
       
    }
    
}
