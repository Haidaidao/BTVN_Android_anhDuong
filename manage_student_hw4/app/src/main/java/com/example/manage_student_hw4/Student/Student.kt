package com.example.manage_student_hw4.Student

import android.os.Parcel
import android.os.Parcelable

class Student(var name: String?, var className:String?, var birthday:String?, var gender:String?):
    Parcelable {

    constructor(parcel: Parcel) : this(
        name =parcel.readString(),
        className=parcel.readString(),
        birthday=parcel.readString(),
        gender=parcel.readString()
    ) {
    }

    fun setNameStudent(name:String) {
        this.name=name
    }
    fun setClassStudent(className:String) {
        this.className=className
    }
    fun setBirthdayStudent(birthday: String) {
        this.birthday=birthday
    }
    fun setGenderStudent(gender: String) {
        this.gender=gender
    }

    fun getNameStudent():String {
        return name!!
    }
    fun getClassStudent():String {
        return className!!
    }
    fun getBirthdayStudent():String {
        return birthday!!
    }
    fun getGenderStudent():String {
        return gender!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(className)
        parcel.writeString(birthday)
        parcel.writeString(gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}