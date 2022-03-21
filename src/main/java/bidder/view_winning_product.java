package bidder;


import auctioneer.auction;
import home.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import login_register.DBconnection;
import login_register.login_Bidder;


public class view_winning_product extends javax.swing.JFrame {
    public static int floorprice;
    private static int bidderID;
    private static int auctionID;
    private static String bidderName;
    
    public view_winning_product() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }
     
    public static ArrayList<bid> getBid(){
        ArrayList<bid> winning_auctions = new ArrayList<bid>();
        Connection con = DBconnection.getConnection();
        PreparedStatement ps, ps2;
        ResultSet rs, rs2;
        bid b;
        bidderName = login_Bidder.username;

        
        String qr = "SELECT `bidderID` FROM `bidder` WHERE `bidder_name`=?";
        String qr2 = "SELECT * FROM `bid` WHERE `bidderID`=?";
        
        try {
            ps = con.prepareStatement(qr);
            ps.setString(1, bidderName);
            rs = ps.executeQuery();
            
            while(rs.next()){
                bidderID = rs.getInt("bidderID");
            }
            
            try{
                ps2 = con.prepareStatement(qr2);
                ps2.setInt(1, bidderID);
                rs2 = ps2.executeQuery();

                while(rs2.next()){
                    b = new bid(rs2.getInt("auctionID"));

                    winning_auctions.add(b);
                } 
            } catch(SQLException ex){
                Logger.getLogger(view_winning_product.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(view_winning_product.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                    /* Ignored */
                }
            }
        }

        return winning_auctions;
    } 
    
    public static ArrayList<auction> getAuction(){
        ArrayList<auction> auction_details = new ArrayList<auction>();
        auction a;
        PreparedStatement ps, ps2, ps3;
        ResultSet rs, rs2, rs3;
        Connection con = DBconnection.getConnection();
        bidderName = login_Bidder.username;
        
        String qr = "SELECT `bidderID` FROM `bidder` WHERE `bidder_name`=?";
        String qr2 = "SELECT `auctionID` FROM `auction` WHERE `winnerID`=?";
        String qr3 = "SELECT * FROM `auction` WHERE `auctionID`=?";
        
        List<Integer> id_arr = new ArrayList<Integer>();
        
        try {
            ps = con.prepareStatement(qr);
            ps.setString(1, bidderName);
            rs = ps.executeQuery();
            
            while(rs.next()){
                bidderID = rs.getInt("bidderID");
            }
            ps2 = con.prepareStatement(qr2);
            ps2.setInt(1, bidderID);
            rs2 = ps2.executeQuery();
            while(rs2.next()){
                auctionID = rs2.getInt("auctionID");
                id_arr.add(auctionID);
            }
            
            int[] auctionID_arr = new int[id_arr.size()];
            for(int i=0; i<id_arr.size(); i++){
                auctionID_arr[i] = id_arr.get(i);
            }
            
            for(int k=0; k<auctionID_arr.length; k++){
                try {
                    ps3 = con.prepareStatement(qr3);
                    ps3.setInt(1, auctionID_arr[k]);
                    rs3 = ps3.executeQuery();

                    while(rs3.next()){
                        a = new auction(rs3.getInt("auctionID"),
                                        rs3.getString("product_name"),
                                        rs3.getString("product_desc"),
                                        rs3.getTimestamp("starttime"),
                                        rs3.getTimestamp("endtime"),
                                        rs3.getInt("winning_price"));

                        auction_details.add(a);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(view_winning_product.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(view_winning_product.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }    
        
        return auction_details;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        back_to_panel_Bidder = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        show_username = new javax.swing.JLabel("username",SwingConstants.RIGHT);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setMinimumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(2, 168, 158));
        jPanel2.setMaximumSize(new java.awt.Dimension(910, 530));
        jPanel2.setPreferredSize(new java.awt.Dimension(910, 530));
        jPanel2.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N
        jScrollPane1.setMaximumSize(new java.awt.Dimension(820, 330));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(820, 330));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(820, 330));

        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[6];
        columnsName[0] = "AuctionID";
        columnsName[1] = "Product Name";
        columnsName[2] = "Description";
        columnsName[3] = "Start Time";
        columnsName[4] = "Endtime";
        columnsName[5] = "Your Bid";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[7];
        for(int i=0; i<getAuction().size(); i++){
            rowData[0] = getAuction().get(i).getAuctionID();
            rowData[1] = getAuction().get(i).getProductName();
            rowData[2] = getAuction().get(i).getProductDesc();
            rowData[3] = getAuction().get(i).getStartTime();
            rowData[4] = getAuction().get(i).getEndTime();
            rowData[5] = getAuction().get(i).getWinningPrice();
            model.addRow(rowData);
        }
        table.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        table.setModel(model);
        table.setRowHeight(25);
        table.setRowSelectionAllowed(false);
        table.setSelectionBackground(new java.awt.Color(203, 240, 237));
        table.setShowHorizontalLines(false);
        table.setSurrendersFocusOnKeystroke(true);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setForeground(Color.BLACK);
        table.getTableHeader().setFont(new Font("Lato", Font.BOLD, 14));
        jScrollPane1.setViewportView(table);
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(80);
        colModel.getColumn(1).setPreferredWidth(160);
        colModel.getColumn(2).setPreferredWidth(180);
        colModel.getColumn(3).setPreferredWidth(160);
        colModel.getColumn(4).setPreferredWidth(160);
        colModel.getColumn(5).setPreferredWidth(80);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        colModel.getColumn(0).setCellRenderer(centerRenderer);
        colModel.getColumn(1).setCellRenderer(centerRenderer);
        colModel.getColumn(2).setCellRenderer(centerRenderer);
        colModel.getColumn(3).setCellRenderer(centerRenderer);
        colModel.getColumn(4).setCellRenderer(centerRenderer);
        colModel.getColumn(5).setCellRenderer(centerRenderer);

        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(45, 90, 820, 340);
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
        back_to_panel_Bidder.setBounds(400, 460, 130, 40);

        jLabel3.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Bidder Panel - View My Winning Products");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 10, 510, 60);

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

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_winning_product().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_to_panel_Bidder;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel show_username;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
