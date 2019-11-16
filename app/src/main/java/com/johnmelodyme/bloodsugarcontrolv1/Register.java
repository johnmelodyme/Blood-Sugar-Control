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
import android.os.Bundle;
import android.os.Handler;
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
import com.google.firebase.auth.FirebaseUser;


public class Register extends AppCompatActivity {

    ImageView 公司;
    EditText 什麼電郵;
    EditText 什麼密碼;
    EditText 什麼姓名;
    Button 什麼按鍵;

    FirebaseAuth F_發克油;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentikaxion);

        F_發克油 = FirebaseAuth.getInstance();

        公司 = findViewById(R.id.羅狗);
        什麼電郵 = findViewById(R.id.登錄電郵);
        什麼密碼 = findViewById(R.id.密碼);
        什麼姓名 = findViewById(R.id.姓名);
        什麼按鍵 = findViewById(R.id.註冊);

        什麼按鍵.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = 什麼電郵.getText()
                        .toString()
                        .trim();

                String password = 什麼密碼.getText()
                        .toString()
                        .trim();

                if(TextUtils.isEmpty(email)){
                    String enterEmailPLS;
                    enterEmailPLS = "Please Enter your Email";
                    Toast.makeText(Register.this, enterEmailPLS
                            , Toast.LENGTH_SHORT)
                            .show();
                }

                if (TextUtils.isEmpty(password)){
                    String enterPasswordPLS;
                    enterPasswordPLS = "Please enter Password";
                    Toast.makeText(Register.this, enterPasswordPLS
                    ,Toast.LENGTH_SHORT)
                    .show();
                }

                if (password.length() <= 6 ){
                    String enterpasswordsixandmorechar;
                    enterpasswordsixandmorechar = "Please enter a strong passwor <Min. 6 character>";
                    Toast.makeText(Register.this, enterpasswordsixandmorechar,
                            Toast.LENGTH_LONG)
                            .show();
                }

                F_發克油.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                //如果登錄失敗，則向用戶顯示一條消息。如果登錄成功
                                //將會通知auth狀態監聽器，並提供邏輯來處理
                                //登錄的用戶可以在偵聽器中處理。

                                String msg;
                                String failed_la_bodoh;
                                msg = "createUserWithEmail:onComplete";
                                failed_la_bodoh = "Authentication failed.";

                                Toast.makeText(Register.this,
                                        msg + task.isSuccessful(),
                                        Toast.LENGTH_SHORT)
                                        .show();

                                if (!task.isSuccessful()){
                                    Toast.makeText(Register.this,
                                            failed_la_bodoh + task.getException(),
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                                else {
                                    Intent tomainpagela;
                                    tomainpagela = new Intent(Register.this, MainPage.class);
                                    startActivity(tomainpagela);
                                    finish();
                                }
                            }
                        });
            }
        });

              /*  String 按鍵;
                按鍵 = "Registered";

                Toast.makeText(Register.this, 按鍵,
                        Toast.LENGTH_SHORT)
                        .show();

                // 非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常重要的設置 ::
                String email;
                String password;
                String name;

                email = 什麼電郵.getText().toString().trim();
                password = 什麼密碼.getText().toString().trim();
                name = 什麼姓名.getText().toString().trim();

                if (email.isEmpty() && password.isEmpty() && name.isEmpty() ){

                    String nameEnter;
                    String passwordEnter;
                    String emailEnter;

                    emailEnter = "Please Enter Email";
                    nameEnter = "Please Enter Name";
                    passwordEnter = "Please Enter Password";


                    什麼電郵.setError(emailEnter);
                    什麼電郵.requestFocus();

                    什麼姓名.setError(nameEnter);
                    什麼姓名.requestFocus();

                    什麼密碼.setError(passwordEnter);
                    什麼密碼.requestFocus();

                } else if (password.length() == 0 ){
                    什麼密碼.setError("The Password Must Be More Than 8 Letters");
                } else {
                    System.out.println("\uD83E\uDD70\uD83E\uDD70\uD83E\uDD70");
                    // 網絡服務器//
                    F_發克油.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //如果登錄失敗，則向用戶顯示一條消息。如果登錄成功
                                    //將會通知auth狀態監聽器，並提供邏輯來處理
                                    //登錄的用戶可以在偵聽器中處理。
                                    if(!task.isSuccessful()){
                                        String failed = "Try Again <506>";
                                        Toast.makeText(Register.this,
                                                failed + task.getException(),
                                                Toast.LENGTH_SHORT)
                                                .show();
                                    } else {
                                        Intent music_音樂播放器;
                                        music_音樂播放器 = new Intent(Register.this, MainPage.class);
                                        startActivity(music_音樂播放器);
                                        finish();
                                    }
                                }
                            });
                }
            }
        });*/

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

    @Override
    protected void onResume() {
        super.onResume();
    }
}