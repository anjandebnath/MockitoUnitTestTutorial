package com.anjan.mockitounittesttutorial.contributor;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.anjan.mockitounittesttutorial.R;

public class ContributorActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void methodCreatedByOwner() {

        Log.d("Owner", "This method has created by owner");
    }
    public void methodCreatedByContributor(){

        Log.d("Owner", "This method has created by contributor machine");

    }
}


