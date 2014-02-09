/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.GroupListener;
import Modele.Contact;
import Modele.Group;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *It's our Main Windows which contains all the Other Frame
 * @author Bakalian
 */
public class Window extends JFrame{
    
    private JPanel menuPanel;
    private JPanel groupPanel;
    private JPanel contactPanel;
    private JPanel displayPanel;
    private JPanel globalPanel;
    private GroupPanel myGroupPanel;
    private ContactPanel myContactPanel;// le panneau qui contient LEs groupes
    private ViewContactPanel myViewContactPanel;
    private List<Contact> myListofContact;
    private List<Group> myListOfGroup;
    
    public Window (List<Group> listg,List<Contact> listc){
            //creating all the containing Panel
        
            this.menuPanel = new JPanel();
            this.contactPanel = new JPanel();
            this.displayPanel = new JPanel();
            this.globalPanel = new JPanel();
            this.groupPanel=new JPanel();
            this.displayPanel=new JPanel();
            this.setIconImage(new ImageIcon("/Users/Bakalian/fond.jpg").getImage());
            
            
            
            
            myListofContact=listc;
            myListOfGroup=listg;
            
            
        
            this.setFocusable(false);
	    this.setTitle("Bakalian's AddressBook");
            this.setSize(700 ,550);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
            this.setBackground(new Color(247,247,247));
            
           


            // menuPanel=menu;
           
           myViewContactPanel=new ViewContactPanel(this);
           displayPanel.add(myViewContactPanel.getBackground());
           
           myContactPanel=new ContactPanel(this,myViewContactPanel);//create a Contact panel which show all the groups 
           contactPanel.add(myContactPanel.getBackground());
          
          
           
           
           myGroupPanel=new GroupPanel(listg,this);//create a group panel which show all the groups 
           groupPanel.add(myGroupPanel.getBackground());
         
                   
                   
           
           this.menuPanel.add(new JLabel("Bienvenue dans votre Repertoire\n"));
           this.menuPanel.setPreferredSize(new Dimension(200,50));
           this.menuPanel.setBackground(new Color(247,247,247));
           this.contactPanel.setBackground(new Color(247,247,247));
           this.displayPanel.setBackground(new Color(247,247,247));
           this.groupPanel.setBackground(new Color(247,247,247));
           this.myContactPanel.getBackground().setBackground(new Color(247,247,247));
           this.myGroupPanel.getBackground().setBackground(new Color(247,247,247));
           this.myViewContactPanel.getBackground().setBackground(new Color(247,247,247));
           
           
           // contactPanel=contact;
            //displayPanel=display;
            
            
            
            globalPanel.setLayout(new BorderLayout());
            globalPanel.add(menuPanel, BorderLayout.NORTH);
            globalPanel.add(groupPanel, BorderLayout.WEST);
            globalPanel.add(contactPanel,BorderLayout.CENTER);
            globalPanel.add(displayPanel,BorderLayout.EAST);
	    
           
            
            this.setContentPane(globalPanel);
            this.setVisible(true);
            
    }

    public List<Group> getMyListOfGroup() {
        return myListOfGroup;
    }

    public void setMyListOfGroup(List<Group> myListOfGroup) {
        this.myListOfGroup = myListOfGroup;
    }

  
    
    public void changeBackground(int n){
       // this.getContentPane().getComponent(n).remove();
    }
    public void addBackground(Component c){
        
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    public JPanel getGroupPanel() {
        return groupPanel;
    }

    public void setGroupPanel(JPanel groupPanel) {
        this.groupPanel = groupPanel;
    }

    public JPanel getContactPanel() {
        return contactPanel;
    }

    public void setContactPanel(JPanel contactPanel) {
        this.contactPanel = contactPanel;
    }

    public JPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(JPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    public JPanel getGlobalPanel() {
        return globalPanel;
    }

    public void setGlobalPanel(JPanel globalPanel) {
        this.globalPanel = globalPanel;
    }

    public GroupPanel getMyGroupPanel() {
        return myGroupPanel;
    }

    public void setMyGroupPanel(GroupPanel myGroupPanel) {
        this.myGroupPanel = myGroupPanel;
    }

    public ContactPanel getMyContactPanel() {
        return myContactPanel;
    }

    public void setMyContactPanel(ContactPanel myContactPanel) {
        this.myContactPanel = myContactPanel;
    }

    public ViewContactPanel getMyViewContactPanel() {
        return myViewContactPanel;
    }

    public void setMyViewContactPanel(ViewContactPanel myViewContactPanel) {
        this.myViewContactPanel = myViewContactPanel;
    }

    public List<Contact> getMyListofContact() {
        return myListofContact;
    }

    public void setMyListofContact(List<Contact> myListofContact) {
        this.myListofContact = myListofContact;
    }

}
