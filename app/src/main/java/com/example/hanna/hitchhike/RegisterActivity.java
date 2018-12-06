package com.example.hanna.hitchhike;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private EditText regEmailField;
    private EditText regPasswordField;
    private EditText regConfirmPasswordField;

    private Button regButton;
    private Button regLoginButton;

    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        regEmailField = (EditText) findViewById(R.id.regEmailText);
        regPasswordField = (EditText) findViewById(R.id.regPasswordText);
        regConfirmPasswordField = (EditText) findViewById(R.id.confirmRegPasswordText);

        regButton = (Button) findViewById(R.id.reg_register_button);
        regLoginButton = (Button) findViewById(R.id.reg_login_button);

        progressBar = (ProgressBar) findViewById(R.id.reg_progress);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = regEmailField.getText().toString();
                String password = regPasswordField.getText().toString();
                String confirmPassword = regConfirmPasswordField.getText().toString();

                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(confirmPassword)){

                    if(password.equals(confirmPassword)){

                        progressBar.setVisibility(ProgressBar.VISIBLE);

                        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){

                                    sendToMain();
                                    Toast.makeText(RegisterActivity.this, "Account successfully created.", Toast.LENGTH_SHORT).show();

                                }else{

                                    String errorMessage = task.getException().getMessage();
                                    Toast.makeText(RegisterActivity.this, "Error: " + errorMessage, Toast.LENGTH_SHORT).show();

                                }

                                progressBar.setVisibility(ProgressBar.INVISIBLE);

                            }
                        });

                    }else
                        Toast.makeText(RegisterActivity.this, "The passwords doesn´t match.", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(RegisterActivity.this, "1 or more required fields are empty.", Toast.LENGTH_SHORT).show();



            }
        });

        regLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToMain();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){
            sendToMain();
        }

    }

    private void sendToMain() {
        Intent mainIntent = new Intent(this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
