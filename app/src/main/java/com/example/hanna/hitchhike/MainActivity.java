package com.example.hanna.hitchhike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    private Button btnFBlogin;
    private Button btnEmailLogin;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFBlogin = (Button)findViewById(R.id.button_login_facebook);
        btnEmailLogin = (Button)findViewById(R.id.button_login_email);
        btnSignUp = (Button)findViewById(R.id.button_create_account);


        //this not working.. tog från hola2
        btnFBlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setType("text/plain");
                String message = "Holaaaaaa";
                intent.putExtra(EXTRA_MESSAGE, message);

                startActivity(intent);

            }
        });





    }

}
