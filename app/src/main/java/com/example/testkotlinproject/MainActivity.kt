package com.example.testkotlinproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var isLargeScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = findViewById<View>(R.id.fragment_blogpy_detail)
        isLargeScreen = view.visibility == View.VISIBLE

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.liveData.observe(this , Observer {model ->
            if (isLargeScreen){
                viewModel.postDetailInfo(model)
            }

        })
    }
}