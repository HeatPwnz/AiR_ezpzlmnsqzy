package co.infinum.heat.air.mvp.views;

import java.util.List;

import co.infinum.heat.air.db.Items;

/**
 * Created by hEAT- on 3.2.2016..
 */
public interface DbView {
    void onSuccess(List<Items> itemsList);
    void onError();
}
