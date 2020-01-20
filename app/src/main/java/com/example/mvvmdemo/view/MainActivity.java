package com.example.mvvmdemo.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mvvmdemo.R;
import com.example.mvvmdemo.adapter.HeroesAdapter;
import com.example.mvvmdemo.bean.Hero;
import com.example.mvvmdemo.viewmodel.NewsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NewsViewModel model = ViewModelProviders.of(this).get(NewsViewModel.class);
        model.init();
        model.getHeroesListData().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
        String s1 = "C++";
        Log.e("TAG"," "+s1);
        //String s2 = "java";
        s1 = s1 + "Java";
        Log.e("TAG"," "+s1);
    }
}