package edu.gatech.seclass.project2;
import edu.gatech.seclass.project2.Item;
import edu.gatech.seclass.project2.FrozenYogurt;
import edu.gatech.seclass.project2.IceCream;

public class Items {
	private Item[] inventory = {
    		new FrozenYogurt("Yologurt", 4.99),
    		new FrozenYogurt("Flogurt", 3.99),
    		new FrozenYogurt("Ketogurt", 4.99),
    		new FrozenYogurt("Pokegurt", 4.99),
    		new FrozenYogurt("Vapegurt", 4.99),
    		new IceCream("Tyranicesauras Rex", 4.99),
    		new IceCream("Bacon Deathstar", 4.99),
    		new IceCream("Mango Onion", 4.99),
    		new IceCream("Banana Corn Chowder", 4.99)
    };
	public Items(){
		
	}
	public Item[] inventory(){
      return this.inventory;
	}    
  //Statically initializing inventory
}
