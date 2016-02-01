package co.infinum.heat.air.helpers;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by hEAT- on 1.2.2016..
 */
public class CityPreference {

    SharedPreferences prefs;

    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Moscow as the default city
    public String getCity(){
        return prefs.getString("city", "Moscow");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).apply();
        //commit() inace ide umjesto apply()
    }
}
