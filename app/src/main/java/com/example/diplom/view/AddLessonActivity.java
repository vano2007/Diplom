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

public class AddLessonActivity extends AppCompatActivity {

    // создание полей
    private EditText title, homework;
    private Button addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);

        // присваивание id полям
        title = findViewById(R.id.title_edit);
        homework = findViewById(R.id.homework_edit);
        addNote = findViewById(R.id.add_note);

        // обработка нажатия кнопки
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // если исправленный текст не пустой, то обновление записи в БД
                if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(homework.getText().toString())){

                    DatabaseHelperLesson database = new DatabaseHelperLesson(AddLessonActivity.this); // создание объекта БД в текущей активности
                    database.addLesson(title.getText().toString(), homework.getText().toString()); // создание записи в БД

                    // создание намерения переключения активности
                    Intent intent = new Intent(AddLessonActivity.this, MainActivity.class); // переключение обратно в активность демонстрации всех записей
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); // установления флага экономии ресурсов
                    startActivity(intent);

                    finish(); // при нажатии на кнопку назад действие уничтожается и проиходит переход в активность MainActivity

                } else { // иначе просто тост об отсутствии изменений
                    Toast.makeText(AddLessonActivity.this, "Необходимо заполнить оба поля", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}