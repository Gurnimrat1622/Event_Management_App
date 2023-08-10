package com.example.myapplicationcse225

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var singn_btn=findViewById<Button>(R.id.signup)
        val loginButton = findViewById<Button>(R.id.login)
        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.pwd)
//        var tt=findViewById<TextView>(R.id.text3)
        singn_btn.setOnClickListener {
            val intent = Intent(this, MainActivitysignup::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val storedName=sharedPreferences.getString("Name","")
            val storedEmail = sharedPreferences.getString("Email", "")
            val storedPassword = sharedPreferences.getString("Password", "")

            val enteredData = emailEditText.text.toString().trim()
            val enteredPassword = passwordEditText.text.toString().trim()

            if ((enteredData == storedEmail || enteredData == storedName) && enteredPassword == storedPassword) {
                // Credentials are correct
                val intent = Intent(this, MainActivityEventDisplay::class.java)
                startActivity(intent)
            } else {
                // Credentials are incorrect
                Toast.makeText(this, "Enter The correct Credentials", Toast.LENGTH_SHORT).show()
            }
        }




    }
}