package com.improve10x.pomodoro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.improve10x.pomodoro.databinding.ActivityBaseTaskListAddEditBinding;

public class BaseTaskListAddEditActivity extends AppCompatActivity {
   protected ActivityBaseTaskListAddEditBinding binding;
   protected TaskListInterface taskListInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBaseTaskListAddEditBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupApi();
    }

    private void setupApi() {
        taskListInterface = new TaskListApi().createTaskInterface();
    }

    protected TaskListItem createTaskListItem(){
        TaskListItem taskListItem = new TaskListItem();
        taskListItem.imageUrl= binding.imageTxt.getText().toString();
        taskListItem.name = binding.nameTxt.getText().toString();
        return taskListItem;
    }
}