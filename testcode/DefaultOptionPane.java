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



public class DefaultOptionPane implements OptionPane {
   public DefaultOptionPane() {
      //intentional
   }
   /*** we have moved the code from the service to here ***/
   public void showMessageDialog(Component parentComponent, Object message, 
   String title, int messageType) {
      JOptionPane.showMessageDialog(parentComponent,message,title,messageType);
   }
}


