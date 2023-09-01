package com.improve10x.pomodoro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TaskListInterface {
    @GET("laksmiTaskListItems")
    Call<TaskListItem[]> getTaskListItem();

    @POST("laksmiTaskListItems")
    Call<TaskListItem> createTaskListItem(@Body TaskListItem taskListItem);

    @DELETE("laksmiTaskListItems/{id}")
    Call<Void>  deleteTaskListItem(@Path("id") String id);

    @PUT("laksmiTaskListItems/{id}")
    Call<Void>  updateTaskListItem(@Path("id") String id,@Body TaskListItem taskListItem);
}
