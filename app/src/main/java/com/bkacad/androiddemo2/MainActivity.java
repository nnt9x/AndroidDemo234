package com.bkacad.androiddemo2;

import android.widget.Adapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvFoods;
    private MyAdapter myAdapter;
    private List<Food> foodList;

    private void initView() {
        // gán biến -> view XML
        lvFoods = findViewById(R.id.lvFoods);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        // Tạo dữ liệu
        foodList = new ArrayList<>();
        foodList.add(new Food("data:image/jpeg;base64,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","Bánh mì", "25000"));
        foodList.add(new Food("data:image/jpeg;base64,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","Bún bò","50000 VND"));
        // Tạo adapter
        myAdapter = new MyAdapter(this, foodList);
        // Set adpater cho listview
        lvFoods.setAdapter(myAdapter);
    }
}