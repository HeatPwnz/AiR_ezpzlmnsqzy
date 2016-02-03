package co.infinum.heat.air.mvp.interactors;

import co.infinum.heat.air.helpers.OnItemStoredListener;

/**
 * Created by hEAT- on 3.2.2016..
 */
public interface DbInteractor {
    void storeData(OnItemStoredListener listener, String title, String message);
    void getData(OnItemStoredListener listener);
}
