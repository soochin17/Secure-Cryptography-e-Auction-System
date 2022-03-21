package login_register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class main_login extends JFrame implements ActionListener {

    public main_login() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        go_to_loginBidder_ = new javax.swing.JButton();
        go_to_main_register_ = new javax.swing.JButton();
        go_to_loginAuctioneer_ = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(2, 168, 158));
        jPanel2.setPreferredSize(new java.awt.Dimension(458, 337));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setDoubleBuffered(false);
        jPanel3.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 206, 0));
        jLabel2.setText("OR");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(170, 160, 39, 50);

        go_to_loginBidder_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bidder button.png"))); // NOI18N
        go_to_loginBidder_.setBorder(null);
        go_to_loginBidder_.setBorderPainted(false);
        go_to_loginBidder_.setContentAreaFilled(false);
        go_to_loginBidder_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_loginBidder_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_loginBidder_ActionPerformed(evt);
            }
        });
        jPanel3.add(go_to_loginBidder_);
        go_to_loginBidder_.setBounds(200, 90, 160, 60);

        go_to_main_register_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register-new-account2 button.png"))); // NOI18N
        go_to_main_register_.setBorderPainted(false);
        go_to_main_register_.setContentAreaFilled(false);
        go_to_main_register_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_main_register_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_main_register_ActionPerformed(evt);
            }
        });
        jPanel3.add(go_to_main_register_);
        go_to_main_register_.setBounds(40, 220, 290, 60);

        go_to_loginAuctioneer_.setBackground(new java.awt.Color(255, 255, 255));
        go_to_loginAuctioneer_.setForeground(new java.awt.Color(255, 255, 255));
        go_to_loginAuctioneer_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/auctioneer button.png"))); // NOI18N
        go_to_loginAuctioneer_.setBorder(null);
        go_to_loginAuctioneer_.setBorderPainted(false);
        go_to_loginAuctioneer_.setContentAreaFilled(false);
        go_to_loginAuctioneer_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_loginAuctioneer_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_loginAuctioneer_ActionPerformed(evt);
            }
        });
        jPanel3.add(go_to_loginAuctioneer_);
        go_to_loginAuctioneer_.setBounds(10, 90, 160, 60);

        jLabel4.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 206, 0));
        jLabel4.setText("LOGIN AS");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(123, 20, 126, 60);

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
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void go_to_loginAuctioneer_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_loginAuctioneer_ActionPerformed
        login_Auctioneer lA = new login_Auctioneer();
        lA.setVisible(true);
        lA.pack();
        lA.setLocationRelativeTo(null);
        lA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_loginAuctioneer_ActionPerformed

    private void go_to_loginBidder_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_loginBidder_ActionPerformed
        login_Bidder b = new login_Bidder();
        b.setVisible(true);
        b.pack();
        b.setLocationRelativeTo(null);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_loginBidder_ActionPerformed

    private void go_to_main_register_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_main_register_ActionPerformed
        main_register reg = new main_register();
        reg.setVisible(true);
        reg.pack();
        reg.setLocationRelativeTo(null);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_main_register_ActionPerformed

    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton go_to_loginAuctioneer_;
    private javax.swing.JButton go_to_loginBidder_;
    private javax.swing.JButton go_to_main_register_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
