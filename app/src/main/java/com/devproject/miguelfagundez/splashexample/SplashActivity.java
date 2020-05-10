package com.devproject.miguelfagundez.splashexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/********************************************
 * Activity- SplashActivity
 * This activity will display a basic logo/slogan
 * for 5 seconds
 * @author: Miguel Fagundez
 * @date: May 10th, 2020
 * @version: 1.0
 * *******************************************/
public class SplashActivity extends AppCompatActivity {

    // Animnation
    private Animation topAnimation;
    private Animation bottomAnimation;

    // TextView
    private TextView companyName;
    private TextView departmentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //************************************************
        // FULL_SCREEN
        //************************************************
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        setupAnimations();
        setupViews();
        connectAnimationWithViews();

        //************************************************
        //I hold 5 sec before calling the MainActivity
        //************************************************
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callNextActivity();
            }
        }, 5000);

    }

    //***************************************
    //        Setup components
    //***************************************
    private void setupAnimations() {
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_bottom_animation);
    }

    private void setupViews() {
        companyName = findViewById(R.id.companyName);
        departmentName = findViewById(R.id.departmentName);
    }

    private void connectAnimationWithViews() {
        companyName.setAnimation(topAnimation);
        departmentName.setAnimation(bottomAnimation);
    }

    //***************************************
    //   Calling Next Activity or Fragment
    //***************************************
    private void callNextActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
