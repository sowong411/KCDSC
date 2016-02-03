package com.example.onzzz.kcdsc;

import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();

        //Set the return arrow in the Action Bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));
    }
}
