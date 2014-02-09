/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.AddGroupListener;
import Controller.AddToGroupListener;
import Controller.GroupListener;
import Controller.HelpListener;
import Controller.RemoveFromGroupListener;
import Controller.RemoveGroupListener;
import Modele.Group;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Bakalian
 */
public class GroupPanel {
    
    private  JPanel background;
    private List<Group> myList;
    private ContactPanel myContactPanel;
    private JButton addGroupButton;
    private JButton deleteGroupButton;
    private final Window myRootPane;
    private List<GroupListener> listofListener;// we have to keep a track of those listener to be anable tom remove them ( when changing the JLABEL nd their listener)
    private AddGroupListener listenergroupadd; // the listener of the button with have to keep a track of !
    private RemoveGroupListener listenergroupdel;
    
    private JLabel selectedGroupLabel;
    
    
    public GroupPanel(List<Group> l,Window w){
        listofListener=new ArrayList<>();
        myRootPane=w;
        background=new JPanel();
        myList=l;
        background.setLayout(new GridBagLayout());
       // background.setLayout(new FlowLayout());
        GridBagConstraints c = new GridBagConstraints(); // on a besoin de ca pour definir les placements 
        c.fill = GridBagConstraints.BOTH;
        c.insets= new Insets(10,10,10,10);// defini la marge 
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridwidth=GridBagConstraints.WEST;
        c.ipadx=100;
        c.weightx=100;
        
        
        c.gridheight=1;
           
        c.gridx=0;
        // each time we read a new group we create a JLabel with it's name and add it to the Panel
       for(int i =0;i<myList.size();i++){
            c.gridy=i;
            JLabel jb=new JLabel(myList.get(i).getNamegroup());
            jb.setName(myList.get(i).getNamegroup());
            jb.setFont(new Font("Arial",1,12));
            jb.setForeground(Color.gray);
            GroupListener gl=new GroupListener(myRootPane.getMyContactPanel(),myRootPane.getMyViewContactPanel(),myRootPane);
            jb.addMouseListener(gl);
            listofListener.add(gl);
            //jb.setBackground(new Color(232,232,232));
            
            if(i==0){
               jb.setFont(new Font("Arial",1,17)); 
               jb.setForeground(Color.black);
            }
            background.add(jb,c);
            background.setPreferredSize(new Dimension(150, 350));
        }
     
    
       JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemAddAGroup = new JMenuItem("Add a Group");
        JMenuItem menuItemRemoveFromGroup = new JMenuItem("Remove a Group ");
        

        
        
        
        popupMenu.add(menuItemAddAGroup);
        popupMenu.add(menuItemRemoveFromGroup);
       
        
        
        
       menuItemAddAGroup.addMouseListener(new AddGroupListener(null,myRootPane));
       menuItemRemoveFromGroup.addMouseListener(new RemoveGroupListener(myRootPane));
       
       background.setComponentPopupMenu(popupMenu);  

        
      
      
      
      
        
        
        
        
        
        background.setVisible(true);
        background.setAutoscrolls(true);
        
        
       
        
    }

    public JLabel getSelectedGroupLabel() {
        return selectedGroupLabel;
    }

    public void setSelectedGroupLabel(JLabel selectedGroupLabel) {
        this.selectedGroupLabel = selectedGroupLabel;
    }
    /**
     * 
     * @return the background of this Panel
     */
    
    public JPanel getBackground() {
        return background;
    }

    public List<Group> getMyList() {
        return myList;
    }

    public void setMyList(List<Group> myList) {
        this.myList = myList;
    }

    public ContactPanel getMyContactPanel() {
        return myContactPanel;
    }

    public void setMyContactPanel(ContactPanel myContactPanel) {
        this.myContactPanel = myContactPanel;
    }

    public void changeList() {
        
        myList=myRootPane.getMyListOfGroup();// on recupère la nouvelle liste
        
        
        
        List<GroupListener> newlistofListener; //on créer une nouvelle liste de Listener
        newlistofListener=new ArrayList<>();
        List<GroupListener> oldlistofListener;
        oldlistofListener=listofListener;
        
        
         GridBagConstraints c = new GridBagConstraints(); // on a besoin de ca pour definir les placements 
        c.fill = GridBagConstraints.BOTH;
        c.insets= new Insets(10,10,10,10);// defini la marge 
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridwidth=GridBagConstraints.WEST;
        c.ipadx=100;
        c.weightx=100;
        
        
        c.gridheight=1;
           
        c.gridx=0;
        
        // each time we read a new group we create a JLabel with it's name and add it to the Panel
       for(int i =0;i<myList.size();i++){
            c.gridy=i;
            if(i!=myList.size()-1){
                /**
                 * en fait lors de l'ajout d'un group on possède la liste mais arrive dernier le jlabel nexiste pasd donc on doit le
                 * créer ainsi que son listener 
                 * donc on teste tant qu'on est pas au dernier ( index correspondant) on peut juste rennomer les jlabel, sinon il faut le créer
                 */
            
            JLabel jb=(JLabel)background.getComponent(i);
            jb.setText(myList.get(i).getNamegroup());
            
            jb.removeMouseListener(oldlistofListener.get(i));
             GroupListener gl=new GroupListener(myRootPane.getMyContactPanel(),myRootPane.getMyViewContactPanel(),myRootPane);
            jb.addMouseListener(gl);
            newlistofListener.add(gl);
            
            jb.addMouseListener(new GroupListener(myRootPane.getMyContactPanel(),myRootPane.getMyViewContactPanel(),myRootPane));
            //jb.setBackground(new Color(232,232,232));
            if(i==0){
               jb.setFont(new Font("Arial",1,17)); 
               jb.setForeground(Color.black);
            }
          
           }
           
            // si on arrive à la fin de la liste on a plus desormais de boutton on doit le remplacer par un Jlabel
            // du coup on doit retirer le listener ( automatique si on retire le composant directement) correspondant au boutton pour le remplacer par un grouplistener !
            
          if(i==myList.size()-1){
              c.gridy=i;
             JLabel jb=new JLabel(myList.get(i).getNamegroup());
            jb.setName(myList.get(i).getNamegroup());
            jb.setFont(new Font("Arial",1,12));
            jb.setForeground(Color.gray);
            GroupListener gl=new GroupListener(myRootPane.getMyContactPanel(),myRootPane.getMyViewContactPanel(),myRootPane);
            jb.addMouseListener(gl);
            newlistofListener.add(gl);
            background.add(jb,c);
               
           }
           
        }
      
      
      
        
        
        
        background.setPreferredSize(new Dimension(150, background.getSize().height+50));
        background.setVisible(true);
        background.setAutoscrolls(true);
        background.repaint();
        listofListener=newlistofListener;
        
        
        //
    }

    public void changeDown() {
        
        myList=myRootPane.getMyListOfGroup();// on recupère la nouvelle liste
        
        
        
        List<GroupListener> newlistofListener; //on créer une nouvelle liste de Listener
        newlistofListener=new ArrayList<>();
        List<GroupListener> oldlistofListener;
        oldlistofListener=listofListener;
        
        
         GridBagConstraints c = new GridBagConstraints(); // on a besoin de ca pour definir les placements 
        c.fill = GridBagConstraints.BOTH;
        c.insets= new Insets(10,10,10,10);// defini la marge 
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridwidth=GridBagConstraints.WEST;
        c.ipadx=100;
        c.weightx=100;
        
        
        c.gridheight=1;
           
        c.gridx=0;
       
        // each time we read a new group we create a JLabel with it's name and add it to the Panel
       for(int i =0;i<myList.size();i++){
            c.gridy=i;
            if(i!=myList.size()-1){
                /**
                 * en fait lors de l'ajout d'un group on possède la liste mais arrive dernier le jlabel nexiste pasd donc on doit le
                 * créer ainsi que son listener 
                 * donc on teste tant qu'on est pas au dernier ( index correspondant) on peut juste rennomer les jlabel, sinon il faut le créer
                 */
            
            JLabel jb=(JLabel)background.getComponent(i);
            jb.setText(myList.get(i).getNamegroup());
            
            jb.removeMouseListener(oldlistofListener.get(i));
             GroupListener gl=new GroupListener(myRootPane.getMyContactPanel(),myRootPane.getMyViewContactPanel(),myRootPane);
            jb.addMouseListener(gl);
            newlistofListener.add(gl);
            
            jb.addMouseListener(new GroupListener(myRootPane.getMyContactPanel(),myRootPane.getMyViewContactPanel(),myRootPane));
            //jb.setBackground(new Color(232,232,232));
            if(i==0){
               jb.setFont(new Font("Arial",1,17)); 
               jb.setForeground(Color.black);
            }
          
           }
           
          
      
        }
      background.remove(myList.size());
    
        
        
        
        background.setPreferredSize(new Dimension(150, background.getSize().height+50));
        background.setVisible(true);
        background.setAutoscrolls(true);
        background.repaint();
        listofListener=newlistofListener;
        
        
        //
        
    }
    
    
    
}

