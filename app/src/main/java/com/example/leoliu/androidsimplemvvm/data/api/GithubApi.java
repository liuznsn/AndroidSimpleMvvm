package com.example.leoliu.androidsimplemvvm.data.api;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liuznsn on 2016/6/29.
 */
public interface GithubApi {

    String BASE_URL = "https://api.github.com";

    @GET("/search/repositories?q=java")
    Observable<GithubResponse> fetchRepositorys(@Query("page") int page);
}
