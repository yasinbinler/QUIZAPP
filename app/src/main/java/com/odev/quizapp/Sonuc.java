package com.odev.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Sonuc extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int[] sikSecimleri;
    TextView sonuc;
    int testNo;
    int zekaPuan;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Gson gson = new Gson();
        sonuc = findViewById(R.id.sonucText);
        testNo = sharedPreferences.getInt("testno",0);
        zekaPuan = sharedPreferences.getInt("zekaPuan",0);
        sikSecimleri = gson.fromJson(sharedPreferences.getString("json", ""), int[].class);

        sonuc.setText(String.valueOf(sikSecimleri[36]));

        switch(testNo)
        {
            case 0:
                    if(sikSecimleri[31]==2&&sikSecimleri[34]==2)
                        sonuc.setText("Kesinlikle ideal bir eşsiniz!");
                    else if(sikSecimleri[32]==1&&sikSecimleri[33]==1)
                        sonuc.setText("Kesinlikle ideal bir eşsiniz!");
                    else if(sikSecimleri[36]==1)
                        sonuc.setText("Çılgın ve Kesinlikle ideal bir eşsiniz!");
                    else if(sikSecimleri[34]==3)
                        sonuc.setText("Eşinizle ortak yönlerinizi daha çok görmeye çalışın.!");
                    else sonuc.setText("Kesinlikle ideal bir eşsiniz!");

                break;
            case 1:
                if(zekaPuan<=100)sonuc.setText("ORTALAMANIN  ALTINDASINIZ ☺");
                else
                if(zekaPuan>100&&zekaPuan<=120)sonuc.setText("ORTALAMA BİR KAPASİTEYE SAHİPSİNİZ");
                else
                if(zekaPuan>120&&zekaPuan<=130)sonuc.setText("ZEKİSİNİZ");
                else
                if(zekaPuan>130&&zekaPuan<=140)sonuc.setText("ÜSTÜN ZEKAYA SAHİPSİNİZ");
                else
                if(zekaPuan>140&&zekaPuan<=150)sonuc.setText("SİZ TAM BİR DEHASINIZ");
                break;
            case 2:
                if(sikSecimleri[23]==1)
                    sonuc.setText("parayı herhangi bir sektöre yatırır ondan faydalanırsınız.");
                else if(sikSecimleri[23]==2&&sikSecimleri[24]==1)
                    sonuc.setText("Yurt dışında yaşamaya başlayacaksınız.");
                else if(sikSecimleri[26]==1)
                    sonuc.setText("yat alacaksınız.");
                else if(sikSecimleri[28]==2)
                    sonuc.setText("kendi işini kuracaksın.");
                else sonuc.setText("dünya turuna çıkacaksınız.");
                break;
            case 3:
                if(sikSecimleri[15]==1)
                    sonuc.setText("Neşeli , Cana yakın,sempatik bir insansınız.");
                else if(sikSecimleri[15]==2)
                    sonuc.setText("Maceraperest, Çılgın, Neşeli, Şakacı ve Sabırsız bir insansınız.");
                else if(sikSecimleri[15]==3)
                    sonuc.setText("fedakar, merhametli, ince düşünceli, iyimser aynı zamanda duygusal bir insansınız.");
                else if(sikSecimleri[15]==4)
                    sonuc.setText("Sabırlı ve Duygusal bir insansınız.");
                break;
            case 4:
                if(sikSecimleri[37]==4)
                    sonuc.setText("Ruhunuz sarı renk.");
                else if(sikSecimleri[37]==2)
                    sonuc.setText("Ruhunuz kırmızı renk.");
                else if(sikSecimleri[37]==3)
                    sonuc.setText("Ruhunuz turuncu renk.");
                else if(sikSecimleri[44]==3)
                    sonuc.setText("Ruhunuz mor renk.");
                else if(sikSecimleri[41]==1)
                    sonuc.setText("Ruhunuz mavi renk.");
                else if(sikSecimleri[40]==3)
                    sonuc.setText("Ruhunuz pembe renk.");
                else if(sikSecimleri[40]==1)
                    sonuc.setText("Ruhunuz kırmızı renk.");
                else
                    sonuc.setText("Ruhunuz siyah renk.");
                break;
        }

    }

    public void showPopup(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.testlerSek:
                startActivity(new Intent(Sonuc.this, Testler.class));
                break;
            case R.id.profil:
                startActivity(new Intent(Sonuc.this, Profile.class));
                break;

        }
        return false;
    }
}
