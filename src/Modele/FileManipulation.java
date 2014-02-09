/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Often used Class we is the interface for Reading-Writing the Contacts on the Hard Drive in the save.csv File
 * @author Bakalian
 */
public class FileManipulation {
    
private final String path;
private FileReader myFileR;
private FileWriter myFileW;
private String Line;
private HashMap myMap;


    
    

    public FileManipulation() {
        this.path="save.csv";
        this.Line="";
        try {
           myFileR=new FileReader("save.csv");
           myFileW=new FileWriter("save.csv",true); 
      //    myFileD=new FileWriter("/Users/Bakalian/NetBeansProjects/AddressBook/save.csv");
            
           
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    

    
    
   /**
    * this method add the c Contact at the end of the file
    * @param c the contact to record
    * @throws IOException 
    */
    
    public void recordContact(Contact c) throws IOException{
       
           myFileW=new FileWriter("save.csv",true); 
    try {        
       
        BufferedWriter ec=new BufferedWriter(myFileW);
        List<Contact> tmp=getContact();
        int taille=tmp.size();
        int newnumber=Integer.parseInt(tmp.get(taille-1).getIdNumber())+1;
        String towrite=c.getFirstName()+";"+c.getLastName()+";"+c.getHomeAddress()+";"+c.getNotes()
                        +";"+c.getPersonalPhone()+";"+c.getProfessionalPhone()+";"+c.getHomePage()+";"+c.getEmail()+";"+c.getPhoto()+";"+c.getAge()+";"+newnumber ;
   
        ec.newLine();
        ec.write(towrite); // writing in the buffer
        ec.flush(); // need this line in order to send the buffer to  be writen
        ec.close();
       // ecr.write(towrite.getBytes());
      
    } catch (FileNotFoundException ex) {
        Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
    }
     
       
    }
    
    /**
     * this Method Reads the contact from the File
     * and transform it in an Contact ArrayList Manipulable by the software
     * @return 
     */
    
    public List<Contact> getContact(){
        
        List<Contact> myList=new ArrayList<Contact>();
        BufferedReader myBuffer =null;
        
        try {
            
            myBuffer=new BufferedReader(new FileReader("save.csv"));
           
            
          while((Line = myBuffer.readLine()) != null){
                Contact myContact=new Contact();
                String[] contact;
                contact = Line.split(";");
                    
                myContact.setFirstName(contact[0]);
                myContact.setLastName(contact[1]);
                myContact.setHomeAddress(contact[2]);
                myContact.setNotes(contact[3]);
                myContact.setPersonalPhone(contact[4]);
                myContact.setProfessionalPhone(contact[5]);
                myContact.setHomePage(contact[6]);
                myContact.setEmail(contact[7]);
                myContact.setPhoto(contact[8]);
                myContact.setAge(contact[9]);
                myContact.setIdNumber(contact[10]);
                myList.add(myContact);                   

          }
   
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
    }
    
            return myList;
    }
    
    /**
     * this function is very useful we send it a id number of group and it returns us the list with all contact belonging to the group
     * @param grouptoshow
     * @return 
     */
    public List<Contact> getSortedContact(int grouptoshow){
        
       GetGroupContact ggg=new GetGroupContact();
        HashMap<Integer,ArrayList> myGroupContactMap=ggg.read();// on a la list des groupe avec leurs contact respectifs
        GetGroup gg=new GetGroup();
        List<Group> groupList=gg.getGroups(); // on a l'ensemble des groupe
        List<Contact> unSortedListContact=getContact();
        if(grouptoshow==0){ 
            return unSortedListContact;}
        else {
            List<Contact> newSortedListContact=new ArrayList<Contact>();
    //System.out.println("grouptoshow in getSortecontac()" + grouptoshow);
            if(myGroupContactMap.get(grouptoshow)!=null){
                    for(int j=0;j<myGroupContactMap.get(grouptoshow).size();j++){
                     /**
                         * // on parcours l'arraylist de int contenue dans la hasmMap
                      */  
                        int tmp=Integer.parseInt(myGroupContactMap.get(grouptoshow).get(j).toString());
        
                         for(int i=0;i<unSortedListContact.size();i++){
                                int t=Integer.parseInt(unSortedListContact.get(i).getIdNumber());
                                if(t==tmp){
                  
                                    newSortedListContact.add(unSortedListContact.get(i));
                  
                                }
                         }
                   
                
                    }
            }
        
       return newSortedListContact;
        }
        
        
    }
    
    /**
     * this Function is about writing in the file the ArrayList given by parameters by deleting old List rewriting this List
     * @param myContact the ArrayList to record
     */
      public void DeleteContact(List<Contact> myContact){
  
          try {        
             
        BufferedWriter ec=new BufferedWriter(new FileWriter("save.csv"));
        for(int i=0;i<myContact.size();i++){
        
                String towrite=myContact.get(i).getFirstName()+";"+myContact.get(i).getLastName()+";"+myContact.get(i).getHomeAddress()+";"+myContact.get(i).getNotes()
                                +";"+myContact.get(i).getPersonalPhone()+";"+myContact.get(i).getProfessionalPhone()+";"+myContact.get(i).getHomePage()+";"+myContact.get(i).getEmail()+";"+myContact.get(i).getPhoto()+";"+myContact.get(i).getAge()+";"+myContact.get(i).getIdNumber();


                ec.write(towrite); // writing in the buffer
                ec.flush(); // need this line in order to send the buffer to  be writen
                ec.newLine();
        }
       
      
    } catch (FileNotFoundException ex) {
        Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
    }
        
       
    } 
    
}