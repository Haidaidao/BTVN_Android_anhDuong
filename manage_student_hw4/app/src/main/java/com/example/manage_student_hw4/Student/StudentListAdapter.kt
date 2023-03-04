package com.example.manage_student_hw4.Student

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.manage_student_hw4.R

class StudentListAdapter(
    private val context: Activity, private val student: List<Student>
) : ArrayAdapter<Student>(context, R.layout.activity_class, student) {

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView: View = inflater.inflate(R.layout.activity_student, null, false)
        val name = rowView.findViewById(R.id.tvName) as TextView
        val className = rowView.findViewById(R.id.tvClass) as TextView
        val tvBG = rowView.findViewById(R.id.tvBirthdayGender) as TextView

        name.text=student[position].getNameStudent()
        className.text=student[position].getClassStudent()
        tvBG.text=student[position].getBirthdayStudent()+" - "+student[position].getGenderStudent()
        return rowView
    }
}