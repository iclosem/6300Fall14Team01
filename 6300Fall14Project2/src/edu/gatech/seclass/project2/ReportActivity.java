package edu.gatech.seclass.project2;

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

	EditText rptDate;
	Button btnSalesRpt, btnPreOrdRept;
	//SQLiteDatabase db;
	//CustomersMySQLiteHelper dbCust;
	PurchasesMySQLiteHelper db;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_report);
	
		rptDate=(EditText)findViewById(R.id.editTextReportDate);
		btnSalesRpt=(Button)findViewById(R.id.buttonSalesReport);
		btnPreOrdRept=(Button)findViewById(R.id.buttonSalesReport);
		
		btnSalesRpt.setOnClickListener(this);
		btnPreOrdRept.setOnClickListener(this);
		
		
		
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
		
		Context context = this;
		db=new PurchasesMySQLiteHelper(context);
		
		//db = openOrCreateDatabase("customersDB", 0, null);
		//dbCust = new CustomersMySQLiteHelper(getBaseContext());
		//dbPer = new PurchasesMySQLiteHelper(getBaseContext());
		
		
		if ((rptDate.getText().toString().trim().length()==0))
		{
			showMessage("Error!", "Enter Report Date");
		}
		if (view==btnSalesRpt)
		{
			SQLiteDatabase dbWrite = db.getWritableDatabase();
			Cursor c;
			
			try {
				c = dbWrite.rawQuery("SELECT * FROM purchases WHERE date='"
						+rptDate.getText()+"'", null);
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
			Cursor c;
			SQLiteDatabase dbWrite = db.getWritableDatabase();
			try {
				c = dbWrite.rawQuery("SELECT * FROM purchases WHERE date='"
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
