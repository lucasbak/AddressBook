/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.AddGroupRecordListener;
import Controller.DeletFieldListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bakalian
 */
public class GroupForm extends JFrame{
    
    private final JTextField name;
    private JPanel background;
    private JButton validate;
    private final Window myRootWindow;
    
    /**
     * We add juste 2 part a button to validate and a JTextField to have the name
     * @param w the global window to be able to access every element
     */
    
    public GroupForm(Window w){
        
        myRootWindow=w;
        
        validate=new JButton("Enregistrer");
        validate.setName("enregistrer");
        validate.addMouseListener(new AddGroupRecordListener(this,myRootWindow));
       
        name=new JTextField ("name of the new group");
        name.addMouseListener(new DeletFieldListener(name));
        name.setName("New Group");
       
        
        background=new JPanel();
        background.setLayout(new GridLayout());
       
        background.add(new JLabel("Type the name of the new group \n "));
        background.add(name);
        background.add(validate);
        this.setContentPane(background);
        this.setVisible(true);
        this.setSize(900,100);
        name.requestFocus();
        
    
    }
/**
 * 
 * @return the nama of the new group
 */
    public JTextField getTextFieldName() {
        return name;
    }
}
