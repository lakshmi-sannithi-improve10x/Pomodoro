package com.improve10x.pomodoro;

public interface OnTaskListActionListener {
    void onDelete(String id);

    void onEdit(TaskListItem item);
}
