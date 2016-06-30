package com.example.leoliu.androidsimplemvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.leoliu.androidsimplemvvm.model.Repository;

/**
 * Created by liuznsn on 2016/6/29.
 */
public class ItemMainViewModel extends BaseObservable {

    private Repository mRepository;
    private Context mContext;

    public ItemMainViewModel(Repository repository, Context context) {
        mRepository = repository;
        mContext = context;
    }

    public String getDescription() {
        return mRepository.description;
    }

    public String getTitle() {
        return mRepository.fullName;
    }

    public String getAvatarUrl() {
        return mRepository.owner.avatarUrl;
    }

    @BindingAdapter({ "imageUrl" }) public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }


    public void setRepository(Repository repository) {
        this.mRepository = repository;
        notifyChange();
    }
}
