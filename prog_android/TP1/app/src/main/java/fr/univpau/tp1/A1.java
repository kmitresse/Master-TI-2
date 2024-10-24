package fr.univpau.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class A1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        Log.i("TP1-Info", "onCreate appelée");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TP1-Info", "onStart appelée");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TP1-Info", "onStop appelée");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TP1-Info", "onDestroy appelée");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TP1-Info", "onPause appelée");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TP1-Info", "onResume appelée");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TP1-Info", "onResume appelée");
    }
}