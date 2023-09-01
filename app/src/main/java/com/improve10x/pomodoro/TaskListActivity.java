package com.improve10x.pomodoro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.improve10x.pomodoro.databinding.ActivityTaskListBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListActivity extends AppCompatActivity implements OnTaskListActionListener {
   private ActivityTaskListBinding binding;
   private TaskListItem[] taskListItems = new TaskListItem[0];
   private TaskListItemsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTaskListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // createDummyData();
        setupAdapter();
        connectAdapter();
    }

    private void deleteApi(String id){
        TaskListInterface taskListInterface = new TaskListApi().createTaskInterface();
        Call<Void> call = taskListInterface.deleteTaskListItem(id);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(TaskListActivity.this, " Item Deleted ", Toast.LENGTH_SHORT).show();
                createApi();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createApi() {
        TaskListInterface taskListInterface = new TaskListApi().createTaskInterface();
        Call<TaskListItem[]> call = taskListInterface.getTaskListItem();
        call.enqueue(new Callback<TaskListItem[]>() {
            @Override
            public void onResponse(Call<TaskListItem[]> call, Response<TaskListItem[]> response) {
                Toast.makeText(TaskListActivity.this, "size" + response.body().length, Toast.LENGTH_SHORT).show();
                adapter.updateData(response.body());
            }

            @Override
            public void onFailure(Call<TaskListItem[]> call, Throwable t) {
                Toast.makeText(TaskListActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void connectAdapter() {
        binding.tasksRv.setLayoutManager(new LinearLayoutManager(this));
        binding.tasksRv.setAdapter(adapter);
    }

    private void setupAdapter() {
       adapter = new TaskListItemsAdapter(taskListItems) ;
       adapter.setOnTaskListActionListener(this);
    }

    @Override
    public void onDelete(String id) {
        deleteApi(id);
    }

    @Override
    public void onEdit(TaskListItem item) {
        Intent intent = new Intent(this,TaskListEditActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createApi();
    }

    // private void createDummyData() {
       // taskListItems = new TaskListItem[1];
       // taskListItems[0] = new TaskListItem();
       // taskListItems[0].imageUrl = "https://cdn3.vectorstock.com/i/thumb-large/54/67/bullseye-with-arrow-icon-vector-10465467.jpg";
        //taskListItems[0].name = "Reading News paper daily";
    //}
}