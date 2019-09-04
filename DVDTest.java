/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mediabiblioteket.code;

import collections.LinkedList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
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

    @Test
    public void testGetActors() {
        System.out.println("getActors");

        //  Dvd;283228;Donnie Darko;2002;Jake Gyllenhaal;Drew Barrymore;Jena Malone;Patrick Swayze;Noah Wyle
        LinkedList<String> actors = new LinkedList();

        actors.add("Jake Gyllenhaal");
        actors.add("Drew Barrymore");
        actors.add("Jena Malone");
        actors.add("Patrick Swayze");
        actors.add("Noah Wyle");

        // DVD(String mediaType, String title, String objectID, int year, LinkedList<String> actors)
        DVD instance = new DVD("Dvd", "Donnie Darko", "283228", 2002, actors);

        String s1 = instance.toString();

        String searchstring[] = {"Jake", "Banana", "Holy Bible", "Gyllenhaal"};

        for (int i = 0; i < searchstring.length; i++) {

            if (s1.contains(searchstring[i])) {
                System.out.println("Found: " + searchstring[i]);
            } else {
                System.out.println("Could not find: " + searchstring[i]);
            }

        }

    }

}
