package com.example.activity_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private TextView signup;

    EditText Phone;
    EditText Password;
    Button Login;
    TextView forgotpass;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = (TextView) findViewById(R.id.textView_signup_login);
        forgotpass = (TextView) findViewById(R.id.textView_forget_password_login);
        Login = (Button) findViewById(R.id.btn_login);
        Phone = (EditText)findViewById(R.id.txt_phone);
        Password = (EditText) findViewById(R.id.txt_pass);



        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String str_phone = Phone.getText().toString();
                String str_pass = Password.getText().toString();

                if(str_phone.isEmpty()){
                    Phone.setError("Enter a valid Contact");
                    Phone.requestFocus();
                    return;
                }
                else if(str_pass.isEmpty())
                {
                    Password.setError("Enter a valid Password");
                    Password.requestFocus();
                    return;
                }
                else
                {
                    Phone.clearFocus();
                    Password.clearFocus();
                    ref = FirebaseDatabase.getInstance().getReference().child("user");
                    Query checkUser = ref.orderByChild("Phone").equalTo(str_phone);

                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                            if(snapshot.exists())
                            {
                                Phone.setError(null);
                                String passfromdb = snapshot.child(str_phone).child("Pass").getValue(String.class);

                                if(passfromdb.equals(str_pass))
                                {
                                    Password.setError(null);

                                    String nameFromDb = snapshot.child(str_phone).child("Name").getValue(String.class);
                                    String phoneFromDb = snapshot.child(str_phone).child("Phone").getValue(String.class);
                                    String packFromDb = snapshot.child(str_phone).child("Pack").getValue(String.class);

                                    Intent intent = new Intent(getApplicationContext(), Activity_Home.class);

                                    intent.putExtra("Name",nameFromDb);
                                    intent.putExtra("Phone",phoneFromDb);
                                    intent.putExtra("Pack",packFromDb);

                                    startActivity(intent);
                                }
                                else
                                {
                                    Password.setError("Wrong Password");
                                    Password.requestFocus();
                                }
                            }
                            else
                            {
                                Phone.setError("No such user exists");
                                Phone.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull @NotNull DatabaseError error) { }
                    });
                }

            }
        });
    }

    public void openSignup()
    {
        Intent intent = new Intent(this, activity_register.class);
        startActivity(intent);
    }


}