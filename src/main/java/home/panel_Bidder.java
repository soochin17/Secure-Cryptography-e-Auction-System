package home;


import bidder.view_auction_list;
import bidder.view_participated_auction_list;
import bidder.view_winning_product;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import login_register.main_login;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import login_register.login_Bidder;
import validation.auction_validate;


public class panel_Bidder extends javax.swing.JFrame {

    private int[] bidderID_list;

    private static List<Integer> arr;
    private int index;
    private int bid_price;
    private int a_id;
    private String bidderName;
    
    public panel_Bidder() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        view_auction_list = new javax.swing.JButton();
        view_participated_auction = new javax.swing.JButton();
        view_winning_product = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        show_username = new javax.swing.JLabel("username",SwingConstants.RIGHT);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(240, 240, 175));
        jPanel2.setMaximumSize(new java.awt.Dimension(910, 530));
        jPanel2.setMinimumSize(new java.awt.Dimension(910, 530));
        jPanel2.setPreferredSize(new java.awt.Dimension(910, 530));
        jPanel2.setLayout(null);

        view_auction_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-ongoing-auctions button.png"))); // NOI18N
        view_auction_list.setBorderPainted(false);
        view_auction_list.setContentAreaFilled(false);
        view_auction_list.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_auction_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_auction_listActionPerformed(evt);
            }
        });
        jPanel2.add(view_auction_list);
        view_auction_list.setBounds(330, 130, 250, 70);

        view_participated_auction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-my-participated-auctions button.png"))); // NOI18N
        view_participated_auction.setBorderPainted(false);
        view_participated_auction.setContentAreaFilled(false);
        view_participated_auction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_participated_auction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_participated_auctionActionPerformed(evt);
            }
        });
        jPanel2.add(view_participated_auction);
        view_participated_auction.setBounds(290, 220, 330, 70);

        view_winning_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-winning-products button.png"))); // NOI18N
        view_winning_product.setBorderPainted(false);
        view_winning_product.setContentAreaFilled(false);
        view_winning_product.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_winning_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_winning_productActionPerformed(evt);
            }
        });
        jPanel2.add(view_winning_product);
        view_winning_product.setBounds(310, 310, 290, 70);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout button.png"))); // NOI18N
        logout.setBorderPainted(false);
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel2.add(logout);
        logout.setBounds(385, 400, 140, 60);

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

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Happy-Auction logo_1.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 300, 110);

        show_username.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        show_username.setForeground(new java.awt.Color(255, 255, 255));
        show_username.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(show_username);
        show_username.setBounds(700, 10, 150, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auctioneer-bg.png"))); // NOI18N
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

    private void view_auction_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_auction_listActionPerformed
        try {
            auction_validate av = new auction_validate();
            av.update_auction_status();
            av.check_and_update_auctioneer_eligibility();
            
            //arr = new ArrayList<>();
            // check auctionID that haven't determine winner
            int[] pending_aucID = av.check_pending_closedAuction();
            
            // if have pending_auctionID
            if(pending_aucID != null){
                av.bid_opening(pending_aucID);     
            }
            else{
                /* Ignored */
            }
            
            view_auction_list val = new view_auction_list();
            val.setVisible(true);
            val.pack();
            val.setLocationRelativeTo(null);
            bidderName = login_Bidder.username;
            val.show_username.setText("User:  " + bidderName);
            val.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_view_auction_listActionPerformed

    private void view_participated_auctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_participated_auctionActionPerformed
        view_participated_auction_list vpal = new view_participated_auction_list();
        vpal.setVisible(true);
        vpal.pack();
        vpal.setLocationRelativeTo(null);
        bidderName = login_Bidder.username;
        vpal.show_username.setText("User:  " + bidderName);
        vpal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_view_participated_auctionActionPerformed

    private void view_winning_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_winning_productActionPerformed
        view_winning_product vwp = new view_winning_product();
        vwp.setVisible(true);
        vwp.pack();
        vwp.setLocationRelativeTo(null);
        bidderName = login_Bidder.username;
        vwp.show_username.setText("User:  " + bidderName);
        vwp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_view_winning_productActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Proceed to logout?", "Choose", JOptionPane.YES_NO_OPTION);
        JOptionPane.setRootFrame(null);
        if(msg == JOptionPane.YES_OPTION){
            dispose();
            main_login ml = new main_login();
            ml.setLocationRelativeTo(null);
            ml.setVisible(true);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed


    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel_Bidder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logout;
    public javax.swing.JLabel show_username;
    private javax.swing.JButton view_auction_list;
    private javax.swing.JButton view_participated_auction;
    private javax.swing.JButton view_winning_product;
    // End of variables declaration//GEN-END:variables
}
