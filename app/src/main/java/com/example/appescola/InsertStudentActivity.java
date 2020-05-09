package com.example.appescola;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InsertStudentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);
    }

    public void insert(View v){

    }

    public void back(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
