/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bakalian
 */
public class GetGroupContact {
    
    private HashMap myGroupContactMap;
    private FileReader fr;
    private BufferedReader bf;
    
    public GetGroupContact(){
        
        
        
        
        
    }
    
    public HashMap read(){
         HashMap<Integer,ArrayList> myGroupContactMap;
         myGroupContactMap=new HashMap<Integer,ArrayList>();
         
         String Line;
         int i=1;
         String [] line;
        try {
            fr=new FileReader("groupcontact.csv");
            bf=new BufferedReader(fr);
            
            while((Line=bf.readLine())!=null){//tant qu'on lit une ligne
               // System.out.println("Ligne de GGG Lu:" +Line);
                line=Line.split(";");// on partage la ligne en tableau de String
                ArrayList<Integer> listofcontact=new ArrayList<>();
                
                
                //System.out.println("nombre de partie dans la ligne lu  " + line.length);
                for(int j=1;j<(line.length);j++){ // pour chaque ligne lu; on ajoute le numéro du groupe et la list des contact y appartenant
                    
                    //System.out.println("partie de la ligne lue:" +line[j]);
                    if(line[j].isEmpty()!=true){// dans la lecture de la ligne on vérifie  si on a bien un contact
                        listofcontact.add(Integer.parseInt(line[j]));    
                        //System.out.println("Contact N° +" + Integer.parseInt(line[j]));
                    }
                
                    myGroupContactMap.put(i, listofcontact);      
                }
               
                i++;
            
              }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GetGroupContact.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GetGroupContact.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
        
        
    
         return myGroupContactMap;
    }
    /**
     * 
     * @param groupname the name of the group to add the contact in
     * @param contact the contact to add ( it's id number)
     * we take the HashMap
     * we go at the index and add the id number of the contact to add
     * we check that that the contact doesn't already exists
     * we record the new HashMap
     */
    public void WriteContactGroup(String groupname,int contact){
        HashMap<Integer,ArrayList> myMap;
        myMap=read();
        boolean contactExists=false;
        GetGroup gg=new GetGroup();
        int group=0;
        List<Group> listofGroup=gg.getGroups();//
        
        
      
        for(int j=0;j<listofGroup.size();j++){
            if(groupname.equals(listofGroup.get(j).getNamegroup())){
                group=listofGroup.get(j).getNumeroGroup();
            }
        }
        
            for(int j=0;j<myMap.get(group).size();j++){
                int idcontact=(int)myMap.get(group).get(j);
                if(contact==idcontact){
                    contactExists=true;  
                }
            }
            if(contactExists==false){
                myMap.get(group).add(contact);
            try {
             FileWriter   fw=new FileWriter("groupcontact.csv");
             BufferedWriter   bf=new BufferedWriter(fw);
            
             for(int i=1;i<=myMap.size();i++){
                 String toWrite=String.valueOf(i)+";";// we create the line to write from the new arraylist in the HashMap
                 for(int j=0;j<myMap.get(i).size();j++){
                 
                 toWrite=toWrite+ myMap.get(i).get(j) +";";
             }
                 System.out.println(toWrite);
                 bf.write(toWrite); // writing in the buffer
                bf.flush(); // need this line in order to send the buffer to  be writen
                bf.newLine();
                         
              }
             
             
             
             
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GetGroupContact.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GetGroupContact.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
                
                
                
                
            }
        
    }
    /**
     * 
     * @param groupname the group to remove the contact from
     * @param contact the correspondant contact to remove
     */
    public void DeleteContactGroup(String groupname,int contact){
         HashMap<Integer,ArrayList> myMap;
        myMap=read();
        
        GetGroup gg=new GetGroup();
        int group=0;
        List<Group> listofGroup=gg.getGroups();//
        
        
      
        for(int j=0;j<listofGroup.size();j++){// we search in thegroup list eh number of the group corresponding to the name
            if(groupname.equals(listofGroup.get(j).getNamegroup())){
                group=listofGroup.get(j).getNumeroGroup();
            }
        }
        
            for(int j=0;j<myMap.get(group).size();j++){
                int idcontact=(int)myMap.get(group).get(j);
                
                if(contact==idcontact){
                    myMap.get(group).remove(j);
                  
                }
            }
            
            try {
             FileWriter   fw=new FileWriter("groupcontact.csv");
             BufferedWriter   bf=new BufferedWriter(fw);
            
             for(int i=1;i<=myMap.size();i++){
                 String toWrite=String.valueOf(i)+";";// we create the line to write from the new arraylist in the HashMap
                 for(int j=0;j<myMap.get(i).size();j++){
                 
                 toWrite=toWrite+ myMap.get(i).get(j) +";";
             }
                 System.out.println(toWrite);
                 bf.write(toWrite); // writing in the buffer
                bf.flush(); // need this line in order to send the buffer to  be writen
                bf.newLine();
                         
              }
             
             
             
             
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GetGroupContact.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GetGroupContact.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
                
                
                
                
            
    }
}
