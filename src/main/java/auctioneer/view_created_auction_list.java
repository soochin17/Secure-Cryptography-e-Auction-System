package auctioneer;

import auctioneer.auction;
import home.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import login_register.DBconnection;
import login_register.login_Auctioneer;


public class view_created_auction_list extends javax.swing.JFrame {

    public static int floorprice;
    private static String auctioneerName;
    private static int auctioneerID;
    
    public view_created_auction_list() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }
    
    public static ArrayList<auction> getAuction(){
        ArrayList<auction> created_auctions = new ArrayList<auction>();
        Connection con = DBconnection.getConnection();
        PreparedStatement ps, ps2;
        ResultSet rs, rs2;
        auction b;
        auctioneerName = login_Auctioneer.username;       

        String qr = "SELECT `auctioneerID` FROM `auctioneer` WHERE `auctioneer_name`=?";
        String qr2 = "SELECT * FROM auction WHERE `auctioneerID`=?";
        try {
            ps = con.prepareStatement(qr);
            ps.setString(1, auctioneerName);
            rs = ps.executeQuery();
            
            while(rs.next()){
                auctioneerID = rs.getInt("auctioneerID");
                
            }
            try{
               ps2 = con.prepareStatement(qr2);
                ps2.setInt(1, auctioneerID);
                rs2 = ps2.executeQuery();


                while(rs2.next()){
                    b = new auction(rs2.getInt("auctionID"),
                                    rs2.getString("product_name"),
                                    rs2.getTimestamp("starttime"),
                                    rs2.getTimestamp("endtime"),
                                    rs2.getInt("winning_price"));

                    created_auctions.add(b);
                } 
            } catch(SQLException ex){
                Logger.getLogger(view_created_auction_list.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(view_created_auction_list.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
                if(con != null){
                    try{
                        con.close();
                    } catch (SQLException e){
                        /* Ignored */
                    }
                }
            }

        return created_auctions;
    } 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        back_to_panel_Bidder = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        show_username = new javax.swing.JLabel("username",SwingConstants.RIGHT);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(2, 168, 158));
        jPanel2.setPreferredSize(new java.awt.Dimension(605, 346));
        jPanel2.setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Lato", 1, 12)); // NOI18N

        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[4];
        columnsName[0] = "Auction ID";
        columnsName[1] = "Product Name";
        columnsName[2] = "Auction Endtime";
        columnsName[3] = "Winning Bid Price";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[5];
        for(int i=0; i<getAuction().size(); i++){
            rowData[0] = getAuction().get(i).getAuctionID();
            rowData[1] = getAuction().get(i).getProductName();
            rowData[2] = getAuction().get(i).getEndTime();
            rowData[3] = getAuction().get(i).getWinningPrice();
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
        table.getTableHeader().setFont(new Font("Lato", Font.BOLD, 16));
        jScrollPane1.setViewportView(table);
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(52);
        colModel.getColumn(1).setPreferredWidth(120);
        colModel.getColumn(2).setPreferredWidth(180);
        colModel.getColumn(3).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        colModel.getColumn(0).setCellRenderer(centerRenderer);
        colModel.getColumn(1).setCellRenderer(centerRenderer);
        colModel.getColumn(2).setCellRenderer(centerRenderer);
        colModel.getColumn(3).setCellRenderer(centerRenderer);

        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
        .setHorizontalAlignment(JLabel.CENTER);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(125, 90, 660, 340);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        back_to_panel_Bidder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back button.png"))); // NOI18N
        back_to_panel_Bidder.setContentAreaFilled(false);
        back_to_panel_Bidder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_to_panel_Bidder.setDefaultCapable(false);
        back_to_panel_Bidder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_panel_BidderActionPerformed(evt);
            }
        });
        jPanel2.add(back_to_panel_Bidder);
        back_to_panel_Bidder.setBounds(400, 460, 130, 40);

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

        jLabel2.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Auctioneer Panel - View My Created Auctions");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 10, 520, 60);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/small logo.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 10, 50, 60);

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
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_to_panel_BidderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_panel_BidderActionPerformed
        panel_Auctioneer pA = new panel_Auctioneer();
        pA.setVisible(true);
        pA.pack();
        pA.setLocationRelativeTo(null);
        auctioneerName = login_Auctioneer.username;
        pA.show_username.setText("User:  " + auctioneerName);
        pA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_back_to_panel_BidderActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed


    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_created_auction_list().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_to_panel_Bidder;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel show_username;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
