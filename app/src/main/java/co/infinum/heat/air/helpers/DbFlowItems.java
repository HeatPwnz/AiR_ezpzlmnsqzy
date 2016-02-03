package co.infinum.heat.air.helpers;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import co.infinum.heat.air.db.Items;

/**
 * Created by hEAT- on 3.2.2016..
 */
public class DbFlowItems implements DatabaseManager {



    @Override
    public List<Items> getItems() {
        return new Select().from(Items.class).queryList();
    }

    @Override
    public void addItem(Items item) {
        item.save();
    }
}
