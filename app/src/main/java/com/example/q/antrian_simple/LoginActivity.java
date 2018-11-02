package com.example.q.antrian_simple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnLogin;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        String strusername = sharedPreferences.getString("username", "");
        String strpassword = sharedPreferences.getString("username", "");

        // set existing value
        username.setText(strusername);
        password.setText(strpassword);


        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                // put value in preference on button click
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        //btnskip
        Button btnSkip = (Button) findViewById(R.id.btnSkip);
        btnSkip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent skip = new Intent(LoginActivity.this,inputUser.class);
                startActivity(skip);
            }
        });
//button skip
    }
}
