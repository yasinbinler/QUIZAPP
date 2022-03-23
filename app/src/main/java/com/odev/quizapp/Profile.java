package com.odev.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.gson.Gson;

public class Profile extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int[] sikSecimleri;
    int testNo;
    Button esSonuc, zekaSonuc, zenginSonuc, kisilikSonuc, renkSonuc;
    Button cık;
    TextView name,email;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Gson gson = new Gson();
        testNo = sharedPreferences.getInt("testno", 0);
        if(sharedPreferences.getBoolean("ilkgiris",false)==false)
            sikSecimleri = gson.fromJson(sharedPreferences.getString("json", ""), int[].class);
        else sikSecimleri = new int[46];
        esSonuc = findViewById(R.id.essonuc);
        zekaSonuc = findViewById(R.id.zekasonuc);
        zenginSonuc = findViewById(R.id.zenginsonuc);
        kisilikSonuc = findViewById(R.id.kisiliksonuc);
        cık=findViewById(R.id.btnCık);
        name = findViewById(R.id.nameText);
        email = findViewById(R.id.mailText);
        name.setText(sharedPreferences.getString("name",""));
        email.setText(sharedPreferences.getString("email",""));

        cık.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Profile.this, MainActivity.class));
            }
        });

        renkSonuc = findViewById(R.id.renksonuc);
        if (sikSecimleri[14] == 0){
          zekaSonuc.setEnabled(false);
          zekaSonuc.setAlpha(.5f);
        }
        if (sikSecimleri[22] == 0){
            kisilikSonuc.setEnabled(false);
            kisilikSonuc.setAlpha(.5f);
        }
        if (sikSecimleri[29] == 0){
            zenginSonuc.setEnabled(false);
            zenginSonuc.setAlpha(.5f);
        }
        if (sikSecimleri[36] == 0){
            esSonuc.setEnabled(false);
            esSonuc.setAlpha(.5f);
        }
        if (sikSecimleri[45] == 0){
            renkSonuc.setEnabled(false);
            renkSonuc.setAlpha(.5f);
        }
esSonuc.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                esSonuc.setAlpha(.5f);
                break;
            case MotionEvent.ACTION_MOVE:
                esSonuc.setAlpha(.5f);
                break;
            case MotionEvent.ACTION_UP:
                esSonuc.setAlpha(1f);
                testNo = 0;
                editor.putInt("testno",testNo);
                editor.commit();
                startActivity(new Intent(Profile.this,Sonuc.class));
                break;

        }
        return true;
    }
});
        zekaSonuc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        zekaSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        zekaSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        zekaSonuc.setAlpha(1f);
                        testNo = 1;
                        editor.putInt("testno",testNo);
                        editor.commit();
                        startActivity(new Intent(Profile.this,Sonuc.class));
                        break;

                }
                return true;
            }
        });zenginSonuc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        zenginSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        zenginSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        zenginSonuc.setAlpha(1f);
                        testNo = 2;
                        editor.putInt("testno",testNo);
                        editor.commit();
                        startActivity(new Intent(Profile.this,Sonuc.class));
                        break;

                }
                return true;
            }
        });zenginSonuc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        zenginSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        zenginSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        zenginSonuc.setAlpha(1f);
                        testNo = 3;
                        editor.putInt("testno",testNo);
                        editor.commit();
                        startActivity(new Intent(Profile.this,Sonuc.class));
                        break;

                }
                return true;
            }
        });renkSonuc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        renkSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        renkSonuc.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        renkSonuc.setAlpha(1f);
                        testNo = 4;
                        editor.putInt("testno",testNo);
                        editor.commit();
                        startActivity(new Intent(Profile.this,Sonuc.class));
                        break;

                }
                return true;
            }
        });


    }

    public void showPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.testlerSek:
                startActivity(new Intent(Profile.this, Testler.class));
                break;
        }
        return true;
    }

}
