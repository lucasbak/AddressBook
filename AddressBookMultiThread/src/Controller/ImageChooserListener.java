/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *Class need to choose the file for the new Contact
 * @author Bakalian
 */
public class ImageChooserListener implements MouseListener {
    
    private JFileChooser choix; 
    private String absolutePath;
    private String nameFile;
    private int retour;
    private JFrame window;
    private JTextField textFielToModify;
   

    public ImageChooserListener(JFrame jf,JTextField jtf){
        window=jf;
        textFielToModify=jtf;

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        choix=new JFileChooser();
        retour=choix.showDialog(window, "ajouter");
        if(retour==JFileChooser.APPROVE_OPTION){
           nameFile= choix.getSelectedFile().getName();
           absolutePath=choix.getSelectedFile().getAbsolutePath();
           textFielToModify.setText(absolutePath);
        }
        else{
            absolutePath="photo.jpg";
            nameFile="photo.jpg";
            textFielToModify.setText(absolutePath);
        }// pas de fichier choisi
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}
