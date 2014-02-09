/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

//import Controller.HomePageLauncher;
//import Controller.MailPageLauncher;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 * This Class is a model created in order to represents the data part of the JTable
 * receive the raw data ( ArrayList ) and add it to the Model to make it usable by the Jtable
 * @author Bakalian
 */
public class TableModelContact extends AbstractTableModel {
    private final List<Contact> ContactList;
 
    private static final String[] head =  {"First Name"};//,"Last Name"};

   
 
    public TableModelContact(List<Contact> c) {
        super();
        this.ContactList = c;
      
        
    }
     /**
      * as row as the ArrayList Size
      * @return 
      */
 
    @Override
    public int getRowCount() {
        return ContactList.size();
    }
    /**
     * ad Column as the number of title of column given
     * @return 
     */
    @Override
    public int getColumnCount() {
        
        return head.length;
    }
  /**
   * geting it from the title array written below
   * @param columnIndex
   * @return 
   */
    @Override
    public String getColumnName(int columnIndex) {
        return head[columnIndex];
    }
  /**
   * get the value to write in the cell according to the data
   * @param rowIndex
   * @param columnIndex
   * @return 
   */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
             
               return ContactList.get(rowIndex).getFirstName();
            case 1:
                return ContactList.get(rowIndex).getLastName();
            
            default:
                return null; //Ne devrait jamais arriver
        }
    }
 
  
  /**
   * called when we click on supprimer in order to refresh table after deleting rows
   * @param rowIndex 
   */
    public void removeContact(int rowIndex) {
       // ContactList.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }
 
 /**
  * new value to show after editing cells
  * @param aValue
  * @param rowIndex
  * @param columnIndex 
  */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){

                
             switch(columnIndex){
                case 0:
                     ContactList.get(rowIndex).setFirstName((String)aValue);
                    break;
                case 1:
                     ContactList.get(rowIndex).setLastName((String)aValue);
                    break;
                
               
             }
       }
        
    }

    public List<Contact> getContactList() {
        return ContactList;
    }


}
