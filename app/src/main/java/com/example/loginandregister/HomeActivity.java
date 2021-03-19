package com.example.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText password;
    EditText email;
    EditText DOB;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.Password);
        DOB = (EditText)findViewById(R.id.DOB);
        register = (Button)findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
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
        if (isEmpty(firstName)) {
            firstName.setError("First name required");
        }

        if (isEmpty(lastName)) {
            lastName.setError("Last name required");
        }

        if (isEmail(email) == false) {
            email.setError("Email Required");
        }

        if (isEmpty(password)) {
            password.setError("Password Required");
        }

        if (isEmpty(DOB)) {
            DOB.setError("Date of Birth Required");
        }
        else {
            Intent LoginIntent = new Intent (HomeActivity.this, Login.class);
            startActivity(LoginIntent);
            finish();
        }

    }
}
