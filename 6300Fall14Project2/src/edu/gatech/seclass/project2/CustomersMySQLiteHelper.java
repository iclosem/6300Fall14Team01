package edu.gatech.seclass.project2;
import java.util.LinkedList;
import java.util.List;

import edu.gatech.seclass.project2.Customer;
import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


//date help here
//http://stackoverflow.com/questions/1081234/java-date-insert-into-database

public class CustomersMySQLiteHelper extends SQLiteOpenHelper{
	   // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "customersDB";
 
    public CustomersMySQLiteHelper(Context context) {
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
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS customers");
        // create fresh customers table
        this.onCreate(db);
    }
     
    private static final String TABLE_CUSTOMERS = "customers";
 
    // customers Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BIRTHDAY = "birthday";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_VIPPOINTSTOTAL = "vippointstotal";
    private static final String KEY_GOLDSTATUSDATE = "goldstatusdate";
    private static final String KEY_PERCENTDISCOUNT = "percentdiscount";
    private static final String KEY_FREEITEMSAVAILABLE = "freeitemsavailable";
    
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME, KEY_BIRTHDAY, KEY_ADDRESS, KEY_VIPPOINTSTOTAL, KEY_GOLDSTATUSDATE, KEY_PERCENTDISCOUNT, KEY_FREEITEMSAVAILABLE};
     
    public long addCustomer(Customer customer){
        SQLiteDatabase db = this.getWritableDatabase(); //get reference to writable DB 
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, customer.getName()); 
        values.put(KEY_BIRTHDAY, customer.getBirthday()); 
        values.put(KEY_ADDRESS, customer.getAddress()); 
        values.put(KEY_VIPPOINTSTOTAL, customer.getVIPPointsTotal());
        values.put(KEY_GOLDSTATUSDATE, customer.getGoldStatusDate());
        values.put(KEY_PERCENTDISCOUNT, customer.getPercentDiscount());
        values.put(KEY_FREEITEMSAVAILABLE, customer.getFreeItemsAvailable()); 
        System.out.println(values); //goes to logcat
        // Changed below to add return of ID when adding customer - Charles
        long id = db.insert(TABLE_CUSTOMERS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 

        db.close();
        return id;
    }

    public List<Customer> getCustomers() {
        List<Customer> customers = new LinkedList<Customer>();
 
        String query = "SELECT  * FROM " + TABLE_CUSTOMERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        //go over each row, build item and add it to list
        Customer customer = null;
        if (cursor.moveToFirst()) {
            do {
                
                int ID = Integer.parseInt((cursor.getString(0)));
                String name = cursor.getString(1);
                String birthday = cursor.getString(2);
                String address = cursor.getString(3);
                int vippointstotal = Integer.parseInt((cursor.getString(4)));
                String goldstatusdate = cursor.getString(5);
                Double discount = Double.parseDouble(cursor.getString(6));
                int freeitemsavailable = Integer.parseInt(cursor.getString(7));
                customer = new Customer(ID, name, birthday, address, vippointstotal, goldstatusdate, discount, freeitemsavailable);
              
    
                customers.add(customer);
            } while (cursor.moveToNext());
        }
 
        // return customers
        return customers;
    }
    
    //this function will increment all gold customers freeitemsavailable by one
    public void giveGoldFreebie(){
        
    }
  	  
    public void deleteCustomer(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CUSTOMERS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(customer.getID()) });
        db.close();
    }
    
    public void updateCustomer (Customer customer){
        SQLiteDatabase db = this.getWritableDatabase();
    	db.execSQL("UPDATE customers SET name ='"
				+ customer.getName() + "',address='" + customer.getAddress() + "',birthday='"
				+ customer.getBirthday() +"',vippointstotal='" + customer.getVIPPointsTotal() + "',goldstatusdate= '"
				+ customer.getGoldStatusDate() + "', percentdiscount='" + customer.getPercentDiscount() + "', freeitemsavailable='"
				+ customer.getFreeItemsAvailable()  + "' WHERE id='" + customer.getID() + "'");

    }
}
