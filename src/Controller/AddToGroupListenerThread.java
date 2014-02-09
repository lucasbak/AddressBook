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
public class AddToGroupListenerThread implements Runnable{
    
    
     private List<Group> grouplist;
    private GetGroup groupGetter;
    private JPopupMenu popupMenuAdd;
    private JTable myTable;
    private int idNumber;
    private final Window myRootWindow;

    public AddToGroupListenerThread(Window window){//JPopupMenu popmenu) {
        myRootWindow=window;
        
        
        
        //popupMenuAdd=popmenu;
        
     
    }
/**
 * Step by Step:
 * we get the list og existing group
 * we launche the window to display it
 * we add on each jlabel (containg the name of the group) a listener to record the user choice
 * then we launch the group listener thread to refresh the contact list
 */
    @Override
    public void run() {
        
        groupGetter= new GetGroup();
        grouplist=groupGetter.getGroups();
        AddToGroupWindow window=new AddToGroupWindow();
        
        GroupPanel groupPanelLittle=new GroupPanel(grouplist,myRootWindow);
        window.setContentPane(groupPanelLittle.getBackground());
        window.setSize(150, 500);
        window.setVisible(true);
        
           for(int i=0;i<groupPanelLittle.getBackground().getComponents().length;i++){
             // need to add this Listener to effectively record the group chosen for the contact chosen
                 groupPanelLittle.getBackground().getComponent(i).addMouseListener(new RecordContactGroupListener(window,myRootWindow));
              
           }
           GroupListenerThread groupLT=new GroupListenerThread(this.myRootWindow.getMyContactPanel(),this.myRootWindow.getMyViewContactPanel(),this.myRootWindow,null);
        Thread thread = new Thread(groupLT);
        thread.start();
    }
    
}
