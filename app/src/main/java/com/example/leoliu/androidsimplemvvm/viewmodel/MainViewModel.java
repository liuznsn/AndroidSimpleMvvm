package com.example.leoliu.androidsimplemvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.leoliu.androidsimplemvvm.GithubApplication;
import com.example.leoliu.androidsimplemvvm.R;
import com.example.leoliu.androidsimplemvvm.data.api.GithubApi;
import com.example.leoliu.androidsimplemvvm.data.api.GithubResponse;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by liuznsn on 2016/6/29.
 */
public class MainViewModel implements MainViewModelContract.ViewModel {

    private MainViewModelContract.MainView mMainView;
    private Context mContext;
    private Subscription mSubscription;

    public ObservableField<String> mMessageLabel;
    public ObservableInt mRepositoryList;


    public MainViewModel(@NonNull MainViewModelContract.MainView mainView, @NonNull Context context) {
        mMainView = mainView;
        mContext = context;
        mMessageLabel = new ObservableField<>("Test Message");
        mRepositoryList = new ObservableInt(View.GONE);
    }

    public void onClickFabLoad(View view) {
        fetchRepositories();
    }

    public void Test() {
        fetchRepositories();
    }

    private void fetchRepositories() {

        unSubscribeFromObservable();
        GithubApplication githubApplication = GithubApplication.create(mContext);
        GithubApi githubApi = githubApplication.getGithubApi();
        mSubscription = githubApi.fetchRepositorys(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(githubApplication.subscribeScheduler())
                .subscribe(new Action1<GithubResponse>() {
                    @Override
                    public void call(GithubResponse githubResponse) {
                        mRepositoryList = new ObservableInt(View.VISIBLE);
                        mMainView.loadData(githubResponse.getItems());
                    }
                }, new Action1<Throwable>() {
                    @Override public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        mMessageLabel.set("There seems to have been some error.");
                        mRepositoryList = new ObservableInt(View.GONE);
                    }
                });

    }


    @Override public void destroy() {
        reset();
    }

    private void unSubscribeFromObservable() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    private void reset() {
        unSubscribeFromObservable();
        mSubscription = null;
        mContext = null;
        mMainView = null;
    }

}
