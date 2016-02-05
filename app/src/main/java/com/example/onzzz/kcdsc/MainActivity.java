package com.example.onzzz.kcdsc;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private Button displayUserInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("Name");
        final String id = intent.getStringExtra("Id");

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
                startActivity(intent);
            }
        });
    }
}
