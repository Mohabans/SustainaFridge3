package com.example.sustainafridge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var item1 = Item("Milk")
        var item2 = Item("Grapes")
        var item3 = Item("Yogurt")
        val items = mutableListOf(Item("Apple"), Item("Milk"), Item("Eggs"))
        var testFridge = Fridge(items)

        val mButton: Button = findViewById(R.id.button)
        val mEditText: EditText = findViewById(R.id.editText1)
        val mTextView: TextView = findViewById(R.id.textView)

        mButton.setOnClickListener {

            val userInput: String = mEditText.text.toString()
            mTextView.setText(userInput)

        }
    }
}