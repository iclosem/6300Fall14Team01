package edu.gatech.seclass.project2;
import android.widget.ListView;
import java.util.ArrayList;
import edu.gatech.seclass.project2.Items;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SellActivity extends Activity {
	private ListView m_listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sell);
		
		
		//This section populates the flavor
		m_listview = (ListView) findViewById(R.id.listViewItemsSell);
		//String[] items = new String[] {};
		
		ArrayList<String> items = new ArrayList<String>();
		Items menu = new Items();
		Item[] menuItems = menu.inventory();
		for(Item item: menuItems){
			items.add(item.getFlavor()+ "     "+String.valueOf(item.getPrice()));
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

		m_listview.setAdapter(adapter);
//		m_listview.setOn.setOnItemClickListener(new OnItemClickListener())
//		{
//		     @Override
//		     public void onItemClick(AdapterView<?> a, View v,int position, long id) 
//		     {
//		          Toast.makeText(getBaseContext(), "Click", Toast.LENGTH_LONG).show();
//		      }
//		});
		
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
