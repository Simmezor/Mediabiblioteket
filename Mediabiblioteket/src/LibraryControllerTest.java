/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediabiblioteket.code;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simonster
 */
public class LibraryControllerTest {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public LibraryControllerTest() {
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
    public void testCheckUserInput_nonwordCharacters() {
        System.out.println("testCheckUserInput_nonwordCharacters");

        //testdata 
        // any non word character except -,_,. and blankspace should return a false value for the test to pass.
        String teststring[] = {"!","abc!","!abc","a!bc", "@", "#", "$", "%", "^", "&", "&", "*", "&", "*", "(", ")", "=", "+", "<", ">", "?", ";", ":", ",", " ", "~", "`", "_", "-", "."};

        LibraryController instance = new LibraryController();

        boolean expResult[] = new boolean[teststring.length];
        boolean Result[] = new boolean[teststring.length];

        for (int i = 0; i < teststring.length; i++) {

            Result[i] = instance.checkUserInput(teststring[i]);

            expResult[i] = ".".equals(teststring[i]) || "-".equals(teststring[i]) || "_".equals(teststring[i]) || " ".equals(teststring[i]);

        }

        if (!Arrays.equals(Result, expResult)) {
            System.out.println("Showing info for failed test: testCheckUserInput_nonwordCharacters");
            for (int i = 0; i < teststring.length; i++) {
                if (Result[i] != expResult[i]) {
                    System.out.println("Testdata: " + ANSI_CYAN + teststring[i] + ANSI_RESET + " Result: " + ANSI_RED + Result[i] + ANSI_RESET + " Expected: " + ANSI_RED + expResult[i] + ANSI_RESET);
                } else {
                    System.out.println("Testdata: " + ANSI_CYAN + teststring[i] + ANSI_RESET + " Result: " + ANSI_GREEN + Result[i] + ANSI_RESET + " Expected: " + ANSI_GREEN + expResult[i] + ANSI_RESET);
                }

            }
        }

        assertArrayEquals(Result, expResult);

    }

    @Test
    public void testCheckUserInput_wordCharactersENG() {
        System.out.println("testCheckUserInput_wordCharactersENG");

        // testdata
        String teststring[] = {"abcdefghijklmnopqrstvwxyz", "ABCDEFGHIJKLMNOPQRSTVWXYZ"};

        LibraryController instance = new LibraryController();

        boolean expResult[] = new boolean[teststring.length];
        boolean Result[] = new boolean[teststring.length];

        for (int i = 0; i < teststring.length; i++) {

            expResult[i] = true;
            Result[i] = instance.checkUserInput(teststring[i]);

        }

        assertArrayEquals(Result, expResult);

    }

    @Test
    public void testCheckUserInput_wordCharactersSWE() {
        System.out.println("testCheckUserInput_wordCharactersSWE");

        // testdata
        String teststring[] = {"abcdefghijklmnopqrstuvwxyzåäö", "ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ"};

        LibraryController instance = new LibraryController();

        boolean expResult[] = new boolean[teststring.length];
        boolean Result[] = new boolean[teststring.length];

        for (int i = 0; i < teststring.length; i++) {

            expResult[i] = true;
            Result[i] = instance.checkUserInput(teststring[i]);

        }
        
                if (!Arrays.equals(Result, expResult)) {
            System.out.println("Showing info for failed test: testCheckUserInput_wordCharactersSWE");
            for (int i = 0; i < teststring.length; i++) {
                if (Result[i] != expResult[i]) {
                    System.out.println("Testdata: " + ANSI_CYAN + teststring[i] + ANSI_RESET + " Result: " + ANSI_RED + Result[i] + ANSI_RESET + " Expected: " + ANSI_RED + expResult[i] + ANSI_RESET);
                } else {
                    System.out.println("Testdata: " + ANSI_CYAN + teststring[i] + ANSI_RESET + " Result: " + ANSI_GREEN + Result[i] + ANSI_RESET + " Expected: " + ANSI_GREEN + expResult[i] + ANSI_RESET);
                }

            }
        }

        assertArrayEquals(Result, expResult);

    }

    @Test
    public void testCheckUserInput_emptyString() {
        System.out.println("testCheckUserInput_emptyString");

        // testdata
        String teststring[] = {null};

        LibraryController instance = new LibraryController();

        boolean expResult[] = new boolean[teststring.length];
        boolean Result[] = new boolean[teststring.length];

        for (int i = 0; i < teststring.length; i++) {

            expResult[i] = false;
            Result[i] = instance.checkUserInput(teststring[i]);

        }

        assertArrayEquals(Result, expResult);

    }

}
