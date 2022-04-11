package com.example.iment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextInputEditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button mButton = (Button) findViewById(R.id.btnLogin);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, focus.class));

            }
        });

//        username =  findViewById(R.id.edUsername);
//        password = findViewById(R.id.edPassword);
//        btnLogin = findViewById(R.id.btnLogin);
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
//                    Toast.makeText(Login.this, "Username  / password Required", Toast.LENGTH_LONG).show();
//                }else{
//                    //proceed to login
//                    login();
//                }
//            }
//        });
//    }
//    public void login(){
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setUsername(username.getText().toString());
//        loginRequest.setPassword(password.getText().toString());
//
//        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
//        loginResponseCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//
//                if (response.isSuccessful()){
//                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();
//                    LoginResponse loginResponse = response.body();
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            LoginResponse loginResponse = response.body();
//                            startActivity(new Intent(Login.this,focus.class).putExtra("data",loginResponse.getUsername()));
//
//                        }
//                    }, 700);
//
//                }else {
//                    Toast.makeText(Login.this, "Login failed", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                Toast.makeText(Login.this, "Throwable"+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        });
    }
}