package com.example.onzzz.kcdsc;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import java.io.InputStream;

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
        String profilePicUri = intent.getStringExtra("ProfilePicUri");
        String loginMethod = intent.getStringExtra("LoginMethod");

        //Get the template Action Bar as our Action Bar
        actionBar = getSupportActionBar();
        //Apply the gradient(漸變色) in the Action Bar
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_gradient_bg));

        TextView loginMethodText = (TextView) findViewById(R.id.login_method);
        if (loginMethod.equals("Facebook")){
            loginMethodText.setText("You are logged in using Facebook");
            //ProfilePictureView displayProfilePic = (ProfilePictureView) findViewById(R.id.profilePicFacebook);
            ImageView displayProfilePic = (ImageView) findViewById(R.id.profilePicFacebook);
            displayProfilePic.setVisibility(View.VISIBLE);
            new LoadProfileImage(displayProfilePic).execute(profilePicUri);
        }
        else if (loginMethod.equals("Google")){
            loginMethodText.setText("You are logged in using Google");
            ImageView displayProfilePic = (ImageView) findViewById(R.id.profilePicGoogle);
            displayProfilePic.setVisibility(View.VISIBLE);
            new LoadProfileImage(displayProfilePic).execute(profilePicUri);
        }

        TextView displayName = (TextView) findViewById(R.id.userName);
        displayName.setText(name);
    }

    /**
     * Background Async task to load user profile picture from url
     * */
    private class LoadProfileImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public LoadProfileImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
