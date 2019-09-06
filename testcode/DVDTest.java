/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket;

import collections.LinkedList;
import java.util.Arrays;
import static mediabiblioteket.LibraryControllerTest.ANSI_CYAN;
import static mediabiblioteket.LibraryControllerTest.ANSI_GREEN;
import static mediabiblioteket.LibraryControllerTest.ANSI_RED;
import static mediabiblioteket.LibraryControllerTest.ANSI_RESET;
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
    public void testToString(){
        System.out.println("toString");

        

        boolean result = false;
        boolean expResult = true;

        LinkedList<String> actors = new LinkedList();

        actors.add("Tom Cruse");
        
        actors.add("Demi Moor");

        DVD instance = new DVD("DVD", "Jaws III", "99999", 2015, actors);

        LinkedList testdata = new LinkedList();

        /// loop
        
          LinkedList temp = instance.getActors();
        
        for (int i = 0; i < actors.size(); i++) {

          testdata.add(temp.get(i));

        }
       

        testdata.add(instance.getTitle());

        testdata.add(instance.getYear());

        testdata.add(instance.getMediaType());

        testdata.add(instance.getObjectID());

        // function under test
        String listedinfo = instance.toString();

        for (int i = 0; i < testdata.size(); i++) {
            if (listedinfo.contains(String.valueOf(testdata.get(i)))) {
                result = true;

            } else {
                result = false;
                break;
            }

        }

        if (expResult != result) {
            System.out.println("Showing info for failed test: testToString");

            System.out.println("String searched:");
            System.out.println(listedinfo);
            System.out.println("Tried to find:");

            for (int i = 0; i < testdata.size(); i++) {

                System.out.println(String.valueOf(testdata.get(i)));
            }
        }

        assertEquals(expResult, result);
    }

    /**
     * Test of listInfo method, of class DVD.
     */
    @Test
    public void testListInfo() {
        System.out.println("testListInfo");

        boolean result = false;
        boolean expResult = false;

        LinkedList<String> actors = new LinkedList();

        String [] actors1 = { "Tom Cruse","Demi Moor" };
        
        actors.add("Tom Cruse");
        
        actors.add("Demi Moor");

        DVD instance = new DVD("DVD", "Jaws III", "99999", 2015, actors);
        
        Borrower b = new Borrower("John Smith","1232","tel00012");
        
        
        instance.setThisMediaBorrower(b);
        //System.out.println("Borrowed or not:");
        //System.out.println(String.valueOf(instance.isBorrowed()));

        instance.setBorrowed(true);
        //System.out.println(String.valueOf(instance.isBorrowed()));
        
        LinkedList testdata = new LinkedList();

      
        LinkedList temp = instance.getActors();
        
        for (int i = 0; i < actors.size(); i++) {

          testdata.add(temp.get(i));

        }
       
        testdata.add(instance.getTitle());

        testdata.add(instance.getYear());

        testdata.add(instance.getMediaType());

        testdata.add(instance.getObjectID());

        // function under test
        String listedinfo = instance.listInfo();

        for (int i = 0; i < testdata.size(); i++) {
            if (listedinfo.contains(String.valueOf(testdata.get(i)))) {
                result = true;

            } else {
                result = false;
                break;
            }

        }

        if (expResult != result) {
            System.out.println("Showing info for failed test: testListInfo");

            System.out.println("String searched:");
            System.out.println(listedinfo);
            System.out.println("Tried to find:");

            for (int i = 0; i < testdata.size(); i++) {

                System.out.println(String.valueOf(testdata.get(i)));
            }
        }

        assertEquals(expResult, result);
    }

}
