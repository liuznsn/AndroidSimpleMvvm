package com.example.leoliu.androidsimplemvvm;

import android.app.Application;
import android.content.Context;

import com.example.leoliu.androidsimplemvvm.data.api.GithubApi;
import com.example.leoliu.androidsimplemvvm.data.api.GithubFactory;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by liuznsn on 2016/6/29.
 */
public class GithubApplication extends Application {

    private GithubApi mGithubApi;
    private Scheduler mScheduler;

    private static GithubApplication get(Context context) {
        return (GithubApplication) context.getApplicationContext();
    }

    public static GithubApplication create(Context context) {
        return GithubApplication.get(context);
    }

    public GithubApi getGithubApi() {
        if (mGithubApi == null) mGithubApi = GithubFactory.create();

        return mGithubApi;
    }

    public Scheduler subscribeScheduler() {
        if (mScheduler == null) mScheduler = Schedulers.io();

        return mScheduler;
    }

    public void setGithubApi(GithubApi githubApi) {
        mGithubApi = githubApi;
    }

    public void setScheduler(Scheduler scheduler) {
        mScheduler = scheduler;
    }

}
