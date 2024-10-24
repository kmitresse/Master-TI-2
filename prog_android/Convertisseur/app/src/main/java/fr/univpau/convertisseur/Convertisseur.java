package fr.univpau.convertisseur;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.os.Bundle;

public class Convertisseur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertisseur);
        Button convertButton = findViewById(R.id.convertButton);
        Log.i("TP2-Info", "Button '"+convertButton.getText().toString()+"' found");
        convertButton.setOnClickListener(new ButtonListener(findViewById(R.id.srcUnit), findViewById(R.id.destUnit), findViewById(R.id.srcValue), findViewById(R.id.destValue)));
    }
}