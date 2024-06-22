package com.dreamsofmyparents.bloodfoundation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dreamsofmyparents.bloodfoundation.MainActivity;
import com.dreamsofmyparents.bloodfoundation.R;
import com.dreamsofmyparents.bloodfoundation.databinding.ActivityDonaterBinding;
import com.dreamsofmyparents.bloodfoundation.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DonaterActivity extends AppCompatActivity {

    private ActivityDonaterBinding binding;
    private String name, phone, email, password;
    private FirebaseAuth auth;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDonaterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

            auth = FirebaseAuth.getInstance();

            String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();
            databaseReference = FirebaseDatabase.getInstance().getReference("user").child(currentuser);

            binding.registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    name = binding.inputName.getText().toString();
                    phone = binding.inputName.getText().toString();
                    email = binding.inputName.getText().toString();
                    password = binding.inputName.getText().toString();

                    if (name.isEmpty()){
                        binding.inputName.setError("Enter Your Name");
                        binding.inputName.requestFocus();

                    } else if (phone.isEmpty()){
                        binding.inputNumber.setError("Enter Your Phone");
                        binding.inputNumber.requestFocus();

                    } else if(email.isEmpty()){
                        binding.inputEmail.setError("Enter Your Email");
                        binding.inputEmail.requestFocus();

                    }else if(password.isEmpty()){
                        binding.inputPassword.setError("Enter Your Password");
                        binding.inputPassword.requestFocus();
                    } else {
                        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    inserData();
                                }
                            }
                        });
                    }
                }
            });

    }

    private void inserData() {

        UserModel userModel = new UserModel(name, phone, email, password);

        databaseReference.setValue(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful());
                startActivity(new Intent(DonaterActivity.this, MainActivity.class));
                Toast.makeText(DonaterActivity.this, "Donor Registration Succesfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}