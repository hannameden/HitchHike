package com.example.hanna.hitchhike;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btnSignUp = (Button)findViewById(R.id.button_create_account);

        ((View) btnSignUp).setOnClickListener((v) -> {

            Toast.makeText(LoginActivity.this, "Great app for getting ridesss."
                    , Toast.LENGTH_LONG).show();
        });

    }
}
