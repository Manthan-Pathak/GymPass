package com.example.activity_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class Activity_Home extends AppCompatActivity {

    CardView profile;
    CardView calc;
    CardView pkg;
    CardView workout;
    CardView notice;
    CardView trainer;
    TextView username;
    TextView usrpack;
    DatabaseReference ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        profile = (CardView) findViewById(R.id.crd_profile);
        calc = (CardView) findViewById(R.id.crd_bmi);
        pkg = (CardView) findViewById(R.id.crd_pkg);
        workout = (CardView) findViewById(R.id.crd_workout);
        notice = (CardView) findViewById(R.id.crd_notice);
        trainer = (CardView) findViewById(R.id.crd_trainer);
        username = (TextView) findViewById(R.id.txt_username);
        usrpack = (TextView) findViewById(R.id.txt_pack);

        Intent intent = getIntent();
        String nameFromSession = intent.getStringExtra("Name");
        String phoneFromSession = intent.getStringExtra("Phone");
        String packFromSession = intent.getStringExtra("Pack");


        username.setText(nameFromSession);
        usrpack.setText(packFromSession);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ref = FirebaseDatabase.getInstance().getReference().child("user");
                Query checkUser = ref.orderByChild("Phone").equalTo(phoneFromSession);

                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                        String phoneFromDb = snapshot.child(phoneFromSession).child("Phone").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(), Activity_Profile.class);
                        intent.putExtra("Phone",phoneFromDb);
                    }

                    @Override
                    public void onCancelled(@NonNull @NotNull DatabaseError error) { }
                });

                Intent intent = new Intent(Activity_Home.this, Activity_Profile.class);
                startActivity(intent);
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Home.this, activity_Bmi_Calc.class);
                startActivity(intent);
            }
        });

        pkg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Home.this, Activity_Package.class);
                startActivity(intent);
            }
        });

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Home.this, Activity_workout.class);
                startActivity(intent);
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Home.this, Activity_Notice.class);
                startActivity(intent);
            }
        });

        trainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Home.this, Activity_Trainer.class);
                startActivity(intent);
            }
        });

    }
}