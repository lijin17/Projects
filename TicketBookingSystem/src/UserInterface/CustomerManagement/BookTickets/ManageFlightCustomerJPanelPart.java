/*
 * ManageProductCatalogJPanel.java
 *
 * Created on September 24, 2008, 2:40 PM
 */
package UserInterface.CustomerManagement.BookTickets;
import Business.BookedDirect;
import Business.Airplane;
import Business.Airliner;
import Business.AirlinerDirectory;
import Business.AirplaneDirectory;
import Business.Booked;
import Business.Customer;
import Business.CustomerDirectory;
import Business.Fleet;
import Business.FleetDirectory;
import Business.Flight;
import Business.FlightDirectory;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Rushabh
 */
public class ManageFlightCustomerJPanelPart extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Airliner airliner;
    AirlinerDirectory airlinerDirectory;
    Fleet fleet;
    FleetDirectory fleetDirectory;
    Flight flight;
    FlightDirectory flightDirectory;
    Airplane airplane;
    AirplaneDirectory airplaneDirectory;
    Customer customer;
    CustomerDirectory customerDirectory;
    String s;
    ArrayList<Flight> fli;
    Booked booked;
    BookedDirect bookedDirect;

    /** Creates new form ManageProductCatalogJPanel */
    
//    userProcessContainer,p ,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,s
    public ManageFlightCustomerJPanelPart(JPanel upc, Airliner p,AirlinerDirectory airlinerDirectory,Fleet fleet, FleetDirectory fleetDirectory,Airplane airplane,AirplaneDirectory airplaneDirectory,Flight flight,FlightDirectory flightDirectory,Customer customer,CustomerDirectory customerDirectory,BookedDirect bookedDirect,Booked booked) {
        initComponents();
        setSize(550, 550);
        FlightName.setVisible(false);
        userProcessContainer = upc;
        airliner = p;
        this.airlinerDirectory=airlinerDirectory;
        this.fleet=fleet;
        this.fleetDirectory=fleetDirectory;
        this.flight=flight;
        this.flightDirectory=flightDirectory;
        this.airplane=airplane;
        this.airplaneDirectory=airplaneDirectory;
        this.customer=customer;
        this.customerDirectory=customerDirectory;
        this.booked=booked;
        this.bookedDirect=bookedDirect;
        //nametxt.setText(airliner.getAirlinerName());
        refreshTable();
        
    }
    
     public void refreshTable() {
        int rowCount = airlinerCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel)airlinerCatalog.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
            Object row[] = new Object[7];
        try{
            for(Flight p :flightDirectory.getFlightDirectory()) {
            row[0] = p;
            row[1] = p.getTime();
            row[2] = p.getFromLocation();
            row[3] = p.getToLocation();
            row[4] = p.getWhichPlane();
            row[5] =airplaneDirectory.WhichAirplane(p.getWhichPlane()).getWhichFleet();  
            row[6] =fleetDirectory.whichFleet(airplaneDirectory.WhichAirplane(p.getWhichPlane()).getWhichFleet()).getWhichAirliner();
            model.addRow(row);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Your flight information is not complete");
        }
        
            
            
            
        }
     
    public void refreshTable(FlightDirectory fli) {
        FlightDirectory flightDirectory=fli;
        int rowCount = airlinerCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel)airlinerCatalog.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
            Object row[] = new Object[7];
        try{
            for(Flight p :flightDirectory.getFlightDirectory()) {
            row[0] = p;
            row[1] = p.getTime();
            row[2] = p.getFromLocation();
            row[3] = p.getToLocation();
            row[4] = p.getWhichPlane();
            row[5] =airplaneDirectory.WhichAirplane(p.getWhichPlane()).getWhichFleet();  
            row[6] =fleetDirectory.whichFleet(airplaneDirectory.WhichAirplane(p.getWhichPlane()).getWhichFleet()).getWhichAirliner();
            model.addRow(row);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Your flight information is not complet");
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
        backButton4 = new javax.swing.JButton();
        searchPButton1 = new javax.swing.JButton();
        FlightName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        FlightTime = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        FromLocation = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Tolocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        customerid = new javax.swing.JTextField();
        searchPButton2 = new javax.swing.JButton();
        searchPButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Search your flight");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        airlinerCatalog.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        airlinerCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "FlightName", "FlightTime", "FromLocation", "ToLocation", "whichAirplane", "whichFleet", "whichAirliner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(airlinerCatalog);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 830, 170));

        backButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton4.setText("<< Back");
        backButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton4ActionPerformed(evt);
            }
        });
        add(backButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 110, -1));

        searchPButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchPButton1.setText("Resume");
        searchPButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPButton1ActionPerformed(evt);
            }
        });
        add(searchPButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, -1));

        FlightName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlightNameActionPerformed(evt);
            }
        });
        add(FlightName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 100, -1));

        jLabel3.setText("FlightTime:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
        add(FlightTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 100, -1));

        jLabel4.setText("FromLocation:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));
        add(FromLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 100, -1));

        jLabel5.setText("Tolocation:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, -1));
        add(Tolocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 100, -1));

        jLabel6.setText("Please input your CustomerIDnum and book seat:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));
        add(customerid, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 160, -1));

        searchPButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchPButton2.setText("Search");
        searchPButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPButton2ActionPerformed(evt);
            }
        });
        add(searchPButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 90, -1));

        searchPButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchPButton3.setText("BookSeat >>");
        searchPButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPButton3ActionPerformed(evt);
            }
        });
        add(searchPButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, 220, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton4ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButton4ActionPerformed

    private void searchPButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPButton1ActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_searchPButton1ActionPerformed

    private void FlightNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlightNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FlightNameActionPerformed

    private void searchPButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPButton2ActionPerformed
        // TODO add your handling code here:
        FlightDirectory flightd=new FlightDirectory();
        int row=airlinerCatalog.getRowCount();
        if(row==0){
            JOptionPane.showMessageDialog(null, "Cannot do research! The table is empty.");
        }else{ 
          flightd.setFlightDirectory(this.flightDirectory.searchFlightList(FlightName.getText(), FlightTime.getText(), FromLocation.getText(), Tolocation.getText()));
          refreshTable(flightd);
          System.out.print(flightd);
        }        
    }//GEN-LAST:event_searchPButton2ActionPerformed

    private void searchPButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPButton3ActionPerformed
        // TODO add your handling code here:
        try{
        Long customerID=Long.valueOf(customerid.getText());
        if(customerDirectory.searchCustomerId(customerID)==null){
            JOptionPane.showMessageDialog(null, "Your Id is not created");
            return;
        }
        int row = airlinerCatalog.getSelectedRow();
        String s=String.valueOf(airlinerCatalog.getValueAt(row, 0));
        booked.setWhichflight(s);
        Flight flight = (Flight)airlinerCatalog.getValueAt(row, 0);
        System.out.println(s);
        BookSeatJPanel mfjp = new BookSeatJPanel(userProcessContainer, airliner,airlinerDirectory,fleet,fleetDirectory,airplane,airplaneDirectory,flight,flightDirectory,customer,customerDirectory,bookedDirect,booked,s,customerID);
        userProcessContainer.add("CreateCustomerJPanel",mfjp);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Your flight information is not complete");
        }
        
        
    }//GEN-LAST:event_searchPButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FlightName;
    private javax.swing.JTextField FlightTime;
    private javax.swing.JTextField FromLocation;
    private javax.swing.JTextField Tolocation;
    private javax.swing.JTable airlinerCatalog;
    private javax.swing.JButton backButton4;
    private javax.swing.JTextField customerid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchPButton1;
    private javax.swing.JButton searchPButton2;
    private javax.swing.JButton searchPButton3;
    // End of variables declaration//GEN-END:variables
}