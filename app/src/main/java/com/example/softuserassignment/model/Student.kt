package com.example.softuserassignment.model

import android.os.Parcel
import android.os.Parcelable

data class Student (
        val fname: String? = null,
        val age: String? = null,
        val gender: String? = null,
        val address: String? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fname)
        parcel.writeString(age)
        parcel.writeString(gender)
        parcel.writeString(address)
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
