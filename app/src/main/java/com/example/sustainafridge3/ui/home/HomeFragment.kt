package com.example.sustainafridge3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.sustainafridge3.Expire
import com.example.sustainafridge3.Fridge
import com.example.sustainafridge3.Item
import com.example.sustainafridge3.R
import com.example.sustainafridge3.camera_fragment
import com.example.sustainafridge3.ui.itemInfo.ItemInfoFragment
import java.util.Calendar



class HomeFragment : Fragment() {


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
        val dataAdapter = ArrayAdapter(requireContext(), R.layout.list_item, dataArrayList)
        val dataView = view?.findViewById<ListView>(R.id.listView)
        dataView?.adapter = dataAdapter
        return dataView ?: View(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fridge, container, false)

        val items = mutableListOf<Item>()
        var testFridge = Fridge(items)

        showList(testFridge.nameList())

        val fridgeMap = Expire()
        val calander = Calendar.getInstance()


        val mButton: Button = view.findViewById(R.id.button)
        val mEditText: EditText = view.findViewById(R.id.editText1)
        val mTextView: TextView = view.findViewById(R.id.textView)


        val mListView: ListView = view.findViewById(R.id.listView)

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


        return inflater.inflate(R.layout.fragment_camera_fragment, container, false)
    }



}


