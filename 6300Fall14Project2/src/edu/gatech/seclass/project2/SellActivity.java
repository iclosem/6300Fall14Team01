package edu.gatech.seclass.project2;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.gatech.seclass.project2.Items;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SellActivity extends Activity {
	private ListView m_listview;
	private ListView m_listview2;
	private List<Item> cart = new ArrayList<Item>(); //stores the cart	
	private Customer curCust;
	
	private void executePurchase() {
		if(cart.size() > 0){
			CustomersMySQLiteHelper dbCust = new CustomersMySQLiteHelper(this);
			PurchasesMySQLiteHelper dbPer = new PurchasesMySQLiteHelper(this);
			double totalPrice = 0;
			int totalPoints = 0;
			
			double discount = 0;
			String custSaleId = "-1";
			int freeItems = 0;
			
			if(curCust != null){
				monthlyFreebies();
				discount = curCust.getPercentDiscount();
				custSaleId = String.valueOf(curCust.getID());
				//needs to check for free items user has
				freeItems = curCust.getFreeItemsAvailable();
			}
			String sellText = "";
			for (Item item: this.cart){
				//applying discount
				double price = item.getPrice() * (1 - discount); 
				
				///creating date
				Calendar cal = Calendar.getInstance();
		        
		        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = format1.format(cal.getTime());
				
				if (freeItems > 0){
					sellText += "\n FREE "+ item.getFlavor(); //adds to receipt
					curCust.creditFreeItem();
					price = 0;
					freeItems--;
				} else {
					sellText += "\n Purchased: "+ item.getFlavor() +"\t\t $" + formatPrice(price); //adds to receipt
					totalPrice += price;
				}
				Purchase curPurchase = new Purchase(item.getFlavor(), item.getCategory(), "SALE", price, formattedDate, custSaleId);
				dbPer.addPurchase(curPurchase);
			}
			totalPrice = Math.floor(totalPrice * 100 ) / 100;
			int points = (int)(Math.floor(totalPrice));
			sellText = sellText + "\n Total: $" + formatPrice(totalPrice);

			if(curCust != null){
				curCust.awardPoints(points);
				dbCust.updateCustomer(curCust); 
				sellText = sellText + "\nPoints Awarded: " + points;
			}
			showMessage("Sale Made!", sellText);
			clearCart();
		} else {
			Toast.makeText(getBaseContext(), "Cart is empty", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	private void updateCart() {
		EditText editText = (EditText)findViewById(R.id.editTextCartSell);
		String cartText = "" ;
		if (curCust != null){
			cartText = "Current Customer " + curCust.getName();	
		}
		for (Item item: this.cart){
			cartText += "\n "+ item.getFlavor() + item.getPrice();
		}
		editText.setText(cartText);
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		CustomersMySQLiteHelper db;
		db = new CustomersMySQLiteHelper(this);
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		
		/////////////////////////////////////////////////////////////////////////////////
		//This section populates the flavors for sale
		m_listview = (ListView) findViewById(R.id.listViewItemsSell);
		
		ArrayList<String> itemStringList = new ArrayList<String>();
		Items menu = new Items();
		Item[] menuItems = menu.inventory();
		for(Item item: menuItems) {
			itemStringList.add(item.getFlavor() + "\t\t" + String.valueOf(item.getPrice()));
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemStringList);

		m_listview.setAdapter(adapter);
		m_listview.setOnItemClickListener(new OnItemClickListener() {
			Items menu = new Items();
			Item[] menuItems = menu.inventory();
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				cart.add(menuItems[position]);
				updateCart();
			}
		});		
		////////////////////////////////////////////////////////////////////////////////////
		
		m_listview2 = (ListView) findViewById(R.id.listCustomersSell);
		
		List<String> custStringList = new ArrayList<String>();
		final List<Customer> customerList = db.getCustomers();
		for(Customer cust: customerList) {
			custStringList.add(cust.getName());
		}
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, custStringList);

		m_listview2.setAdapter(adapter2);
		m_listview2.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				curCust = customerList.get(position);
				updateCart();
			}
		});		

		///this section defines sells
		Button clickSellButton = (Button) findViewById(R.id.buttonPurchaseSell);
		clickSellButton.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				executePurchase();
			}
		});
		
		///comment about clear button
		Button clickClearButton = (Button) findViewById(R.id.buttonClearCart);
		clickClearButton.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				clearCart();

				Toast.makeText(getBaseContext(), "Cart Cleared", Toast.LENGTH_SHORT).show();
			}
		});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sell, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void clearCart(){
		this.cart = new ArrayList<Item>();
		EditText editText = (EditText) findViewById( R.id.editTextCartSell);
		editText.setText("");
	}
	
	public void showMessage(String title, String message) {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
    public int monthlyFreebies(){

		PurchasesMySQLiteHelper dbPer = new PurchasesMySQLiteHelper(this);
    	int numToAward = 0;
    	
    	int vipId = this.curCust.getVIPNumber();
        List<Purchase> lastMonthPurchase;
        Purchase lastPurchase;
       
		try {
			lastMonthPurchase = dbPer.getLastMonthPurchases(String.valueOf(vipId));
	    	if(lastMonthPurchase.size() > 0){
	    		lastPurchase = dbPer.getLastPurchases(String.valueOf(vipId));
	    		Calendar cal = Calendar.getInstance();
	    		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    		Date lastPurchDate = format1.parse(lastPurchase.getDate());
	    		if(lastPurchDate.before(format1.parse(getLastLastMonthPurchase(lastMonthPurchase).getDate()))){
		    		if(this.curCust.getGoldStatusDate().compareTo("") != 0 && this.curCust.getGoldStatusDate().compareTo("null") != 0 && this.curCust.getGoldStatusDate() != null){
		    			numToAward++; 
		    		}
		    		double totalPurch = 0;
		    		for(Purchase purch: lastMonthPurchase){
		    			totalPurch += purch.getPrice();
		    		}
		    		
		    		if(totalPurch >= 50){
		    			numToAward++; 
		    		}
	    		}
	    	}
		} catch (Exception e) {
			showMessage("Exception!", "Table problem.");
			e.printStackTrace();
		}
    	return numToAward;
    }
    
    private String formatPrice(double price){
    	price = Math.floor(price * 100 ) / 100;
		String totalPriceStr = String.valueOf( price);
		if(totalPriceStr.charAt(totalPriceStr.length() - 3) != '.'){
			totalPriceStr += "0";
		}
		
		return totalPriceStr;
    }
    
    private Purchase getLastLastMonthPurchase(List<Purchase> lastMonthPurchase){
    	Purchase lastPurchase = lastMonthPurchase.get(0);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date lastPurchDate = format1.parse(lastPurchase.getDate());
	    	for(Purchase purch: lastMonthPurchase){
	    		if(lastPurchDate.after(format1.parse(purch.getDate()))){
	    			lastPurchDate = format1.parse(purch.getDate());
	    			lastPurchase = purch;
	    		}
	    	}
        } catch (ParseException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        }
    	return lastPurchase;
    }
//    private boolean purchase50LastMonth(){
//    }
}
