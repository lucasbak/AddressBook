/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Vue.ContactPanel;
import Vue.ViewContactPanel;
import Vue.Window;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *
 * @author Bakalian
 */
public class GroupListener implements MouseListener {

    private List<Contact> myList;
    private final ContactPanel contactPanel;
    private final ViewContactPanel displayPanel;
    private int selectedGroup=0;

    private final Window myWindow;
    
    
   // public GroupListener (JPanel c){
     public GroupListener( ContactPanel c,ViewContactPanel vpc,Window w) {
     //contactPanelToModify=c;
        displayPanel=vpc;
        contactPanel=c;
        myWindow=w;
        
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        GroupListenerThread groupLT=new GroupListenerThread(contactPanel,displayPanel,myWindow,e);
        Thread thread = new Thread(groupLT);
        thread.start();
        
        
        
  
        
        
        
       
        

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

    public int getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(int selectedGroup) {
        this.selectedGroup = selectedGroup;
    }
    
}
