package edu.gatech.seclass.project2;


public abstract class Item {
    private String flavor;
    private int ID;
    private double cost;
    private String category;//yogurt or icecream 
  
    public Item (String initFlavor, double initCost, String category){
        this.flavor = initFlavor;
        this.cost = initCost;
    }
    
    public String getFlavor(){
        return this.flavor;
    }
    public String getCategory(){
        return this.category;
    }
    public double getPrice(){
        return this.cost;
    }
    public int getID(){
        return this.ID;
    }
    public int setID(int initID){
        return this.ID = initID;
    }
    //deduct current date slot
}

class IceCream extends Item {
    
    public IceCream(String initFlavor, double initCost){
        super (initFlavor, initCost, "IceCream");
    };
    //public int purchase(int custID){
        //this should log the purchase and the customer ID in the DB
    //};
}

class FrozenYogurt extends Item {
    
    
    private int dailyPreorderSlots = 30; //used to check against database (subtract all other preorders for the day in question)
    
    public FrozenYogurt(String initFlavor, double initCost){
        super(initFlavor,  initCost, "FrozenYogurt");
    };
    
    //public int purchase(int custID){
        //this should log the purchase and the customer ID in the DB
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
    //
    //should consult database for all preorders within next 7 days and subtract each from dailyPreorderSlots since we can hard code that number
    //};
}

// package edu.gatech.seclass.project2;

// public class Items {
//     prvate Items[] inventory;
//     public Items(items[]){
//         FrozenYogurt yogurt1 = new FrozenYogurt('Yologurt', 4.99);
//         FrozenYogurt yogurt2 = new FrozenYogurt('Flogurt', 3.99);
//         FrozenYogurt yogurt3 = new FrozenYogurt('Ketogurt', 4.99);
//         FrozenYogurt yogurt4 = new FrozenYogurt('Pokegurt', 4.99);
//         FrozenYogurt yogurt5 = new FrozenYogurt('Vapegurt', 4.99);
//         IceCreamSale icecream1 = new IceCream('Tyranicesauras Rex', 4.99);
//         IceCreamSale icecream2 = new IceCream('Bacon Deathstar', 4.99);
//         IceCreamSale icecream3 = new IceCream('Mango Onion', 4.99);
//         IceCreamSale icecream4 = new IceCream('Banana Corn Chowder', 4.99);
//         this.inventory = [yogurt1, yogurt2, yogurt3, yogurt4, yogurt5, icecream1, icecream2, icecream3, icecream4]; 
//     }
//     public Item[] inventory(){
//         return this.inventory;
//     }    
//     //Statically initializing inventory
   
// }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


