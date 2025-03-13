package com.example.databinding.test2.test11;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding.R;
import com.example.databinding.databinding.ViewRecyclerviewItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Person> mList;

    public MyAdapter() {
        mList = new ArrayList<>();
    }

    public MyAdapter(List<Person> list) {
        mList = list;
    }

    public void setData(List<Person> persons) {
        this.mList = persons;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewRecyclerviewItemBinding itemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.view_recyclerview_item,
                        parent,
                        false);

        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final ViewRecyclerviewItemBinding itemBinding;

        public ViewHolder(ViewRecyclerviewItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        void bind(Person person) {
            itemBinding.setPerson(person);
        }
    }
}