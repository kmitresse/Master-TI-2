package fr.univpau.intention;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class A3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            // Start the activity A2
            startActivity(new Intent(this, A4.class));
        });
    }
}