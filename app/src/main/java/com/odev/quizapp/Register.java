package com.odev.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private Button kaydol;
    private EditText name, email, password, passwordRetry;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        kaydol = findViewById(R.id.button2);
        name = findViewById(R.id.name);
        email = findViewById(R.id.emailEdit);
        password = findViewById(R.id.password);
        passwordRetry = findViewById(R.id.passwordretry);


        kaydol.setOnTouchListener(new View.OnTouchListener() {
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
                        kaydol.setAlpha(1f);
                        if(name.getText().length()<=0)
                            Toast.makeText(Register.this, "Ad Soyad alanı boş bırakılamaz", Toast.LENGTH_SHORT).show();
                        else if(email.getText().length()<=0)
                            Toast.makeText(Register.this, "e-mail alanı boş bırakılamaz", Toast.LENGTH_SHORT).show();
                        else if(password.getText().length()<=0||passwordRetry.getText().length()<=0)
                            Toast.makeText(Register.this, "şifre alanı boş bırakılamaz", Toast.LENGTH_SHORT).show();
                        else if(!password.getText().toString().equals(passwordRetry.getText().toString()))
                            Toast.makeText(Register.this, "Şifreler eşleşmiyor", Toast.LENGTH_SHORT).show();
                        else {
                            Toast.makeText(Register.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                            editor.putString("email",String.valueOf(email.getText()));
                            editor.putString("name",String.valueOf(name.getText()));
                            editor.putString("password",String.valueOf(password.getText()));
                            editor.putBoolean("ilkgiris",true);
                            editor.putBoolean("girisok",true);
                            editor.commit();
                            startActivity(new Intent(Register.this,MainActivity.class));
                        }
                        break;
                }
                return true;
            }
        });
    }
}
