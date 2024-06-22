package com.dreamsofmyparents.bloodfoundation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dreamsofmyparents.bloodfoundation.MainActivity;
import com.dreamsofmyparents.bloodfoundation.R;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (FirebaseAuth.getInstance().getCurrentUser()==null){
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                    finish();
                }else

                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, 2000);


    }
}