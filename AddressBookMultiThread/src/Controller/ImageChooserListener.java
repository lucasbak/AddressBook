/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Modele.FileManipulation;
import Vue.Window;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
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
    private final JFrame window;
    private JTextField textFielToModify;
    private Window myRootWindow;
   

    public ImageChooserListener(JFrame jf,JTextField jtf,Window mrw){
        window=jf;
        textFielToModify=jtf;
        myRootWindow=mrw;

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        choix=new JFileChooser();
        retour=choix.showDialog(window, "ajouter");
        if(retour==JFileChooser.APPROVE_OPTION){
           nameFile= choix.getSelectedFile().getName();
           absolutePath=choix.getSelectedFile().getAbsolutePath();
           if(textFielToModify!=null){
                        textFielToModify.setText(absolutePath);
           }
           else {
                FileManipulation fm=new FileManipulation();// we need this class to record
                List<Contact> listofContact=fm.getContact();
               for(int i=0;i<myRootWindow.getMyListofContact().size();i++){
                   
                    if(Integer.parseInt(listofContact.get(i).getIdNumber())==myRootWindow.getMyContactPanel().getIdNumber()){
                        listofContact.get(i).setPhoto(absolutePath);
                    }
                }
               fm.DeleteContact(listofContact);// record the new list
           }
           
        }
        else{
            if(textFielToModify!=null){
            absolutePath="photo.jpg";
            nameFile="photo.jpg";
            textFielToModify.setText(absolutePath);
            }
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
