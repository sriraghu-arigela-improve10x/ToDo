package com.improve10x.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskListScreenActivity extends AppCompatActivity {

    public ArrayList<TaskListScreen> taskListScreensId;
    public RecyclerView taskListScreenRv;
    public  TaskListScreenAdapter taskListScreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_screen);
        getSupportActionBar().setTitle("Task List");
        taskListScreenAddBtn();
        setData();
        taskListScreensRv();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    public void fetchData() {
        ToDoApi toDoApi = new ToDoApi();
        ToDoService toDoService = toDoApi.createToDoService();
        Call<List<TaskListScreen>> call = toDoService.fetchTasks();
        call.enqueue(new Callback<List<TaskListScreen>>() {
            @Override
            public void onResponse(Call<List<TaskListScreen>> call, Response<List<TaskListScreen>> response) {
                List<TaskListScreen> taskListScreens = response.body();
                taskListScreenAdapter.setData(taskListScreens);
            }

            @Override
            public void onFailure(Call<List<TaskListScreen>> call, Throwable t) {
                Toast.makeText(TaskListScreenActivity.this, "Try after some time", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void taskListScreenAddBtn() {
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddTaskScreenActivity.class);
            startActivity(intent);
        });
    }

    public void taskListScreensRv() {
        taskListScreenRv = findViewById(R.id.task_screen_list_rv);
        taskListScreenRv.setLayoutManager(new LinearLayoutManager(this));
        taskListScreenAdapter = new TaskListScreenAdapter();
        taskListScreenAdapter.setData(taskListScreensId);
        taskListScreenRv.setAdapter(taskListScreenAdapter);
    }

    public void setData() {
        taskListScreensId = new ArrayList<>();

       /* TaskListScreen getVegetables = new TaskListScreen();
        getVegetables.title = "Get Vegetables";
        getVegetables.message = "for 1 week";
        taskListScreensId.add(getVegetables);

        TaskListScreen news = new TaskListScreen();
        news.title = "Reading news";
        news.message = "Explore politics filmy and sport news ";
        taskListScreensId.add(news);

        TaskListScreen prepareLunch = new TaskListScreen();
        prepareLunch.title = "Prepare Lunch";
        prepareLunch.message = "Biryani and Raitha. yummyyyy";
        taskListScreensId.add(prepareLunch);

        TaskListScreen breakFast = new TaskListScreen();
        breakFast.title = "Healthy breakfast for a better morning";
        breakFast.message = "for 1 week";
        taskListScreensId.add(breakFast);*/
    }
}