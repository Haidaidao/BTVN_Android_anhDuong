package com.example.manage_student_hw4

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.example.manage_student_hw4.Class.chooseClass
import com.example.manage_student_hw4.Student.Student

class studentInformationCreate : AppCompatActivity() {

    var edtName:EditText?=null
    var edtBirthday:EditText?=null
    var edtClass:TextView?=null

    var radioGroup:RadioGroup?=null

    var btnSave:Button?=null
    var btnDelete:Button?=null

    var radio:String?=null

    var radioButtonMale:RadioButton?=null
    var radioButtonFemale:RadioButton?=null
    var radioButtonOther:RadioButton?=null

    val mode = Activity.MODE_PRIVATE
    var mySharedPreferences: SharedPreferences?=null

    var pos:Int?=null
    var check:Boolean?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_information_create)
        Log.i("test","onCreate")
        val actionBar = supportActionBar
        actionBar!!.hide()

        edtName=findViewById(R.id.edtName)
        edtBirthday=findViewById(R.id.edtBirthday)
        edtClass=findViewById(R.id.edtClass)

        radioGroup=findViewById(R.id.radioGroup)

        btnSave=findViewById(R.id.btnSave)
        btnDelete=findViewById(R.id.btnDelete)

        radioButtonMale=findViewById(R.id.radioButtonMale)
        radioButtonFemale=findViewById(R.id.radioButtonFemale)
        radioButtonOther=findViewById(R.id.radioButtonOther)

        check=intent.getStringExtra("CHECK").toString().equals("TRUE")

        mySharedPreferences = getSharedPreferences("MYPREFS", mode)

        pos= intent.getIntExtra("POS",-1)
        Log.i("test","--------pos: " + pos)
        if(pos==-1 && check!!) {
            pos=mySharedPreferences?.getInt("Pos", -1)
        }
        else if(pos==-1) {
            pos=mySharedPreferences?.getInt("Pos", -1)
        }


        Log.i("test","--pos: " + pos)
        Log.i("test","checked -----> " + check)
        if(check!!) {

            val studentReceive:Student? =intent.getParcelableExtra<Student>("STUDENT_SEND")
            btnDelete!!.setVisibility(View.VISIBLE)

            edtName!!.setText(studentReceive!!.getNameStudent())
            edtBirthday!!.setText(studentReceive!!.getBirthdayStudent())
            edtClass!!.setText(studentReceive!!.getClassStudent())

            var gender=studentReceive!!.getGenderStudent()
            if(gender.equals("Male")) radioButtonMale!!.setChecked(true)
            else if(gender.equals("Female")) radioButtonFemale!!.setChecked(true)
            else if(gender.equals("Other")) radioButtonOther!!.setChecked(true)
        }
        else {
            edtName!!.setText("")
            edtBirthday!!.setText("")
            edtClass!!.setText("")
            radioGroup!!.clearCheck()
        }

        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonMale -> {
                    radio="Male"
                }
                R.id.radioButtonFemale -> {
                    radio="Female"
                }
                R.id.radioButtonOther -> {
                    radio="Other"
                }
            }
        }

        btnDelete!!.setOnClickListener {

            Log.i("test",pos.toString())


            if(pos!=-1 ) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("POSITION", pos)
                startActivity(intent)
            }
        }

        btnSave!!.setOnClickListener {

            var student=Student(edtName!!.getText().toString(),edtClass!!.getText().toString(),edtBirthday!!.getText().toString(),radio!!)

            val intent = Intent(this, MainActivity::class.java)
            //pos= intent.getIntExtra("POS",-1)
            Log.i("test","class ->" + edtClass!!.getText().toString())
            Log.i("test","posCheck: " + pos)

            if(pos==-1) {
                if(checkInput(student.getNameStudent(),student.getBirthdayStudent(),radio!!)) {
                    intent.putExtra("STUDENT", student)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this,"Please input",Toast.LENGTH_SHORT).show()
                }
            }
            else {
                //pos= intent.getIntExtra("POS",-1)
                Log.i("test","class ->" + edtClass!!.getText().toString())
                if(pos!=-1) {
                    if(checkInput(student.getNameStudent(),student.getBirthdayStudent(),radio!!)) {
                        val intent = Intent(this, MainActivity::class.java)
                        intent.putExtra("POSITION_UPDATE", pos)
                        intent.putExtra("STUDENT", student)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this,"Please input",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            edtName!!.setText("")
            edtBirthday!!.setText("")
            radio=""

            radioGroup!!.clearCheck()
        }
    }

    override fun onResume() {
        super.onResume()
        mySharedPreferences = getSharedPreferences("MYPREFS", mode)

        Log.i("test","pos= " + pos.toString())
        if(pos!=-1) {
            btnDelete!!.setVisibility(View.VISIBLE)
            edtName!!.setText(mySharedPreferences?.getString("Name", " ")!!)
            edtBirthday!!.setText(mySharedPreferences?.getString("Birthday", " ")!!)
            edtClass!!.setText("19KTPM1")
        }

        else if(pos==-1) {

            edtName!!.setText(mySharedPreferences?.getString("Name", " ")!!)
            edtBirthday!!.setText(mySharedPreferences?.getString("Birthday", " ")!!)

        }

        var name = intent.getStringExtra("CLASSNAME")

        if(name!=null)
            edtClass!!.text=name

        radioGroup!!.clearCheck()

        if(check!!)
        {
            val studentReceive:Student? =intent.getParcelableExtra<Student>("STUDENT_SEND")
            btnDelete!!.setVisibility(View.VISIBLE)

            edtName!!.setText(studentReceive!!.getNameStudent())
            edtBirthday!!.setText(studentReceive!!.getBirthdayStudent())
            edtClass!!.setText(studentReceive!!.getClassStudent())

            var gender=studentReceive!!.getGenderStudent()
            if(gender.equals("Male")) radioButtonMale!!.setChecked(true)
            else if(gender.equals("Female")) radioButtonFemale!!.setChecked(true)
            else if(gender.equals("Other")) radioButtonOther!!.setChecked(true)

        }
    }

    override fun onStop() {
        super.onStop()
        mySharedPreferences = getSharedPreferences("MYPREFS", mode)
        val myEditor = mySharedPreferences!!.edit()

        myEditor.putString("Name", edtName!!.getText().toString())
        myEditor.putString("Birthday", edtBirthday!!.getText().toString())
        myEditor.putInt("Pos",pos!!)

        myEditor.commit()
    }

    fun navigationPage(view: View) {
        val intent = Intent(this, chooseClass::class.java)
        mySharedPreferences = getSharedPreferences("MYPREFS", mode)
        intent.putExtra("POS_CLASS", pos)
        Log.i("test","navi" + pos.toString())

        startActivity(intent)
    }

    fun checkInput(name:String, birthday:String, radio:String):Boolean {
        Log.i("test",name + "--" + birthday + "--" + radio)
        if(name.isEmpty() || birthday.isEmpty() || radio.isEmpty()) return false
        return true
    }
}