/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Modele.Contact;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *class with reive a string and give in return a panel with an icon
 * @author Bakalian
 */
public class Miniature {
    private JLabel label;
    private Contact myContact;
    private ImageIcon image;

    public Miniature(String str) {
        image=new ImageIcon(new ImageIcon(str).getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT));
        label=new JLabel(image);
        label.setIcon(image);
        
        
    }

    public JLabel getMyMiniature() {
        return label;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public Contact getMyContact() {
        return myContact;
    }

    public void setMyContact(Contact myContact) {
        this.myContact = myContact;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    
    
}
