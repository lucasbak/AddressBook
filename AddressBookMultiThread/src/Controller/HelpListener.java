/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *this listener is called when the user click on add to group
 * we get the existing list of group, create a new window and send it the list to choose the group
 * we also add a listener in order to record the group he clicks on
 * @author Bakalian
 */
public class HelpListener  implements MouseListener {
    
   
    
  

    public HelpListener(){//JPopupMenu popmenu) {
     
        
     
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         JFrame myFrame=new JFrame();
        JLabel myLabel=new JLabel();
        String Text="1-Click on the name of the group , in order to show all the contacts belonging to it \n"
                +"2-Click right on the name of the contact to add it  to a group or remove it from a group";
        
        myLabel.setText(Text);
        myFrame.add(myLabel);
        
        
        myFrame.setSize(200, 1000);
        myFrame.setVisible(true);
        System.out.println("TESTTTTTTTT");
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
