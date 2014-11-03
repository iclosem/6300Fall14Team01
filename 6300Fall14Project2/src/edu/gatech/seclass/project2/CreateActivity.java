package edu.gatech.seclass.project2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create, menu);
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
	
	public void handleClick(View view){

		EditText txtName = (EditText) findViewById(R.id.EditTextName);
		EditText txtAddr = (EditText) findViewById(R.id.EditTextAddress);
		EditText txtDob = (EditText) findViewById(R.id.EditTextDOB);
		if(!txtName.getText().toString().matches("") && !txtAddr.getText().toString().matches("") && !txtDob.getText().toString().matches("")){
			Customer newCust = new Customer(txtName.getText().toString(), txtAddr.getText().toString(), txtDob.getText().toString() );
			EditText txtVipNum = (EditText) findViewById(R.id.NewCreatedVIPNum);
			txtVipNum.setText(newCust.getVIPNumber());
		}
	}
}
