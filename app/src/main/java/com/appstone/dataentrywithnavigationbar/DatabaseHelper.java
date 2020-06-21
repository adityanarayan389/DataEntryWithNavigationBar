package com.appstone.dataentrywithnavigationbar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String TABLE_NAME = "students";
    private static String COL_REG_NO = "reg_no";
    private static String COL_STUDENT_NAME = "student_name";
    private static String COL_DEPARTMENT = "department";

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_REG_NO + " INTEGER PRIMARY KEY," + COL_STUDENT_NAME + " TEXT," + COL_DEPARTMENT + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    protected void insertDataToDataBase(Student student, SQLiteDatabase database) {
        ContentValues cv = new ContentValues();
        cv.put(COL_REG_NO, student.RegNo);
        cv.put(COL_STUDENT_NAME, student.StudentName);
        cv.put(COL_DEPARTMENT, student.Department);

        database.insert(TABLE_NAME, null, cv);
    }

    public ArrayList<Student> getDataFromDatabase(SQLiteDatabase database) {
        ArrayList<Student> studentList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                Student data = new Student();
                data.RegNo = cursor.getInt(cursor.getColumnIndex(COL_REG_NO));
                data.StudentName = cursor.getString(cursor.getColumnIndex(COL_STUDENT_NAME));
                data.Department = cursor.getString(cursor.getColumnIndex(COL_DEPARTMENT));

                studentList.add(data);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return studentList;
    }
}
