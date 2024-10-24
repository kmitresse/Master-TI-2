package fr.univpau.todo_list.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import fr.univpau.todo_list.R;
import fr.univpau.todo_list.entities.Task;
import fr.univpau.todo_list.listeners.OnCheckTaskListener;


public class TaskAdapter extends ArrayAdapter<Task> {

    ArrayList<Task> tasks;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0);
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the view is already created
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.task_list, null);
        }
        // Get the task
        Task task = getItem(position);
        if (task == null) {
            return convertView;
        }
        // Get the views
        TextView taskName = convertView.findViewById(R.id.taskName);
        TextView taskDate = convertView.findViewById(R.id.taskDate);
        CheckBox taskDone = convertView.findViewById(R.id.taskCheck);

        // Set the task data
        taskDone.setOnCheckedChangeListener(null);
        taskName.setText(task.getName());
        taskDate.setText(task.getDate().toString());
        taskDone.setChecked(task.isDone());
        taskDone.setOnCheckedChangeListener(new OnCheckTaskListener(task));

        return convertView;

    }

    /**
     * Add a task to the list
     * @param task
     */
    public void addTask(Task task) {
        add(task);
    }

    /**
     * Remove all the tasks from the list
     */
    public void removeAll() {
        if (getCount() == 0) {
            Toast.makeText(this.getContext(), "Aucune tâche à supprimer", Toast.LENGTH_SHORT).show();
            return;
        }
        clear();
        Toast.makeText(this.getContext(), "Toutes les tâches ont été supprimées", Toast.LENGTH_SHORT).show();

    }

    /**
     * Remove all the checked tasks from the list
     */
    public void removeChecked() {
        int counter = 0;
        for (int i = 0; i < getCount(); i++) {
            Task task = getItem(i);
            if (task.isDone()) {
                remove(task);
                i--;
                counter++;
            }
        }
        if (counter == 0) {
            Toast.makeText(this.getContext(), "Aucune tâche à supprimée", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this.getContext(), counter + " tâches ont été supprimée", Toast.LENGTH_SHORT).show();

    }
}
