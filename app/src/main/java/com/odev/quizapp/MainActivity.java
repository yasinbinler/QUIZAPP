package com.odev.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button giris;
    private TextView kaydol;
    SharedPreferences sharedPreferences;
    ConstraintLayout layo1,layo2;
    EditText name, password;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        layo1 = findViewById(R.id.layo1);
        layo2 = findViewById(R.id.layo2);

        giris = findViewById(R.id.button);
        kaydol = findViewById(R.id.kayitol);

        name =findViewById(R.id.emailEdit);
        password=findViewById(R.id.editText2);
        StartAnimations();
        kaydol.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        kaydol.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        kaydol.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        startActivity(new Intent(MainActivity.this,Register.class));
                        kaydol.setAlpha(1f);
                        break;
                }
                return true;
            }
        });

        giris.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        giris.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        giris.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:

                        break;

                }

                return false;
            }
        });
        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if(sharedPreferences.getBoolean("girisok",false))
                if(sharedPreferences.getString("email",".").contains(name.getText().toString())&&
                        sharedPreferences.getString("password",".").contains(password.getText().toString()))
                {
                    startActivity(new Intent(MainActivity.this,Profile.class));
                    finish();
                }else{
                    giris.setAlpha(1f);
                    Toast.makeText(MainActivity.this, "Kullanıcı Yok Ya Da Hatalı Giriş Yaptınız", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }



    private void StartAnimations() {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ConstraintLayout l=findViewById(R.id.layo1);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv =  findViewById(R.id.Logo);
        iv.clearAnimation();

        anim.setAnimationListener(new Animation.AnimationListener() {


            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub
            }


            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                    layo2.setVisibility(View.VISIBLE);
            }
        });
        iv.startAnimation(anim);

    }
}
