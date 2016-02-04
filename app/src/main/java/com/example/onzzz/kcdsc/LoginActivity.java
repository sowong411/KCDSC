package com.example.onzzz.kcdsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by onzzz on 4/2/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private Button fbLoginButton;
    private Button gLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /***************Action Bar***************/
        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();
        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));

        /***************Facebook Login Button***************/
        fbLoginButton = (Button) findViewById(R.id.fbLogin);
        fbLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        /***************Google Login Button***************/
        gLoginButton = (Button) findViewById(R.id.gLogin);
        gLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
