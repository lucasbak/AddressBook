/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.GetGroup;
import Vue.GroupForm;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Bakalian
 */
public class AddGroupRecordListener implements MouseListener {
    private final GroupForm windowToClose;
    private final Window myRootWindow;

    /**
     * 
     * @param windowToClose the window where we wrote the name of the new group has to be disposed so we take it as a parameter
     * @param rootPane the global pane to have access to root variables
     */
    public AddGroupRecordListener(GroupForm windowToClose,Window rootPane) {
        this.windowToClose = windowToClose;
        myRootWindow=rootPane;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
         
    }

    @Override
    public void mousePressed(MouseEvent e) {
       JButton boutton=(JButton)e.getComponent();
       
        if(boutton.getName().equals("enregistrer")){
        
                Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        
                        windowToClose.dispose();
                   
                    GetGroup myGroupGetter=new GetGroup();
                    myGroupGetter.recordNewGroup(windowToClose.getTextFieldName()); // we record the new group ( it's name) in the group.csv file and groupcontact.csv
                    myGroupGetter=null;
                    myGroupGetter=new GetGroup();
                     myRootWindow.setMyListOfGroup(myGroupGetter.getGroups()); // we update the list of gorup in the root variables
                     myRootWindow.getMyGroupPanel().changeList();// wwe update the view
                    }    
                    
                } );
                        
                        
                thread.start();
        }
       
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
