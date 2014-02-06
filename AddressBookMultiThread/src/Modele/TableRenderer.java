/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;



/**
 *  The TableRenderer class provides a renderer and an editor that looks like a
  JButton. The renderer  will be used for a specified column
 *  in the table. it's the  TableModel which contains the String to be displayed on
 *  the button.
 *
 
 *
 */
public class TableRenderer implements TableCellRenderer,MouseListener  {    
    
        private JTable myTable=null;
        
   @Override 
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            myTable=table;
           
            //myTable.setBackground(Color.gray);
            JLabel button = new JLabel(value.toString());
            button.setHorizontalAlignment(SwingConstants.LEFT);
            
            JPopupMenu jpopupmenu = new JPopupMenu();
          JMenuItem jmenuitem1 = new JMenuItem("AddToGroup" );
          jpopupmenu.add(jmenuitem1);
          button.setComponentPopupMenu(jpopupmenu);
            //button.setPreferredSize(new Dimension(300,10));
            return button;  
        }

    @Override
    public void mouseClicked(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(e.getSource().equals(myTable)){
                
                   // System.out.println("TEST CLICK DROIT");
                
            }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

        

