package edu.gatech.seclass.project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;

public class MainActivity extends Activity {
	   	 
	// Tab titles
	private String[] tabs = { "Sell", "Preorder", "VIPS", "Report", "Create" };
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void startNewActivity(Class activityClass ){	

		Intent intent = new Intent(this, activityClass);
		startActivity(intent);
	}

	public void handleMenuSelection(View view){
				
		switch(view.getId()){
		case R.id.buttonSalesReport:
			startNewActivity( CreateActivity.class);
			break;
		case R.id.buttonDailyPreordersReport:
			startNewActivity(VIPActivity.class);
			break;
		case R.id.button3:
			startNewActivity(SellActivity.class);
			break;
		case R.id.button4:
			startNewActivity(PreorderActivity.class);
			break;
		case R.id.button5:
			startNewActivity(ReportActivity.class);
			break;
			
		}
	}
	

}
