package edu.gatech.seclass.project2;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;

public class VIPActivity extends Activity implements OnClickListener {
	EditText vipId, vipName, address, dob, vipPointsTotal, goldStatusDate, 
			percentDiscount, freeItemsAvailable ;
	Button btnRetrieve, btnSave, btnDelete, btnList;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vip);
		
		vipId=(EditText)findViewById(R.id.editTextFindVIPID);
		vipName=(EditText)findViewById(R.id.editTextVIPName);
		address=(EditText)findViewById(R.id.editTextAddress);
		dob=(EditText)findViewById(R.id.editTextDOB);
		vipPointsTotal= (EditText)findViewById(R.id.editTextVIPPts); 
	    goldStatusDate= (EditText)findViewById(R.id.editTextGoldDate); 
	    percentDiscount= (EditText)findViewById(R.id.editTextPercent);   
	    freeItemsAvailable= (EditText)findViewById(R.id.editTextFreebies);
		
		
		btnRetrieve=(Button)findViewById(R.id.ButtonVIPRetrieve);
		btnSave=(Button)findViewById(R.id.ButtonSaveVIP);
		btnDelete=(Button)findViewById(R.id.ButtonIPDelete);
		btnList=(Button)findViewById(R.id.buttonList);
		
		btnRetrieve.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		btnList.setOnClickListener(this);
		
		
	}

	public void onClick(View view)
	{
		// set context
		Context context = this;
		// instantiate helper
		CustomersMySQLiteHelper dbhelp = new CustomersMySQLiteHelper(context);
		SQLiteDatabase db = dbhelp.getWritableDatabase();
		
		if ((view!=btnList) && (vipId.getText().toString().trim().length()==0))
		{
			showMessage("Error!", "Enter VIP ID");
		}
		if (view==btnRetrieve)
		{
			Cursor c=db.rawQuery("SELECT * FROM customers WHERE id='"
					+vipId.getText()+"'", null);
    		if(c.moveToFirst())
    		{
    			vipName.setText(c.getString(1));
    			address.setText(c.getString(2));
    			dob.setText(c.getString(3));
    			vipPointsTotal.setText(c.getString(4));
    			goldStatusDate.setText(c.getString(5));
    			percentDiscount.setText(c.getString(6));
    			freeItemsAvailable.setText(c.getString(7));
    		}
		}
		if (view==btnSave)
		{
			db.execSQL("UPDATE customers SET name ='"
					+vipName.getText()+"',address='"+address.getText()+"',birthday='"
					+dob.getText()+"',vippointstotal='"+vipPointsTotal.getText()+"',goldstatusdate= '"
					+goldStatusDate.getText()+"', percentdiscount='"+percentDiscount.getText()+"', freeitemsavailable='"
					+freeItemsAvailable.getText()+"' WHERE id='"+vipId.getText()+"'");
    		// clearText();
			showMessage("Success", "Record Updated");
    			
    	}
		if (view==btnDelete)
		{
			db.execSQL("DELETE FROM customers WHERE id='"+vipId.getText()+"'");
					
			clearText();
			showMessage("Success", "Record Deleted"); 
		}
		if (view==btnList)
		{
			
			Cursor c=db.rawQuery("SELECT * FROM customers", null);
    		if(c.getCount()==0)
    		{
    			showMessage("Error", "No VIP records found");
    			return;
    		}
    		StringBuffer buffer=new StringBuffer();
    		while(c.moveToNext())
    		{
    			buffer.append("VIP ID: "+c.getString(0)+"\n");
    			buffer.append("Name: "+c.getString(1)+"\n");
    			buffer.append("Address: "+c.getString(2)+"\n");
    			buffer.append("DOB: "+c.getString(3)+"\n");
    			buffer.append("VIP Points: "+c.getString(4)+"\n");
    			buffer.append("Gold Date: "+c.getString(5)+"\n");
    			buffer.append("Discount: "+c.getString(6)+"\n");
    			buffer.append("Freebies: "+c.getString(7)+"\n\n");
    		}
    		showMessage("VIP Records", buffer.toString());
		}
	}
		
		
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vi, menu);
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
		vipId.setText("");
		vipName.setText("");
		address.setText("");
		dob.setText("");
		vipPointsTotal.setText("");
		goldStatusDate.setText("");
		percentDiscount.setText("");
		freeItemsAvailable.setText("");
		vipId.requestFocus();
    }















	
}
