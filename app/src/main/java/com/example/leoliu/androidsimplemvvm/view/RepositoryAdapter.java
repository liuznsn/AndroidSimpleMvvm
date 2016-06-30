package com.example.leoliu.androidsimplemvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.leoliu.androidsimplemvvm.R;
import com.example.leoliu.androidsimplemvvm.databinding.ItemRepositoryBinding;
import com.example.leoliu.androidsimplemvvm.model.Repository;
import com.example.leoliu.androidsimplemvvm.viewmodel.ItemMainViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by liuznsn on 2016/6/29.
 */
public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryAdapterViewHolder> {
    private List<Repository> mRepositoryList;
    public RepositoryAdapter() { this.mRepositoryList = Collections.emptyList(); }

    @Override
    public RepositoryAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRepositoryBinding ItemRepositoryBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_repository,
                        parent, false);
        return new RepositoryAdapterViewHolder(ItemRepositoryBinding);
    }

    @Override
    public void onBindViewHolder(RepositoryAdapterViewHolder holder, int position) {
        holder.bindRepository(mRepositoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepositoryList.size();
    }

    public void setRepositoryList(List<Repository> repositoryList) {
        this.mRepositoryList = repositoryList;
        notifyDataSetChanged();
    }

    public static class RepositoryAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemRepositoryBinding mItemRepositoryBinding;

        public RepositoryAdapterViewHolder(ItemRepositoryBinding itemRepositoryBinding) {
            super(itemRepositoryBinding.itemRepository);
            this.mItemRepositoryBinding = itemRepositoryBinding;
        }

        void bindRepository(Repository repository) {
            if(mItemRepositoryBinding.getItemMainViewModel() == null) {
                mItemRepositoryBinding.setItemMainViewModel(
                        new ItemMainViewModel(repository, itemView.getContext())
                );
            } else {
                mItemRepositoryBinding.getItemMainViewModel().setRepository(repository);
            }
        }

    }


}
