package com.justify.grhypermart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Loginpage extends AppCompatActivity {

    EditText mobilenumbers;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        mobilenumbers.findViewById(R.id.mobilenumber);
        loginbutton.findViewById(R.id.Logipagebutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mobilenumbers.getText().toString())) {
                    Toast.makeText(loginbutton.this, "please enter a valid phone number", Toast.LENGTH_SHORT).show();
                }

//
                loginbutton.setVisibility(View.INVISIBLE);

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + mobilenumbers.getText().toString(),
                        60,
                        TimeUnit.SECONDS, loginbutton.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                                verificationButton.setVisibility(view.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                verificationButton.setVisibility(view.VISIBLE);
                                Toast.makeText(loginbutton.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                Log.d("vignesh", "onVerificationFailed: " + e.getMessage());
                            }

                            @Override
                            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                loginbutton.setVisibility(View.VISIBLE);
                                Bundle bundle = new Bundle();
                                bundle.putString("key", verificationId);

                            }
                        });
                String value1 = mobilenumbers.getText().toString();
                String value2 = loginbutton.toString();
                Intent intent = new Intent(loginbutton.this, Otppage.class);
                intent.putExtra("key1", value1);
                intent.putExtra("key2", value2); // "key" is the identifier, value is the data you want to pass
                startActivity(intent);

            }
        });

    }
}