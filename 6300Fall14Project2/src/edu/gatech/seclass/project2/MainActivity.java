package edu.gatech.seclass.project2;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.TabListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements android.app.ActionBar.TabListener {
	   	 
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private android.app.ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "Sell", "Preorder", "VIPS", "Report", "Create" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	
	    // Initilization
	    viewPager = (ViewPager) findViewById(R.id.pager);
	    actionBar = this.getActionBar();
	    mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
	
	    viewPager.setAdapter(mAdapter);
	    actionBar.setHomeButtonEnabled(false);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
	
	    // Adding Tabs
	    for (String tab_name : tabs) {
	        actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
	    }
	
	    /**
	     * on swiping the viewpager make respective tab selected
	     * */
	    viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
	
	        @Override
	        public void onPageSelected(int position) {
	            // on changing the page
	            // make respected tab selected
	            actionBar.setSelectedNavigationItem(position);
	        }
	
	        @Override
	        public void onPageScrolled(int arg0, float arg1, int arg2) {
	        }
	
	        @Override
	        public void onPageScrollStateChanged(int arg0) {
	        }
	    });
	}

	@Override
	public void onTabSelected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction ft) {
		 // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabReselected(android.app.ActionBar.Tab tab,
			android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	

}
