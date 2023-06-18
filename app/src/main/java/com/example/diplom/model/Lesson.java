package com.example.diplom.model;

public class Lesson {
    private String id; // поле идентификатора урока
    private String title; // поле заголовка урока
    private String homework; // поле домашнего задания урока

    // конструктор
    public Lesson(String id, String title, String homework) {
        this.id = id;
        this.title = title;
        this.homework = homework;
    }

    // геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String description) {
        this.homework = description;
    }
}
