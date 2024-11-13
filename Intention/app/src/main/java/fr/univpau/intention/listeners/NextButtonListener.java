package fr.univpau.intention.listeners;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.content.Context;
import android.view.View;

public class NextButtonListener implements View.OnClickListener {

    Context context;
    Class<?> nextActivity;

    public NextButtonListener(Context context, Class<?> nextActivity) {
        this.context = context;
        this.nextActivity = nextActivity;
    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.setClass(context, nextActivity);
        context.startActivity(i);
    }
}
