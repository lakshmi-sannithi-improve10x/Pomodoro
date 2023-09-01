package com.improve10x.pomodoro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListEditActivity extends BaseTaskListAddEditActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        TaskListItem taskListItem = (TaskListItem) intent.getSerializableExtra("item");
        setData(taskListItem);
        handleUpdateBtn(taskListItem.id);
    }

    private void setData(TaskListItem taskListItem) {
        binding.imageTxt.setText(taskListItem.imageUrl);
        binding.nameTxt.setText(taskListItem.name);
    }

    private void handleUpdateBtn(String id) {
        binding.updateBtn.setOnClickListener(view -> {
            Call<Void> call = taskListInterface.updateTaskListItem(id,createTaskListItem());
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    Toast.makeText(TaskListEditActivity.this, "Updated Item", Toast.LENGTH_SHORT).show();
                    finish();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(TaskListEditActivity.this, "Failed Item", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }


}
