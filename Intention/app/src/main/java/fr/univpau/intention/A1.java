package fr.univpau.intention;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class A1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            // Start the activity A2
            startActivity(new Intent(this, A2.class));
        });
    }
}