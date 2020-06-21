package com.appstone.dataentrywithnavigationbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendData extends AppCompatActivity {
    private EditText sRegNo;
    private EditText sStudentname;
    private EditText sDepartment;
    private Button sbtnEnterData;

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        sRegNo = findViewById(R.id.et_regNo);
        sStudentname = findViewById(R.id.et_StudentName);
        sDepartment = findViewById(R.id.et_department);

        sbtnEnterData = findViewById(R.id.btn_EnterData);

        dbHelper = new DatabaseHelper(this);
        sbtnEnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regno = sRegNo.getText().toString();
                String studentname = sStudentname.getText().toString();
                String department = sDepartment.getText().toString();

                int regNo = 0;
                if (!regno.isEmpty()) {
                    regNo = Integer.parseInt(regno);
                }

                Student studentDetails = new Student();
                studentDetails.RegNo = regNo;
                studentDetails.StudentName = studentname;
                studentDetails.Department = department;

                dbHelper.insertDataToDataBase(studentDetails, dbHelper.getWritableDatabase());

                sRegNo.setText("");
                sStudentname.setText("");
                sDepartment.setText("");
            }
        });


    }
}
