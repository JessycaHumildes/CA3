package com.jHumildes18303CA3.exercise3;

import com.jHumildes18303CA3.exercise3.network.ResponseDaily;

import java.util.List;


public interface DailyWeatherContract {
    interface View{
        void showDialog();
        void hideDialog();
        void showData(List<ResponseDaily> responseDailies);
        void showError(String message);
    }
    interface Presenter{
        void load();
    }
}
