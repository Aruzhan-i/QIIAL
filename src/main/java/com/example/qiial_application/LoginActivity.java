package com.example.qiial_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_register;
    private ImageView back_icon;
    private TextView brand;

    private EditText editTextEmail, editTextPassword;
    private Button login;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        editTextEmail = (EditText) findViewById (R.id.email);
        editTextPassword = (EditText) findViewById (R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();


        back_icon = (ImageView) findViewById(R.id.imageView4);

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        brand = (TextView) findViewById(R.id.textBrand);
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHome();
            }
        });

        button_register = (Button) findViewById(R.id.register);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterPage();
            }
        });

    }

    public void toHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity((intent));
    }

    public void openRegisterPage(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity((intent));
    }


    public void backToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity((intent));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;

            case R.id.login:
                userLogin();
                break;
        }

    }
    private void userLogin(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()){
            editTextEmail.setError("???????????????????? ???????????????????? ??????????????????");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("?????????????? ?????????????????????? ?????????????? ????????????????????");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("???????????????????? ??????????????????");
            editTextPassword.requestFocus();
            return;

        }
        if(password.length() < 6){
            editTextPassword.setError("???????????????? ?????????????? 6 ???????????????? ?????????? ??????????");
            editTextPassword.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.VISIBLE);
                    startActivity(new Intent(LoginActivity.this, HomePage.class));

                } else{
                    Toast.makeText(LoginActivity.this, "?????????????????????????? ???????? ???????????? ????????! ???????????????? ???????????????????????????? ????????????????????!", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);

                }
            }
        });


    }
}