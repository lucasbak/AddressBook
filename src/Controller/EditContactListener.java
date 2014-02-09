/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Modele.FileManipulation;
import Vue.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JTextField;

/**
 *this class listener record deirectly evry modificationk brought by the user in the accurate view
 * @author Bakalian
 */
public class EditContactListener implements KeyListener {
    
  private final Window myWindow;
    
    public EditContactListener(Window w){
       
        myWindow=w;
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(final KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //System.out.println("KEYCODE "+ e.getKeyCode());
        
        
        if(e.getKeyCode()==10){
            
            /**
             * for each case , same processus
             * we see which field is modified
             * we take the new value and put i in the corresponding contact ine the list
             * record the new list
             */
          
            String cmp=e.getComponent().getName();
            if(cmp.equals("FirstName")){
            
                FileManipulation fm=new FileManipulation();// we need this class to record
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setFirstName(jf.getText());
                    }
                }

//listofContact.get(this.avl.getSelectedRow()).setFirstName(jf.getText());// we set the new value to the contact in the list
                fm.DeleteContact(listofContact);// record the new list
           
            }
            if(cmp.equals("LastName")){
            
                FileManipulation fm=new FileManipulation();
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setLastName(jf.getText());
                    }
                }

//listofContact.get(this.avl.getSelectedRow()).setLastName(jf.getText());
                fm.DeleteContact(listofContact);
           
            }
            if(cmp.equals("HomeAddress")){
            
                FileManipulation fm=new FileManipulation();
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
//                listofContact.get(this.avl.getSelectedRow()).setHomeAddress(jf.getText());
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setHomeAddress(jf.getText());
                    }
                }
                fm.DeleteContact(listofContact);
           
            }
             if(cmp.equals("Notes")){
            
                FileManipulation fm=new FileManipulation();
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
                //listofContact.get(this.avl.getSelectedRow()).setNotes(jf.getText());
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setNotes(jf.getText());
                    }
                }
                fm.DeleteContact(listofContact);
           
            }
            
            if(cmp.equals("PersonalPhone")){
            
                FileManipulation fm=new FileManipulation();
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
               // listofContact.get(this.avl.getSelectedRow()).setPersonalPhone(jf.getText());
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setPersonalPhone(jf.getText());
                    }
                }
                fm.DeleteContact(listofContact);
           
            }
            if(cmp.equals("Email")){
            
                FileManipulation fm=new FileManipulation();
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
               // listofContact.get(this.avl.getSelectedRow()).setEmail(jf.getText());
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setEmail(jf.getText());
                    }
                }
                fm.DeleteContact(listofContact);
           
            }
            if(cmp.equals("HomePage")){
            
                FileManipulation fm=new FileManipulation();
                List<Contact> listofContact=fm.getContact();
                JTextField jf=(JTextField) e.getComponent();// we have to cast the component in order to use getText() method
               // listofContact.get(this.avl.getSelectedRow()).setHomePage(jf.getText());
                for(int i=0;i<listofContact.size();i++){
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setHomePage(jf.getText());
                    }
                }
                fm.DeleteContact(listofContact);
           
            }
            
          
        }
    
    }
    
}
