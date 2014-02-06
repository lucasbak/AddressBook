/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Modele.Contact;
import Vue.Form;
import Vue.Window;

/**
 *
 * @author Bakalian
 */
public class AddContactListenerThread implements Runnable{
    
       private final Window myRootWindow;

public AddContactListenerThread(Window w){
    myRootWindow=w;
}

    @Override
    public void run() {
        Contact myContact =new Contact();
        Form myForm=new Form(myRootWindow,myContact,0);
    }
    
}
