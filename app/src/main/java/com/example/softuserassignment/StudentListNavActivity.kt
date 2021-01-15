package com.example.softuserassignment

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.softuserassignment.model.Student

class StudentListNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list_nav)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        loadList()

    }

    private fun loadList() {
        if (StudentList.size == 0) {
            StudentList.add(Student("Kiran Rana", "30", "Male", "Lalitpur"))
            StudentList.add(Student("Katrina Kaif", "35", "Female", "India"))
            StudentList.add(Student("Daya Rai", "30", "Male", "Kathmandu"))
        }

    }
    companion object {
        var StudentList = ArrayList<Student>()
    }
}