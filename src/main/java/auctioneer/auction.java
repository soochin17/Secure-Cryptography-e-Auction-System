package auctioneer;

import java.sql.Timestamp;

public class auction {
    private int auctionID;
    private String product_name;
    private String product_desc;
    private double floor_price;
    private int winning_price;
    
    private Timestamp starttime;
    private Timestamp endtime;
    
    public auction(int auctionID, String product_name, Timestamp endtime){
        this.auctionID = auctionID;
        this.product_name = product_name;
        this.endtime = endtime;
        
    }
    
    public auction(int auctionID, String product_name, Timestamp starttime, Timestamp endtime, int winning_price){
        this.auctionID = auctionID;
        this.product_name = product_name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.winning_price = winning_price;
    }
    
    public auction(int auctionID, String product_name, String product_desc, Timestamp starttime, Timestamp endtime, int winning_price){
        this.auctionID = auctionID;
        this.product_desc = product_desc;
        this.product_name = product_name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.winning_price = winning_price;
    }
    
    public auction(int auctionID, String product_name, String product_desc, double floor_price, Timestamp endtime, int winning_price){
        
        
    }
    
    public int getAuctionID(){
        return this.auctionID;
    }
    
    public String getProductName(){
        return this.product_name;
    }
  
    public Timestamp getStartTime(){
        return this.starttime;
    }
    
    public Timestamp getEndTime(){
        return this.endtime;
    }
    
   
    public String getProductDesc(){
        return this.product_desc;
    } 
    
   
    public double getFloorPrice(){
        return this.floor_price;
    }
   
    public int getWinningPrice(){
        return this.winning_price;
    }
}
