package com.bytedance.chapter_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv=findViewById(R.id.tv1);
        tv.setText("");
        Button bt = findViewById(R.id.bt1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String str  = "Hi, Fan Xi!";
                tv.setText(str);
                System.out.println("Log: "+str);
                tv.setTextColor(0xffffffff);
                tv.setBackgroundColor(0xff009933);
            }
        });
    }
}