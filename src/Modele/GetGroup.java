/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import Vue.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

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
               // System.out.println(Line);
               // System.out.println(  Integer.parseInt(group[0])+"->>>"+group[1]);
                 
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

    public void recordNewGroup(JTextField jTextField) {
        try {
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
                mybuffer.close();
                myFileReader.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            
            
            FileWriter myFileWriter;// for the group.csv file
            FileWriter myFileWriterTwo;// for the groupcontact.csv file
            BufferedWriter myBufferedWriter;// for the group.csv file
            BufferedWriter myBufferedWriterTwo;// groupcontact.csv file
            
            
            myFileWriter=new FileWriter("group.csv",true);
            myBufferedWriter=new BufferedWriter(myFileWriter);
            
            myFileWriterTwo=new FileWriter("groupcontact.csv",true);
            myBufferedWriterTwo=new BufferedWriter(myFileWriterTwo);
            
            
          
            
            
            int newGroupId=myGroup.get(myGroup.size()-1).getNumeroGroup()+1;
            
            String toAdd=newGroupId + ";" + jTextField.getText();// in the Csv file
            String toAddTwo=newGroupId +";;";
            
            myBufferedWriter.newLine();
            myBufferedWriter.write(toAdd);
            myBufferedWriter.flush();
            myBufferedWriter.close();
            myFileWriter.close();
            myBufferedWriterTwo.newLine();
            myBufferedWriterTwo.write(toAddTwo);
            myBufferedWriterTwo.flush();
            
            myBufferedWriterTwo.close();
            myFileWriterTwo.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * this fonction erase the Group from the list
     * @param nameOfGroupToDel
     * @param text 
     */
    public void deleteGroup(String nameOfGroupToDel,Window w) {
        try {
            // delete the group from the list
            // then rewrite the list in the file
            
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
                    // System.out.println(Line);
                    // System.out.println(  Integer.parseInt(group[0])+"->>>"+group[1]);
                    
                    Group newGroup=new Group(Integer.parseInt(group[0]),group[1]);
                    
                    
                    myGroup.add(newGroup);
                    
                    
                }
                myFileReader.close();
                mybuffer.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i=0;i<myGroup.size();i++){
                
                
                if(myGroup.get(i).getNamegroup().equals(nameOfGroupToDel)){
                    
                    myGroup.remove(i);
                    
                }
            }
            
            w.setMyListOfGroup(myGroup);
            // then we write the lis
            
            
            FileWriter myFileWriter;
            BufferedWriter myBufferedWriter;
            
            myFileWriter=new FileWriter("group.csv");
            myBufferedWriter=new BufferedWriter(myFileWriter);
            
            String toWrite="0;All";
            myBufferedWriter.write(toWrite);
            myBufferedWriter.flush();
            
            
            for(int i=1;i<myGroup.size();i++){
               myBufferedWriter.newLine();
                toWrite= i +";"+myGroup.get(i).getNamegroup();
                myBufferedWriter.write(toWrite);
                myBufferedWriter.flush();
             
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        
        
       
       
       
        
    }
    
    public int getNumberFromName(String nameOfGroup){
        int retur=0;
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
               
                 if(group[1].equals(nameOfGroup)){
                     
                     return Integer.parseInt(group[0]);
                 }
               
             }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetGroup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
    
    
    
}
