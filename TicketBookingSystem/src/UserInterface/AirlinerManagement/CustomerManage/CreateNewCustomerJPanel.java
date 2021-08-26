/*
 * CreateProductJPanel.java
 *
 * Created on September 18, 2008, 2:54 PM
 */
package UserInterface.AirlinerManagement.CustomerManage;

import UserInterface.AirlinerManagement.Airfleetmanage.*;;
import Business.Airplane;
import Business.Airliner;
import Business.Customer;
import Business.CustomerDirectory;
import Business.Fleet;
import Business.FleetDirectory;
import UserInterface.TravelAgencyManagement.ManageAirliners;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author Rushabh
 */
public class CreateNewCustomerJPanel extends javax.swing.JPanel {

    FleetDirectory fleetDirectory;
    JPanel userProcessContainer;
    CustomerDirectory customerDirectory;
    
    /** Creates new form CreateProductJPanel */
    public CreateNewCustomerJPanel(JPanel userProcessContainer, FleetDirectory fleetDirectory, CustomerDirectory customerDirectory){
        initComponents();
        this.fleetDirectory=fleetDirectory;
        this.userProcessContainer = userProcessContainer;
        this.customerDirectory=customerDirectory;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fleetNum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        ADDButton = new javax.swing.JButton();
        backButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nameField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        whichair1 = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Create New Customer");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("IDNum:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 100, 30));

        fleetNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(fleetNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 210, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Age:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 180, 40, 30));

        age.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 210, 30));

        ADDButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ADDButton.setText("Add Customer");
        ADDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDButtonActionPerformed(evt);
            }
        });
        add(ADDButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 301, -1, 30));

        backButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton1.setText("<< Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });
        add(backButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Customer Name:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 30));

        nameField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(nameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 210, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("whichFlight:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 120, 30));

        whichair1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(whichair1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 210, 30));
    }// </editor-fold>//GEN-END:initComponents
    private void ADDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDButtonActionPerformed
    // TODO add your handling code here:
        Customer customer = customerDirectory.addCustomer();
        try{
        customer.setName(nameField1.getText());
        customer.setIDNum(Long.parseLong(fleetNum.getText()));
        customer.setAge(Integer.parseInt(age.getText()));
        customer.setWhichFlight(whichair1.getText());
        JOptionPane.showMessageDialog(null, "Customer successfully added", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Wrong type!", "Warning", JOptionPane.INFORMATION_MESSAGE);
            customerDirectory.removeCustomer(customer);
        }
        
}//GEN-LAST:event_ADDButtonActionPerformed
  private void backAction() {
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageCustomerJPanelPart ManageCustomerJPanelPart = (ManageCustomerJPanelPart) component;
        ManageCustomerJPanelPart.refreshTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        // TODO add your handling code here:
        backAction();
    }//GEN-LAST:event_backButton1ActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADDButton;
    private javax.swing.JTextField age;
    private javax.swing.JButton backButton1;
    private javax.swing.JTextField fleetNum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameField1;
    private javax.swing.JTextField whichair1;
    // End of variables declaration//GEN-END:variables
}
