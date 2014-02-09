/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Vue.ViewContactPanel;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;

/**
 *The accurate view listener is need in order to see in detail the contact the user click on
 * So we need the Jtable, the list of contact, and the view contact panel
 * @author Bakalian
 */
public class AccurateViewListener implements MouseListener{

    private JTable myTable=null;
    private final List<Contact> myContacts;
    private final ViewContactPanel displayPanel;
    private int SelectedRow;
    private final Window myWindow;
   
  
     /**
      * 
      * @param t The Table of the application we get it to be able to get the rower and model
      * @param w the global window to have access at all the variables to set them
      * @param display the view in detail panel to change the information in it
      */
    public AccurateViewListener (JTable t,Window w,ViewContactPanel display){
        myTable=t;
        displayPanel=display;
        myWindow=w;
        myContacts=w.getMyListofContact();
        
      
    }
    /**
     * 
     * @param e classical mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        AccurateViewListenerThread aclt=new AccurateViewListenerThread(myTable,myWindow,displayPanel,e);
       Thread tc=new Thread(aclt);
       tc.start();
            
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSelectedRow() {
        return SelectedRow;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }
    
}
