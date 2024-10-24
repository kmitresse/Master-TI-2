package fr.univpau.todo_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import fr.univpau.todo_list.adapters.TaskAdapter;
import fr.univpau.todo_list.entities.Task;
import fr.univpau.todo_list.listeners.AddTaskButtonListener;

public class TodoList extends AppCompatActivity {
    ArrayList<Task> tasks = new ArrayList<>();
    TaskAdapter taskAdapter;

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        Button addTaskButton = findViewById(R.id.addTaskButton);
        ListView taskList = findViewById(R.id.taskList);
        this.taskAdapter = new TaskAdapter(this, tasks);
        taskList.setAdapter(this.taskAdapter);

        addTaskButton.setOnClickListener(new AddTaskButtonListener(findViewById(R.id.addTaskText), this.taskAdapter));
    }

    /**
     * Initialize the contents of the Activity's standard options menu.
     * @param menu The options menu in which you place your items.
     *
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    /**
     * This method is called when an item in the options menu is selected.
     * @param item The menu item that was selected.
     *
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuRemoveAll) {
            this.taskAdapter.removeAll();
            return true;
        }
        if (item.getItemId() == R.id.menuRemoveChecked) {
            this.taskAdapter.removeChecked();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}