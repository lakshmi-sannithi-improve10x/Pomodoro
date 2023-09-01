package com.improve10x.pomodoro;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.improve10x.pomodoro.databinding.TaskListItemBinding;
import com.squareup.picasso.Picasso;

public class TaskListItemsAdapter extends RecyclerView.Adapter<TaskListItemViewHolder> {
     private TaskListItem[] items;
     private OnTaskListActionListener listener;

     public TaskListItemsAdapter(TaskListItem[] TaskListItems){
         items = TaskListItems;
     }

     void setOnTaskListActionListener(OnTaskListActionListener listener){
         this.listener = listener;
     }

     void  updateData(TaskListItem[] items){
         this.items = items;
         notifyDataSetChanged();
     }
    @NonNull
    @Override
    public TaskListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskListItemBinding binding = TaskListItemBinding.inflate(inflater,parent,false);
        TaskListItemViewHolder viewHolder = new TaskListItemViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListItemViewHolder holder, int position) {
         TaskListItem item = items[position];
         holder.binding.nameTxt.setText(item.name);
        Picasso.get().load(item.imageUrl).into(holder.binding.imageIv);
        holder.binding.deleteBtn.setOnClickListener(view -> {
            listener.onDelete(item.id);
        });
        holder.binding.editBtn.setOnClickListener(view -> {
            listener.onEdit(item);
        });
     }


    @Override
    public int getItemCount() {
         return items.length;
    }
}
