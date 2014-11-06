package edu.gatech.seclass.project2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateActivity extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
		
	}
	
	public void handleClick(View view){
		// set context
		Context context = this;
		// instantiate helper
		CustomersMySQLiteHelper dbhelp = new CustomersMySQLiteHelper(context);
		
		EditText txtName = (EditText) findViewById(R.id.EditTextName);
		EditText txtAddr = (EditText) findViewById(R.id.EditTextAddress);
		EditText txtDob = (EditText) findViewById(R.id.EditTextDOB);
		TextView txtVipNum = (TextView) findViewById(R.id.NewCreatedVIPNum);
		try{
			if(!txtName.getText().toString().matches("") && !txtAddr.getText().toString().matches("") && 
					!txtDob.getText().toString().matches(""))
			{
				Customer newCust = new Customer(txtName.getText().toString(), txtAddr.getText().toString(), 
						txtDob.getText().toString() );
				// addCustomer now returns the primary key value
				long id = dbhelp.addCustomer(newCust);
				txtVipNum.setText(String.valueOf(id));
			}
			else
			{
				txtVipNum.setText("Wrong");
			}
		}catch(Exception e){
			txtVipNum.setText("FAILED");
		}
		
	}
}
