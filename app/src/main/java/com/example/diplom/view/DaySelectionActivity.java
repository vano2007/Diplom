package com.example.diplom.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.diplom.R;
import com.example.diplom.view.day.FridayActivity;
import com.example.diplom.view.day.MondayActivity;
import com.example.diplom.view.day.SaturdayActivity;
import com.example.diplom.view.day.ThursdayActivity;
import com.example.diplom.view.day.TuesdayActivity;
import com.example.diplom.view.day.WednesdayActivity;

public class DaySelectionActivity extends AppCompatActivity {

        private ImageButton imageButtonMonday;
        private ImageButton imageButtonTuesday;
        private ImageButton imageButtonWednesday;
        private ImageButton imageButtonThursday;
        private ImageButton imageButtonFriday;
        private ImageButton imageButtonSaturday;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_selection);

        imageButtonMonday = findViewById(R.id.imageButtonMonday);
        imageButtonTuesday = findViewById(R.id.imageButtonTuesday);
        imageButtonWednesday = findViewById(R.id.imageButtonWednesday);
        imageButtonThursday = findViewById(R.id.imageButtonThursday);
        imageButtonFriday = findViewById(R.id.imageButtonFriday);
        imageButtonSaturday = findViewById(R.id.imageButtonSaturday);

        imageButtonMonday.setOnClickListener(listener);
        imageButtonTuesday.setOnClickListener(listener);
        imageButtonWednesday.setOnClickListener(listener);
        imageButtonThursday.setOnClickListener(listener);
        imageButtonFriday.setOnClickListener(listener);
        imageButtonSaturday.setOnClickListener(listener);

        }

        private View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.imageButtonMonday:
                        Intent intentMonday = new Intent(getApplicationContext(), MondayActivity.class);
                        intentMonday.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intentMonday);
                        break;
                    case R.id.imageButtonTuesday:
                        Intent intentTuesday = new Intent(getApplicationContext(), TuesdayActivity.class);
                        intentTuesday.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intentTuesday);
                        break;
                    case R.id.imageButtonWednesday:
                        Intent intentWednesday = new Intent(getApplicationContext(), WednesdayActivity.class);
                        intentWednesday.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intentWednesday);
                        break;
                    case R.id.imageButtonThursday:
                        Intent intentThursday = new Intent(getApplicationContext(), ThursdayActivity.class);
                        intentThursday.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intentThursday);
                        break;
                    case R.id.imageButtonFriday:
                        Intent intentFriday = new Intent(getApplicationContext(), FridayActivity.class);
                        intentFriday.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intentFriday);
                        break;
                    case R.id.imageButtonSaturday:
                        Intent intentSaturday = new Intent(getApplicationContext(), SaturdayActivity.class);
                        intentSaturday.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intentSaturday);
                        break;
                }
            }
        };
}