/*
 * CreateProductJPanel.java
 *
 * Created on September 18, 2008, 2:54 PM
 */
package UserInterface.AirlinerManagement.CustomerManage;

import UserInterface.AirlinerManagement.Airfleetmanage.*;
import Business.Customer;
import UserInterface.AirlinerManagement.ManageAirlinerJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rushabh
 */
public class ViewCustomerJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Customer customer;
   
    
    
    /** Creates new form CreateProductJPanel */
    public ViewCustomerJPanel(JPanel upc, Customer cus) {
        initComponents();
        userProcessContainer = upc;
        customer = cus;
        nameField.setText(cus.getName());
        String s=String.valueOf(cus.getIDNum());
        IDnumber.setText(s);
        age.setText(String.valueOf(cus.getAge()));
        whichFlight.setText(cus.getWhichFlight());
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
        age = new javax.swing.JTextField();
        createButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        IDnumber = new javax.swing.JTextField();
        IDnum = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        fleetname1 = new javax.swing.JLabel();
        whichFlight = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("View Customer Detail");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 25, -1, -1));

        fleetname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fleetname.setText("Customer Name:");
        add(fleetname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        nameField.setEditable(false);
        nameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 159, -1));

        whichairliner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whichairliner.setText("Age:");
        add(whichairliner, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 30));

        age.setEditable(false);
        age.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        age.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 159, -1));

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

        IDnumber.setEditable(false);
        IDnumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IDnumber.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(IDnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 159, -1));

        IDnum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        IDnum.setText("ID Number:");
        add(IDnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 30));

        saveButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveButton.setText("SAVE");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 70, 30));

        fleetname1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fleetname1.setText("whichFlight");
        add(fleetname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 30));

        whichFlight.setEditable(false);
        whichFlight.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whichFlight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(whichFlight, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 159, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
       nameField.setEditable(true);
       age.setEditable(true);
       IDnumber.setEditable(true);
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
        ManageCustomerJPanelPart manageProductCatalogJPanel = (ManageCustomerJPanelPart) component;
        manageProductCatalogJPanel.refreshTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:\
        try{
        customer.setName(nameField.getText());
        int s = Integer.parseInt(age.getText());
        customer.setAge(s);
        Long l= Long.parseLong(IDnumber.getText());
        customer.setIDNum(l);
        customer.setWhichFlight(whichFlight.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Wrong type!");
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDnum;
    private javax.swing.JTextField IDnumber;
    private javax.swing.JTextField age;
    private javax.swing.JButton backButton1;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel fleetname;
    private javax.swing.JLabel fleetname1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField whichFlight;
    private javax.swing.JLabel whichairliner;
    // End of variables declaration//GEN-END:variables
}
