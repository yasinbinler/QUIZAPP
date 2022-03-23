package com.odev.quizapp;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;



public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder> {

    ArrayList<tests> mTestList;
    LayoutInflater inflater;
    private View.OnTouchListener mOnItemClickListener;

    public TestAdapter(Context context, ArrayList<tests> tests) {
        inflater = LayoutInflater.from(context);
        this.mTestList = tests;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.testcard, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        tests selectedTest = mTestList.get(position);
        holder.setData(selectedTest, position);
 }

    @Override
    public int getItemCount() {
        return mTestList.size();
    }
    public void setOnItemClickListener(View.OnTouchListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {

        ImageView testImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            testImage =  itemView.findViewById(R.id.testImage);
            itemView.setTag(this);
            itemView.setOnTouchListener(mOnItemClickListener);
        }

        public void setData(tests selectedProduct, int position) {

            this.testImage.setImageResource(selectedProduct.getImageID());

      }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }
}
