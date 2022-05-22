package com.example.qiial_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button_login;
    private Button button_register;
    private TextView brand;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brand = (TextView) findViewById(R.id.textBrand);
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHome();
            }
        });


        button_register = (Button) findViewById(R.id.button1);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterPage();
            }
        });

        button_login = (Button) findViewById(R.id.button2);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginPage();
            }
        });
    }

    public void toHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity((intent));
    }


    public void openLoginPage(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity((intent));
    }

    public void openRegisterPage(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity((intent));
    }
}