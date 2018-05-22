package com.anjan.mockitounittesttutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Gets the unique id.
     *
     * @return the unique id
     */
    public int getUniqueId() {
        return 43;
    }

    public int testing(int num) {
        someMethod("");
        return num;
    }

    public void someMethod(String someMethod) {
        testing(1);
    }
}
