/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author simon
 */
public class helpFunctions {

    public static void clearFile(String filename) {
        System.out.println("clearFile");

        try {
            PrintWriter theOutPutf = new PrintWriter(new FileOutputStream(new File("src/mediabiblioteket/files/" + filename)));

            theOutPutf.flush();

            theOutPutf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println(System.err);
        }

    }

    public static ArrayList getFileInfo(String filename) {

        ArrayList temp = new ArrayList();

        try {
            StringTokenizer theTokenizer;
            Scanner theScanner = new Scanner(new File("src/mediabiblioteket/files/" + filename));

            while (theScanner.hasNext()) {

                String theLine = theScanner.nextLine();
                temp.add(theLine);

            }
            theScanner.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return temp;
    }
}
