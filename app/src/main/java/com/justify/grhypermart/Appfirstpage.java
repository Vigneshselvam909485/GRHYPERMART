package com.justify.grhypermart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Appfirstpage extends AppCompatActivity {

    Button appsecondpage,appthirdpage,appfourthpage,appsignup;

    private static final int SPLASH_TIME_OUT = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appfirstpage);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app's main activity
                        Intent i = new Intent(Appfirstpage.this, Appsecondpage.class);
                        startActivity(i);

                        // Close this activity
                        finish();
                    }
                }, SPLASH_TIME_OUT);



        appsecondpage.findViewById(R.id.nextpagebtn);
        appthirdpage.findViewById(R.id.nextpage2btn);
        appfourthpage.findViewById(R.id.getstartedbtn);
        appsignup.findViewById(R.id.signinbtn);

        appsecondpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Appsecondpage.this, Appthirdpage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_input_btn, R.anim.slide_output_btn); // using the same animation for enter and exit
            }
        });

        appthirdpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Appthirdpage.this, Appfourthpage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_input_btn, R.anim.slide_output_btn); // using the same animation for enter and exit
            }
        });

        appfourthpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Appfourthpage.this, Appsignpage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_input_btn, R.anim.slide_output_btn); // using the same animation for enter and exit
            }
        });

        appsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Appsignpage.this, Loginpage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_input_btn, R.anim.slide_output_btn); // using the same animation for enter and exit
            }
        });

    }
}
