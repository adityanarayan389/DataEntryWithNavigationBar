package com.appstone.dataentrywithnavigationbar;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentdataHolder> {

    private Context context;
    private ArrayList<Student> students;
    public StudentAdapter(Context context, ArrayList<Student> students){
        this.context=context;
        this.students=students;
    }


    @NonNull
    @Override
    public StudentdataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cell_studentdataview,parent,false);
        StudentdataHolder holder = new StudentdataHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentdataHolder holder, int position) {
        Student currentStudent = students.get(position);
        holder.mTvRegNo.setText(String.valueOf(currentStudent.RegNo));
        holder.mTvStudentName.setText(currentStudent.StudentName);
        holder.mTvDepartment.setText(currentStudent.Department);

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentdataHolder extends RecyclerView.ViewHolder{
        private TextView mTvRegNo;
        private TextView mTvStudentName;
        private TextView mTvDepartment;

        public StudentdataHolder(@NonNull View itemView) {
            super(itemView);
            mTvRegNo=itemView.findViewById(R.id.tv_RegNo);
            mTvStudentName=itemView.findViewById(R.id.tv_StudentName);
            mTvDepartment=itemView.findViewById(R.id.tv_Department);
        }


    }
}
