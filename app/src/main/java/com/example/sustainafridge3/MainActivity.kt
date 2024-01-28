package com.example.sustainafridge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mButton: Button = findViewById(R.id.button)

        mButton.setOnClickListener {
            // Code to be executed when the button is clicked
            // ...
            // ...
            // ...
        }
    }
}