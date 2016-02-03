package co.infinum.heat.air.fragments;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.heat.air.MainActivity;
import co.infinum.heat.air.R;
import co.infinum.heat.air.adapters.ItemAdapter;
import co.infinum.heat.air.db.Items;
import co.infinum.heat.air.helpers.OnItemAddedListener;
import co.infinum.heat.air.mvp.interactors.DbInteractorImpl;
import co.infinum.heat.air.mvp.presenters.DbPresenter;
import co.infinum.heat.air.mvp.presenters.DbPresenterImpl;
import co.infinum.heat.air.mvp.views.DbView;

/**
 * Created by hEAT- on 30.1.2016..
 */
public class RecyclerViewFragment extends BaseFragment implements DbView,OnItemAddedListener {

    public static final String TITLE = "Title";
    public static final String MESSAGE = "Message";

    @Bind(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;

    @Bind(R.id.empty_rv_info)
    TextView emtpyRvList;

    private DbPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rv, container, false);
        ButterKnife.bind(this, view);

        presenter = new DbPresenterImpl(new DbInteractorImpl(), this);
        ((MainActivity) getActivity()).setListener(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
        presenter.getData();


//        String title = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(TITLE, "");
//        String message = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString(MESSAGE, "");
//        if (title.equals("") && message.equals("")) {
//            presenter.storeData(title, message);
//        }
//        else{
//            emtpyRvList.setVisibility(View.VISIBLE);
//            rvRecyclerView.setVisibility(View.GONE);
//        }
    }


    private void initRecyclerView() {
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onSuccess(List<Items> itemsList) {
        Toast.makeText(getActivity(), "Successfuly read from db", Toast.LENGTH_SHORT).show();
        rvRecyclerView.setAdapter(new ItemAdapter(itemsList));
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(), "Error while storing an item", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void itemAdded(String title, String message) {
        if (!title.equals("") && !message.equals("")) {
            presenter.storeData(title, message);
        }
        else{
            emtpyRvList.setVisibility(View.VISIBLE);
            rvRecyclerView.setVisibility(View.GONE);
        }
    }
}
