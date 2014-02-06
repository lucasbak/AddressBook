/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Modele.FileManipulation;
import Modele.GetGroup;
import Modele.GetGroupContact;
import Modele.Group;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 *this Listener delete the contact in the accurateView from the database (csv folder)
 * @author Bakalian
 */
public class DeleteContactListener implements MouseListener{
    
    private Window myRootWindow;
    private int idNumber;
    private List<Contact> listofContact;
    private List<Group> listofGroup;

    public DeleteContactListener(Window w){
        myRootWindow=w;
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        GroupListenerThread groupLT=new GroupListenerThread(this.myRootWindow.getMyContactPanel(),this.myRootWindow.getMyViewContactPanel(),this.myRootWindow,null);
        listofContact=myRootWindow.getMyListofContact();
        idNumber=myRootWindow.getMyContactPanel().getIdNumber();
        for(int i=0;i<listofContact.size();i++){
            if(Integer.parseInt(listofContact.get(i).getIdNumber())==idNumber){
                listofContact.remove(i);
                 FileManipulation fm=new FileManipulation();
                 fm.DeleteContact(listofContact);
                 myRootWindow.setMyListofContact(listofContact);
            }
        }
        GetGroupContact ggc=new GetGroupContact();
        GetGroup gg=new GetGroup();
        listofGroup=gg.getGroups();
        for(int j=1;j<listofGroup.size();j++){
            ggc.DeleteContactGroup(listofGroup.get(j).getNamegroup(), idNumber);
        }
        
       
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
