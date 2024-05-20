package com.justify.grhypermart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Loginwithpage extends AppCompatActivity {

    EditText enternumber,passbutton;
    Button getotpbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginwithpage);

        enternumber.findViewById(R.id.Logipagebutton);
        passbutton.findViewById(R.id.passwordpage);
        getotpbutton.findViewById(R.id.getotpbutton);


        getotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Loginwithpage.this, Forgotpageslide.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_input_btn, R.anim.slide_output_btn);
            }
        });

    }
}