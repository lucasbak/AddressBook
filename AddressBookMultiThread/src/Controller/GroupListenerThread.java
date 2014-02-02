/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Modele.FileManipulation;
import Modele.GetGroup;
import Modele.Group;
import Modele.TableModelContact;
import Modele.TableRenderer;
import Vue.ContactPanel;
import Vue.ViewContactPanel;
import Vue.Window;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Bakalian
 */
public class GroupListenerThread implements Runnable {
     private List<Contact> myList;
    private JPanel contactPanelToModify;
    private ContactPanel cp;
    private ViewContactPanel displayPanel;
    private int selectedGroup=0;
    private  String groupToShowString=null;
    private Window myWindow;
    private MouseEvent event;
    
    
   // public GroupListener (JPanel c){/
    /**
     * 
     * @param c the contact panel in orderto modify tje table of contact
     * @param vpc the accurate view panel
     * @param w the root window to have access to the different list and variable
     * @param e the event to see ( eventually) on which group we have clicked on
     */
     public GroupListenerThread( ContactPanel c,ViewContactPanel vpc,Window w,MouseEvent e) {
     //contactPanelToModify=c;
        displayPanel=vpc;
        cp=c;
        myWindow=w;
        event=e;
        
        
    }

    @Override
    public void run() {
       FileManipulation fm=new FileManipulation();// on alloue un nouveau file ma,nipulation pour obtenir la liste des contact
        List<Contact> newlist;
        JLabel tmp = null;
       
      if(event!=null){   tmp=(JLabel) event.getComponent();// on receptionne le jlabe qui a ete cliqué
      }
      
        GetGroup gg=new GetGroup();
        List<Group> listofGroup=gg.getGroups();//
        
        for(int i=0;i<listofGroup.size();i++){
            myWindow.getMyGroupPanel().getBackground().getComponent(i).setFont(new Font("Arial",1,12));
            myWindow.getMyGroupPanel().getBackground().getComponent(i).setForeground(Color.gray);
        }
      
       if(event!=null){  
           
           
        for(int j=0;j<listofGroup.size();j++){
            if(tmp.getName().equals(listofGroup.get(j).getNamegroup())){
                tmp.setForeground(Color.black);
                tmp.setFont(new Font("Arial",1,17));
                selectedGroup=listofGroup.get(j).getNumeroGroup();
                groupToShowString=listofGroup.get(j).getNamegroup();
                
            }
            
        }
       }
       else{
           myWindow.getMyGroupPanel().getBackground().getComponent(1).setFont(new Font("Arial",1,12));
            myWindow.getMyGroupPanel().getBackground().getComponent(1).setForeground(Color.gray);
            selectedGroup=listofGroup.get(0).getNumeroGroup();// on envoit le group 0 qui correspond à ALL
                groupToShowString=listofGroup.get(0).getNamegroup();
            
           
       }
      // we add those line in order to have the table updated when we delete or add a contact
      myWindow.setMyListofContact(fm.getSortedContact(selectedGroup));
      
     myWindow.getMyContactPanel().getMyTable().setModel(new TableModelContact(myWindow.getMyListofContact()));
     TableRowSorter<TableModelContact> sorter = new TableRowSorter<>((TableModelContact) myWindow.getMyContactPanel().getMyTable().getModel());
     myWindow.getMyContactPanel().getMyTable().setRowSorter(sorter);
     myWindow.getMyContactPanel().getMyTable().setRowSorter(sorter);
     sorter.setSortsOnUpdates(true);
     TableRenderer buttonRenderer = new TableRenderer();
     myWindow.getMyContactPanel().getMyTable().getColumnModel().getColumn(0).setCellRenderer(buttonRenderer);
     
    }
    
}
