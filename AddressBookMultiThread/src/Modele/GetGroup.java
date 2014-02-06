/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *class which will read in the harddrive and load the group then creates an ArrayList
 * @author Bakalian
 */
public  class GetGroup {
 
    private List<Group> myGroup;
    
    
    
    
    public List<Group> getGroups(){
        FileReader myFileReader;
        BufferedReader mybuffer;
        String Line;
        String[] group;
        myGroup=new ArrayList<Group>();
        try {
            myFileReader = new FileReader("group.csv");
            mybuffer=new BufferedReader(myFileReader);
             while((Line = mybuffer.readLine()) != null){
                 group=Line.split(";");
               //  System.out.println(Line);
                //System.out.println(  Integer.parseInt(group[0])+"->>>"+group[1]);
                 
               Group newGroup=new Group(Integer.parseInt(group[0]),group[1]);
                 

                 myGroup.add(newGroup);
             }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return myGroup;
    }
    
    
    
}
