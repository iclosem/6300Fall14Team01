package edu.gatech.seclass.project2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);
	}
	
	public void handleClick(View view){

		EditText txtName = (EditText) findViewById(R.id.EditTextName);
		EditText txtAddr = (EditText) findViewById(R.id.EditTextAddress);
		EditText txtDob = (EditText) findViewById(R.id.EditTextDOB);
		EditText txtVipNum = (EditText) findViewById(R.id.NewCreatedVIPNum);
		try{
			if(!txtName.getText().toString().matches("") && !txtAddr.getText().toString().matches("") && !txtDob.getText().toString().matches("")){
				Customer newCust = new Customer(txtName.getText().toString(), txtAddr.getText().toString(), txtDob.getText().toString() );
				txtVipNum.setText(newCust.getVIPNumber());
			}else{
				txtVipNum.setText("Wrong");
			}
		}catch(Exception e){
			txtVipNum.setText("FAIL");
		}
		
	}
}
