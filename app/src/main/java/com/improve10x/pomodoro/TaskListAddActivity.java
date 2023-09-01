package com.improve10x.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListAddActivity extends BaseTaskListAddEditActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleAddBtn();
    }

    private void handleAddBtn() {
        binding.addBtn.setOnClickListener(view -> {
            Call<TaskListItem> call = taskListInterface.createTaskListItem(createTaskListItem());
            call.enqueue(new Callback<TaskListItem>() {
                @Override
                public void onResponse(Call<TaskListItem> call, Response<TaskListItem> response) {
                    Toast.makeText(TaskListAddActivity.this, "size" + response.body(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<TaskListItem> call, Throwable t) {
                    Toast.makeText(TaskListAddActivity.this, "Failed Item", Toast.LENGTH_SHORT).show();
                }
            });
            Intent intent = new Intent(this,TaskListActivity.class);
            startActivity(intent);
        });
    }
}
