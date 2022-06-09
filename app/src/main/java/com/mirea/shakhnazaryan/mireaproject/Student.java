package com.mirea.shakhnazaryan.mireaproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String university;
    public String age;

    public Student(String name, String university, String age) {
        this.name = name;
        this.university = university;
        this.age = age;
    }
}
