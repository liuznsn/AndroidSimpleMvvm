package com.example.leoliu.androidsimplemvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.leoliu.androidsimplemvvm.R;
import com.example.leoliu.androidsimplemvvm.databinding.ActivityMainBinding;
import com.example.leoliu.androidsimplemvvm.model.Repository;
import com.example.leoliu.androidsimplemvvm.viewmodel.MainViewModel;
import com.example.leoliu.androidsimplemvvm.viewmodel.MainViewModelContract;;import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewModelContract.MainView {

    private ActivityMainBinding mActivityMainBinding;
    private MainViewModel mMainViewModel;
    private MainViewModelContract.MainView mMainView = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        setupListRepositoryView(mActivityMainBinding.listRepository);
        mMainViewModel.Test();
    }

    private void initDataBinding(){
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mMainViewModel =  new MainViewModel(mMainView,getContext());
        mActivityMainBinding.setMainViewModel(mMainViewModel);
    }

    private void setupListRepositoryView(RecyclerView listRepositories){
        RepositoryAdapter adapter = new RepositoryAdapter();
        listRepositories.setAdapter(adapter);
        listRepositories.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainViewModel.destroy();
    }

    @Override
    public void loadData(List<Repository> repositories) {
       RepositoryAdapter repositoryAdapter = (RepositoryAdapter)mActivityMainBinding.listRepository.getAdapter();
        repositoryAdapter.setRepositoryList(repositories);
    }

    @Override
    public Context getContext() {
        return MainActivity.this;
    }
}
