package com.johnmelodyme.BSC;
/*
 * YES , THIS IS CODED BY ME,
 * I RANTING HERE BECAUSE THIS IS THE ONLY PLACE YOUR
 * NOTICE THE ISSUE.
 * I AM A HIGH SCHOOL STUDENT WHO STARTED TO CODE FROM BOOK
 * WHEN I WAS 15 , IN YOUR COUNTRY YOU STILL NEED
 * A COCK-LESS TEACHER TO TEACH YOU. AT LEAST AS POOR
 * AS MY COUNTRY IS , I LEARN FROM A BOOK.
 * YOU MIGHT MAKE FUN OF MY CODE, BECAUSE THE LITTLE PUSSY
 * OF YOU WANT TO CRY BUT THERE'S NO OPPORTUNITY TO DO SO,
 * BECAUSE COMMUNISM ALL ITS BEST.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  DON'T LIKE WHAT I SAY ? THEN BETTER RESPECT ME, MY RACE,
 *  MY COUNTRY AND MY JOB.
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

public class LoginActivitea extends AppCompatActivity {

    /*I HAVE TO CHANGE ALL THE VARIABLE BECAUSE SOME PEOPLE
    * DON'T HAVE SENSE OF HUMOR AND PROBABLY THEY DON'T UNDERSTAND
    * WHAT I WROTE HERE. THEY HASTE TO ANGER AND EMPLOYER ARE ON
    * THEIR SIDE SO, OFF YOU GO.
    * #CRYINGBABY "you need to grow up and get sense of humor"
     */
    ImageView theStarlabthingy;
    EditText eeemail;
    EditText stupidPassword;
    Button loginbutton;
    TextView newUser;
    TextView absentMinded;

    /*
    * FIREBASE IS SOMETHING CHINA AND MY EMPLOYER HATE ABOUT
    * COMMUNISTIC VIEW, NARROW MINDED. JUST BECAUSE FIREBASE
    * IS TECHNOLOGY MY EMPLOYER HATE IT? RACIST!
    * ***********************************************
    * FIREBASE IS THE BEST! GOOGLE ARE GENEROUS!
    * */
    FirebaseAuth auth_firebase;
    TextView welcome_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activitea);

        theStarlabthingy = findViewById(R.id.imageView照片);
        eeemail = findViewById(R.id.登錄電郵);
        stupidPassword = findViewById(R.id.登錄密碼);
        loginbutton = findViewById(R.id.登錄按鍵);
        newUser  = findViewById(R.id.新來的);
        absentMinded = findViewById(R.id.忘了密碼的);

        //tmp = findViewById(R.id.temp);
       //welcome_user = findViewById(R.id.welcomeUserlawhatevershitla);
        auth_firebase = FirebaseAuth.getInstance();

        if (auth_firebase
                .getCurrentUser() != null){
            moozik();
        }

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regista;
                regista = new Intent(LoginActivitea.this, Register.class);
                startActivity(regista);
            }
        });

        absentMinded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetpassword;
                resetpassword = new Intent(LoginActivitea.this, resetPassword.class);
                startActivity(resetpassword);
            }
        });

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
                                    if (password.length() <= 8 ){
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
                                    moozik();
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

    private void moozik() {
        Intent musicpage;
        musicpage = new Intent(LoginActivitea.this, MainPage.class);
        startActivity(musicpage);
    }

    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser;
        currentUser = auth_firebase.getCurrentUser();
    }

    public void temporary(){
        Intent temp;
        temp = new Intent(LoginActivitea.this, MainPage.class);
        startActivity(temp);
    }


    // बाहर निकलने के लिए दो बार क्लिक करें ::
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
