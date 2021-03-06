package edu.gatech.seclass.project2;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Purchase {
    private int id;
    private String flavor;
    private String category;//yogurt or icecream 
    private String purchaseType;//preorder or sale
    private double price;
    private String date;
    private String vipid;
    private boolean freebie; //if it was a freebie or not
    
    //constructor for other classes
    public Purchase(String initFlavor, 
    				String initCategory, 
    				String initPurchaseType, 
    				double initPrice,  
    				String initDate,
    				String initVIPID){     
        this.flavor = initFlavor;
        this.category = initCategory;
        this.purchaseType = initPurchaseType;
        this.price = initPrice;
        this.vipid = initVIPID;
        this.date = initDate;
    }

    
    public int setID(int initID){
        return this.id = initID;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getFlavor(){
        return this.flavor;
    }
    
    public String getCategory(){
        return this.category;
    }//yogurt or icecream 
    
    public String getPurchaseType(){
        return this.purchaseType;
    }
    
    public double getPrice(){
        return this.price;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public String getVIPID(){
        return this.vipid;
    }
}
