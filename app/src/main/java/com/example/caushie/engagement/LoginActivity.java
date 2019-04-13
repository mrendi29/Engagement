package com.example.caushie.engagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etUser;
    private EditText etPassword;
    private Button btnLogin;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser= findViewById(R.id.etUsername);
        etPassword= findViewById(R.id.etPassword);
        btnLogin= findViewById(R.id.btnSign);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  username = etUser.toString();
                String password = etPassword.toString();
                login(username,password);
            }
        });


    }

    private void login(String username, String password) {

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if( e!= null ){
                    Log.e("Error", "Something went wrong in login");
                    e.printStackTrace();
                    return;
                }
                goMainActivity();

            }
        });


    }

    private void goMainActivity() {
        Log.d("Success", " Succsessfully loged in.");
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        // Close the screen so when we click on back button after successfully logging in the app will exit.
        finish();
    }
}
