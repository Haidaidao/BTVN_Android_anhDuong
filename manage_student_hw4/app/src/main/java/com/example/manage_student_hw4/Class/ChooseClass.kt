package com.example.manage_student_hw4.Class

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.manage_student_hw4.R
import com.example.manage_student_hw4.studentInformationCreate

class chooseClass : AppCompatActivity() {

    var nameClass = arrayListOf<String>("19KTPM1", "19KTPM2", "19KTPM3")

    var selectedTV: TextView? = null
    var customListView: ListView? = null

    var btnSave: Button?=null

    var name:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)

        customListView = findViewById(R.id.customListView)
        selectedTV = findViewById(R.id.tvChooseClass)
        btnSave = findViewById(R.id.btnSave)

        val adapter = ClassListAdapter(this, nameClass)
        customListView!!.adapter = adapter
        customListView!!.setOnItemClickListener { adapterView, view, i, l ->
            name=nameClass[i]
        }
        val intent = Intent(this, studentInformationCreate::class.java)
      //  val s:Int=intent.getIntExtra("POS_CLASS",-1)
       // Log.i("test","sclass= " + s.toString())
        btnSave!!.setOnClickListener {

            intent.putExtra("CLASSNAME", name)
            intent.putExtra("CHECK", "FALSE")
           // intent.putExtra("POS",s)
             startActivity(intent)
        }
    }
}