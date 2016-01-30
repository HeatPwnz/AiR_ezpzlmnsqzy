package co.infinum.heat.air;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.heat.air.fragments.ListViewFragment;
import co.infinum.heat.air.fragments.RecyclerViewFragment;

public class MainActivity extends BaseActivity{

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager pager;

    private ArrayList<ListViewFragment> fragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initTabs();
        initFragmentList();
    }

    public void initFragmentList(){
        fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new ListViewFragment());
        //fragmentArrayList.add(new RecyclerViewFragment());

        pager.setCurrentItem(0);
    }

    public void initTabs(){
        tabLayout.addTab(tabLayout.newTab().setCustomView(inflateTabItem(R.drawable.tasks_tab_selector,R.string.my_rv_tab)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(inflateTabItem(R.drawable.tasks_tab_selector,R.string.my_lv_tab)));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private View inflateTabItem(int iconResourceId, int textResourceId) {
        LinearLayout tabItemLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.main_activity_tab_item, null);

        ImageView tabIcon = (ImageView) tabItemLayout.findViewById(R.id.main_activity_tab_icon);
        tabIcon.setImageResource(iconResourceId);

        TextView tabText = (TextView) tabItemLayout.findViewById(R.id.main_activity_tab_text);
        tabText.setText(textResourceId);

        return tabItemLayout;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
    /*
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }*/
}
