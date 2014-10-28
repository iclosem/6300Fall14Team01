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
}

class IceCream extends Item {
    public IceCream(String initFlavor, double initCost){
        super (initFlavor, initCost, "IceCream");
    };
}

class FrozenYogurt extends Item {
    public FrozenYogurt(String initFlavor, double initCost){
        super(initFlavor,  initCost, "FrozenYogurt");
    };
}
    
    
    


