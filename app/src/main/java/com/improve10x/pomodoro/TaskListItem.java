package com.improve10x.pomodoro;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TaskListItem implements Serializable {
    @SerializedName("_id")
    String id;
    String imageUrl;
    String name;
}
