/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.EditContactListener;
import Controller.HomePageLauncher;
import Controller.ImageChooserListener;
import Controller.MailPageLauncher;
import Modele.Contact;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *This class is about  display in an accurate view , all the detail on the clicked contact
 * @author Bakalian
 */
public class ViewContactPanel {
 
    private JPanel background;
    private JPanel Photo;
    private JTextField  firstName;
    private JTextField  lastName;
    private JTextField  address;
    private JTextField  phone;
    private JTextField  notes;
    
    private Miniature m;
    private JTextField email;
    private JTextField homepage;
    private JScrollPane scrollpanel;
    private JButton delete;
    private Window myWindow;
    private Contact cn;

    /**
     * 
     * @param w the global window , in order to access all of the starting element (contact, group etc..)
     */
    public ViewContactPanel(Window w) {
        myWindow=w;
        cn=myWindow.getMyListofContact().get(0);
        Photo=new JPanel();
        m=new Miniature(cn.getPhoto());
        Photo.add(m.getMyMiniature());
        Photo.addMouseListener(new ImageChooserListener(new JFrame(),null,myWindow));
        this.firstName = new JTextField(cn.getFirstName());
        this.firstName.setName("FirstName");
        this.lastName = new JTextField(cn.getLastName());
        this.lastName.setName("LastName");
        this.address = new JTextField(cn.getHomeAddress());
        this.address.setName("HomeAddress");
        this.notes = new JTextField(cn.getNotes());
        this.notes.setName("Notes");
        this.phone=new JTextField(cn.getPersonalPhone());
        this.phone.setName("PersonalPhone");
        this.email=new JTextField(cn.getEmail());
        this.email.setName("Email");
        this.email.addMouseListener(new MailPageLauncher());
        this.homepage=new JTextField(cn.getHomePage());
        this.homepage.setName("HomePage");
        this.homepage.addMouseListener(new HomePageLauncher(cn.getHomePage()));
        this.delete=new JButton("delete");
        
        scrollpanel=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        background=new JPanel();
        background.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); // on a besoin de ca pour definir les placements 
        c.fill = GridBagConstraints.BOTH;
        c.ipadx=95;
        c.insets= new Insets(5,5,5,5);// defini la marge
        
        // add the photo in the high left corner
        c.gridheight=2;
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=0;
        Photo.setBackground(new Color(247,247,247));
        background.add(Photo,c);
        background.setPreferredSize(new Dimension(300,470));
        scrollpanel.add(background);
        
       
        c.ipadx=1;
        c.gridheight=1;
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridx=0;
        c.gridy=3;
     
        background.add(this.firstName,c);
       
       
        
        
        
        
        c.ipadx=10;
        c.gridheight=1;
        c.gridwidth=GridBagConstraints.REMAINDER;
        c.gridx=0;
        c.gridy=4;
        background.add(this.lastName,c);
        
        
        
        
        c.gridheight=1;
       // c.gridwidth=6;
        c.gridx=0;
        c.gridy=5;
        background.add(this.address,c);
        
        
        
        
        c.gridheight=1;
       // c.gridwidth=6;
        c.gridx=0;
        c.gridy=6;
        background.add(this.phone,c);
        
       
        c.gridheight=1;
        //c.gridwidth=6;
        c.gridx=0;
        c.gridy=7;
        background.add(this.notes,c);
        
         c.gridheight=1;
       // c.gridwidth=6;
        c.gridx=0;
        c.gridy=8;
        background.add(this.email,c);
        
       
        c.gridheight=1;
        //c.gridwidth=6;
        c.gridx=0;
        c.gridy=9;
        background.add(this.homepage,c);
        
         c.gridheight=1;
        //c.gridwidth=6;
        c.gridx=0;
        c.gridy=10;
        background.add(this.delete,c);
        
      
        
    }

    public JScrollPane getScrollpanel() {
        return scrollpanel;
    }

    public void setScrollpanel(JScrollPane scrollpanel) {
        this.scrollpanel = scrollpanel;
    }

    public JPanel getBackground() {
        return background;
    }

    public JPanel getPhoto() {
        return Photo;
    }

    public JTextField getFirstName() {
        return firstName;
    }

    public JTextField getLastName() {
        return lastName;
    }

    public JTextField getAddress() {
        return address;
    }

    public JTextField getPhone() {
        return phone;
    }

    public JTextField getNotes() {
        return notes;
    }

    public Miniature getM() {
        return m;
    }

    public void setBackground(JPanel background) {
        this.background = background;
    }

    public void setPhoto(JPanel Photo) {
        this.Photo = Photo;
    }

    public void setFirstName(JTextField firstName) {
        this.firstName = firstName;
    }

    public void setLastName(JTextField lastName) {
        this.lastName = lastName;
    }

    public void setAddress(JTextField address) {
        this.address = address;
    }

    public void setPhone(JTextField phone) {
        this.phone = phone;
    }

    public void setNotes(JTextField notes) {
        this.notes = notes;
    }

    public void setM(Miniature m) {
        this.m = m;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public JTextField getHomepage() {
        return homepage;
    }

    public void setHomepage(JTextField homepage) {
        this.homepage = homepage;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }
    
    
    
}
