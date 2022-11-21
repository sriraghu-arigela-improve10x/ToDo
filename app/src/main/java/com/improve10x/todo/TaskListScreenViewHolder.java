package com.improve10x.todo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskListScreenViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTxt;
    public TextView messageTxt;

    public TaskListScreenViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTxt = itemView.findViewById(R.id.title_txt);
        messageTxt = itemView.findViewById(R.id.message_txt);
    }
}
