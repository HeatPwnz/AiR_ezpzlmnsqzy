package co.infinum.heat.air.mvp.interactors;

import java.util.List;

import co.infinum.heat.air.db.Items;
import co.infinum.heat.air.helpers.DbFlowItems;
import co.infinum.heat.air.helpers.OnItemStoredListener;

/**
 * Created by hEAT- on 3.2.2016..
 */
public class DbInteractorImpl implements DbInteractor {

    public DbFlowItems items = new DbFlowItems();


    @Override
    public void storeData(OnItemStoredListener listener, String title, String message) {
        Items item = new Items();
        item.setMessage(message);
        item.setTitle(title);

        items.addItem(item);
        List<Items> list = items.getItems();

        listener.itemStored(list);
    }

    @Override
    public void getData(OnItemStoredListener listener) {
        listener.itemStored(items.getItems());
    }
}
