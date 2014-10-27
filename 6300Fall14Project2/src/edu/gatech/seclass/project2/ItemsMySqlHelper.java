package edu.gatech.seclass.project2;
import edu.gatech.seclass.project2.*;

import java.util.LinkedList;
import java.util.List;
  
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class ItemsMySQLiteHelper extends SQLiteOpenHelper {
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ItemsDB";
 
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION); 
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create items table
        String CREATE_ITEM_TABLE = "CREATE TABLE items ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "flavor TEXT, "+
                "categtory TEXT, "+ //yogurt or icecream
                "price TEXT )";
 
        // create item table
        db.execSQL(CREATE_ITEM_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older items table if existed
        db.execSQL("DROP TABLE IF EXISTS items");
 
        // create new table
        this.onCreate(db);
    }

    private static final String TABLE_ITEMS = "items";
 
    // Items Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FLAVOR = "flavor";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_PRICE = "price";
 
    private static final String[] COLUMNS = {KEY_ID,KEY_FLAVOR,KEY_CATEGORY, KEY_PRICE};
 
    public void addItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase(); //get reference to writable DB 
        ContentValues values = new ContentValues();
        values.put(KEY_FLAVOR, item.getFlavor()); 
        values.put(KEY_CATEGORY, item.getCategory()); 
        values.put(KEY_CATEGORY, item.getPrice()); 
        
 
        // 3. insert
        db.insert(TABLE_ITEMS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
 
        // 4. close
        db.close();
    }
 
    public Item getItem(int id){
 
        //get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();
 
        //build query
        Cursor cursor =
                db.query(TABLE_ITEMS, // a. table
                COLUMNS, // b. column names
                " id = ?", // c. selections
                new String[] { String.valueOf(id) }, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
 
        //if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();
 
        //build item object
        Item item = new Item();
        //ID Integer.parseInt(cursor.getString(0))); //ID
        //flavor (cursor.getString(0))); //Flavor
        //category (cursor.getString(2));   //Category
        //price Integer.parseInt(cursor.getString(3));     //Price
      
        return item;
    }
 
    public List<Item> getItems() {
        List<Item> items = new LinkedList<Item>();
 
        String query = "SELECT  * FROM " + TABLE_ITEMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        //go over each row, build item and add it to list
        Item item = null;
        if (cursor.moveToFirst()) {
            do {
                item = new Item();
                 //ID Integer.parseInt(cursor.getString(0))); //ID
                //flavor (cursor.getString(0))); //Flavor
                //category (cursor.getString(2));   //Category
                //price Integer.parseInt(cursor.getString(3));     //Price
    
                Item.add(item);
            } while (cursor.moveToNext());
        }
 
        // return items
        return items;
    }
 
    public void deleteItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(item.getId()) });
        db.close();
    }
}
