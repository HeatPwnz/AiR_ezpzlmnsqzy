package co.infinum.heat.air.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by hEAT- on 2.2.2016..
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragmentArrayList;

    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> arr) {
        super(fm);
        this.fragmentArrayList = arr;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList != null ? fragmentArrayList.get(position) : null;
    }

    @Override
    public int getCount() {
        return fragmentArrayList != null ? fragmentArrayList.size() : 0;
    }

}
