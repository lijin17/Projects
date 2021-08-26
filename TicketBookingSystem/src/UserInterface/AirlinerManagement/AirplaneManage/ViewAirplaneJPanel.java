/*
 * CreateProductJPanel.java
 *
 * Created on September 18, 2008, 2:54 PM
 */
package UserInterface.AirlinerManagement.AirplaneManage;

import UserInterface.AirlinerManagement.Airfleetmanage.*;
import Business.Airliner;
import Business.Airplane;
import Business.Fleet;
import UserInterface.AirlinerManagement.ManageAirlinerJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rushabh
 */
public class ViewAirplaneJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Airplane airplane;
   
    
    
    /** Creates new form CreateProductJPanel */
    public ViewAirplaneJPanel(JPanel upc, Airplane air) {
        initComponents();
        userProcessContainer = upc;
        airplane = air;
        String s=String.valueOf(air.getPlaneNum());
        nameField.setText(air.getPlaneName());
        airplanenumber.setText(s);
        airplanetype.setText(air.getPlaneType());
        whichfleet.setText(air.getWhichFleet());
    }

    
    public static String convertInteger(int i) {
        return Integer.toString(i);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fleetname = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        whichairliner = new javax.swing.JLabel();
        airplanetype = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        airplanenumber = new javax.swing.JTextField();
        fleetnum = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        whichairliner1 = new javax.swing.JLabel();
        whichfleet = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Airplane Detail");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 25, -1, -1));

        fleetname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fleetname.setText("Airplane Name:");
        add(fleetname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        nameField.setEditable(false);
        nameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 159, -1));

        whichairliner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whichairliner.setText("AirplaneType:");
        add(whichairliner, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 30));

        airplanetype.setEditable(false);
        airplanetype.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        airplanetype.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(airplanetype, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 159, -1));

        createButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        createButton.setText("Update Product");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });
        add(createButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 176, -1));

        backButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        airplanenumber.setEditable(false);
        airplanenumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        airplanenumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(airplanenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 159, -1));

        fleetnum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fleetnum.setText("Airplane Number:");
        add(fleetnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 30));

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 70, 30));

        whichairliner1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whichairliner1.setText("whichFleet:");
        add(whichairliner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        whichfleet.setEditable(false);
        whichfleet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whichfleet.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(whichfleet, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 159, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
       nameField.setEditable(true);
       airplanetype.setEditable(true);
       airplanenumber.setEditable(true);
       whichfleet.setEditable(false);
       saveButton.setEnabled(true);
}//GEN-LAST:event_createButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
      backAction();
    }//GEN-LAST:event_backButton1ActionPerformed

      private void backAction() {
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageAirplaneJPanelPart manageProductCatalogJPanel = (ManageAirplaneJPanelPart) component;
        manageProductCatalogJPanel.refreshTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:\
        try{
            int s=Integer.parseInt(airplanenumber.getText());
            airplane.setPlaneName(nameField.getText());
            airplane.setPlaneNum(s);
            airplane.setPlaneType(airplanetype.getText());
            airplane.setWhichFleet(whichfleet.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Wrong type!");
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airplanenumber;
    private javax.swing.JTextField airplanetype;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel fleetname;
    private javax.swing.JLabel fleetnum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel whichairliner;
    private javax.swing.JLabel whichairliner1;
    private javax.swing.JTextField whichfleet;
    // End of variables declaration//GEN-END:variables
}
