package edu.gatech.seclass.project2;

import android.app.Activity;
import android.app.AlertDialog.Builder;
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
	
	public void handleClick( View view) {
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
					!txtDob.getText().toString().matches("")) {

		    		Customer newCust = new Customer(txtName.getText().toString(), txtAddr.getText().toString(), 
						txtDob.getText().toString() );
		    		// addCustomer now returns the primary key value
		    		long id = dbhelp.addCustomer(newCust);
		    		//TODO also add the new cust's name to a field
		    		txtVipNum.setText(String.valueOf(id));
		    		clearText();

		    } else {
				showMessage("Error!","Please Enter all data fields");
			}
		}catch(Exception e){
			showMessage("Error!","An error occurred.");
		}
		
	}
	
	public void clearText() {
		((EditText) findViewById(R.id.EditTextName)).setText("");
		((EditText) findViewById(R.id.EditTextAddress)).setText("");
		((EditText) findViewById(R.id.EditTextDOB)).setText("");
		findViewById(R.id.NewCreatedVIPNum).requestFocus();
    }
	
	public void showMessage(String title,String message) {
    	Builder builder=new Builder(this);
    	builder.setCancelable(true);
    	builder.setTitle(title);
    	builder.setMessage(message);
    	builder.show();
	}
}
