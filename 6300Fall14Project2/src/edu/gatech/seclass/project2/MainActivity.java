package edu.gatech.seclass.project2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
		tabHost.setup();
		//this video explains the process i used here...more or less
		//https://www.youtube.com/watch?v=irDdBxamuZs 
		TabHost.TabSpec tabSpec = tabHost.newTabSpec("sell");
		tabSpec.setContent(R.id.sellTab);
		tabSpec.setIndicator("Sell");
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("preorder");
		tabSpec.setContent(R.id.preorderTab);
		tabSpec.setIndicator("Preorder");
		tabHost.addTab(tabSpec);
	
		tabSpec = tabHost.newTabSpec("vips");
		tabSpec.setContent(R.id.vipsTab);
		tabSpec.setIndicator("VIPS");
		tabHost.addTab(tabSpec);

		
		tabSpec = tabHost.newTabSpec("report");
		tabSpec.setContent(R.id.reportTab);
		tabSpec.setIndicator("Report");
		tabHost.addTab(tabSpec);
	
		
		tabSpec = tabHost.newTabSpec("create");
		tabSpec.setContent(R.id.createTab);
		tabSpec.setIndicator("Create");
		tabHost.addTab(tabSpec);

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
