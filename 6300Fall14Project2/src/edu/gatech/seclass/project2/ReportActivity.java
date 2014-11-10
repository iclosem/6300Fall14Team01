package edu.gatech.seclass.project2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ReportActivity extends Activity implements OnClickListener {

	EditText rptDate, rptVIPID;
	Button btnSalesRpt, btnPreOrdRept, btnHistory, btn30Day;
	SQLiteDatabase db;
	//CustomersMySQLiteHelper dbCust;
	//PurchasesMySQLiteHelper db;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
	
		rptDate=(EditText)findViewById(R.id.editTextReportDate);
		rptVIPID=(EditText)findViewById(R.id.editTextRptVIPID);
		
		btnSalesRpt=(Button)findViewById(R.id.buttonSalesReport);
		btnPreOrdRept=(Button)findViewById(R.id.buttonDailyPreordersReport);
		btnHistory=(Button)findViewById(R.id.ButtonPurchaseHist);
		btn30Day=(Button)findViewById(R.id.Button30Day);
		
		btnSalesRpt.setOnClickListener(this);
		btnPreOrdRept.setOnClickListener(this);
		btnHistory.setOnClickListener(this);
		btn30Day.setOnClickListener(this);
		
//		   // purchases Table Columns names
//	    private static final String KEY_ID = "id";
//	    private static final String KEY_FLAVOR = "flavor";
//	    private static final String KEY_CATEGORY = "category";
//	    private static final String KEY_PURCHASETYPE = "purchasetype";
//	    private static final String KEY_PRICE = "price";
//	    private static final String KEY_DATE = "date";
//	    private static final String KEY_VIPID = "vipid";
		
	}
	
	@Override
	public void onClick(View view) 
	{
		db = openOrCreateDatabase("customersDB", 0, null);
		// set context
		Context context = this;
		// instantiate helper
		CustomersMySQLiteHelper dbhelp = new CustomersMySQLiteHelper(context);
		SQLiteDatabase db = dbhelp.getWritableDatabase();
		
		//db = openOrCreateDatabase("customersDB", 0, null);
		//dbCust = new CustomersMySQLiteHelper(getBaseContext());
		//dbPer = new PurchasesMySQLiteHelper(getBaseContext());
		
		
		
		if (view==btnSalesRpt)
		{
			if ((rptDate.getText().toString().trim().length()==0))
			{
				showMessage("Error!", "Enter Report Date");
			}
			Cursor c;
			
			try {
				c = db.rawQuery("SELECT * FROM purchases WHERE date='"
						+rptDate.getText()+"'", null);
//				c = db.rawQuery("SELECT * FROM purchases", null);
				} catch (Exception e) {
					showMessage("Exception!", "Table problem.");
					return;
				}
    		if(c.getCount()==0)
        	{
        		showMessage("Error", "No Sales found for this date");
        		return;
        	}
        	StringBuffer buffer=new StringBuffer();
        	while(c.moveToNext())
        	{
        		buffer.append("Date: "+c.getString(5)+"\n");
        		buffer.append("Transaction: "+c.getString(3)+"\n");
        		buffer.append("Flavor: "+c.getString(1)+"\n");
        		buffer.append("Amount: "+c.getString(4)+"\n\n");
        			
        	}
        	showMessage("Daily Sales for " +rptDate.getText(), buffer.toString());
    	}
		if (view==btnPreOrdRept)
		{
			if ((rptDate.getText().toString().trim().length()==0))
			{
				showMessage("Error!", "Enter Report Date");
			}
			
			Cursor c;
			try {
				c = db.rawQuery("SELECT * FROM purchases WHERE date='"
						+rptDate.getText()+"' AND purchasetype ='PREORDER'", null);
			} catch (Exception e) {
				showMessage("Exception!", "Table problem.");
    			return;
			}
    		if(c.getCount()==0)
        		{
        			showMessage("Error", "No Sales found for this date");
        			return;
        		}
        		StringBuffer buffer=new StringBuffer();
        		while(c.moveToNext())
        		{
        			buffer.append("Date: "+c.getString(5)+"\n");
        			buffer.append("Flavor: "+c.getString(1)+"\n");
        			buffer.append("Amount: "+c.getString(4)+"\n\n");
        			
        		}
        	showMessage("Daily Preorders for " +rptDate.getText(), buffer.toString());
    	}
		if (view==btnHistory)
		{
			Cursor c;
			try {
				c = db.rawQuery("SELECT * FROM purchases WHERE vipid='"
						+rptVIPID.getText()+"'", null);
			} catch (Exception e) {
				showMessage("Exception!", "Table problem.");
    			return;
			}
    		if(c.getCount()==0)
        	{
        		showMessage("Error", "No Sales found for this VIP ID");
        		return;
        	}
    		StringBuffer buffer=new StringBuffer();
    		while(c.moveToNext())
        		{
    			buffer.append("Date: "+c.getString(5)+"\n");
    			buffer.append("Flavor: "+c.getString(1)+"\n");
    			buffer.append("Amount: "+c.getString(4)+"\n\n");
        		
        		}
        	showMessage("Purchase history for VIP #" +rptVIPID.getText(), buffer.toString());
    	}
		if (view==btn30Day)
		{
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal2.add(Calendar.DATE, -31);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDate = format1.format(cal.getTime());
	        String formattedDate2 = format1.format(cal2.getTime());
						
			Cursor c;
			try {
				c = db.rawQuery("SELECT * FROM purchases WHERE date <='"+formattedDate+"' AND date>'"+formattedDate2+"'", null);
			} catch (Exception e) {
				showMessage("Exception!", "Table problem.");
    			return;
			}
    		if(c.getCount()==0)
        	{
        		showMessage("Error", "No Sales found for this date");
        		return;
        	}
        StringBuffer buffer=new StringBuffer();
        while(c.moveToNext())
        {
        	buffer.append("Date: "+c.getString(5)+"\n");
        	buffer.append("Flavor: "+c.getString(1)+"\n");
        	buffer.append("Amount: "+c.getString(4)+"\n\n");
        	
        }
        	showMessage("Daily Preorders for " +rptDate.getText(), buffer.toString());
    	}
		
	}
		
	public void showMessage(String title,String message)
    {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
	public void clearText()
    {
		rptDate.setText("");
		rptDate.requestFocus();
    }
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.report, menu);
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
