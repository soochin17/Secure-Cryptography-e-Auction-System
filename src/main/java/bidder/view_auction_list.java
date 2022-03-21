package bidder;

import auctioneer.auction;
import home.*;
import java.awt.Color;
import java.awt.Font;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import login_register.DBconnection;
import login_register.login_Bidder;
import validation.auction_validate;

public class view_auction_list extends javax.swing.JFrame {
    public static int auctionID_keyedIn;
    public static int floorprice;
    private String bidderName;
    
    public view_auction_list() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }
    
    public static ArrayList<auction> getAuction(){
        ArrayList<auction> auctions = new ArrayList<auction>();
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        auction a;
        
        /* need to filter out only status=1 can be displayed*/
        String qr = "SELECT * FROM auction WHERE `status`=1";
        try {
            ps = con.prepareStatement(qr);
            rs = ps.executeQuery();
            
            while(rs.next()){
                a = new auction(rs.getInt("auctionID"),
                                rs.getString("product_name"),
                                rs.getTimestamp("endtime"));
                auctions.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(view_auction_list.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
                if(con != null){
                    try{
                        con.close();
                    } catch (SQLException e){
                        /* Ignored */
                    }
                }
            }

        return auctions;
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        back_to_panel_Bidder = new javax.swing.JButton();
        auctionID = new javax.swing.JTextField();
        go_to_auction_details = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        show_username = new javax.swing.JLabel("username",SwingConstants.RIGHT);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(240, 240, 175));
        jPanel2.setMinimumSize(new java.awt.Dimension(910, 530));
        jPanel2.setPreferredSize(new java.awt.Dimension(910, 530));
        jPanel2.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[3];
        columnsName[0] = "Auction ID";
        columnsName[1] = "Product Name";
        columnsName[2] = "Auction Endtime";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[4];
        for(int i=0; i<getAuction().size(); i++){
            rowData[0] = getAuction().get(i).getAuctionID();
            rowData[1] = getAuction().get(i).getProductName();
            rowData[2] = getAuction().get(i).getEndTime();

            model.addRow(rowData);
        }
        table.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        table.setModel(model);
        table.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        table.setModel(model);

        table.setRowHeight(25);

        table.setRowSelectionAllowed(false);

        table.setSelectionBackground(new Color(203, 240, 237));

        table.setShowHorizontalLines(false);

        table.setSurrendersFocusOnKeystroke(true);

        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("Lato", Font.BOLD, 16));
        table.setRowHeight(25);
        table.setSelectionBackground(new java.awt.Color(203, 240, 237));
        table.setShowHorizontalLines(false);
        table.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(table);
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(52);
        colModel.getColumn(1).setPreferredWidth(250);
        colModel.getColumn(2).setPreferredWidth(150);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        colModel.getColumn(0).setCellRenderer(centerRenderer);
        colModel.getColumn(1).setCellRenderer(centerRenderer);
        colModel.getColumn(2).setCellRenderer(centerRenderer);

        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(125, 90, 660, 330);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        back_to_panel_Bidder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back button.png"))); // NOI18N
        back_to_panel_Bidder.setBorderPainted(false);
        back_to_panel_Bidder.setContentAreaFilled(false);
        back_to_panel_Bidder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_to_panel_Bidder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_panel_BidderActionPerformed(evt);
            }
        });
        jPanel2.add(back_to_panel_Bidder);
        back_to_panel_Bidder.setBounds(60, 445, 130, 50);
        jPanel2.add(auctionID);
        auctionID.setBounds(658, 450, 126, 40);

        go_to_auction_details.setIcon(new javax.swing.ImageIcon(getClass().getResource("/go button.png"))); // NOI18N
        go_to_auction_details.setBorderPainted(false);
        go_to_auction_details.setContentAreaFilled(false);
        go_to_auction_details.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_auction_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_auction_detailsActionPerformed(evt);
            }
        });
        jPanel2.add(go_to_auction_details);
        go_to_auction_details.setBounds(800, 445, 70, 50);

        jLabel3.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bidder Panel - View Ongoing Auctions");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 10, 460, 60);

        jLabel7.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter Auction ID:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(500, 445, 160, 50);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/small logo.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 10, 50, 60);

        close.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("x");
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel2.add(close);
        close.setBounds(860, 0, 53, 40);

        show_username.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        show_username.setForeground(new java.awt.Color(255, 255, 255));
        show_username.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(show_username);
        show_username.setBounds(700, 10, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-list-bg.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 910, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_to_panel_BidderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_panel_BidderActionPerformed
        panel_Bidder pB = new panel_Bidder();
        pB.setVisible(true);
        pB.pack();
        pB.setLocationRelativeTo(null);
        bidderName = login_Bidder.username;
        pB.show_username.setText("User:  " + bidderName);
        pB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_back_to_panel_BidderActionPerformed

    private void go_to_auction_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_auction_detailsActionPerformed
        try {
            auction_validate av = new auction_validate();
            av.update_auction_status();
            av.check_and_update_auctioneer_eligibility();
            
            // check auctionID that haven't determine winner
            int[] pending_aucID = av.check_pending_closedAuction();
            
            // if have pending_auctionID
            if(pending_aucID != null){
                av.bid_opening(pending_aucID);     
            }
            else{
                /* Ignored */
            }

            Connection con = DBconnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            auctionID_keyedIn = Integer.parseInt(auctionID.getText());
            String qr = "SELECT `product_name`, `product_desc`, `floor_price`, `status` FROM auction WHERE `auctionID`=?";

            try {
                ps = con.prepareStatement(qr);
                ps.setInt(1, auctionID_keyedIn);
                rs = ps.executeQuery();

                if(rs.next()){
                    String productname = rs.getString("product_name");
                    String productdesc = rs.getString("product_desc");
                    floorprice = rs.getInt("floor_price");
                    int status = rs.getInt("status");

                    //set details in textfields
                    if(status == 1){
                        auction_details ad = new auction_details();
                        ad.setVisible(true);
                        ad.pack();
                        ad.setLocationRelativeTo(null);
                        ad.show_auctionID.setText(Integer.toString(auctionID_keyedIn));
                        ad.show_product_name.setText(productname);
                        ad.show_product_desc.setText(productdesc);
                        ad.show_floor_price.setText(Integer.toString(floorprice));
                        bidderName = login_Bidder.username;
                        ad.show_username.setText("User:  " + bidderName);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Auction is invalid or has been closed", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null, "Please enter a valid auctionID", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(view_auction_list.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                    if(con != null){
                        try{
                            con.close();
                        } catch (SQLException e){
                            /* Ignored */
                        }
                    }
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_go_to_auction_detailsActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_auction_list().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField auctionID;
    private javax.swing.JButton back_to_panel_Bidder;
    private javax.swing.JButton close;
    private javax.swing.JButton go_to_auction_details;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel show_username;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
