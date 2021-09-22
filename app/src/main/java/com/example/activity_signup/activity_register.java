package com.example.activity_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;

public class activity_register extends AppCompatActivity {

    private TextView login;

    EditText name;
    EditText email;
    EditText pass;
    EditText phone;
    Button register = null;
    TextView error;

    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference dr=db.getReference().child("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.txt_name);
        email = (EditText) findViewById(R.id.txt_email_up);
        pass = (EditText) findViewById(R.id.txt_pass_up);
        phone = (EditText) findViewById(R.id.txt_phone);
        register = (Button) findViewById(R.id.btn_register);
        login = (TextView) findViewById(R.id.textView_login_register);
        error = (TextView) findViewById(R.id.txt_err);

        register.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || phone.getText().toString().isEmpty())
                {
                    error.setText("Empty Not Allowed");
                }
                else {

                    HashMap<String, String> userMap = new HashMap<>();
                    userMap.put("Name", name.getText().toString());
                    userMap.put("Email", email.getText().toString());
                    userMap.put("Pass", pass.getText().toString());
                    userMap.put("Phone", phone.getText().toString());
                    dr.child(phone.getText().toString()).setValue(userMap).addOnCompleteListener(task ->
                            {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(activity_register.this, "Registerd Sucessfully!", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(activity_register.this, "Some error occured", Toast.LENGTH_SHORT).show();

                                }
                            });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_register.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}