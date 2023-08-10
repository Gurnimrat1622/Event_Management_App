package com.example.myapplicationcse225

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast

class MainActivityrating : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activityrating)

        var rb1=findViewById<RatingBar>(R.id.ratingBar3)
        var rb2=findViewById<RatingBar>(R.id.ratingBar4)
        var tv1=findViewById<EditText>(R.id.feedbacktext)
        var btn=findViewById<Button>(R.id.button2)


        btn.setOnClickListener {
            if(rb1.rating.isNaN() || rb2.rating.isNaN() || tv1.text.isEmpty()){
                Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "thank for your feedback ", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    val i = Intent(this, MainActivityEventDisplay::class.java)
                    startActivity(i)
                    finish()
                }, 3000)
            }
        }
    }
}