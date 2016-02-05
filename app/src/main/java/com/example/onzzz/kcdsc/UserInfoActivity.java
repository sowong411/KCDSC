package com.example.onzzz.kcdsc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by onzzz on 5/2/2016.
 */
public class UserInfoActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String id = intent.getStringExtra("Id");

        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();
        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));

        ProfilePictureView displayProfilePic = (ProfilePictureView) findViewById(R.id.profilePic);
        displayProfilePic.setProfileId(id);

        TextView displayName = (TextView) findViewById(R.id.userName);
        displayName.setText(name);
    }
}
