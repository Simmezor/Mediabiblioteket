/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediabiblioteket.misc;

import java.awt.Component;

/**
 *
 * @author Simonster
 */
/*
* Note you can add all the methods you use in your application
*/
public interface OptionPane {
   public void showMessageDialog(Component parentComponent, Object message, 
   String title, int messageType);
}
