package com.bytedance.chapter2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        EditText met = findViewById(R.id.et);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchAdapter);

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            String line = "第"+String.valueOf(i)+"行数据";
            items.add(line);
        }
        mSearchAdapter.notifyItems(items);

        met.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence c,int a,int b,int d){
                //pass
            }

            @Override
            public void afterTextChanged(Editable s){
                String content = s.toString();
                List<String> items = new ArrayList<>();
                for (int i = 0; i < 100; i++){
                    String line = "第"+String.valueOf(i)+"行数据";
                    if (line.contains(content)){
                        items.add(line); }
                }
                mSearchAdapter.notifyItems(items);
            }

            @Override
            public void onTextChanged(CharSequence c,int a,int b,int d){

            }
        });
    }
}