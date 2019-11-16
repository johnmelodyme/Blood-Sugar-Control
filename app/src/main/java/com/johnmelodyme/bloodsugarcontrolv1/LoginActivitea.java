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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class LoginActivitea extends AppCompatActivity {
    ImageView theStarlabthingy;
    EditText 電郵;
    EditText 密碼;
    Button 登錄按鍵;
    TextView 新來的;
    TextView 忘了密碼的;
    //TextView tmp;

    FirebaseAuth this_is_the_server_that_no_one_in_this_company_is_giving_a_shit_about;
    TextView welcome_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activitea);

        theStarlabthingy = findViewById(R.id.imageView照片);
        電郵 = findViewById(R.id.登錄電郵);
        密碼 = findViewById(R.id.登錄密碼);
        登錄按鍵 = findViewById(R.id.登錄按鍵);
        //新來的  = findViewById(R.id.新來的);
       // 忘了密碼的 = findViewById(R.id.忘了密碼的);

        //tmp = findViewById(R.id.temp);
       //welcome_user = findViewById(R.id.welcomeUserlawhatevershitla);
        this_is_the_server_that_no_one_in_this_company_is_giving_a_shit_about = FirebaseAuth.getInstance();

        if (this_is_the_server_that_no_one_in_this_company_is_giving_a_shit_about
                .getCurrentUser() != null){
            音樂();
        }
/*
        新來的.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent 註冊;
                註冊 = new Intent(LoginActivitea.this, Register.class);
                startActivity(註冊);
            }
        });



        忘了密碼的.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent 重設密碼;
                重設密碼 = new Intent(LoginActivitea.this, resetPassword.class);
                startActivity(重設密碼);
            }
        });
*/
//////////////////////////////////////////////////////
        /*
        OkHttpClient client;
        String url;
        Request request;

        client = new OkHttpClient();
        url = "https://starlabsbioscience.co.uk/bloodsugar/api/authentication/login";
        request = new Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String myresponse = response.body().string();

                    LoginActivitea.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            welcome_user.setText(myresponse);
                        }
                    });
                }
            }
        });

         */

        //////////////////////////////////////////////////////
        登錄按鍵.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 非常非常非常非常非常非常非常非常非常非常非常非常非常非常非常重要的設置 ::
                String email;
                final String password;
                email = 電郵.getText().toString();
                password = 密碼.getText().toString();
                /*
                if (email.isEmpty()){
                    String msg;
                    msg = "Please Enter Email";
                    電郵.setError(msg);
                    電郵.requestFocus();
                }
                if (password.isEmpty()){
                    String msg;
                    msg = "Please Enter Password";
                    密碼.setError(msg);
                    密碼.requestFocus();
                }
                else {
                    System.out.println("FUNCTION");
                    // 網絡服務器//
                    Intent 音樂播放器;
                    音樂播放器 = new Intent(LoginActivitea.this, MainPage.class);
                    startActivity(音樂播放器);
                }
                 */
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
                this_is_the_server_that_no_one_in_this_company_is_giving_a_shit_about
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivitea.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //如果登錄失敗，則向用戶顯示一條消息。如果登錄成功
                                //將會通知auth狀態監聽器，並提供邏輯來處理
                                //登錄的用戶可以在偵聽器中處理。
                                if (!task.isSuccessful()){
                                    if (password.length() <= 8 ){
                                        密碼.setError(
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
                                    音樂();
                                }
                            }
                        });
            }
        });

        /*
        tmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temporary();
            }
        });
         */
    }

    private void 音樂() {
        Intent musicpage;
        musicpage = new Intent(LoginActivitea.this, MainPage.class);
        startActivity(musicpage);
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser;
        currentUser = this_is_the_server_that_no_one_in_this_company_is_giving_a_shit_about.getCurrentUser();
    }

    public void temporary(){
        Intent temp;
        temp = new Intent(LoginActivitea.this, MainPage.class);
        startActivity(temp);
    }


    /////////////////////////////////////////////////////////////////////////////
    // 兩次按下以退出應用程序 ::
    boolean doubleBackToExitPressedOne = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOne) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOne = true;
        Toast.makeText(this, R.string.回,
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
