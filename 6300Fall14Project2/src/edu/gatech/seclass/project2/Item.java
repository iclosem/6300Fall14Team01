package edu.gatech.seclass.project2;

public abstract class Item {
    private String flavor;
    private double cost;
 
    public Item (String initFlavor, double initCost){
        this.flavor = initFlavor;
        this.cost = initCost;
    }
    //deduct current date slot
}

class IceCream extends Item {
    
    public IceCream(String initFlavor, double initCost){
        super (initFlavor, initCost);
    };
    //public int purchase(int custID){
        //this should log the purchase and the customer ID
    //};
}

class FrozenYogurt extends Item {
     private int dailyPreorderSlots;
    
    public FrozenYogurt(String initFlavor, double initCost){
        super(initFlavor,  initCost);
    };
    
    //public int purchase(int custID){
        //this should log the purchase and the customer ID
    //};
    //public int preorder(Date date, int vipID){
        //this should log the purchase and the preorder
        //return orderNumber;
    //};
    //public int cancelPreorder(int orderNumber, int vipID){
        //this should remove the entry from the database
    //};
    //function that consults database to show upcoming availability for next 7 days
    //public int[] preorderAvailability(){
    //if a date is uninitialized in the next 7 days, init it here
    //consults the data base for the next several days to see if a preorder is available.    
    //};
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


