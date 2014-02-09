/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.GetGroup;
import Modele.GetGroupContact;
import Vue.GroupForm;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Bakalian
 */
public class RemoveGroupListener implements MouseListener {
    
    
    private final Window myRootWindow;

    public RemoveGroupListener(Window rootPane) {
       
        myRootWindow=rootPane;
    }
    
    
    

    @Override
    public void mouseClicked(final MouseEvent e) {
               
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        
                       
                       GetGroup myGetGrouper=new GetGroup();
                       // delete the group from the group.csv file ( containing list of group and  name)
          
 myGetGrouper.deleteGroup(myRootWindow.getMyGroupPanel().getSelectedGroupLabel().getText(),myRootWindow);
                       GetGroupContact myGetGroupContacer=new GetGroupContact();
                      // deleting group from  groupcontact.csv file
                       myGetGroupContacer.deleteGroup(myRootWindow.getMyGroupPanel().getSelectedGroupLabel().getText(),myGetGrouper.getNumberFromName(myRootWindow.getMyGroupPanel().getSelectedGroupLabel().getText()));
                      myRootWindow.getMyGroupPanel().changeDown();
                    
                    }    
                    
                } );
                        
                        
                thread.start();
        
       
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
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
