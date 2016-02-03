package co.infinum.heat.air;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import co.infinum.heat.air.helpers.OnItemAddedListener;

/**
 * Created by hEAT- on 3.2.2016..
 */
public class WeatherApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
