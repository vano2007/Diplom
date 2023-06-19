package com.example.diplom.view.day;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.diplom.R;
import com.example.diplom.model.Lesson;
import com.example.diplom.view.AddLessonActivity;
import com.example.diplom.viewmodel.Adapter;
import com.example.diplom.viewmodel.DatabaseHelperLesson;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FridayActivity extends AppCompatActivity {

    // создание полей
    private RecyclerView recyclerView; // поле для списка RecyclerView
    private FloatingActionButton fabAdd; // поле для кнопки добавить новый урок
    private FloatingActionButton fabDel; // поле для кнопки удалить урок

    private List<Lesson> notesList; // поле для контейнера списка уроков

    private DatabaseHelperLesson database; // поле работы с БД

    private Adapter adapter; // поле для адаптера

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        // присваивание id полям
        recyclerView = findViewById(R.id.recycler_list);
        fabAdd = findViewById(R.id.fabAdd);
        fabDel = findViewById(R.id.fabDel);

        notesList = new ArrayList<>(); // выделение памяти и задание типа контейнера для списка уроков
        database = new DatabaseHelperLesson(this); // выделение памяти и задание текущего контекста работы с БД

        // считывание данных из БД и запись их в коллекцию notesList
        fetchFridayLesson();

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // задание структуры вывода данных в recyclerView
        adapter = new Adapter(this, FridayActivity.this, notesList); // инициализация адаптера и передача в него данных из БД
        recyclerView.setAdapter(adapter); // передача в recyclerView адаптер

        // обработка нажатия кнопки создания новой заметки
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // переключение на новую активность
                startActivity(new Intent(FridayActivity.this, AddLessonActivity.class));
            }
        });
        // обработка нажатия кнопки удаления всех заметок
        fabDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // удаления записей
                database.deleteMondayLesson();
                // переключение активити с помощью намерения
                startActivity(new Intent(FridayActivity.this, FridayActivity.class));
                Toast.makeText(FridayActivity.this, "Данные из блокнота удалены", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // метод считывания из БД всех записей
    public void fetchFridayLesson(){
        // чтение БД и запись данных в курсор
        Cursor cursor = database.readLesson();

        if (cursor.getCount() == 0) { // если данные отсутствую, то вывод на экран об этом тоста
            Toast.makeText(this, "Заметок нет", Toast.LENGTH_SHORT).show();
        } else { // иначе помещение их в контейнер данных notesList
            while (cursor.moveToNext()){
                // помещение в контейнер notesList из курсора данных
                notesList.add(new Lesson(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }
        }
    }
}