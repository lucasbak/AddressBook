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
import javax.swing.JPanel;

/**
 *
 * @author Bakalian
 */
public class GroupListener implements MouseListener {

    private List<Contact> myList;
    private JPanel contactPanelToModify;
    private final ContactPanel contactPanel;
    private final ViewContactPanel displayPanel;
    private int selectedGroup=0;
    private final  String groupToShowString=null;
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
        
        /**
         * step of the action:
         * we get the Jlabel we clicked on to know which group he want to see
         * we record the number & name of the group
         * we send it to the SorteCont of Filemanipulation which returns the list of contact belonging to this group
         * we get the model of the jtable
         * we change it the data, to update the JTABLe if not done the jtable doesn't update
         * 
         * need to change the model content to update jtable
         * don't forget to add accurate viewlistener on the new Jtable because of new model
         * the the smae step than contact Panel
         */
        
  
        
        
        
       
        

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
