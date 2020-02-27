package com.jHumildes18303CA3.exercise3.database;

import java.util.ArrayList;
import java.util.List;



public class DataSingleton {

    private static DataSingleton instance;

    private List<MyWarning> myWarningList = new ArrayList<MyWarning>();

    private DataSingleton() {

    }
    public static DataSingleton getInstance(){
        if(instance!=null){
            return  instance;
        }
        instance = new DataSingleton();
        return instance;
    }

    public List<MyWarning> getMyWarningList() {
        return myWarningList;
    }

    public void setMyWarningList(List<MyWarning> myWarningList) {
        this.myWarningList = myWarningList;
    }
}
