package com.example.leoliu.androidsimplemvvm.viewmodel;

import android.content.Context;

import com.example.leoliu.androidsimplemvvm.model.Repository;

import java.util.List;

/**
 * Created by liuznsn on 2016/6/29.
 */
public interface MainViewModelContract {

    interface MainView {

        Context getContext();

        void loadData(List<Repository> repositories);
    }

    interface ViewModel {

        void destroy();
    }
}
