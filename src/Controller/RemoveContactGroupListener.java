/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.GetGroupContact;
import Modele.TableModelContact;
import Vue.AddToGroupWindow;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

/**
 *class need to record the new contact for the selected Group
 * need the window to close it after group selection
 * @author Bakalian
 */
public class RemoveContactGroupListener implements MouseListener{

   
    
    
    private final AddToGroupWindow windowtoClose;
    private final Window myRootWindow;
    private final int idNumberRemove;
/**
 * 
 * @param adgw the window where the list is displayed
 * @param rootwindow the root window 
 */
    public RemoveContactGroupListener(AddToGroupWindow adgw,Window rootwindow) {
        myRootWindow=rootwindow;
        idNumberRemove=myRootWindow.getMyContactPanel().getIdNumber();
        windowtoClose=adgw;
    }
    /**
     * we catch the id of the group to remove
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        GetGroupContact ggc=new GetGroupContact();
        ggc.DeleteContactGroup(e.getComponent().getName(), idNumberRemove);// send the name of the group and idofContact
       this.windowtoClose.dispose();// we close the window
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
