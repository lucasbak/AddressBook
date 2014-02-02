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
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 *
 * @author Bakalian
 */
public class RemoveFromGroupListenerThread implements Runnable{
    
     private List<Group> grouplist;
    private GetGroup groupGetter;
    private JPopupMenu popupMenuAdd;
    private JTable myTable;
    private int idNumber;
    private final Window myRootWindow;

    public RemoveFromGroupListenerThread(Window window){//JPopupMenu popmenu) {
        myRootWindow=window;
        
        
        //popupMenuAdd=popmenu;
        
     
    }

    @Override
    public void run() {
        groupGetter= new GetGroup();
        grouplist=groupGetter.getGroups();
         AddToGroupWindow window=new AddToGroupWindow();
        GroupPanel groupPanelLittle=new GroupPanel(grouplist);
        window.setContentPane(groupPanelLittle.getBackground());
        window.setSize(150, 300);
        window.setVisible(true);
        
           for(int i=0;i<groupPanelLittle.getBackground().getComponents().length;i++){
             // need to add this Listener to effectively record the group chosen for the contact chosen
                 groupPanelLittle.getBackground().getComponent(i).addMouseListener(new RemoveContactGroupListener(window,myRootWindow));
              
           }
    }
    
}
