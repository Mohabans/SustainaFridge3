package com.example.sustainafridge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import java.util.Arrays
import java.util.Calendar


class MainActivity : AppCompatActivity() {

    fun checkExpirationDates(itemList: MutableList<Item>){

        val calender = Calendar.getInstance()

        for(element in itemList){

            element.daysRemaining = element.expireDate - calender.get(Calendar.DAY_OF_YEAR)

            if (element.daysRemaining <= 0){

                //Notify User of expiration


            }

        }

    }

    private fun showList(itemNameList : MutableList<String>): View {
        val dataArrayList = ArrayList(itemNameList)
        val dataAdapter = ArrayAdapter(this, R.layout.list_item, dataArrayList)
        val dataView = findViewById<ListView>(R.id.listView)
        dataView.adapter = dataAdapter
        return dataView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = mutableListOf<Item>()
        var testFridge = Fridge(items)

        showList(testFridge.nameList())

        val fridgeMap = Expire()
        val calander = Calendar.getInstance()


        val mButton: Button = findViewById(R.id.button)
        val mEditText: EditText = findViewById(R.id.editText1)
        val mTextView: TextView = findViewById(R.id.textView)


        val mListView: ListView = findViewById(R.id.listView)

        mButton.setOnClickListener {


            val userInput: String = mEditText.text.toString()

            mEditText.setText("")

            val newItem = Item(userInput)

            if (fridgeMap.InList(userInput)) {

                val daysLeft = fridgeMap.DaysToExpire(userInput)

                newItem.daysRemaining = daysLeft

                val dayOfYear = calander.get(Calendar.DAY_OF_YEAR)

                if(daysLeft != -1){
                    val futureDate = dayOfYear + daysLeft
                    newItem.expireDate = futureDate

                    testFridge.addItem(newItem)
                    showList(testFridge.nameList())

                } else {
                   //Possible Error/Timeout
                }



            }


            //mTextView.setText(userInput)


        }
    }
}
