package co.infinum.heat.air.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.heat.air.R;

/**
 * Created by hEAT- on 30.1.2016..
 */
public class RecyclerViewFragment extends BaseFragment{

    public static final String TASK = "task";

    @Bind(R.id.rv_recycler_view)
    RecyclerView rvRecyclerView;

    @Bind(R.id.rv_swipe_refresh_layout)
    SwipeRefreshLayout rvSwipeRefreshLayout;

    @Bind(R.id.empty_rv_info)
    TextView emtpyRvList;
    /*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);
        ButterKnife.bind(this, view);

        DaggerTasksComponent.builder()
                .tasksModule(new TasksModule(this))
                .build()
                .inject(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecyclerView();
        initSwipeRefresh();
        tasksPresenter.getTasks();
    }

    private void initSwipeRefresh() {
        rvSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        rvSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefreshed = true;
                tasksPresenter.getTasks();

            }
        });
    }

    private void initRecyclerView() {
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }*/
}
