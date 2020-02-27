package com.jHumildes18303CA3.exercise3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.jHumildes18303CA3.exercise3.adapter.DailyAdapter;
import com.jHumildes18303CA3.exercise3.DailyWeatherContract;
import com.jHumildes18303CA3.exercise3.R;
import com.jHumildes18303CA3.exercise3.network.ResponseDaily;
import com.jHumildes18303CA3.exercise3.presenter.DailyWeatherPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DailyWeatherContract.View,View.OnClickListener {
    private String[] dates = new String[7];
    private TextView[] dayLabels = new TextView[7];
    private String[] dayNumbers = new String[7];
    private LinearLayout[] dayRows = new LinearLayout[7];
    private AppCompatImageView[] icons = new AppCompatImageView[7];
    private AppCompatImageView[] temperatureImageViews = new AppCompatImageView[7];
    private TextView[] temperatureTextViews = new TextView[7];
    private ViewFlipper viewFlipper;
    private AppCompatImageView[] warnings = new AppCompatImageView[7];
    private TextView[] windTextViews = new TextView[7];
    private AppCompatImageView[] winds = new AppCompatImageView[7];
    private ProgressBar mProgress;

    private RecyclerView recyclerView;
    private DailyWeatherPresenter mPresenter;
    private DailyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setupViews();
        this.mProgress = findViewById(R.id.progressBar);
        this.recyclerView = findViewById(R.id.rv_daily);

        mPresenter = new DailyWeatherPresenter(this);
        mPresenter.load();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate your main_menu into the menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_warnings){
            startActivity(new Intent(this, WarningActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

/*
    private void setupViews(){
        this.mProgress = findViewById(R.id.progressBar);
        this.dayRows[0] = findViewById(R.id.day0Row);
        this.dayRows[1] = findViewById(R.id.day1Row);
        this.dayRows[2] = findViewById(R.id.day2Row);
        this.dayRows[3] = findViewById(R.id.day3Row);
        this.dayRows[4] = findViewById(R.id.day4Row);
        this.dayRows[5] = findViewById(R.id.day5Row);
        this.dayRows[6] = findViewById(R.id.day6Row);
        this.dayLabels[0] = findViewById(R.id.day0TextView);
        this.dayLabels[1] = findViewById(R.id.day1TextView);
        this.dayLabels[2] = findViewById(R.id.day2TextView);
        this.dayLabels[3] = findViewById(R.id.day3TextView);
        this.dayLabels[4] = findViewById(R.id.day4TextView);
        this.dayLabels[5] = findViewById(R.id.day5TextView);
        this.dayLabels[6] = findViewById(R.id.day6TextView);
        this.icons[0] = findViewById(R.id.day0IconImageView);
        this.icons[1] = findViewById(R.id.day1IconImageView);
        this.icons[2] = findViewById(R.id.day2IconImageView);
        this.icons[3] = findViewById(R.id.day3IconImageView);
        this.icons[4] = findViewById(R.id.day4IconImageView);
        this.icons[5] = findViewById(R.id.day5IconImageView);
        this.icons[6] = findViewById(R.id.day6IconImageView);
        this.temperatureImageViews[0] = findViewById(R.id.day0TemperatureImageView);
        this.temperatureImageViews[1] = findViewById(R.id.day1TemperatureImageView);
        this.temperatureImageViews[2] = findViewById(R.id.day2TemperatureImageView);
        this.temperatureImageViews[3] = findViewById(R.id.day3TemperatureImageView);
        this.temperatureImageViews[4] = findViewById(R.id.day4TemperatureImageView);
        this.temperatureImageViews[5] = findViewById(R.id.day5TemperatureImageView);
        this.temperatureImageViews[6] = findViewById(R.id.day6TemperatureImageView);
        this.temperatureTextViews[0] = findViewById(R.id.day0TemperatureTextView);
        this.temperatureTextViews[1] = findViewById(R.id.day1TemperatureTextView);
        this.temperatureTextViews[2] = findViewById(R.id.day2TemperatureTextView);
        this.temperatureTextViews[3] = findViewById(R.id.day3TemperatureTextView);
        this.temperatureTextViews[4] = findViewById(R.id.day4TemperatureTextView);
        this.temperatureTextViews[5] = findViewById(R.id.day5TemperatureTextView);
        this.temperatureTextViews[6] = findViewById(R.id.day6TemperatureTextView);
        this.winds[0] = findViewById(R.id.day0WindImageView);
        this.winds[1] = findViewById(R.id.day1WindImageView);
        this.winds[2] = findViewById(R.id.day2WindImageView);
        this.winds[3] = findViewById(R.id.day3WindImageView);
        this.winds[4] = findViewById(R.id.day4WindImageView);
        this.winds[5] = findViewById(R.id.day5WindImageView);
        this.winds[6] = findViewById(R.id.day6WindImageView);
        this.windTextViews[0] = findViewById(R.id.day0WindTextView);
        this.windTextViews[1] = findViewById(R.id.day1WindTextView);
        this.windTextViews[2] = findViewById(R.id.day2WindTextView);
        this.windTextViews[3] = findViewById(R.id.day3WindTextView);
        this.windTextViews[4] = findViewById(R.id.day4WindTextView);
        this.windTextViews[5] = findViewById(R.id.day5WindTextView);
        this.windTextViews[6] = findViewById(R.id.day6WindTextView);
        this.warnings[0] = findViewById(R.id.day0WarningImageView);
        this.warnings[1] = findViewById(R.id.day1WarningImageView);
        this.warnings[2] = findViewById(R.id.day2WarningImageView);
        this.warnings[3] = findViewById(R.id.day3WarningImageView);
        this.warnings[4] = findViewById(R.id.day4WarningImageView);
        this.warnings[5] = findViewById(R.id.day5WarningImageView);
        this.warnings[6] = findViewById(R.id.day6WarningImageView);
        this.dayRows[0].setOnClickListener(this);
        this.dayRows[1].setOnClickListener(this);
        this.dayRows[2].setOnClickListener(this);
        this.dayRows[3].setOnClickListener(this);
        this.dayRows[4].setOnClickListener(this);
        this.dayRows[5].setOnClickListener(this);
        this.dayRows[6].setOnClickListener(this);
    }*/

    @Override
    public void onClick(View v) {
        if (this.dayNumbers.length != 0) {
        }

    }

    @Override
    public void showDialog() {
        this.mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        this.mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showData(List<ResponseDaily> responseDailies) {
        Log.d("DATA",responseDailies.size()+"");
        adapter = new DailyAdapter(this, null,responseDailies);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showError(String message) {
        Log.d("DATA_ERROR",message);
    }
}
