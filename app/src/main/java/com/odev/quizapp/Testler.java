package com.odev.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Testler extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    RecyclerView recyclerView;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testler);
        sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        final TestAdapter testAdapter = new TestAdapter(this, tests.getData());
        recyclerView.setAdapter(testAdapter);
        testAdapter.setOnItemClickListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        v.setAlpha(.5f);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        v.setAlpha(.5f);

                        break;
                    case MotionEvent.ACTION_SCROLL:
                        v.setAlpha(1f);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        v.setAlpha(1f);
                        break;
                    case MotionEvent.ACTION_UP:
                        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
                        int position = viewHolder.getAdapterPosition();
                        // viewHolder.getItemId();
                        // viewHolder.getItemViewType();
                        // viewHolder.itemView;7
                        v.setAlpha(1f);

                        tests thisItem = tests.getData().get(position);
                        editor.putInt("testno",position);
                        editor.commit();
                        startActivity(new Intent(Testler.this,Question.class));
                       // Toast.makeText(Testler.this, "You Clicked: " + position, Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void showPopup(View v)
    {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.profil:
                startActivity(new Intent(Testler.this,Profile.class));
                break;
        }
        return false;
    }
}
