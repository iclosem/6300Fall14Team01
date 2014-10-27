package edu.gatech.seclass.project2;

public class Customer {
    private Date birthday;
    private String name;
    private String address;
    private int vipNumber;
    private int vipPointsTotal; //may want this to be a method to generate on the fly
    private bool goldStatus;
    private Date goldStautsDate;
    private double percentDiscount;
    private int freeItemsAvailable;
    
    //this creates a new customer
    public Customer(Date initBirthday, String initName, String initAddress){
        //needs to assign unique VIP number...
        this.birthday = initBirthday;
        this.name = initName;
        this.initAddress = initAddress;
        this.goldStautsDate = null;
        this.percentDiscount = 0;
        this.goldStauts = false;
        this.freeItemsAvailable = 0;
        //
        //save the customer to database
    }
    public Customer(int vipNumber){
        //loads the vip customer from the database
    }
    
    public awardPoints(int numberOfPoints){
        this.awardPoints+=numberOfPoints;///need to check for negative?
        //save the customer to database
        return this.awardPoints;
    }
    
    public int getDiscount(void){
        return this.percentDiscount;
    }
  
    public String rewardsReport(){
        
    }
    
    public String[][] preorders(){
        //returns a list of current preorders
    }
    public removeCustomer(){
        //delete this customer from database
    }
}

public class Customers {
    //loads the entire set of user ids and customer names for display
    //when selected, customer can be loaded by userID construtor
}


