package edu.gatech.seclass.project2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;


//following testing methodology here
//http://stackoverflow.com/questions/8499554/android-junit-test-for-sqliteopenhelper
public class PurchasesMySQLiteHelperTest extends AndroidTestCase  {

	 private PurchasesMySQLiteHelper db;

	 public void setUp(){
		 RenamingDelegatingContext context = new RenamingDelegatingContext(getContext(), "test_");
		 db = new PurchasesMySQLiteHelper(context);
	 }

	 public void testAddEntry(){
		 
		 ///adding new purchases
		 Purchase newPurchase = new Purchase(	"SQLISELLTERRABLECREAM", 
				 								"YOGURT", 
				 								"PREORDER",
				 								12.12,
				 								"2015-12-12",
				 								"112");
		 db.addPurchase(newPurchase);
		 //retrieving list of purchases
		 List<Purchase> list = new ArrayList<Purchase>();
		 list = db.getPurchases();
		 Purchase pur = list.get(0);
		 for(Purchase purchase: list){
			 assertEquals("purchase created in DB", purchase.getCategory(), "YOGURT");
		 }
	 }
	 public void testRmEntry(){
		///adding new purchases
		 Purchase newPurchase = new Purchase(	"SQLISELLTERRABLECREAM", 
				 								"YOGURT", 
				 								"PREORDER",
				 								12.12,
				 								"2015-12-12",
				 								"112");
		 db.addPurchase(newPurchase);
		 //retrieving list of purchases
		 List<Purchase> list = new ArrayList<Purchase>();
		 list = db.getPurchases();
		 Purchase pur = list.get(0);
		 db.deletePurchase(pur);
		 list = db.getPurchases();
		 assertEquals("no purchases should be in list", list.size(), 0);
	 }
	 boolean isTableExisting(SQLiteDatabase db, String tableName)
	 {
	     if (tableName == null || db == null || !db.isOpen())
	     {
	         return false;
	     }
	     Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM sqlite_master WHERE type = ? AND name = ?", new String[] {"table", tableName});
	     if (!cursor.moveToFirst())
	     {
	         return false;
	     }
	     int count = cursor.getInt(0);
	     cursor.close();
	     return count > 0;
	 
	}
	public void testTableCreated(){
		
		assertEquals("Does table exist?", true, isTableExisting(db.getReadableDatabase(), "purchases"));
	}
	
	 public void tearDown() throws Exception{
		 db.close(); 
		 super.tearDown();
	 }
}
