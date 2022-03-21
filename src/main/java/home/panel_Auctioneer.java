package home;

import login_register.main_login;
import auctioneer.add_auction;
import auctioneer.view_created_auction_list;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import login_register.login_Auctioneer;
import validation.auction_validate;

public class panel_Auctioneer extends JFrame implements ActionListener {

    private login_Auctioneer lA;
    private String auctioneerName;
            
    
    public panel_Auctioneer() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        add_auction = new javax.swing.JButton();
        view_created_auction = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        close = new javax.swing.JButton();
        show_username = new javax.swing.JLabel("username",SwingConstants.RIGHT);
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(910, 530));
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(240, 240, 175));
        jPanel2.setPreferredSize(new java.awt.Dimension(605, 346));
        jPanel2.setLayout(null);

        add_auction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create-new-auction button.png"))); // NOI18N
        add_auction.setBorderPainted(false);
        add_auction.setContentAreaFilled(false);
        add_auction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_auction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_auctionActionPerformed(evt);
            }
        });
        jPanel2.add(add_auction);
        add_auction.setBounds(330, 160, 240, 70);

        view_created_auction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view-my-created-auction button.png"))); // NOI18N
        view_created_auction.setBorderPainted(false);
        view_created_auction.setContentAreaFilled(false);
        view_created_auction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_created_auction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_created_auctionActionPerformed(evt);
            }
        });
        jPanel2.add(view_created_auction);
        view_created_auction.setBounds(310, 260, 280, 60);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Happy-Auction logo_1.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 300, 110);

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
        logout.setBounds(380, 360, 140, 60);

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auctioneer-bg.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 910, 530);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 910, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_auctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_auctionActionPerformed
        add_auction aA = new add_auction();
        aA.setVisible(true);
        aA.pack();
        aA.setLocationRelativeTo(null);
        auctioneerName = login_Auctioneer.username;
        aA.show_username.setText("User:  " + auctioneerName);
        aA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_add_auctionActionPerformed

    private void view_created_auctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_created_auctionActionPerformed
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
        
            view_created_auction_list vcal = new view_created_auction_list();
            vcal.setVisible(true);
            vcal.pack();
            vcal.setLocationRelativeTo(null);
            auctioneerName = login_Auctioneer.username;
            vcal.show_username.setText("User:  " + auctioneerName);
            vcal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_view_created_auctionActionPerformed

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
                new panel_Auctioneer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_auction;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logout;
    public javax.swing.JLabel show_username;
    private javax.swing.JButton view_created_auction;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
