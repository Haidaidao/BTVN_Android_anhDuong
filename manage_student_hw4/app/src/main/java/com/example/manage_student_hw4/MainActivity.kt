package com.example.manage_student_hw4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.manage_student_hw4.Class.ClassListAdapter
import com.example.manage_student_hw4.Student.Student
import com.example.manage_student_hw4.Student.StudentListAdapter
import java.io.*

class MainActivity : AppCompatActivity() {

    val fileName = "input.txt"

    var student = arrayListOf<Student>()

    var selectedTV: TextView? = null
    var customListView: ListView? = null
    var btnAdd: Button? =null
    var adapter:StudentListAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val actionBar = supportActionBar
        actionBar!!.hide()

        customListView = findViewById(R.id.customListView)
        selectedTV = findViewById(R.id.tvStudents)
        btnAdd = findViewById(R.id.btnAdd)

        createData()


        adapter = StudentListAdapter(this, student)
        customListView!!.adapter = adapter
        customListView!!.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this, studentInformationCreate::class.java)
            Log.i("test",student[i].getNameStudent())
            intent.putExtra("CHECK", "TRUE")
            intent.putExtra("POS",i)
            intent.putExtra("STUDENT_SEND", student[i])
            startActivity(intent)

        }

        btnAdd!!.setOnClickListener {
            val intent = Intent(this, studentInformationCreate::class.java)
            intent.putExtra("CHECK", "FALSE")
            startActivity(intent)
        }
    }
    fun createData(){
            student.add( Student("Nguyen Van A","19KTPM1","14/02/2002","Male"))
            student.add( Student("Tran Van B","19KTPM2","15/02/2002","Female"))
            student.add( Student("Le Van C","19KTPM3","16/02/2002","Other"))
            student.add( Student("Nguyen Van A","19KTPM1","14/02/2002","Male"))
            student.add( Student("Le Van D","19KTPM3","17/02/2002","Other"))
    }


    override fun onResume() {
        super.onResume()

        Log.i("test","onResume")

        val posDelete=intent.getIntExtra("POSITION",-1)

        if(posDelete!=-1) {
            student.removeAt(posDelete)
            Log.i("test","posDelete-->" + posDelete.toString())
            adapter!!.notifyDataSetChanged()
        }

        val posUpdate=intent.getIntExtra("POSITION_UPDATE",-1)
        Log.i("test","posUpdate-->" + posUpdate.toString())
        if(posUpdate!=-1) {

            val studentItem = intent.getParcelableExtra<Student>("STUDENT")
            Log.i("test","-->" + studentItem!!.getClassStudent())
            if (studentItem != null) {
                student.set(posUpdate, intent.getParcelableExtra<Student>("STUDENT")!!)
                adapter!!.notifyDataSetChanged()
            }
        }
        else {

            val studentItem = intent.getParcelableExtra<Student>("STUDENT")
            if (studentItem != null) {
                student.add(intent.getParcelableExtra<Student>("STUDENT")!!)
                adapter!!.notifyDataSetChanged()
            }

        }
    }

    override fun onStart() {
        super.onStart()

//        try {
//            val inputStream: InputStream? = openFileInput(fileName)
//            if (inputStream != null) {
//                val inputStreamReader = InputStreamReader(inputStream)
//                val reader = BufferedReader(inputStreamReader)
//                val stringBuffer = StringBuffer()
//                var line : String? = reader.readLine()
//                while (line != null) {
//                    stringBuffer.append(line + "\n")
//                    line = reader.readLine()
//
//                    val subStrings=line.split("@")
//                    student.add(Student(subStrings[0],subStrings[1],subStrings[2],subStrings[3]))
//                }
//                inputStream.close()
//                //editText.setText(stringBuffer.toString())
//            }
//        } catch (e: FileNotFoundException) {
//        } catch (t: Throwable) {
//            Toast.makeText(this, "Exception: $t", Toast.LENGTH_SHORT).show()
//        }
    }

    override fun onPause() {
        super.onPause()

//        try {
////File will be in "/data/data/$packageName/files/"
//            val out = OutputStreamWriter(openFileOutput(fileName, 0))
//            for(item in student)
//            out.write(editText.getText().toString())
//            out.close()
//        } catch (t: Throwable) {
//            Toast.makeText(this, "Write file fail", Toast.LENGTH_SHORT).show()
//        }
    }
}