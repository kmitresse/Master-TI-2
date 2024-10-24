package fr.univpau.todo_list.listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.univpau.todo_list.entities.Task;
import fr.univpau.todo_list.adapters.TaskAdapter;

public class AddTaskButtonListener implements View.OnClickListener {

    EditText taskName;

    TaskAdapter taskAdapter;

    public AddTaskButtonListener(EditText taskName, TaskAdapter taskAdapter) {
        this.taskName = taskName;
        this.taskAdapter = taskAdapter;
    }

    @Override
    public void onClick(View v) {
        // Check if the task name is empty
        if (taskName.getText().toString().isEmpty()) {
            Toast.makeText(v.getContext(), "Le nom de la tâche ne peut pas être vide", Toast.LENGTH_SHORT).show();
            return;
        }
        // Add the task to the list
        Task task = new Task(taskName.getText().toString());
        taskAdapter.addTask(task);
        taskName.setText("");
        // Notify the user that the task has been created
        Toast.makeText(v.getContext(), "Une nouvelle tâche à été crée", Toast.LENGTH_SHORT).show();
    }
}
