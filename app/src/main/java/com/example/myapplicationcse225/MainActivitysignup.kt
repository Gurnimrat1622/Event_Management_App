package com.example.myapplicationcse225

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivitysignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activitysignup)
        var submit_btn=findViewById<Button>(R.id.submitbtn)
        var name=findViewById<EditText>(R.id.nametv)
        var email=findViewById<EditText>(R.id.emailtv)
        var pwd=findViewById<EditText>(R.id.passwordtv)
        var cpwd=findViewById<EditText>(R.id.conformpwdtv)

        submit_btn.setOnClickListener {

            if (name.text.toString().isEmpty() ||
                email.text.toString().isEmpty() ||
                pwd.text.toString().isEmpty() ||
                cpwd.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Handle form submission
                val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("Name", name.text.toString().trim())
                editor.putString("Email", email.text.toString().trim())
                editor.putString("Password", pwd.text.toString().trim())
                editor.apply()
                submit_btn.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

        }



    }
}