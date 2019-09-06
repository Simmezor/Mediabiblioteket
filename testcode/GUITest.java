/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket;


import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class GUITest implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public GUITest() {
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
     * Test of login method, of class GUI.
     */
    @Test
    public void testLogin() throws IOException,
            AWTException, InterruptedException {


        System.out.println("login");
        String userName = "";

        System.out.println("Sleeping done 1");

        GraphicsEnvironment ge = GraphicsEnvironment.
                getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();

        Runtime run = Runtime.getRuntime();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block 
            e.printStackTrace();
        }

        Robot r = new Robot();

        r.keyPress(KeyEvent.VK_E);

        GUI instance = new GUI();

        r.keyPress(KeyEvent.VK_B);

        // TODO review the generated test code and remove the default call to fail.
    }

    public void testMain() {
        System.out.println("main");
        String[] arguments = null;
        GUI.main(arguments);

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
