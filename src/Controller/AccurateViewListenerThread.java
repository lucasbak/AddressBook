/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Vue.ViewContactPanel;
import Vue.Window;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Bakalian
 */
public class AccurateViewListenerThread implements Runnable{

    private JTable myTable=null;
    private final List<Contact> myContacts;
    private final ViewContactPanel displayPanel;
    private int SelectedRow;
    private final Window myWindow;
    private MouseEvent event;
    
    
    
     public AccurateViewListenerThread (JTable t,Window w,ViewContactPanel display,MouseEvent e){
        myTable=t;
        displayPanel=display;
        myWindow=w;
        myContacts=w.getMyListofContact();
        event=e;
        
      
    }
    
    @Override
    public void run() {
        Point p = event.getPoint();
       myWindow.getMyContactPanel().setIdNumber(Integer.parseInt(myWindow.getMyListofContact().get(myWindow.getMyContactPanel().getMyTable().getRowSorter().convertRowIndexToModel(myWindow.getMyContactPanel().getMyTable().rowAtPoint(event.getPoint()))).getIdNumber()));
       System.out.println("test id number AVL :" + myWindow.getMyContactPanel().getIdNumber());
       int idnumber=myWindow.getMyContactPanel().getIdNumber();
       
        
        // get the row index that contains that coordinate
	
 
        /**
         * What we do is to change the content of the accurate view of the contact
         * we need to convert the index given by the jtable thanks to it rowSorterconverter
         * because avec Sorting contact the index has changed, an we need the original one
         */
        if (event.getClickCount() == 1){
           
            
          
          for(int i=0;i<myWindow.getMyListofContact().size();i++){
              
              if(Integer.parseInt(myWindow.getMyListofContact().get(i).getIdNumber())==idnumber){
                  
                    displayPanel.getFirstName().setText(myWindow.getMyListofContact().get(i).getFirstName());
                    displayPanel.getLastName().setText(myWindow.getMyListofContact().get(i).getLastName());
                    displayPanel.getPhone().setText(myWindow.getMyListofContact().get(i).getPersonalPhone());
                    displayPanel.getEmail().setText(myWindow.getMyListofContact().get(i).getEmail());
                    displayPanel.getHomepage().setText(myWindow.getMyListofContact().get(i).getHomePage());
                    displayPanel.getAddress().setText(myWindow.getMyListofContact().get(i).getHomeAddress());
                    
                    
                    if(myWindow.getMyListofContact().get(i).getPhoto().isEmpty()==false){
               
              ImageIcon image=new ImageIcon(new ImageIcon(myWindow.getMyListofContact().get(i).getPhoto()).getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT));
              displayPanel.getM().getLabel().setIcon(image);
              
           }
          else {
               ImageIcon image=new ImageIcon(new ImageIcon("photo.jpg").getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT));
               displayPanel.getM().getLabel().setIcon(image);
               
           }
        
    }
    

          }
          
          
        }
    }
}