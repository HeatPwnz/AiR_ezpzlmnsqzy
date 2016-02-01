package co.infinum.heat.air;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.heat.air.fragments.ListViewFragment;
import co.infinum.heat.air.fragments.RecyclerViewFragment;
import co.infinum.heat.air.fragments.WeatherFragment;
import co.infinum.heat.air.helpers.CityPreference;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

    /*@Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager pager;*/

    private ArrayList<Fragment> fragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //ButterKnife.bind(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new WeatherFragment())
                    .commit();
        }

        //initTabs();
        //initFragmentList();
    }

    /*public void initFragmentList(){
        fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new ListViewFragment());
        //fragmentArrayList.add(new RecyclerViewFragment());
        fragmentArrayList.add(new WeatherFragment());

        //pager.setCurrentItem(0);
    }*/
    /*
    public void initTabs(){
        tabLayout.addTab(tabLayout.newTab().setCustomView(inflateTabItem(R.drawable.tasks_tab_selector,R.string.my_rv_tab)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(inflateTabItem(R.drawable.tasks_tab_selector,R.string.my_lv_tab)));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }*/

    private View inflateTabItem(int iconResourceId, int textResourceId) {
        LinearLayout tabItemLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.main_activity_tab_item, null);

        ImageView tabIcon = (ImageView) tabItemLayout.findViewById(R.id.main_activity_tab_icon);
        tabIcon.setImageResource(iconResourceId);

        TextView tabText = (TextView) tabItemLayout.findViewById(R.id.main_activity_tab_text);
        tabText.setText(textResourceId);

        return tabItemLayout;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.change_city){
            showInputDialog();
        }
        return false;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        //pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void showInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change city");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void changeCity(String city){
        WeatherFragment wf = (WeatherFragment)getSupportFragmentManager()
                .findFragmentById(R.id.container);
        wf.changeCity(city);
        new CityPreference(this).setCity(city);
    }
}
