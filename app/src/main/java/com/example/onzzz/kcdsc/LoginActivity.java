package com.example.onzzz.kcdsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by onzzz on 4/2/2016.
 */
public class LoginActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private LoginButton fbLoginButton;
    private Button gLoginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /***************Action Bar***************/
        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();
        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));

        /***************Facebook Login Button***************/
        fbLoginButton = (LoginButton) findViewById(R.id.fbLogin);
        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile = Profile.getCurrentProfile();
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                intent.putExtra("Name", profile.getName());
                intent.putExtra("Id", profile.getId());
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
