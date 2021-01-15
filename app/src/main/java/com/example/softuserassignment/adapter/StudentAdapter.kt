package com.example.softuserassignment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.softuserassignment.R
import com.example.softuserassignment.model.Student
import java.nio.file.Files.size

class StudentAdapter(
        val lstStudent: ArrayList<Student>,
        val context: Context
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view:View):
            RecyclerView.ViewHolder(view){
        val imgProfile: ImageView
        val tvFname: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val tvGender: TextView
        val imgDelete: ImageButton
        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvFname = view.findViewById(R.id.tvName)
            tvAge = view.findViewById(R.id.tvAge)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvGender = view.findViewById(R.id.tvGender)
            imgDelete = view.findViewById(R.id.imgDelete)
        }

            }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.studentlayout, parent, false)
        return  StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvFname.text = student.fname
        holder.tvAge.text = student.age.toString()
        holder.tvAddress.text = student.address
        holder.tvGender.text = student.gender
        if(student.gender == "Male"){
            holder.imgProfile.setImageResource(R.drawable.male)
        }
        else if(student.gender == "Female"){
            holder.imgProfile.setImageResource(R.drawable.female)
        }
        holder.imgProfile.setOnClickListener {
            val context = context
            val stringBuilder = StringBuilder()
            stringBuilder.append("Hello My name is: ")
            stringBuilder.append(student.fname)
            Toast.makeText(context, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
        }
        holder.imgDelete.setOnClickListener {
            lstStudent.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }

}