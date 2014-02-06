/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.GetGroup;
import Modele.Group;
import Vue.AddToGroupWindow;
import Vue.GroupPanel;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 *this listener is called when the user click on add to group
 * we get the existing list of group, create a new window and send it the list to choose the group
 * we also add a listener in order to record the group he clicks on
 * @author Bakalian
 */
public class RemoveFromGroupListener implements MouseListener {
    
    private List<Group> grouplist;
    private GetGroup groupGetter;
    private JPopupMenu popupMenuAdd;
    private JTable myTable;
    private int idNumber;
    private final Window myRootWindow;

    public RemoveFromGroupListener(Window window){//JPopupMenu popmenu) {
        myRootWindow=window;
        
        groupGetter= new GetGroup();
        grouplist=groupGetter.getGroups();
        //popupMenuAdd=popmenu;
        
     
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
         RemoveFromGroupListenerThread aTGLT=new RemoveFromGroupListenerThread(myRootWindow);
        Thread thread=new Thread(aTGLT);
        thread.start();
   /*     AddToGroupWindow window=new AddToGroupWindow();
        GroupPanel groupPanelLittle=new GroupPanel(grouplist);
        window.setContentPane(groupPanelLittle.getBackground());
        window.setSize(150, 300);
        window.setVisible(true);
        
           for(int i=0;i<groupPanelLittle.getBackground().getComponents().length;i++){
             // need to add this Listener to effectively record the group chosen for the contact chosen
                 groupPanelLittle.getBackground().getComponent(i).addMouseListener(new RemoveContactGroupListener(window,myRootWindow));
              
           }
     */   
      
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
