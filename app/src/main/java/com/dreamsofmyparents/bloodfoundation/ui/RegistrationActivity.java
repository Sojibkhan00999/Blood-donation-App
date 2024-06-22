package com.dreamsofmyparents.bloodfoundation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dreamsofmyparents.bloodfoundation.R;
import com.dreamsofmyparents.bloodfoundation.databinding.ActivityLoginBinding;
import com.dreamsofmyparents.bloodfoundation.databinding.ActivityRegistrationBinding;

public class RegistrationActivity extends AppCompatActivity {

    private @androidx.annotation.NonNull ActivityRegistrationBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.RepoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, ReproActivity.class);
                startActivity(intent);
            }
        });

        binding.donBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, DonaterActivity.class);
                startActivity(intent);
            }
        });


    }
}