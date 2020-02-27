package com.jHumildes18303CA3.exercise3.presenter;


import com.jHumildes18303CA3.exercise3.DailyWeatherContract;
import com.jHumildes18303CA3.exercise3.network.ResponseDaily;
import com.jHumildes18303CA3.exercise3.network.Server;
import com.jHumildes18303CA3.exercise3.network.ServerAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DailyWeatherPresenter implements DailyWeatherContract.Presenter {

    private DailyWeatherContract.View mView;

    public DailyWeatherPresenter(DailyWeatherContract.View view) {
        this.mView = view;
    }

    @Override
    public void load() {
        this.mView.showDialog();
        Server.getServer()
                .create(ServerAPI.class)
                .getDailyWeather().enqueue(new Callback<List<ResponseDaily>>() {
            @Override
            public void onResponse(Call<List<ResponseDaily>> call, Response<List<ResponseDaily>> response) {
                mView.showData(response.body());
                mView.hideDialog();
            }

            @Override
            public void onFailure(Call<List<ResponseDaily>> call, Throwable t) {
                mView.showError(t.getMessage());
                mView.hideDialog();
            }
        });
    }
}
