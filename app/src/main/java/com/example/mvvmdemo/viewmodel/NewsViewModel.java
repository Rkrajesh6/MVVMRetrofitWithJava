package com.example.mvvmdemo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.mvvmdemo.bean.Hero;
import com.example.mvvmdemo.repo.NewsRepository;

import java.util.List;

public class NewsViewModel extends ViewModel {

  private MutableLiveData<List<Hero>> listMutableLiveData;

    public void init(){
        if (listMutableLiveData != null){
            return;
        }
        NewsRepository newsRepository = NewsRepository.getInstance();
        listMutableLiveData = newsRepository.getHeroesList();

    }

    public LiveData<List<Hero>> getHeroesListData(){
        return listMutableLiveData;
    }

}
