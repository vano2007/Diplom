package com.example.diplom.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diplom.R;
import com.example.diplom.viewmodel.DatabaseHelperLesson;

public class UpdateActivity extends AppCompatActivity {

    // создание полей
    private EditText title, homework;
    private Button updateLesson, deleteLesson;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        // присваивание id полям
        title = findViewById(R.id.title);
        homework = findViewById(R.id.homework);
        updateLesson = findViewById(R.id.update_lesson);
        deleteLesson = findViewById(R.id.delete_lesson);

        // считывание данных из переданного намерения Intent
        Intent intent = getIntent();
        // запись этих данных на экран активности
        title.setText(intent.getStringExtra("title"));
        homework.setText(intent.getStringExtra("homework"));
        id = intent.getStringExtra("id");

        // обработка нажатия кнопки
        updateLesson.setOnClickListener(listener);
        deleteLesson.setOnClickListener(listener);
    }
    // задание слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // если исправленный текст не пустой, то обновление записи в БД
            if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(homework.getText().toString())) {
                DatabaseHelperLesson database = new DatabaseHelperLesson(UpdateActivity.this); // создание объекта БД в текущей активности

                // обработка кнопки
                switch (view.getId()) {
                    case R.id.update_lesson:
                        // обновление заметки
                        database.updateLesson(title.getText().toString(), homework.getText().toString(), id); // обновление записи в БД по id
                        break;
                    case R.id.delete_lesson:
                        // удаление заметки
                        database.deleteSingleItem(id); // удаление записи БД по id
                        break;
                }

                startActivity(new Intent(UpdateActivity.this, MainActivity.class)); // переключение обратно в активность демонстрации всех записей
            } else { // иначе просто тост об отсутствии изменений
                Toast.makeText(UpdateActivity.this, "Изменений не внесено", Toast.LENGTH_SHORT).show();
            }
        }
    };
}