package fr.univpau.todo_list.entities;

import java.util.Date;

public class Task {
    private final String name;
    private boolean done;
    private final Date date;

    public Task(String name) {
        this.name = name;
        this.done = false;
        this.date = new Date();
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Date getDate() {
        return date;
    }
}
