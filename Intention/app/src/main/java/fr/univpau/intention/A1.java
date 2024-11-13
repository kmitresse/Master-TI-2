package fr.univpau.intention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import fr.univpau.intention.listeners.NextButtonListener;

public class A1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Button button = findViewById(R.id.button);
        button.setOnClickListener( new NextButtonListener(this, A2.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(null);
    }
}