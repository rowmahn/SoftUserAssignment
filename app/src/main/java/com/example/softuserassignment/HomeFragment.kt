package com.example.softuserassignment

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.softuserassignment.adapter.StudentAdapter

class HomeFragment : AppCompatActivity() {

    private lateinit var rView: RecyclerView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_home, container, false)
        rView = view?.findViewById(R.id.rView) as RecyclerView
        val userAdapter = StudentAdapter(StudentListNavActivity.StudentList, this as Context)
        rView!!.adapter = userAdapter
        rView!!.layoutManager = LinearLayoutManager(this as Context?)
        return view
    }
}