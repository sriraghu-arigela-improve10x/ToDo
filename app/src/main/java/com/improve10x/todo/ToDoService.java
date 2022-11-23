package com.improve10x.todo;

import java.util.List;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ToDoService {
   @GET("sriraghuTodo")
    Call<List<TaskListScreen>> fetchTasks();

   @POST("sriraghuTodo")
    Call<TaskListScreen> createTasks(@Body TaskListScreen taskListScreen);
}
