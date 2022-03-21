package validation;

import bidder.auction_details;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import login_register.DBconnection;

public class bid_validation {
    private static boolean can_place_bid;
    
    public static int check_bid_count(int bidderID, int auctionID){
        bidderID = auction_details.bidderID;
        auctionID = auction_details.auctionID;
        int count = 0;
        
        Connection con = DBconnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT COUNT(*) FROM `bid` WHERE `bidderID`=? AND `auctionID`=?;";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, bidderID);
            ps.setInt(2, auctionID);
            rs = ps.executeQuery();
            
            while(rs.next()){
                count = rs.getInt("COUNT(*)");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(bid_validation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(con != null){
                try{
                    con.close();
                } catch (SQLException e){
                     /* Ignored */
                }
            }
        }
        
        return count;
    }
    
    
    public static boolean check_eligibility_place_bid(int count){
        if (count < 1){
            can_place_bid = true;
        }
        else{
            can_place_bid = false;
        }
        
        return can_place_bid;
    }
    
}
