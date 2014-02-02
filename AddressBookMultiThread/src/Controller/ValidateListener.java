/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;


import Modele.Contact;
import Modele.FileManipulation;
import Vue.Window;
//import Vue.SeeForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *The Listener Assocated to the Validate Button in the Form
 * @author Bakalian
 */
public class ValidateListener implements ActionListener,WindowListener {
    
    private FileManipulation makeOperations;
    private Contact myContact;
    private int mode;// mode créer ou updater
    private JTextField FirstName;
    private JTextField LastName;
    private JTextField HomeAddress;
    private JTextField CompanyAddress;
    private JTextField PersonalPhone;
    private JTextField ProfessionalPhone;
    private JTextField HomePage;
    private JTextField Email;
    private JTextField Photo;
    private JTextField Age;
    private JFrame winow;
    private Window myRootWindow;
/**
 * 
     * @param w
     * @param fr
 * @param myContact the New Contact sent by MenuOperation we have to fill 
 * @param mode unused
 * @param FirstName JtextField containing the Name
 * @param LastName JtextField containing ""
 * @param HomeAddress JtextField containing ""
 * @param CompanyAddress JtextField containing ""
 * @param PersonalPhone JtextField containing ""
 * @param ProfessionalPhone JtextField containing  ""
 * @param HomePage JtextField containing ""
 * @param Email JtextField containing ""
 * @param Photo JtextField containing ""
 * @param Age  JtextField containing ""
 */
    public ValidateListener(Window w,JFrame fr,Contact myContact, int mode, JTextField FirstName, JTextField  LastName, JTextField  HomeAddress, JTextField  CompanyAddress, JTextField  PersonalPhone, JTextField  ProfessionalPhone, JTextField  HomePage, JTextField  Email, JTextField  Photo, JTextField  Age) {
        this.myContact = myContact;
        this.mode = mode;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.HomeAddress = HomeAddress;
        this.CompanyAddress = CompanyAddress;
        this.PersonalPhone = PersonalPhone;
        this.ProfessionalPhone = ProfessionalPhone;
        this.HomePage = HomePage;
        this.Email = Email;
        this.Photo = Photo;
        this.Age = Age;
        this.winow=fr;
        makeOperations=new FileManipulation();
        this.myRootWindow=w;
       
    }
    
    
  
/**
 * We Fill each field of the New Contact with The JTextField informations
 * then send it to FileManipulation-> Record() Action
 * @param e 
 */
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(mode==0){ // if mode == 0 we create contact
        myContact.setCompanyAddress(this.CompanyAddress.getText());
        myContact.setEmail(this.Email.getText());
        myContact.setFirstName(this.FirstName.getText());
        myContact.setHomeAddress(this.HomeAddress.getText());
        myContact.setHomePage(this.HomePage.getText());
        myContact.setLastName(this.LastName.getText());
        myContact.setPersonalPhone(this.PersonalPhone.getText());
        myContact.setPhoto(this.Photo.getText());
        myContact.setProfessionalPhone(this.ProfessionalPhone.getText());
        myContact.setAge(this.Age.getText());
     //   myContact.setIdNumber(String.valueOf(myRootWindow.getMyContactPanel().getIdNumber()));
     
            try {
                makeOperations.recordContact(myContact);// save the contact
            } catch (IOException ex) {
                Logger.getLogger(ValidateListener.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        FirstName.setText("prenom");
        LastName.setText(" Nom");
        HomeAddress.setText(" addresse privee");
        CompanyAddress.setText(" addresse professionelle");
        PersonalPhone.setText("telephone personnel");
        ProfessionalPhone.setText(" telephone privee");;
        HomePage.setText("site web");;
        Email.setText(" addresse Mail");;
        Photo.setText(" lien vers photo");;
        Age.setText(" votre age");
       }   
    winow.dispose();
    
    
    GroupListenerThread groupLT=new GroupListenerThread(this.myRootWindow.getMyContactPanel(),this.myRootWindow.getMyViewContactPanel(),this.myRootWindow,null);
        Thread thread = new Thread(groupLT);
        thread.start();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
