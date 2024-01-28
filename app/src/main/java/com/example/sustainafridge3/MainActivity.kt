package com.example.sustainafridge3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.concurrent.TimeUnit


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var item1 = Item("Milk")
        var item2 = Item("Grapes")
        var item3 = Item("Yogurt")
        val items = mutableListOf(Item("Apple"), Item("Milk"), Item("Eggs"))
        var testFridge = Fridge(items)

        val fridgeMap = Expire()
        val calander = Calendar.getInstance()


        val mButton: Button = findViewById(R.id.button)
        val mEditText: EditText = findViewById(R.id.editText1)
        val mTextView: TextView = findViewById(R.id.textView)

        mButton.setOnClickListener {


            val userInput: String = mEditText.text.toString()
            val newItem = Item(userInput)

            if (fridgeMap.InList(userInput)) {

                val daysLeft = fridgeMap.DaysToExpire(userInput)

                newItem.daysRemaining = daysLeft

                val dayOfYear = calander.get(Calendar.DAY_OF_YEAR)

                if(daysLeft != -1){
                    val futureDate = dayOfYear + daysLeft
                    newItem.expireDate = futureDate

                    testFridge.addItem(newItem)

                } else {
                   //Possible Error/Timeout
                }



            }


            mTextView.setText(userInput)


        }
    }
}
