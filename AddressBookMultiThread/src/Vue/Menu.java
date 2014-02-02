/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Bakalian
 */
public class Menu {
    
    private JPanel MenuBackground;
    private JButton Add;
    private JButton Edit;
    private JButton Delete;
    private JButton SeeList;
    private JButton Search;

    public Menu() {
        Add=new JButton("Add");
       
        SeeList=new JButton("SeeList");
        Search=new JButton("Search");
        
        MenuBackground=new JPanel();
        MenuBackground.setSize(500, 400);
        MenuBackground.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); // on a besoin de ca pour definir les placements 
        c.fill = GridBagConstraints.BOTH;
        c.insets= new Insets(5,5,5,5);// defini la marge 
        
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridheight=1;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=0;
      
        MenuBackground.add(Add);
        
       
        
       
        
        
        c.gridx=1;
        c.gridy=0;

        MenuBackground.add(SeeList);
        
       
        
        
        
    }
    
    public JPanel getMenuBackground() {
        return MenuBackground;
    }
    
    
    
    
    
}
