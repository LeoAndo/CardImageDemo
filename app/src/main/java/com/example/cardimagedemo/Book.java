package com.example.cardimagedemo;

import androidx.annotation.NonNull;

public class Book {
    private final int id; // 本のID
    @NonNull
    private final String title; // 本のタイトル

    // 本の情報をコンストラクタで初期化する
    public Book(int id, @NonNull String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }


    // debugでoverrideしている.
//    @NonNull
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                '}';
//    }
}
