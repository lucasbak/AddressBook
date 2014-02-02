/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.DeletFieldListener;
import Controller.ImageChooserListener;
import Modele.Contact;
import Vue.Window;
import Controller.ValidateListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *permet la création du formulaire avec Swing pour ajouter un nouveau contact
 * @author Bakalian
 */
public final class Form extends JFrame  {
    
    private final JLabel Affichage;
    private final JTextField FirstName;
    private final JTextField LastName;
    private final JTextField HomeAddress;
    private final JTextField CompanyAddress;
    private final JTextField PersonalPhone;
    private final JTextField ProfessionalPhone;
    private final JTextField HomePage;
    private final JTextField Email;
    private final JTextField Photo;
    private final JTextField age;
    private final JButton enregistrer;
    private final JPanel FormBackground;
    private final JPanel Background;
    //private final Menu myMenu;
    private final Contact myContact;
    private final int mode;
    private final Window myRootWindow;
    /**
     * 
     * @param w
     * @param cn the New Contact we want to Fill
     * @param mode 
     */
    public Form(Window w,Contact cn,int mode) {
        myRootWindow=w;
        this.mode=mode;
        Affichage=new JLabel("Veuillez entrer les informations du nouveau contact");
        FirstName=new JTextField(" prenom");
        LastName=new JTextField(" Nom");
        HomeAddress=new JTextField(" addresse privee");
        CompanyAddress=new JTextField(" addresse professionelle");
        PersonalPhone=new JTextField(" telephone personnel");
        ProfessionalPhone=new JTextField("telephone privee");;
        HomePage=new JTextField("site web");;
        Email=new JTextField("addresse Mail");;
        Photo=new JTextField(" lien vers photo");;
        age=new JTextField("votre age");;
        enregistrer=new JButton("validate");
       // myContact=currentContact;
       // myMenu=new Menu();
        
        Background = new JPanel();
        FormBackground=new JPanel();
        myContact=cn;
        //FormBackground.setSize(420,300);
        //Background.setLayout(new BorderLayout());
        //Background.add(myMenu.getMenuBackground(), BorderLayout.NORTH);
        //Background.add(FormBackground, BorderLayout.CENTER);
        
        FormBackground.setLayout(new GridBagLayout());
        FormBackground.setBackground(Color.gray);
        FormBackground.setSize(FormBackground.getLayout().minimumLayoutSize(FormBackground));
        Background.setAutoscrolls(true);
        
        Background.add(FormBackground);
        GridBagConstraints c = new GridBagConstraints(); // on a besoin de ca pour definir les placements 
        c.fill = GridBagConstraints.BOTH;
        c.insets= new Insets(5,5,5,5);// defini la marge 
        
        
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridheight=1;
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=0;
        FormBackground.add(Affichage,c);
        
        c.gridheight=1;
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=1;
        FirstName.addMouseListener(new DeletFieldListener(FirstName));
        FormBackground.add(FirstName,c);
        
        c.gridx=0;
        c.gridy=2;
        LastName.addMouseListener(new DeletFieldListener(LastName));
        FormBackground.add(LastName,c);
        
        c.gridx=0;
        c.gridy=3;
        HomeAddress.addMouseListener(new DeletFieldListener(HomeAddress));
        FormBackground.add(HomeAddress,c);
        
        c.gridx=0;
        c.gridy=4;
        CompanyAddress.addMouseListener(new DeletFieldListener(CompanyAddress));
        FormBackground.add(CompanyAddress,c);
        
        c.gridx=0;
        c.gridy=5;
            age.addMouseListener(new DeletFieldListener(age));
        FormBackground.add(age,c);
        
        
        c.gridx=1;
        c.gridy=1;
        PersonalPhone.addMouseListener(new DeletFieldListener(PersonalPhone));
        FormBackground.add(PersonalPhone,c);
        
        c.gridx=1;
        c.gridy=2;
        ProfessionalPhone.addMouseListener(new DeletFieldListener(ProfessionalPhone));
        FormBackground.add(ProfessionalPhone,c);
        
        c.gridx=1;
        c.gridy=3;
        HomePage.addMouseListener(new DeletFieldListener(HomePage));
        FormBackground.add(HomePage,c);
        
        c.gridx=1;
        c.gridy=4;
        Email.addMouseListener(new DeletFieldListener(Email));
        FormBackground.add(Email,c);
        
        c.gridx=1;
        c.gridy=5;
        Photo.addMouseListener(new DeletFieldListener(Photo));
        Photo.addMouseListener(new ImageChooserListener(this,Photo));
        FormBackground.add(Photo,c);   
        
        c.gridx=1;
        c.gridy=6;
        
        enregistrer.addActionListener(new ValidateListener(myRootWindow,this,cn,mode,getFirstName(),getLastName(),getHomeAddress()
        ,getCompanyAddress()
        ,getPersonalPhone(),
        getProfessionalPhone(),
         getHomePage(),
                getEmail(),
                getPhoto(),
                getAge()
        ));
        FormBackground.add(enregistrer,c);
        
        this.setTitle("New Contact");
        this.setAlwaysOnTop(true);
        this.setLocation(400, 300);
        this.setResizable(false);
        this.setSize(400, 300);
        this.setContentPane(FormBackground);
        this.setVisible(true);
        
        
        
//place de tous les champs
        
        
    }

    public JPanel getFormBackground() {
        return FormBackground;
    }


    public String getFirstNameContent() {
        return FirstName.getText();
    }

    public String getLastNameContent() {
        return LastName.getText();
    }

    public String getHomeAddressContent() {
        return HomeAddress.getText();
    }

    public String getCompanyAddressContent() {
        return CompanyAddress.getText();
    }

    public String getPersonalPhoneContent() {
        return PersonalPhone.getText();
    }

    public String getProfessionalPhoneContent() {
        return ProfessionalPhone.getText();
    }

    public String getHomePageContent() {
        return HomePage.getText();
    }

    public String getEmailContent() {
        return Email.getText();
    }

    public String getPhotoContent() {
        return Photo.getText();
    }

    public String getAgeContent() {
        return age.getText();
    }
    
 /*   public Contact setFieldContact(){
        
        myContact.setFirstName(FirstName.getText());
        myContact.setLastName(LastName.getText());
        myContact.setCompanyAddress(CompanyAddress.getText());
        myContact.setEmail(Email.getText());
        myContact.setHomeAddress(HomeAddress.getText());
        myContact.setHomePage(HomePage.getText());
        myContact.setPersonalPhone(PersonalPhone.getText());
        myContact.setPhoto(Photo.getText());
        myContact.setProfessionalPhone(ProfessionalPhone.getText());
        
        return myContact;
        
    }
   */

    public JTextField getFirstName() {
        return FirstName;
    }

    public JTextField getLastName() {
        return LastName;
    }

    public JTextField getHomeAddress() {
        return HomeAddress;
    }

    public JTextField getCompanyAddress() {
        return CompanyAddress;
    }

    public JTextField getPersonalPhone() {
        return PersonalPhone;
    }

    public JTextField getProfessionalPhone() {
        return ProfessionalPhone;
    }

    public JTextField getHomePage() {
        return HomePage;
    }

    public JTextField getEmail() {
        return Email;
    }

    public JTextField getPhoto() {
        return Photo;
    }

    public JTextField getAge() {
        return age;
    }
    
}
