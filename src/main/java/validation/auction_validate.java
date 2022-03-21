package validation;

import home.panel_Bidder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import login_register.DBconnection;


public class auction_validate {

    private static int eligibility;
    private static int status;
    private static int winner_result; //set 0=no; 1=yes
    //private static int winnerID;
    private int[] auctionID_toBeDetermined;
    private int[] participated_bidderID;
    private byte[] enc_bid;
    private static byte[] sk_bytes;
   
    /* bid_opening() */
    private int a_id;
    private int[] bidderID_list;
    private int bid_price;
    private static List<Integer> arr;
    private int index;
    
    public auction_validate() {
        
    }
    
    // get auctioneer's egilibility from `auctioneer` table
    // used in add_auction.java
    public int get_auctioneer_eligibility(int auctioneerID){
        Connection con = DBconnection.getConnection();
        PreparedStatement st;
        ResultSet rs;

        String query = "SELECT `eligibility` FROM `auctioneer` WHERE `auctioneerID`=?";
        
        try {
            st = con.prepareStatement(query);
            st.setInt(1, auctioneerID);
            rs = st.executeQuery();
            
            try{
                if(rs.next()){
                    eligibility = rs.getInt("eligibility");
                } else{
                    eligibility = 0;
                }
            } catch(NullPointerException e){
                System.out.println("Null value found");
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }

        return eligibility;
    }
    
    // get auction status
    // 1 = still opening
    // 0 = closed
    public int get_auction_status(int auctionID){
        Connection con = DBconnection.getConnection();
        PreparedStatement st;
        ResultSet rs;

        String query = "SELECT `status` FROM `auction` WHERE `auctionID`=?";
        
        try {
            st = con.prepareStatement(query);
            st.setInt(1, auctionID);
            rs = st.executeQuery();
            
            try{
                if(rs.next()){
                    status = rs.getInt("status");
                } else{
                    status = 0;
                }
            } catch(NullPointerException e){
                System.out.println("Null value found");
            }

        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }

        return status;
    }
    
    //compare current time with endtime
    public void update_auction_status(){
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        String query = "UPDATE `auction` SET `status`=0 WHERE endtime < now() AND `status`=1";
        
        try {
            ps = con.prepareStatement(query);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void check_and_update_auctioneer_eligibility(){
        List auctioneer_list = new ArrayList();
        Connection con = DBconnection.getConnection();
        PreparedStatement ps1, ps2, ps3;
        ResultSet rs1, rs2;
        int auctioneerID;
        
        try{
            String qr1 = "SELECT `auctioneerID` FROM `auctioneer`";
            ps1 = con.prepareStatement(qr1);
            rs1 = ps1.executeQuery();
            
            while(rs1.next()){
                auctioneerID = rs1.getInt("auctioneerID");
                auctioneer_list.add(auctioneerID);
            }

            String qr2 = "SELECT COUNT(*) FROM `auction` WHERE `status`=1 AND `auctioneerID`=?";
            String qr3 = "UPDATE auctioneer SET `eligibility`=0 WHERE `auctioneerID`=?";
            int count = 0;

            for(int i=0; i<auctioneer_list.size(); i++){
                try {
                    ps2 = con.prepareStatement(qr2);
                    ps2.setInt(1, (int) auctioneer_list.get(i));
                    rs2 = ps2.executeQuery();
                    while(rs2.next()){
                        count = rs2.getInt(1);
                    }

                    if(count == 0){
                        ps3 = con.prepareStatement(qr3);
                        ps3.setInt(1, (int) auctioneer_list.get(i));
                        ps3.executeUpdate();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        } catch (SQLException ex) {
                Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //check all pending auctions that are closed and not yet process bid opening
    public int[] check_pending_closedAuction(){
        ArrayList<Integer> list = new ArrayList<>();
        Connection con = DBconnection.getConnection();
        PreparedStatement st;
        ResultSet rs;

        String query = "SELECT `auctionID` FROM `auction` WHERE `winnerID`=0 AND `status`=0";
        
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            
            
            while(rs.next()){
                list.add(rs.getInt("auctionID"));
                    
            } 
            
            auctionID_toBeDetermined = new int[list.size()];
            for(int i=0; i<auctionID_toBeDetermined.length; i++){
                auctionID_toBeDetermined[i] = list.get(i);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }

        return auctionID_toBeDetermined;
    }
    
    // retrieve participated bidder ID for auctionID=?
    public int[] get_participated_bidder_ID(int auctionID){
        ArrayList<Integer> bidder_list = new ArrayList<>();
        Connection con = DBconnection.getConnection();
        PreparedStatement st;
        ResultSet rs;

        String query = "SELECT `bidderID` FROM `bid` WHERE `auctionID`=?";
        
        try {
            st = con.prepareStatement(query);
            st.setInt(1, auctionID);
            rs = st.executeQuery();
            
            
            while(rs.next()){
                bidder_list.add(rs.getInt("bidderID"));
                    
            } 
            
            if(bidder_list.size() != 0){
                participated_bidderID = new int[bidder_list.size()];
                for(int i=0; i<participated_bidderID.length; i++){
                    participated_bidderID[i] = bidder_list.get(i);
                }
            } else {
                return null;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }

        return participated_bidderID;
        
    }
    
    //retrieve encrypted bid for one bidder
    public byte[] retrieve_encrypted_bid(int bidderID, int auctionID)throws Exception{
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String qr = "SELECT `token` FROM `bid` WHERE `bidderID`=? AND `auctionID`=?";
        
        try {
            ps = con.prepareStatement(qr);
            ps.setInt(1, bidderID);
            ps.setInt(2, auctionID);
            rs = ps.executeQuery();
            
            while(rs.next()){
               
                enc_bid = rs.getBytes("token");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }

        return enc_bid;
    }
    
    //retrieve private key (bytes[]) of the auctioneer
    //after retrieve, call RSA.convertBytesToSK(byte[] sk_bytes) to get back PrivateKey object
    //call RSA.decrypt(byte[] enc_bid, PrivateKey sk)
    public byte[] retrieve_sk(int auctionID) throws Exception{
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        String qr = "SELECT `sk` FROM `auctioneer` WHERE "
                    + "`auctioneerID`=(SELECT `auctioneerID` FROM `auction` WHERE `auctionID`=?)";
        
        try {
            ps = con.prepareStatement(qr);
            ps.setInt(1, auctionID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                sk_bytes = (byte[])rs.getBytes("sk");

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }
        
        return sk_bytes;
    }
    
    //choose the highest bid with time priority
    //if same bid prices are placed, it will automatically choose the first highest bid
    //since the bid is placed in time order
    public int maxBid(List<Integer> arr){
        int[] all_bids = new int[arr.size()];
        for(int k=0; k<arr.size(); k++){
            all_bids[k] = arr.get(k);
        }
        
        int max = Arrays.stream(all_bids).max().getAsInt();
        return max;
    }
   
    //update the winner on db
    public void publish_auction_winner(int auctionID, int[] bidder_list, int index, int winningPrice){
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        
        String qr = "UPDATE `auction` SET `winnerID`=? , `winning_price`=? WHERE `auctionID`=?";
        
        try {
            ps = con.prepareStatement(qr);
            ps.setInt(1, bidder_list[index]);
            ps.setInt(2, winningPrice);
            ps.setInt(3, auctionID);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }
    }
    
    //if no bidder placing bid on that auction, will call this function
    public void update_NO_winner(int auctionID){
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        
        String qr = "UPDATE `auction` SET `winnerID`=NULL , `winning_price`=0 WHERE `auctionID`=?";
        
        try {
            ps = con.prepareStatement(qr);
            ps.setInt(1, auctionID);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(auction_validate.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }
    }
    
    
    
    public void bid_opening (int[] pending_aucID) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        arr = new ArrayList<>();
        
        //if there is at least one auctionID not yet open bids
        for(int i=0; i<pending_aucID.length; i++){
            RSA r = new RSA();
            auction_validate av2 = new auction_validate();

            try {    
                a_id = pending_aucID[i];
                byte[] sk = av2.retrieve_sk(a_id); //byte[]

                bidderID_list = av2.get_participated_bidder_ID(a_id);

                //if there is at least one bid placed on the auction
                if(bidderID_list != null){
                    for(int j=0; j<bidderID_list.length; j++){
                        try {
                            int b_id = bidderID_list[j];
                            byte[] encrypted_bid = av2.retrieve_encrypted_bid(b_id, a_id);
                            byte[] decrypted_bid = r.decrypt(encrypted_bid, r.convertBytesToSK(sk));

                            String dec_bid_str = new String(decrypted_bid);
                            bid_price = Integer.parseInt(dec_bid_str);

                        } catch (Exception ex) {
                            Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        arr.add(bid_price);
                    }

                    //determine the winning price
                    int winning_price = av2.maxBid(arr);
                    index = arr.indexOf(winning_price);
                    //publish and update the auction result
                    av2.publish_auction_winner(a_id, bidderID_list, index, winning_price);

                }else{
                    av2.update_NO_winner(a_id);
                }

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(panel_Bidder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
