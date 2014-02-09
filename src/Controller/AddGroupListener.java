/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.GetGroup;
import Vue.GroupForm;
import Vue.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Bakalian
 */
public class AddGroupListener implements MouseListener {
    private final GroupForm windowToClose;
    private final Window myRootWindow;

    public AddGroupListener(GroupForm windowToClose,Window rootPane) {
        this.windowToClose = windowToClose;
        myRootWindow=rootPane;
          System.out.println("Test");
    }
    
    
    

    @Override
    public void mouseClicked( MouseEvent e) {
       
                    

        
               
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
      Thread thread = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        
                        
                    GroupForm mygroupform=new GroupForm(myRootWindow);
                    
                   
                            
                        }
                    }
                );
        thread.start();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
