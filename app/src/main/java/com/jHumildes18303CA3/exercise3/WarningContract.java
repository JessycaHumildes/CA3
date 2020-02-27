package com.jHumildes18303CA3.exercise3;

import java.util.List;


public interface WarningContract {
    interface View{
        void showDialog();
        void hideDialog();
        void showTypes(List<String> warningTypes);
        void showArea(List<String> warningAreas);
        void showError(String message);
    }
    interface Presenter{
        List<String> loadWarningTypes();
        List<String> loadWarningArea();
    }
}
