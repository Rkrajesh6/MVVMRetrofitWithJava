package com.example.mvvmdemo.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmdemo.bean.Hero;
import com.example.mvvmdemo.network.Api;
import com.example.mvvmdemo.network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    private static NewsRepository newsRepository;

    public static NewsRepository getInstance(){
        if(newsRepository == null){
            newsRepository = new NewsRepository();
        }
        return newsRepository;
    }

    private Api api;

    public NewsRepository(){
        api = NetworkService.cteateService(Api.class);
    }

    public MutableLiveData<List<Hero>> getHeroesList(){
        final MutableLiveData<List<Hero>> mutableLiveData = new MutableLiveData<>();
        api.getHeroes().enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
               mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }
}
