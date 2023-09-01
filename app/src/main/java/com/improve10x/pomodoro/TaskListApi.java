package com.improve10x.pomodoro;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TaskListApi {

    public TaskListInterface createTaskInterface(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://crudcrud.com/api/479dd07f8c1d482e9219f7dcb48e25f4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TaskListInterface taskListInterface = retrofit.create(TaskListInterface.class);
        return taskListInterface;
    }
}
