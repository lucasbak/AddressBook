/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Modele.FileManipulation;
import Modele.GetGroup;
import Modele.Group;
import Vue.Window;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Bakalian
 */
public class AddressBookSecond {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        // TODO code application logic here
        image();
        GetGroup g=new GetGroup();
        FileManipulation f=new FileManipulation();
        List<Group> lg=g.getGroups();
        List<Contact> c=f.getContact();
        Window mw;
        
        
        mw = new Window(lg,c);
    }

    public static void setIconImage(Image in) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void image(){
       Image i = null;
        try {
            i = ImageIO.read(new File("photo.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(AddressBookSecond.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(i);
    }
    
}
