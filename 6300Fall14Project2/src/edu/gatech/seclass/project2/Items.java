package edu.gatech.seclass.project2;

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