package com.improve10x.todo;

import com.google.gson.annotations.SerializedName;

public class TaskListScreen {
    @SerializedName("task")
    public String title;
    @SerializedName("description")
    public String message;
}
