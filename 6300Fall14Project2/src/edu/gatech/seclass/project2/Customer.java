package edu.gatech.seclass.project2;

import java.util.Date;


public class Customer {
    private Date birthday;
    private String name;
    private String address;
    private int vipNumber;
    private int vipPointsTotal; //may want this to be a method to generate on the fly
    private boolean goldStatus;
    private Date goldStatusDate;
    private double percentDiscount;
    private int freeItemsAvailable;
    
    //this creates a new customer
    public Customer(Date initBirthday, String initName, String initAddress){
        //needs to assign unique VIP number...
        this.birthday = initBirthday;
        this.name = initName;
        this.address = initAddress;
        this.goldStatusDate = null;
        this.percentDiscount = 0;
        this.goldStatus = false;
        this.freeItemsAvailable = 0;
        //
        //save the customer to database
    }
    public Customer(int vipNumber){
        //loads the vip customer from the database
    };
    
    public int awardPoints(int numberOfPoints){
        this.vipPointsTotal+=numberOfPoints;///need to check for negative?
        //save the customer to database
        return this.vipPointsTotal;
    };
    
    public double getDiscount(){
        return this.percentDiscount;
    };
  
//     public String rewardsReport(){
         
//     };
    
//     public String[][] preorders(){
//         //returns a list of current preorders...json array?
//        
//     };
    public int removeCustomer(){
        //delete this customer from database
        return 0;
    };
}




