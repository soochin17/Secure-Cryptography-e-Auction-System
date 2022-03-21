package auctioneer;

import home.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import login_register.DBconnection;
import login_register.login_Auctioneer;
import validation.auction_validate;


public class add_auction extends JFrame implements ActionListener{

    private static int auctioneerID;
    
    private String auctioneerName;
    private static int eligibility;
    private int status;
    
    public add_auction() {
        initComponents();
        this.setLocationRelativeTo(null); // center form in screen
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        go_to_panel_Auctioneer = new javax.swing.JButton();
        create_auction = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        product_name = new javax.swing.JTextField();
        product_desc = new javax.swing.JTextField();
        floor_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        show_username = new javax.swing.JLabel("username",SwingConstants.RIGHT);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(910, 530));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(910, 530));

        jPanel2.setBackground(new java.awt.Color(240, 240, 175));
        jPanel2.setPreferredSize(new java.awt.Dimension(605, 346));
        jPanel2.setLayout(null);

        go_to_panel_Auctioneer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel2 button.png"))); // NOI18N
        go_to_panel_Auctioneer.setBorderPainted(false);
        go_to_panel_Auctioneer.setContentAreaFilled(false);
        go_to_panel_Auctioneer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        go_to_panel_Auctioneer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_to_panel_AuctioneerActionPerformed(evt);
            }
        });
        jPanel2.add(go_to_panel_Auctioneer);
        go_to_panel_Auctioneer.setBounds(300, 410, 120, 50);

        create_auction.setIcon(new javax.swing.ImageIcon(getClass().getResource("/create button.png"))); // NOI18N
        create_auction.setBorderPainted(false);
        create_auction.setContentAreaFilled(false);
        create_auction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_auction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_auctionActionPerformed(evt);
            }
        });
        jPanel2.add(create_auction);
        create_auction.setBounds(500, 410, 120, 50);

        jLabel2.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Auctioneer Panel - Create New Auction");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 10, 460, 60);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);
        jPanel3.add(product_name);
        product_name.setBounds(150, 20, 310, 33);
        jPanel3.add(product_desc);
        product_desc.setBounds(150, 80, 310, 80);

        floor_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                floor_priceKeyTyped(evt);
            }
        });
        jPanel3.add(floor_price);
        floor_price.setBounds(180, 190, 110, 33);

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("** should not be 0");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(300, 190, 100, 30);

        jLabel3.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Floor Price:      RM");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(20, 190, 150, 30);

        jLabel4.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Description:");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 120, 120, 40);

        jLabel7.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Product Name: ");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(20, 20, 130, 30);

        jLabel10.setFont(new java.awt.Font("Lato Heavy", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Product");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(20, 90, 100, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(220, 130, 480, 250);

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

    private void go_to_panel_AuctioneerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_to_panel_AuctioneerActionPerformed
        panel_Auctioneer pA = new panel_Auctioneer();
        pA.setVisible(true);
        pA.pack();
        pA.setLocationRelativeTo(null);
        auctioneerName = login_Auctioneer.username;
        pA.show_username.setText("User:  " + auctioneerName);
        pA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_go_to_panel_AuctioneerActionPerformed

    private void create_auctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_auctionActionPerformed
        String productname = product_name.getText();
        String productdesc = product_desc.getText();

        if(productname.equals("") || productdesc.equals("") || floor_price.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All the fields cannot be EMPTY");
        }
        else if(productname.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in Product Name");
        }
        else if(productdesc.equals("")){
            JOptionPane.showMessageDialog(null, "Please fill in Product Description");
        }
        else if(floor_price.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill in Floor Price");
        }
        else if((!floor_price.getText().isEmpty()) && (floor_price.getText().charAt(0) == '0')){
            JOptionPane.showMessageDialog(null, "Floor price cannot be RM 0");
        }
        else{
            int floorprice = Integer.parseInt(floor_price.getText().trim());
            
            PreparedStatement st1 = null, st2 = null, st3 = null;
            ResultSet rs = null;
            String query1 = "SELECT `auctioneerID` FROM `auctioneer` WHERE `auctioneer_name`=?";
            String query2 = "INSERT INTO `auction`(`product_name`, `product_desc`,`floor_price`,`auctioneerID`,`status`, `starttime`,`endtime`) "
                    + "VALUES (?,?,?,?,?,?,?)";
            String query3 = "UPDATE `auctioneer` SET `eligibility`=1 WHERE `auctioneerID`=?";
            
            // get values from login_Auctioneer(username)
            auctioneerName = login_Auctioneer.username;
            
            Connection con = DBconnection.getConnection();
            
            try {
                st1 = con.prepareStatement(query1);
                st1.setString(1, auctioneerName);
                rs = st1.executeQuery();

                while (rs.next()) {
                    auctioneerID = rs.getInt("auctioneerID");
                    auction_validate av = new auction_validate();
                    eligibility = av.get_auctioneer_eligibility(auctioneerID);
                }
                
                //status=0, can add auction
                if(eligibility == 0){
                    st2 = con.prepareStatement(query2);
                    st2.setString(1, productname);
                    st2.setString(2, productdesc);
                    st2.setInt(3, floorprice);
                    st2.setInt(4, auctioneerID);
                    
                    //set status=1, indicating that the auction is open
                    status = 1;
                    st2.setInt(5, status);
                    
                    //get current time and store in database
                    java.util.Date date = new java.util.Date();
                    Timestamp starttime = new Timestamp(date.getTime());
                    st2.setTimestamp(6, starttime);
                    
                    // get current time, calculate endttime (default duration = 1 hour) and store in database
                    Calendar cal = Calendar.getInstance();
                    cal.setTimeInMillis(starttime.getTime());
                    //cal.add(Calendar.HOUR, 1); /* HappyAuction system setting, auction duration = 1 hour */
                    cal.add(Calendar.MINUTE, 2); /* set duration = 2mins for testing purpose */
                    Timestamp endtime = new Timestamp(cal.getTime().getTime());
                    st2.setTimestamp(7, endtime);
                    
                    st3 = con.prepareStatement(query3);
                    //set eligibility=1, indicating that the auctioneer cannot be able to create another auction
                    
                    st3.setInt(1, auctioneerID);
                    st3.executeUpdate();
                   
                    if(st2.executeUpdate() > 0){
                        JOptionPane.showMessageDialog(null, "Your auction is successfully created");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "You only can create ONE auction at ONE time");
                }
                
            
            } catch (SQLException ex) {
                Logger.getLogger(add_auction.class.getName()).log(Level.SEVERE, null, ex);
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
           
    }//GEN-LAST:event_create_auctionActionPerformed

    private void floor_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_floor_priceKeyTyped
        // make sure only integer can be keyed in
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_floor_priceKeyTyped

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //close the jframe
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_auction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JButton create_auction;
    private javax.swing.JTextField floor_price;
    private javax.swing.JButton go_to_panel_Auctioneer;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField product_desc;
    private javax.swing.JTextField product_name;
    public javax.swing.JLabel show_username;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
