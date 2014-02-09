/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controller.AccurateViewListener;
import Controller.AddContactListener;
import Controller.AddToGroupListener;
import Controller.DeleteContactListener;
import Controller.EditContactListener;
import Controller.HelpListener;
import Controller.RemoveFromGroupListener;
import Modele.TableRenderer;
import Modele.Contact;
import Modele.TableModelContact;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Bakalian
 */
public class ContactPanel {
    
    private JPanel background;
    private JTable myTable;
    private List<Contact> myList;
    private JScrollPane scrollPane;
    private ViewContactPanel displayPanel;
    private int idNumber;
    private Window myWindow;
    private TableRenderer buttonRenderer;
    
   /**
    * 
    * @param w
    * @param display we need this panel in order to send it to the AccurateView Listener ( MVC patterns compells reidrections)
    */
    public ContactPanel(Window w,ViewContactPanel display) {
        myWindow=w;
        displayPanel=display;
        background=new JPanel();
        this.myList = w.getMyListofContact();
        TableModelContact model=new TableModelContact(myList);// Table Model whic contains our data
        myTable = new JTable(model);// create the Table with the renderer
        TableRowSorter<TableModelContact> sorter = new TableRowSorter<>((TableModelContact) myTable.getModel());
        AccurateViewListener AVL=new AccurateViewListener(myTable,myWindow,display);
       myTable.addMouseListener(AVL);//-----------------to put
        sorter.setSortsOnUpdates(true);
        myTable.setRowSorter(sorter);
         buttonRenderer = new TableRenderer();
         
         
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem menuItemAddToGroup = new JMenuItem("Add to Group");
        JMenuItem menuItemRemoveFromGroup = new JMenuItem("Remove from Group ");
        
        popupMenu.add(menuItemAddToGroup);
        popupMenu.add(menuItemRemoveFromGroup);
       menuItemAddToGroup.addMouseListener(new AddToGroupListener(myWindow));
       menuItemRemoveFromGroup.addMouseListener(new RemoveFromGroupListener(myWindow));
        myTable.setComponentPopupMenu(popupMenu);       
 
   
        myTable.getColumnModel().getColumn(0).setCellRenderer(buttonRenderer);
        myTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        myTable.setRowHeight(40);
        //myTable.getColumnModel().getColumn(1).setCellRenderer(buttonRenderer);
        scrollPane=new JScrollPane(myTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(150,410));
        scrollPane.setAutoscrolls(true);
        //scrollPane.setSize(600, 200);
        myTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        myTable.setAutoscrolls(true);
        myTable.setShowGrid(false);
        myTable.setBackground(new Color(247,247,247));
        myTable.setBorder(null);
        scrollPane.setBorder(createEmptyBorder());
        scrollPane.setBackground(new Color(247,247,247));
        scrollPane.getViewport().setBackground(new Color(247,247,247));
        // now we nedd to add keylistener on the field in the ViewContactPanel 
        // in order to have modification taking in count when the users change the filds
        // the listener need AccurateView Listener to getback the selected Row before recording
       display.getFirstName().addKeyListener(new EditContactListener(myWindow));
        display.getLastName().addKeyListener(new EditContactListener(myWindow));
        display.getAddress().addKeyListener(new EditContactListener(myWindow));
        display.getPhone().addKeyListener(new EditContactListener(myWindow));
        display.getNotes().addKeyListener(new EditContactListener(myWindow));
        display.getEmail().addKeyListener(new EditContactListener(myWindow));
        display.getHomepage().addKeyListener(new EditContactListener(myWindow));
      display.getDelete().addMouseListener(new DeleteContactListener(myWindow));
         
        myTable.setVisible(true);
        background.setLayout(new BorderLayout());
        background.add(scrollPane,BorderLayout.CENTER);
        
        background.add(new JButton("+"),BorderLayout.SOUTH);
        background.getComponent(1).setPreferredSize(new Dimension(50,30));
        background.getComponent(1).addMouseListener(new AddContactListener(myWindow));
    }

    public JPanel getBackground() {
        return background;
    }

    public JTable getMyTable() {
        return myTable;
    }

    public List<Contact> getMyList() {
        return myList;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setBackground(JPanel background) {
        this.background = background;
    }

    public void setMyTable(JTable myTable) {
        this.myTable = myTable;
    }

    public void setMyList(List<Contact> myList) {
        this.myList = myList;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public ViewContactPanel getDisplayPanel() {
        return displayPanel;
    }

    public void setDisplayPanel(ViewContactPanel displayPanel) {
        this.displayPanel = displayPanel;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Window getMyWindow() {
        return myWindow;
    }

    public void setMyWindow(Window myWindow) {
        this.myWindow = myWindow;
    }

    public TableRenderer getButtonRenderer() {
        return buttonRenderer;
    }

    public void setButtonRenderer(TableRenderer buttonRenderer) {
        this.buttonRenderer = buttonRenderer;
    }
    
    
    
    
}
