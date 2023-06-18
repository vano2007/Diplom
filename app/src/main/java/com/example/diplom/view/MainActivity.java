package com.example.diplom.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplom.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton buttonRemind;
    private Button buttonEditLessons, buttonWriteHomework;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRemind = findViewById(R.id.buttonRemind);
        buttonEditLessons = findViewById(R.id.buttonEditLessons);
        buttonWriteHomework = findViewById(R.id.buttonWriteHomework);

        buttonRemind.setOnClickListener(listener);
        buttonEditLessons.setOnClickListener(listener);
        buttonWriteHomework.setOnClickListener(listener);

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // переключение на новую активность
            Intent intent = new Intent(getApplicationContext(), DaySelectionActivity.class);
            startActivity(intent);

        }
    };
}
