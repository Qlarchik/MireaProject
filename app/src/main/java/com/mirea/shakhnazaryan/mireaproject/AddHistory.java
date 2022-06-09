package com.mirea.shakhnazaryan.mireaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddHistory extends AppCompatActivity {
    private EditText nameEditStory;
    private EditText ageEditStory;
    private EditText universityEditStory;
    private Button btnSaveNewStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_history);

        nameEditStory = findViewById(R.id.editTextName);
        universityEditStory = findViewById(R.id.editTextUniversity);
        ageEditStory = findViewById(R.id.editTextAge);
        btnSaveNewStory = findViewById(R.id.saveButton3);
        btnSaveNewStory.setOnClickListener(this::saveStory);
    }

    public void saveStory(View view) {
        AppDatabase db = App.getInstance().getDatabase();
        StudentDao studentDao = db.studentDao();

        studentDao.insert(new Student(nameEditStory.getText().toString(), ageEditStory.getText().toString(), universityEditStory.getText().toString()));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
