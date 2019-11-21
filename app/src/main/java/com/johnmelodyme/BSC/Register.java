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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {
    /*I HAVE TO CHANGE ALL THE VARIABLE BECAUSE SOME PEOPLE
     * DON'T HAVE SENSE OF HUMOR AND PROBABLY THEY DON'T UNDERSTAND
     * WHAT I WROTE HERE. THEY HASTE TO ANGER AND EMPLOYER ARE ON
     * THEIR SIDE SO, OFF YOU GO.
     * #CRYINGBABY "you need to grow up and get sense of humor"
     */
    ImageView company;
    EditText whatever_email;
    EditText whatever_password;
    EditText Whoever_is_this;
    Button R_button;

    FirebaseAuth F;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentikaxion);

        /*
         * FIREBASE IS SOMETHING CHINA AND MY EMPLOYER HATE ABOUT
         * COMMUNISTIC VIEW, NARROW MINDED. JUST BECAUSE FIREBASE
         * IS TECHNOLOGY MY EMPLOYER HATE IT? RACIST!
         * ***********************************************
         * FIREBASE IS THE BEST! GOOGLE ARE GENEROUS!
         * */

        F = FirebaseAuth.getInstance();

        company = findViewById(R.id.羅狗);
        whatever_email = findViewById(R.id.登錄電郵);
        whatever_password = findViewById(R.id.密碼);
        Whoever_is_this = findViewById(R.id.姓名);
        R_button = findViewById(R.id.註冊);

        R_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = whatever_email.getText()
                        .toString()
                        .trim();

                String password = whatever_password.getText()
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

                F.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
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
    }

    // TEKAN DUA KALI UNTUK PULANG KE MAIN:
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