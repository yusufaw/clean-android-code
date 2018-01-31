package com.crevion.apps.cleanandroidcode.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.crevion.apps.cleanandroidcode.BaseApp;
import com.crevion.apps.cleanandroidcode.R;
import com.crevion.apps.cleanandroidcode.models.CityListData;
import com.crevion.apps.cleanandroidcode.models.CityListResponse;
import com.crevion.apps.cleanandroidcode.networking.Service;

import javax.inject.Inject;

/**
 * Created by yusufaw on 1/27/18.
 */

public class HomeActivity extends BaseApp implements HomeView {

    private RecyclerView recyclerView;
    @Inject
    public Service service;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);
        renderView();
        init();

        HomePresenter homePresenter = new HomePresenter(service, this);
        homePresenter.getCityList();
    }

    public void renderView() {
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void geCityListSuccess(CityListResponse cityListResponse) {
        HomeAdapter homeAdapter = new HomeAdapter(getApplicationContext(), cityListResponse.getData(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(CityListData cityListData) {
                        Toast.makeText(getApplicationContext(), cityListData.getName(), Toast.LENGTH_LONG);
                    }
                });

        recyclerView.setAdapter(homeAdapter);
    }
}
