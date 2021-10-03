package com.example.activity_signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_userDashboard extends AppCompatActivity{

    CardView profile;
    CardView calc;
    CardView pkg;
    CardView workout;
    CardView notice;
    CardView trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        profile = (CardView) findViewById(R.id.crd_profile);
        calc = (CardView) findViewById(R.id.crd_bmi);
        pkg = (CardView) findViewById(R.id.crd_pkg);
        workout = (CardView) findViewById(R.id.crd_workout);
        notice = (CardView) findViewById(R.id.crd_notice);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmi();
            }
        });

        pkg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPkg();
            }
        });

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWorkout();
            }
        });

        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotice();
            }
        });

        trainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrainer();
            }
        });
    }

    public void openProfile()
    {
        Intent intent = new Intent(this, Activity_Profile.class);
        startActivity(intent);
    }

    public void openBmi()
    {
        Intent intent = new Intent(this, activity_Bmi_Calc.class);
        startActivity(intent);
    }

    public void openPkg()
    {
        Intent intent = new Intent(this, Activity_Package.class);
        startActivity(intent);
    }

    public void openWorkout()
    {
        Intent intent = new Intent(this, Activity_workout.class);
        startActivity(intent);
    }

    public void openNotice()
    {
        Intent intent = new Intent(this, Activity_Notice.class);
        startActivity(intent);
    }

    public void openTrainer()
    {
        Intent intent = new Intent(this, Activity_Trainer.class);
        startActivity(intent);
    }
}