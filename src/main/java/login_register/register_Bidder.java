package login_register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import validation.JBCrypt;


public class register_Bidder extends JFrame implements ActionListener {

    public register_Bidder() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        user_name = new javax.swing.JTextField();
        user_pwd = new javax.swing.JPasswordField();
        back_to_mainRegister_ = new javax.swing.JButton();
        BidRegister_ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        unmask_pass = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(2, 168, 158));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        user_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        user_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_nameKeyTyped(evt);
            }
        });
        jPanel3.add(user_name);
        user_name.setBounds(140, 100, 240, 33);
        jPanel3.add(user_pwd);
        user_pwd.setBounds(140, 165, 240, 33);

        back_to_mainRegister_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel button.png"))); // NOI18N
        back_to_mainRegister_.setBorderPainted(false);
        back_to_mainRegister_.setContentAreaFilled(false);
        back_to_mainRegister_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back_to_mainRegister_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_to_mainRegister_ActionPerformed(evt);
            }
        });
        jPanel3.add(back_to_mainRegister_);
        back_to_mainRegister_.setBounds(70, 230, 110, 40);

        BidRegister_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/register button.png"))); // NOI18N
        BidRegister_.setBorderPainted(false);
        BidRegister_.setContentAreaFilled(false);
        BidRegister_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BidRegister_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BidRegister_ActionPerformed(evt);
            }
        });
        jPanel3.add(BidRegister_);
        BidRegister_.setBounds(250, 230, 110, 40);

        jLabel2.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 206, 0));
        jLabel2.setText("Bidder Registration");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(65, 20, 310, 50);

        jLabel3.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Username: ");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(30, 100, 100, 30);

        jLabel4.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Password:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(30, 165, 90, 30);

        unmask_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/unmask-pass button.png"))); // NOI18N
        unmask_pass.setBorderPainted(false);
        unmask_pass.setContentAreaFilled(false);
        unmask_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unmask_passMouseClicked(evt);
            }
        });
        jPanel3.add(unmask_pass);
        unmask_pass.setBounds(390, 165, 20, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(235, 120, 440, 310);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Happy-Auction logo_1.png"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 300, 110);

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

    // check if the username already exist in bidder table
    public boolean checkUsernameExist(String uname){
        PreparedStatement ps;
        ResultSet rs;
        boolean result = false;
        String qr = "SELECT * FROM `bidder` WHERE `bidder_name`=?";
        
        try{
            ps = DBconnection.getConnection().prepareStatement(qr);
            ps.setString(1, uname);
            rs = ps.executeQuery();
            
            if(rs.next()){
                result = true;
            }
        } catch(SQLException ex){
            Logger.getLogger(register_Bidder.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return result;
    }
    
    private void BidRegister_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BidRegister_ActionPerformed
        String username = user_name.getText();
        String password = String.valueOf(user_pwd.getPassword());
        Connection con = DBconnection.getConnection();
        
        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Username");
        } 
        else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Add A Password");
        }
        else if(checkUsernameExist(username)){
            JOptionPane.showMessageDialog(null, "This bidder account is already exist");
            user_name.setText("");
            user_pwd.setText("");
        }
        else{
            PreparedStatement st;
            String query = "INSERT INTO `bidder`(`bidder_name`, `bidder_pass`) VALUES (?,?)";
                
            try {
                String password_hash = JBCrypt.hashPassword(password);
                
                st = con.prepareStatement(query);
                st.setString(1, username);
                st.setString(2, password_hash);
            
                if(st.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Your bidder account is added");
                }
            } catch (SQLException ex) {
                Logger.getLogger(register_Bidder.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                if(con != null){
                    try{
                        con.close();
                    } catch (SQLException e){
                         /* Ignored */
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_BidRegister_ActionPerformed

    private void user_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_nameKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isAlphabetic(c) || (Character.isDigit(c)) ||(c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE))){
            evt.consume();
        }
    }//GEN-LAST:event_user_nameKeyTyped

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void unmask_passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unmask_passMouseClicked
        if ( user_pwd.getEchoChar() != '\u0000' ) {
            user_pwd.setEchoChar((char)0);
        } else {
            //          user_pwd.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
            user_pwd.setEchoChar('*');
        }
    }//GEN-LAST:event_unmask_passMouseClicked

    private void back_to_mainRegister_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_to_mainRegister_ActionPerformed
        main_register reg = new main_register();
        reg.setVisible(true);
        reg.pack();
        reg.setLocationRelativeTo(null);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_back_to_mainRegister_ActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(register_Bidder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register_Bidder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register_Bidder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register_Bidder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register_Bidder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BidRegister_;
    private javax.swing.JButton back_to_mainRegister_;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton unmask_pass;
    private javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pwd;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
