package com.improve10x.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTaskScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_screen);
        getSupportActionBar().setTitle("Add Task");
        Button addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(view -> {
            EditText taskTxt = findViewById(R.id.task_txt);
            String task = taskTxt.getText().toString();
            EditText descriptionTxt = findViewById(R.id.discription_txt);
            String description = descriptionTxt.getText().toString();
            createTask(task, description);
        });
    }

    public void createTask(String task, String description) {
        TaskListScreen taskListScreen = new TaskListScreen();
        taskListScreen.title = task;
        taskListScreen.message = description;

        ToDoApi toDoApi = new ToDoApi();
        ToDoService toDoService = toDoApi.createToDoService();
        Call<TaskListScreen> call = toDoService.createTasks(taskListScreen);
        call.enqueue(new Callback<TaskListScreen>() {
            @Override
            public void onResponse(Call<TaskListScreen> call, Response<TaskListScreen> response) {
                Toast.makeText(AddTaskScreenActivity.this, "Sunitha Good Girl", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<TaskListScreen> call, Throwable t) {
                Toast.makeText(AddTaskScreenActivity.this, "but some times moodOff", Toast.LENGTH_SHORT).show();
            }
        });
    }
}