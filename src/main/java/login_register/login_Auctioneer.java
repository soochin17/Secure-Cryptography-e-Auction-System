package login_register;

import home.panel_Auctioneer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;


public class login_Auctioneer extends JFrame implements ActionListener {

    public static String username;

    
    public login_Auctioneer() {
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
        go_to_mainLogin_ = new javax.swing.JButton();
        Login_ = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        unmask_pass = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(240, 240, 175));
        jPanel2.setPreferredSize(new java.awt.Dimension(605, 346));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        user_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                user_nameKeyTyped(evt);
            }
        });
        jPanel3.add(user_name);
        user_name.setBounds(140, 100, 240, 33);
        jPanel3.add(user_pwd);
        user_pwd.setBounds(140, 165, 240, 33);

        go_to_mainLogin_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel button.png"))); // NOI18N
        go_to_mainLogin_.setBorderPainted(false);
        go_to_mainLogin_.setContentAreaFilled(false);
        go_to_mainLogin_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_mainLogin_.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_to_mainLogin_MouseClicked(evt);
            }
        });
        jPanel3.add(go_to_mainLogin_);
        go_to_mainLogin_.setBounds(70, 230, 110, 40);

        Login_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login button.png"))); // NOI18N
        Login_.setBorderPainted(false);
        Login_.setContentAreaFilled(false);
        Login_.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_ActionPerformed(evt);
            }
        });
        jPanel3.add(Login_);
        Login_.setBounds(250, 230, 110, 40);

        jLabel2.setFont(new java.awt.Font("Impact", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 206, 0));
        jLabel2.setText("Auctioneer Login");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(90, 20, 270, 50);

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

    private void go_to_mainLogin_MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_go_to_mainLogin_MouseClicked
        main_login ml = new main_login();
        ml.setVisible(true);
        ml.pack();
        ml.setLocationRelativeTo(null);
        ml.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_mainLogin_MouseClicked


    private void Login_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_ActionPerformed
        Connection con = DBconnection.getConnection();
        PreparedStatement st;
        ResultSet rs;
        username = user_name.getText();

        String password = String.valueOf(user_pwd.getPassword());
        String stored_hash = null;
        String query = "SELECT `auctioneer_pass` FROM `auctioneer` WHERE `auctioneer_name`=?";
        try {
            
            st = con.prepareStatement(query);
            st.setString(1, username);
            rs = st.executeQuery();
            while(rs.next()){
                stored_hash = rs.getString("auctioneer_pass");
            }

            //verify account
            if(BCrypt.checkpw(password, stored_hash)){
                panel_Auctioneer pa = new panel_Auctioneer();
                pa.setVisible(true);
                pa.pack();
                pa.setLocationRelativeTo(null);
                pa.show_username.setText("User:  " + username);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                user_name.setText("");
                user_pwd.setText("");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "The Auctioneer account is not exist", "Error", JOptionPane.ERROR_MESSAGE);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }
    }//GEN-LAST:event_Login_ActionPerformed

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
            user_pwd.setEchoChar('*');
        }
    }//GEN-LAST:event_unmask_passMouseClicked


    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_Auctioneer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login_;
    private javax.swing.JButton close;
    private javax.swing.JButton go_to_mainLogin_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton unmask_pass;
    public static javax.swing.JTextField user_name;
    private javax.swing.JPasswordField user_pwd;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
