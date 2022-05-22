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
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView back_icon;
    private Button button_login;
    private TextView brand;


    private TextView banner;
    private EditText editTextName, editTextSurname, editTextEmail, editTextUsername, editTextPassword;
    private Button registerUser;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.signup);
        registerUser.setOnClickListener(this);
        editTextName = (EditText) findViewById (R.id.name);
        editTextSurname = (EditText) findViewById (R.id.surname);
        editTextEmail = (EditText) findViewById (R.id.email);
        editTextUsername = (EditText) findViewById (R.id.username);
        editTextPassword = (EditText) findViewById (R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        brand = (TextView) findViewById(R.id.textBrand);
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toHome();
            }
        });

        back_icon = (ImageView) findViewById(R.id.imageView4);
        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        button_login = (Button) findViewById(R.id.signin);
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
            case R.id.signup:
                registerUser();
                break;
        }

    }

    private void registerUser(){
        String username = editTextUsername.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String surname = editTextSurname.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(name.isEmpty()){
            editTextName.setError("Атыңызды енгізіңіз");
            editTextName.requestFocus();
            return;
        }

        if(surname.isEmpty()){
            editTextSurname.setError("Тегіңізді енгізіңіз");
            editTextSurname.requestFocus();
            return;

        }
        if(email.isEmpty()){
            editTextEmail.setError("Электронды поштаңызды енгізіңіз");
            editTextEmail.requestFocus();
            return;

        }

        if(username.isEmpty()){
            editTextUsername.setError("Аккаунттыңыздың атын енгізіңіз");
            editTextUsername.requestFocus();
            return;

        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Жарамды электрондық поштаны көрсетіңіз");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()){
            editTextPassword.setError("Құпиясөзді енгізіңіз");
            editTextPassword.requestFocus();
            return;

        }

        if(password.length() < 6){
            editTextPassword.setError("Құпиясөз кемінді 6 таңбадан тұруы керек");
            editTextPassword.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(name, surname, email, username);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(RegisterActivity.this, "Тіркелуден сәтті өттіңіз!", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);
                                        startActivity(new Intent(RegisterActivity.this, HomePage.class));

                                    }
                                    else{
                                        Toast.makeText(RegisterActivity.this, "Тіркелу мүмкін емес! Қайтадан өтіңіз!", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                    }

                                }
                            });

                        }else{
                            Toast.makeText(RegisterActivity.this, "Тіркелу мүмкін емес", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}