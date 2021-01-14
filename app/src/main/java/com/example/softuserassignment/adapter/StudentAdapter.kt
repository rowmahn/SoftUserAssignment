package com.example.softuserassignment.adapter

import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.softuserassignment.model.Student

class StudentAdapter(
        val lstStudent: ArrayList<Student>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view:View):
            RecyclerView.ViewHolder(view){

            }
}