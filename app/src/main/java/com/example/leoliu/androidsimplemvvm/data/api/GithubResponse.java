package com.example.leoliu.androidsimplemvvm.data.api;

import com.example.leoliu.androidsimplemvvm.model.Repository;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuznsn on 2016/6/29.
 */
public class GithubResponse implements Serializable {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<Repository> items = new ArrayList<Repository>();


    public List<Repository> getItems() {
        return items;
    }
}
