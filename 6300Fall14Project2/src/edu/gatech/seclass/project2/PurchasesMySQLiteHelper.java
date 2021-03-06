package edu.gatech.seclass.project2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.gatech.seclass.project2.Purchase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


//date help here
//http://stackoverflow.com/questions/1081234/java-date-insert-into-database

public class PurchasesMySQLiteHelper extends SQLiteOpenHelper{
	   // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "customersDB";
 
    public PurchasesMySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); 
        
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create Customers table
        String CREATE_CUSTOMERS_TABLE = "CREATE TABLE customers ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " + //this will be the VIP ID
                "name TEXT, "+ 
                "birthday TEXT, "+
                "address TEXT, "+ //customer or preorder
                "vippointstotal TEXT, "+
                "goldstatusdate TEXT, "+
                "percentdiscount TEXT, "+
                "freeitemsavailable TEXT )";
 
        // create customers table
        db.execSQL(CREATE_CUSTOMERS_TABLE);
        
        String CREATE_PURCHASES_TABLE = "CREATE TABLE purchases ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "flavor TEXT, "+
                "category TEXT, "+ //yogurt or icecream
                "purchasetype TEXT, "+ //purchase or preorder
                "price TEXT, "+
                "date TEXT, "+
                "vipid TEXT )";
 
        // create purchases table
        
        db.execSQL(CREATE_PURCHASES_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS purchases");
        // create fresh purchases table
        this.onCreate(db);
    }
     
    private static final String TABLE_PURCHASES = "purchases";
 
    // purchases Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FLAVOR = "flavor";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_PURCHASETYPE = "purchasetype";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DATE = "date";
    private static final String KEY_VIPID = "vipid";
    
    private static final String[] COLUMNS = {KEY_ID,KEY_FLAVOR, KEY_CATEGORY, KEY_PURCHASETYPE, KEY_PRICE, KEY_DATE, KEY_VIPID};
     
    public void addPurchase(Purchase purchase){
        SQLiteDatabase db = this.getWritableDatabase(); //get reference to writable DB 
        ContentValues values = new ContentValues();
        values.put(KEY_FLAVOR, purchase.getFlavor()); 
        values.put(KEY_CATEGORY, purchase.getCategory()); 
        values.put(KEY_PURCHASETYPE, purchase.getPurchaseType()); 
        values.put(KEY_PRICE, purchase.getPrice());
        values.put(KEY_DATE, purchase.getDate());
        values.put(KEY_VIPID, purchase.getVIPID());
        // 3. insert
        db.insert(TABLE_PURCHASES, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close();
    }

    public List<Purchase> getPurchases() {
        List<Purchase> purchases = new LinkedList<Purchase>();
 
        String query = "SELECT  * FROM " + TABLE_PURCHASES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        //go over each row, build item and add it to list
        Purchase purchase = null;
        if (cursor.moveToFirst()) {
            do {
                int ID = Integer.parseInt(cursor.getString(0));
                String flavor = cursor.getString(1);
                String category = cursor.getString(2);
                String purchaseType = cursor.getString(3);
                Double price = Double.parseDouble(cursor.getString(4));
                String date = cursor.getString(5);
                String vipid= cursor.getString(6);
            	
                purchase = new Purchase(flavor, category, purchaseType, price, date, vipid);
                purchase.setID(ID);
    
                purchases.add(purchase);
            } while (cursor.moveToNext());
        }
 
        // return purchases
        return purchases;
    }
    


    public List<Purchase> getLast30DaysPurchases(String vipId) throws ParseException {
        List<Purchase> purchases = new LinkedList<Purchase>();

    	Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = format1.format(cal.getTime());
        Date startDate = format1.parse(formattedDate);
        
        String query = "SELECT  * FROM " + TABLE_PURCHASES + " WHERE vipid='"
				+ vipId + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        //go over each row, build item and add it to list
        Purchase purchase = null;
        if (cursor.moveToFirst()) {
            do {
                int ID = Integer.parseInt(cursor.getString(0));
                String flavor = cursor.getString(1);
                String category = cursor.getString(2);
                String purchaseType = cursor.getString(3);
                Double price = Double.parseDouble(cursor.getString(4));
                String date = cursor.getString(5);
                String vipid= cursor.getString(6);
            	if(startDate.before(format1.parse(date) )){
	                purchase = new Purchase(flavor, category, purchaseType, price, date, vipid);
	                purchase.setID(ID);
	    
	                purchases.add(purchase);
            	}
            } while (cursor.moveToNext());
        }
 
        // return purchases
        return purchases;
    }
    public List<Purchase> getLastMonthPurchases(String vipId) throws ParseException {
        List<Purchase> purchases = new LinkedList<Purchase>();

    	Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -30);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = format1.format(cal.getTime());
        Date startDate = format1.parse(formattedDate);
        cal.add(Calendar.MONTH, 1);
        Date endDate = format1.parse(formattedDate);
        
        
        String query = "SELECT  * FROM " + TABLE_PURCHASES + " WHERE vipid='"
				+ vipId + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        //go over each row, build item and add it to list
        Purchase purchase = null;
        if (cursor.moveToFirst()) {
            do {
                int ID = Integer.parseInt(cursor.getString(0));
                String flavor = cursor.getString(1);
                String category = cursor.getString(2);
                String purchaseType = cursor.getString(3);
                Double price = Double.parseDouble(cursor.getString(4));
                String date = cursor.getString(5);
                String vipid= cursor.getString(6);
            	if(startDate.before(format1.parse(date) ) && endDate.after(format1.parse(date))){
	                purchase = new Purchase(flavor, category, purchaseType, price, date, vipid);
	                purchase.setID(ID);
	    
	                purchases.add(purchase);
            	}
            } while (cursor.moveToNext());
        }
 
        // return purchases
        return purchases;
    }
    public Purchase getLastPurchases(String vipId) throws ParseException {

    	Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -80);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = format1.format(cal.getTime());
        Date startDate = format1.parse(formattedDate);
        
        String query = "SELECT  * FROM " + TABLE_PURCHASES + " WHERE vipid='"
				+ vipId + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        //go over each row, build item and add it to list
        Purchase purchase = null;
        if (cursor.moveToFirst()) {
            do {
            	String date = cursor.getString(5);
            	if(startDate.before(format1.parse(date) )){
	                int ID = Integer.parseInt(cursor.getString(0));
	                String flavor = cursor.getString(1);
	                String category = cursor.getString(2);
	                String purchaseType = cursor.getString(3);
	                Double price = Double.parseDouble(cursor.getString(4));
	                String vipid= cursor.getString(6);
	                purchase = new Purchase(flavor, category, purchaseType, price, date, vipid);
	                purchase.setID(ID);
	                startDate = format1.parse(date);
            	}
            } while (cursor.moveToNext());
        }

        // return purchases
        return purchase;
    }
    public void deletePurchase(Purchase purchase) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PURCHASES,
                KEY_ID+" = ?",
                new String[] { String.valueOf(purchase.getID()) });
        db.close();
    }
   
}
