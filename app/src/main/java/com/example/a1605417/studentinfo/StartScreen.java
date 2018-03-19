package com.example.a1605417.studentinfo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import extra.HideIt;

public class StartScreen extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        HideIt.hideitt(getWindow());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ((ImageView)findViewById(R.id.iv)).setImageResource(R.drawable.assd);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), Login.class));
                    }
                }, 3000);
            }
        },1000);

    }
}
