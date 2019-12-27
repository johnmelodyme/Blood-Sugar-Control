package com.johnmelodyme.BSC;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivitea extends AppCompatActivity {

    ImageView theStarlabthingy;
    EditText eeemail;
    EditText stupidPassword;
    Button loginbutton;
    FirebaseAuth auth_firebase;

    @Override
    public void onStart(){
        super.onStart();
        // From STACKOVERFLOW: https://stackoverflow.com/questions/59483359/silentmode-android-on-start
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager != null) {
            int currentMode = audioManager.getRingerMode();

            // Make ringer mode silent
            if (currentMode != AudioManager.RINGER_MODE_NORMAL) {
                System.out.println("----");
           //     audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            } else {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE,0);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activitea);

        theStarlabthingy = findViewById(R.id.imageView照片);
        eeemail = findViewById(R.id.登錄電郵);
        stupidPassword = findViewById(R.id.登錄密碼);
        loginbutton = findViewById(R.id.登錄按鍵);

        auth_firebase = FirebaseAuth.getInstance();


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email;
                final String password;
                email = eeemail.getText().toString();
                password = stupidPassword.getText().toString();

                String enterEmail = "Please Enter an Email";
                String enterPassword = "Please Enter Password";
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),
                            enterEmail,
                            Toast.LENGTH_SHORT)
                            .show();
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),
                            enterPassword,
                            Toast.LENGTH_SHORT)
                            .show();
                }
                auth_firebase
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivitea.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    if (password.length() <= 3 ){
                                        stupidPassword.setError(
                                                getString(
                                                        R.string.password_length
                                                )
                                        );
                                    }
                                    else {
                                        Toast.makeText(
                                                LoginActivitea.this,
                                                getString(
                                                        R.string.failed
                                                ),
                                                Toast.LENGTH_LONG
                                        ).show();
                                    }
                                } else {
                                    Intent toBLO;
                                    toBLO = new Intent(LoginActivitea.this, message.class);
                                    startActivity(toBLO);
                                }
                            }
                        });
            }
        });
    }
}
