package com.improve10x.pomodoro;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.pomodoro.databinding.TaskListItemBinding;


public class TaskListItemViewHolder extends RecyclerView.ViewHolder {
    TaskListItemBinding binding;

    public TaskListItemViewHolder(TaskListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
