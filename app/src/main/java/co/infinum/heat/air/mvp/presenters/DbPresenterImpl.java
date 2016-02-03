package co.infinum.heat.air.mvp.presenters;

import java.util.List;

import co.infinum.heat.air.db.Items;
import co.infinum.heat.air.helpers.OnItemStoredListener;
import co.infinum.heat.air.mvp.interactors.DbInteractor;
import co.infinum.heat.air.mvp.views.DbView;

/**
 * Created by hEAT- on 3.2.2016..
 */
public class DbPresenterImpl implements DbPresenter {

    private DbInteractor interactor;
    private DbView view;

    public DbPresenterImpl(DbInteractor interactor, DbView view) {
        this.interactor = interactor;
        this.view = view;
    }


    @Override
    public void storeData(String title, String message) {
        interactor.storeData(listener, title, message);
    }

    @Override
    public void getData() {
        interactor.getData(listener);
    }

    private OnItemStoredListener listener = new OnItemStoredListener() {
        @Override
        public void itemStored(List<Items> list) {
            view.onSuccess(list);
        }

        @Override
        public void onItemStoredError() {
            view.onError();
        }
    };

}
