package co.infinum.heat.air.helpers;

import java.util.List;

import co.infinum.heat.air.db.Items;

/**
 * Created by hEAT- on 3.2.2016..
 */
public interface OnItemStoredListener {

    void itemStored(List<Items> list);
    void onItemStoredError();
}
