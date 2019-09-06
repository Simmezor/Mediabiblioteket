/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket.misc;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Simonster
 */
public class MockOptionPane implements OptionPane {

   @Override
   public void showMessageDialog(Component parentComponent, Object message, 
   String title, int messageType) {
    //  The following dialog option has been commented out for the purposes  
    //  JOptionPane.showMessageDialog(parentComponent,message,title,messageType);
       System.out.println(title + "Message: " + message.toString());
    
   }
}