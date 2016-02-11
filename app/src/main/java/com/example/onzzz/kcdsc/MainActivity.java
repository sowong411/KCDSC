package com.example.onzzz.kcdsc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;
import com.parse.Parse;
import com.parse.ParseObject;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private Button displayUserInfoButton;
    private Button photoUploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this); //Can use separate class later to solve the multiple initialization problem

        Intent intent = getIntent();
        final String name = intent.getStringExtra("Name");
        final String id = intent.getStringExtra("Id");
        final String profilePicUri = intent.getStringExtra("ProfilePicUri");
        final String loginMethod = intent.getStringExtra("LoginMethod");

        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();
        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));

        displayUserInfoButton = (Button) findViewById(R.id.display_user_info_button);
        displayUserInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, UserInfoActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("Id", id);
                intent.putExtra("ProfilePicUri", profilePicUri);
                intent.putExtra("LoginMethod", loginMethod);
                startActivity(intent);
            }
        });

        photoUploadButton = (Button) findViewById(R.id.photo_upload);
        photoUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Just for Testing
                ParseObject testObject = new ParseObject("TestObject");
                testObject.put("foo", "bar");
                testObject.saveInBackground();
            }
        });
    }

}
