package edu.gatech.seclass.project2;

public class Item {
    private string flavor;
    private double cost;
 
    public Item (string initFlavor, double initCost){
        this.flavor = initFlavor;
        this.cost = initCost;
    }
    //deduct current date slot
}

public class IceCream extends Item {
    
    public IceCream(string initFlavor, double initCost){
        super (string initFlavor, double initCost)
    };
     public int purchase(int custID){
        //this should log the purchase and the customer ID
    };
}

public class FrozenYogurt extends Item {
     private int dailyPreorderSlots;
    
    public FrozenYogurt(string initFlavor, double initCost){
        super(string initFlavor, double initCost)
    };
    public int purchase(int custID){
        //this should log the purchase and the customer ID
    };
    public FrozenYogurt(string initFlavor, double initCost){
        super(string initFlavor, double initCost)
    };
    public int preorder(Date date, int vipID){
        //this should log the purchase and the preorder
    };
    public int cancelPreorder(int orderNumber, int vipID){
        //this should remove the entry from the database
    };
    //function that consults database to show upcoming availability for next 7 days
    public int[] preorderAvailability(){
    //if a date is uninitialized in the next 7 days, init it here
    //consults the data base for the next several days to see if a preorder is available.    
    };
}

public class Items {
    prvate Items[] inventory;
    public Items(items[]){
        FrozenYogurt yogurt1 = new FrozenYogurt('Yologurt', 4.99);
        FrozenYogurt yogurt2 = new FrozenYogurt('Flogurt', 3.99);
        FrozenYogurt yogurt3 = new FrozenYogurt('Ketogurt', 4.99);
        FrozenYogurt yogurt4 = new FrozenYogurt('Pokegurt', 4.99);
        FrozenYogurt yogurt5 = new FrozenYogurt('Vapegurt', 4.99);
        IceCreamSale icecream1 = new IceCream('Tyranicesauras Rex', 4.99);
        IceCreamSale icecream2 = new IceCream('Bacon Deathstar', 4.99);
        IceCreamSale icecream3 = new IceCream('Mango Onion', 4.99);
        IceCreamSale icecream4 = new IceCream('Banana Corn Chowder', 4.99);
        this.inventory = [yogurt1, yogurt2, yogurt3, yogurt4, yogurt5, icecream1, icecream2, icecream3, icecream4]; 
    }
    public Item[] inventory(){
        return this.inventory;
    }    
    //Statically initializing inventory
   
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


