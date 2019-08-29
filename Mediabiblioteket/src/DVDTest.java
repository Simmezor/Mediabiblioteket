/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediabiblioteket.code;

import collections.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class DVDTest {
    
    public DVDTest() {
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
     * Test of getActors method, of class DVD.
     */
    @Test
    public void testGetActors() {
        System.out.println("getActors");
        DVD instance = null;
        LinkedList<String> expResult = null;
        LinkedList<String> result = instance.getActors();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActors method, of class DVD.
     */
    @Test
    public void testSetActors() {
        System.out.println("setActors");
        LinkedList<String> actors = null;
        DVD instance = null;
        instance.setActors(actors);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class DVD.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        DVD instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listInfo method, of class DVD.
     */
    @Test
    public void testListInfo() {
        System.out.println("listInfo");
        DVD instance = null;
        String expResult = "";
        String result = instance.listInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
