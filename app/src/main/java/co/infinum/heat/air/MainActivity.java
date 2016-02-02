package co.infinum.heat.air;

import android.content.DialogInterface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.heat.air.adapters.ViewPagerAdapter;
import co.infinum.heat.air.fragments.RecyclerViewFragment;
import co.infinum.heat.air.fragments.WeatherFragment;
import co.infinum.heat.air.helpers.CityPreference;

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.viewPager)
    ViewPager pager;

    private ArrayList<Fragment> fragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FlowManager.init(this);
        /*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new WeatherFragment())
                    .commit();
        }*/

        initTabs();
        initFragmentList();

        final PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentArrayList);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(this);

        pager.setCurrentItem(0);
    }

    public void initFragmentList(){
        fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new RecyclerViewFragment());
        fragmentArrayList.add(new WeatherFragment());
    }

    public void initTabs(){
        tabLayout.addTab(tabLayout.newTab().setCustomView(inflateTabItem(R.drawable.tasks_tab_selector, R.string.my_rv_tab)));
        tabLayout.addTab(tabLayout.newTab().setCustomView(inflateTabItem(R.drawable.tasks_tab_selector, R.string.my_lv_tab)));

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.change_city){
            showWeatherInputDialog();
        }else if(item.getItemId() == R.id.add_item){
            showListInputDialog();
        }
        return false;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private void showWeatherInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change city");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("--- ON CLICK ---", input.getText().toString());
                changeCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void changeCity(String city){
        WeatherFragment wf = (WeatherFragment)getSupportFragmentManager()
                .findFragmentById(R.id.container);
        WeatherFragment weatherFragment = new WeatherFragment();
        Log.i("--- CHANGE CITY ---", city);
        weatherFragment.changeCity(city);
        new CityPreference(this).setCity(city);
    }

    public void showListInputDialog(){
        LayoutInflater factory = LayoutInflater.from(this);

        final View textEntryView = factory.inflate(R.layout.fragment_add_item, null);
        final EditText title = (EditText)textEntryView.findViewById(R.id.username);
        final EditText message = (EditText)textEntryView.findViewById(R.id.password);

        title.setInputType(InputType.TYPE_CLASS_TEXT);
        message.setInputType(InputType.TYPE_CLASS_TEXT);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add item to list");
        builder.setView(textEntryView);


        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("--- ADD TITLE ---", title.getText().toString());
                Log.i("--- ADD MESSAGE ---", message.getText().toString());
            }
        });
        builder.show();
    }
}
