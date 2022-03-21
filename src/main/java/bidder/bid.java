package bidder;

import java.sql.Timestamp;

public class bid {
    private int auctionID;
    private Timestamp placing_time;
    
    //constructor
    public bid(Timestamp placing_time){
       
        this.placing_time = placing_time;
    }
    
    public bid(int auctionID){
        this.auctionID = auctionID;
    }
    
    public int getAuctionID(){
        return this.auctionID;
    }
    
    public Timestamp getPlacingTime(){
        return this.placing_time;
    }
}
