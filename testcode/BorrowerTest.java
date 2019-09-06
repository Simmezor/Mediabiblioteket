/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket;

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
public class BorrowerTest {
    
    public BorrowerTest() {
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
     * Test of setName method, of class Borrower.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        
        //Testdata
        String name = "Simon";
        
        
        Borrower b = new Borrower("","","");
        
      
        b.setName(name);

   
        
        if(b.getName() != "Simonm"){
        fail();
        }
                
                
    }

 
    
}
