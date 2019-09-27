package com.example.chatproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chatproject.forgetpassword.ForgetPasswordActivity;
import com.example.chatproject.R;
import com.example.chatproject.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView forgetPass = findViewById(R.id.txv_forget_password_login);
        TextView createAccount = findViewById(R.id.txv_create_account_login);
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);

                startActivity(intent);

            }
        });
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);

                startActivity(intent);

            }
        });
    }


}
