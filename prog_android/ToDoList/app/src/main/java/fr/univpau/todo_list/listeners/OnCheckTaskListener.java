package fr.univpau.todo_list.listeners;

import android.widget.CompoundButton;

import fr.univpau.todo_list.entities.Task;

public class OnCheckTaskListener implements CompoundButton.OnCheckedChangeListener {

    private Task task;

    public OnCheckTaskListener(Task task) {
        this.task = task;
    }

    /**
     * Called when the checked state of a compound button has changed.
     * @param checkbox The compound button view whose state has changed.
     * @param isChecked The new checked state of buttonView.
     */
    @Override
    public void onCheckedChanged(CompoundButton checkbox, boolean isChecked) {
        task.setDone(isChecked);
    }
}
