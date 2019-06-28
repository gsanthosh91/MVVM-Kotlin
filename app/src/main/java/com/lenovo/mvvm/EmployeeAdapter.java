package com.lenovo.mvvm;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lenovo.mvvm.data.model.Employee;
import com.lenovo.mvvm.data.model.PlacesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 10-03-2018.
 */


public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyViewHolder> {
    private List<Employee> list;

    public EmployeeAdapter(Activity activity, List<Employee> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding layoutPlacesBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_employee,
                        parent, false);
        return new MyViewHolder(layoutPlacesBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, String resource) {
        Glide.with(imageView.getContext()).load(resource).into(imageView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public MyViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.obj, obj);
            binding.executePendingBindings();

        }
    }
}