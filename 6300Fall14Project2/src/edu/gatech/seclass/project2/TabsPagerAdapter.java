package edu.gatech.seclass.project2;
import edu.gatech.seclass.project2.SellFragment;
import edu.gatech.seclass.project2.PreorderFragment;
import edu.gatech.seclass.project2.VIPFragment;
import edu.gatech.seclass.project2.ReportFragment;
import edu.gatech.seclass.project2.EditFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 
    @Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            // sell fragment activity
            return new SellFragment();
        case 1:
            // preorder fragment activity
            return new PreorderFragment();
        case 2:
            // VIP fragment activity
            return new VIPFragment();
        case 3:
            // VIP fragment activity
            return new ReportFragment();
        case 4:
            // VIP fragment activity
            return new EditFragment();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }
 
}