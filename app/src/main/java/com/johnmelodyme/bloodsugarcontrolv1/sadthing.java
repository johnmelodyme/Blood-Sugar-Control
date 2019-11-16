package com.johnmelodyme.bloodsugarcontrolv1;
/*
 *このページは、読み込みに伴うスプラッシュです。
 * これは John Melody Melissa によってコーディングされています。
 * このライセンスは、商標、サービスマーク、
 * または貢献者のロゴ（準拠するために必要な場合を除く）
 * セクション3.4の通知要件）。
 **/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class sadthing extends AppCompatActivity {

    TextView emailtodeveloperlaelseyouwillbeslowlycrying;
    TextView aboutUs;
    TextView $VERSION;
    Button Logout_登出;

    FirebaseAuth F_發克油;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sadthing);

        F_發克油 = FirebaseAuth.getInstance();

        emailtodeveloperlaelseyouwillbeslowlycrying = findViewById(R.id.emailtodeveloper);
        aboutUs = findViewById(R.id.Aboutus);
        $VERSION = findViewById(R.id.version);
        //Logout_登出 = findViewById(R.id.登出);

        emailtodeveloperlaelseyouwillbeslowlycrying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                johnmelodyme();
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starlabs();
            }
        });

        $VERSION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                version();
            }
        });


    }

    private void johnmelodyme() {
        Intent EmailDEV;
        String devemail;
        Uri email;
        email = Uri.parse("john@braintechgroup.com");
        EmailDEV = new Intent(Intent.ACTION_SENDTO);
        devemail = "mailto: John@braintechgroup.com";
        Toast.makeText(sadthing.this,
                devemail,
                Toast.LENGTH_SHORT)
                .show();
    }

    private void starlabs(){
        Intent 網站;
        網站 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.starlabs.com.my/"));
        startActivity(網站);
    }

    private void version(){
        Intent 網站;
        網站 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://github.com/johnmelodyme"));
        startActivity(網站);
    }

    private void please_log_out() {
        F_發克油.signOut();
        FirebaseAuth.AuthStateListener F_listener;
        F_listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user_la;
                user_la = firebaseAuth.getCurrentUser();
                if (user_la == null){
                    Intent toMainLA;
                    toMainLA = new Intent(sadthing.this, LoginActivitea.class);
                    startActivity(toMainLA);
                    finish();
                }
            }
        };
        gotomain();
    }

    private void gotomain() {
        Intent toMainLA;
        toMainLA = new Intent(sadthing.this, LoginActivitea.class);
        startActivity(toMainLA);
        finish();
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

