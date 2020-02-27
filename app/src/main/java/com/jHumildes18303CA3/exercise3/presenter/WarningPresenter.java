package com.jHumildes18303CA3.exercise3.presenter;


import com.jHumildes18303CA3.exercise3.WarningContract;

import java.util.Arrays;
import java.util.List;


public class WarningPresenter implements WarningContract.Presenter {

    private WarningContract.View mView;

    public WarningPresenter(WarningContract.View view) {
        this.mView = view;
    }

    @Override
    public List<String> loadWarningTypes() {
        mView.hideDialog();
        return Arrays.asList("All",
                "Rain",
                "Wind",
                "Snow Ice",
                "Fog",
                "Low Temperature Ice",
                "High Temperature",
                "Thunderstorm",
                "Advisory"
        );

    }


    @Override
    public List<String> loadWarningArea() {
        mView.hideDialog();
        return Arrays.asList(
                "All counties",
                "Carlow",
                "Cavan",
                "Clare",
                "Cork",
                "Donegal",
                "Dublin",
                "Galway",
                "Kerry",
                "Kildare",
                "Kilkenny",
                "Laois",
                "Leitrim",
                "Limerick",
                "Longford",
                "Louth",
                "Mayo",
                "Meath",
                "Monaghan",
                "Offaly",
                "Roscommon",
                "Sligo",
                "Tipperary",
                "Waterford",
                "Westmeath",
                "Wexford",
                "Wicklow"
        );
    }
}
