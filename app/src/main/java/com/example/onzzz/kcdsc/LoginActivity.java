package com.example.onzzz.kcdsc;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by onzzz on 4/2/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();

        //Set the return arrow in the Action Bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));
    }
}
