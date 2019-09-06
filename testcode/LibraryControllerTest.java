/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.Window;
import static java.awt.event.KeyEvent.VK_ENTER;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mediabiblioteket.misc.DefaultOptionPane;
import mediabiblioteket.misc.MockOptionPane;

/**
 *
 * @author Simonster
 */
public class LibraryControllerTest {
// https://stackoverflow.com/questions/22417113/how-to-auto-click-ok-on-joptionpane-when-testing

    public static JDialog waitForDialog(String title) {

        JDialog win = null;
        do {
            for (Window window : Frame.getWindows()) {
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    // System.out.println(dialog.getTitle());
                    if (title.equals(dialog.getTitle())) {
                        win = dialog;
                        
                                        try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    break;
                }
                        
                        break;
                    }
                }
            }

            if (win == null) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException ex) {
                    break;
                }
            }

        } while (win == null);

        return win;

    }

    public static JButton getButton(Container container, String text) {
        JButton btn = null;
        List<Container> children = new ArrayList<>(25);
        for (Component child : container.getComponents()) {
            //    System.out.println(child);
            if (child instanceof JButton) {
                JButton button = (JButton) child;
                if (text.equals(button.getText())) {
                    btn = button;
                    break;
                }
            } else if (child instanceof Container) {
                children.add((Container) child);
            }
        }
        if (btn == null) {
            for (Container cont : children) {
                JButton button = getButton(cont, text);
                if (button != null) {
                    btn = button;
                    break;
                }
            }
        }
        return btn;
    }
// end of copied
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    
    public void testfunc(Boolean result, String input, LibraryController instance){
    
        
        
                // Code copied from slack
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

             

                   boolean temp = instance.checkInputOnlyDigits(input);

                

            }
        }
        );

        JDialog frame = waitForDialog("Error");
        System.out.println("Found window " + frame);
        if (frame != null) {
            final JButton btn = getButton(frame, "OK");
            System.out.println("Found button " + btn);
            
            if (btn != null) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {


                            System.out.println("Click");
                            btn.doClick();

                        
                    }
                }
                );
            }
        }
        
    
        
        
    }
    
    

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

    // Tests for CheckUserInput
    //@Test
    public void testCheckUserInput_nonwordCharacters() {
        System.out.println("testCheckUserInput_nonwordCharacters");

        //testdata 
        // any non word character except -,_,. and blankspace should return a false value for the test to pass.
        String teststring[] = {"!sdf", "@", "#", "$", "%", "^", "&", "&", "*", "&", "*", "(", ")", "=", "+", "<", ">", "?", ";", ":", ",", " ", "~", "`", "_", "-", "."};

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

    //@Test
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

    //@Test
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

    //@Test
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

    @Test
    public void testCheckInputOnlyDigits_validInput() {
        System.out.println("testCheckInputOnlyDigits_validInput");
        String inputString = "1234";
        LibraryController instance = new LibraryController();
        //instance.setOptionPane(new MockOptionPane());
        boolean expResult = true;
        boolean result = instance.checkInputOnlyDigits(inputString);
        assertEquals(expResult, result);

    }

    //@Test
    public void testCheckInputOnlyDigits_nonNumberInput() {
        System.out.println("testCheckInputOnlyDigits_nonrealNumberInput");
        //testdata 
        // any non word character except -,_,. and blankspace should return a false value for the test to pass.
        String teststring[] = {"aaa", "2asd", "sdf4", "!?", "12.34", "12,45"};
        //String teststring[] = {"aaa"};

        LibraryController instance = new LibraryController();
        instance.setOptionPane(new DefaultOptionPane());

        boolean expResult[] = new boolean[teststring.length];
        boolean Result[] = new boolean[teststring.length];

        for (int i = 0; i < teststring.length; i++) {

            Result[i] = instance.checkInputOnlyDigits(teststring[i]);

            expResult[i] = false;

        }

        if (!Arrays.equals(Result, expResult)) {
            System.out.println("Showing info for failed test: testCheckInputOnlyDigits_nonrealNumberInput");
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
    public void testCheckInputOnlyDigits_autoClick() {
        System.out.println("testCheckInputOnlyDigits_autoClick");
        //testdata 
        // any non word character except -,_,. and blankspace should return a false value for the test to pass.
        String teststring[] = {"aaa", "2asd", "sdf4", "!?", "12.34", "12,45"};

        LibraryController instance = new LibraryController();

        boolean expResult[] = new boolean[teststring.length];
        boolean Result[] = new boolean[teststring.length];

        String msg = "";
        
         int counting = 0;
        
        while(counting < teststring.length){
            // Code copied from slack
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

               

                    
                    expResult[0] = true;
                    Result[0] = instance.checkInputOnlyDigits(teststring[0]);

 

            }
        }
        );
        
             JDialog frame = waitForDialog("Error");
        System.out.println("Found window " + frame);
        if (frame != null) {
            final JButton btn = getButton(frame, "OK");
            System.out.println("Found button " + btn);
            
            if (btn != null) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {

                        for (int i = 0; i < teststring.length; i++) {
                            System.out.println("Click");
                            btn.doClick();

                        }
                    }
                }
                );
            }
        }
        
        counting++;
        
        }
        
        
        
        
                   for (int i = 0; i < teststring.length; i++) {
                        System.out.println("Result: "+Result[i]);

                       System.out.println("expResult: "+expResult[i]);

                }
        assertArrayEquals(Result, expResult);
    }

//    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        LibraryController instance = new LibraryController();
        instance.writeToFile();
        fail("The test case is a prototype.");
    }

//    @Test
    public void testBorrowMedia() {
        System.out.println("borrowMedia");
        Media theMedia = null;
        LibraryController instance = new LibraryController();
        instance.borrowMedia(theMedia);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testReturnMedia() {
        System.out.println("returnMedia");
        Media theMedia = null;
        LibraryController instance = new LibraryController();
        instance.returnMedia(theMedia);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testCheckIfBorrowerExist() {
        System.out.println("checkIfBorrowerExist");
        String borrowerID = "";
        LibraryController instance = new LibraryController();
        boolean expResult = false;
        boolean result = instance.checkIfBorrowerExist(borrowerID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testSortMedia() {
        System.out.println("sortMedia");
        LibraryController instance = new LibraryController();
        instance.sortMedia();
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetMedia() {
        System.out.println("getMedia");
        String ID = "";
        LibraryController instance = new LibraryController();
        Media expResult = null;
        Media result = instance.getMedia(ID);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testShowSelectedMediaInfo() {
        System.out.println("showSelectedMediaInfo");
        String theString = "";
        LibraryController instance = new LibraryController();
        instance.showSelectedMediaInfo(theString);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testSearchMediaAllByString() {
        System.out.println("searchMediaAllByString");
        String theSearchString = "";
        LibraryController instance = new LibraryController();
        instance.searchMediaAllByString(theSearchString);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetMediaFromSearchResult() {
        System.out.println("getMediaFromSearchResult");
        String theString = "";
        LibraryController instance = new LibraryController();
        Media expResult = null;
        Media result = instance.getMediaFromSearchResult(theString);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testSearchMediaTitleByString() {
        System.out.println("searchMediaTitleByString");
        String theSearchString = "";
        LibraryController instance = new LibraryController();
        instance.searchMediaTitleByString(theSearchString);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testGetBorrower() {
        System.out.println("getBorrower");
        String Ssn = "";
        LibraryController instance = new LibraryController();
        Borrower expResult = null;
        Borrower result = instance.getBorrower(Ssn);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testLoadBorrowedMedia() {
        System.out.println("loadBorrowedMedia");
        LibraryController instance = new LibraryController();
        boolean expResult = false;
        boolean result = instance.loadBorrowedMedia();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

//    @Test
    public void testSearchBorrowed() {
        System.out.println("searchBorrowed");
        LibraryController instance = new LibraryController();
        instance.searchBorrowed();
        fail("The test case is a prototype.");
    }

}
