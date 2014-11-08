package edu.gatech.seclass.project2;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.gatech.seclass.project2.Items;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SellActivity extends Activity {
	private ListView m_listview;
	private ListView m_listview2;
	private List<Item> cart = new ArrayList<Item>(); //stores the cart	
	private Customer curCust;
	
	private void executePurchase(String isPreorder){
		
		CustomersMySQLiteHelper dbCust;
		dbCust = new CustomersMySQLiteHelper(this);
		PurchasesMySQLiteHelper dbPer;
		dbPer = new PurchasesMySQLiteHelper(this);
		double totalPrice = 0;
		int totalPoints = 0;
		//needs to check for free items user has
		int freeItems = curCust.getFreeItemsAvailable();
		String sellText = "";
		for (Item item: this.cart){
			//branch removed yogurt if its a preorder
			if(isPreorder == "PREORDER "&& item.getCategory() == "FrozenYogurt"){
				sellText += "\nCanx "+ item.getFlavor()+": not preorderable";
			} else {
				//applying discount
				double price = item.getPrice() - (item.getPrice() * curCust.getPercentDiscount()); 
			    //adding new points 
				int points = (int)price; 
				totalPoints+=points;
				
				///creating date
				Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.DATE, 1);
		        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		        String formattedDate = format1.format(cal.getTime());
				
				curCust.awardPoints(points);//awards the ammount of points based on price
				if (freeItems >0){
					sellText += "\n FREE "+ item.getFlavor(); //adds to reciept
					curCust.creditFreeItem();
					price = 0;
					freeItems--;
				} else {
					sellText += "\n Purchased"+ item.getFlavor() + price; //adds to reciept
					totalPrice+= price;
				}
				Purchase curPurchase = new Purchase(item.getFlavor(), item.getCategory(), isPreorder, price, formattedDate, String.valueOf(curCust.getID()));
				dbPer.addPurchase(curPurchase);
			}
			dbCust.editCustomer(curCust);//adds the customers current record
			sellText += "\n Total:"+totalPrice + "Points:"+totalPoints;
			
		}
		Toast.makeText(getBaseContext(), "Purchase added:" + sellText, Toast.LENGTH_LONG).show();
		
	}
	
	
	private void updateCart(){
		EditText editText = (EditText)findViewById(R.id.editTextCartSell);
		String cartText = "" ;
		if (curCust != null){
			cartText = "Current Customer "+curCust.getName();	
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
		for(Item item: menuItems){
			itemStringList.add(item.getFlavor()+ "     "+String.valueOf(item.getPrice()));
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemStringList);

		m_listview.setAdapter(adapter);
		m_listview.setOnItemClickListener(new OnItemClickListener()
		{
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
		for(Customer cust: customerList){
			custStringList.add(cust.getName() + "	ID	" + String.valueOf(cust.getID()));
		}
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, custStringList);

		m_listview2.setAdapter(adapter2);
		m_listview2.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				curCust = customerList.get(position);
				updateCart();
			}
		});		
		
		///this section defines preorder
		Button clickPreOrderButton = (Button) findViewById(R.id.ButtonPreorderSell);
		clickPreOrderButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				executePurchase("PREORDER");
				
				
			}
		});
		///this section defines sells
		Button clickSellButton = (Button) findViewById(R.id.buttonPurchaseSell);
		clickPreOrderButton.setOnClickListener( new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				executePurchase("SALE");
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
}
