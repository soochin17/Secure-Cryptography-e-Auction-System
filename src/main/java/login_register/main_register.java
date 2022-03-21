package login_register;

import javax.swing.JFrame;


public class main_register extends javax.swing.JFrame {

    public main_register() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        go_to_registerAuctioneer_ = new javax.swing.JButton();
        go_to_registerBidder_ = new javax.swing.JButton();
        go_to_main_login_ = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(240, 240, 175));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        go_to_registerAuctioneer_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auctioneer button.png"))); // NOI18N
        go_to_registerAuctioneer_.setBorderPainted(false);
        go_to_registerAuctioneer_.setContentAreaFilled(false);
        go_to_registerAuctioneer_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_registerAuctioneer_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_registerAuctioneer_ActionPerformed(evt);
            }
        });
        jPanel3.add(go_to_registerAuctioneer_);
        go_to_registerAuctioneer_.setBounds(10, 100, 160, 60);

        go_to_registerBidder_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bidder button.png"))); // NOI18N
        go_to_registerBidder_.setBorderPainted(false);
        go_to_registerBidder_.setContentAreaFilled(false);
        go_to_registerBidder_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_registerBidder_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_registerBidder_ActionPerformed(evt);
            }
        });
        jPanel3.add(go_to_registerBidder_);
        go_to_registerBidder_.setBounds(200, 100, 160, 60);

        go_to_main_login_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel button.png"))); // NOI18N
        go_to_main_login_.setBorderPainted(false);
        go_to_main_login_.setContentAreaFilled(false);
        go_to_main_login_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_main_login_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_main_login_ActionPerformed(evt);
            }
        });
        jPanel3.add(go_to_main_login_);
        go_to_main_login_.setBounds(60, 199, 243, 50);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 206, 0));
        jLabel4.setText("REGISTER ACCOUNT ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(46, 20, 280, 60);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(270, 120, 370, 300);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Happy-Auction logo_1.png"))); // NOI18N
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 0, 300, 110);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main.png"))); // NOI18N
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

    private void go_to_registerAuctioneer_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_registerAuctioneer_ActionPerformed
        register_Auctioneer ra = new register_Auctioneer();
        ra.setVisible(true);
        ra.pack();
        ra.setLocationRelativeTo(null);
        ra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_registerAuctioneer_ActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void go_to_main_login_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_main_login_ActionPerformed
        main_login lo = new main_login();
        lo.setVisible(true);
        lo.pack();
        lo.setLocationRelativeTo(null);
        lo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_main_login_ActionPerformed

    private void go_to_registerBidder_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_registerBidder_ActionPerformed
        register_Bidder rb = new register_Bidder();
        rb.setVisible(true);
        rb.pack();
        rb.setLocationRelativeTo(null);
        rb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_registerBidder_ActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton go_to_main_login_;
    private javax.swing.JButton go_to_registerAuctioneer_;
    private javax.swing.JButton go_to_registerBidder_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
