package com.example.activity_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class activity_Bmi_Calc extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calc);

        back = (ImageView)findViewById(R.id.iv_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backtoCalcFragment();
            }
        });
    }
    public void backtoCalcFragment()
    {
        Intent intent = new Intent(this, fragment_calc.class);
        startActivity(intent);
    }
}