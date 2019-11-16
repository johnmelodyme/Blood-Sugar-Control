package com.johnmelodyme.bloodsugarcontrolv1;
/**
 *このページは、読み込みに伴うスプラッシュです。
 * これは John Melody Melissa によってコーディングされています。
 * このライセンスは、商標、サービスマーク、
 * または貢献者のロゴ（準拠するために必要な場合を除く）
 * セクション3.4の通知要件）。
 **/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetPassword extends AppCompatActivity {

    Button testing;
    Button send_發送;
    EditText email_電郵;
    EditText name_名字;

    FirebaseAuth auth_發克油;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        /*
        /// TEMP ::
        testing = findViewById(R.id.Testing);
        testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m;
                m = new Intent(resetPassword.this, MainPage.class);
                startActivity(m);
            }
        });
         */
        auth_發克油 = FirebaseAuth.getInstance();

        send_發送 = findViewById(R.id.發送);
        email_電郵 = findViewById(R.id.電郵_reset);
        name_名字 = findViewById(R.id.名_reset);

        send_發送.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_電郵
                        .getText()
                        .toString()
                        .trim();
                String name = name_名字
                        .getText()
                        .toString()
                        .trim();
                if(TextUtils.isEmpty(email)){
                    String enterEmail;
                    enterEmail = "Please Enter Your Email";
                    Toast.makeText(resetPassword.this,
                            enterEmail
                            , Toast.LENGTH_SHORT)
                            .show();
                }
                auth_發克油.sendPasswordResetEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    String resetEmailsentlawhatyouexpect = "We have sent you the reset email";
                                    Toast.makeText(resetPassword.this,
                                            resetEmailsentlawhatyouexpect,
                                            Toast.LENGTH_LONG)
                                            .show();
                                } else {
                                    String Contactdev = "Please Contact Developer :(";
                                    Toast.makeText(resetPassword.this,
                                            Contactdev,
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }
                        });
            }
        });
    }

    // 兩次按下以退出應用程序 ::
    boolean doubleBackToExitPressedOne = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOne) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOne = true;
        Toast.makeText(this, R.string.回回,
                Toast.LENGTH_SHORT)
                .show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOne = false;
            }
        }, 2000);
    }
}
