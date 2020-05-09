package br.univali.appescola;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertStudentActivity extends AppCompatActivity {

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

    public void addStudent(View v){
        insert(etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), etCourse.getText().toString());
    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void clear(){
        etName.setText("");
        etAge.setText("");
        etCourse.setText("");
    }

    private boolean insert(String name, int age, String course){
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO aluno (name, age, course) VALUES (");
        sql.append("'" + name + "',");
        sql.append(age + ",");
        sql.append("'" + course + "'");
        sql.append(")");
        try {
            db.execSQL(sql.toString());
            clear();
            return true;
        } catch (SQLException ex){
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_LONG).show();
            return false;
        }
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
        try {
            db.execSQL(sql.toString());
        } catch (SQLException ex){
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
