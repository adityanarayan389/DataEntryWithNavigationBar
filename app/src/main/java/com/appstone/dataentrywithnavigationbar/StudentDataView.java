package com.appstone.dataentrywithnavigationbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class StudentDataView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data_view);

        RecyclerView mRcStudentdata=findViewById(R.id.rcv_StudentDataView);
        mRcStudentdata.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        ArrayList<Student> students = dbHelper.getDataFromDatabase(dbHelper.getReadableDatabase());
        StudentAdapter adapter = new StudentAdapter(this,students);
        mRcStudentdata.setAdapter(adapter);


    }
}
