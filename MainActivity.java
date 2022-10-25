package com.example.tp5b_u21987540;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Plateau plateau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        plateau = new Plateau(this);
        setContentView(plateau);
    }
}
