package com.example.activity_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView signup;

    EditText email;
    EditText password;
    Button Login;
    TextView forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = (TextView) findViewById(R.id.textView_signup_login);
        forgotpass = (TextView) findViewById(R.id.textView_forget_password_login);
        Login = (Button) findViewById(R.id.btn_login);
        email = (EditText)findViewById(R.id.txt_email);
        password = (EditText) findViewById(R.id.txt_pass);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendashboard();
            }
        });
    }

    public void openSignup()
    {
        Intent intent = new Intent(this, activity_register.class);
        startActivity(intent);
    }

    public void opendashboard()
    {
        Intent intent = new Intent(this, activity_dashboard.class);
        startActivity(intent);
    }
}