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
import com.example.sustainafridge3.ui.home.HomeFragment
import com.example.sustainafridge3.ui.itemInfo.ItemInfoFragment
import java.util.Arrays
import java.util.Calendar


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fridgeFragment = HomeFragment()
        val cameraFragment = camera_fragment()
        val itemFragment = ItemInfoFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fridgeFragment)
            commit()
        }


    }
}
