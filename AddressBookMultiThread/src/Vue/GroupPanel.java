/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.GroupListener;
import Modele.Group;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bakalian
 */
public class GroupPanel {
    
    private JPanel background;
    private List<Group> myList;
    private ContactPanel myContactPanel;
    
    public GroupPanel(List<Group> l){
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
       for(int i =0;i<myList.size();i++){
            c.gridy=i;
            JLabel jb=new JLabel(myList.get(i).getNamegroup());
            jb.setName(myList.get(i).getNamegroup());
            jb.setFont(new Font("Arial",1,12));
            jb.setForeground(Color.gray);
            //jb.setBackground(new Color(232,232,232));
            
            if(i==0){
               jb.setFont(new Font("Arial",1,17)); 
               jb.setForeground(Color.black);
            }
            background.add(jb,c);
            background.setPreferredSize(new Dimension(150, 300));
        }
        
        
        
      
        
        
        
        
        
        background.setVisible(true);
        background.setAutoscrolls(true);
        
       
        
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
    
    
    
}

