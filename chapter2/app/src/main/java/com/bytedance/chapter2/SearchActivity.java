package com.bytedance.chapter2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mSearchAdapter);

        String target = getIntent().getStringExtra("target");

        List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            String line = "第"+String.valueOf(i)+"行数据";
            if(line.contains(target)) {
                items.add(line);
            }
        }
        mSearchAdapter.notifyItems(items);
    }
}
