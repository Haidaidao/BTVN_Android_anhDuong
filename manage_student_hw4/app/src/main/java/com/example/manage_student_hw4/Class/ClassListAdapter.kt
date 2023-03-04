package com.example.manage_student_hw4.Class

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.manage_student_hw4.R

class ClassListAdapter(
    private val context: Activity, private val nameClass: List<String>
    ) : ArrayAdapter<String>(context, R.layout.activity_class, nameClass) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView: View = inflater.inflate(R.layout.activity_class, null, true)
        val className = rowView.findViewById(R.id.tvClass) as TextView
        className.text = nameClass[position]
        return rowView
    }
}