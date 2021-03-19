package com.example.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText elogin;
    EditText plogin;
    Button login;
    Button rlogin;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        elogin = (EditText)findViewById(R.id.elogin);
        plogin = (EditText)findViewById(R.id.plogin);
        login = (Button)findViewById(R.id.login);
        rlogin = (Button)findViewById(R.id.rlogin);
        txt = (TextView)findViewById(R.id.txt);

        rlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent (Login.this, HomeActivity.class);
                startActivity(registerIntent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }


    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmail(elogin) == false) {
            elogin.setError("Please enter your email");
        }

        if (isEmpty(plogin)) {
            plogin.setError("Please enter your password");
        }

        else {
            txt.setText("Login Successful");
        }

    }
}
