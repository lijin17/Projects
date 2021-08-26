/*
 * ManageProductCatalogJPanel.java
 *
 * Created on September 24, 2008, 2:40 PM
 */
package UserInterface.AirlinerManagement.AirplaneManage;

import UserInterface.AirlinerManagement.Airfleetmanage.*;
import Business.Airplane;
import Business.Airliner;
import Business.AirlinerDirectory;
import Business.AirplaneDirectory;
import Business.Customer;
import Business.CustomerDirectory;
import Business.Fleet;
import Business.FleetDirectory;
import Business.Flight;
import Business.FlightDirectory;
import UserInterface.AirlinerManagement.AirFlightManage.ManageFlightJPanelPart;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Rushabh
 */
public class ManageAirplaneJPanelPart extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Airliner airliner;
    Fleet fleet;
    FleetDirectory fleetDirectory;
    Airplane airplane;
    AirplaneDirectory airplaneDirectory;
    Flight flight;
    FlightDirectory flightDirectory;
    Customer customer;
    CustomerDirectory customerDirectory;
    String s;
    ArrayList<Fleet> fl;
    ArrayList<Airplane> ai;

    /** Creates new form ManageProductCatalogJPanel */
    public ManageAirplaneJPanelPart(JPanel upc, Airliner p, FleetDirectory fleetDirectory,Airplane airplane,AirplaneDirectory airplaneDirectory,Flight flight,FlightDirectory flightDirectory,Customer customer,CustomerDirectory customerDirectory,String s) {
        initComponents();
        userProcessContainer = upc;
        airliner = p;
        this.fleetDirectory=fleetDirectory;
        this.s=s;
        this.airplane=airplane;
        this.airplaneDirectory=airplaneDirectory;
        this.flight=flight;
        this.flightDirectory=flightDirectory;
        this.customer=customer;
        this.customerDirectory=customerDirectory;
        //nametxt.setText(airliner.getAirlinerName());
        ai=classify();
        if(s.equals("-1")){
            refreshTable();
        }else{
            refreshTable(ai);
        }
        
    }
     public ArrayList<Airplane> classify(){
        ArrayList<Airplane> reList=new ArrayList<Airplane>();
        String value=s;
        reList=airplaneDirectory.searchAirplane(value);
        return reList;
    }
    public void refreshTable(ArrayList<Airplane> ai) {
        int rowCount = airlinerCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel)airlinerCatalog.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        
        for(Airplane p : ai) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getPlaneNum();
            row[2] = p.getPlaneType();
            row[3] = p.getWhichFleet();
            model.addRow(row);
            }
        }
    
    public void refreshTable() {
        int rowCount = airlinerCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel)airlinerCatalog.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        
        for(Airplane p : airplaneDirectory.getairplaneDirectory()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getPlaneNum();
            row[2] = p.getPlaneType();
            row[3] = p.getWhichFleet();
            model.addRow(row);
            }
        }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        airlinerCatalog = new javax.swing.JTable();
        viewPButton = new javax.swing.JButton();
        createPButton = new javax.swing.JButton();
        backButton4 = new javax.swing.JButton();
        delButton5 = new javax.swing.JButton();
        viewflightButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Airplane Directory");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        airlinerCatalog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        airlinerCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "AirlaneName", "AirplaneNum", "AirplaneType", "whichFleet"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(airlinerCatalog);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 500, 170));

        viewPButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewPButton.setText("View Airplane Detail >>");
        viewPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPButtonActionPerformed(evt);
            }
        });
        add(viewPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 220, -1));

        createPButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createPButton.setText("Create New Airplane >>");
        createPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPButtonActionPerformed(evt);
            }
        });
        add(createPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        backButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton4.setText("<< Back");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton4ActionPerformed(evt);
            }
        });
        add(backButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 110, -1));

        delButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delButton5.setText("Delete Airplane");
        delButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButton5ActionPerformed(evt);
            }
        });
        add(delButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 190, -1));

        viewflightButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewflightButton2.setText("View Flights >>");
        viewflightButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewflightButton2ActionPerformed(evt);
            }
        });
        add(viewflightButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 170, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void viewPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPButtonActionPerformed
        // TODO add your handling code here:
        int row = airlinerCatalog.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
             return;
        }
        Airplane air = (Airplane)airlinerCatalog.getValueAt(row, 0);
        ViewAirplaneJPanel vpdjp = new ViewAirplaneJPanel(userProcessContainer, air);
        userProcessContainer.add("ViewAirplaneJPanel", vpdjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_viewPButtonActionPerformed

    private void createPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPButtonActionPerformed
        CreateNewAirplaneJPanel cnjp = new CreateNewAirplaneJPanel(userProcessContainer,fleetDirectory,airplaneDirectory);
        userProcessContainer.add("CreateNewFleetJPanel",cnjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_createPButtonActionPerformed

    private void backButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton4ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButton4ActionPerformed

    private void delButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButton5ActionPerformed
        // TODO add your handling code here:
        int row = airlinerCatalog.getSelectedRow();
        if(row<0) {
             JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Airplane air = (Airplane)airlinerCatalog.getValueAt(row, 0);
        airplane.getAirplaneDirectory().removeAirplane(air);
        refreshTable(ai);
    }//GEN-LAST:event_delButton5ActionPerformed

    private void viewflightButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewflightButton2ActionPerformed
        // TODO add your handling code here:
        int row = airlinerCatalog.getSelectedRow();       
        Airliner p = null;//(Airliner)airlinerCatalog.getValueAt(row, 1); 
        String s=String.valueOf(airlinerCatalog.getValueAt(row, 0));
        System.out.println(s);
        ManageFlightJPanelPart mf = new ManageFlightJPanelPart(userProcessContainer,p ,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,customer,customerDirectory,s);
        userProcessContainer.add("ManageFlightJPanelPart", mf);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_viewflightButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable airlinerCatalog;
    private javax.swing.JButton backButton4;
    private javax.swing.JButton createPButton;
    private javax.swing.JButton delButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewPButton;
    private javax.swing.JButton viewflightButton2;
    // End of variables declaration//GEN-END:variables
}
