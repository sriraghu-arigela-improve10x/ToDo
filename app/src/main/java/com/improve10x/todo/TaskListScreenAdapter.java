package com.improve10x.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskListScreenAdapter extends RecyclerView.Adapter<TaskListScreenViewHolder> {

    public List<TaskListScreen> taskListScreensList;

    public void setData(List<TaskListScreen> taskListScreens) {
        taskListScreensList = taskListScreens;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TaskListScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasklistscreen_item, parent, false);
        TaskListScreenViewHolder taskListScreenViewHolder = new TaskListScreenViewHolder(view);
        return taskListScreenViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListScreenViewHolder holder, int position) {
        TaskListScreen taskListScreen = taskListScreensList.get(position);
        holder.titleTxt.setText(taskListScreen.title);
        holder.messageTxt.setText(taskListScreen.message);
    }

    @Override
    public int getItemCount() {
        return taskListScreensList.size();
    }
}
