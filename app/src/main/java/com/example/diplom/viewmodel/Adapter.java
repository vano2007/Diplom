package com.example.diplom.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplom.R;
import com.example.diplom.model.Lesson;
import com.example.diplom.view.UpdateActivity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    // поля адаптера
    private Context context; // поле для контекста
    private Activity activity; // поле для активности
    private List<Lesson> lessonListList; // поле для всех записей всех уроков
    private List<Lesson> newList; // поле для новой записи урока

    // конструктор
    public Adapter(Context context, Activity activity, List<Lesson> lessonListList) {
        this.context = context;
        this.activity = activity;
        this.lessonListList = lessonListList;
        newList = new ArrayList<>(lessonListList);
    }

    @NonNull
    // метод onCreateViewHolder() возвращает объект ViewHolder(), который будет хранить данные по одному объекту Lesson
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // трансформация layout-файла во View-элемент
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    // метод onBindViewHolder() выполняет привязку объекта ViewHolder к объекту Lesson по определенной позиции
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.title.setText(lessonListList.get(position).getTitle());
        holder.homework.setText(lessonListList.get(position).getHomework());

        // обработаем нажатие на контейнер lesson_recycler_view
        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // задание переключения на новый экран
                Intent intent = new Intent(context, UpdateActivity.class);
                // передача данных в новую активити
                intent.putExtra("title", lessonListList.get(position).getTitle());
                intent.putExtra("homework", lessonListList.get(position).getHomework());
                intent.putExtra("id", lessonListList.get(position).getId());
                // старт перехода
                activity.startActivity(intent);
            }
        });

    }

    // метод getItemCount() возвращает количество объектов в списке
    @Override
    public int getItemCount() {
        return lessonListList.size();
    }


    // созданный статический класс ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // поля представления
        TextView title, homework;
        ConstraintLayout mLayout;

        // конструктор класса ViewHolder с помощью которого мы связываем поля и представление lesson_recycler_view.xml
        ViewHolder(@NonNull View view) {
            super(view);
            title = view.findViewById(R.id.title);
            homework = view.findViewById(R.id.homework);
            mLayout = view.findViewById(R.id.mLayout);
        }
    }
}
