package com.example.appescola;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InsertStudentActivity extends Activity {

    private EditText etName;
    private EditText etAge;
    private EditText etCourse;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etCourse = findViewById(R.id.etCourse);

        createDatabase();
    }

    private void createDatabase(){
        db = openOrCreateDatabase("appescola.db", Context.MODE_PRIVATE, null);
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS aluno (");
        sql.append("id INTEGER PRIMARY KEY AUTOINCREMENT,");
        sql.append("name VARCHAR(255),");
        sql.append("age INTEGER,");
        sql.append("course VARCHAR(255)");
        sql.append(")");
    }

    public void insert(View v){

    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
