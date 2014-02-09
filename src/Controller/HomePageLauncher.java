/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *this Listener is called when the user clicks on a webpage, it launchs the firefox Browser
 * just implemented it for Mac os systeme
 * @author Bakalian
 */
public class HomePageLauncher implements MouseListener{
    
   private String homepage;
/**
 * 
 * @param str is cotaining the webpage
 */
    public HomePageLauncher(String str) {
  
       homepage=str;
		
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec(new String[] { "/Applications/Firefox.app/Contents/MacOS/firefox","-new-tab", homepage } );
        } catch (IOException ex) {
            Logger.getLogger(HomePageLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    
}
