/*
 * ProductManagerWorkAreaJPanel.java
 *
 * Created on October 3, 2008, 8:06 AM
 */
package UserInterface.AirlinerManagement;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Airplane;
import Business.AirplaneDirectory;
import Business.Customer;
import Business.CustomerDirectory;
import Business.FleetDirectory;
import Business.Flight;
import Business.FlightDirectory;
import UserInterface.AirlinerManagement.AirFlightManage.ManageFlightJPanelPart;

import UserInterface.AirlinerManagement.Airfleetmanage.ManageFleetJPanelPart;
import UserInterface.AirlinerManagement.AirplaneManage.ManageAirplaneJPanelPart;
import UserInterface.AirlinerManagement.CustomerManage.ManageCustomerJPanelPart;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Rushabh
 */
public class AirlinerChooseJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Airliner airliner;
    AirlinerDirectory airlinerDirectory;
    FleetDirectory fleetDirectory;
    Airplane airplane;
    AirplaneDirectory airplaneDirectory;
    Flight flight;
    FlightDirectory flightDirectory;
    Customer customer;
    CustomerDirectory customerDirectory;
    String s="-1";
//    MasterOrderCatalog masterOrderCatalog;
    
    /** Creates new form ProductManagerWorkAreaJPanel */
    public AirlinerChooseJPanel(JPanel upc, Airliner a,AirlinerDirectory ad,FleetDirectory fleetDirectory,Airplane airplane,AirplaneDirectory airplaneDirectory, Flight flight, FlightDirectory flightDirectory,Customer customer,CustomerDirectory customerDirectory) {

        initComponents();
        userProcessContainer = upc;
        airlinerDirectory=ad;
        this.fleetDirectory=fleetDirectory;
        this.airplane=airplane;
        this.airplaneDirectory=airplaneDirectory;
        this.flightDirectory=flightDirectory;
        this.customer=customer;
        this.customerDirectory=customerDirectory;
        airliner = a;
//      masterOrderCatalog = moc;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        managePButton = new javax.swing.JButton();
        manageairplane = new javax.swing.JButton();
        manageflight = new javax.swing.JButton();
        ManagefleetButton = new javax.swing.JButton();
        manageflight1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Airliner Manager ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        managePButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        managePButton.setText("Manage Airliner Directory ");
        managePButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePButtonActionPerformed(evt);
            }
        });
        add(managePButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        manageairplane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageairplane.setText("Manage Airplane");
        manageairplane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageairplaneActionPerformed(evt);
            }
        });
        add(manageairplane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 230, -1));

        manageflight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageflight.setText("Manage Customer");
        manageflight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageflightActionPerformed(evt);
            }
        });
        add(manageflight, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 230, -1));

        ManagefleetButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ManagefleetButton.setText("Manage Fleet");
        ManagefleetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagefleetButtonActionPerformed(evt);
            }
        });
        add(ManagefleetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 230, -1));

        manageflight1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageflight1.setText("Manage Flight");
        manageflight1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageflight1ActionPerformed(evt);
            }
        });
        add(manageflight1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 230, -1));
    }// </editor-fold>//GEN-END:initComponents
    private void managePButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePButtonActionPerformed
        // TODO add your handling code here:
        ManageAirlinerJPanel majp = new ManageAirlinerJPanel(userProcessContainer, airliner,airlinerDirectory,fleetDirectory,airplaneDirectory,flightDirectory,customer,customerDirectory);
        userProcessContainer.add("ManageAirlinerJPanel",majp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_managePButtonActionPerformed

    private void ManagefleetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagefleetButtonActionPerformed
        // TODO add your handling code here:
        ManageFleetJPanelPart mfjp = new ManageFleetJPanelPart(userProcessContainer, airliner,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,customer,customerDirectory,s);
        userProcessContainer.add("ManageFleetJPanelPart",mfjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ManagefleetButtonActionPerformed

    private void manageairplaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageairplaneActionPerformed
        // TODO add your handling code here:
        ManageAirplaneJPanelPart majp = new ManageAirplaneJPanelPart(userProcessContainer, airliner,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,customer,customerDirectory,s);
        userProcessContainer.add("ManageAirplaneJPanelPart",majp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageairplaneActionPerformed

    private void manageflightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageflightActionPerformed
        // TODO add your handling code here:
        ManageCustomerJPanelPart mfjp = new ManageCustomerJPanelPart(userProcessContainer, airliner,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,customer,customerDirectory,s);
        userProcessContainer.add("ManageCustomerJPanelPart",mfjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageflightActionPerformed

    private void manageflight1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageflight1ActionPerformed
        // TODO add your handling code here:
//JPanel upc, Airliner p, FleetDirectory fleetDirectory,Airplane airplane,AirplaneDirectory airplaneDirectory,Flight flight,FlightDirectory flightDirectory,String s
        ManageFlightJPanelPart mfjp = new ManageFlightJPanelPart(userProcessContainer, airliner,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,customer,customerDirectory,s);
        userProcessContainer.add("ManageFlightJPanelPart",mfjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageflight1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManagefleetButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton managePButton;
    private javax.swing.JButton manageairplane;
    private javax.swing.JButton manageflight;
    private javax.swing.JButton manageflight1;
    // End of variables declaration//GEN-END:variables
}
