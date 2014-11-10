package edu.gatech.seclass.project2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Customer {
    private String birthday;
    private String name;
    private String address;
    private int vipNumber;
    private int vipPointsTotal; 
    private String goldStatusDate; //store as YYYY-MM-DD
    private double percentDiscount = 0;
    private int freeItemsAvailable;
    
    //this creates a new customer
    public Customer(String initName, String initBirthday, String initAddress){
        this.birthday = initBirthday;
        this.name = initName;
        this.address = initAddress;
        this.goldStatusDate = null;
        this.percentDiscount = 0;
        this.freeItemsAvailable = 0;

    }
    //to create customer from database 
    public Customer(int initID, 
                    String initName, 
                    String initBirthday, 
                    String initAddress,
                    int initVIPPointsTotal, 
                    String initGoldStatusDate, 
                    double initPercentDiscount, 
                    int initFreeItemsAvailable){
        this.vipNumber = initID;
        this.name = initName;
        this.birthday = initBirthday;
        this.address = initAddress;
        this.vipPointsTotal = initVIPPointsTotal;
        this.goldStatusDate = initGoldStatusDate;
        this.percentDiscount = initPercentDiscount;
        this.freeItemsAvailable = initFreeItemsAvailable;

    }
    
    
    //public methods

    //award points
    //
    //this will be called when a purchase is executed, will modify status to gold if over 1000
    public int awardPoints(int numberOfPoints) {
    	
    	if(this.getVIPPointsTotal() >= 1000){
    		numberOfPoints += numberOfPoints;
    	}
        this.vipPointsTotal += numberOfPoints;///need to check for negative?
        if (this.vipPointsTotal >= 1000){
            this.awardGold();
        }
        
        return this.vipPointsTotal;
    };
    
    //this attempts to claim free items and will return the number claimed
    public int claimFreeItems (int numberOfItems){
        if (this.freeItemsAvailable == 0 ){
            return 0;
        } else if (this.freeItemsAvailable >= numberOfItems){
            this.freeItemsAvailable -= numberOfItems;
            return numberOfItems; //all are available for free
        } else if (this.freeItemsAvailable < numberOfItems){
            int returnAvailable = this.freeItemsAvailable;
            this.freeItemsAvailable = 0;
            return returnAvailable;
        }
        return 0;
    }
    
    //this method can be called anytime the customer is accessed it will s
    public int creditFreeItem(){
        this.freeItemsAvailable++;
        return this.freeItemsAvailable;
    };
    
    //private methods 
    //

    //this function will modify status to gold, modifying the percent discount and flagging for free items
    private void awardGold(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formatted = format1.format(cal.getTime());
        this.goldStatusDate = formatted;
        this.percentDiscount = .10; //
      
    };
    
    //getters 
    //
    public int getID(){ return this.vipNumber;}
    public String getBirthday(){ return this.birthday;}
    public String getName(){ return this.name;}
    public String getAddress(){ return this.address;}
    public int getVIPNumber(){ return this.vipNumber;}
    public int getVIPPointsTotal (){ return this.vipPointsTotal;}
    public String getGoldStatusDate(){ return this.goldStatusDate;}
    public double getPercentDiscount(){ return this.percentDiscount;}
    public int getFreeItemsAvailable(){ return this.freeItemsAvailable;}
  
}




