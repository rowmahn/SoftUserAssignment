package com.example.softuserassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    lateinit var username: String
    lateinit var password: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        username = etUsername.text.toString()
        password = etPassword.text.toString()

        btnLogin.setOnClickListener {
            if (username=="softwarica" && password=="coventry")
            {
                val intent = Intent(this, HomeFragment::class.java)
                startActivity(intent)
            }
        }

    }
}